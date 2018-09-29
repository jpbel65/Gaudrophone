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
public interface ConteneurInstrumentsObserveur {
    
    public void notificationInstrumentCree(ConteneurInstrumentsObservable osb, Object arg);
    public void notificationInstrumentSupprime(ConteneurInstrumentsObservable osb, Object arg);
    public void notificationInstrumentActifChange(ConteneurInstrumentsObservable osb, Object arg);
    public void notificationInstrumentActifModifie(ConteneurInstrumentsObservable osb, Object arg, int i);
}
