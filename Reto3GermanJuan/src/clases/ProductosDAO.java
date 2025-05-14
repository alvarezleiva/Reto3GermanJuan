
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

public class ProductosDAO {

	public static void gestionProductos(Productos producto) {
		try {
			// abro conexion
			Connection con = SqlConnection.abirConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement(
					"insert into productos(idproducto,idcategoria,nombre,precio,descripcion,color,talla,stock) values(?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, producto.getIdproducto());

			pst.setInt(2, producto.getIdcategoria().getIdCategoria());
			pst.setString(3, producto.getNombre());
			pst.setDouble(4, producto.getPrecio());
			pst.setString(5, producto.getDescripcion());
			pst.setString(6, producto.getColor());
			pst.setString(7, producto.getTalla());
			pst.setInt(8, producto.getStock());

			pst.execute();
			// recupero clave
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
				producto.setIdproducto(rs.getInt(1));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlConnection.cierraConexion();
		}
	}



	public static void displayProductos(Categorias categoria) {
		try {
			int idCategoria = categoria.getIdCategoria();
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(
					"Select idproducto, idcategoria, nombre, precio, descripcion, color, talla, stock  from productos where idcategoria = ?");
			ps.setInt(1, idCategoria);
			ResultSet rs = ps.executeQuery();
			List<Productos> productos = new ArrayList<>();
			if (!rs.next())
				System.out.println("La categoria introducida no tiene productos o no extiste");
			while (rs.next()) {
				Productos producto = new Productos(rs.getInt(1), new Categorias(idCategoria, null), rs.getString(3),
						rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				productos.add(producto);
			}
			for (Productos productos2 : productos) {
				System.out.println(productos2.toString());
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
