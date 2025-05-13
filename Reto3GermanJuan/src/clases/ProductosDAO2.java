package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import util.Functions;
import util.SqlConnection;

public class ProductosDAO2 {

	public static void gestionProductos(Productos producto) {
		try {
			// abro conexion
			Connection con = SqlConnection.abirConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement(
					"insert into categorias(idproducto,idcategoria,nombre,precio,descripcion,color,talla,stock) values(?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, producto.getIdproducto());
			// pst.setInt(2, producto.getIdcategoria());

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

	public static void buscarProductos() {
		Scanner sc = new Scanner(System.in);
		String query = "Select idproducto, idcategoria, nombre, precio, descripcion, color, talla, stock  from productos where nombre like ? and talla like ? and color like ?";
		String nombre = Functions.dimeString("Dime el nombre del producto (Pulsa enter para saltar)", sc);
		if (nombre.isBlank()) {
			nombre = "%";
		}
		String talla = Functions.dimeString("Dime la talla del producto (Pulsa enter para saltar)", sc);
		if (talla.isBlank()) {
			talla = "%";
		}
		String color = Functions.dimeString("Dime el color del producto (Pulsa enter para saltar)", sc);
		if (color.isBlank()) {
			color = "%";
		}
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, talla);
			ps.setString(3, color);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				System.out.println("No hay productos con esos filtros");
			}
			List<Productos> productos = new ArrayList<>();
			while (rs.next()) {
				Productos producto = new Productos(rs.getInt(1), new Categorias(rs.getInt(2), null), rs.getString(3),
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
