/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Instrument;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Luca
 */
public class InstrumentPianoStrategy implements InstrumentStrategy{
    @Override
    public Instrument genererInstrument(String p_nomInstrument){
        Instrument v_piano = new Instrument(){
            @Override
            public void peindreBackgroundInstrument(JPanel p_jPanel, Graphics p_graphics) {
                    
            }
        };
        
        v_piano.setNom("Nouveau_piano");
        
        v_piano.setTimbre(0);
        
        
        //Octave 0
        Touche v_t0 = new Touche();
        v_t0.setCouleur(Color.white);
        v_t0.setNom("TB00");
        v_t0.setNote(9);
        v_t0.setOctave(0);
        v_t0.setBordure(4);
        v_t0.getForme().setPositionRelativeX(0.033f);
        v_t0.getForme().setPositionRelativeY(0.35f);
        v_t0.getForme().setTailleRelativeX(0.016f);
        v_t0.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t0);
        
        Touche v_t1 = new Touche();
        v_t1.setCouleur(Color.white);
        v_t1.setNom("TB01");
        v_t1.setNote(11);
        v_t1.setOctave(0);
        v_t1.setBordure(4);
        v_t1.getForme().setPositionRelativeX(0.033f +  0.018f);
        v_t1.getForme().setPositionRelativeY(0.35f);
        v_t1.getForme().setTailleRelativeX(0.016f);
        v_t1.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t1);
        
        //Octave 1
        
        Touche v_t2 = new Touche();
        v_t2.setCouleur(Color.white);
        v_t2.setNom("TB02");
        v_t2.setNote(0);
        v_t2.setOctave(1);
        v_t2.setBordure(4);
        v_t2.getForme().setPositionRelativeX(0.033f +  0.036f);
        v_t2.getForme().setPositionRelativeY(0.35f);
        v_t2.getForme().setTailleRelativeX(0.016f);
        v_t2.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t2);
        
        Touche v_t3 = new Touche();
        v_t3.setCouleur(Color.white);
        v_t3.setNom("TB03");
        v_t3.setNote(2);
        v_t3.setOctave(1);
        v_t3.setBordure(4);
        v_t3.getForme().setPositionRelativeX(0.033f +  0.054f);
        v_t3.getForme().setPositionRelativeY(0.35f);
        v_t3.getForme().setTailleRelativeX(0.016f);
        v_t3.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t3);
        
        Touche v_t4 = new Touche();
        v_t4.setCouleur(Color.white);
        v_t4.setNom("TB04");
        v_t4.setNote(4);
        v_t4.setOctave(1);
        v_t4.setBordure(4);
        v_t4.getForme().setPositionRelativeX(0.033f +  0.072f);
        v_t4.getForme().setPositionRelativeY(0.35f);
        v_t4.getForme().setTailleRelativeX(0.016f);
        v_t4.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t4);
        
        
        Touche v_t5 = new Touche();
        v_t5.setCouleur(Color.white);
        v_t5.setNom("TB05");
        v_t5.setNote(5);
        v_t5.setOctave(1);
        v_t5.setBordure(4);
        v_t5.getForme().setPositionRelativeX(0.033f +  0.090f);
        v_t5.getForme().setPositionRelativeY(0.35f);
        v_t5.getForme().setTailleRelativeX(0.016f);
        v_t5.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t5);
        
        Touche v_t6 = new Touche();
        v_t6.setCouleur(Color.white);
        v_t6.setNom("TB06");
        v_t6.setNote(7);
        v_t6.setOctave(1);
        v_t6.setBordure(4);
        v_t6.getForme().setPositionRelativeX(0.033f +  0.108f);
        v_t6.getForme().setPositionRelativeY(0.35f);
        v_t6.getForme().setTailleRelativeX(0.016f);
        v_t6.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t6);
        
        Touche v_t7 = new Touche();
        v_t7.setCouleur(Color.white);
        v_t7.setNom("TB07");
        v_t7.setNote(9);
        v_t7.setOctave(1);
        v_t7.setBordure(4);
        v_t7.getForme().setPositionRelativeX(0.033f +  0.126f);
        v_t7.getForme().setPositionRelativeY(0.35f);
        v_t7.getForme().setTailleRelativeX(0.016f);
        v_t7.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t7);
        
        Touche v_t8 = new Touche();
        v_t8.setCouleur(Color.white);
        v_t8.setNom("TB08");
        v_t8.setNote(11);
        v_t8.setOctave(1);
        v_t8.setBordure(4);
        v_t8.getForme().setPositionRelativeX(0.033f +  0.144f);
        v_t8.getForme().setPositionRelativeY(0.35f);
        v_t8.getForme().setTailleRelativeX(0.016f);
        v_t8.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t8);
        
        //Octave 2
        
        Touche v_t9 = new Touche();
        v_t9.setCouleur(Color.white);
        v_t9.setNom("TB09");
        v_t9.setNote(0);
        v_t9.setOctave(2);
        v_t9.setBordure(4);
        v_t9.getForme().setPositionRelativeX(0.033f +  0.162f);
        v_t9.getForme().setPositionRelativeY(0.35f);
        v_t9.getForme().setTailleRelativeX(0.016f);
        v_t9.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t9);
        
        Touche v_t10 = new Touche();
        v_t10.setCouleur(Color.white);
        v_t10.setNom("TB10");
        v_t10.setNote(2);
        v_t10.setOctave(2);
        v_t10.setBordure(4);
        v_t10.getForme().setPositionRelativeX(0.033f +  0.180f);
        v_t10.getForme().setPositionRelativeY(0.35f);
        v_t10.getForme().setTailleRelativeX(0.016f);
        v_t10.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t10);
        
        Touche v_t11 = new Touche();
        v_t11.setCouleur(Color.white);
        v_t11.setNom("TB11");
        v_t11.setNote(4);
        v_t11.setOctave(2);
        v_t11.setBordure(4);
        v_t11.getForme().setPositionRelativeX(0.033f +  0.198f);
        v_t11.getForme().setPositionRelativeY(0.35f);
        v_t11.getForme().setTailleRelativeX(0.016f);
        v_t11.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t11);
        
        
        Touche v_t12 = new Touche();
        v_t12.setCouleur(Color.white);
        v_t12.setNom("TB12");
        v_t12.setNote(5);
        v_t12.setOctave(2);
        v_t12.setBordure(4);
        v_t12.getForme().setPositionRelativeX(0.033f +  0.216f);
        v_t12.getForme().setPositionRelativeY(0.35f);
        v_t12.getForme().setTailleRelativeX(0.016f);
        v_t12.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t12);
        
        Touche v_t13 = new Touche();
        v_t13.setCouleur(Color.white);
        v_t13.setNom("TB13");
        v_t13.setNote(7);
        v_t13.setOctave(2);
        v_t13.setBordure(4);
        v_t13.getForme().setPositionRelativeX(0.033f +  0.234f);
        v_t13.getForme().setPositionRelativeY(0.35f);
        v_t13.getForme().setTailleRelativeX(0.016f);
        v_t13.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t13);
        
        Touche v_t14 = new Touche();
        v_t14.setCouleur(Color.white);
        v_t14.setNom("TB14");
        v_t14.setNote(9);
        v_t14.setOctave(2);
        v_t14.setBordure(4);
        v_t14.getForme().setPositionRelativeX(0.033f +  0.252f);
        v_t14.getForme().setPositionRelativeY(0.35f);
        v_t14.getForme().setTailleRelativeX(0.016f);
        v_t14.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t14);
        
        Touche v_t15 = new Touche();
        v_t15.setCouleur(Color.white);
        v_t15.setNom("TB15");
        v_t15.setNote(11);
        v_t15.setOctave(2);
        v_t15.setBordure(4);
        v_t15.getForme().setPositionRelativeX(0.033f +  0.270f);
        v_t15.getForme().setPositionRelativeY(0.35f);
        v_t15.getForme().setTailleRelativeX(0.016f);
        v_t15.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t15);
        
        //Octave 3
        
        Touche v_t16 = new Touche();
        v_t16.setCouleur(Color.white);
        v_t16.setNom("TB16");
        v_t16.setNote(0);
        v_t16.setOctave(3);
        v_t16.setBordure(4);
        v_t16.getForme().setPositionRelativeX(0.033f +  0.288f);
        v_t16.getForme().setPositionRelativeY(0.35f);
        v_t16.getForme().setTailleRelativeX(0.016f);
        v_t16.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t16);
        
        Touche v_t17 = new Touche();
        v_t17.setCouleur(Color.white);
        v_t17.setNom("TB17");
        v_t17.setNote(2);
        v_t17.setOctave(3);
        v_t17.setBordure(4);
        v_t17.getForme().setPositionRelativeX(0.033f +  0.306f);
        v_t17.getForme().setPositionRelativeY(0.35f);
        v_t17.getForme().setTailleRelativeX(0.016f);
        v_t17.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t17);
        
        Touche v_t18 = new Touche();
        v_t18.setCouleur(Color.white);
        v_t18.setNom("TB18");
        v_t18.setNote(4);
        v_t18.setOctave(3);
        v_t18.setBordure(4);
        v_t18.getForme().setPositionRelativeX(0.033f +  0.324f);
        v_t18.getForme().setPositionRelativeY(0.35f);
        v_t18.getForme().setTailleRelativeX(0.016f);
        v_t18.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t18);
        
        
        Touche v_t19 = new Touche();
        v_t19.setCouleur(Color.white);
        v_t19.setNom("TB19");
        v_t19.setNote(5);
        v_t19.setOctave(3);
        v_t19.setBordure(4);
        v_t19.getForme().setPositionRelativeX(0.033f +  0.342f);
        v_t19.getForme().setPositionRelativeY(0.35f);
        v_t19.getForme().setTailleRelativeX(0.016f);
        v_t19.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t19);
        
        Touche v_t20 = new Touche();
        v_t20.setCouleur(Color.white);
        v_t20.setNom("TB20");
        v_t20.setNote(7);
        v_t20.setOctave(3);
        v_t20.setBordure(4);
        v_t20.getForme().setPositionRelativeX(0.033f +  0.360f);
        v_t20.getForme().setPositionRelativeY(0.35f);
        v_t20.getForme().setTailleRelativeX(0.016f);
        v_t20.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t20);
        
        Touche v_t21 = new Touche();
        v_t21.setCouleur(Color.white);
        v_t21.setNom("TB21");
        v_t21.setNote(9);
        v_t21.setOctave(3);
        v_t21.setBordure(4);
        v_t21.getForme().setPositionRelativeX(0.033f +  0.378f);
        v_t21.getForme().setPositionRelativeY(0.35f);
        v_t21.getForme().setTailleRelativeX(0.016f);
        v_t21.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t21);
        
        Touche v_t22 = new Touche();
        v_t22.setCouleur(Color.white);
        v_t22.setNom("TB22");
        v_t22.setNote(11);
        v_t22.setOctave(3);
        v_t22.setBordure(4);
        v_t22.getForme().setPositionRelativeX(0.033f +  0.396f);
        v_t22.getForme().setPositionRelativeY(0.35f);
        v_t22.getForme().setTailleRelativeX(0.016f);
        v_t22.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t22);
        
        //Octave 4
        
        Touche v_t23 = new Touche();
        v_t23.setCouleur(Color.white);
        v_t23.setNom("TB23");
        v_t23.setNote(0);
        v_t23.setOctave(4);
        v_t23.setBordure(4);
        v_t23.getForme().setPositionRelativeX(0.033f +  0.414f);
        v_t23.getForme().setPositionRelativeY(0.35f);
        v_t23.getForme().setTailleRelativeX(0.016f);
        v_t23.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t23);
        
        Touche v_t24 = new Touche();
        v_t24.setCouleur(Color.white);
        v_t24.setNom("TB24");
        v_t24.setNote(2);
        v_t24.setOctave(4);
        v_t24.setBordure(4);
        v_t24.getForme().setPositionRelativeX(0.033f +  0.432f);
        v_t24.getForme().setPositionRelativeY(0.35f);
        v_t24.getForme().setTailleRelativeX(0.016f);
        v_t24.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t24);
        
        Touche v_t25 = new Touche();
        v_t25.setCouleur(Color.white);
        v_t25.setNom("TB25");
        v_t25.setNote(4);
        v_t25.setOctave(4);
        v_t25.setBordure(4);
        v_t25.getForme().setPositionRelativeX(0.033f +  0.450f);
        v_t25.getForme().setPositionRelativeY(0.35f);
        v_t25.getForme().setTailleRelativeX(0.016f);
        v_t25.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t25);
        
        
        Touche v_t26 = new Touche();
        v_t26.setCouleur(Color.white);
        v_t26.setNom("TB26");
        v_t26.setNote(5);
        v_t26.setOctave(4);
        v_t26.setBordure(4);
        v_t26.getForme().setPositionRelativeX(0.033f +  0.468f);
        v_t26.getForme().setPositionRelativeY(0.35f);
        v_t26.getForme().setTailleRelativeX(0.016f);
        v_t26.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t26);
        
        Touche v_t27 = new Touche();
        v_t27.setCouleur(Color.white);
        v_t27.setNom("TB27");
        v_t27.setNote(7);
        v_t27.setOctave(4);
        v_t27.setBordure(4);
        v_t27.getForme().setPositionRelativeX(0.033f +  0.486f);
        v_t27.getForme().setPositionRelativeY(0.35f);
        v_t27.getForme().setTailleRelativeX(0.016f);
        v_t27.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t27);
        
        Touche v_t28 = new Touche();
        v_t28.setCouleur(Color.white);
        v_t28.setNom("TB28");
        v_t28.setNote(9);
        v_t28.setOctave(4);
        v_t28.setBordure(4);
        v_t28.getForme().setPositionRelativeX(0.033f +  0.504f);
        v_t28.getForme().setPositionRelativeY(0.35f);
        v_t28.getForme().setTailleRelativeX(0.016f);
        v_t28.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t28);
        
        Touche v_t29 = new Touche();
        v_t29.setCouleur(Color.white);
        v_t29.setNom("TB29");
        v_t29.setNote(11);
        v_t29.setOctave(4);
        v_t29.setBordure(4);
        v_t29.getForme().setPositionRelativeX(0.033f +  0.522f);
        v_t29.getForme().setPositionRelativeY(0.35f);
        v_t29.getForme().setTailleRelativeX(0.016f);
        v_t29.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t29);
        
        //Octave 5
        
        Touche v_t30 = new Touche();
        v_t30.setCouleur(Color.white);
        v_t30.setNom("TB30");
        v_t30.setNote(0);
        v_t30.setOctave(5);
        v_t30.setBordure(4);
        v_t30.getForme().setPositionRelativeX(0.033f +  0.540f);
        v_t30.getForme().setPositionRelativeY(0.35f);
        v_t30.getForme().setTailleRelativeX(0.016f);
        v_t30.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t30);
        
        Touche v_t31 = new Touche();
        v_t31.setCouleur(Color.white);
        v_t31.setNom("TB31");
        v_t31.setNote(2);
        v_t31.setOctave(5);
        v_t31.setBordure(4);
        v_t31.getForme().setPositionRelativeX(0.033f +  0.558f);
        v_t31.getForme().setPositionRelativeY(0.35f);
        v_t31.getForme().setTailleRelativeX(0.016f);
        v_t31.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t31);
        
        Touche v_t32 = new Touche();
        v_t32.setCouleur(Color.white);
        v_t32.setNom("TB32");
        v_t32.setNote(4);
        v_t32.setOctave(5);
        v_t32.setBordure(4);
        v_t32.getForme().setPositionRelativeX(0.033f +  0.576f);
        v_t32.getForme().setPositionRelativeY(0.35f);
        v_t32.getForme().setTailleRelativeX(0.016f);
        v_t32.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t32);
        
        
        Touche v_t33 = new Touche();
        v_t33.setCouleur(Color.white);
        v_t33.setNom("TB33");
        v_t33.setNote(5);
        v_t33.setOctave(5);
        v_t33.setBordure(4);
        v_t33.getForme().setPositionRelativeX(0.033f +  0.594f);
        v_t33.getForme().setPositionRelativeY(0.35f);
        v_t33.getForme().setTailleRelativeX(0.016f);
        v_t33.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t33);
        
        Touche v_t34 = new Touche();
        v_t34.setCouleur(Color.white);
        v_t34.setNom("TB34");
        v_t34.setNote(7);
        v_t34.setOctave(5);
        v_t34.setBordure(4);
        v_t34.getForme().setPositionRelativeX(0.033f +  0.612f);
        v_t34.getForme().setPositionRelativeY(0.35f);
        v_t34.getForme().setTailleRelativeX(0.016f);
        v_t34.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t34);
        
        Touche v_t35 = new Touche();
        v_t35.setCouleur(Color.white);
        v_t35.setNom("TB35");
        v_t35.setNote(9);
        v_t35.setOctave(5);
        v_t35.setBordure(4);
        v_t35.getForme().setPositionRelativeX(0.033f +  0.630f);
        v_t35.getForme().setPositionRelativeY(0.35f);
        v_t35.getForme().setTailleRelativeX(0.016f);
        v_t35.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t35);
        
        Touche v_t36 = new Touche();
        v_t36.setCouleur(Color.white);
        v_t36.setNom("TB36");
        v_t36.setNote(11);
        v_t36.setOctave(5);
        v_t36.setBordure(4);
        v_t36.getForme().setPositionRelativeX(0.033f +  0.648f);
        v_t36.getForme().setPositionRelativeY(0.35f);
        v_t36.getForme().setTailleRelativeX(0.016f);
        v_t36.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t36);
        
        //Octave 6
        
        Touche v_t37 = new Touche();
        v_t37.setCouleur(Color.white);
        v_t37.setNom("TB37");
        v_t37.setNote(0);
        v_t37.setOctave(6);
        v_t37.setBordure(4);
        v_t37.getForme().setPositionRelativeX(0.033f +  0.666f);
        v_t37.getForme().setPositionRelativeY(0.35f);
        v_t37.getForme().setTailleRelativeX(0.016f);
        v_t37.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t37);
        
        Touche v_t38 = new Touche();
        v_t38.setCouleur(Color.white);
        v_t38.setNom("TB38");
        v_t38.setNote(2);
        v_t38.setOctave(6);
        v_t38.setBordure(4);
        v_t38.getForme().setPositionRelativeX(0.033f +  0.684f);
        v_t38.getForme().setPositionRelativeY(0.35f);
        v_t38.getForme().setTailleRelativeX(0.016f);
        v_t38.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t38);
        
        Touche v_t39 = new Touche();
        v_t39.setCouleur(Color.white);
        v_t39.setNom("TB39");
        v_t39.setNote(4);
        v_t39.setOctave(6);
        v_t39.setBordure(4);
        v_t39.getForme().setPositionRelativeX(0.033f +  0.702f);
        v_t39.getForme().setPositionRelativeY(0.35f);
        v_t39.getForme().setTailleRelativeX(0.016f);
        v_t39.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t39);
        
        
        Touche v_t40 = new Touche();
        v_t40.setCouleur(Color.white);
        v_t40.setNom("TB40");
        v_t40.setNote(5);
        v_t40.setOctave(6);
        v_t40.setBordure(4);
        v_t40.getForme().setPositionRelativeX(0.033f +  0.720f);
        v_t40.getForme().setPositionRelativeY(0.35f);
        v_t40.getForme().setTailleRelativeX(0.016f);
        v_t40.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t40);
        
        Touche v_t41 = new Touche();
        v_t41.setCouleur(Color.white);
        v_t41.setNom("TB41");
        v_t41.setNote(7);
        v_t41.setOctave(6);
        v_t41.setBordure(4);
        v_t41.getForme().setPositionRelativeX(0.033f +  0.738f);
        v_t41.getForme().setPositionRelativeY(0.35f);
        v_t41.getForme().setTailleRelativeX(0.016f);
        v_t41.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t41);
        
        Touche v_t42 = new Touche();
        v_t42.setCouleur(Color.white);
        v_t42.setNom("TB42");
        v_t42.setNote(9);
        v_t42.setOctave(6);
        v_t42.setBordure(4);
        v_t42.getForme().setPositionRelativeX(0.033f +  0.756f);
        v_t42.getForme().setPositionRelativeY(0.35f);
        v_t42.getForme().setTailleRelativeX(0.016f);
        v_t42.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t42);
        
        Touche v_t43 = new Touche();
        v_t43.setCouleur(Color.white);
        v_t43.setNom("TB43");
        v_t43.setNote(11);
        v_t43.setOctave(6);
        v_t43.setBordure(4);
        v_t43.getForme().setPositionRelativeX(0.033f +  0.774f);
        v_t43.getForme().setPositionRelativeY(0.35f);
        v_t43.getForme().setTailleRelativeX(0.016f);
        v_t43.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t43);
        
        //Octave 7
        
        Touche v_t44 = new Touche();
        v_t44.setCouleur(Color.white);
        v_t44.setNom("TB44");
        v_t44.setNote(0);
        v_t44.setOctave(7);
        v_t44.setBordure(4);
        v_t44.getForme().setPositionRelativeX(0.033f +  0.792f);
        v_t44.getForme().setPositionRelativeY(0.35f);
        v_t44.getForme().setTailleRelativeX(0.016f);
        v_t44.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t44);
        
        Touche v_t45 = new Touche();
        v_t45.setCouleur(Color.white);
        v_t45.setNom("TB45");
        v_t45.setNote(2);
        v_t45.setOctave(7);
        v_t45.setBordure(4);
        v_t45.getForme().setPositionRelativeX(0.033f +  0.810f);
        v_t45.getForme().setPositionRelativeY(0.35f);
        v_t45.getForme().setTailleRelativeX(0.016f);
        v_t45.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t45);
        
        Touche v_t46 = new Touche();
        v_t46.setCouleur(Color.white);
        v_t46.setNom("TB46");
        v_t46.setNote(4);
        v_t46.setOctave(7);
        v_t46.setBordure(4);
        v_t46.getForme().setPositionRelativeX(0.033f +  0.828f);
        v_t46.getForme().setPositionRelativeY(0.35f);
        v_t46.getForme().setTailleRelativeX(0.016f);
        v_t46.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t46);
        
        
        Touche v_t47 = new Touche();
        v_t47.setCouleur(Color.white);
        v_t47.setNom("TB47");
        v_t47.setNote(5);
        v_t47.setOctave(7);
        v_t47.setBordure(4);
        v_t47.getForme().setPositionRelativeX(0.033f +  0.846f);
        v_t47.getForme().setPositionRelativeY(0.35f);
        v_t47.getForme().setTailleRelativeX(0.016f);
        v_t47.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t47);
        
        Touche v_t48 = new Touche();
        v_t48.setCouleur(Color.white);
        v_t48.setNom("TB48");
        v_t48.setNote(7);
        v_t48.setOctave(7);
        v_t48.setBordure(4);
        v_t48.getForme().setPositionRelativeX(0.033f +  0.864f);
        v_t48.getForme().setPositionRelativeY(0.35f);
        v_t48.getForme().setTailleRelativeX(0.016f);
        v_t48.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t48);
        
        Touche v_t49 = new Touche();
        v_t49.setCouleur(Color.white);
        v_t49.setNom("TB49");
        v_t49.setNote(9);
        v_t49.setOctave(7);
        v_t49.setBordure(4);
        v_t49.getForme().setPositionRelativeX(0.033f +  0.882f);
        v_t49.getForme().setPositionRelativeY(0.35f);
        v_t49.getForme().setTailleRelativeX(0.016f);
        v_t49.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t49);
        
        Touche v_t50 = new Touche();
        v_t50.setCouleur(Color.white);
        v_t50.setNom("TB50");
        v_t50.setNote(11);
        v_t50.setOctave(7);
        v_t50.setBordure(4);
        v_t50.getForme().setPositionRelativeX(0.033f +  0.900f);
        v_t50.getForme().setPositionRelativeY(0.35f);
        v_t50.getForme().setTailleRelativeX(0.016f);
        v_t50.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t50);
        
        //Octave 8
        
        Touche v_t51 = new Touche();
        v_t51.setCouleur(Color.white);
        v_t51.setNom("TB51");
        v_t51.setNote(0);
        v_t51.setOctave(8);
        v_t51.setBordure(4);
        v_t51.getForme().setPositionRelativeX(0.033f +  0.918f);
        v_t51.getForme().setPositionRelativeY(0.35f);
        v_t51.getForme().setTailleRelativeX(0.016f);
        v_t51.getForme().setTailleRelativeY(0.30f);
        v_piano.ajouterTouche(v_t51);
        
        //Touches noires
        
        //Octave 0
        Touche v_t52 = new Touche();
        v_t52.setCouleur(Color.black);
        v_t52.setNom("TN00");
        v_t52.setNote(10);
        v_t52.setOctave(0);
        v_t52.setBordure(4);
        v_t52.getForme().setPositionRelativeX(0.033f +  0.011f);
        v_t52.getForme().setPositionRelativeY(0.35f);
        v_t52.getForme().setTailleRelativeX(0.012f);
        v_t52.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t52);
        
        //Octave 1
        
        Touche v_t53 = new Touche();
        v_t53.setCouleur(Color.black);
        v_t53.setNom("TN01");
        v_t53.setNote(1);
        v_t53.setOctave(1);
        v_t53.setBordure(4);
        v_t53.getForme().setPositionRelativeX(0.033f +  0.047f);
        v_t53.getForme().setPositionRelativeY(0.35f);
        v_t53.getForme().setTailleRelativeX(0.012f);
        v_t53.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t53);
        
        Touche v_t54 = new Touche();
        v_t54.setCouleur(Color.black);
        v_t54.setNom("TN02");
        v_t54.setNote(3);
        v_t54.setOctave(1);
        v_t54.setBordure(4);
        v_t54.getForme().setPositionRelativeX(0.033f +  0.065f);
        v_t54.getForme().setPositionRelativeY(0.35f);
        v_t54.getForme().setTailleRelativeX(0.012f);
        v_t54.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t54);
        
        Touche v_t55 = new Touche();
        v_t55.setCouleur(Color.black);
        v_t55.setNom("TN03");
        v_t55.setNote(6);
        v_t55.setOctave(1);
        v_t55.setBordure(4);
        v_t55.getForme().setPositionRelativeX(0.033f +  0.101f);
        v_t55.getForme().setPositionRelativeY(0.35f);
        v_t55.getForme().setTailleRelativeX(0.012f);
        v_t55.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t55);
        
        Touche v_t56 = new Touche();
        v_t56.setCouleur(Color.black);
        v_t56.setNom("TN04");
        v_t56.setNote(8);
        v_t56.setOctave(1);
        v_t56.setBordure(4);
        v_t56.getForme().setPositionRelativeX(0.033f +  0.119f);
        v_t56.getForme().setPositionRelativeY(0.35f);
        v_t56.getForme().setTailleRelativeX(0.012f);
        v_t56.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t56);
        
        Touche v_t57 = new Touche();
        v_t57.setCouleur(Color.black);
        v_t57.setNom("TN05");
        v_t57.setNote(10);
        v_t57.setOctave(1);
        v_t57.setBordure(4);
        v_t57.getForme().setPositionRelativeX(0.033f +  0.137f);
        v_t57.getForme().setPositionRelativeY(0.35f);
        v_t57.getForme().setTailleRelativeX(0.012f);
        v_t57.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t57);
        
        //Octave 2
        
        Touche v_t58 = new Touche();
        v_t58.setCouleur(Color.black);
        v_t58.setNom("TN06");
        v_t58.setNote(1);
        v_t58.setOctave(2);
        v_t58.setBordure(4);
        v_t58.getForme().setPositionRelativeX(0.033f +  0.173f);
        v_t58.getForme().setPositionRelativeY(0.35f);
        v_t58.getForme().setTailleRelativeX(0.012f);
        v_t58.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t58);
        
        Touche v_t59 = new Touche();
        v_t59.setCouleur(Color.black);
        v_t59.setNom("TN07");
        v_t59.setNote(3);
        v_t59.setOctave(2);
        v_t59.setBordure(4);
        v_t59.getForme().setPositionRelativeX(0.033f +  0.191f);
        v_t59.getForme().setPositionRelativeY(0.35f);
        v_t59.getForme().setTailleRelativeX(0.012f);
        v_t59.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t59);
        
        Touche v_t60 = new Touche();
        v_t60.setCouleur(Color.black);
        v_t60.setNom("TN08");
        v_t60.setNote(6);
        v_t60.setOctave(2);
        v_t60.setBordure(4);
        v_t60.getForme().setPositionRelativeX(0.033f +  0.227f);
        v_t60.getForme().setPositionRelativeY(0.35f);
        v_t60.getForme().setTailleRelativeX(0.012f);
        v_t60.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t60);
        
        Touche v_t61 = new Touche();
        v_t61.setCouleur(Color.black);
        v_t61.setNom("TN09");
        v_t61.setNote(8);
        v_t61.setOctave(2);
        v_t61.setBordure(4);
        v_t61.getForme().setPositionRelativeX(0.033f +  0.245f);
        v_t61.getForme().setPositionRelativeY(0.35f);
        v_t61.getForme().setTailleRelativeX(0.012f);
        v_t61.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t61);
        
        Touche v_t62 = new Touche();
        v_t62.setCouleur(Color.black);
        v_t62.setNom("TN10");
        v_t62.setNote(10);
        v_t62.setOctave(2);
        v_t62.setBordure(4);
        v_t62.getForme().setPositionRelativeX(0.033f +  0.263f);
        v_t62.getForme().setPositionRelativeY(0.35f);
        v_t62.getForme().setTailleRelativeX(0.012f);
        v_t62.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t62);
        
        //Octave 3
        
        Touche v_t63 = new Touche();
        v_t63.setCouleur(Color.black);
        v_t63.setNom("TN11");
        v_t63.setNote(1);
        v_t63.setOctave(3);
        v_t63.setBordure(4);
        v_t63.getForme().setPositionRelativeX(0.033f +  0.299f);
        v_t63.getForme().setPositionRelativeY(0.35f);
        v_t63.getForme().setTailleRelativeX(0.012f);
        v_t63.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t63);
        
        Touche v_t64 = new Touche();
        v_t64.setCouleur(Color.black);
        v_t64.setNom("TN12");
        v_t64.setNote(3);
        v_t64.setOctave(3);
        v_t64.setBordure(4);
        v_t64.getForme().setPositionRelativeX(0.033f +  0.317f);
        v_t64.getForme().setPositionRelativeY(0.35f);
        v_t64.getForme().setTailleRelativeX(0.012f);
        v_t64.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t64);
        
        Touche v_t65 = new Touche();
        v_t65.setCouleur(Color.black);
        v_t65.setNom("TN13");
        v_t65.setNote(6);
        v_t65.setOctave(3);
        v_t65.setBordure(4);
        v_t65.getForme().setPositionRelativeX(0.033f +  0.353f);
        v_t65.getForme().setPositionRelativeY(0.35f);
        v_t65.getForme().setTailleRelativeX(0.012f);
        v_t65.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t65);
        
        Touche v_t66 = new Touche();
        v_t66.setCouleur(Color.black);
        v_t66.setNom("TN14");
        v_t66.setNote(8);
        v_t66.setOctave(3);
        v_t66.setBordure(4);
        v_t66.getForme().setPositionRelativeX(0.033f +  0.371f);
        v_t66.getForme().setPositionRelativeY(0.35f);
        v_t66.getForme().setTailleRelativeX(0.012f);
        v_t66.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t66);
        
        Touche v_t67 = new Touche();
        v_t67.setCouleur(Color.black);
        v_t67.setNom("TN15");
        v_t67.setNote(10);
        v_t67.setOctave(3);
        v_t67.setBordure(4);
        v_t67.getForme().setPositionRelativeX(0.033f +  0.389f);
        v_t67.getForme().setPositionRelativeY(0.35f);
        v_t67.getForme().setTailleRelativeX(0.012f);
        v_t67.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t67);
        
        //Octave 4
        
        Touche v_t68 = new Touche();
        v_t68.setCouleur(Color.black);
        v_t68.setNom("TN16");
        v_t68.setNote(1);
        v_t68.setOctave(4);
        v_t68.setBordure(4);
        v_t68.getForme().setPositionRelativeX(0.033f +  0.425f);
        v_t68.getForme().setPositionRelativeY(0.35f);
        v_t68.getForme().setTailleRelativeX(0.012f);
        v_t68.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t68);
        
        Touche v_t69 = new Touche();
        v_t69.setCouleur(Color.black);
        v_t69.setNom("TN17");
        v_t69.setNote(3);
        v_t69.setOctave(4);
        v_t69.setBordure(4);
        v_t69.getForme().setPositionRelativeX(0.033f +  0.443f);
        v_t69.getForme().setPositionRelativeY(0.35f);
        v_t69.getForme().setTailleRelativeX(0.012f);
        v_t69.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t69);
        
        Touche v_t70 = new Touche();
        v_t70.setCouleur(Color.black);
        v_t70.setNom("TN18");
        v_t70.setNote(6);
        v_t70.setOctave(4);
        v_t70.setBordure(4);
        v_t70.getForme().setPositionRelativeX(0.033f +  0.479f);
        v_t70.getForme().setPositionRelativeY(0.35f);
        v_t70.getForme().setTailleRelativeX(0.012f);
        v_t70.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t70);
        
        Touche v_t71 = new Touche();
        v_t71.setCouleur(Color.black);
        v_t71.setNom("TN19");
        v_t71.setNote(8);
        v_t71.setOctave(4);
        v_t71.setBordure(4);
        v_t71.getForme().setPositionRelativeX(0.033f +  0.497f);
        v_t71.getForme().setPositionRelativeY(0.35f);
        v_t71.getForme().setTailleRelativeX(0.012f);
        v_t71.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t71);
        
        Touche v_t72 = new Touche();
        v_t72.setCouleur(Color.black);
        v_t72.setNom("TN20");
        v_t72.setNote(10);
        v_t72.setOctave(4);
        v_t72.setBordure(4);
        v_t72.getForme().setPositionRelativeX(0.033f +  0.515f);
        v_t72.getForme().setPositionRelativeY(0.35f);
        v_t72.getForme().setTailleRelativeX(0.012f);
        v_t72.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t72);
        
        //Octave 5
        
        Touche v_t73 = new Touche();
        v_t73.setCouleur(Color.black);
        v_t73.setNom("TN21");
        v_t73.setNote(1);
        v_t73.setOctave(5);
        v_t73.setBordure(4);
        v_t73.getForme().setPositionRelativeX(0.033f +  0.551f);
        v_t73.getForme().setPositionRelativeY(0.35f);
        v_t73.getForme().setTailleRelativeX(0.012f);
        v_t73.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t73);
        
        Touche v_t74 = new Touche();
        v_t74.setCouleur(Color.black);
        v_t74.setNom("TN22");
        v_t74.setNote(3);
        v_t74.setOctave(5);
        v_t74.setBordure(4);
        v_t74.getForme().setPositionRelativeX(0.033f +  0.569f);
        v_t74.getForme().setPositionRelativeY(0.35f);
        v_t74.getForme().setTailleRelativeX(0.012f);
        v_t74.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t74);
        
        Touche v_t75 = new Touche();
        v_t75.setCouleur(Color.black);
        v_t75.setNom("TN23");
        v_t75.setNote(6);
        v_t75.setOctave(5);
        v_t75.setBordure(4);
        v_t75.getForme().setPositionRelativeX(0.033f +  0.605f);
        v_t75.getForme().setPositionRelativeY(0.35f);
        v_t75.getForme().setTailleRelativeX(0.012f);
        v_t75.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t75);
        
        Touche v_t76 = new Touche();
        v_t76.setCouleur(Color.black);
        v_t76.setNom("TN24");
        v_t76.setNote(8);
        v_t76.setOctave(5);
        v_t76.setBordure(4);
        v_t76.getForme().setPositionRelativeX(0.033f +  0.623f);
        v_t76.getForme().setPositionRelativeY(0.35f);
        v_t76.getForme().setTailleRelativeX(0.012f);
        v_t76.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t76);
        
        Touche v_t77 = new Touche();
        v_t77.setCouleur(Color.black);
        v_t77.setNom("TN25");
        v_t77.setNote(10);
        v_t77.setOctave(5);
        v_t77.setBordure(4);
        v_t77.getForme().setPositionRelativeX(0.033f +  0.641f);
        v_t77.getForme().setPositionRelativeY(0.35f);
        v_t77.getForme().setTailleRelativeX(0.012f);
        v_t77.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t77);
        
        //Octave 6
        
        Touche v_t78 = new Touche();
        v_t78.setCouleur(Color.black);
        v_t78.setNom("TN26");
        v_t78.setNote(1);
        v_t78.setOctave(6);
        v_t78.setBordure(4);
        v_t78.getForme().setPositionRelativeX(0.033f +  0.677f);
        v_t78.getForme().setPositionRelativeY(0.35f);
        v_t78.getForme().setTailleRelativeX(0.012f);
        v_t78.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t78);
        
        Touche v_t79 = new Touche();
        v_t79.setCouleur(Color.black);
        v_t79.setNom("TN27");
        v_t79.setNote(3);
        v_t79.setOctave(6);
        v_t79.setBordure(4);
        v_t79.getForme().setPositionRelativeX(0.033f +  0.695f);
        v_t79.getForme().setPositionRelativeY(0.35f);
        v_t79.getForme().setTailleRelativeX(0.012f);
        v_t79.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t79);
        
        Touche v_t80 = new Touche();
        v_t80.setCouleur(Color.black);
        v_t80.setNom("TN28");
        v_t80.setNote(6);
        v_t80.setOctave(6);
        v_t80.setBordure(4);
        v_t80.getForme().setPositionRelativeX(0.033f +  0.731f);
        v_t80.getForme().setPositionRelativeY(0.35f);
        v_t80.getForme().setTailleRelativeX(0.012f);
        v_t80.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t80);
        
        Touche v_t81 = new Touche();
        v_t81.setCouleur(Color.black);
        v_t81.setNom("TN29");
        v_t81.setNote(8);
        v_t81.setOctave(6);
        v_t81.setBordure(4);
        v_t81.getForme().setPositionRelativeX(0.033f +  0.749f);
        v_t81.getForme().setPositionRelativeY(0.35f);
        v_t81.getForme().setTailleRelativeX(0.012f);
        v_t81.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t81);
        
        Touche v_t82 = new Touche();
        v_t82.setCouleur(Color.black);
        v_t82.setNom("TN30");
        v_t82.setNote(10);
        v_t82.setOctave(6);
        v_t82.setBordure(4);
        v_t82.getForme().setPositionRelativeX(0.033f +  0.767f);
        v_t82.getForme().setPositionRelativeY(0.35f);
        v_t82.getForme().setTailleRelativeX(0.012f);
        v_t82.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t82);
        
        //Octave 7
        
        Touche v_t83 = new Touche();
        v_t83.setCouleur(Color.black);
        v_t83.setNom("TN31");
        v_t83.setNote(1);
        v_t83.setOctave(7);
        v_t83.setBordure(4);
        v_t83.getForme().setPositionRelativeX(0.033f +  0.803f);
        v_t83.getForme().setPositionRelativeY(0.35f);
        v_t83.getForme().setTailleRelativeX(0.012f);
        v_t83.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t83);
        
        Touche v_t84 = new Touche();
        v_t84.setCouleur(Color.black);
        v_t84.setNom("TN32");
        v_t84.setNote(3);
        v_t84.setOctave(7);
        v_t84.setBordure(4);
        v_t84.getForme().setPositionRelativeX(0.033f +  0.821f);
        v_t84.getForme().setPositionRelativeY(0.35f);
        v_t84.getForme().setTailleRelativeX(0.012f);
        v_t84.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t84);
        
        Touche v_t85 = new Touche();
        v_t85.setCouleur(Color.black);
        v_t85.setNom("TN33");
        v_t85.setNote(6);
        v_t85.setOctave(7);
        v_t85.setBordure(4);
        v_t85.getForme().setPositionRelativeX(0.033f +  0.857f);
        v_t85.getForme().setPositionRelativeY(0.35f);
        v_t85.getForme().setTailleRelativeX(0.012f);
        v_t85.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t85);
        
        Touche v_t86 = new Touche();
        v_t86.setCouleur(Color.black);
        v_t86.setNom("TN34");
        v_t86.setNote(8);
        v_t86.setOctave(7);
        v_t86.setBordure(4);
        v_t86.getForme().setPositionRelativeX(0.033f +  0.875f);
        v_t86.getForme().setPositionRelativeY(0.35f);
        v_t86.getForme().setTailleRelativeX(0.012f);
        v_t86.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t86);
        
        Touche v_t87 = new Touche();
        v_t87.setCouleur(Color.black);
        v_t87.setNom("TN35");
        v_t87.setNote(10);
        v_t87.setOctave(7);
        v_t87.setBordure(4);
        v_t87.getForme().setPositionRelativeX(0.033f +  0.893f);
        v_t87.getForme().setPositionRelativeY(0.35f);
        v_t87.getForme().setTailleRelativeX(0.012f);
        v_t87.getForme().setTailleRelativeY(0.15f);
        v_piano.ajouterTouche(v_t87);
        
        return v_piano;
    }
}
