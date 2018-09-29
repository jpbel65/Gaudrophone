/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.InterpreteurPiece;

import gaudrophone.Vue.testThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Simon
 */
public class InterpreteurPiece {
    
    private ArrayList<ArrayList<String>> m_pieceInterprete = new ArrayList<ArrayList<String>>();
    private int m_tempo = 0;
    private boolean m_pieceInterpreteVide = true;
    
    private enum TypeLigne{
        Vide,
        Commentaire,
        Pulsation,
        Partition,
        Duree,
        Invalide
    }
    
    private class MauvaisFormatException extends Exception{
        public MauvaisFormatException(){
            System.out.println("Mauvais format");
        }
        public MauvaisFormatException(String p_messageErreur){
            System.out.println(p_messageErreur);
        }
    }
    
    public boolean chargerFichierPieceMusicale(File p_fichierPiece){
        
        boolean v_erreur = false;
        m_pieceInterprete = new ArrayList<ArrayList<String>>();
        m_pieceInterpreteVide = true;
        
        
        try{
            BufferedReader v_BufLecture = new BufferedReader(new FileReader(p_fichierPiece));
        
            String v_ligne =  v_BufLecture.readLine();
            
            while(identifierLigne(v_ligne) != TypeLigne.Pulsation){
                v_ligne =  v_BufLecture.readLine();
            }
            
            m_tempo = Integer.parseInt(v_ligne);
        
            System.out.println("Tempo : " + m_tempo);
            
            while(true){
                ArrayList<String> v_lignesPartition = new ArrayList<>();
                String v_ligneDuree;
                v_ligne = v_BufLecture.readLine();
            
                boolean v_finFichier = false;
                while(identifierLigne(v_ligne) != TypeLigne.Partition){
                    if(identifierLigne(v_ligne) == TypeLigne.Invalide){
                        v_finFichier = true;
                        break;
                    }
                    v_ligne = v_BufLecture.readLine();
                }
                if(v_finFichier){
                    break;
                }
            
                while(identifierLigne(v_ligne) == TypeLigne.Partition){
                    System.out.println("Ligne partition: " + v_ligne);
                    v_lignesPartition.add(v_ligne);
                    v_ligne = v_BufLecture.readLine();
                }
            
                if(identifierLigne(v_ligne) == TypeLigne.Duree){
                    v_ligneDuree = v_ligne;
                    System.out.println("Ligne Duree: " + v_ligne);
                }
                else{
                    v_ligneDuree = null;
                }
            
                ArrayList<ArrayList<String>> v_resultat = decouperLigne(v_lignesPartition, v_ligneDuree);
                
               System.out.println("V_RESULTAT : ");
               System.out.println(v_resultat);
               
                if(m_pieceInterpreteVide){
                    for(int i = 0; i < v_resultat.size(); i++){
                        m_pieceInterprete.add(v_resultat.get(i));
                    }
                    m_pieceInterpreteVide = false;
                }else{
                   for(int i = 0; i < v_resultat.size(); i++){
                        m_pieceInterprete.get(i).addAll(v_resultat.get(i));
                    } 
                }
                
            }
            System.out.println("FINAL : ");
            System.out.println(m_pieceInterprete);
        
        }catch(FileNotFoundException e){ 
            v_erreur = true;
        }catch(IOException e){
            v_erreur = true;
        }catch(MauvaisFormatException e){  
            v_erreur = true;
        }
       

        return v_erreur;
    }            
        
    public ArrayList<ArrayList<String>> getPieceInterprete(){
        return m_pieceInterprete;
    } 
    
