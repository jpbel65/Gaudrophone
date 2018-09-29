/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Instrument;


import PatternObserver.ConteneurTouchesObservable;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

import java.awt.Color;

/**
 *
 * @author Simon
 */
public class ConteneurTouches extends ConteneurTouchesObservable implements java.io.Serializable{
    
//<editor-fold defaultstate="collapsed" desc="Variables membres">
    public TreeMap<String, Touche> m_listeTouches; /////TEST TEST TES TEST remettre private asap
    private Touche m_toucheActive;
    private TreeMap<String, Color> m_listeRecherche;
//</editor-fold>
    
    public ConteneurTouches() {
        this.m_listeTouches = new TreeMap<>();
        this.m_toucheActive = null;
        this.m_listeRecherche = new TreeMap<>();
    }
    
    public Set<String> getListeNomTouches(){
        return m_listeTouches.keySet();
    }
    
    public void creerToucheVierge(){
        
        int i = 1;
        
        String nomNouvelleTouche = "Nouvelle_touche";
        
        while(true){
            
            //Si contient deja un instrument ayant le non "NouvelInstrument1", "NouvelInstrument2" ... etc
            if (m_listeTouches.containsKey(nomNouvelleTouche + Integer.toString(i)))
            {
                i++;
            }
            else
            {
               //Enfin un nom libre 
                Touche v_nouvelleTouche = new Touche();
                v_nouvelleTouche.setNom(nomNouvelleTouche + Integer.toString(i));
                
                m_listeTouches.put(v_nouvelleTouche.getNom(), v_nouvelleTouche);
                break;
            }
        }
        
        Set<String> e = m_listeTouches.keySet();
        
        notifierObservateursToucheCree(e);  
    }
    
    public void ajouterTouche(Touche p_touche){
        m_listeTouches.put(p_touche.getNom(), p_touche);
    }
    
    public void changerToucheActive(String p_nouvelleToucheSelectionnee){
        
        m_toucheActive = (p_nouvelleToucheSelectionnee == null ? null : m_listeTouches.get(p_nouvelleToucheSelectionnee));
        
        notifierObservateursToucheActiveChangee(m_toucheActive);
    }

    public void supprimerToucheActive(){
        m_listeTouches.remove(m_toucheActive.getNom());
        m_toucheActive = null;
        
        Set<String> e = m_listeTouches.keySet();
        notifierObservateursToucheSupprimee(e); 
    }
    
    public Color getCouleurToucheActive(){
        return m_toucheActive.getCouleur();
    }
    
    public void setCouleurToucheActive(Color p_nouvelleCouleur){
        m_toucheActive.setCouleur(p_nouvelleCouleur);
        m_toucheActive.setImageDeFond("");
    }
    
    public Color getCouleurBordureToucheActive(){
        return m_toucheActive.getCouleurBordure();
    }
    
    public void setCouleurBordureToucheActive(Color p_nouvelleCouleur){
        m_toucheActive.setCouleurBordure(p_nouvelleCouleur);
    }
    
    public int getBordureToucheActive(){
        return m_toucheActive.getBordure();
    }
    
    public void setBordureToucheActive(int p_bordure){
        m_toucheActive.setBordure(p_bordure);
    }
    
    public String getNomToucheActive(){
        return m_toucheActive.getNom();
    }
    
    public boolean setNomToucheActive(String p_ancienNom, String p_nouveauNom){
        //Permet d'updater la jList dans le UI
        if(!m_listeTouches.containsKey(p_nouveauNom)){
            m_toucheActive.setNom(p_nouveauNom);
            m_listeTouches.put(p_nouveauNom, m_toucheActive);
            m_listeTouches.remove(p_ancienNom);
            return true;
        }
        else{
            m_toucheActive.setNom(p_ancienNom);
            return false;
        }
    }
    
    public void setOctaveToucheActive(int p_nouvelleOctave){
        m_toucheActive.setOctave(p_nouvelleOctave);
    }
    
    public int getOctaveToucheActive(){
        return m_toucheActive.getOctave();
    }
    
    public void setNoteToucheActive(int p_nouvelleNote){
        m_toucheActive.setNote(p_nouvelleNote);
    }
    
    public int getNoteToucheActive(){
        return m_toucheActive.getNote();
    }
    
    public Touche getToucheActive(){
        return m_toucheActive;
    }
    
    public void setFichierAudioToucheActive(String p_fichierAudio){
        m_toucheActive.setFichierAudio(p_fichierAudio);
    }
    
    public TreeMap<String,Touche> getSetTouche(){
        return m_listeTouches;
    }
    
