/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj.vistas;

/**
 *
 * @author Diego Lopez
 */
public class ComprasObj {
 

    private double m_dblPrecio;
    private int m_strID;
    private int m_strCantidad;
    private int m_iDDocumento;
    private String m_strMedicamento;
    
    public ComprasObj(int p_strID, double p_dblPrecio, int p_strCantidad, int p_iDDocumento,String p_strMedicamento) 
    {
    
        setPrecio(p_dblPrecio);
        setID(p_strID);
        setCantidad(p_strCantidad);
        setiDDocumento(p_iDDocumento);
        setMedicamento(p_strMedicamento);
    }

    public double getPrecio() {
        return m_dblPrecio;
    }

    private void setPrecio(double p_Precio) {
        this.m_dblPrecio = p_Precio;
    }

    public int getID() {
        return m_strID;
    }

    private void setID(int p_strID) {
        this.m_strID = p_strID;
    }

    public int getCantidad() {
        return m_strCantidad;
    }

    private void setCantidad(int p_strCantidad) {
        this.m_strCantidad = p_strCantidad;
    }

    public int getiDDocumento() {
        return m_iDDocumento;
    }

    private void setiDDocumento(int p_iDDocumento) {
        this.m_iDDocumento = p_iDDocumento;
    }

    public String getMedicamento() {
        return m_strMedicamento;
    }

    private void setMedicamento(String p_strMedicamento) {
        this.m_strMedicamento = p_strMedicamento;
    }
}