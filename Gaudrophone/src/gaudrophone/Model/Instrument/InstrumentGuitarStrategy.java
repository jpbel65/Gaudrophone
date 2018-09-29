/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Instrument;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Simon
 */
public class InstrumentGuitarStrategy implements InstrumentStrategy{
    
    @Override
    public Instrument genererInstrument(String p_nomInstrument){
        System.out.println(p_nomInstrument);
        Instrument v_guitare = new Instrument(){
            @Override
            public void peindreBackgroundInstrument(JPanel p_jPanel, Graphics p_graphics) {
//                Graphics2D v_g2d = (Graphics2D) p_graphics; 
//                
//                int v_largeurAbsolue = p_jPanel.getWidth();
//                int v_hauteurAbsolue = p_jPanel.getHeight();
//                
//                float v_hauteurRelativeCorde1 = 0.2f + (0.0f * 0.12f);
//                float v_hauteurRelativeCorde2 = 0.2f + (1.0f * 0.12f);
//                float v_hauteurRelativeCorde3 = 0.2f + (2.0f * 0.12f);
//                float v_hauteurRelativeCorde4 = 0.2f + (3.0f * 0.12f);
//                float v_hauteurRelativeCorde5 = 0.2f + (4.0f * 0.12f);
//                float v_hauteurRelativeCorde6 = 0.2f + (5.0f * 0.12f);
//                
//                int v_hauteurAbsolueCorde1    = (int)((float)v_hauteurAbsolue * v_hauteurRelativeCorde1);
//                int v_hauteurAbsolueCorde2    = (int)((float)v_hauteurAbsolue * v_hauteurRelativeCorde2);
//                int v_hauteurAbsolueCorde3    = (int)((float)v_hauteurAbsolue * v_hauteurRelativeCorde3);
//                int v_hauteurAbsolueCorde4    = (int)((float)v_hauteurAbsolue * v_hauteurRelativeCorde4);
//                int v_hauteurAbsolueCorde5    = (int)((float)v_hauteurAbsolue * v_hauteurRelativeCorde5);
//                int v_hauteurAbsolueCorde6    = (int)((float)v_hauteurAbsolue * v_hauteurRelativeCorde6);
//                
//                v_g2d.setPaint(new Color(0f, 0f, 0f, 0.8f));
//                
//                v_g2d.setStroke(new BasicStroke(2));
//                v_g2d.drawLine(0, v_hauteurAbsolueCorde1, v_largeurAbsolue, v_hauteurAbsolueCorde1);
//                v_g2d.setStroke(new BasicStroke(4));
//                v_g2d.drawLine(0, v_hauteurAbsolueCorde2, v_largeurAbsolue, v_hauteurAbsolueCorde2);
//                v_g2d.setStroke(new BasicStroke(6));
//                v_g2d.drawLine(0, v_hauteurAbsolueCorde3, v_largeurAbsolue, v_hauteurAbsolueCorde3);
//                v_g2d.setStroke(new BasicStroke(8));
//                v_g2d.drawLine(0, v_hauteurAbsolueCorde4, v_largeurAbsolue, v_hauteurAbsolueCorde4);
//                v_g2d.setStroke(new BasicStroke(10));
//                v_g2d.drawLine(0, v_hauteurAbsolueCorde5, v_largeurAbsolue, v_hauteurAbsolueCorde5);
//                v_g2d.setStroke(new BasicStroke(12));
//                v_g2d.drawLine(0, v_hauteurAbsolueCorde6, v_largeurAbsolue, v_hauteurAbsolueCorde6);
//                        
//                v_g2d.setStroke(new BasicStroke(5));
                
            }
            
        };
        
        //Set le nom de l'instrument, préalablement choisi comme unique 
        v_guitare.setNom(p_nomInstrument);
        
        //Set le timbre, 1 veut dire timbre de guitare
        v_guitare.setTimbre(1);
        
        Touche v_tBase1 = new Touche();
        v_tBase1.setNom("C1BASE");
        v_tBase1.setNote(4);
        v_tBase1.setOctave(4);
        v_tBase1.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_tBase1.setBordure(10);
        v_tBase1.getForme().setPositionRelativeX(0.05f);
        v_tBase1.getForme().setPositionRelativeY(0.15f);
        v_tBase1.getForme().setTailleRelativeX(0.06f);
        v_tBase1.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_tBase1);
        
