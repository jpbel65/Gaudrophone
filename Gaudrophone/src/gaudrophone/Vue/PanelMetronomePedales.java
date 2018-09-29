
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

/**
 *
 * @author Frederick
 */
public class PanelMetronomePedales extends javax.swing.JPanel {
    
    boolean enCours = false;
    
    static String m_statePedale1 = "off";
    static long m_timeStartPedale1;
    static long m_timeStopPedale1;
    
    static String m_statePedale2 = "off";
    static long m_timeStartPedale2;
    static long m_timeStopPedale2;
    
    static String m_statePedale3 = "off";
    static long m_timeStartPedale3;
    static long m_timeStopPedale3;
    
    static String m_statePedale4 = "off";
    static long m_timeStartPedale4;
    static long m_timeStopPedale4;
    
    static String m_statePedale5 = "off";
    static long m_timeStartPedale5;
    static long m_timeStopPedale5;
    
    static String m_statePedale6 = "off";
    static long m_timeStartPedale6;
    static long m_timeStopPedale6;
    
    static String m_statePedale7 = "off";
    static long m_timeStartPedale7;
    static long m_timeStopPedale7;
    
    static String m_statePedale8 = "off";
    static long m_timeStartPedale8;
    static long m_timeStopPedale8;
    
    static String m_statePedale9 = "off";
    static long m_timeStartPedale9;
    static long m_timeStopPedale9;
    
