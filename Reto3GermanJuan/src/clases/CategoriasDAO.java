package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.SqlConnection;


public class CategoriasDAO {
	public static void inserta(Categorias categoria) {
		try {
			// abro conexion
			Connection con = SqlConnection.abirConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement(
					"insert into categorias(nombre) values(?)",
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, categoria.getNombre());
			pst.execute();
			// recupero clave
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
				categoria.setIdCategoria(rs.getInt(1));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlConnection.cierraConexion();
		}
}
	public static void displayCategorias() {
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement("Select idcategoria,nombre from categoria");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Id: "+rs.getInt(1)+" Nombre: "+rs.getString(2));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	
		
		
	}
	}
	


