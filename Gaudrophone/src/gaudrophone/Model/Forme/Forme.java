/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaudrophone.Model.Forme;

import java.awt.Shape;

/**
 *
 * @author Simon
 */
public abstract class Forme implements FormeStrategy{
    
    Forme(float p_positionRelativeX,
          float p_positionRelativeY,
          float p_tailleRelativeX,
          float p_tailleRelativeY){
        m_positionRelativeX = p_positionRelativeX;
        m_positionRelativeY = p_positionRelativeY;
        m_tailleRelativeX = p_tailleRelativeX;
        m_tailleRelativeY = p_tailleRelativeY;
    }
    
    @Override
    public void setTailleRelativeX(float p_tailleRelativeX){
        m_tailleRelativeX = p_tailleRelativeX;
        if(m_tailleRelativeX+m_positionRelativeX > 1.0f){
            m_positionRelativeX -= m_tailleRelativeX+m_positionRelativeX-1.0f;
        }
    }
    @Override
    public float getTailleRelativeX(){
        return m_tailleRelativeX;
    }
    @Override
    public void setTailleRelativeY(float p_tailleRelativeY){
        m_tailleRelativeY = p_tailleRelativeY;
        if(m_tailleRelativeY+m_positionRelativeY > 1.0f){
            m_positionRelativeY -= m_tailleRelativeY+m_positionRelativeY-1.0f;
        }
    }
    @Override
    public float getTailleRelativeY(){
        return m_tailleRelativeY;
    }
    @Override
    public void setPositionRelativeX(float p_positionRelativeX){
        m_positionRelativeX = p_positionRelativeX;
    }
    @Override
    public float getPositionRelativeX(){
        return m_positionRelativeX;
    }
    @Override
    public void setPositionRelativeY(float p_positionRelativeY){
        m_positionRelativeY = p_positionRelativeY;
    }
    @Override
    public float getPositionRelativeY(){
        return m_positionRelativeY;
    }
    
    
    
    protected float          m_positionRelativeX;
    protected float          m_positionRelativeY;
    protected float          m_tailleRelativeX;
    protected float          m_tailleRelativeY;
    
    
    
    
}
