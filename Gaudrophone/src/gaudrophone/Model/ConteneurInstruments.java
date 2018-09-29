/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model;

import gaudrophone.Model.Instrument.Instrument;
import PatternObserver.ConteneurInstrumentsObservable;
import java.awt.Graphics;
import java.util.TreeMap;
import java.util.Set;
import java.util.LinkedList;
import javax.swing.JPanel;



/**
 *
 * @author Simon
 */
public class ConteneurInstruments extends ConteneurInstrumentsObservable implements java.io.Serializable {
    
    public SauvegarderChargerInstruments m_importExportInstrument = new SauvegarderChargerInstruments(this);
    protected TreeMap<String,Instrument> m_listeInstruments = new TreeMap<>();
    
    private Instrument m_instrumentActif = null;
    
    
    public ConteneurInstruments(){
        //m_importExportInstrument.importerInstruments("test.xml");
    }
    
    public void creerInstrumentVierge(){
        int i = 1;
        boolean repeter = true;
        String v_nomNouvelInstrument = "NouvelInstrument";
        
        while(repeter == true){
            
            //Si contient deja un instrument ayant le non "NouvelInstrument1", "NouvelInstrument2" ... etc
            if (m_listeInstruments.containsKey(v_nomNouvelInstrument + Integer.toString(i)))
            {
                i++;
            }
            else
            {
               //Enfin un nom libre 
                Instrument v_nouvelInstrument = new Instrument(){
                    @Override
                    public void peindreBackgroundInstrument(JPanel p_jPanel, Graphics p_graphics) {
                        System.out.println("pas de background");
                    }
                    
                };
                v_nouvelInstrument.setNom(v_nomNouvelInstrument + Integer.toString(i));
                v_nouvelInstrument.setTimbre(0);
                m_listeInstruments.put(v_nouvelInstrument.getNom(), v_nouvelInstrument);
                repeter = false;
            }
        }
        
        Set<String> e = m_listeInstruments.keySet();
        
        notifierObservateursInstrumentCree(e);  
    }
    
    public void ajouterInstrument(Instrument p_nouvelInstrument){
        int i = 1;
        while(true){
            if(m_listeInstruments.containsKey(p_nouvelInstrument.getNom())){
                i++;
            }
            else{
                p_nouvelInstrument.setNom(p_nouvelInstrument.getNom() + Integer.toString(i));
                m_listeInstruments.put(p_nouvelInstrument.getNom(), p_nouvelInstrument);
                break;
            }
        }
        
        
        Set<String> e = m_listeInstruments.keySet();
        
        notifierObservateursInstrumentCree(e);
    }

    public void supprimerInstrument(String p_nomInstrument){
        
        if(!m_listeInstruments.containsKey(p_nomInstrument))
        {
            System.out.println("Erreur! L'instrument à supprimer n'est pas dans la liste");
            return;
        }
        
        m_listeInstruments.remove(p_nomInstrument);
        
        Set<String> e = m_listeInstruments.keySet();
        
        notifierObservateursInstrumentSupprime(e);
        
    }

    public void enregistrerModifications(){
        
    }
    
    public void changerInstrumentActif(String p_nomInstrument){
        
        m_instrumentActif = (p_nomInstrument == null ? null : m_listeInstruments.get(p_nomInstrument));
        
        notifierObservateursInstrumentActifChange(m_instrumentActif);
    }
    
    public void traiterInformationInstrumentChangees(){
        
        Set<String> set = m_listeInstruments.keySet();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(set);
        
        
        
        int i = 0;
        for(String str : linkedList){
            
            if(m_instrumentActif.getNom().equals(str)){
                linkedList.set(i, str + "***");
                break;
            }
            else{
                i++;   
            }
             
        }
        
        notifierObservateursInstrumentActifModifie(linkedList,i);
        
    }
    
    
    public Instrument getInstrumentActif(){
        return m_instrumentActif;
    }
    
    public boolean setNomInstrumentActif(String p_ancienNom, String p_nouveauNom){
        if(!m_listeInstruments.containsKey(p_nouveauNom)){
            m_instrumentActif.setNom(p_nouveauNom);
            m_listeInstruments.put(p_nouveauNom, m_instrumentActif);
            m_listeInstruments.remove(p_ancienNom);
            return true;
        }
        else{
            m_instrumentActif.setNom(p_ancienNom);
            return false;
        }
    }
    
    public Set<String> getListeNomInstruments(){
        return m_listeInstruments.keySet();
    }
    
    public TreeMap<String,Instrument> getListeInstruments(){
        return m_listeInstruments;
    }

    
}
