/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternObserver;

/**
 *
 * @author Simon
 */
public interface ConteneurTouchesObserveur {
    
    public void notificationToucheCree(ConteneurTouchesObservable p_observable, Object p_argument);
    public void notificationToucheSupprimee(ConteneurTouchesObservable p_observable, Object p_argument);
    public void notificationToucheActiveChangee(ConteneurTouchesObservable p_observable, Object p_argument);
    
            
            
    
    
}
