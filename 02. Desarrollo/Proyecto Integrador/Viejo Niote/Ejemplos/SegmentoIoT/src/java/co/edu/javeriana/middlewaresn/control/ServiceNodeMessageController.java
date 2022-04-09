package co.edu.javeriana.middlewaresn.control;

import co.edu.javeriana.middlewaresn.entities.ServiceNodeValue;
import co.edu.javeriana.middlewaresn.control.util.JsfUtil;
import co.edu.javeriana.middlewaresn.ejb.NotificationManagerFacade;
import co.edu.javeriana.middlewaresn.entities.Service;
import co.edu.javeriana.middlewaresn.entities.ServiceNode;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("serviceNodeMessageController")
@SessionScoped
public class ServiceNodeMessageController implements Serializable {

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.NotificationManagerFacade ejbFacade;
    private List<ServiceNodeValue> items = null;
    private ServiceNodeValue selected;

    public ServiceNodeMessageController() {
        selected = new ServiceNodeValue();
        selected.setIdServiceNodeValue(Integer.MIN_VALUE);
    }

    public ServiceNodeValue getSelected() {
        return selected;
    }

    public void setSelected(ServiceNodeValue selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private NotificationManagerFacade getFacade() {
        return ejbFacade;
    }

    public void send() {
        
        //initializeEmbeddableKey();
        Service s = selected.getServiceNode().getService();
        ServiceNode sn = selected.getServiceNode();
        
        getFacade().SendMessage(s, sn, selected.getValue());
        
        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SendMessage"));
        
    }
    
    
    public List<ServiceNodeValue> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public ServiceNodeValue getServiceNodeValue(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ServiceNodeValue> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ServiceNodeValue> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ServiceNodeValue.class)
    public static class ServiceNodeValueControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServiceNodeMessageController controller = (ServiceNodeMessageController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "serviceNodeValueController");
            return controller.getServiceNodeValue(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ServiceNodeValue) {
                ServiceNodeValue o = (ServiceNodeValue) object;
                return getStringKey(o.getIdServiceNodeValue());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ServiceNodeValue.class.getName()});
                return null;
            }
        }

    }

}