    public int getPulsation(){
        return m_tempo;
    }
        
    
    /**
    * Identifie le type de ligne. Assume que la ligne est déjà trimmée avec
    * la fonction String.trim().
    */
    private TypeLigne identifierLigne(String p_ligne){
        
        //vérifie si la ligne est vide(fin de fichier en fait)
        if(p_ligne == null){   
            return TypeLigne.Invalide;
        }
        
        String v_ligne = p_ligne.trim();
        
        //vérifie si la ligne est vide
        if(v_ligne.isEmpty()){
            return TypeLigne.Vide; 
        }
           
        //Vérifie si la ligne est un commentaire
        if(v_ligne.startsWith("//")){
            return TypeLigne.Commentaire;
        }
        
        //Vérifie si la ligne est une pulsation, c.a.d. si la ligne représente
        //strictement un nombre. 
        
        boolean ok = true;
        try{
            Integer.parseInt(v_ligne);
        }catch(NumberFormatException e){
            ok = false;
        }
        if(ok == true) return TypeLigne.Pulsation;
        
        while(v_ligne.charAt(0) == '|' ||
              v_ligne.charAt(0) == ' '){
            v_ligne = v_ligne.substring(1);
        }
        
        //Vérifie si la ligne est une ligne de partition
        if(Character.toUpperCase(v_ligne.charAt(0)) == 'C' ||
           Character.toUpperCase(v_ligne.charAt(0)) == 'D' ||
           Character.toUpperCase(v_ligne.charAt(0)) == 'E' ||
           Character.toUpperCase(v_ligne.charAt(0)) == 'F' ||
           Character.toUpperCase(v_ligne.charAt(0)) == 'G' ||
           Character.toUpperCase(v_ligne.charAt(0)) == 'A' ||
           Character.toUpperCase(v_ligne.charAt(0)) == 'B' ){
           
            return TypeLigne.Partition;
        }
       
        //vérifie si la ligne est une ligne de durée.
        if(v_ligne.charAt(0) == '_' ||
           v_ligne.charAt(0) == ',' ||
           v_ligne.charAt(0) == '.' ||
           v_ligne.charAt(0) == '2' ||
           v_ligne.charAt(0) == '3' ||
           v_ligne.charAt(0) == '4' ||
           v_ligne.charAt(0) == '5' ||
           v_ligne.charAt(0) == '6' ||
           v_ligne.charAt(0) == '7' ||
           v_ligne.charAt(0) == '8' ||
           v_ligne.charAt(0) == '9'){
            
            return TypeLigne.Duree;
        }
        
        //Sinon il sagit d'un type inconnu.
        return TypeLigne.Invalide;
    }
        
