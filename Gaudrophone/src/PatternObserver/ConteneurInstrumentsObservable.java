/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternObserver;

import java.util.List;
import java.util.LinkedList;


/**
 *
 * @author Simon
 */
public class ConteneurInstrumentsObservable {
    
    private List<ConteneurInstrumentsObserveur> m_observateurs = new LinkedList<>();;
    
    public ConteneurInstrumentsObservable(){
    }
    
    public void ajouterObservateur(ConteneurInstrumentsObserveur p_observateur){
        m_observateurs.add(p_observateur);
    }
    
    public void supprimerObservateur(ConteneurInstrumentsObserveur p_observateur){
        m_observateurs.remove(p_observateur);
    }

    public void notifierObservateursInstrumentCree(Object obj){
        m_observateurs.forEach((observateur) -> {
            observateur.notificationInstrumentCree(this, obj);
        });
    }
    public void notifierObservateursInstrumentSupprime(Object obj){
        m_observateurs.forEach((observateur) -> {
            observateur.notificationInstrumentSupprime(this, obj);
        });
    }
    public void notifierObservateursInstrumentActifChange(Object obj){
        m_observateurs.forEach((observateur) -> {
            observateur.notificationInstrumentActifChange(this, obj);
        });
    }           
    public void notifierObservateursInstrumentActifModifie(Object obj, int i){
        m_observateurs.forEach((observateur) -> {
            observateur.notificationInstrumentActifModifie(this, obj, i);
        });
    }
}
