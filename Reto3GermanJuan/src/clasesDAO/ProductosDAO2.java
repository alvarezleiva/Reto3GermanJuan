package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import clases.Categorias;
import clases.Productos;
import util.Functions;
import util.SqlConnection;

public class ProductosDAO2 {

	public static List<Productos> buscarProductos(String nombre,String talla,String color) {
		List<Productos> productos = new ArrayList<>();
		String query = "Select idproducto, idcategoria, nombre, precio, descripcion, color, talla, stock  from productos where nombre like ? and talla like ? and color like ?";
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, talla);
			ps.setString(3, color);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Productos producto = new Productos(rs.getInt(1), new Categorias(rs.getInt(2), null), rs.getString(3),
						rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				productos.add(producto);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}
	

}