    private ArrayList<ArrayList<String>> decouperLigne(ArrayList<String> p_lignesPartition, String p_ligneDuree) throws MauvaisFormatException {
        
        //Le nombre de lignes de partitions recues (1,2,3,... lignes une par dessus lautre collees 
        int v_nombreLignesPartition = p_lignesPartition.size();
        
        //Représente le nombre de caractère de la première ligne de partition
        //On s'en sert pour itérer en parallère sur toutes les lignes.
        //On assume que ce sera la ligne la plus longue 
        //TODO faire la condition pour éviter le cas ou ce n'est pas le cas.
        int v_finIndex = p_lignesPartition.get(0).length();
        
        //Représente le résultat 
        ArrayList<ArrayList<String>> v_resultat = new ArrayList<ArrayList<String>>();
        
        //On crée les listes dans le vecteur de résultat. Un vecteur par ligne de partition
        //et un pour le vecteur de durée (d'où le + 1).
        for(int i = 0; i < v_nombreLignesPartition + 1; i++){
            v_resultat.add(new ArrayList<String>());
        }
        
        //Represente la ligne de duree optionnelle. On la reatribue ici pour pouvoir append des espaces à la fin pour 
        //la rendre de la même longueur que les lignes de partition.
        String v_ligneDuree = new String();
        
        //Représente si on a une ligne de durée ou non, si oui on l'utilisera sinon ce sera par défaut la duree sera 1 
        boolean v_isDureeSpecified = (p_ligneDuree != null);
        
        if(v_isDureeSpecified){
            v_ligneDuree = p_ligneDuree;
            for(int i = 0; i<(v_finIndex - v_ligneDuree.length()); i++){
                v_ligneDuree = v_ligneDuree + ' ';
            }
        }
        
        //Représente l'index de la colonne
        int v_columnIndex;
        
        
        
        int v_indexNote = 0;
        
        //Cette variable sert à déterminer si la colone doit être un caractere qui sert a
        //rien, soit un espace ou un |.
        //Ceci est déterminé par la première ligne de partition car toutes les notes doivent
        //être allignées 
        boolean v_isBlanc = true;
        
        boolean v_isStartNote = false;
        
        //On itère colonne par colonne en parallèle sur toutes les lignes de partition 
        //ainsi que la ligne de durée si elle est spécifiée.
        for(v_columnIndex = 0; v_columnIndex < v_finIndex; v_columnIndex++){
            
            
        
            //Si le caractere est une barre ou un espace, tout les autres caracteres des lignes 
            //subséquences ainsi que la ligne de durée devront être eux aussi blanc ou barre.
            if(p_lignesPartition.get(0).charAt(v_columnIndex) == '|' ||
               p_lignesPartition.get(0).charAt(v_columnIndex) == ' '){
                 
                //Si la colonne précédente était une colonne blanc, le fait que celle-ci
                //le soit aussi implique que ce n'est pas un début de colonne.
                if(v_isBlanc == true){
                    //Alors la colonne est toujours une colonne blanc
                    
                    //Et ce n'est pas le début d'une note
                    v_isStartNote = false;
                }
                else{
                    
                }
                v_isBlanc = true;
            }
            //Sinon il sagit d'un caractere d'une note
            else{
                //Si la colonne précédente était une colonne blanc, il sagit du début d'une colonne note
                if(v_isBlanc == true){
                    //C'est le début d'une note.
                    v_isStartNote = true;
                }
                //Si la colonne précédente n'était pas blanc et que celle-ci nonplus, ce nest pas une colonne début note
                else{
                    v_isStartNote = false;
                }
                v_isBlanc = false;
                
            }

            //On évalue le caractere pour les autres lignes 
            for(int i = 0; i < v_nombreLignesPartition; i++){
            
                //Si la première ligne nous indique qu'il sagissait d'un caractere blanc, il faut
                //que toutes les autres lignes aussi le soient, sinon on lance une exception
                //mauvais format
                if(v_isBlanc){
                
                    //Si le caractere est autre chose que '|' ou ' ' on lance une exception
                    if(p_lignesPartition.get(i).charAt(v_columnIndex) != '|' &&
                       p_lignesPartition.get(i).charAt(v_columnIndex) != ' '){
                        throw new MauvaisFormatException("Mauvais allignement au niveau des caractères '|' ou ' ' entre les lignes de partition.");
                    }
                
                    //Si une ligne de durée est spécifiée, on la vérifie
                    if(v_isDureeSpecified){
                        //Si le caractere est autre chose que '|' ou ' ' on lance une exception
                        if(v_ligneDuree.charAt(v_columnIndex) != '|' &&
                           v_ligneDuree.charAt(v_columnIndex) != ' '){
                            throw new MauvaisFormatException("Mauvais allignement au niveau des caractères '|' ou ' ' avec la ligne de durée.");
                        }
                    }
                }
                //is not blanc
                else{
                    
                    //Si c'est le début d'une nouvelle note
                    if(v_isStartNote){
                        //on crée une string avec la premiere lettre de la note
                        v_resultat.get(i).add(Character.toString(p_lignesPartition.get(i).charAt(v_columnIndex))) ;
                        
                    }
                    else{
                        //sinon on ajoute la prochaine lettre de la note
                        String s = v_resultat.get(i).get(v_resultat.get(i).size()-1).concat(Character.toString(p_lignesPartition.get(i).charAt(v_columnIndex)));
                        v_resultat.get(i).set(v_resultat.get(i).size()-1, s);
                    }
                    
                }
            }
            
            //Si il sagit du début d'une note on met le caractere de durée dans le dernier vecteur de string
            if(v_isStartNote){
                if(v_isDureeSpecified){
                    v_resultat.get(v_nombreLignesPartition).add(Character.toString(v_ligneDuree.charAt(v_columnIndex)));
                }
                else{
                    v_resultat.get(v_nombreLignesPartition).add("_");
                }
                
                v_isStartNote = false;
            }
        }
        
        return v_resultat;
    }    
     
    
}
