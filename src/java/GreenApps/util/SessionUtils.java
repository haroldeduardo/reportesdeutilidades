
package GreenApps.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class SessionUtils {
    
    private SessionUtils(){
    
    }
    
    private static SessionUtils instance = new SessionUtils();
    
    public static SessionUtils getInstance(){
        return  instance;
    }
    
    public String getAtribute(FacesContext fc, String atribute){
        HttpSession ses = (HttpSession) fc.getExternalContext().getSession(true);
        return ses.getAttribute(atribute).toString();
    }
    
    public void setAtribute(FacesContext fc, String atribute, String value){
        HttpSession ses = (HttpSession) fc.getExternalContext().getSession(true);
        ses.setAttribute(atribute, value);
    }
    
}