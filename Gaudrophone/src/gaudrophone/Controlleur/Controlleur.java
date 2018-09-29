/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Controlleur;

import gaudrophone.Model.Model;
import gaudrophone.Model.Instrument.Touche;
import gaudrophone.Model.Instrument.Instrument;
import gaudrophone.Model.Instrument.InstrumentGuitarStrategy;
import gaudrophone.Model.Instrument.InstrumentPianoStrategy;
import javax.sound.midi.*;

import java.awt.Color;
import java.util.Set;
import java.util.ArrayList;
/**
 *
 * @author Simon
 */
public class Controlleur {
    private final Model m_model;
    public MidiChannel[] m_Channels;
    
    
    public Controlleur(){
        m_model = new Model();
        initSynth();
    }
    
    public Model getModel(){
        return m_model;
    }
 
//Instrument
    public void Nouveau_InstrumentActionPerformed(){
        m_model.getConteneurInstruments().creerInstrumentVierge();
    }
    public void Supprimer_InstrumentActionPerformed(String pNomInstrument){
        if(pNomInstrument == null){
            System.out.println("Aucun nom selectionné pour supprimer");
            return;
        }
        m_model.getConteneurInstruments().supprimerInstrument(pNomInstrument);
        
    }
    
    public void Enregistrer_Modifications_Instrument(){
        m_model.getConteneurInstruments().enregistrerModifications();
    }
    
    public void Changer_Instrument(String pNomInstrument){
        m_model.getConteneurInstruments().changerInstrumentActif(pNomInstrument);
    }
    
    public void Informations_instrument_modifiees(){
        m_model.getConteneurInstruments().traiterInformationInstrumentChangees();
    }

//Touche
    public void creerTouche(){
        m_model.getConteneurInstruments().getInstrumentActif().creerTouche();
    }
    
    public void changerToucheActiveDansListeTouche(String p_nomNouvelleToucheSelectionnee){
        if(p_nomNouvelleToucheSelectionnee == null){
        }
        
        if(m_model.getConteneurInstruments().getInstrumentActif() == null){
            
        }  
        else if(m_model.getConteneurInstruments().getInstrumentActif() != null)
            m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().changerToucheActive(p_nomNouvelleToucheSelectionnee);
        
    }

    public void supprimerToucheActiveDansListeTouche(String p_nomToucheASupprimer){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().supprimerToucheActive();
    }
    
    public Color getCouleurToucheActive(){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getCouleurToucheActive();
    }
    
    public void setCouleurToucheActive(Color p_nouvelleCouleur){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().setCouleurToucheActive(p_nouvelleCouleur);
    }
    
    public Color getCouleurBordureToucheActive(){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getCouleurBordureToucheActive();
    }
    
    public void setCouleurBordureToucheActive(Color p_nouvelleCouleur){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().setCouleurBordureToucheActive(p_nouvelleCouleur);
    }

//* Non-utilisé donc enlever si jamais utilisé à la fin du projet 
//    public int getBordureToucheActive(){
//        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getBordureToucheActive();
//    }
    
    public void setBordureToucheActive(int p_bordure){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().setBordureToucheActive(p_bordure);
    }
    
    public String getNomToucheActive(){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getNomToucheActive();
    }
    
    public String getNomInstrumentActif(){
        return m_model.getConteneurInstruments().getInstrumentActif().getNom();
    }
    
    public boolean setNomToucheActive(String p_ancienNom, String p_nouveauNom){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().setNomToucheActive(p_ancienNom, p_nouveauNom);
    }
    
    public void setOctaveToucheActive(int p_nouvelleOctave){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().setOctaveToucheActive(p_nouvelleOctave);
    }
    
    public int getOctaveToucheActive(){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getOctaveToucheActive();           
    }
    
    public void setNoteToucheActive(int p_nouvelleNote){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().setNote(p_nouvelleNote);
    }
    
    public int getNoteToucheActive(){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getNoteToucheActive();           
    }
    
    public boolean setNomInstrumentActif(String p_ancienNom, String p_nouveauNom){
        return m_model.getConteneurInstruments().setNomInstrumentActif(p_ancienNom, p_nouveauNom);
    }
    
