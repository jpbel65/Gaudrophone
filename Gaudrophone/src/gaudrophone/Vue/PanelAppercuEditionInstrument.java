/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Vue;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gaudrophone.Model.Instrument.Touche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.SwingUtilities;

import java.io.File;
import javax.sound.sampled.*;


/**
 *
 * @author Simon
 */
public class PanelAppercuEditionInstrument extends javax.swing.JPanel{
    
    boolean v_pressedOut = true;
    float preX, preY;
    Touche v_toucheEnfoncee = null;

    boolean v_relacher = false;
    int v_comparateur = 0;
    int v_sleepTime;

    //Color v_ancienneCouleur;

    
    public PanelAppercuEditionInstrument(){
        
        addMouseMotionListener(new MyMouseAdapter());
        addMouseListener(new MyMouseAdapter());
    }
    
    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(v_comparateur < v_sleepTime){
                v_comparateur += 10;
            }
            if(v_comparateur >= v_sleepTime && v_relacher == true)
            {
                ((Timer)e.getSource()).stop();
                int Timbre = Vue.m_controlleur.getInstrumentActif().getTimbre();

                Vue.m_controlleur.m_Channels[Timbre].allNotesOff();
                v_comparateur = 0;
                v_relacher = false;
            }
        }
    });
    
     
    @Override
    public void paintComponent(Graphics g){
        
        setBackground(Color.white);
        super.paintComponent(g);
        
       
        if(Vue.m_controlleur.getModel().getConteneurInstruments().getInstrumentActif() != null){
            Vue.m_controlleur.getModel().getConteneurInstruments().getInstrumentActif().peindreInstrument(this, g);
        }
              
    }
    
    
    private class MyMouseAdapter extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent me) {
            super.mouseClicked(me);

            if(SwingUtilities.isLeftMouseButton(me)){
                if(Vue.m_controlleur.getModel().getConteneurInstruments().getInstrumentActif() != null){
                    Vue.m_controlleur.getModel().getConteneurInstruments().getInstrumentActif().getConteneurTouches().m_listeTouches.forEach((v_nom,v_touche) -> {
                        if(v_touche.getForme().contient(me.getPoint())){
                            System.out.println("Clické : " + v_nom);
                        }           
                    });
                }
            }
        }
        
        
        @Override
        public void mousePressed(MouseEvent e){
            if(SwingUtilities.isLeftMouseButton(e)){
                if(Vue.m_controlleur.getModel().getConteneurInstruments().getInstrumentActif() != null){

                    Vue.m_controlleur
                       .getModel()
                       .getConteneurInstruments()
                       .getInstrumentActif()
                       .getConteneurTouches()
                       .m_listeTouches.forEach((v_nom,v_touche) -> {
                            if(v_touche.getForme().contient(e.getPoint())){
                                //System.out.println("Pressed : " + v_nom);
                                v_toucheEnfoncee = v_touche;
                            }           
                        });

                    if(v_toucheEnfoncee == null)
                    {
                        System.out.println("Pas de touche enfoncee");
                        v_pressedOut = true;
                    }
                    else{
                        v_pressedOut = false;

                        preX = v_toucheEnfoncee.getForme().getPositionRelativeX() - ((float)e.getX()/(float)getWidth());
                        preY = v_toucheEnfoncee.getForme().getPositionRelativeY() - ((float)e.getY()/(float)getHeight());
                        updateLocation(e);

                        //v_ancienneCouleur = v_toucheEnfoncee.getCouleur();
                        //v_toucheEnfoncee.setCouleur(new Color(v_ancienneCouleur.getRed()/255, v_ancienneCouleur.getGreen()/255, v_ancienneCouleur.getBlue()/255, 0.5f));
                        if("".equals(v_toucheEnfoncee.getFichierAudio())){
                            int Octave = v_toucheEnfoncee.getOctave();
                            int Note = v_toucheEnfoncee.getNote();

                            int Timbre = Vue.m_controlleur.getInstrumentActif().getTimbre();

                            int Valeur_Synth = Note + Octave*12;

                            //if (timer.isRunning() == false){
                                Vue.m_controlleur.m_Channels[Timbre].noteOn(Valeur_Synth,100);
                            //}

                            float persistance = v_toucheEnfoncee.getPersistance();
                            v_sleepTime = Math.round(persistance*1000);

                            timer.start();
                        }
                        else{
                            try{
                                AudioInputStream ais = AudioSystem.getAudioInputStream(new File(v_toucheEnfoncee.getFichierAudio()));
                                Clip v_clip = AudioSystem.getClip();  

                                v_clip.open(ais);
                                v_clip.start();

                            }
                            catch(Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
            else
            {
                
            }
        }
        
        @Override
        public void mouseDragged(MouseEvent e){
            if(SwingUtilities.isLeftMouseButton(e)){
                if(!v_pressedOut){
                    updateLocation(e);
                }
                else{

                }
            }
            else{
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent e){
            if(SwingUtilities.isLeftMouseButton(e)){
                if(!v_pressedOut){
                   if(v_toucheEnfoncee.getForme().contient(e.getPoint())){
                        updateLocation(e);
                        int Timbre = Vue.m_controlleur.getInstrumentActif().getTimbre();
                        Vue.m_controlleur.m_Channels[Timbre].allNotesOff();
                    }
                }
            }
            v_toucheEnfoncee = null;
        }
    
        
        //Fonction personnelle
        public void updateLocation(MouseEvent e){
            
            //On update la position relative de la touche
            
            
            v_toucheEnfoncee.getForme().setPositionRelativeX(preX + ((float)e.getX()/(float)getWidth()));
            v_toucheEnfoncee.getForme().setPositionRelativeY(preY + ((float)e.getY()/(float)getHeight()));
            
            //Si la touche va dépasser les bord du jpanel :
            if( !(new java.awt.Rectangle(getWidth(),getHeight()).contains(
                   (int)(v_toucheEnfoncee.getForme().getPositionRelativeX()*(float)getWidth()),
                   (int)(v_toucheEnfoncee.getForme().getPositionRelativeY()*(float)getHeight()),
                   (int)(v_toucheEnfoncee.getForme().getTailleRelativeX()*(float)getWidth()),
                   (int)(v_toucheEnfoncee.getForme().getTailleRelativeY()*(float)getHeight()))))
            {
                float new_x = v_toucheEnfoncee.getForme().getPositionRelativeX();
                float new_y = v_toucheEnfoncee.getForme().getPositionRelativeY();
                
                if((v_toucheEnfoncee.getForme().getPositionRelativeX() + v_toucheEnfoncee.getForme().getTailleRelativeX()) > 1.0f){
                    new_x = 1.0f - v_toucheEnfoncee.getForme().getTailleRelativeX();
                }
                if((v_toucheEnfoncee.getForme().getPositionRelativeY() + v_toucheEnfoncee.getForme().getTailleRelativeY()) > 1.0f){
                    new_y = 1.0f - v_toucheEnfoncee.getForme().getTailleRelativeY();
                }
                if(v_toucheEnfoncee.getForme().getPositionRelativeX() < 0.0f){
                    new_x = 0.0f;
                }
                if(v_toucheEnfoncee.getForme().getPositionRelativeY() < 0.0f){
                    new_y = 0.0f;
                }
                v_toucheEnfoncee.getForme().setPositionRelativeX(new_x);
                v_toucheEnfoncee.getForme().setPositionRelativeY(new_y);
            }
            //on repaint le jpanel avec les changements
            repaint();
        }
    }
}
