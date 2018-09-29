/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Vue;

import gaudrophone.Model.Instrument.Touche;
import static gaudrophone.Vue.Vue.m_controlleur;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author jpbel
 */
public class testThread implements Runnable {
        private final int m_pulse;
        private int m_PositionMusic;
        private final javax.swing.JPanel m_panel;
        private final javax.swing.JTable m_table;
        private final javax.swing.JComboBox m_CBox;
        private javax.swing.JProgressBar m_jProgressBar1;
        
        public testThread(int p_positionMusic,int p_pulse,javax.swing.JPanel p_panel,javax.swing.JTable p_table,javax.swing.JComboBox p_CBox,javax.swing.JProgressBar p_jProgressBar1) {
            super();
            m_jProgressBar1 = p_jProgressBar1;
            m_PositionMusic = p_positionMusic;
            m_pulse = p_pulse;
            m_panel = p_panel;
            m_table = p_table;
            m_CBox = p_CBox;
        }
        
        public int getPositionMusic(){
            return m_PositionMusic;
        }

        public void run() {
            m_jProgressBar1.setMaximum(m_table.getColumnCount());//set prodression barre
            m_jProgressBar1.setMinimum(0);
            for(;m_PositionMusic<m_table.getColumnCount();++m_PositionMusic){
                m_jProgressBar1.setValue(m_PositionMusic);
                List<String> v_noteAJouer = new ArrayList<String>();
                for(int i = 0;i<m_table.getRowCount()-1;++i){//trouve les notes qui devrons etre jouer

                    v_noteAJouer.add((String)m_table.getValueAt(i, m_PositionMusic));
                    System.out.print(m_table.getValueAt(i, m_PositionMusic)+"\n");
                }
                Collection<Touche> v_touche = m_controlleur.getInstrumentActif().getConteneurTouches().getSetTouche().values();
                List<Touche> v_touche2 = new ArrayList<Touche>();
                v_touche.forEach((str)->{
                    v_touche2.add(str);
                });
                List<Touche> v_toucheAJouer = new ArrayList<Touche>();
                for(int i = 0;i<v_noteAJouer.size();++i){
                    for(int j =0; j < v_touche2.size();++j){
                        Touche v_toucheCourante = v_touche2.get(j);
                        String lol = (String)m_CBox.getItemAt(v_toucheCourante.getNote())+v_toucheCourante.getOctave();
                        //System.out.print(lol+"\n");
                        if(v_noteAJouer.get(i).equalsIgnoreCase(lol)){
                            v_toucheAJouer.add(v_toucheCourante);
                            System.out.print(v_toucheCourante.getNom()+"\n");
                            break;
                        }
                    }
                }
                for(int i = 0;i<v_toucheAJouer.size();++i){//les touche a jouer sont dans la list
                    Runnable r = new MyThread(v_toucheAJouer.get(i));
                    new Thread(r).start();
                }
                String temps = (String)m_table.getValueAt(3, m_PositionMusic);//a completer faut gere les temps dans la colonne 4
                if(temps.equals("_"));
                long tempsdd = m_pulse*1000/60;
                try {
                    Thread.sleep(tempsdd);
                } catch (InterruptedException ex) {
                    
                }
            }
        }
        public class MyThread implements Runnable {

            private final Touche m_touche;

            public MyThread(Touche p_touche) {//thread pour chaque touche meme code que pour le panel jouer instrument
                super();
                m_touche = p_touche;
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
                    Vue.m_controlleur.m_Channels[Timbre].noteOn(Valeur_Synth,100);

                    float persistance = m_touche.getPersistance();
                    int sleepTime = Math.round(persistance*1000);

                    try{
                        /*int i = 0;
                        while(!v_pressedOut){
                            Thread.sleep(1);
                            i++;
                        }
                        if (i < sleepTime){
                            Thread.sleep(sleepTime-i);
                        }*/
                        Thread.sleep(sleepTime);
                    }
                    catch(Exception e){

                    }
                }
                else{
                    try{
                        AudioInputStream ais = AudioSystem.getAudioInputStream(new File(m_touche.getFichierAudio()));
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
                m_touche.setCouleur(v_ancienneCouleur);
                m_panel.repaint();
                m_touche.setThread(false);
            }
        }
    }
