/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Vue;

import PatternObserver.ConteneurInstrumentsObservable;
import PatternObserver.ConteneurInstrumentsObserveur;

import PatternObserver.ConteneurTouchesObservable;
import PatternObserver.ConteneurTouchesObserveur;

import gaudrophone.Controlleur.Controlleur;




import gaudrophone.Model.Instrument.Instrument;
import gaudrophone.Model.Instrument.Touche;

import java.util.LinkedList;
import java.util.Vector;
import java.util.Set;
import java.util.ArrayList;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.colorchooser.AbstractColorChooserPanel;


import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Simon
 */
public class Vue 
       extends javax.swing.JFrame 
       implements ConteneurInstrumentsObserveur,
                  ConteneurTouchesObserveur
    {
    JFileChooser m_instrumentFileChooser = new JFileChooser();
            
            
    private final JFileChooser m_piece_chooser = new JFileChooser();
    static Controlleur m_controlleur;
    
    boolean couleurTouche = false;
    boolean couleurBordure = false;
    int m_colonneJouer = 0;
    static int m_pulsation = 0;
    int m_temps = 0;
    Thread lol = null;
    testThread kol = null;
    
    String[] m_recherche;
    
    static boolean m_metronome = false;
    static int m_tempo = 100;
    
    public Vue(Controlleur pControlleur) {
        
        m_controlleur = pControlleur;
        pControlleur.getModel().getConteneurInstruments().ajouterObservateur(this);
        initComponents();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file", "xml");
        m_instrumentFileChooser.setFileFilter(filter);
    }
    
    
//<editor-fold defaultstate="collapsed" desc="Méthodes implémentées de l'interface «ConteneurInstrumentObservateur» du pattern observer">
    @Override
    public void notificationInstrumentCree(ConteneurInstrumentsObservable osb, Object p_argument){
        
        Vector<String> v_vecteurString = new Vector<>();
        
        for(String str : (Set<String>) p_argument){
            v_vecteurString.add(str);
        }
        
        jPanel_Appercu_Instrument.repaint();
        jList_Liste_Instruments.setListData(v_vecteurString); 
    }
    
    @Override
    public void notificationInstrumentSupprime(ConteneurInstrumentsObservable osb, Object arg){
        Vector<String> v = new Vector<>();
        Set<String> s = (Set<String>) arg;
        
        for(String st : s){
            v.add(st);
        }
        
        jPanel_Appercu_Instrument.repaint();
        jList_Liste_Instruments.setListData(v); 
        
    }
    
    @Override
    public void notificationInstrumentActifChange(ConteneurInstrumentsObservable p_observeur, Object p_argument){
        
        jPanel_Appercu_Instrument.repaint();
        
        if(p_argument == null){
            jTextField_Nom_Instrument.setText("");
            jTextField_Nom_Instrument.setEnabled(false);
            jComboBox_Timbre_Instrument.setEnabled(false);
            jButton_Supprimer_Instrument.setEnabled(false);
            jButton_Enregistrer_Instrument.setEnabled(false);
            
            jList_Liste_Touches.setListData(new Vector<String>());
            jList_Liste_Touches.setEnabled(false);
            jButton_Creer_Touche.setEnabled(false);
            jButton_Supprimer_Touche.setEnabled(false);
            jComboBox_Forme_Touche.setEnabled(false);
            jSlider_TailleX_Touche.setEnabled(false);
            jSlider_TailleY_Touche.setEnabled(false);
            jSpinner_Bordure.setEnabled(false);
            jButton_Couleur_Touche.setEnabled(false);
            jButton_Image_Touche.setEnabled(false);
            jTextField_Image_Touche.setText("");
            jTextField_Image_Touche.setEnabled(false);
            jTextField_Nom_Touche.setText("");
            jTextField_Nom_Touche.setEnabled(false);
            jSpinner_Octave_Touche.setEnabled(false);
            jComboBox_Note_Touche.setEnabled(false);  
            jSpinner_Persistance_Touche.setEnabled(false);
            jTextField_Fichier_Audio_Touche.setText("");
            jTextField_Fichier_Audio_Touche.setEnabled(false);
            jButton_Fichier_Audio_Touche.setEnabled(false);
            jCheckBox_Afficher_Nom_Touche.setSelected(false);
            jCheckBox_Afficher_Nom_Touche.setEnabled(false);
            jCheckBox_Afficher_Octave_Touche.setSelected(false);
            jCheckBox_Afficher_Octave_Touche.setEnabled(false);
            jCheckBox_Afficher_Frequence_Touche.setSelected(false);
            jCheckBox_Afficher_Frequence_Touche.setEnabled(false);
            jCheckBox_Afficher_Persistance_Touche.setSelected(false);
            jCheckBox_Afficher_Persistance_Touche.setEnabled(false);
            
            jColorChooser.setVisible(false);
            jTextField_Recherche.setText("");
            jTextField_Recherche.setEnabled(false);
            jComboBox_recherche.setEnabled(false);
            jButton_Annuler_Recherche.setEnabled(false);
        }
        else
        {
            
            Instrument v_instrument = (Instrument) p_argument;
            v_instrument.getConteneurTouches().ajouterObservateur(this);
            
            jTextField_Nom_Instrument.setEnabled(true);
            jTextField_Nom_Instrument.setText(v_instrument.getNom());
            jComboBox_Timbre_Instrument.setEnabled(true);
            jComboBox_Timbre_Instrument.setSelectedIndex(v_instrument.getTimbre());
            jButton_Supprimer_Instrument.setEnabled(true);
            jButton_Enregistrer_Instrument.setEnabled(true);
            jTextField_Recherche.setEnabled(true);
            
            Vector<String> v_vectorString = new Vector<>();
            v_instrument.getConteneurTouches().getListeNomTouches().forEach((v_string) -> {
                v_vectorString.add(v_string);
            });
            jList_Liste_Touches.setListData(v_vectorString);
            jList_Liste_Touches.setEnabled(true);
            jButton_Creer_Touche.setEnabled(true);
            jComboBox_recherche.setEnabled(true);
           
        }   
    }
    
    @Override
    public void notificationInstrumentActifModifie(ConteneurInstrumentsObservable osb, Object arg, int i){
        Vector<String> v = new Vector<>();
        LinkedList<String> s = (LinkedList<String>) arg;
        
        for(String st : s){
            v.add(st);
        }
        
        
        
        jList_Liste_Instruments.setListData(v); 
    }
//</editor-fold> 
  
//<editor-fold defaultstate="collapsed" desc="Méthodes implémentées de l'interface «ConteneurTouchesObservateur» du pattern observer">
    @Override
    public void notificationToucheCree(ConteneurTouchesObservable p_observable, Object p_argument){
        Vector<String> v_vecteurString = new Vector<>();
        
        for(String str : (Set<String>) p_argument){
            v_vecteurString.add(str);
        }
        
        jPanel_Appercu_Instrument.repaint();
        jList_Liste_Touches.setListData(v_vecteurString);
    }
    
    @Override
    public void notificationToucheSupprimee(ConteneurTouchesObservable p_observable, Object p_argument){
        Vector<String> v_vecteurString = new Vector<>();
        
        for(String str : (Set<String>) p_argument){
            v_vecteurString.add(str);
        }
        
        jPanel_Appercu_Instrument.repaint();
        jList_Liste_Touches.setListData(v_vecteurString);
    }
     
    @Override
    public void notificationToucheActiveChangee(ConteneurTouchesObservable p_observable, Object p_argument){
       
        jPanel_Appercu_Instrument.repaint();
        
        /**
         * Si Aucune Touche n'est sélectionnées. Ceci se produit si c'est le résultat d'un clic sur supprimer
         * touche, ce qui changera le contenu de la list pour le contenu updaté de la liste des touches. Ou bien
         * ça peut être car on a changé d'instrument, ce qui updatera aussi la liste des touches et du même coup
         * fera que la sélection de l'évènement sera nulle. Peut aussi être à cause qu'on a supprimé un instrument.
         */
        if(p_argument == null){
            jTextField_Image_Touche.setText("");
            
            jTextField_Nom_Touche.setText("");
            jSpinner_Octave_Touche.setValue(5);


            jTextField_Fichier_Audio_Touche.setText("");
            jCheckBox_Afficher_Nom_Touche.setSelected(false);
            jCheckBox_Afficher_Octave_Touche.setSelected(false);
            jCheckBox_Afficher_Frequence_Touche.setSelected(false);
            jCheckBox_Afficher_Persistance_Touche.setSelected(false);
            
            jButton_Supprimer_Touche.setEnabled(false);
            jComboBox_Forme_Touche.setEnabled(false);
            jSlider_TailleX_Touche.setEnabled(false);
            jSlider_TailleY_Touche.setEnabled(false);
            jSpinner_Bordure.setEnabled(false);
            jButton_Couleur_Touche.setEnabled(false);
            jButton_Image_Touche.setEnabled(false);
            jPanelCouleur.setBackground(Color.gray);
            jButton_Couleur_Bordure.setEnabled(false);
            jPanelCouleurBordure.setBackground(Color.gray);
            jTextField_Image_Touche.setEnabled(false);
            jTextField_Nom_Touche.setEnabled(false);
            jSpinner_Octave_Touche.setEnabled(false);
            jComboBox_Note_Touche.setEnabled(false);
            jSpinner_Persistance_Touche.setEnabled(false);
            jTextField_Fichier_Audio_Touche.setEnabled(false);
            jButton_Fichier_Audio_Touche.setEnabled(false);
            jCheckBox_Afficher_Nom_Touche.setEnabled(false);
            jCheckBox_Afficher_Octave_Touche.setEnabled(false);
            jCheckBox_Afficher_Frequence_Touche.setEnabled(false);
            jCheckBox_Afficher_Persistance_Touche.setEnabled(false);
            
            jColorChooser.setVisible(false);
        }
        else{
            Touche v_toucheActive = (Touche) p_argument;
            
            jTextField_Image_Touche.setText(v_toucheActive.getImageDeFond());
            
            jTextField_Nom_Touche.setText(v_toucheActive.getNom());
            jSpinner_Octave_Touche.setValue(v_toucheActive.getOctave());
            jSpinner_Bordure.setValue(v_toucheActive.getBordure());
            jComboBox_Note_Touche.setSelectedIndex((int)(v_toucheActive.getNote()));
            jSpinner_Persistance_Touche.setValue(v_toucheActive.getPersistance());
            jTextField_Fichier_Audio_Touche.setText(v_toucheActive.getFichierAudio());
            jCheckBox_Afficher_Nom_Touche.setSelected(v_toucheActive.getAfficherNom());
            jCheckBox_Afficher_Octave_Touche.setSelected(v_toucheActive.getAfficherOctave());
            jCheckBox_Afficher_Frequence_Touche.setSelected(v_toucheActive.getAfficherNote());
            jCheckBox_Afficher_Persistance_Touche.setSelected(v_toucheActive.getAfficherPersistance());
            jPanelCouleur.setBackground(v_toucheActive.getCouleur());
            jPanelCouleurBordure.setBackground(v_toucheActive.getCouleurBordure());
            
            //TODO afficher reste des informations de la touche (apparence)
           
            jSlider_TailleX_Touche.setValue((int)(v_toucheActive.getForme().getTailleRelativeX() * 100.0f));
            jSlider_TailleY_Touche.setValue((int)(v_toucheActive.getForme().getTailleRelativeY() * 100.0f));
            
            jButton_Supprimer_Touche.setEnabled(true);
            jComboBox_Forme_Touche.setEnabled(true);
            jSlider_TailleX_Touche.setEnabled(true);
            jSlider_TailleY_Touche.setEnabled(true);
            jSpinner_Bordure.setEnabled(true);
            jButton_Couleur_Touche.setEnabled(true);
            jButton_Couleur_Bordure.setEnabled(true);
            jButton_Image_Touche.setEnabled(true);
            jTextField_Image_Touche.setEnabled(true);
            jTextField_Nom_Touche.setEnabled(true);
            jSpinner_Octave_Touche.setEnabled(true);
            jComboBox_Note_Touche.setEnabled(true);
            jSpinner_Persistance_Touche.setEnabled(true);
            jTextField_Fichier_Audio_Touche.setEnabled(true);
            jButton_Fichier_Audio_Touche.setEnabled(true);
            jCheckBox_Afficher_Nom_Touche.setEnabled(true);
            jCheckBox_Afficher_Octave_Touche.setEnabled(true);
            jCheckBox_Afficher_Frequence_Touche.setEnabled(true);
            jCheckBox_Afficher_Persistance_Touche.setEnabled(true);
        }
 
    }
//</editor-fold>    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        TabbedPane_Vue = new javax.swing.JTabbedPane();
        jPanel_Principal_Editeur_Instrument = new javax.swing.JPanel();
        Panel_Menu_Instrument = new javax.swing.JPanel();
        jLabel_Generateur_De_Gabarit = new javax.swing.JLabel();
        jLabel_Nom_Instrument = new javax.swing.JLabel();
        jLabel_Timbre_Instrument = new javax.swing.JLabel();
        jButton_Nouveau_Instrument = new javax.swing.JButton();
        jButton_Supprimer_Instrument = new javax.swing.JButton();
        jButton_Charger_Instrument = new javax.swing.JButton();
        jButton_Enregistrer_Instrument = new javax.swing.JButton();
        jButton_Generer_Gabarit = new javax.swing.JButton();
        jSeparator1_Menu_Instrument = new javax.swing.JSeparator();
        jSeparator2_Menu_Instrument = new javax.swing.JSeparator();
        jComboBox_Selection_Gabarit = new javax.swing.JComboBox<>();
        jScrollPane_List_Instruments = new javax.swing.JScrollPane();
        jList_Liste_Instruments = new javax.swing.JList<>();
        jTextField_Nom_Instrument = new javax.swing.JTextField();
        jComboBox_Timbre_Instrument = new javax.swing.JComboBox<>();
        jPanel_Appercu_Instrument = new PanelAppercuEditionInstrument();
        jPanel_Menu_Touche = new javax.swing.JPanel();
        jPanel_Menu_Touche_Apparence = new javax.swing.JPanel();
        jLabel_Forme_Touche = new javax.swing.JLabel();
        jLabel_Taille_Touche = new javax.swing.JLabel();
        jLabel_Bordure_Touche = new javax.swing.JLabel();
        jLabel_Couleur_Touche = new javax.swing.JLabel();
        jLabel_Image_Touche = new javax.swing.JLabel();
        jComboBox_Forme_Touche = new javax.swing.JComboBox<>();
        jSlider_TailleX_Touche = new javax.swing.JSlider();
        jButton_Couleur_Touche = new javax.swing.JButton();
        jButton_Image_Touche = new javax.swing.JButton();
        filler_Apparence_Touche = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(150, 0), new java.awt.Dimension(200, 32767));
        jTextField_Image_Touche = new javax.swing.JTextField();
        jPanelCouleur = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider_TailleY_Touche = new javax.swing.JSlider();
        jSpinner_Bordure = new javax.swing.JSpinner();
        jButton_Couleur_Bordure = new javax.swing.JButton();
        jPanelCouleurBordure = new javax.swing.JPanel();
        jLabelCouleurBordure = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel_Menu_Touche_Caractéristiques = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton_Fichier_Audio_Touche = new javax.swing.JButton();
        jTextField_Nom_Touche = new javax.swing.JTextField();
        jSpinner_Octave_Touche = new javax.swing.JSpinner();
        jSpinner_Persistance_Touche = new javax.swing.JSpinner();
        jCheckBox_Afficher_Nom_Touche = new javax.swing.JCheckBox();
        jCheckBox_Afficher_Octave_Touche = new javax.swing.JCheckBox();
        jCheckBox_Afficher_Frequence_Touche = new javax.swing.JCheckBox();
        jCheckBox_Afficher_Persistance_Touche = new javax.swing.JCheckBox();
        jTextField_Fichier_Audio_Touche = new javax.swing.JTextField();
        filler_Caracteristique_Touche = new javax.swing.Box.Filler(new java.awt.Dimension(120, 0), new java.awt.Dimension(120, 0), new java.awt.Dimension(120, 32767));
        jComboBox_Note_Touche = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton_Creer_Touche = new javax.swing.JButton();
        jButton_Supprimer_Touche = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_Liste_Touches = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Recherche = new javax.swing.JTextField();
        jComboBox_recherche = new javax.swing.JComboBox<>();
        jLabel_rechercherPar = new javax.swing.JLabel();
        jButton_Annuler_Recherche = new javax.swing.JButton();
        jColorChooser = new javax.swing.JColorChooser();
        jButton_Color_Ok = new javax.swing.JButton();
        jPanel_Principal_Joueur_Instrument = new javax.swing.JPanel();
        jPanel_Jouer_Instrument = new PanelJoueurInstrument();
        jPanel_Controle_Musique = new javax.swing.JPanel();
        jButton_Retour_Musique = new javax.swing.JButton();
        jButton_Avancer_Musique = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton_Import_Instrument = new javax.swing.JButton();
        jLabelText_Music = new javax.swing.JLabel();
        jButton_Jouer = new javax.swing.JButton();
        jButton_Pause = new javax.swing.JButton();
        jCheckBox_mode_automatique = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel_accesoires_jouer = new PanelMetronomePedales();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButtonStartMet = new javax.swing.JButton();
        jSpinnerTempoMet = new javax.swing.JSpinner();
        jButtonStopMet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Principal_Editeur_Instrument.setLayout(new java.awt.GridBagLayout());

        Panel_Menu_Instrument.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Des Instruments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        Panel_Menu_Instrument.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panel_Menu_Instrument.setDoubleBuffered(false);
        Panel_Menu_Instrument.setLayout(new java.awt.GridBagLayout());

        jLabel_Generateur_De_Gabarit.setText("Générateur de gabarit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 3;
        Panel_Menu_Instrument.add(jLabel_Generateur_De_Gabarit, gridBagConstraints);

        jLabel_Nom_Instrument.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        Panel_Menu_Instrument.add(jLabel_Nom_Instrument, gridBagConstraints);
        jLabel_Nom_Instrument.getAccessibleContext().setAccessibleName("");
        jLabel_Nom_Instrument.getAccessibleContext().setAccessibleDescription("");

        jLabel_Timbre_Instrument.setText("Timbre :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        Panel_Menu_Instrument.add(jLabel_Timbre_Instrument, gridBagConstraints);

        jButton_Nouveau_Instrument.setText("Nouveau");
        jButton_Nouveau_Instrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Nouveau_InstrumentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        Panel_Menu_Instrument.add(jButton_Nouveau_Instrument, gridBagConstraints);

        jButton_Supprimer_Instrument.setText("Supprimer");
        jButton_Supprimer_Instrument.setEnabled(false);
        jButton_Supprimer_Instrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Supprimer_InstrumentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        Panel_Menu_Instrument.add(jButton_Supprimer_Instrument, gridBagConstraints);

        jButton_Charger_Instrument.setText("Charger");
        jButton_Charger_Instrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Charger_InstrumentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        Panel_Menu_Instrument.add(jButton_Charger_Instrument, gridBagConstraints);

        jButton_Enregistrer_Instrument.setText("Enregistrer");
        jButton_Enregistrer_Instrument.setEnabled(false);
        jButton_Enregistrer_Instrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Enregistrer_InstrumentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        Panel_Menu_Instrument.add(jButton_Enregistrer_Instrument, gridBagConstraints);

        jButton_Generer_Gabarit.setText("Générer Gabarit");
        jButton_Generer_Gabarit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Generer_GabaritActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        Panel_Menu_Instrument.add(jButton_Generer_Gabarit, gridBagConstraints);

        jSeparator1_Menu_Instrument.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1_Menu_Instrument.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(9, 3, 9, 3);
        Panel_Menu_Instrument.add(jSeparator1_Menu_Instrument, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(9, 3, 9, 3);
        Panel_Menu_Instrument.add(jSeparator2_Menu_Instrument, gridBagConstraints);

        jComboBox_Selection_Gabarit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guitare", "Piano" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        Panel_Menu_Instrument.add(jComboBox_Selection_Gabarit, gridBagConstraints);

        jList_Liste_Instruments.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_Liste_InstrumentsValueChanged(evt);
            }
        });
        jScrollPane_List_Instruments.setViewportView(jList_Liste_Instruments);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weighty = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        Panel_Menu_Instrument.add(jScrollPane_List_Instruments, gridBagConstraints);

        jTextField_Nom_Instrument.setEnabled(false);
        jTextField_Nom_Instrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Nom_InstrumentActionPerformed(evt);
            }
        });
        jTextField_Nom_Instrument.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Nom_InstrumentKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        Panel_Menu_Instrument.add(jTextField_Nom_Instrument, gridBagConstraints);

        jComboBox_Timbre_Instrument.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Piano", "Guitare", "Flute",}));
        jComboBox_Timbre_Instrument.setEnabled(false);
        jComboBox_Timbre_Instrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Timbre_InstrumentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        Panel_Menu_Instrument.add(jComboBox_Timbre_Instrument, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_Principal_Editeur_Instrument.add(Panel_Menu_Instrument, gridBagConstraints);

        javax.swing.GroupLayout jPanel_Appercu_InstrumentLayout = new javax.swing.GroupLayout(jPanel_Appercu_Instrument);
        jPanel_Appercu_Instrument.setLayout(jPanel_Appercu_InstrumentLayout);
        jPanel_Appercu_InstrumentLayout.setHorizontalGroup(
            jPanel_Appercu_InstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_Appercu_InstrumentLayout.setVerticalGroup(
            jPanel_Appercu_InstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.7;
        jPanel_Principal_Editeur_Instrument.add(jPanel_Appercu_Instrument, gridBagConstraints);

        jPanel_Menu_Touche.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Menu_Touche.setMinimumSize(new java.awt.Dimension(800, 200));
        jPanel_Menu_Touche.setOpaque(false);
        jPanel_Menu_Touche.setPreferredSize(new java.awt.Dimension(900, 200));
        jPanel_Menu_Touche.setLayout(new java.awt.GridBagLayout());

        jPanel_Menu_Touche_Apparence.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Menu_Touche_Apparence.setMaximumSize(new java.awt.Dimension(216, 129));
        jPanel_Menu_Touche_Apparence.setPreferredSize(new java.awt.Dimension(200, 183));
        jPanel_Menu_Touche_Apparence.setLayout(new java.awt.GridBagLayout());

        jLabel_Forme_Touche.setText("Forme   :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jLabel_Forme_Touche, gridBagConstraints);

        jLabel_Taille_Touche.setText("Taille X :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jLabel_Taille_Touche, gridBagConstraints);

        jLabel_Bordure_Touche.setText("Bordure :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jLabel_Bordure_Touche, gridBagConstraints);

        jLabel_Couleur_Touche.setText("Couleur touche :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jLabel_Couleur_Touche, gridBagConstraints);

        jLabel_Image_Touche.setText("Image   :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jLabel_Image_Touche, gridBagConstraints);

        jComboBox_Forme_Touche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rectangle", "Oval", "Étoile" }));
        jComboBox_Forme_Touche.setEnabled(false);
        jComboBox_Forme_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Forme_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jComboBox_Forme_Touche, gridBagConstraints);

        jSlider_TailleX_Touche.setEnabled(false);
        jSlider_TailleX_Touche.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_TailleX_ToucheStateChanged(evt);
            }
        });
        jSlider_TailleX_Touche.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jSlider_TailleX_ToucheMouseWheelMoved(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Menu_Touche_Apparence.add(jSlider_TailleX_Touche, gridBagConstraints);

        jButton_Couleur_Touche.setText("...");
        jButton_Couleur_Touche.setEnabled(false);
        jButton_Couleur_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Couleur_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jButton_Couleur_Touche, gridBagConstraints);

        jButton_Image_Touche.setText("...");
        jButton_Image_Touche.setEnabled(false);
        jButton_Image_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Image_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jButton_Image_Touche, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        jPanel_Menu_Touche_Apparence.add(filler_Apparence_Touche, gridBagConstraints);

        jTextField_Image_Touche.setEditable(false);
        jTextField_Image_Touche.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jTextField_Image_Touche, gridBagConstraints);

        jPanelCouleur.setBackground(new java.awt.Color(128, 128, 128));
        jPanelCouleur.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelCouleurLayout = new javax.swing.GroupLayout(jPanelCouleur);
        jPanelCouleur.setLayout(jPanelCouleurLayout);
        jPanelCouleurLayout.setHorizontalGroup(
            jPanelCouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelCouleurLayout.setVerticalGroup(
            jPanelCouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 6, 3);
        jPanel_Menu_Touche_Apparence.add(jPanelCouleur, gridBagConstraints);

        jLabel1.setText("Taille Y :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel_Menu_Touche_Apparence.add(jLabel1, gridBagConstraints);

        jSlider_TailleY_Touche.setEnabled(false);
        jSlider_TailleY_Touche.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_TailleY_ToucheStateChanged(evt);
            }
        });
        jSlider_TailleY_Touche.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jSlider_TailleY_ToucheMouseWheelMoved(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Menu_Touche_Apparence.add(jSlider_TailleY_Touche, gridBagConstraints);

        jSpinner_Bordure.setModel(new javax.swing.SpinnerNumberModel(1, 0, 20, 1));
        jSpinner_Bordure.setEnabled(false);
        jSpinner_Bordure.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_BordureStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jSpinner_Bordure, gridBagConstraints);

        jButton_Couleur_Bordure.setText("...");
        jButton_Couleur_Bordure.setEnabled(false);
        jButton_Couleur_Bordure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Couleur_BordureActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Apparence.add(jButton_Couleur_Bordure, gridBagConstraints);

        jPanelCouleurBordure.setBackground(new java.awt.Color(128, 128, 128));
        jPanelCouleurBordure.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelCouleurBordureLayout = new javax.swing.GroupLayout(jPanelCouleurBordure);
        jPanelCouleurBordure.setLayout(jPanelCouleurBordureLayout);
        jPanelCouleurBordureLayout.setHorizontalGroup(
            jPanelCouleurBordureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelCouleurBordureLayout.setVerticalGroup(
            jPanelCouleurBordureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 6, 3);
        jPanel_Menu_Touche_Apparence.add(jPanelCouleurBordure, gridBagConstraints);

        jLabelCouleurBordure.setText("Couleur bordure :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Menu_Touche_Apparence.add(jLabelCouleurBordure, gridBagConstraints);

        jLabel2.setText("Apparence");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel_Menu_Touche_Apparence.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_Menu_Touche.add(jPanel_Menu_Touche_Apparence, gridBagConstraints);
        jPanel_Menu_Touche_Apparence.getAccessibleContext().setAccessibleName("Apparence");

        jPanel_Menu_Touche_Caractéristiques.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Menu_Touche_Caractéristiques.setPreferredSize(new java.awt.Dimension(331, 300));
        jPanel_Menu_Touche_Caractéristiques.setLayout(new java.awt.GridBagLayout());

        jLabel8.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Octave :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jLabel9, gridBagConstraints);

        jLabel10.setText("Note :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jLabel10, gridBagConstraints);

        jLabel11.setText("Persistance :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Fichier audio :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jLabel12, gridBagConstraints);

        jButton_Fichier_Audio_Touche.setText("...");
        jButton_Fichier_Audio_Touche.setEnabled(false);
        jButton_Fichier_Audio_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Fichier_Audio_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jButton_Fichier_Audio_Touche, gridBagConstraints);

        jTextField_Nom_Touche.setEnabled(false);
        jTextField_Nom_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Nom_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jTextField_Nom_Touche, gridBagConstraints);

        jSpinner_Octave_Touche.setModel(new javax.swing.SpinnerNumberModel(5, 1, 9, 1));
        jSpinner_Octave_Touche.setEnabled(false);
        jSpinner_Octave_Touche.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_Octave_ToucheStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jSpinner_Octave_Touche, gridBagConstraints);

        jSpinner_Persistance_Touche.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner_Persistance_Touche.setEnabled(false);
        jSpinner_Persistance_Touche.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_Persistance_ToucheStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jSpinner_Persistance_Touche, gridBagConstraints);

        jCheckBox_Afficher_Nom_Touche.setEnabled(false);
        jCheckBox_Afficher_Nom_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Afficher_Nom_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        jPanel_Menu_Touche_Caractéristiques.add(jCheckBox_Afficher_Nom_Touche, gridBagConstraints);

        jCheckBox_Afficher_Octave_Touche.setEnabled(false);
        jCheckBox_Afficher_Octave_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Afficher_Octave_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel_Menu_Touche_Caractéristiques.add(jCheckBox_Afficher_Octave_Touche, gridBagConstraints);

        jCheckBox_Afficher_Frequence_Touche.setEnabled(false);
        jCheckBox_Afficher_Frequence_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Afficher_Frequence_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        jPanel_Menu_Touche_Caractéristiques.add(jCheckBox_Afficher_Frequence_Touche, gridBagConstraints);

        jCheckBox_Afficher_Persistance_Touche.setEnabled(false);
        jCheckBox_Afficher_Persistance_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Afficher_Persistance_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        jPanel_Menu_Touche_Caractéristiques.add(jCheckBox_Afficher_Persistance_Touche, gridBagConstraints);

        jTextField_Fichier_Audio_Touche.setEditable(false);
        jTextField_Fichier_Audio_Touche.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jTextField_Fichier_Audio_Touche, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        jPanel_Menu_Touche_Caractéristiques.add(filler_Caracteristique_Touche, gridBagConstraints);

        jComboBox_Note_Touche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C", "C#", "D", "D#" , "E", "F", "F#", "G", "G#", "A", "A#", "B" }));
        jComboBox_Note_Touche.setEnabled(false);
        jComboBox_Note_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Note_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel_Menu_Touche_Caractéristiques.add(jComboBox_Note_Touche, gridBagConstraints);

        jLabel3.setText("Caractéristiques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel_Menu_Touche_Caractéristiques.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 56, 0);
        jPanel_Menu_Touche.add(jPanel_Menu_Touche_Caractéristiques, gridBagConstraints);

        jButton_Creer_Touche.setText("Créer Touche");
        jButton_Creer_Touche.setEnabled(false);
        jButton_Creer_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Creer_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_Menu_Touche.add(jButton_Creer_Touche, gridBagConstraints);

        jButton_Supprimer_Touche.setText("Supprimer Touche");
        jButton_Supprimer_Touche.setEnabled(false);
        jButton_Supprimer_Touche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Supprimer_ToucheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_Menu_Touche.add(jButton_Supprimer_Touche, gridBagConstraints);

        jLabel17.setText("Touches");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel_Menu_Touche.add(jLabel17, gridBagConstraints);

        jList_Liste_Touches.setEnabled(false);
        jList_Liste_Touches.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_Liste_TouchesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList_Liste_Touches);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel_Menu_Touche.add(jScrollPane2, gridBagConstraints);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 7, 5);
        jPanel_Menu_Touche.add(jSeparator1, gridBagConstraints);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 7, 5);
        jPanel_Menu_Touche.add(jSeparator2, gridBagConstraints);

        jLabel4.setText("Recherche : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Menu_Touche.add(jLabel4, gridBagConstraints);

        jTextField_Recherche.setEnabled(false);
        jTextField_Recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_RechercheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Menu_Touche.add(jTextField_Recherche, gridBagConstraints);

        jComboBox_recherche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nom", "Note"}));
        jComboBox_recherche.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Menu_Touche.add(jComboBox_recherche, gridBagConstraints);

        jLabel_rechercherPar.setText("Rechercher par :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Menu_Touche.add(jLabel_rechercherPar, gridBagConstraints);

        jButton_Annuler_Recherche.setText("Annuler recherche");
        jButton_Annuler_Recherche.setEnabled(false);
        jButton_Annuler_Recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Annuler_RechercheActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Menu_Touche.add(jButton_Annuler_Recherche, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel_Principal_Editeur_Instrument.add(jPanel_Menu_Touche, gridBagConstraints);

        AbstractColorChooserPanel[] panels = jColorChooser.getChooserPanels();
        for (AbstractColorChooserPanel accp : panels) {
            if(accp.getDisplayName().equals("TSV") || accp.getDisplayName().equals("TSL") || accp.getDisplayName().equals("RVB") || accp.getDisplayName().equals("RGB") || accp.getDisplayName().equals("HSV") || accp.getDisplayName().equals("HSL")  || accp.getDisplayName().equals("CMYK")) {
                jColorChooser.removeChooserPanel(accp);
            }
        }
        jColorChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel_Principal_Editeur_Instrument.add(jColorChooser, gridBagConstraints);
        jColorChooser.setVisible(false);

        jButton_Color_Ok.setText("Accepter");
        jButton_Color_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Color_OkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel_Principal_Editeur_Instrument.add(jButton_Color_Ok, gridBagConstraints);
        jButton_Color_Ok.setVisible(false);

        TabbedPane_Vue.addTab("Éditeur d'instrument", jPanel_Principal_Editeur_Instrument);

        jPanel_Principal_Joueur_Instrument.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel_Jouer_InstrumentLayout = new javax.swing.GroupLayout(jPanel_Jouer_Instrument);
        jPanel_Jouer_Instrument.setLayout(jPanel_Jouer_InstrumentLayout);
        jPanel_Jouer_InstrumentLayout.setHorizontalGroup(
            jPanel_Jouer_InstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_Jouer_InstrumentLayout.setVerticalGroup(
            jPanel_Jouer_InstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 6.0;
        jPanel_Principal_Joueur_Instrument.add(jPanel_Jouer_Instrument, gridBagConstraints);

        jPanel_Controle_Musique.setLayout(new java.awt.GridBagLayout());

        jButton_Retour_Musique.setText("( << ) Reculer");
        jButton_Retour_Musique.setEnabled(false);
        jButton_Retour_Musique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Retour_MusiqueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Controle_Musique.add(jButton_Retour_Musique, gridBagConstraints);

        jButton_Avancer_Musique.setText("Avancer ( >> )");
        jButton_Avancer_Musique.setEnabled(false);
        jButton_Avancer_Musique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Avancer_MusiqueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Controle_Musique.add(jButton_Avancer_Musique, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel_Controle_Musique.add(jProgressBar1, gridBagConstraints);

        jButton_Import_Instrument.setText("Importer Musique");
        jButton_Import_Instrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Import_InstrumentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        jPanel_Controle_Musique.add(jButton_Import_Instrument, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        jPanel_Controle_Musique.add(jLabelText_Music, gridBagConstraints);

        jButton_Jouer.setText("Jouer ( > )");
        jButton_Jouer.setEnabled(false);
        jButton_Jouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_JouerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel_Controle_Musique.add(jButton_Jouer, gridBagConstraints);

        jButton_Pause.setText("Pause ( | | )");
        jButton_Pause.setEnabled(false);
        jButton_Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PauseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        jPanel_Controle_Musique.add(jButton_Pause, gridBagConstraints);

        jCheckBox_mode_automatique.setSelected(true);
        jCheckBox_mode_automatique.setText("Mode Automatique");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Controle_Musique.add(jCheckBox_mode_automatique, gridBagConstraints);

        jLabel6.setText("Rythme : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel_Controle_Musique.add(jLabel6, gridBagConstraints);

        jLabel7.setText("0 bpm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel_Controle_Musique.add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel_Principal_Joueur_Instrument.add(jPanel_Controle_Musique, gridBagConstraints);

        jPanel_accesoires_jouer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel_accesoires_jouer.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel_accesoires_jouer.add(jPanel1, gridBagConstraints);

        jLabel5.setText("Métronome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_accesoires_jouer.add(jLabel5, gridBagConstraints);

        jButtonStartMet.setText("Start");
        jButtonStartMet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartMetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_accesoires_jouer.add(jButtonStartMet, gridBagConstraints);

        jSpinnerTempoMet.setModel(new javax.swing.SpinnerNumberModel(100, 30, 250, 5));
        jSpinnerTempoMet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTempoMetStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_accesoires_jouer.add(jSpinnerTempoMet, gridBagConstraints);

        jButtonStopMet.setText("Stop");
        jButtonStopMet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopMetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_accesoires_jouer.add(jButtonStopMet, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_Principal_Joueur_Instrument.add(jPanel_accesoires_jouer, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(453, 120));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel_Principal_Joueur_Instrument.add(jScrollPane1, gridBagConstraints);

        TabbedPane_Vue.addTab("Joueur d'instrument", jPanel_Principal_Joueur_Instrument);

        getContentPane().add(TabbedPane_Vue, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    
//<editor-fold defaultstate="collapsed" desc="Event Listeners automatiquement générés par le GUI Editor">
    
    private void jButton_Nouveau_InstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Nouveau_InstrumentActionPerformed
        m_controlleur.Nouveau_InstrumentActionPerformed();
    }//GEN-LAST:event_jButton_Nouveau_InstrumentActionPerformed

    private void jButton_Couleur_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Couleur_ToucheActionPerformed
        jColorChooser.setVisible(true);
        jButton_Color_Ok.setVisible(true);
        couleurTouche = true;

    }//GEN-LAST:event_jButton_Couleur_ToucheActionPerformed

    private void jButton_Creer_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Creer_ToucheActionPerformed
        int v_position = jList_Liste_Touches.getSelectedIndex();
        m_controlleur.creerTouche();
        jList_Liste_Touches.setSelectedIndex(v_position);
        jButton_Enregistrer_Instrument.enable(true);
    }//GEN-LAST:event_jButton_Creer_ToucheActionPerformed

    private void jButton_Supprimer_InstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Supprimer_InstrumentActionPerformed
        
        String nomInstrumentSelectionneDansLaListe = jList_Liste_Instruments.getSelectedValue();
        
        m_controlleur.Supprimer_InstrumentActionPerformed(nomInstrumentSelectionneDansLaListe);
    }//GEN-LAST:event_jButton_Supprimer_InstrumentActionPerformed

    private void jList_Liste_InstrumentsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_Liste_InstrumentsValueChanged
       
       if(evt.getValueIsAdjusting())
       {
           return;
       }
       if(evt.getFirstIndex() != evt.getLastIndex())
       {
           //System.out.println("Plusieurs instruments sélectionnés... TODO" + evt.getFirstIndex() + evt.getLastIndex());
           //return;
       }
       
       //Lor
       if(jList_Liste_Instruments.getSelectedValue() == null)
       {
           m_controlleur.getModel().getConteneurInstruments().getInstrumentActif().getConteneurTouches().supprimerObservateur(this);
       }
       
        m_controlleur.Changer_Instrument(jList_Liste_Instruments.getSelectedValue());
    }//GEN-LAST:event_jList_Liste_InstrumentsValueChanged

    private void jTextField_Nom_InstrumentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Nom_InstrumentKeyTyped
        //Empechait la modification du nom de l'instrument. A voir
        //m_controlleur.Informations_instrument_modifiees();
    }//GEN-LAST:event_jTextField_Nom_InstrumentKeyTyped

    private void jList_Liste_TouchesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_Liste_TouchesValueChanged
        if(evt.getValueIsAdjusting())
        {
           return;
        }
        m_controlleur.changerToucheActiveDansListeTouche(jList_Liste_Touches.getSelectedValue());
    }//GEN-LAST:event_jList_Liste_TouchesValueChanged

    private void jButton_Supprimer_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Supprimer_ToucheActionPerformed
        m_controlleur.supprimerToucheActiveDansListeTouche(jList_Liste_Touches.getSelectedValue());
    }//GEN-LAST:event_jButton_Supprimer_ToucheActionPerformed

    private void jButton_Image_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Image_ToucheActionPerformed
        JFileChooser v_fc = new JFileChooser();
        int returnVal = v_fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = v_fc.getSelectedFile();
            //This is where a real application would open the file.
            
            jTextField_Image_Touche.setText(file.getName());
            m_controlleur.changerImageTouche(file.getAbsolutePath());
            jPanel_Appercu_Instrument.repaint();
        } else {

        }
    }//GEN-LAST:event_jButton_Image_ToucheActionPerformed

    private void jCheckBox_Afficher_Nom_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Afficher_Nom_ToucheActionPerformed
        m_controlleur.changerAfficherNomTouche(jCheckBox_Afficher_Nom_Touche.isSelected());
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jCheckBox_Afficher_Nom_ToucheActionPerformed

    private void jCheckBox_Afficher_Octave_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Afficher_Octave_ToucheActionPerformed
        m_controlleur.changerAfficherOctaveTouche(jCheckBox_Afficher_Octave_Touche.isSelected());
        jPanel_Appercu_Instrument.repaint();

    }//GEN-LAST:event_jCheckBox_Afficher_Octave_ToucheActionPerformed

    private void jCheckBox_Afficher_Frequence_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Afficher_Frequence_ToucheActionPerformed
        m_controlleur.changerAfficherFrequenceTouche(jCheckBox_Afficher_Frequence_Touche.isSelected());
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jCheckBox_Afficher_Frequence_ToucheActionPerformed

    private void jCheckBox_Afficher_Persistance_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Afficher_Persistance_ToucheActionPerformed
        m_controlleur.changerAfficherPersistanceTouche(jCheckBox_Afficher_Persistance_Touche.isSelected());
        jPanel_Appercu_Instrument.repaint();
        
    }//GEN-LAST:event_jCheckBox_Afficher_Persistance_ToucheActionPerformed

    private void jSlider_TailleX_ToucheStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_TailleX_ToucheStateChanged
        m_controlleur.changerTailleXTouche(jSlider_TailleX_Touche.getValue());
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jSlider_TailleX_ToucheStateChanged

    private void jSlider_TailleY_ToucheStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_TailleY_ToucheStateChanged
        m_controlleur.changerTailleYTouche(jSlider_TailleY_Touche.getValue());
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jSlider_TailleY_ToucheStateChanged

    private void jSlider_TailleX_ToucheMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jSlider_TailleX_ToucheMouseWheelMoved
        jSlider_TailleX_Touche.setValue(jSlider_TailleX_Touche.getValue() + (evt.getUnitsToScroll()> 0 ? -1 : 1));
    }//GEN-LAST:event_jSlider_TailleX_ToucheMouseWheelMoved

    private void jSlider_TailleY_ToucheMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jSlider_TailleY_ToucheMouseWheelMoved
        jSlider_TailleY_Touche.setValue(jSlider_TailleY_Touche.getValue() + (evt.getUnitsToScroll()> 0 ? -1 : 1));
    }//GEN-LAST:event_jSlider_TailleY_ToucheMouseWheelMoved

    private void jSpinner_BordureStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_BordureStateChanged
        m_controlleur.setBordureToucheActive((int)jSpinner_Bordure.getValue());
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jSpinner_BordureStateChanged

    private void jTextField_Nom_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Nom_ToucheActionPerformed
        String v_ancienNom = m_controlleur.getNomToucheActive();
        String v_nouveauNom = jTextField_Nom_Touche.getText();
        boolean v_nomChange;
        v_nomChange = m_controlleur.setNomToucheActive(v_ancienNom, v_nouveauNom);
        Set<String> v_set = m_controlleur.getListeNomTouches();
        ArrayList<String> v_arrayListString = new ArrayList<>();
        for(String str : (Set<String>) v_set){
            v_arrayListString.add(str);
        }
        jPanel_Appercu_Instrument.repaint();
        String[] v_stringArray = new String[v_arrayListString.size()];
        jList_Liste_Touches.setListData(v_arrayListString.toArray(v_stringArray));
        
        if(v_nomChange)
            jList_Liste_Touches.setSelectedValue(v_nouveauNom, true);
        else
            jList_Liste_Touches.setSelectedValue(v_ancienNom, true);
    }//GEN-LAST:event_jTextField_Nom_ToucheActionPerformed

    private void jButton_Charger_InstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Charger_InstrumentActionPerformed
        int returnVal = m_instrumentFileChooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                
                String v_fileName = m_instrumentFileChooser.getSelectedFile().getAbsolutePath();
                
                if(! v_fileName.endsWith(".xml")){
                    System.out.println("ERREUR : Le fichier d'import n'a pas l'extension .xml !");
                }
                else{
                    System.out.println("INFO : Fichier d'import selectionné : " +
                                    v_fileName);
                
                    m_controlleur.importerInstrument(v_fileName);
                    
                }
                
                
            }

    }//GEN-LAST:event_jButton_Charger_InstrumentActionPerformed

    private void jComboBox_Forme_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Forme_ToucheActionPerformed
        // TODO add your handling code here:
        jPanel_Appercu_Instrument.repaint();
        String v_forme = jComboBox_Forme_Touche.getItemAt(jComboBox_Forme_Touche.getSelectedIndex());
        m_controlleur.changerFormeToucheActive(v_forme);
    }//GEN-LAST:event_jComboBox_Forme_ToucheActionPerformed

    private void jTextField_Nom_InstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Nom_InstrumentActionPerformed
        String v_ancienNom = m_controlleur.getNomInstrumentActif();
        String v_nouveauNom = jTextField_Nom_Instrument.getText();
        boolean v_nomChange;
        v_nomChange = m_controlleur.setNomInstrumentActif(v_ancienNom, v_nouveauNom);
        Set<String> v_set = m_controlleur.getListeNomInstruments();
        ArrayList<String> v_arrayListString = new ArrayList<>();
        for(String str : (Set<String>) v_set){
            v_arrayListString.add(str);
        }
        jPanel_Appercu_Instrument.repaint();
        String[] v_stringArray = new String[v_arrayListString.size()];
        jList_Liste_Instruments.setListData(v_arrayListString.toArray(v_stringArray));
        if(v_nomChange)
            jList_Liste_Instruments.setSelectedValue(v_nouveauNom, true);
        else
            jList_Liste_Instruments.setSelectedValue(v_ancienNom, true);
    }//GEN-LAST:event_jTextField_Nom_InstrumentActionPerformed

    private void jButton_Couleur_BordureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Couleur_BordureActionPerformed
        jColorChooser.setVisible(true);
        jButton_Color_Ok.setVisible(true);
        couleurBordure = true;
    }//GEN-LAST:event_jButton_Couleur_BordureActionPerformed

    private void jSpinner_Octave_ToucheStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_Octave_ToucheStateChanged
        // TODO add your handling code here:
        jCheckBox_Afficher_Frequence_Touche.setEnabled(true);
        jCheckBox_Afficher_Octave_Touche.setEnabled(true);
        jCheckBox_Afficher_Persistance_Touche.setEnabled(true);
        
        m_controlleur.setOctaveToucheActive((int)jSpinner_Octave_Touche.getValue());
        m_controlleur.setFichierAudioToucheActive("");
        jTextField_Fichier_Audio_Touche.setText("");
        
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jSpinner_Octave_ToucheStateChanged

    private void jComboBox_Note_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Note_ToucheActionPerformed
        // TODO add your handling code here:
        jCheckBox_Afficher_Frequence_Touche.setEnabled(true);
        jCheckBox_Afficher_Octave_Touche.setEnabled(true);
        jCheckBox_Afficher_Persistance_Touche.setEnabled(true);
        
        m_controlleur.setNoteToucheActive(jComboBox_Note_Touche.getSelectedIndex());
        m_controlleur.setFichierAudioToucheActive("");
        jTextField_Fichier_Audio_Touche.setText("");
        
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jComboBox_Note_ToucheActionPerformed

    private void jComboBox_Timbre_InstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Timbre_InstrumentActionPerformed
        // TODO add your handling code here:
        m_controlleur.setTimbreInstrumentActif(jComboBox_Timbre_Instrument.getSelectedIndex());
    }//GEN-LAST:event_jComboBox_Timbre_InstrumentActionPerformed

    private void jSpinner_Persistance_ToucheStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_Persistance_ToucheStateChanged
        jCheckBox_Afficher_Frequence_Touche.setEnabled(true);
        jCheckBox_Afficher_Octave_Touche.setEnabled(true);
        jCheckBox_Afficher_Persistance_Touche.setEnabled(true);
        
        m_controlleur.setPersistanceToucheActive((int)jSpinner_Persistance_Touche.getValue());
        m_controlleur.setFichierAudioToucheActive("");
        jTextField_Fichier_Audio_Touche.setText("");
        
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jSpinner_Persistance_ToucheStateChanged

    private void jButton_Fichier_Audio_ToucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Fichier_Audio_ToucheActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Fichier audio (*.wav)", "wav");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = chooser.getSelectedFile();
            if(filter.accept(file)){
                jTextField_Fichier_Audio_Touche.setText(file.getName());
                m_controlleur.setFichierAudioToucheActive(file.getAbsolutePath());
                jCheckBox_Afficher_Frequence_Touche.setSelected(false);
                jCheckBox_Afficher_Octave_Touche.setSelected(false);
                jCheckBox_Afficher_Persistance_Touche.setSelected(false);
                jCheckBox_Afficher_Frequence_Touche.setEnabled(false);
                jCheckBox_Afficher_Octave_Touche.setEnabled(false);
                jCheckBox_Afficher_Persistance_Touche.setEnabled(false);
                m_controlleur.getInstrumentActif().getConteneurTouches().getToucheActive().setAfficherNote(false);
                m_controlleur.getInstrumentActif().getConteneurTouches().getToucheActive().setAfficherOctave(false);
                m_controlleur.getInstrumentActif().getConteneurTouches().getToucheActive().setAfficherPersistance(false);
                jPanel_Appercu_Instrument.repaint();
            }
        } 
    }//GEN-LAST:event_jButton_Fichier_Audio_ToucheActionPerformed

    private void jButton_Color_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Color_OkActionPerformed
        // TODO add your handling code here:
        if(couleurTouche){
            Color v_nouvelleCouleur = jColorChooser.getColor();
            m_controlleur.setCouleurToucheActive(v_nouvelleCouleur);
            jPanelCouleur.setBackground(v_nouvelleCouleur);
            jPanel_Appercu_Instrument.repaint();
            couleurTouche = false;
            jColorChooser.setVisible(false);
            jButton_Color_Ok.setVisible(false);
        }
        if(couleurBordure){
            Color v_nouvelleCouleur = jColorChooser.getColor();
            m_controlleur.setCouleurBordureToucheActive(v_nouvelleCouleur);
            jPanelCouleurBordure.setBackground(v_nouvelleCouleur);
            jPanel_Appercu_Instrument.repaint();
            couleurBordure = false;
            jColorChooser.setVisible(false);
            jButton_Color_Ok.setVisible(false);
        }
    }//GEN-LAST:event_jButton_Color_OkActionPerformed

    private void jButton_Generer_GabaritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Generer_GabaritActionPerformed
        m_controlleur.genererGabaritInstrument(jComboBox_Selection_Gabarit.getItemAt(jComboBox_Selection_Gabarit.getSelectedIndex()));
    }//GEN-LAST:event_jButton_Generer_GabaritActionPerformed

    private void jButton_Enregistrer_InstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Enregistrer_InstrumentActionPerformed
        
        if(m_controlleur.getModel()
                        .getConteneurInstruments()
                        .getInstrumentActif() != null)
        {
            
            int returnVal = m_instrumentFileChooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                
                String v_fileNameAbsolue;
                
                if(! m_instrumentFileChooser.getSelectedFile()
                                            .getAbsolutePath()
                                            .endsWith(".xml")){
                    v_fileNameAbsolue = m_instrumentFileChooser.getSelectedFile()
                                                                .getAbsolutePath() + ".xml";
                }
                else{
                    v_fileNameAbsolue = m_instrumentFileChooser.getSelectedFile()
                                                               .getAbsolutePath();
                }
                
                System.out.println("INFO : Fichier de sauvegarde selectionné : " +
                                    v_fileNameAbsolue);
                
                m_controlleur.getModel()
                         .getConteneurInstruments()
                         .m_importExportInstrument
                         .exporterInstrument(v_fileNameAbsolue,
                                              m_controlleur.getModel()
                                                           .getConteneurInstruments()
                                                           .getInstrumentActif());
            }
            
            
        }
        else{
            System.out.println("ERREUR : Tentative d'enregistrer un instrument alors que l'instrument actif == null!");
        }
    }//GEN-LAST:event_jButton_Enregistrer_InstrumentActionPerformed

    private void jButton_Import_InstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Import_InstrumentActionPerformed
        // TODO add your handling code here:
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Fichier Texte (*.txt)", "txt");
        m_piece_chooser.setFileFilter(filter);
        int returnVal = m_piece_chooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            java.io.File file = m_piece_chooser.getSelectedFile();
            if(filter.accept(file)){//filtre pour les fichier txt
                if(m_controlleur.chargerFichierPieceMusicale(file)){
                  jLabelText_Music.setText("FICHIER INVALIDE !!!");
                }
                else{
                     jLabelText_Music.setText(file.getName());//affiche le nom du fichier 
                     m_pulsation = m_controlleur.getModel().getInterpreteurPiece().getPulsation();
                     ArrayList<ArrayList<String>> v_piece = m_controlleur.getModel().getInterpreteurPiece().getPieceInterprete();
                     
                     DefaultTableModel v_model = (DefaultTableModel) jTable2.getModel();
                     
                     int v_nombreNotes = v_piece.get(0).size();
                     
                     String[] v_nomColonnesNotes = new String[v_nombreNotes];
                     
                     for(int i = 0; i < v_nombreNotes ; i++){
                         v_nomColonnesNotes[i] = Integer.toString(i+1);
                     }
                     
                    
                     
                     v_model.setColumnCount(v_nombreNotes);
                     v_model.setColumnIdentifiers(v_nomColonnesNotes);
                     v_model.setRowCount(v_piece.size());
                     
                     
                     
                     for(int i = 0; i < v_piece.size(); i++){
                         
                         for(int j = 0; j < v_piece.get(0).size(); j++){
                             
                             v_model.setValueAt(v_piece.get(i).get(j), i, j);
                             
                         }
                         
                         
                     }

                     jTable2.setModel(v_model);
                     
                     jTable2.setColumnSelectionAllowed(true);
                     jTable2.setRowSelectionAllowed(false);
                     
                     jButton_Jouer.setEnabled(true);
                     jButton_Pause.setEnabled(false);
                     jButton_Avancer_Musique.setEnabled(true);
                     jButton_Retour_Musique.setEnabled(true);
                     
                     int bpm = m_controlleur.getModel().getInterpreteurPiece().getPulsation();
                     
                     jLabel7.setText(Integer.toString(bpm) + " bpm");
                     ((PanelJoueurInstrument)jPanel_Jouer_Instrument).importerPiece(jTable2, bpm);
                    
                }
                
            }
        } 
    }//GEN-LAST:event_jButton_Import_InstrumentActionPerformed

    private void jButton_Avancer_MusiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Avancer_MusiqueActionPerformed
        ((PanelJoueurInstrument)jPanel_Jouer_Instrument).avancerPiece();
    }//GEN-LAST:event_jButton_Avancer_MusiqueActionPerformed

    private void jButton_Retour_MusiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Retour_MusiqueActionPerformed
        ((PanelJoueurInstrument)jPanel_Jouer_Instrument).reculerPiece();
    }//GEN-LAST:event_jButton_Retour_MusiqueActionPerformed

    private void jButton_JouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_JouerActionPerformed

        jButton_Jouer.setEnabled(false);
        jButton_Pause.setEnabled(true);
        jButton_Avancer_Musique.setEnabled(false);
        jButton_Retour_Musique.setEnabled(false);
        ((PanelJoueurInstrument)jPanel_Jouer_Instrument).jouerPiece(jCheckBox_mode_automatique.isSelected());

    }//GEN-LAST:event_jButton_JouerActionPerformed

    private void jButton_PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PauseActionPerformed
       jButton_Jouer.setEnabled(true);
        jButton_Pause.setEnabled(false);
        jButton_Avancer_Musique.setEnabled(true);
        jButton_Retour_Musique.setEnabled(true);
        ((PanelJoueurInstrument)jPanel_Jouer_Instrument).pausePiece();
       
    }//GEN-LAST:event_jButton_PauseActionPerformed

    private void jTextField_RechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_RechercheActionPerformed
        String v_rechercheTemp;
        v_rechercheTemp = jTextField_Recherche.getText();
        String v_typeRecherche;
        v_typeRecherche = String.valueOf(jComboBox_recherche.getSelectedItem());
        m_recherche = v_rechercheTemp.split("\\s");
        m_controlleur.rechercheTouche(m_recherche, v_typeRecherche);

        jPanel_Appercu_Instrument.repaint();
        jTextField_Recherche.setEnabled(false);
        jButton_Annuler_Recherche.setEnabled(true);
        jTextField_Nom_Touche.setEnabled(false);
    }//GEN-LAST:event_jTextField_RechercheActionPerformed

    private void jButton_Annuler_RechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Annuler_RechercheActionPerformed
        // TODO add your handling code here:
        m_controlleur.annulerRechercheTouche();
        jButton_Annuler_Recherche.setEnabled(false);
        jTextField_Recherche.setEnabled(true);
        jTextField_Nom_Touche.setEnabled(true);
        jPanel_Appercu_Instrument.repaint();
    }//GEN-LAST:event_jButton_Annuler_RechercheActionPerformed

    private void jSpinnerTempoMetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTempoMetStateChanged
        // TODO add your handling code here:
        m_tempo = (int)jSpinnerTempoMet.getValue();
    }//GEN-LAST:event_jSpinnerTempoMetStateChanged

    private void jButtonStartMetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartMetActionPerformed
        // TODO add your handling code here:
        m_metronome = true;
    }//GEN-LAST:event_jButtonStartMetActionPerformed

    private void jButtonStopMetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopMetActionPerformed
        // TODO add your handling code here:
        m_metronome = false;
    }//GEN-LAST:event_jButtonStopMetActionPerformed
    
    //<editor-fold defaultstate="collapsed" desc="Fonction comment out">
    
    /*private void Jouer_Colonne_Tableau_Notes(int p_colonne){
        List<String> v_noteAJouer = new ArrayList<String>();
        for(int i = 0;i<jTable2.getRowCount()-1;++i){
            
            v_noteAJouer.add((String)jTable2.getValueAt(i, p_colonne));
            System.out.print(jTable2.getValueAt(i, p_colonne)+"\n");
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
                String lol = jComboBox_Note_Touche.getItemAt(v_toucheCourante.getNote())+v_toucheCourante.getOctave();
                //System.out.print(lol+"\n");
                if(v_noteAJouer.get(i).equalsIgnoreCase(lol)){
                    v_toucheAJouer.add(v_toucheCourante);
                    System.out.print(v_toucheCourante.getNom()+"\n");
                    break;
                }
            }
        }
        
        for(int i = 0;i<v_toucheAJouer.size();++i){
            //Runnable r = new testThread(v_toucheAJouer.get(i),m_pulsation,jPanel_Jouer_Instrument);
            //new Thread(r).start();
        }
    
    }*/
    //</editor-fold>
