package co.edu.javeriana.middlewaresn.control;

import co.edu.javeriana.middlewaresn.entities.ServiceNodeAttribute;
import co.edu.javeriana.middlewaresn.control.util.JsfUtil;
import co.edu.javeriana.middlewaresn.control.util.JsfUtil.PersistAction;
import co.edu.javeriana.middlewaresn.ejb.ServiceNodeAttributeFacade;

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

@Named("serviceNodeAttributeController")
@SessionScoped
public class ServiceNodeAttributeController implements Serializable {

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceNodeAttributeFacade ejbFacade;
    private List<ServiceNodeAttribute> items = null;
    private ServiceNodeAttribute selected;

    public ServiceNodeAttributeController() {
    }

    public ServiceNodeAttribute getSelected() {
        return selected;
    }

    public void setSelected(ServiceNodeAttribute selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ServiceNodeAttributeFacade getFacade() {
        return ejbFacade;
    }

    public ServiceNodeAttribute prepareCreate() {
        selected = new ServiceNodeAttribute();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ServiceNodeAttributeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServiceNodeAttributeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ServiceNodeAttributeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ServiceNodeAttribute> getItems() {
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

    public ServiceNodeAttribute getServiceNodeAttribute(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ServiceNodeAttribute> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ServiceNodeAttribute> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ServiceNodeAttribute.class)
    public static class ServiceNodeAttributeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServiceNodeAttributeController controller = (ServiceNodeAttributeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "serviceNodeAttributeController");
            return controller.getServiceNodeAttribute(getKey(value));
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
            if (object instanceof ServiceNodeAttribute) {
                ServiceNodeAttribute o = (ServiceNodeAttribute) object;
                return getStringKey(o.getIdServiceNodeAttribute());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ServiceNodeAttribute.class.getName()});
                return null;
            }
        }

    }

}