        Touche v_t1 = new Touche();
        v_t1.setNom("C1T1");
        v_t1.setNote(5);
        v_t1.setOctave(4);
        v_t1.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t1.setBordure(10);
        v_t1.getForme().setPositionRelativeX(0.11f);
        v_t1.getForme().setPositionRelativeY(0.15f);
        v_t1.getForme().setTailleRelativeX(0.06f);
        v_t1.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t1);
        
        Touche v_t2 = new Touche();
        v_t2.setNom("C1T2");
        v_t2.setNote(6);
        v_t2.setOctave(4);
        v_t2.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t2.setBordure(10);
        v_t2.getForme().setPositionRelativeX(0.17f);
        v_t2.getForme().setPositionRelativeY(0.15f);
        v_t2.getForme().setTailleRelativeX(0.06f);
        v_t2.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t2);
        
        Touche v_t3 = new Touche();
        v_t3.setNom("C1T3");
        v_t3.setNote(7);
        v_t3.setOctave(4);
        v_t3.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t3.setBordure(10);
        v_t3.getForme().setPositionRelativeX(0.23f);
        v_t3.getForme().setPositionRelativeY(0.15f);
        v_t3.getForme().setTailleRelativeX(0.06f);
        v_t3.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t3);
        
        Touche v_t4 = new Touche();
        v_t4.setNom("C1T4");
        v_t4.setNote(8);
        v_t4.setOctave(4);
        v_t4.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t4.setBordure(10);
        v_t4.getForme().setPositionRelativeX(0.29f);
        v_t4.getForme().setPositionRelativeY(0.15f);
        v_t4.getForme().setTailleRelativeX(0.06f);
        v_t4.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t4);
        
        Touche v_t5 = new Touche();
        v_t5.setNom("C1T5");
        v_t5.setNote(9);
        v_t5.setOctave(4);
        v_t5.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t5.setBordure(10);
        v_t5.getForme().setPositionRelativeX(0.35f);
        v_t5.getForme().setPositionRelativeY(0.15f);
        v_t5.getForme().setTailleRelativeX(0.06f);
        v_t5.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t5);
        
        Touche v_t6 = new Touche();
        v_t6.setNom("C1T6");
        v_t6.setNote(10);
        v_t6.setOctave(4);
        v_t6.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t6.setBordure(10);
        v_t6.getForme().setPositionRelativeX(0.41f);
        v_t6.getForme().setPositionRelativeY(0.15f);
        v_t6.getForme().setTailleRelativeX(0.06f);
        v_t6.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t6);
        
        Touche v_t7 = new Touche();
        v_t7.setNom("C1T7");
        v_t7.setNote(11);
        v_t7.setOctave(4);
        v_t7.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t7.setBordure(10);
        v_t7.getForme().setPositionRelativeX(0.47f);
        v_t7.getForme().setPositionRelativeY(0.15f);
        v_t7.getForme().setTailleRelativeX(0.06f);
        v_t7.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t7);
        
        Touche v_t8 = new Touche();
        v_t8.setNom("C1T8");
        v_t8.setNote(0);
        v_t8.setOctave(5);
        v_t8.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t8.setBordure(10);
        v_t8.getForme().setPositionRelativeX(0.53f);
        v_t8.getForme().setPositionRelativeY(0.15f);
        v_t8.getForme().setTailleRelativeX(0.06f);
        v_t8.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t8);
        
        Touche v_t9 = new Touche();
        v_t9.setNom("C1T9");
        v_t9.setNote(1);
        v_t9.setOctave(5);
        v_t9.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t9.setBordure(10);
        v_t9.getForme().setPositionRelativeX(0.59f);
        v_t9.getForme().setPositionRelativeY(0.15f);
        v_t9.getForme().setTailleRelativeX(0.06f);
        v_t9.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t9);
        
        Touche v_t10 = new Touche();
        v_t10.setNom("C1T_10");
        v_t10.setNote(2);
        v_t10.setOctave(5);
        v_t10.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t10.setBordure(10);
        v_t10.getForme().setPositionRelativeX(0.65f);
        v_t10.getForme().setPositionRelativeY(0.15f);
        v_t10.getForme().setTailleRelativeX(0.06f);
        v_t10.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t10);
        
        Touche v_t11 = new Touche();
        v_t11.setNom("C1T_11");
        v_t11.setNote(3);
        v_t11.setOctave(5);
        v_t11.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t11.setBordure(10);
        v_t11.getForme().setPositionRelativeX(0.71f);
        v_t11.getForme().setPositionRelativeY(0.15f);
        v_t11.getForme().setTailleRelativeX(0.06f);
        v_t11.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t11);
        
        Touche v_t12 = new Touche();
        v_t12.setNom("C1T_12");
        v_t12.setNote(4);
        v_t12.setOctave(5);
        v_t12.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t12.setBordure(10);
        v_t12.getForme().setPositionRelativeX(0.77f);
        v_t12.getForme().setPositionRelativeY(0.15f);
        v_t12.getForme().setTailleRelativeX(0.06f);
        v_t12.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t12);
        