//</editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Attributs générés automatiquement"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Menu_Instrument;
    private javax.swing.JTabbedPane TabbedPane_Vue;
    private javax.swing.Box.Filler filler_Apparence_Touche;
    private javax.swing.Box.Filler filler_Caracteristique_Touche;
    private javax.swing.JButton jButtonStartMet;
    private javax.swing.JButton jButtonStopMet;
    private javax.swing.JButton jButton_Annuler_Recherche;
    private javax.swing.JButton jButton_Avancer_Musique;
    private javax.swing.JButton jButton_Charger_Instrument;
    private javax.swing.JButton jButton_Color_Ok;
    private javax.swing.JButton jButton_Couleur_Bordure;
    private javax.swing.JButton jButton_Couleur_Touche;
    private javax.swing.JButton jButton_Creer_Touche;
    private javax.swing.JButton jButton_Enregistrer_Instrument;
    private javax.swing.JButton jButton_Fichier_Audio_Touche;
    private javax.swing.JButton jButton_Generer_Gabarit;
    private javax.swing.JButton jButton_Image_Touche;
    private javax.swing.JButton jButton_Import_Instrument;
    private javax.swing.JButton jButton_Jouer;
    private javax.swing.JButton jButton_Nouveau_Instrument;
    private javax.swing.JButton jButton_Pause;
    private javax.swing.JButton jButton_Retour_Musique;
    private javax.swing.JButton jButton_Supprimer_Instrument;
    private javax.swing.JButton jButton_Supprimer_Touche;
    private javax.swing.JCheckBox jCheckBox_Afficher_Frequence_Touche;
    private javax.swing.JCheckBox jCheckBox_Afficher_Nom_Touche;
    private javax.swing.JCheckBox jCheckBox_Afficher_Octave_Touche;
    private javax.swing.JCheckBox jCheckBox_Afficher_Persistance_Touche;
    private javax.swing.JCheckBox jCheckBox_mode_automatique;
    private javax.swing.JColorChooser jColorChooser;
    private javax.swing.JComboBox<String> jComboBox_Forme_Touche;
    private javax.swing.JComboBox<String> jComboBox_Note_Touche;
    private javax.swing.JComboBox<String> jComboBox_Selection_Gabarit;
    private javax.swing.JComboBox<String> jComboBox_Timbre_Instrument;
    private javax.swing.JComboBox<String> jComboBox_recherche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCouleurBordure;
    private javax.swing.JLabel jLabelText_Music;
    private javax.swing.JLabel jLabel_Bordure_Touche;
    private javax.swing.JLabel jLabel_Couleur_Touche;
    private javax.swing.JLabel jLabel_Forme_Touche;
    private javax.swing.JLabel jLabel_Generateur_De_Gabarit;
    private javax.swing.JLabel jLabel_Image_Touche;
    private javax.swing.JLabel jLabel_Nom_Instrument;
    private javax.swing.JLabel jLabel_Taille_Touche;
    private javax.swing.JLabel jLabel_Timbre_Instrument;
    private javax.swing.JLabel jLabel_rechercherPar;
    private javax.swing.JList<String> jList_Liste_Instruments;
    private javax.swing.JList<String> jList_Liste_Touches;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCouleur;
    private javax.swing.JPanel jPanelCouleurBordure;
    private javax.swing.JPanel jPanel_Appercu_Instrument;
    private javax.swing.JPanel jPanel_Controle_Musique;
    private static javax.swing.JPanel jPanel_Jouer_Instrument;
    private javax.swing.JPanel jPanel_Menu_Touche;
    private javax.swing.JPanel jPanel_Menu_Touche_Apparence;
    private javax.swing.JPanel jPanel_Menu_Touche_Caractéristiques;
    private javax.swing.JPanel jPanel_Principal_Editeur_Instrument;
    private javax.swing.JPanel jPanel_Principal_Joueur_Instrument;
    private javax.swing.JPanel jPanel_accesoires_jouer;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane_List_Instruments;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator1_Menu_Instrument;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator2_Menu_Instrument;
    private javax.swing.JSlider jSlider_TailleX_Touche;
    private javax.swing.JSlider jSlider_TailleY_Touche;
    private javax.swing.JSpinner jSpinnerTempoMet;
    private javax.swing.JSpinner jSpinner_Bordure;
    private javax.swing.JSpinner jSpinner_Octave_Touche;
    private javax.swing.JSpinner jSpinner_Persistance_Touche;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField_Fichier_Audio_Touche;
    private javax.swing.JTextField jTextField_Image_Touche;
    private javax.swing.JTextField jTextField_Nom_Instrument;
    private javax.swing.JTextField jTextField_Nom_Touche;
    private javax.swing.JTextField jTextField_Recherche;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
