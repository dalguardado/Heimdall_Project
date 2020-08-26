/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Farmacia;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import obj.vistas.ComprasObj;
import obj.vistas.ProductosObj;

public class LogicUser extends Logic
{
    public LogicUser(String pConnectionString) {
        super(pConnectionString);
    }

   
    public boolean insertUser(String p_strNombre, String p_strApellido, String p_strDUI,String p_strCorreo, String p_strDireccion, String p_strTelefono, String p_strNumero_registro_fiscal,
            String p_strUser, String p_strContraseña)  
    {
        boolean hasFailed;
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO heimdall2.cliente"
                + "(IDcliente, nombre, apellido,DUI, correo, direccion, telefono, numero_registro_fiscal, user, contraseña) "
                + "VALUES('0','"+p_strNombre+"','"+p_strApellido+"','"+p_strDUI+"','"+p_strCorreo+"','"+p_strDireccion+"','"+p_strTelefono+"','"+p_strNumero_registro_fiscal+"','"+p_strUser+"','"+p_strContraseña+"');";
        hasFailed = database.executeNonQueryBool(strSql);
        return hasFailed;
    }
    
    public List<ComprasObj> getCompras() 
    {
        List<ComprasObj> CList = null;
        DatabaseX CDatabase = getDatabase();
        String strSql = "SELECT * FROM heimdall2.compras_vista";
        ResultSet CResult = CDatabase.executeQuery(strSql);
        
        
        if(CResult!=null)
        {
            try 
            {
                int ID;
                double Precio;
                int Cantidad;
                int Documento;
                String Medicamento;
                ComprasObj CTemp;
                
               
                
                CList = new ArrayList<>();
                
                while(CResult.next())
                {
                    ID = CResult.getInt("id");
                    Precio = CResult.getDouble("Precio");
                    Cantidad = CResult.getInt("Cantidad");
                    Documento = CResult.getInt("IDdocumentoCompra");
                    Medicamento = CResult.getString("Medicamento");
                    CTemp = new ComprasObj(ID, Precio, Cantidad , Documento, Medicamento);
                    CList.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(LogicUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return CList;
    }

public UserObj getUser(String p_Username, 
            String p_Password) 
    {
        
    DatabaseX database = getDatabase();
           String strSql = "SELECT * "
                + "FROM heimdall2.cliente "
                + "where user like '"+p_Username+"' "
                + "and contraseña like '"+p_Password+"'; " ;           
    ResultSet result = database.executeQuery(strSql);
    
    UserObj temp = null;
    
    if(result!=null)
    {
        try 
        {
            int id;
            String nombre;
            String apellido;
            String DUI;        
            String correo;
            String direccion;
            String telefono;
            String numero;
            String user;
            String password;
            int idtype;
            while (result.next())
            {
                id = result.getInt("IDcliente");
                nombre = result.getString("nombre");
                apellido = result.getString("apellido");
                DUI = result.getString("DUI");
                correo = result.getString("correo");
                direccion = result.getString("direccion");
                telefono = result.getString("telefono");
                numero = result.getString("numero_registro_fiscal");
                user = result.getString("user");
                password = result.getString("contraseña");
                
                temp = new UserObj(user, password);
            }
        }
        catch (SQLException ex) 
            {
                Logger.getLogger(LogicUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return temp;
    }

 public List<ProductosObj> getProductos() 
    {
        List<ProductosObj> PList = null;
        DatabaseX CDatabase = getDatabase();
        String strSql = "SELECT * FROM heimdall2.productos_vista";
        ResultSet CResult = CDatabase.executeQuery(strSql);
        
        
        if(CResult!=null)
        {
            try 
            {
                int ID;
                String Medicamento;
                int Stock;
                String Presentacion;
                String Categoria;
                String Receta;
                String Sucursal;
                double Precio;
                ProductosObj CTemp;
                
               
                
                PList = new ArrayList<>();
                
                while(CResult.next())
                {
                    ID = CResult.getInt("id");
                    Medicamento = CResult.getString("Medicamento");
                    Stock = CResult.getInt("stock");
                    Presentacion = CResult.getString("Presentacion");
                    Categoria = CResult.getString("Categoria");
                    Receta = CResult.getString("Receta");
                    Sucursal = CResult.getString("Sucursal");
                    Precio = CResult.getDouble("precio");
                    
                    CTemp = new ProductosObj(ID, Medicamento, Stock , Presentacion, Categoria, Receta, Sucursal,Precio);
                    PList.add(CTemp);
                }
            } 
            catch (SQLException ex) 
               {
                Logger.getLogger(LogicUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return PList;
    }
}
