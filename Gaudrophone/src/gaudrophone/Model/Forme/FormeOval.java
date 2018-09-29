/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Forme;

import gaudrophone.Model.Forme.Forme;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Simon
 */
public class FormeOval 
            extends Forme implements java.io.Serializable{
    
    private Ellipse2D m_shape = new Ellipse2D.Float();
    
    FormeOval(float p_positionRelativeX,
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
        float v_positionX = (float) p_dimensionX * m_positionRelativeX;
        float v_positionY = (float) p_dimensionY * m_positionRelativeY;
        float v_tailleX   = (float) p_dimensionX * m_tailleRelativeX;
        float v_tailleY   = (float) p_dimensionY * m_tailleRelativeY;    
        
        m_shape.setFrame(v_positionX, v_positionY, v_tailleX, v_tailleY);
    }
    
    @Override
    public void drawForme(Graphics2D p_graphics2d){
        //p_graphics2d.drawOval((int)m_shape.getMaxX(), (int)m_shape.getMaxY(), (int)m_shape.getWidth(), (int)m_shape.getWidth());
        p_graphics2d.draw(m_shape);
    }
    @Override
    public void fillForme(Graphics2D p_graphics2d){
        p_graphics2d.fill(m_shape);
        //p_graphics2d.fillOval((int)m_shape.getMaxX(), (int)m_shape.getMaxY(), (int)m_shape.getWidth(), (int)m_shape.getWidth());
    }
    
    @Override
    public boolean contient(java.awt.Point p_point){
       return m_shape.contains(p_point);
    }
    
    @Override
    public String getNom(){
        return "oval";
    }
    
}
