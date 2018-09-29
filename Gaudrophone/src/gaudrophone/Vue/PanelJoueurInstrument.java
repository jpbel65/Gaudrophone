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
//import static gaudrophone.Vue.Vue.m_statePedale1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.SwingUtilities;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.Timer;


/**
 *
 * @author Luca
 */
public class PanelJoueurInstrument extends javax.swing.JPanel{

    
    
    boolean v_pressedOut = true;
    Touche v_toucheEnfoncee = null;

    Color v_ancienneCouleur;
    
    static int v_compteur1 = 0;
    static int v_ToucheBoucleJouer1 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer1 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle1 = new ArrayList<Touche>();
    static int placeDansBoucle1 = 0;
    
    static int v_compteur2 = 0;
    static int v_ToucheBoucleJouer2 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer2 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle2 = new ArrayList<Touche>();
    static int placeDansBoucle2 = 0;
    
    static int v_compteur3 = 0;
    static int v_ToucheBoucleJouer3 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer3 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle3 = new ArrayList<Touche>();
    static int placeDansBoucle3 = 0;
    
    static int v_compteur4 = 0;
    static int v_ToucheBoucleJouer4 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer4 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle4 = new ArrayList<Touche>();
    static int placeDansBoucle4 = 0;
    
    static int v_compteur5 = 0;
    static int v_ToucheBoucleJouer5 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer5 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle5 = new ArrayList<Touche>();
    static int placeDansBoucle5 = 0;
    
    static int v_compteur6 = 0;
    static int v_ToucheBoucleJouer6 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer6 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle6 = new ArrayList<Touche>();
    static int placeDansBoucle6 = 0;
    
    static int v_compteur7 = 0;
    static int v_ToucheBoucleJouer7 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer7 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle7 = new ArrayList<Touche>();
    static int placeDansBoucle7 = 0;
    
    static int v_compteur8 = 0;
    static int v_ToucheBoucleJouer8 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer8 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle8 = new ArrayList<Touche>();
    static int placeDansBoucle8 = 0;
    
    static int v_compteur9 = 0;
    static int v_ToucheBoucleJouer9 = 0;
    static ArrayList<Long> v_TempsToucheAppuyer9 = new ArrayList<Long>();
    static ArrayList<Touche> v_ToucheJouerBoucle9 = new ArrayList<Touche>();
    static int placeDansBoucle9 = 0;
    
    PanelJoueurInstrument(){
        
        addMouseMotionListener(new PanelJoueurInstrument.MyMouseAdapter());
        addMouseListener(new PanelJoueurInstrument.MyMouseAdapter());
        timerPedale1.start();
        timerPedale2.start();
        timerPedale3.start();
        timerPedale4.start();
        timerPedale5.start();
        timerPedale6.start();
        timerPedale7.start();
        timerPedale8.start();
        timerPedale9.start();
        
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        
        setBackground(Color.white);
        super.paintComponent(g);
        
       
        if(Vue.m_controlleur.getModel().getConteneurInstruments().getInstrumentActif() != null){
            Vue.m_controlleur.getModel().getConteneurInstruments().getInstrumentActif().peindreInstrument(this, g);
        }
              
    }

