package co.edu.javeriana.middlewaresn.control;

import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import co.edu.javeriana.middlewaresn.control.util.JsfUtil;
import co.edu.javeriana.middlewaresn.control.util.JsfUtil.PersistAction;
import co.edu.javeriana.middlewaresn.ejb.ServiceNodeFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("serviceNodeController")
@SessionScoped
public class ServiceNodeController implements Serializable {

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceNodeFacade ejbFacade;
    private List<ServiceNode> items = null;
    private ServiceNode selected;

    public ServiceNodeController() {
    }

    public ServiceNode getSelected() {
        return selected;
    }

    public void setSelected(ServiceNode selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ServiceNodeFacade getFacade() {
        return ejbFacade;
    }

    public ServiceNode prepareCreate() {
        selected = new ServiceNode();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ServiceNodeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServiceNodeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ServiceNodeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ServiceNode> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ServiceNode getServiceNode(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ServiceNode> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ServiceNode> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ServiceNode.class)
    public static class ServiceNodeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServiceNodeController controller = (ServiceNodeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "serviceNodeController");
            return controller.getServiceNode(getKey(value));
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
            if (object instanceof ServiceNode) {
                ServiceNode o = (ServiceNode) object;
                return getStringKey(o.getIdServiceNode());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ServiceNode.class.getName()});
                return null;
            }
        }

    }

}