///////////////////////////////////////////////////////////////        
        Touche v_tBase2 = new Touche();
        v_tBase2.setNom("C2BASE");
        v_tBase2.setNote(11);
        v_tBase2.setOctave(3);
        v_tBase2.setCouleur(Color.YELLOW);
        v_tBase2.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_tBase2.setBordure(10);
        v_tBase2.getForme().setPositionRelativeX(0.05f);
        v_tBase2.getForme().setPositionRelativeY(0.27f);
        v_tBase2.getForme().setTailleRelativeX(0.06f);
        v_tBase2.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_tBase2);


        Touche v_t13 = new Touche();
        v_t13.setNom("C2T1");
        v_t13.setNote(0);
        v_t13.setOctave(4);
        v_t13.setCouleur(Color.YELLOW);
        v_t13.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t13.setBordure(10);
        v_t13.getForme().setPositionRelativeX(0.11f);
        v_t13.getForme().setPositionRelativeY(0.27f);
        v_t13.getForme().setTailleRelativeX(0.06f);
        v_t13.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t13);
        
        Touche v_t14 = new Touche();
        v_t14.setNom("C2T2");
        v_t14.setNote(1);
        v_t14.setOctave(4);
        v_t14.setCouleur(Color.YELLOW);
        v_t14.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t14.setBordure(10);
        v_t14.getForme().setPositionRelativeX(0.17f);
        v_t14.getForme().setPositionRelativeY(0.27f);
        v_t14.getForme().setTailleRelativeX(0.06f);
        v_t14.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t14);
        
        Touche v_t15 = new Touche();
        v_t15.setNom("C2T3");
        v_t15.setNote(2);
        v_t15.setOctave(4);
        v_t15.setCouleur(Color.YELLOW);
        v_t15.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t15.setBordure(10);
        v_t15.getForme().setPositionRelativeX(0.23f);
        v_t15.getForme().setPositionRelativeY(0.27f);
        v_t15.getForme().setTailleRelativeX(0.06f);
        v_t15.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t15);
        
        Touche v_t16 = new Touche();
        v_t16.setNom("C2T4");
        v_t16.setNote(3);
        v_t16.setOctave(4);
        v_t16.setCouleur(Color.YELLOW);
        v_t16.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t16.setBordure(10);
        v_t16.getForme().setPositionRelativeX(0.29f);
        v_t16.getForme().setPositionRelativeY(0.27f);
        v_t16.getForme().setTailleRelativeX(0.06f);
        v_t16.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t16);
        
        Touche v_t17 = new Touche();
        v_t17.setNom("C2T5");
        v_t17.setNote(4);
        v_t17.setOctave(4);
        v_t17.setCouleur(Color.YELLOW);
        v_t17.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t17.setBordure(10);
        v_t17.getForme().setPositionRelativeX(0.35f);
        v_t17.getForme().setPositionRelativeY(0.27f);
        v_t17.getForme().setTailleRelativeX(0.06f);
        v_t17.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t17);
        
        Touche v_t18 = new Touche();
        v_t18.setNom("C2T6");
        v_t18.setNote(5);
        v_t18.setOctave(4);
        v_t18.setCouleur(Color.YELLOW);
        v_t18.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t18.setBordure(10);
        v_t18.getForme().setPositionRelativeX(0.41f);
        v_t18.getForme().setPositionRelativeY(0.27f);
        v_t18.getForme().setTailleRelativeX(0.06f);
        v_t18.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t18);
        
        Touche v_t19 = new Touche();
        v_t19.setNom("C2T7");
        v_t19.setNote(6);
        v_t19.setOctave(4);
        v_t19.setCouleur(Color.YELLOW);
        v_t19.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t19.setBordure(10);
        v_t19.getForme().setPositionRelativeX(0.47f);
        v_t19.getForme().setPositionRelativeY(0.27f);
        v_t19.getForme().setTailleRelativeX(0.06f);
        v_t19.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t19);
        
        Touche v_t20 = new Touche();
        v_t20.setNom("C2T8");
        v_t20.setNote(7);
        v_t20.setOctave(4);
        v_t20.setCouleur(Color.YELLOW);
        v_t20.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t20.setBordure(10);
        v_t20.getForme().setPositionRelativeX(0.53f);
        v_t20.getForme().setPositionRelativeY(0.27f);
        v_t20.getForme().setTailleRelativeX(0.06f);
        v_t20.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t20);
        
        Touche v_t21 = new Touche();
        v_t21.setNom("C2T9");
        v_t21.setNote(8);
        v_t21.setOctave(4);
        v_t21.setCouleur(Color.YELLOW);
        v_t21.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t21.setBordure(10);
        v_t21.getForme().setPositionRelativeX(0.59f);
        v_t21.getForme().setPositionRelativeY(0.27f);
        v_t21.getForme().setTailleRelativeX(0.06f);
        v_t21.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t21);
        
        Touche v_t22 = new Touche();
        v_t22.setNom("C2T_10");
        v_t22.setNote(9);
        v_t22.setOctave(4);
        v_t22.setCouleur(Color.YELLOW);
        v_t22.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t22.setBordure(10);
        v_t22.getForme().setPositionRelativeX(0.65f);
        v_t22.getForme().setPositionRelativeY(0.27f);
        v_t22.getForme().setTailleRelativeX(0.06f);
        v_t22.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t22);
        
        Touche v_t23 = new Touche();
        v_t23.setNom("C2T_11");
        v_t23.setNote(10);
        v_t23.setOctave(4);
        v_t23.setCouleur(Color.YELLOW);
        v_t23.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t23.setBordure(10);
        v_t23.getForme().setPositionRelativeX(0.71f);
        v_t23.getForme().setPositionRelativeY(0.27f);
        v_t23.getForme().setTailleRelativeX(0.06f);
        v_t23.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t23);
        
        Touche v_t24 = new Touche();
        v_t24.setNom("C2T_12");
        v_t24.setNote(11);
        v_t24.setOctave(4);
        v_t24.setCouleur(Color.YELLOW);
        v_t24.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t24.setBordure(10);
        v_t24.getForme().setPositionRelativeX(0.77f);
        v_t24.getForme().setPositionRelativeY(0.27f);
        v_t24.getForme().setTailleRelativeX(0.06f);
        v_t24.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t24);
        
