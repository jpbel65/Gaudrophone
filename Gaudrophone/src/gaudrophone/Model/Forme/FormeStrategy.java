/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Forme;

import java.awt.Graphics2D;
import java.awt.Point;
/**
 *
 * @author jpbel65
 */
public interface FormeStrategy {
    
    
    
    public void setTailleRelativeX(float p_tailleRelativeX);
    public float getTailleRelativeX();
    public void setTailleRelativeY(float p_tailleRelativeY);
    public float getTailleRelativeY();
    public void setPositionRelativeX(float p_positionRelativeX);
    public float getPositionRelativeX();
    public void setPositionRelativeY(float p_positionRelativeY);
    public float getPositionRelativeY();
     
    public void updateFenetreDimensions(int p_dimensionX, int p_dimensionY);
    
    public void drawForme(Graphics2D p_graphics2d);
    public void fillForme(Graphics2D p_graphics2d);
    
    public boolean contient(Point p_point);
    
    public String getNom();
}
