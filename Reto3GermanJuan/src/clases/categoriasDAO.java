package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.SqlConnection;


public class categoriasDAO {
	public static void inserta(categorias categoria) {
		try {
			// abro conexion
			Connection con = SqlConnection.abirConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement(
					"insert into categorias(nombre) values(?)",
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(2, categoria.getNombre());
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
	public static void main(String[] args) {
		
		
		
	}
	}
	


