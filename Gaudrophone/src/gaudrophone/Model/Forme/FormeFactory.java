/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Forme;

import gaudrophone.Model.Forme.FormeEtoile;
import gaudrophone.Model.Forme.Forme;

/**
 *
 * @author jpbel65
 */
public class FormeFactory {
    //use getShape method to get object of type shape 
   public static Forme getShape(String shapeType){
      if(shapeType == null){
         return null;
      }		
      else if(shapeType.equalsIgnoreCase("rectangle")){
         return new FormeRectangle(0.4f,0.4f,0.1f,0.1f);
      }
      else if(shapeType.equalsIgnoreCase("oval")){
          return new FormeOval(0.4f, 0.4f, 0.1f, 0.1f);
      }
      else if(shapeType.equalsIgnoreCase("étoile")){
          return new FormeEtoile(0.4f,0.4f,0.1f,0.1f);
      }
      else{
          return null;
      }
//      else if(shapeType.equalsIgnoreCase("RECTANGLE")){
//         return new FormeRectangle();
//         
//      } else if(shapeType.equalsIgnoreCase("Oval")){
//         return new FormeOval();
//      }
      
      
   }
}