    PanelMetronomePedales(){
        timer.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(new PanelMetronomePedales.MyKeyListener());

    }
   
    Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Vue.m_metronome == true && enCours == false){
                    Runnable metro = new ThreadMétronome();
                    new Thread(metro).start();
                }
            }
            
    });
    
    
    private class MyKeyListener implements java.awt.event.KeyListener{

        

        @Override
        public void keyPressed(java.awt.event.KeyEvent ke) {
            
            if(ke.getKeyCode() == KeyEvent.VK_1){
                switch (m_statePedale1){
                    case "off" : 
                                m_timeStartPedale1 = System.nanoTime();      
                                m_statePedale1 = "rec";

                                 break;
                    case "rec" : 
                                 m_timeStopPedale1 = System.nanoTime();  
                                 m_statePedale1 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer1.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle1.clear();
                                 PanelJoueurInstrument.placeDansBoucle1 = 0;
                                 m_statePedale1 = "off";
                                 break;
                }

            }
            if(ke.getKeyCode() == KeyEvent.VK_2){
                switch (m_statePedale2){
                    case "off" : 
                                m_timeStartPedale2 = System.nanoTime(); 
                                m_statePedale2 = "rec";
                                 break;
                    case "rec" : 
                                 m_timeStopPedale2 = System.nanoTime();  
                                 m_statePedale2 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer2.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle2.clear();
                                 PanelJoueurInstrument.placeDansBoucle2 = 0;
                                 m_statePedale2 = "off";
                                 break;
                }

            }
            
            if(ke.getKeyCode() == KeyEvent.VK_3){
                switch (m_statePedale3){
                    case "off" : 
                                m_timeStartPedale3 = System.nanoTime(); 
                                m_statePedale3 = "rec";
                                 break;
                    case "rec" : 
                                 m_timeStopPedale3 = System.nanoTime();     
                                 m_statePedale3 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer3.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle3.clear();
                                 PanelJoueurInstrument.placeDansBoucle3 = 0;
                                 m_statePedale3 = "off";
                                 break;
                }

            }
            if(ke.getKeyCode() == KeyEvent.VK_4){
                switch (m_statePedale4){
                    case "off" : 
                                m_timeStartPedale4 = System.nanoTime();   
                                m_statePedale4 = "rec";
                                 break;
                    case "rec" : 
                                 m_timeStopPedale4 = System.nanoTime();     
                                 m_statePedale4 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer4.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle4.clear();
                                 PanelJoueurInstrument.placeDansBoucle4 = 0;
                                 m_statePedale4 = "off";
                                 break;
                }

            }
            if(ke.getKeyCode() == KeyEvent.VK_5){
                switch (m_statePedale5){
                    case "off" : 
                                m_timeStartPedale5 = System.nanoTime();   
                                m_statePedale5 = "rec";
                                 break;
                    case "rec" : 
                                 m_timeStopPedale5 = System.nanoTime();     
                                 m_statePedale5 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer5.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle5.clear();
                                 PanelJoueurInstrument.placeDansBoucle5 = 0;
                                 m_statePedale5 = "off";
                                 break;
                }

            }
            if(ke.getKeyCode() == KeyEvent.VK_6){
                switch (m_statePedale6){
                    case "off" : 
                                m_timeStartPedale6 = System.nanoTime();   
                                m_statePedale6 = "rec";
                                 break;
                    case "rec" : 
                                 m_timeStopPedale6 = System.nanoTime();     
                                 m_statePedale6 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer6.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle6.clear();
                                 PanelJoueurInstrument.placeDansBoucle6 = 0;
                                 m_statePedale6 = "off";
                                 break;
                }

            }
            if(ke.getKeyCode() == KeyEvent.VK_7){
                switch (m_statePedale7){
                    case "off" : 
                                m_timeStartPedale7 = System.nanoTime();   
                                m_statePedale7 = "rec";
                                 break;
                    case "rec" : 
                                 m_timeStopPedale7 = System.nanoTime();     
                                 m_statePedale7 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer7.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle7.clear();
                                 PanelJoueurInstrument.placeDansBoucle7 = 0;
                                 m_statePedale7 = "off";
                                 break;
                }

            }
            if(ke.getKeyCode() == KeyEvent.VK_8){
                switch (m_statePedale8){
                    case "off" : 
                                m_timeStartPedale8 = System.nanoTime();   
                                m_statePedale8 = "rec";
                                 break;
                    case "rec" : 
                                 m_timeStopPedale8 = System.nanoTime();     
                                 m_statePedale8 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer8.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle8.clear();
                                 PanelJoueurInstrument.placeDansBoucle8 = 0;
                                 m_statePedale8 = "off";
                                 break;
                }

            }
            if(ke.getKeyCode() == KeyEvent.VK_9){
                switch (m_statePedale9){
                    case "off" : 
                                m_timeStartPedale9 = System.nanoTime();   
                                m_statePedale9 = "rec";
                                 break;
                    case "rec" : 
                                 m_timeStopPedale9 = System.nanoTime();     
                                 m_statePedale9 = "play";
                                 break;
                    case "play": 
                                 PanelJoueurInstrument.v_TempsToucheAppuyer9.clear();
                                 PanelJoueurInstrument.v_ToucheJouerBoucle9.clear();
                                 PanelJoueurInstrument.placeDansBoucle9 = 0;
                                 m_statePedale9 = "off";
                                 break;
                }

            }
                
            
            
        }

        @Override
        public void keyTyped(java.awt.event.KeyEvent ke) {
            
        }

        @Override
        public void keyReleased(java.awt.event.KeyEvent ke) {
            
        }

        
    }

    
    public class ThreadMétronome implements Runnable {

        public ThreadMétronome() {
            super();

        }

        public void run() {

            
            while(Vue.m_metronome == true){
                enCours = true;
                Vue.m_controlleur.m_Channels[9].noteOn(75,20);
                try { Thread.sleep(100); // wait time in milliseconds to control duration
                } catch( InterruptedException e ) { }
                Vue.m_controlleur.m_Channels[9].allNotesOff();

                float Tempo = Vue.m_tempo;
                Tempo = (60/Tempo * 1000) - 100;
                int sleepTime = Math.round(Tempo);
                try { Thread.sleep(sleepTime); // wait time in milliseconds to control duration
                } catch( InterruptedException e ) { }
            
            }
        enCours = false;    
        }
            
        
    }
    
}
