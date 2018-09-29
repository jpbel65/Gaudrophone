/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Instrument;



import gaudrophone.Model.Forme.FormeStrategy;
import gaudrophone.Model.Forme.FormeFactory;
import gaudrophone.Vue.Vue;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.lang.Math;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
 *
 * @author Simon
 */
public class Touche implements java.io.Serializable{
    
//<editor-fold defaultstate="collapsed" desc="Attributs">

    private String         m_nom;
    private FormeStrategy  m_forme;
    private java.awt.Color m_couleur;
    private java.awt.Color m_couleurBordure;
    private int            m_bordure;
    private String         m_imageDeFond;
    private String         m_fichierAudio;
    private int            m_octave;
    private int            m_note;
    private int            m_persistance;    
    private boolean        m_afficherNom;
    private boolean        m_afficherOctave;
    private boolean        m_afficherNote;
    private boolean        m_afficherPersistance;
    private boolean        m_thread;
    
    java.awt.Image         m_image;
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Méthodes">
    public Touche(){
        
        m_nom                 = "NouvelleTouche";
        m_forme               = FormeFactory.getShape("rectangle");
        m_couleur             = java.awt.Color.RED;
        m_couleurBordure      = java.awt.Color.BLACK;
        m_bordure             = 1;
        m_imageDeFond         = "";
        m_fichierAudio        = "";
        m_octave              = 5;
        m_note                = 0;
        m_persistance         = 1; 
        m_afficherNom         = true;
        m_afficherOctave      = true;
        m_afficherNote   = true;
        m_afficherPersistance = true;
        m_thread              = false;
    }
    
    public Touche(float          p_tailleRelativeX,
                  float          p_tailleRelativeY,
                  float          p_positionRelativeX,
                  float          p_positionRelativeY,
                  String         p_nom,
                  String         p_forme, 
                  java.awt.Color p_couleur,
                  java.awt.Color p_couleurBordure,
                  int            p_bordure,
                  String         p_imageDeFond,
                  String         p_fichierAudio,
                  int            p_octave,
                  int            p_note,
                  int            p_persistance){

        m_nom               = p_nom;
        m_forme             = FormeFactory.getShape("rectangle");
        m_forme.setPositionRelativeX(p_positionRelativeX);
        m_forme.setPositionRelativeY(p_positionRelativeY);
        m_forme.setTailleRelativeX(p_tailleRelativeX);
        m_forme.setTailleRelativeY(p_tailleRelativeY);
        m_couleur           = p_couleur;
        m_couleurBordure    = p_couleurBordure;
        m_bordure           = p_bordure;
        m_imageDeFond       = p_imageDeFond;
        m_fichierAudio      = p_fichierAudio;
        m_octave            = p_octave;
        m_note              = p_note;
        m_persistance       = p_persistance;
    };
    
 //<editor-fold defaultstate="collapsed" desc="Accesseurs / Mutateurs">   

    public void setNom(String p_nom){
        m_nom = p_nom;
    }
    public String getNom(){
        return m_nom;
    }
    public void setForme(String p_forme){
        if(m_forme != null){
        float v_oldPositionRelativeX = m_forme.getPositionRelativeX();
        float v_oldPositionRelativeY = m_forme.getPositionRelativeY();
        float v_oldTailleRelativeX   = m_forme.getTailleRelativeX();
        float v_oldTailleRelativeY   = m_forme.getTailleRelativeY();
        m_forme = FormeFactory.getShape(p_forme);
        m_forme.setPositionRelativeX(v_oldPositionRelativeX);
        m_forme.setPositionRelativeY(v_oldPositionRelativeY);
        m_forme.setTailleRelativeX(v_oldTailleRelativeX);
        m_forme.setTailleRelativeY(v_oldTailleRelativeY);
        }
        else{
            m_forme = FormeFactory.getShape(p_forme);
        }
    }
    public FormeStrategy getForme(){
        return m_forme;
    }
    public void setCouleur(java.awt.Color p_couleur){
        m_couleur = p_couleur;
    }
    public java.awt.Color getCouleur(){
        return m_couleur;
    }
    
    public void setCouleurBordure(java.awt.Color p_couleur){
        m_couleurBordure = p_couleur;
    }
    public java.awt.Color getCouleurBordure(){
        return m_couleurBordure;
    }
    
    public void setBordure(int p_bordure){
        m_bordure = p_bordure;
    }
    public int getBordure(){
        return m_bordure;
    }
    public void setImageDeFond(String p_imageDeFond){
        m_imageDeFond = p_imageDeFond;
        
        try {
            java.io.File v_fichierImage = new java.io.File(m_imageDeFond); 
            m_image = javax.imageio.ImageIO.read(v_fichierImage);    
                
        } catch (java.io.IOException ex) {
            //ex.printStackTrace();
        }
    }
    public String getImageDeFond(){
        return m_imageDeFond;
    }
    public void setFichierAudio(String p_fichierAudio){
        m_fichierAudio = p_fichierAudio;
    }
    public String getFichierAudio(){
        return m_fichierAudio;
    }
    public void setOctave(int p_octave){
        m_octave = p_octave;
    }
    public int getOctave(){
        return m_octave;
    }
    
