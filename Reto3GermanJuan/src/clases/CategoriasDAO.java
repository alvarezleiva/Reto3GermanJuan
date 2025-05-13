
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.Functions;
import util.SqlConnection;

public class CategoriasDAO {
	public static void inserta(Categorias categoria) {
		try {
			// abro conexion
			Connection con = SqlConnection.abirConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement("insert into categorias(nombre) values(?)",
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
			PreparedStatement ps = con.prepareStatement("Select idcategoria,nombre from categorias");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1) + " Nombre: " + rs.getString(2));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Categorias> displayCategoriasLista() {
		List<Categorias> listaCategorias = new ArrayList<>();
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement("Select idcategoria,nombre from categorias");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listaCategorias.add(new Categorias(rs.getInt(1),rs.getString(2)));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCategorias;
	}

	public static void listarProductosPorCategorias() {
		Scanner sc = new Scanner(System.in);
		displayCategorias();
		int id = Functions.dimeEntero("Selecciona una categoria", sc);
		ProductosDAO.displayProductos(new Categorias(id, null));
	}

}
