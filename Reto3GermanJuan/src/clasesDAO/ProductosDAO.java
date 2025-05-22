


package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clases.Categorias;
import clases.Productos;
import util.Functions;
import util.SqlConnection;

/**
 * @author german y juan
 */

public class ProductosDAO {
	
	/**
	 * 
	 * @param Recibe el producto que vamos a insertar en la BBDD
	 */

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
	
	/**
	 * 
	 * @param Recibe la categoría de la que queremos mostrar los productos
	 * @return devuelve una lista de productos con esa categoría
	 */

	public static List<Productos> getProductos(Categorias categoria) {
		List<Productos> productos;
		try {
			int idCategoria = categoria.getIdCategoria();
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(
					"Select idproducto, idcategoria, nombre, precio, descripcion, color, talla, stock  from productos where idcategoria = ?");
			ps.setInt(1, idCategoria);
			ResultSet rs = ps.executeQuery();
			productos = new ArrayList<>();
			if (!rs.next())
				System.out.println("La categoria introducida no tiene productos o no extiste");
			while (rs.next()) {
				Productos producto = new Productos(rs.getInt(1), new Categorias(idCategoria, null), rs.getString(3),
						rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				productos.add(producto);
			}
			con.close();
			return productos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return devuelve una lista de todos los productos
	 */
	public static List<Productos> listProductos() {
		List<Productos> productos = null;
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(
					"Select idproducto, idcategoria, nombre, precio, descripcion, color, talla, stock  from productos");
			ResultSet rs = ps.executeQuery();
			productos = new ArrayList<>();
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
	
	/**
	 *  Esta funcion crea una categoria validando que no tenga el mismo id que otra
	 */
	public static void gestionCategorias() {
		Scanner sc = new Scanner(System.in);

		String nombre = Functions.dimeString("Introduce el nombre", sc);
		double precio = Functions.dimeDouble("Introduce el precio", sc);
		String descripcion = Functions.dimeString("Introduce su descripción", sc);
		String color = Functions.dimeString("Introduce su color", sc);
		String talla = Functions.dimeString("Introduce su talla", sc);
		int stock = Functions.dimeEntero("Introduce stock", sc);

		Productos pro = new Productos(nombre, precio, descripcion, color, talla, stock);

		List<Categorias> list = CategoriasDAO.getCategorias();
		boolean existe = false;
		for (Categorias categorias : list) {
			System.out.println(categorias.toString());
		}

		do {

			int idCategoria = Functions.dimeEntero("Introduce el idCategoria", sc);
			for (Categorias categorias : list) {
				if (idCategoria == categorias.getIdCategoria()) {
					pro.setIdcategoria(new Categorias(idCategoria, null));
					existe = true;
					break;
				}
			}

		} while (!existe);

		ProductosDAO.gestionProductos(pro);
	}

	/**
	 * 
	 * @return devuelve una lista con todos los productos con un stock menor al deseado.
	 */
	public static List<Productos> bajoStock() {

		List<Productos> productos = new ArrayList<>();
		try {
			int stock = 5;

			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(
					"select p.nombre,p.idcategoria, p.precio,p.descripcion,p.color,p.talla,p.stock from productos p\r\n"
							+ "inner join categorias c on c.idcategoria = p.idcategoria\r\n" + "where stock <?");
			ps.setInt(1, stock);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Productos producto = new Productos(new Categorias(rs.getInt("idcategoria"), null),
						rs.getString("nombre"), rs.getDouble("precio"), rs.getString("descripcion"),
						rs.getString("color"), rs.getString("talla"), rs.getInt("stock"));
				productos.add(producto);
			}
			
			for (Productos productos2 : productos) {
				System.out.println(productos2.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;

	}
	
	/**
	 * 
	 * @param recibe el la nueva cantidad de stock que queremos en los productos
	 */

	public static void actualizarStock(int stock) {
		try {

			int minimo = 5;
			// abro conexion
			Connection con = SqlConnection.abirConexion();
			// genero el sql
			PreparedStatement pst = con
					.prepareStatement("update productos\r\n" + "set stock = stock + ?\r\n" + "where stock <=?");
			pst.setInt(1, stock);
			pst.setInt(2, minimo);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlConnection.cierraConexion();
		}

	}
	

	/**
	 * 
	 * @param recibe el nombre por el que queremos buscar al producto
	 * @param recibe la talla por la que queremos buscar el producto
	 * @param recibe el color por el que queremos buscar el producto
	 * @return devuelve una lista con los productos filtrados por esas características
	 */

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
	/**
	 * 
	 * @param recibe el idProducto 
	 * @param recibe la cantidad a restar el stock
	 */
	public static void updateStock(int idProducto,int cantidad) {
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement pst = con
					.prepareStatement("update productos set stock = stock - ? where idProducto =  ?;");
			pst.setInt(1, cantidad);
			pst.setInt(2,idProducto);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlConnection.cierraConexion();
		}
	}
	
}