    public void rechercheTouche(String[] p_recherche, String p_typeRecherche){
        if("Nom".equals(p_typeRecherche)){
            for (String v_stringRecherche : p_recherche) {
                if (m_listeTouches.containsKey(v_stringRecherche)) {
                    Touche v_touche = m_listeTouches.get(v_stringRecherche);
                    Color v_ancienneCouleur = v_touche.getCouleur();
                    m_listeRecherche.put(v_touche.getNom(), v_ancienneCouleur);
                    v_touche.setCouleur(new Color(v_ancienneCouleur.getRed()/255, v_ancienneCouleur.getGreen()/255, v_ancienneCouleur.getBlue()/255, 0.5f));
                }
            }
        }
        else if("Note".equals(p_typeRecherche)){
            for (String v_stringRecherche : p_recherche) {
                for(Map.Entry<String,Touche> entry : m_listeTouches.entrySet()) {
                    Touche v_touche = entry.getValue();
                    String v_compareRecherche = noteIntToString(v_touche.getNote()) + String.valueOf(v_touche.getOctave());
                    if(v_compareRecherche.contains(v_stringRecherche)){
                        Color v_ancienneCouleur = v_touche.getCouleur();
                        m_listeRecherche.put(v_touche.getNom(), v_ancienneCouleur);
                        v_touche.setCouleur(new Color(v_ancienneCouleur.getRed()/255, v_ancienneCouleur.getGreen()/255, v_ancienneCouleur.getBlue()/255, 0.5f));
                    }
                }
            }
        }
    }
    
    public Touche retournerTouche(String p_string){
        for(Map.Entry<String,Touche> entry : m_listeTouches.entrySet()) {
            Touche v_touche = entry.getValue();
            String v_compare = noteIntToString(v_touche.getNote()) + String.valueOf(v_touche.getOctave());
            if(v_compare.equalsIgnoreCase(p_string)){
                return v_touche;
            }
        }
        return null;
    }
    
    public void annulerRechercheTouche(){
        for (Map.Entry<String, Color> entry : m_listeRecherche.entrySet()) {
            Touche v_touche;
            v_touche = m_listeTouches.get(entry.getKey());
            v_touche.setCouleur(entry.getValue());
        }
        m_listeRecherche.clear();
    }
    
    //Thanks to https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    public static boolean estNumerique(String p_string){
        try {
            int integer = Integer.parseInt(p_string);
        } 
        catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
    
    public int noteStringToInt(String p_note){
        switch(p_note){
            case "C"  : return 0;
            
            case "C#" : return 1;
            
            case "D"  : return 2;
            
            case "D#" : return 3;
            
            case "E"  : return 4;
            
            case "F"  : return 5;
            
            case "F#" : return 6;
            
            case "G"  : return 7;
            
            case "G#" : return 8;
            
            case "A"  : return 9;
            
            case "A#" : return 10;
            
            case "B"  : return 11;
            
            default   : return 0;
                          
        }
    }
    
    public String noteIntToString(int p_note){
        switch(p_note){
                case 0 : return "C";
                
                case 1 : return "C#";
                
                case 2 : return "D";
                         
                case 3 : return "D#";

                case 4 : return "E";

                case 5 : return "F";

                case 6 : return "F#";

                case 7 : return "G";

                case 8 : return "G#";

                case 9 : return "A";
                         
                case 10 : return "A#";
                         
                case 11 : return "B";
                          
                default : return "";
        }
    }
    
    public boolean partitionEstValide(ArrayList<ArrayList<String>> p_array){
        int present;
        for(int j = 0;j < p_array.size()-1;j++){
            for(int i = 0; i < p_array.get(j).size(); i++){
                present = 0;
                String v_toCompare = p_array.get(j).get(i);
                for(Map.Entry<String, Touche> entry : m_listeTouches.entrySet()){
                    Touche v_touche = entry.getValue();
                    String v_compare = noteIntToString(v_touche.getNote()) + String.valueOf(v_touche.getOctave());
                    if(v_toCompare.equalsIgnoreCase(v_compare)){
                        present++;
                    }
                }
                if(present == 0){
                    return false;
                }
            }
        }
        ArrayList<String> v_array = new ArrayList();
        v_array.add("_");
        v_array.add(",");
        v_array.add(".");
        for(int i = 3;i<10;i++){
            v_array.add(""+i);
        }
        for(int i = 0;i < p_array.get(p_array.size()-1).size();i++){
            if(!v_array.contains(p_array.get(p_array.size()-1).get(i)))return false;
        }
        return true;
    }
}