//////////////////////////////////////////////////////////////////////////

        Touche v_tBase3 = new Touche();
        v_tBase3.setNom("C3BASE");
        v_tBase3.setNote(7);
        v_tBase3.setOctave(3);
        v_tBase3.setCouleur(Color.GREEN);
        v_tBase3.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_tBase3.setBordure(10);
        v_tBase3.getForme().setPositionRelativeX(0.05f);
        v_tBase3.getForme().setPositionRelativeY(0.39f);
        v_tBase3.getForme().setTailleRelativeX(0.06f);
        v_tBase3.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_tBase3);

        Touche v_t25 = new Touche();
        v_t25.setNom("C3T1");
        v_t25.setNote(8);
        v_t25.setOctave(3);
        v_t25.setCouleur(Color.GREEN);
        v_t25.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t25.setBordure(10);
        v_t25.getForme().setPositionRelativeX(0.11f);
        v_t25.getForme().setPositionRelativeY(0.39f);
        v_t25.getForme().setTailleRelativeX(0.06f);
        v_t25.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t25);
        
        Touche v_t26 = new Touche();
        v_t26.setNom("C3T2");
        v_t26.setNote(9);
        v_t26.setOctave(3);
        v_t26.setCouleur(Color.GREEN);
        v_t26.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t26.setBordure(10);
        v_t26.getForme().setPositionRelativeX(0.17f);
        v_t26.getForme().setPositionRelativeY(0.39f);
        v_t26.getForme().setTailleRelativeX(0.06f);
        v_t26.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t26);
        
        Touche v_t27 = new Touche();
        v_t27.setNom("C3T3");
        v_t27.setNote(10);
        v_t27.setOctave(3);
        v_t27.setCouleur(Color.GREEN);
        v_t27.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t27.setBordure(10);
        v_t27.getForme().setPositionRelativeX(0.23f);
        v_t27.getForme().setPositionRelativeY(0.39f);
        v_t27.getForme().setTailleRelativeX(0.06f);
        v_t27.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t27);
        
        Touche v_t28 = new Touche();
        v_t28.setNom("C3T4");
        v_t28.setNote(11);
        v_t28.setOctave(3);
        v_t28.setCouleur(Color.GREEN);
        v_t28.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t28.setBordure(10);
        v_t28.getForme().setPositionRelativeX(0.29f);
        v_t28.getForme().setPositionRelativeY(0.39f);
        v_t28.getForme().setTailleRelativeX(0.06f);
        v_t28.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t28);
        
        Touche v_t29 = new Touche();
        v_t29.setNom("C3T5");
        v_t29.setNote(0);
        v_t29.setOctave(4);
        v_t29.setCouleur(Color.GREEN);
        v_t29.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t29.setBordure(10);
        v_t29.getForme().setPositionRelativeX(0.35f);
        v_t29.getForme().setPositionRelativeY(0.39f);
        v_t29.getForme().setTailleRelativeX(0.06f);
        v_t29.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t29);
        
        Touche v_t30 = new Touche();
        v_t30.setNom("C3T6");
        v_t30.setNote(1);
        v_t30.setOctave(4);
        v_t30.setCouleur(Color.GREEN);
        v_t30.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t30.setBordure(10);
        v_t30.getForme().setPositionRelativeX(0.41f);
        v_t30.getForme().setPositionRelativeY(0.39f);
        v_t30.getForme().setTailleRelativeX(0.06f);
        v_t30.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t30);
        
        Touche v_t31 = new Touche();
        v_t31.setNom("C3T7");
        v_t31.setNote(2);
        v_t31.setOctave(4);
        v_t31.setCouleur(Color.GREEN);
        v_t31.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t31.setBordure(10);
        v_t31.getForme().setPositionRelativeX(0.47f);
        v_t31.getForme().setPositionRelativeY(0.39f);
        v_t31.getForme().setTailleRelativeX(0.06f);
        v_t31.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t31);
        
        Touche v_t32 = new Touche();
        v_t32.setNom("C3T8");
        v_t32.setNote(3);
        v_t32.setOctave(4);
        v_t32.setCouleur(Color.GREEN);
        v_t32.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t32.setBordure(10);
        v_t32.getForme().setPositionRelativeX(0.53f);
        v_t32.getForme().setPositionRelativeY(0.39f);
        v_t32.getForme().setTailleRelativeX(0.06f);
        v_t32.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t32);
        
        Touche v_t33 = new Touche();
        v_t33.setNom("C3T9");
        v_t33.setNote(4);
        v_t33.setOctave(4);
        v_t33.setCouleur(Color.GREEN);
        v_t33.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t33.setBordure(10);
        v_t33.getForme().setPositionRelativeX(0.59f);
        v_t33.getForme().setPositionRelativeY(0.39f);
        v_t33.getForme().setTailleRelativeX(0.06f);
        v_t33.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t33);
        
        Touche v_t34 = new Touche();
        v_t34.setNom("C3T_10");
        v_t34.setNote(5);
        v_t34.setOctave(4);
        v_t34.setCouleur(Color.GREEN);
        v_t34.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t34.setBordure(10);
        v_t34.getForme().setPositionRelativeX(0.65f);
        v_t34.getForme().setPositionRelativeY(0.39f);
        v_t34.getForme().setTailleRelativeX(0.06f);
        v_t34.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t34);
        
        Touche v_t35 = new Touche();
        v_t35.setNom("C3T_11");
        v_t35.setNote(6);
        v_t35.setOctave(4);
        v_t35.setCouleur(Color.GREEN);
        v_t35.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t35.setBordure(10);
        v_t35.getForme().setPositionRelativeX(0.71f);
        v_t35.getForme().setPositionRelativeY(0.39f);
        v_t35.getForme().setTailleRelativeX(0.06f);
        v_t35.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t35);
        
        Touche v_t36 = new Touche();
        v_t36.setNom("C3T_12");
        v_t36.setNote(7);
        v_t36.setOctave(4);
        v_t36.setCouleur(Color.GREEN);
        v_t36.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t36.setBordure(10);
        v_t36.getForme().setPositionRelativeX(0.77f);
        v_t36.getForme().setPositionRelativeY(0.39f);
        v_t36.getForme().setTailleRelativeX(0.06f);
        v_t36.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t36);
        
