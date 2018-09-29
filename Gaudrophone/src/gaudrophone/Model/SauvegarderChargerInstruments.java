/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model;


import gaudrophone.Model.Forme.FormeFactory;
import gaudrophone.Model.Instrument.Instrument;
import gaudrophone.Model.Instrument.Touche;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 *
 * @author Simon
 */
public class SauvegarderChargerInstruments implements java.io.Serializable{
    
    private final ConteneurInstruments m_conteneurInstruments;
    
    public SauvegarderChargerInstruments(ConteneurInstruments p_conteneurInstruments){
        m_conteneurInstruments = p_conteneurInstruments;
    }
    
    public Instrument importerInstrument(String fichier){
        // Nous récupérons une instance de factory qui se chargera de nous fournir
      // un parseur
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setIgnoringComments(true);
      factory.setIgnoringElementContentWhitespace(true);
      
      
      Instrument v_instrument = new Instrument(){
          @Override
          public void peindreBackgroundInstrument(JPanel p_jPanel, Graphics p_graphics) {
              //rien.
          }
      };

      try {
         // Création de notre parseur via la factory
         DocumentBuilder builder = factory.newDocumentBuilder();
         File fileXML = new File(fichier);

         // parsing de notre fichier via un objet File et récupération d'un
         // objet Document
         // Ce dernier représente la hiérarchie d'objet créée pendant le parsing
         Document xml = builder.parse(fileXML);

         // Via notre objet Document, nous pouvons récupérer un objet Element
         // Ce dernier représente un élément XML mais, avec la méthode ci-dessous,
         // cet élément sera la racine du document
         Element v_inst = xml.getDocumentElement();
       

         //Nous récupérons la liste des noeuds enfants
         NodeList v_liste = v_inst.getChildNodes();
         
         //nom
         Node v_nom_inst = v_liste.item(0);
         if (v_nom_inst instanceof Element){
                v_instrument.setNom(v_nom_inst.getTextContent());
         }
         
         //timbre
         Node v_timbre_inst = v_liste.item(1);
         if (v_timbre_inst instanceof Element){
                v_instrument.setTimbre(Integer.decode(v_timbre_inst.getTextContent()));
               System.out.println("VALUE : " + v_timbre_inst.getNodeName() + " : " + v_timbre_inst.getTextContent());
         }
         
         //conteneur touches
         Node v_conteneur_touches = v_liste.item(2);
         NodeList v_touche_liste_conteneur = v_conteneur_touches.getChildNodes();
         
         if (v_conteneur_touches instanceof Element){
             int v_nbTouches = v_conteneur_touches.getChildNodes().getLength();
        
             for(int i = 0; i!= v_nbTouches; i++){
                 
                 Node v_touche_xml = v_touche_liste_conteneur.item(i);
                 
                 if (v_touche_xml instanceof Element){
                     
                    NodeList v_touche_liste = v_touche_xml.getChildNodes();
                    Touche v_touche = new Touche();
                 
                 
                    //nom touche
                    Node v_nom_touche = v_touche_liste.item(0);
                    if (v_nom_touche instanceof Element){
                        v_touche.setNom(v_nom_touche.getTextContent());   
                    }  
                     //forme touche
                    Node v_forme_touche = v_touche_liste.item(1);
                    if (v_forme_touche instanceof Element){               
                        v_touche.setForme(v_forme_touche.getTextContent());   
                    } 
                    
                    //taille relative x
                    Node v_taille_relative_x = v_touche_liste.item(2);
                    if (v_taille_relative_x instanceof Element){
                        v_touche.getForme().setTailleRelativeX(Float.parseFloat(v_taille_relative_x.getTextContent()));   
                    } 
                    
                    //taille relative y
                    Node v_taille_relative_y = v_touche_liste.item(3);
                    if (v_taille_relative_y instanceof Element){
                        v_touche.getForme().setTailleRelativeY(Float.parseFloat(v_taille_relative_y.getTextContent()));   
                    } 
                    
                    //position relative x
                    Node v_position_relative_x = v_touche_liste.item(4);
                    if (v_position_relative_x instanceof Element){
                        v_touche.getForme().setPositionRelativeX(Float.parseFloat(v_position_relative_x.getTextContent()));   
                    }
                    
                    //position relative y
                    Node v_position_relative_y = v_touche_liste.item(5);
                    if (v_position_relative_y instanceof Element){
                        v_touche.getForme().setPositionRelativeY(Float.parseFloat(v_position_relative_y.getTextContent()));   
                    }
                    
                    //bordure
                    Node v_bordure = v_touche_liste.item(6);
                    if (v_bordure instanceof Element){
                        v_touche.setBordure(Integer.decode(v_bordure.getTextContent()));   
                    }
                    
                    //couleur
                    Node v_couleur = v_touche_liste.item(7);                   
                    if (v_couleur instanceof Element){
                        
                        NodeList v_nodelist_couleur = v_couleur.getChildNodes();
                        
                        Node v_rouge = v_nodelist_couleur.item(0);
                        int v_r = Integer.parseInt(v_rouge.getTextContent());
                        
                        Node v_vert = v_nodelist_couleur.item(1);
                        int v_v = Integer.parseInt(v_vert.getTextContent());
                        
                        Node v_bleu = v_nodelist_couleur.item(2);
                        int v_b = Integer.parseInt(v_bleu.getTextContent());
                        
                        v_touche.setCouleur(new Color(v_r, v_v, v_b));   
                    }
                    
                    //couleur bordure
                    Node v_couleur_bordure = v_touche_liste.item(8);
                    if (v_couleur_bordure instanceof Element){
                        
                        NodeList v_nodelist_couleur_bordure = v_couleur_bordure.getChildNodes();
                        
                        Node v_rouge = v_nodelist_couleur_bordure.item(0);
                        int v_r = Integer.parseInt(v_rouge.getTextContent());
                        
                        Node v_vert = v_nodelist_couleur_bordure.item(1);
                        int v_v = Integer.parseInt(v_vert.getTextContent());
                        
                        Node v_bleu = v_nodelist_couleur_bordure.item(2);
                        int v_b = Integer.parseInt(v_bleu.getTextContent());
                        
                        v_touche.setCouleurBordure(new Color(v_r, v_v, v_b));

                    }
                    
                    //image de fond
                    Node v_image_de_fond = v_touche_liste.item(9);
                    if (v_image_de_fond instanceof Element){
                        
                        v_touche.setImageDeFond(v_image_de_fond.getTextContent());   
                    }
                    
                    //fichier audio
                    Node v_fichier_audio = v_touche_liste.item(10);
                    if (v_fichier_audio instanceof Element){
                        
                        v_touche.setFichierAudio(v_fichier_audio.getTextContent());   
                    }
                    
                    //octave
                    Node v_octave = v_touche_liste.item(11);
                    if (v_octave instanceof Element){
                        v_touche.setOctave(Integer.decode(v_octave.getTextContent()));   
                    }
                    
                    //note
                    Node v_note = v_touche_liste.item(12);
                    if (v_note instanceof Element){
                        v_touche.setNote(Integer.decode(v_note.getTextContent()));   
                    }
                    
                    //persistance
                    Node v_persistance = v_touche_liste.item(13);
                    if (v_persistance instanceof Element){
                        v_touche.setPersistance(Integer.decode(v_persistance.getTextContent()));   
                    }
                    
                    //afficher nom
                    Node v_afficher_nom = v_touche_liste.item(14);
                    if (v_afficher_nom instanceof Element){
                        v_touche.setAfficherNom(Boolean.valueOf(v_afficher_nom.getTextContent()));   
                    }
                    
                    //afficher octave
                    Node v_afficher_octave = v_touche_liste.item(15);
                    if (v_afficher_octave instanceof Element){
                        v_touche.setAfficherOctave(Boolean.valueOf(v_afficher_octave.getTextContent()));   
                    }
                    
                    //afficher note
                    Node v_afficher_note = v_touche_liste.item(16);
                    if (v_afficher_note instanceof Element){
                        v_touche.setAfficherNote(Boolean.valueOf(v_afficher_note.getTextContent()));   
                    }
                    
                    //afficher persistance
                    Node v_afficher_persistance = v_touche_liste.item(17);
                    if (v_afficher_persistance instanceof Element){
                        v_touche.setAfficherPersistance(Boolean.valueOf(v_afficher_persistance.getTextContent()));   
                    }
                
                    v_instrument.ajouterTouche(v_touche);
                 } 
                 
             }
         }

      } catch (ParserConfigurationException e){
         e.printStackTrace();
      } catch (SAXException e){
         e.printStackTrace();
      } catch (IOException e){
         e.printStackTrace();
      }
      
      return v_instrument;
    }
    
    
    public void exporterInstrument(String p_chemin, Instrument p_instrument){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try {
         //document builder
         DocumentBuilder builder = factory.newDocumentBuilder();
         //le dcument
         Document xml = builder.newDocument();
         //élément racine
         Element e_instrument = xml.createElement("instrument");
         
         //nom de l'instrument
         Element e_nom_instrument = xml.createElement("nom");
         e_nom_instrument.setTextContent(p_instrument.getNom());
         e_instrument.appendChild(e_nom_instrument);
         
         //timbre de l'instrument
         Element e_timbre_instrument = xml.createElement("timbre");
         e_timbre_instrument.setTextContent(Integer.toString(p_instrument.getTimbre()));
         e_instrument.appendChild(e_timbre_instrument);
             
         Element e_conteneurTouches = xml.createElement("conteneur_touches");
             
         p_instrument.getConteneurTouches().m_listeTouches.forEach((v_nomTouche, v_touche) -> {
            
            //l'élément racinedu conteneur de touche
            Element e_touche = xml.createElement("touche");
                 
            //nom
            Element e_nomTouche = xml.createElement("nom");
            e_nomTouche.setTextContent(v_touche.getNom());
            e_touche.appendChild(e_nomTouche);
                 
            //forme
            Element e_forme = xml.createElement("forme");
            e_forme.setTextContent(v_touche.getForme().getNom());
            e_touche.appendChild(e_forme);
            
            //tailleRelativeX
            Element e_tailleRelativeX = xml.createElement("taille_relative_x");
            e_tailleRelativeX.setTextContent(Float.toString(v_touche.getForme().getTailleRelativeX()));
            e_touche.appendChild(e_tailleRelativeX);
                 
            //tailleRelativeY
            Element e_tailleRelativeY = xml.createElement("taille_relative_y");
            e_tailleRelativeY.setTextContent(Float.toString(v_touche.getForme().getTailleRelativeY()));
            e_touche.appendChild(e_tailleRelativeY);
                 
            //positionRelativeX
            Element e_positionRelativeX = xml.createElement("position_relative_x");
            e_positionRelativeX.setTextContent(Float.toString(v_touche.getForme().getPositionRelativeX()));
            e_touche.appendChild(e_positionRelativeX);
                 
            //positionRelativeY
            Element e_positionRelativeY = xml.createElement("position_relative_Y");
            e_positionRelativeY.setTextContent(Float.toString(v_touche.getForme().getPositionRelativeY()));
            e_touche.appendChild(e_positionRelativeY);
                 
            //bordure
            Element e_bordure = xml.createElement("bordure");
            e_bordure.setTextContent(Integer.toString(v_touche.getBordure()));
            e_touche.appendChild(e_bordure);
                 
            //couleur
            Element e_couleur = xml.createElement("couleur");
                Element e_couleur_rouge = xml.createElement("rouge");
                e_couleur_rouge.setTextContent(Integer.toString(v_touche.getCouleur().getRed()));
                Element e_couleur_vert = xml.createElement("vert");
                e_couleur_vert.setTextContent(Integer.toString(v_touche.getCouleur().getGreen()));
                Element e_couleur_bleu = xml.createElement("bleu");
                e_couleur_bleu.setTextContent(Integer.toString(v_touche.getCouleur().getBlue()));
            
                e_couleur.appendChild(e_couleur_rouge);
                e_couleur.appendChild(e_couleur_vert);
                e_couleur.appendChild(e_couleur_bleu);
            e_touche.appendChild(e_couleur);
                 
            //couleur bordure
            Element e_couleurBordure = xml.createElement("couleur_bordure");
                Element e_couleur_rouge_b = xml.createElement("rouge");
                e_couleur_rouge_b.setTextContent(Integer.toString(v_touche.getCouleurBordure().getRed()));
                Element e_couleur_vert_b = xml.createElement("vert");
                e_couleur_vert_b.setTextContent(Integer.toString(v_touche.getCouleurBordure().getGreen()));
                Element e_couleur_bleu_b = xml.createElement("bleu");
                e_couleur_bleu_b.setTextContent(Integer.toString(v_touche.getCouleurBordure().getBlue()));
            
                e_couleurBordure.appendChild(e_couleur_rouge_b);
                e_couleurBordure.appendChild(e_couleur_vert_b);
                e_couleurBordure.appendChild(e_couleur_bleu_b);
            e_touche.appendChild(e_couleurBordure);
                 
            //image de fond
            Element e_imageDeFond = xml.createElement("image_de_fond");
            e_imageDeFond.setTextContent(v_touche.getImageDeFond());
            e_touche.appendChild(e_imageDeFond);
                 
            //fichier audio
            Element e_fichierAudio = xml.createElement("fichier_audio");
            e_fichierAudio.setTextContent(v_touche.getFichierAudio());
            e_touche.appendChild(e_fichierAudio);
                 
            //octave
            Element e_octave = xml.createElement("octave");
            e_octave.setTextContent(Integer.toString(v_touche.getOctave()));
            e_touche.appendChild(e_octave);
                 
            //note
            Element e_note = xml.createElement("note");
            e_note.setTextContent(Integer.toString(v_touche.getNote()));
            e_touche.appendChild(e_note);
                 
            //persistance
            Element e_persistance = xml.createElement("persistance");
            e_persistance.setTextContent(Integer.toString(v_touche.getPersistance()));
            e_touche.appendChild(e_persistance);
                 
            //afficherNom
            Element e_afficherNom = xml.createElement("afficher_nom");
            e_afficherNom.setTextContent(Boolean.toString(v_touche.getAfficherNom()));
            e_touche.appendChild(e_afficherNom);
                 
            //afficher octave
            Element e_afficherOctave = xml.createElement("afficher_octave");
            e_afficherOctave.setTextContent(Boolean.toString(v_touche.getAfficherOctave()));
            e_touche.appendChild(e_afficherOctave);
                 
            //afficher note
            Element e_afficherNote = xml.createElement("afficher_note");
            e_afficherNote.setTextContent(Boolean.toString(v_touche.getAfficherNote()));
            e_touche.appendChild(e_afficherNote);
                 
            //afficher persistance
            Element e_afficherPersistance = xml.createElement("afficher_persistance");
            e_afficherPersistance.setTextContent(Boolean.toString(v_touche.getAfficherPersistance()));
            e_touche.appendChild(e_afficherPersistance);
                 
            e_conteneurTouches.appendChild(e_touche);

             });
             
         e_instrument.appendChild(e_conteneurTouches);
             
          
                   
         //On crée un fichier xml correspondant au résultat
         //construire la transformation inactive
         Transformer t = TransformerFactory.newInstance().newTransformer();
         //définir les propriétés de sortie pour obtenir un nœud DOCTYPE
         t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Instrument.dtd");
         t.setOutputProperty(OutputKeys.INDENT, "yes");
         t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
         // appliquer la transformation 
          
         StreamResult XML = new StreamResult(p_chemin);
         
         t.transform(new DOMSource(e_instrument), XML);       
         
      }catch (DOMException | ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
         e.printStackTrace();
      }
        // TODO Auto-generated catch block
        // TODO Auto-generated catch block
        
        // TODO Auto-generated catch block
        // TODO Auto-generated catch block
       
    }
}
