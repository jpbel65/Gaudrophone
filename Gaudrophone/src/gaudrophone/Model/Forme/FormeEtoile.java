/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Forme;

import gaudrophone.Model.Forme.Forme;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author jpbel65
 */
public class FormeEtoile 
     extends Forme implements java.io.Serializable{
    
    private Polygon m_shape;
    
    int[] ArrayX = new int[10];
    int[] ArrayY = new int[10];
    
    public FormeEtoile(float p_positionRelativeX,
                       float p_positionRelativeY,
                       float p_tailleRelativeX,
                       float p_tailleRelativeY){
        super(p_positionRelativeX,
              p_positionRelativeY,
              p_tailleRelativeX,
              p_tailleRelativeY);
    }
    
    @Override
    public void updateFenetreDimensions(int p_dimensionX, int p_dimensionY){
        int v_positionX = (int)((float) p_dimensionX * m_positionRelativeX);
        int v_positionY = (int)((float) p_dimensionY * m_positionRelativeY);
        int v_tailleX   = (int)((float) p_dimensionX * m_tailleRelativeX);
        int v_tailleY   = (int)((float) p_dimensionY * m_tailleRelativeY);
        
        
        ArrayX[0] = v_tailleX/2   + v_positionX;
        ArrayX[2] = v_tailleX     + v_positionX;
        ArrayX[4] = v_tailleX*4/5 + v_positionX;
        ArrayX[6] = v_tailleX/5   + v_positionX;
        ArrayX[8] = v_positionX;
        ArrayX[1] = v_tailleX/2   +( v_tailleX /2 - v_tailleX/5)/2 + v_positionX;//
        ArrayX[3] = v_tailleX/2 + v_tailleX/5 + v_positionX;
        ArrayX[5] = v_tailleX/2 + v_positionX;
        ArrayX[7] = v_tailleX/2 - v_tailleX/5 + v_positionX;
        ArrayX[9] = v_tailleX/2-(v_tailleX/2-v_tailleX/5)/2 + v_positionX;//
        
        ArrayY[0] = v_positionY;
        ArrayY[2] = v_tailleY*2/5+v_positionY;
        ArrayY[4] = v_tailleY+v_positionY;
        ArrayY[6] = v_tailleY+v_positionY;
        ArrayY[8] = v_tailleY*2/5+v_positionY;
        ArrayY[1] = v_tailleY*2/5+v_positionY;
        ArrayY[3] = v_tailleY*3/5+v_positionY;
        ArrayY[5] = v_tailleY*4/5+v_positionY;
        ArrayY[7] = v_tailleY*3/5+v_positionY;
        ArrayY[9] = v_tailleY*2/5+v_positionY;
        
        m_shape = new Polygon();
        for(int i = 0; i<10;i++){
            m_shape.addPoint(ArrayX[i], ArrayY[i]);
        }
    }
    
    @Override
    public void drawForme(Graphics2D p_graphics2d){
        p_graphics2d.drawPolygon(m_shape);
    }
    @Override
    public void fillForme(Graphics2D p_graphics2d){
        p_graphics2d.fillPolygon(m_shape);
    }
    
    @Override
    public boolean contient(Point p_point){
        return m_shape.contains(p_point.x, p_point.y);
    }
    
    @Override
    public String getNom(){
        return "Étoile";
    }
//    @Override
//    public void draw(Graphics2D v_panel,int v_posX,int v_posY,int v_tailleX,int v_tailleY){
//        int v_WeidthD8 = (int)((float)v_posX/0.5f/8);
//        int v_HeightD8 = (int)((float)v_posY/0.5f/8);
//        int v_sliderX = (int)((float)v_tailleX*100);
//        int v_sliderY = (int)((float)v_tailleY*100);

//            v_panel.drawPolygon(ArrayX, ArrayY, 10);
//    }
//    @Override
//    public void fill(Graphics2D v_panel,int v_posX,int v_posY,int v_tailleX,int v_tailleY){
//        int[] ArrayX = new int[10];
//        ArrayX[0] = v_tailleX/2+v_posX;
//        ArrayX[2] = v_tailleX+v_posX;
//        ArrayX[4] = v_tailleX*4/5+v_posX;
//        ArrayX[6] = v_tailleX/5+v_posX;
//        ArrayX[8] = v_posX;
//        ArrayX[1] = v_tailleX/2+(v_tailleX/2-v_tailleX/5)/2+v_posX;//
//        ArrayX[3] = v_tailleX/2+v_tailleX/5+v_posX;
//        ArrayX[5] = v_tailleX/2+v_posX;
//        ArrayX[7] = v_tailleX/2-v_tailleX/5+v_posX;
//        ArrayX[9] = v_tailleX/2-(v_tailleX/2-v_tailleX/5)/2+v_posX;//
//        int[] ArrayY = new int[10];
//        ArrayY[0] = v_posY;
//        ArrayY[2] = v_tailleY*2/5+v_posY;
//        ArrayY[4] = v_tailleY+v_posY;
//        ArrayY[6] = v_tailleY+v_posY;
//        ArrayY[8] = v_tailleY*2/5+v_posY;
//        ArrayY[1] = v_tailleY*2/5+v_posY;
//        ArrayY[3] = v_tailleY*3/5+v_posY;
//        ArrayY[5] = v_tailleY*4/5+v_posY;
//        ArrayY[7] = v_tailleY*3/5+v_posY;
//        ArrayY[9] = v_tailleY*2/5+v_posY;
//        v_panel.fillPolygon(ArrayX, ArrayY, 10);
//    }
//    
}