    Timer timerPedale1 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale1 == "play"){
                v_compteur1++;
                if(v_compteur1 == v_TempsToucheAppuyer1.get(v_ToucheBoucleJouer1)){
                    Runnable Pedale1 = new ThreadBoucle(v_ToucheJouerBoucle1.get(v_ToucheBoucleJouer1));
                    new Thread(Pedale1).start();
                    if(v_ToucheBoucleJouer1 < placeDansBoucle1-1) v_ToucheBoucleJouer1++;

                }
                if (v_compteur1 == (PanelMetronomePedales.m_timeStopPedale1 - PanelMetronomePedales.m_timeStartPedale1)/ 100000000){
                    v_ToucheBoucleJouer1 = 0;
                    v_compteur1 = 0;
                }
            }  
         }
            
    });
    
    Timer timerPedale2 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale2 == "play"){
                v_compteur2++;
                if(v_compteur2 == v_TempsToucheAppuyer2.get(v_ToucheBoucleJouer2)){
                    Runnable Pedale2 = new ThreadBoucle(v_ToucheJouerBoucle2.get(v_ToucheBoucleJouer2));
                    new Thread(Pedale2).start();
                    if(v_ToucheBoucleJouer2 < placeDansBoucle2-1) v_ToucheBoucleJouer2++;

                }
                if (v_compteur2 == (PanelMetronomePedales.m_timeStopPedale2 - PanelMetronomePedales.m_timeStartPedale2)/ 100000000){
                    v_ToucheBoucleJouer2 = 0;
                    v_compteur2 = 0;
                }
            }  
         }
            
    });
    
    Timer timerPedale3 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale3 == "play"){
                v_compteur3++;
                if(v_compteur3 == v_TempsToucheAppuyer3.get(v_ToucheBoucleJouer3)){
                    Runnable Pedale3 = new ThreadBoucle(v_ToucheJouerBoucle3.get(v_ToucheBoucleJouer3));
                    new Thread(Pedale3).start();
                    if(v_ToucheBoucleJouer3 < placeDansBoucle3-1) v_ToucheBoucleJouer3++;

                }
                if (v_compteur3 == (PanelMetronomePedales.m_timeStopPedale3 - PanelMetronomePedales.m_timeStartPedale3)/ 100000000){
                    v_ToucheBoucleJouer3 = 0;
                    v_compteur3 = 0;
                }
            }  
         }
            
    });
    
    Timer timerPedale4 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale4 == "play"){
                v_compteur4++;
                if(v_compteur4 == v_TempsToucheAppuyer4.get(v_ToucheBoucleJouer4)){
                    Runnable Pedale4 = new ThreadBoucle(v_ToucheJouerBoucle4.get(v_ToucheBoucleJouer4));
                    new Thread(Pedale4).start();
                    if(v_ToucheBoucleJouer4 < placeDansBoucle4-1) v_ToucheBoucleJouer4++;

                }
                if (v_compteur4 == (PanelMetronomePedales.m_timeStopPedale4 - PanelMetronomePedales.m_timeStartPedale4)/ 100000000){
                    v_ToucheBoucleJouer4 = 0;
                    v_compteur4 = 0;
                }
            }  
         }
            
    });
    
    Timer timerPedale5 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale5 == "play"){
                v_compteur5++;
                if(v_compteur5 == v_TempsToucheAppuyer5.get(v_ToucheBoucleJouer5)){
                    Runnable Pedale5 = new ThreadBoucle(v_ToucheJouerBoucle5.get(v_ToucheBoucleJouer5));
                    new Thread(Pedale5).start();
                    if(v_ToucheBoucleJouer5 < placeDansBoucle5-1) v_ToucheBoucleJouer5++;

                }
                if (v_compteur5 == (PanelMetronomePedales.m_timeStopPedale5 - PanelMetronomePedales.m_timeStartPedale5)/ 100000000){
                    v_ToucheBoucleJouer5 = 0;
                    v_compteur5 = 0;
                }
            }  
         }
            
    });
    
    Timer timerPedale6 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale6 == "play"){
                v_compteur6++;
                if(v_compteur6 == v_TempsToucheAppuyer6.get(v_ToucheBoucleJouer6)){
                    Runnable Pedale6 = new ThreadBoucle(v_ToucheJouerBoucle6.get(v_ToucheBoucleJouer6));
                    new Thread(Pedale6).start();
                    if(v_ToucheBoucleJouer6 < placeDansBoucle6-1) v_ToucheBoucleJouer6++;

                }
                if (v_compteur6 == (PanelMetronomePedales.m_timeStopPedale6 - PanelMetronomePedales.m_timeStartPedale6)/ 100000000){
                    v_ToucheBoucleJouer6 = 0;
                    v_compteur6 = 0;
                }
            }  
         }
            
    });
    
    Timer timerPedale7 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale7 == "play"){
                v_compteur7++;
                if(v_compteur7 == v_TempsToucheAppuyer7.get(v_ToucheBoucleJouer7)){
                    Runnable Pedale7 = new ThreadBoucle(v_ToucheJouerBoucle7.get(v_ToucheBoucleJouer7));
                    new Thread(Pedale7).start();
                    if(v_ToucheBoucleJouer7 < placeDansBoucle7-1) v_ToucheBoucleJouer7++;

                }
                if (v_compteur7 == (PanelMetronomePedales.m_timeStopPedale7 - PanelMetronomePedales.m_timeStartPedale7)/ 100000000){
                    v_ToucheBoucleJouer7 = 0;
                    v_compteur7 = 0;
                }
            }  
         }
            
    });
    
    Timer timerPedale8 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale8 == "play"){
                v_compteur8++;
                if(v_compteur8 == v_TempsToucheAppuyer8.get(v_ToucheBoucleJouer8)){
                    Runnable Pedale8 = new ThreadBoucle(v_ToucheJouerBoucle8.get(v_ToucheBoucleJouer8));
                    new Thread(Pedale8).start();
                    if(v_ToucheBoucleJouer8 < placeDansBoucle8-1) v_ToucheBoucleJouer8++;

                }
                if (v_compteur8 == (PanelMetronomePedales.m_timeStopPedale8 - PanelMetronomePedales.m_timeStartPedale8)/ 100000000){
                    v_ToucheBoucleJouer8 = 0;
                    v_compteur8 = 0;
                }
            }  
         }
            
    });
    
    Timer timerPedale9 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(PanelMetronomePedales.m_statePedale9 == "play"){
                v_compteur9++;
                if(v_compteur9 == v_TempsToucheAppuyer9.get(v_ToucheBoucleJouer9)){
                    Runnable Pedale9 = new ThreadBoucle(v_ToucheJouerBoucle9.get(v_ToucheBoucleJouer9));
                    new Thread(Pedale9).start();
                    if(v_ToucheBoucleJouer9 < placeDansBoucle9-1) v_ToucheBoucleJouer9++;

                }
                if (v_compteur9 == (PanelMetronomePedales.m_timeStopPedale9 - PanelMetronomePedales.m_timeStartPedale9)/ 100000000){
                    v_ToucheBoucleJouer9 = 0;
                    v_compteur9 = 0;
                }
            }  
         }
            
    });
    
    
    
    private class MyMouseAdapter extends MouseAdapter{
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
                                v_toucheEnfoncee = v_touche;
                            }
                        });
                     
                    if(v_toucheEnfoncee != null){
                        repaint();
                        v_pressedOut = false;
                        //Lance un thread qui s'occuper de jouer la touche si elle n'est pas deja activee
                        if(!v_toucheEnfoncee.getThread()){
                            if(PanelMetronomePedales.m_statePedale1 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale1)/ 100000000;
                                v_TempsToucheAppuyer1.add(placeDansBoucle1, timeNow);
                                v_ToucheJouerBoucle1.add(placeDansBoucle1, v_toucheEnfoncee);
                                placeDansBoucle1++;

                            }
                            if(PanelMetronomePedales.m_statePedale2 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale2)/ 100000000;
                                v_TempsToucheAppuyer2.add(placeDansBoucle2, timeNow);
                                v_ToucheJouerBoucle2.add(placeDansBoucle2, v_toucheEnfoncee);
                                placeDansBoucle2++;

                            }
                            if(PanelMetronomePedales.m_statePedale3 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale3)/ 100000000;
                                v_TempsToucheAppuyer3.add(placeDansBoucle3, timeNow);
                                v_ToucheJouerBoucle3.add(placeDansBoucle3, v_toucheEnfoncee);
                                placeDansBoucle3++;

                            }
                            if(PanelMetronomePedales.m_statePedale4 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale4)/ 100000000;
                                v_TempsToucheAppuyer4.add(placeDansBoucle4, timeNow);
                                v_ToucheJouerBoucle4.add(placeDansBoucle4, v_toucheEnfoncee);
                                placeDansBoucle4++;

                            }
                            if(PanelMetronomePedales.m_statePedale5 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale5)/ 100000000;
                                v_TempsToucheAppuyer5.add(placeDansBoucle5, timeNow);
                                v_ToucheJouerBoucle5.add(placeDansBoucle5, v_toucheEnfoncee);
                                placeDansBoucle5++;

                            }
                            if(PanelMetronomePedales.m_statePedale6 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale6)/ 100000000;
                                v_TempsToucheAppuyer6.add(placeDansBoucle6, timeNow);
                                v_ToucheJouerBoucle6.add(placeDansBoucle6, v_toucheEnfoncee);
                                placeDansBoucle6++;

                            }
                            if(PanelMetronomePedales.m_statePedale7 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale7)/ 100000000;
                                v_TempsToucheAppuyer7.add(placeDansBoucle7, timeNow);
                                v_ToucheJouerBoucle7.add(placeDansBoucle7, v_toucheEnfoncee);
                                placeDansBoucle7++;

                            }
                            if(PanelMetronomePedales.m_statePedale8 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale8)/ 100000000;
                                v_TempsToucheAppuyer8.add(placeDansBoucle8, timeNow);
                                v_ToucheJouerBoucle8.add(placeDansBoucle8, v_toucheEnfoncee);
                                placeDansBoucle8++;

                            }
                            if(PanelMetronomePedales.m_statePedale9 == "rec"){
                                long timeNow = (System.nanoTime() - PanelMetronomePedales.m_timeStartPedale9)/ 100000000;
                                v_TempsToucheAppuyer9.add(placeDansBoucle9, timeNow);
                                v_ToucheJouerBoucle9.add(placeDansBoucle9, v_toucheEnfoncee);
                                placeDansBoucle9++;

                            }
                            Runnable r = new MyThread(v_toucheEnfoncee);
                            new Thread(r).start();
                        }
                    }
                    else{}
                }
                
                
            }
            else{}
        }
        
        @Override
        public void mouseReleased(MouseEvent e){
            if(SwingUtilities.isLeftMouseButton(e)){
                if(!v_pressedOut)
                    v_pressedOut = true;
            }    
            v_toucheEnfoncee = null;
        }
    }//end of MyMouseAdapter
    
    /*
    Classe qui implementes Runnable qui est utilise dans un thread. 
    Permet de s'occuper de jouer une note en gérant son son et sa couleur.
    */
    public class MyThread implements Runnable {
        
        private final Touche m_touche;
        private int m_persistancePieceMS = 0;
        private boolean m_jouerSon = true;
        
        public MyThread(Touche p_touche) {
            super();
            m_touche = p_touche;
        }

        public void setPersistancePieceMS(int p_persistancePieceMS){
            m_persistancePieceMS = p_persistancePieceMS;
        }
        public void setJouerSon(boolean p_jouerSon){
            m_jouerSon = p_jouerSon;
        }
        
        public void run() {
            m_touche.setThread(true);
            Color v_ancienneCouleur = m_touche.getCouleur();
            m_touche.setCouleur(new Color(v_ancienneCouleur.getRed()/255, v_ancienneCouleur.getGreen()/255, v_ancienneCouleur.getBlue()/255, 0.5f));
            int Octave = m_touche.getOctave();
            int Note = m_touche.getNote();
            int Timbre = Vue.m_controlleur.getInstrumentActif().getTimbre();

            int Valeur_Synth = Note + Octave*12;
            if("".equals(m_touche.getFichierAudio())){
                if(m_jouerSon){
                    Vue.m_controlleur.m_Channels[Timbre].noteOn(Valeur_Synth,100);
                }
                

                float persistance = m_touche.getPersistance();
                int sleepTime = Math.round(persistance*1000);

                try{
                    int i = 0;
                    if(m_persistancePieceMS == 0){
                       while(!v_pressedOut){
                            Thread.sleep(1);
                            i++;
                        }
                        if (i < sleepTime){
                            Thread.sleep(sleepTime-i);
                        } 
                    }
                    else{
                        Thread.sleep(m_persistancePieceMS);
                    }
                    
                }
                catch(Exception e){

                }
            }
            else{
                try{
                    AudioInputStream ais = AudioSystem.getAudioInputStream(new File(v_toucheEnfoncee.getFichierAudio()));
                    Clip v_clip = AudioSystem.getClip();  

                    v_clip.open(ais);
                    if(m_jouerSon){
                        v_clip.start();
                    }
                    if(m_persistancePieceMS == 0){
                        Thread.sleep(v_clip.getMicrosecondLength()/1000);
                    }
                    else{
                        
                        Thread.sleep(m_persistancePieceMS);
                    }
                    
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            if(m_jouerSon){
                Vue.m_controlleur.m_Channels[Timbre].noteOff(Valeur_Synth);
            }
            
            m_touche.setCouleur(v_ancienneCouleur);
            repaint();
            m_touche.setThread(false);
        }
    }
    
    
    public class ThreadBoucle implements Runnable {
        
        private final Touche m_touche;
        
        public ThreadBoucle(Touche p_touche) {
            super();
            m_touche = p_touche;
        }

        public void run() {
            m_touche.setThread(true);
            int Octave = m_touche.getOctave();
            int Note = m_touche.getNote();
            int Timbre = Vue.m_controlleur.getInstrumentActif().getTimbre();

            int Valeur_Synth = Note + Octave*12;
            if("".equals(m_touche.getFichierAudio())){
                Vue.m_controlleur.m_Channels[Timbre].noteOn(Valeur_Synth,100);

                float persistance = m_touche.getPersistance();
                int sleepTime = Math.round(persistance*1000);

                try{
                    
                    Thread.sleep(sleepTime);
                    
                }
                catch(Exception e){

                }
            }
            else{
                try{
                    AudioInputStream ais = AudioSystem.getAudioInputStream(new File(v_toucheEnfoncee.getFichierAudio()));
                    Clip v_clip = AudioSystem.getClip();  

                    v_clip.open(ais);
                    v_clip.start();
                    Thread.sleep(v_clip.getMicrosecondLength()/1000);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            Vue.m_controlleur.m_Channels[Timbre].noteOff(Valeur_Synth);
            m_touche.setThread(false);
        }
    }
    
    public class ThreadPiece implements Runnable{
        
        private final javax.swing.JTable m_table;
        private int m_noteIndex = 0;
        private int m_bpm = 0;
        private boolean m_jouerSon = true;
        private final int m_nbPartitionRow; 
        private final int m_indexRowDuree;
        private boolean m_pause = false;
        
        public ThreadPiece(javax.swing.JTable p_table){
            m_table = p_table;
            m_nbPartitionRow = m_table.getRowCount() - 1;
            m_indexRowDuree = m_table.getRowCount() - 1;
        }
    
        public void setPlaySound(boolean p_playSound){
            m_jouerSon = p_playSound;
        }
        
        public void setBpm(int p_bpm){
            m_bpm = p_bpm;
        }
        
        public void setPause(boolean p_pause){
            m_pause = p_pause;
        }
        
        public void avancer(){
            
            if(m_table.getSelectedColumn() == -1){
                m_table.setColumnSelectionInterval(0, 0);

            }
            else if(m_table.getSelectedColumn() == m_table.getColumnCount() -1){
                m_table.setColumnSelectionInterval(0,0);
            }
            else{
                m_table.setColumnSelectionInterval(m_table.getSelectedColumn()+1, m_table.getSelectedColumn()+1);
            }
        }
        
        public void reculer(){
            if(m_table.getSelectedColumn() == -1 ||
               m_table.getSelectedColumn() == 0){
                m_table.setColumnSelectionInterval(m_table.getColumnCount() - 1, m_table.getColumnCount() - 1);

            }
   
            else{
                m_table.setColumnSelectionInterval(m_table.getSelectedColumn() - 1, m_table.getSelectedColumn() - 1);
            }
        }
        
        @Override
        public void run() {
            
            
            //On obtient l'indice de départ pour itérer
            if(m_table.getSelectedColumn() == -1){
                m_table.setColumnSelectionInterval(0, 0);
                m_noteIndex = 0;
            }else{
                m_noteIndex = m_table.getSelectedColumn();
            }
            
            //On itère du début de la sélection de la piece jusqua la fin
            for(; m_noteIndex != m_table.getColumnCount(); m_noteIndex++){
                
                //On met en selection l'accord actuellement joué dans le UI
                m_table.setColumnSelectionInterval(m_noteIndex, m_noteIndex);
                
                //On récupère les touches pour la colonne actuelle
                ArrayList<Touche> v_touches = new ArrayList<>();
                for(int i = 0; i < m_nbPartitionRow; i++){
                    
                    //La touche récupérée
                    Touche v_touche;
                    
                    //On récupère le nom de la note de la touche.
                    String v_strTouche = (String)m_table.getValueAt(i, m_noteIndex);
                    
                    //Si le nom est 'X' c'est un vide
                    if(v_strTouche.equalsIgnoreCase("X")){
                        v_touche = null;
                    }
                    //Sinon on cherche la touche
                    else{
                        
                        if(v_strTouche.equalsIgnoreCase("C") ||
                           v_strTouche.equalsIgnoreCase("D") ||
                           v_strTouche.equalsIgnoreCase("E") ||
                           v_strTouche.equalsIgnoreCase("F") ||
                           v_strTouche.equalsIgnoreCase("G") ||
                           v_strTouche.equalsIgnoreCase("A") ||
                           v_strTouche.equalsIgnoreCase("B")){
                           v_strTouche = v_strTouche + "4";
                        }
                        
                        else if(v_strTouche.equalsIgnoreCase("C#") ||
                                v_strTouche.equalsIgnoreCase("D#") ||
                                v_strTouche.equalsIgnoreCase("E#") ||
                                v_strTouche.equalsIgnoreCase("F#") ||
                                v_strTouche.equalsIgnoreCase("G#") ||
                                v_strTouche.equalsIgnoreCase("A#") ||
                                v_strTouche.equalsIgnoreCase("B#")){
                            v_strTouche = v_strTouche.charAt(0) + "4#";
                        }
                        
                        if(v_strTouche.charAt(v_strTouche.length()-1) == '#'){
                            v_strTouche = v_strTouche.charAt(0) + "#" + v_strTouche.charAt(1);
                        }
                        
                        v_touche = Vue.
                                   m_controlleur.
                                   getModel().
                                   getConteneurInstruments().
                                   getInstrumentActif().
                                   getConteneurTouches().
                                   retournerTouche(v_strTouche);
                    }
                    
                    v_touches.add(v_touche);
                    
                }
                
                //On calcule le nombre de millisecondes à attendre
                float v_millis = 1000.0f * ( 60.0f / ((float)m_bpm));
                String v_charDuree = (String) m_table.getValueAt(m_indexRowDuree, m_noteIndex);
                
                switch(v_charDuree){
                    case "_" : v_millis *= 1.0f;  break;
                    case "," : v_millis *= 0.5f;  break;
                    case "." : v_millis *= 0.25f; break;
                    case "3" : v_millis *= 3.0f;  break;
                    case "4" : v_millis *= 4.0f;  break;
                    case "5" : v_millis *= 5.0f;  break;
                    case "6" : v_millis *= 6.0f;  break;
                    case "7" : v_millis *= 7.0f;  break;
                    case "8" : v_millis *= 8.0f;  break;
                    case "9" : v_millis *= 9.0f;  break;
                    default  : v_millis *= 1.0f;  break;
                }
                
                int v_ms = Math.round(v_millis);
                
                ArrayList<Thread> v_threads = new ArrayList<>();
                
                for(int i = 0; i < m_nbPartitionRow; i++){
                    if(v_touches.get(i) != null){
                        MyThread r = new MyThread(v_touches.get(i));
                        
                        r.setPersistancePieceMS(v_ms);
                        r.setJouerSon(m_jouerSon);
                        
                        v_threads.add(new Thread(r));
                        
                    }
                    else{
                        v_threads.add(new Thread(new Runnable(){
                                int m_ms = v_ms;
                                @Override
                                public void run(){
                                    try {
                                        Thread.sleep(m_ms);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(PanelJoueurInstrument.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }));
                    }
                    
                }
                for(int i = 0; i < m_nbPartitionRow; i++){
                    v_threads.get(i).start();
                }
                
                
                for(int i = 0; i < m_nbPartitionRow; i++){
                    try {
                        v_threads.get(i).join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PanelJoueurInstrument.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(m_pause) break;
                
            }
            
        }
        
        
    }
    
    private ThreadPiece m_threadPiece;
    
    public void importerPiece(javax.swing.JTable p_table, int p_bpm){
        m_threadPiece = new ThreadPiece(p_table);
        m_threadPiece.setBpm(p_bpm);
    }
    
    public void jouerPiece(boolean p_playSound){
        
        m_threadPiece.setPlaySound(p_playSound);
        m_threadPiece.setPause(false);
        
        new Thread(m_threadPiece).start();
        
    }

    public void pausePiece(){
        m_threadPiece.setPause(true);
    }

    public void avancerPiece(){
        m_threadPiece.avancer();
        m_threadPiece.setPause(true);
        new Thread(m_threadPiece).start();
    }
    
    public void reculerPiece(){
        m_threadPiece.reculer();
        m_threadPiece.setPause(true);
        new Thread(m_threadPiece).start();
    }
}
//end of Paneljoueur Instrument
