/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.javeriana.middlewaresn.control;


import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis Eduardo
 * @author Andres Sanchez
 */
@Named ("languageSwitcher")
@SessionScoped
public class LenguajeSwitcher implements Serializable {
    
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    /**
     * Creates a new instance of LenguajeSwitcher
     */
    public LenguajeSwitcher() {
        HttpSession hs = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        hs.setAttribute("idioma", locale);
        
    }

    public Locale getLocale() {
        HttpSession hs = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        locale = (Locale) hs.getAttribute("idioma");
        return locale;
    }

    public void setLocale(Locale locale) {       
        this.locale = locale;
    }
    
    public void changeLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
        
    public String getPathImage() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return externalContext.getRequestContextPath() + "/faces/resources/img/middleware_banner.jpg";
    }
}
