package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.SqlConnection;

public class ProductosDAO {
	
	
	public static void gestionProductos(Productos producto) {
		try {
			// abro conexion
			Connection con = SqlConnection.abirConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement(
					"insert into categorias(idproducto,idcategoria,nombre,precio,descripcion,color,talla,stock) values(?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, producto.getIdproducto());
			pst.setInt(2, producto.getIdcategoria());
			
			pst.execute();
			// recupero clave
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
				
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlConnection.cierraConexion();
		}
	}
	
	
	
	
	
public static void main(String[] args) {
		
	
		
		
	}








































































}


















