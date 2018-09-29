/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Instrument;

import java.util.Map;


/**
 *
 * @author Simon
 * @author Luca
 */
public abstract class Instrument implements java.io.Serializable{
 
//<editor-fold defaultstate="collapsed" desc="Attributs">
    private String m_nom;
    private int    m_timbre;
    private final ConteneurTouches m_conteneurTouches;
    private String m_fichierAudio;
    
//</editor-fold>   

    
    public Instrument(){
        m_conteneurTouches = new ConteneurTouches();
    }
 
    public void creerTouche(){
        m_conteneurTouches.creerToucheVierge();
    }
    
    public void ajouterTouche(Touche p_touche){
        m_conteneurTouches.ajouterTouche(p_touche);
    }
    
    public ConteneurTouches getConteneurTouches(){
        return m_conteneurTouches;
    }
    
    public void peindreInstrument(javax.swing.JPanel p_jPanel, java.awt.Graphics p_graphics){
        peindreTouches(p_jPanel, p_graphics);
        peindreBackgroundInstrument(p_jPanel, p_graphics);
        
    }
    
    public abstract void peindreBackgroundInstrument(javax.swing.JPanel p_jPanel, java.awt.Graphics p_graphics);
    
    public void peindreTouches(javax.swing.JPanel p_jPanel, java.awt.Graphics p_graphics){
        
        
    //TODO:Peindre le background de l'instrument    
    
        m_conteneurTouches.m_listeTouches.forEach((v_nom, v_touche) -> {
            
            v_touche.peindre(p_jPanel, p_graphics);
            
        });
     
      
    }
    
    public void jouerMusique(){
        
    }
    
    public void pauseMusique(){
        
    }
    
    public void avancerMusique(){
        
    }
    
    public void reculerMusique(){
        
    }
    
    public void afficherMusique(){
        
    }
    

    
//<editor-fold defaultstate="collapsed" desc="Accesseur / Mutateurs">
    public String getNom(){
        return m_nom;
    }
    public int getTimbre(){
        return m_timbre;
    }
    public String getFichierAudio(){
        return m_fichierAudio;
    }
    public void setNom(String p_nouveauNom){
        m_nom = p_nouveauNom;
    }
    public void setTimbre(int pTimbre){
        m_timbre = pTimbre;
    }
    public void setfichierAudio(String pFichierAudio){
        m_fichierAudio = pFichierAudio;
    }
    
//</editor-fold>    

    
}
