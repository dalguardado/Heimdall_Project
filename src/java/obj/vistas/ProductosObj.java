
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
public class ProductosObj {
 

   
    private int m_strID;
    private String m_strMedicamento;
    private int m_strStock;
    private String m_strPresentacion;
    private String m_strCategoria;
    private String m_strReceta;
    private String m_strSucursal;
    private double m_strPrecio;
    
    
    public ProductosObj(int p_strID, String p_strMedicamento, int p_strStock, String p_strPresentacion, String p_strCategoria, String p_strReceta, String p_strSucursal, double p_strPrecio) 
    {
    
        
        
        
        setID(p_strID);
        setMedicamento(p_strMedicamento);
        setStock(p_strStock);
        setPresentacion(p_strPresentacion);
        setCategoria(p_strCategoria);
        setReceta(p_strReceta);
        setSucursal(p_strSucursal);
        setPrecio(p_strPrecio);
        
    }

    public int getID() {
        return m_strID;
    }

    private void setID(int p_strID) {
        this.m_strID = p_strID;
    }

    public String getMedicamento() {
        return m_strMedicamento;
    }

    private void setMedicamento(String p_strMedicamento) {
        this.m_strMedicamento = p_strMedicamento;
    }

    public int getStock() {
        return m_strStock;
    }

    private void setStock(int p_strStock) {
        this.m_strStock = p_strStock;
    }

    public String getPresentacion() {
        return m_strPresentacion;
    }

    private void setPresentacion(String p_strPresentacion) {
        this.m_strPresentacion = p_strPresentacion;
    }

    public String getCategoria() {
        return m_strCategoria;
    }

    private void setCategoria(String p_strCategoria) {
        this.m_strCategoria = p_strCategoria;
    }

    public String getReceta() {
        return m_strReceta;
    }

    private void setReceta(String p_strReceta) {
        this.m_strReceta = p_strReceta;
    }

    public String getSucursal() {
        return m_strSucursal;
    }

    private void setSucursal(String p_strSucursal) {
        this.m_strSucursal = p_strSucursal;
    }
    
    public double getPrecio() {
        return m_strPrecio;
    }

    private void setPrecio(double p_strPrecio) {
        this.m_strPrecio = p_strPrecio;
}
}
    
    
    
   