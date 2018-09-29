/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Forme;

import gaudrophone.Model.Forme.Forme;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author jpbel65
 */
public class FormeRectangle
        extends Forme implements java.io.Serializable{
    
    private Rectangle m_shape = new Rectangle();
    
    FormeRectangle(float p_positionRelativeX,
                   float p_positionRelativeY,
                   float p_tailleRelativeX,
                   float p_tailleRelativeY){
        super(p_positionRelativeX,
              p_positionRelativeY,
              p_tailleRelativeX,
              p_tailleRelativeY);
        m_shape = new Rectangle();
        
    }
    
    @Override
    public void updateFenetreDimensions(int p_dimensionX, int p_dimensionY){
        float v_positionX = (float) p_dimensionX * m_positionRelativeX;
        float v_positionY = (float) p_dimensionY * m_positionRelativeY;
        float v_tailleX   = (float) p_dimensionX * m_tailleRelativeX;
        float v_tailleY   = (float) p_dimensionY * m_tailleRelativeY;    
        
        m_shape.setRect(v_positionX, v_positionY, v_tailleX, v_tailleY);
    }
    
    @Override
    public void drawForme(Graphics2D p_graphics2d){
        p_graphics2d.drawRect(m_shape.x, m_shape.y, m_shape.width, m_shape.height);
    }
    @Override
    public void fillForme(Graphics2D p_graphics2d){
        p_graphics2d.fillRect(m_shape.x, m_shape.y, m_shape.width, m_shape.height);
    }
    
    @Override
    public boolean contient(java.awt.Point p_point){
       return m_shape.contains(p_point);
    }
    
    @Override
    public String getNom(){
        return "rectangle";
    }
    
}