    public void setTimbreInstrumentActif(int p_nouveauTimbre){
        m_model.getConteneurInstruments().getInstrumentActif().setTimbre(p_nouveauTimbre);
                
    }
    public void setPersistanceToucheActive(int p_nouvellePersistance){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().setPersistance(p_nouvellePersistance);  
    }
    
    public void setFichierAudioToucheActive(String p_fichierAudio){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().setFichierAudioToucheActive(p_fichierAudio);
    }
    
    public Set<String> getListeNomTouches(){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getListeNomTouches();
    }
    
    public Set<String> getListeNomInstruments(){
        return m_model.getConteneurInstruments().getListeNomInstruments();
    }
    
    public Touche getToucheActive(){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive();
    }
    
    public Instrument getInstrumentActif(){
        return m_model.getConteneurInstruments().getInstrumentActif();
    }
    

    
    public void changerAfficherNomTouche(boolean p_afficherNomTouche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().setAfficherNom(p_afficherNomTouche);
    }
    public void changerAfficherOctaveTouche(boolean p_afficherOctaveTouche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().setAfficherOctave(p_afficherOctaveTouche);
    }
    public void changerAfficherFrequenceTouche(boolean p_afficherFrequenceTouche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().setAfficherNote(p_afficherFrequenceTouche);
    }
    public void changerAfficherPersistanceTouche(boolean p_afficherPersistanceTouche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().setAfficherPersistance(p_afficherPersistanceTouche);
    }
    public void changerTailleXTouche(int p_tailleXTouche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().getForme().setTailleRelativeX((float)p_tailleXTouche/100.0f);
    }
    public void changerTailleYTouche(int p_tailleYTouche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().getForme().setTailleRelativeY((float)p_tailleYTouche/100.0f);
    }
    public void changerImageTouche(String p_nomImageTouche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().setImageDeFond(p_nomImageTouche);
    }
    public void changerFormeToucheActive(String p_formeTouche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().getToucheActive().setForme(p_formeTouche);
    }
    
    public void genererGabaritInstrument(String p_nomGabaritInstrument){
        System.out.println("NOM GABARIT : " + p_nomGabaritInstrument);
        
        if(p_nomGabaritInstrument.equalsIgnoreCase("guitare")){
            
            m_model.setGenerateurInstrumentStrategy(new InstrumentGuitarStrategy());
        }
        else if(p_nomGabaritInstrument.equalsIgnoreCase("piano")){
            m_model.setGenerateurInstrumentStrategy(new InstrumentPianoStrategy());
        }
        else{
            
        }
        
        m_model.genererGabaritInstrument();
    }
    
    public void importerInstrument(String v_fileName){
        
        Instrument v_instrument = m_model.getConteneurInstruments().m_importExportInstrument.importerInstrument(v_fileName);
        m_model.getConteneurInstruments().ajouterInstrument(v_instrument);
    }
    
    private void initSynth(){ 
    Synthesizer midiSynth = null;

        try{
            midiSynth = MidiSystem.getSynthesizer(); 
            midiSynth.open();
        } 
        catch (MidiUnavailableException e) {}

        javax.sound.midi.Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
        m_Channels = midiSynth.getChannels();
        midiSynth.loadInstrument(instr[0]);//load an instrument

        //Chaine de piano
        m_Channels[0].programChange(0);
        //Chaine de Guitare
        m_Channels[1].programChange(24);
        //Chaine de Flute
        m_Channels[2].programChange(73);  
    }

    public void AddInstruments(Instrument Import){
        m_model.getConteneurInstruments().ajouterInstrument(Import);
    }
    

    
    
    //Fonction appellée lorsque l'utilisateur choisit un fichier text valide
    //pour charger une pièce musicale.
    // return : int - status validité du parsing 0 = ok, 1=err
    public boolean chargerFichierPieceMusicale(java.io.File p_fichierPieceMusicale){
       return m_model.getInterpreteurPiece().chargerFichierPieceMusicale(p_fichierPieceMusicale);
    }
        
    public void rechercheTouche(String[] p_recherche, String p_typeRecherche){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().rechercheTouche(p_recherche, p_typeRecherche);
    }
    
    public void annulerRechercheTouche(){
        m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().annulerRechercheTouche();

    }
    
    public boolean partitionEstValide(ArrayList<ArrayList<String>> p_array){
        return m_model.getConteneurInstruments().getInstrumentActif().getConteneurTouches().partitionEstValide(p_array);
    } 
}
