package co.edu.javeriana.middlewaresn.control;

import co.edu.javeriana.middlewaresn.entities.ServiceType;
import co.edu.javeriana.middlewaresn.control.util.JsfUtil;
import co.edu.javeriana.middlewaresn.control.util.JsfUtil.PersistAction;
import co.edu.javeriana.middlewaresn.ejb.ServiceTypeFacade;

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

@Named("serviceTypeController")
@SessionScoped
public class ServiceTypeController implements Serializable {

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceTypeFacade ejbFacade;
    private List<ServiceType> items = null;
    private ServiceType selected;

    public ServiceTypeController() {
    }

    public ServiceType getSelected() {
        return selected;
    }

    public void setSelected(ServiceType selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ServiceTypeFacade getFacade() {
        return ejbFacade;
    }

    public ServiceType prepareCreate() {
        selected = new ServiceType();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ServiceTypeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServiceTypeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ServiceTypeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ServiceType> getItems() {
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

    public ServiceType getServiceType(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ServiceType> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ServiceType> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ServiceType.class)
    public static class ServiceTypeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServiceTypeController controller = (ServiceTypeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "serviceTypeController");
            return controller.getServiceType(getKey(value));
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
            if (object instanceof ServiceType) {
                ServiceType o = (ServiceType) object;
                return getStringKey(o.getSeviceTypeId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ServiceType.class.getName()});
                return null;
            }
        }

    }

}
