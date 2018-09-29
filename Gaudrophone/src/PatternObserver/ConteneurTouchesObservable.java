/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternObserver;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class ConteneurTouchesObservable {
     
    private List<ConteneurTouchesObserveur> m_observateurs = new LinkedList<>();
    
    public ConteneurTouchesObservable(){
    }
    
    public void ajouterObservateur(ConteneurTouchesObserveur p_observateur){
        m_observateurs.add(p_observateur);
    }
    
    public void supprimerObservateur(ConteneurTouchesObserveur p_observateur){
        m_observateurs.remove(p_observateur);
    }

    public void notifierObservateursToucheCree(Object p_argument){
        m_observateurs.forEach((observateur) -> {
            observateur.notificationToucheCree(this, p_argument);
        });
    }
    
    public void notifierObservateursToucheSupprimee(Object p_argument){
        m_observateurs.forEach((observateur) -> {
            observateur.notificationToucheSupprimee(this, p_argument);
        });
    }

    public void notifierObservateursToucheActiveChangee(Object p_argument){
        m_observateurs.forEach((observateur) -> {
            observateur.notificationToucheActiveChangee(this, p_argument);
        });
    }
    

}