///////////////////////////////////////////////////////////////        
        Touche v_tBase4 = new Touche();
        v_tBase4.setNom("C4BASE");
        v_tBase4.setNote(2);
        v_tBase4.setOctave(3);
        v_tBase4.setCouleur(Color.MAGENTA);
        v_tBase4.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_tBase4.setBordure(10);
        v_tBase4.getForme().setPositionRelativeX(0.05f);
        v_tBase4.getForme().setPositionRelativeY(0.51f);
        v_tBase4.getForme().setTailleRelativeX(0.06f);
        v_tBase4.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_tBase4);
        
        Touche v_t37 = new Touche();
        v_t37.setNom("C4T1");
        v_t37.setNote(3);
        v_t37.setOctave(3);
        v_t37.setCouleur(Color.MAGENTA);
        v_t37.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t37.setBordure(10);
        v_t37.getForme().setPositionRelativeX(0.11f);
        v_t37.getForme().setPositionRelativeY(0.51f);
        v_t37.getForme().setTailleRelativeX(0.06f);
        v_t37.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t37);
        
        Touche v_t38 = new Touche();
        v_t38.setNom("C4T2");
        v_t38.setNote(4);
        v_t38.setOctave(3);
        v_t38.setCouleur(Color.MAGENTA);
        v_t38.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t38.setBordure(10);
        v_t38.getForme().setPositionRelativeX(0.17f);
        v_t38.getForme().setPositionRelativeY(0.51f);
        v_t38.getForme().setTailleRelativeX(0.06f);
        v_t38.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t38);
        
        Touche v_t39 = new Touche();
        v_t39.setNom("C4T3");
        v_t39.setNote(5);
        v_t39.setOctave(3);
        v_t39.setCouleur(Color.MAGENTA);
        v_t39.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t39.setBordure(10);
        v_t39.getForme().setPositionRelativeX(0.23f);
        v_t39.getForme().setPositionRelativeY(0.51f);
        v_t39.getForme().setTailleRelativeX(0.06f);
        v_t39.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t39);
        
        Touche v_t40 = new Touche();
        v_t40.setNom("C4T4");
        v_t40.setNote(6);
        v_t40.setOctave(3);
        v_t40.setCouleur(Color.MAGENTA);
        v_t40.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t40.setBordure(10);
        v_t40.getForme().setPositionRelativeX(0.29f);
        v_t40.getForme().setPositionRelativeY(0.51f);
        v_t40.getForme().setTailleRelativeX(0.06f);
        v_t40.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t40);
        
        Touche v_t41 = new Touche();
        v_t41.setNom("C4T5");
        v_t41.setNote(7);
        v_t41.setOctave(3);
        v_t41.setCouleur(Color.MAGENTA);
        v_t41.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t41.setBordure(10);
        v_t41.getForme().setPositionRelativeX(0.35f);
        v_t41.getForme().setPositionRelativeY(0.51f);
        v_t41.getForme().setTailleRelativeX(0.06f);
        v_t41.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t41);
        
        Touche v_t42 = new Touche();
        v_t42.setNom("C4T6");
        v_t42.setNote(8);
        v_t42.setOctave(3);
        v_t42.setCouleur(Color.MAGENTA);
        v_t42.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t42.setBordure(10);
        v_t42.getForme().setPositionRelativeX(0.41f);
        v_t42.getForme().setPositionRelativeY(0.51f);
        v_t42.getForme().setTailleRelativeX(0.06f);
        v_t42.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t42);
        
        Touche v_t43 = new Touche();
        v_t43.setNom("C4T7");
        v_t43.setNote(9);
        v_t43.setOctave(3);
        v_t43.setCouleur(Color.MAGENTA);
        v_t43.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t43.setBordure(10);
        v_t43.getForme().setPositionRelativeX(0.47f);
        v_t43.getForme().setPositionRelativeY(0.51f);
        v_t43.getForme().setTailleRelativeX(0.06f);
        v_t43.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t43);
        
        Touche v_t44 = new Touche();
        v_t44.setNom("C4T8");
        v_t44.setNote(10);
        v_t44.setOctave(3);
        v_t44.setCouleur(Color.MAGENTA);
        v_t44.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t44.setBordure(10);
        v_t44.getForme().setPositionRelativeX(0.53f);
        v_t44.getForme().setPositionRelativeY(0.51f);
        v_t44.getForme().setTailleRelativeX(0.06f);
        v_t44.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t44);
        
        Touche v_t45 = new Touche();
        v_t45.setNom("C4T9");
        v_t45.setNote(11);
        v_t45.setOctave(3);
        v_t45.setCouleur(Color.MAGENTA);
        v_t45.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t45.setBordure(10);
        v_t45.getForme().setPositionRelativeX(0.59f);
        v_t45.getForme().setPositionRelativeY(0.51f);
        v_t45.getForme().setTailleRelativeX(0.06f);
        v_t45.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t45);
        
        Touche v_t46 = new Touche();
        v_t46.setNom("C4T_10");
        v_t46.setNote(0);
        v_t46.setOctave(4);
        v_t46.setCouleur(Color.MAGENTA);
        v_t46.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t46.setBordure(10);
        v_t46.getForme().setPositionRelativeX(0.65f);
        v_t46.getForme().setPositionRelativeY(0.51f);
        v_t46.getForme().setTailleRelativeX(0.06f);
        v_t46.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t46);
        
        Touche v_t47 = new Touche();
        v_t47.setNom("C4T_11");
        v_t47.setNote(1);
        v_t47.setOctave(4);
        v_t47.setCouleur(Color.MAGENTA);
        v_t47.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t47.setBordure(10);
        v_t47.getForme().setPositionRelativeX(0.71f);
        v_t47.getForme().setPositionRelativeY(0.51f);
        v_t47.getForme().setTailleRelativeX(0.06f);
        v_t47.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t47);
        
        Touche v_t48 = new Touche();
        v_t48.setNom("C4T_12");
        v_t48.setNote(2);
        v_t48.setOctave(4);
        v_t48.setCouleur(Color.MAGENTA);
        v_t48.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t48.setBordure(10);
        v_t48.getForme().setPositionRelativeX(0.77f);
        v_t48.getForme().setPositionRelativeY(0.51f);
        v_t48.getForme().setTailleRelativeX(0.06f);
        v_t48.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t48);
        