    public void setNote(int p_note){
        m_note = p_note;
    }
    public int getNote(){
        return m_note;
    }
    public void setPersistance(int p_persistance){
        m_persistance = p_persistance;
    }
    public int getPersistance(){
        return m_persistance;
    }
    public void setAfficherNom(boolean p_afficherNom){
        m_afficherNom = p_afficherNom;
    }
    public boolean getAfficherNom(){
        return m_afficherNom;
    }
    public void setAfficherOctave(boolean p_afficherOctave){
        m_afficherOctave = p_afficherOctave;
    }
    public boolean getAfficherOctave(){
        return m_afficherOctave;
    }
    public void setAfficherNote(boolean p_afficherNote){
        m_afficherNote = p_afficherNote;
    }
    public boolean getAfficherNote(){
        return m_afficherNote;
    }
    public void setAfficherPersistance(boolean p_afficherPersistance){
        m_afficherPersistance = p_afficherPersistance;
    }
    public boolean getAfficherPersistance(){
        return m_afficherPersistance;
    }
    public void setThread(boolean p_thread){
        m_thread = p_thread;
    }
    public boolean getThread(){
        return m_thread;
    }
//</editor-fold> 
    /*
    Permet de peindre les touches lorsque la fonction repaint est appelee
    */
    public void peindre(javax.swing.JPanel p_jPanel, java.awt.Graphics p_graphics){
       
        Graphics2D v_graphics2d = (Graphics2D)p_graphics;
        
        
        //on notifie la forme de la nouvelle taille du jpanel
        m_forme.updateFenetreDimensions(p_jPanel.getWidth(), p_jPanel.getHeight());
        
        //On obtient le rectangle entourant la forme en coordonnes absolues
        int v_positionX = (int)((float) p_jPanel.getWidth() * m_forme.getPositionRelativeX());
        int v_positionY = (int)((float) p_jPanel.getHeight() * m_forme.getPositionRelativeY());
        int v_tailleX   = (int)((float) p_jPanel.getWidth() * m_forme.getTailleRelativeX());
        int v_tailleY   = (int)((float) p_jPanel.getHeight() * m_forme.getTailleRelativeY());    
        
        
        //Permet de créer la bordure d'une touche
        if(m_bordure!=0){
            BasicStroke v_stroke = new BasicStroke(m_bordure);
            v_graphics2d.setStroke(v_stroke);
            v_graphics2d.setPaint(m_couleurBordure);
            m_forme.drawForme(v_graphics2d);
        }
        
        v_graphics2d.setColor(m_couleur);
        
        
        if("".equals(m_imageDeFond)){
            m_forme.fillForme(v_graphics2d);
        }
        else{   
            v_graphics2d.drawImage(m_image,
                          v_positionX,
                          v_positionY,
                          (v_positionX + v_tailleX),
                          (v_positionY + v_tailleY),
                          0,
                          0,
                          m_image.getWidth(null),
                          m_image.getHeight(null),
                          null);
        }
        
        //TODO remplacer par la valeur de la case à cocher
        //Permet d'utiliser une couleur complementaire pour que le texte soit toujours lisible
        if("rectangle".equals(m_forme.getNom())){
            float r = (~m_couleur.getRed()) & 0xff;
            float g = (~m_couleur.getGreen()) & 0xff;
            float b = (~m_couleur.getBlue()) & 0xff;
            v_graphics2d.setColor(new Color(r/255f, g/255f, b/255f));
        }
        else{
            v_graphics2d.setColor(Color.BLACK);
        }
        if(m_afficherNom){
           v_graphics2d.drawString(m_nom, v_positionX, v_positionY+10);
        }
        if(m_afficherOctave){
           v_graphics2d.drawString(Integer.toString(m_octave),v_positionX, v_positionY+30);
        }

        if(m_afficherNote){
            switch(m_note){
                case 0 : v_graphics2d.drawString("C", v_positionX, v_positionY+20);
                         break;
                
                case 1 : v_graphics2d.drawString("C#", v_positionX, v_positionY+20);
                         break;
                
                case 2 : v_graphics2d.drawString("D", v_positionX, v_positionY+20);
                         break;
                         
                case 3 : v_graphics2d.drawString("D#", v_positionX, v_positionY+20);
                         break;

                case 4 : v_graphics2d.drawString("E", v_positionX, v_positionY+20);
                         break;

                case 5 : v_graphics2d.drawString("F", v_positionX, v_positionY+20);
                         break;

                case 6 : v_graphics2d.drawString("F#", v_positionX, v_positionY+20);
                         break;

                case 7 : v_graphics2d.drawString("G", v_positionX, v_positionY+20);
                         break;

                case 8 : v_graphics2d.drawString("G#", v_positionX, v_positionY+20);
                         break;

                case 9 : v_graphics2d.drawString("A", v_positionX, v_positionY+20);
                         break;
                         
                case 10 : v_graphics2d.drawString("A#", v_positionX, v_positionY+20);
                          break;
                         
                case 11 : v_graphics2d.drawString("B", v_positionX, v_positionY+20);
                          break;
                          
                default : v_graphics2d.drawString("C", v_positionX, v_positionY+20);
                          break;
            }
        }
        if(m_afficherPersistance){
            v_graphics2d.drawString(Integer.toString(m_persistance),v_positionX, v_positionY+40);
        }
        
    }
//</editor-fold>  

}
