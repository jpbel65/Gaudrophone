/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model;

import gaudrophone.Model.Instrument.InstrumentGuitarStrategy;
import gaudrophone.Model.Instrument.InstrumentStrategy;
import gaudrophone.Model.InterpreteurPiece.InterpreteurPiece;
/**
 *
 * @author Simon
 */
public class Model {
    
    private final ConteneurInstruments m_conteneurInstruments = new ConteneurInstruments();
    private final InterpreteurPiece    m_interpreteurPiece    = new InterpreteurPiece();
    private InstrumentStrategy m_instrumentStrategy;
    
    public Model(){
        m_instrumentStrategy = new InstrumentGuitarStrategy();
    }
    
    public void setGenerateurInstrumentStrategy(InstrumentStrategy p_instrumentStrategy){
        m_instrumentStrategy = p_instrumentStrategy;
    }
    
    public void genererGabaritInstrument(){
        int i = 1;
        
        String nomNouvelInstrument = "Nouvelle_Guitare";
        
        while(true){
            
            //Si contient deja un instrument ayant le non "NouvelInstrument1", "NouvelInstrument2" ... etc
            if (this.getConteneurInstruments().getListeInstruments().containsKey(nomNouvelInstrument + Integer.toString(i)))
            {
                i++;
            }
            else
            {
                nomNouvelInstrument = nomNouvelInstrument + Integer.toString(i);
                break;
            }
        }
        System.out.println(nomNouvelInstrument);
        m_conteneurInstruments.ajouterInstrument(m_instrumentStrategy.genererInstrument(nomNouvelInstrument));
    }
    
    public ConteneurInstruments getConteneurInstruments(){
        return m_conteneurInstruments;
    }
   
    public InterpreteurPiece getInterpreteurPiece(){
        return m_interpreteurPiece;
    }
}