/////////////////////////////////////////////////////////////// 

        Touche v_tBase5 = new Touche();
        v_tBase5.setNom("C5BASE");
        v_tBase5.setNote(9);
        v_tBase5.setOctave(2);
        v_tBase5.setCouleur(Color.BLUE);
        v_tBase5.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_tBase5.setBordure(10);
        v_tBase5.getForme().setPositionRelativeX(0.05f);
        v_tBase5.getForme().setPositionRelativeY(0.63f);
        v_tBase5.getForme().setTailleRelativeX(0.06f);
        v_tBase5.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_tBase5);
        
        Touche v_t49 = new Touche();
        v_t49.setNom("C5T1");
        v_t49.setNote(10);
        v_t49.setOctave(2);
        v_t49.setCouleur(Color.BLUE);
        v_t49.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t49.setBordure(10);
        v_t49.getForme().setPositionRelativeX(0.11f);
        v_t49.getForme().setPositionRelativeY(0.63f);
        v_t49.getForme().setTailleRelativeX(0.06f);
        v_t49.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t49);
        
        Touche v_t50 = new Touche();
        v_t50.setNom("C5T2");
        v_t50.setNote(11);
        v_t50.setOctave(2);
        v_t50.setCouleur(Color.BLUE);
        v_t50.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t50.setBordure(10);
        v_t50.getForme().setPositionRelativeX(0.17f);
        v_t50.getForme().setPositionRelativeY(0.63f);
        v_t50.getForme().setTailleRelativeX(0.06f);
        v_t50.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t50);
        
        Touche v_t51 = new Touche();
        v_t51.setNom("C5T3");
        v_t51.setNote(0);
        v_t51.setOctave(3);
        v_t51.setCouleur(Color.BLUE);
        v_t51.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t51.setBordure(10);
        v_t51.getForme().setPositionRelativeX(0.23f);
        v_t51.getForme().setPositionRelativeY(0.63f);
        v_t51.getForme().setTailleRelativeX(0.06f);
        v_t51.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t51);
        
        Touche v_t52 = new Touche();
        v_t52.setNom("C5T4");
        v_t52.setNote(1);
        v_t52.setOctave(3);
        v_t52.setCouleur(Color.BLUE);
        v_t52.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t52.setBordure(10);
        v_t52.getForme().setPositionRelativeX(0.29f);
        v_t52.getForme().setPositionRelativeY(0.63f);
        v_t52.getForme().setTailleRelativeX(0.06f);
        v_t52.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t52);
        
        Touche v_t53 = new Touche();
        v_t53.setNom("C5T5");
        v_t53.setNote(2);
        v_t53.setOctave(3);
        v_t53.setCouleur(Color.BLUE);
        v_t53.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t53.setBordure(10);
        v_t53.getForme().setPositionRelativeX(0.35f);
        v_t53.getForme().setPositionRelativeY(0.63f);
        v_t53.getForme().setTailleRelativeX(0.06f);
        v_t53.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t53);
        
        Touche v_t54 = new Touche();
        v_t54.setNom("C5T6");
        v_t54.setNote(3);
        v_t54.setOctave(3);
        v_t54.setCouleur(Color.BLUE);
        v_t54.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t54.setBordure(10);
        v_t54.getForme().setPositionRelativeX(0.41f);
        v_t54.getForme().setPositionRelativeY(0.63f);
        v_t54.getForme().setTailleRelativeX(0.06f);
        v_t54.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t54);
        
        Touche v_t55 = new Touche();
        v_t55.setNom("C5T7");
        v_t55.setNote(4);
        v_t55.setOctave(3);
        v_t55.setCouleur(Color.BLUE);
        v_t55.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t55.setBordure(10);
        v_t55.getForme().setPositionRelativeX(0.47f);
        v_t55.getForme().setPositionRelativeY(0.63f);
        v_t55.getForme().setTailleRelativeX(0.06f);
        v_t55.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t55);
        
        Touche v_t56 = new Touche();
        v_t56.setNom("C5T8");
        v_t56.setNote(5);
        v_t56.setOctave(3);
        v_t56.setCouleur(Color.BLUE);
        v_t56.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t56.setBordure(10);
        v_t56.getForme().setPositionRelativeX(0.53f);
        v_t56.getForme().setPositionRelativeY(0.63f);
        v_t56.getForme().setTailleRelativeX(0.06f);
        v_t56.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t56);
        
        Touche v_t57 = new Touche();
        v_t57.setNom("C5T9");
        v_t57.setNote(6);
        v_t57.setOctave(3);
        v_t57.setCouleur(Color.BLUE);
        v_t57.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t57.setBordure(10);
        v_t57.getForme().setPositionRelativeX(0.59f);
        v_t57.getForme().setPositionRelativeY(0.63f);
        v_t57.getForme().setTailleRelativeX(0.06f);
        v_t57.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t57);
        
        Touche v_t58 = new Touche();
        v_t58.setNom("C5T_10");
        v_t58.setNote(7);
        v_t58.setOctave(3);
        v_t58.setCouleur(Color.BLUE);
        v_t58.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t58.setBordure(10);
        v_t58.getForme().setPositionRelativeX(0.65f);
        v_t58.getForme().setPositionRelativeY(0.63f);
        v_t58.getForme().setTailleRelativeX(0.06f);
        v_t58.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t58);
        
        Touche v_t59 = new Touche();
        v_t59.setNom("C5T_11");
        v_t59.setNote(8);
        v_t59.setOctave(3);
        v_t59.setCouleur(Color.BLUE);
        v_t59.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t59.setBordure(10);
        v_t59.getForme().setPositionRelativeX(0.71f);
        v_t59.getForme().setPositionRelativeY(0.63f);
        v_t59.getForme().setTailleRelativeX(0.06f);
        v_t59.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t59);
        
        Touche v_t60 = new Touche();
        v_t60.setNom("C5T_12");
        v_t60.setNote(9);
        v_t60.setOctave(3);
        v_t60.setCouleur(Color.BLUE);
        v_t60.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t60.setBordure(10);
        v_t60.getForme().setPositionRelativeX(0.77f);
        v_t60.getForme().setPositionRelativeY(0.63f);
        v_t60.getForme().setTailleRelativeX(0.06f);
        v_t60.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t60);
        
///////////////////////////////////////////////////////////////

        Touche v_tBase6 = new Touche();
        v_tBase6.setNom("C6BASE");
        v_tBase6.setNote(4);
        v_tBase6.setOctave(2);
        v_tBase6.setCouleur(Color.CYAN);
        v_tBase6.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_tBase6.setBordure(10);
        v_tBase6.getForme().setPositionRelativeX(0.05f);
        v_tBase6.getForme().setPositionRelativeY(0.75f);
        v_tBase6.getForme().setTailleRelativeX(0.06f);
        v_tBase6.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_tBase6);
        
        Touche v_t61 = new Touche();
        v_t61.setNom("C6T1");
        v_t61.setNote(5);
        v_t61.setOctave(2);
        v_t61.setCouleur(Color.CYAN);
        v_t61.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t61.setBordure(10);
        v_t61.getForme().setPositionRelativeX(0.11f);
        v_t61.getForme().setPositionRelativeY(0.75f);
        v_t61.getForme().setTailleRelativeX(0.06f);
        v_t61.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t61);
        
        Touche v_t62 = new Touche();
        v_t62.setNom("C6T2");
        v_t62.setNote(6);
        v_t62.setOctave(2);
        v_t62.setCouleur(Color.CYAN);
        v_t62.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t62.setBordure(10);
        v_t62.getForme().setPositionRelativeX(0.17f);
        v_t62.getForme().setPositionRelativeY(0.75f);
        v_t62.getForme().setTailleRelativeX(0.06f);
        v_t62.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t62);
        
        Touche v_t63 = new Touche();
        v_t63.setNom("C6T3");
        v_t63.setNote(7);
        v_t63.setOctave(2);
        v_t63.setCouleur(Color.CYAN);
        v_t63.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t63.setBordure(10);
        v_t63.getForme().setPositionRelativeX(0.23f);
        v_t63.getForme().setPositionRelativeY(0.75f);
        v_t63.getForme().setTailleRelativeX(0.06f);
        v_t63.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t63);
        
        Touche v_t64 = new Touche();
        v_t64.setNom("C6T4");
        v_t64.setNote(8);
        v_t64.setOctave(2);
        v_t64.setCouleur(Color.CYAN);
        v_t64.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t64.setBordure(10);
        v_t64.getForme().setPositionRelativeX(0.29f);
        v_t64.getForme().setPositionRelativeY(0.75f);
        v_t64.getForme().setTailleRelativeX(0.06f);
        v_t64.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t64);
        
        Touche v_t65 = new Touche();
        v_t65.setNom("C6T5");
        v_t65.setNote(9);
        v_t65.setOctave(2);
        v_t65.setCouleur(Color.CYAN);
        v_t65.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t65.setBordure(10);
        v_t65.getForme().setPositionRelativeX(0.35f);
        v_t65.getForme().setPositionRelativeY(0.75f);
        v_t65.getForme().setTailleRelativeX(0.06f);
        v_t65.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t65);
        
        Touche v_t66 = new Touche();
        v_t66.setNom("C6T6");
        v_t66.setNote(10);
        v_t66.setOctave(2);
        v_t66.setCouleur(Color.CYAN);
        v_t66.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t66.setBordure(10);
        v_t66.getForme().setPositionRelativeX(0.41f);
        v_t66.getForme().setPositionRelativeY(0.75f);
        v_t66.getForme().setTailleRelativeX(0.06f);
        v_t66.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t66);
        
        Touche v_t67 = new Touche();
        v_t67.setNom("C6T7");
        v_t67.setNote(11);
        v_t67.setOctave(2);
        v_t67.setCouleur(Color.CYAN);
        v_t67.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t67.setBordure(10);
        v_t67.getForme().setPositionRelativeX(0.47f);
        v_t67.getForme().setPositionRelativeY(0.75f);
        v_t67.getForme().setTailleRelativeX(0.06f);
        v_t67.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t67);
        
        Touche v_t68 = new Touche();
        v_t68.setNom("C6T8");
        v_t68.setNote(0);
        v_t68.setOctave(3);
        v_t68.setCouleur(Color.CYAN);
        v_t68.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t68.setBordure(10);
        v_t68.getForme().setPositionRelativeX(0.53f);
        v_t68.getForme().setPositionRelativeY(0.75f);
        v_t68.getForme().setTailleRelativeX(0.06f);
        v_t68.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t68);
        
        Touche v_t69 = new Touche();
        v_t69.setNom("C6T9");
        v_t69.setNote(1);
        v_t69.setOctave(3);
        v_t69.setCouleur(Color.CYAN);
        v_t69.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t69.setBordure(10);
        v_t69.getForme().setPositionRelativeX(0.59f);
        v_t69.getForme().setPositionRelativeY(0.75f);
        v_t69.getForme().setTailleRelativeX(0.06f);
        v_t69.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t69);
        
        Touche v_t70 = new Touche();
        v_t70.setNom("C6T_10");
        v_t70.setNote(2);
        v_t70.setOctave(3);
        v_t70.setCouleur(Color.CYAN);
        v_t70.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t70.setBordure(10);
        v_t70.getForme().setPositionRelativeX(0.65f);
        v_t70.getForme().setPositionRelativeY(0.75f);
        v_t70.getForme().setTailleRelativeX(0.06f);
        v_t70.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t70);
        
        Touche v_t71 = new Touche();
        v_t71.setNom("C6T_11");
        v_t71.setNote(3);
        v_t71.setOctave(3);
        v_t71.setCouleur(Color.CYAN);
        v_t71.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t71.setBordure(10);
        v_t71.getForme().setPositionRelativeX(0.71f);
        v_t71.getForme().setPositionRelativeY(0.75f);
        v_t71.getForme().setTailleRelativeX(0.06f);
        v_t71.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t71);
        
        Touche v_t72 = new Touche();
        v_t72.setNom("C6T_12");
        v_t72.setNote(4);
        v_t72.setOctave(3);
        v_t72.setCouleur(Color.CYAN);
        v_t72.setCouleurBordure(new Color(139/255f, 69/255f, 19/255f));
        v_t72.setBordure(10);
        v_t72.getForme().setPositionRelativeX(0.77f);
        v_t72.getForme().setPositionRelativeY(0.75f);
        v_t72.getForme().setTailleRelativeX(0.06f);
        v_t72.getForme().setTailleRelativeY(0.11f);
        v_guitare.ajouterTouche(v_t72);
        
///////////////////////////////////////////////////////////////
        return v_guitare;
    }
    
}
