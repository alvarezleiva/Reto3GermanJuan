package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Categorias;
import clases.Clientes;
import clases.PedidoProducto;
import clases.Pedidos;
import clases.Productos;
import util.SqlConnection;

public class PedidoProductosDAO {
	public static void insertPedidoProductos(PedidoProducto pedidoProducto) {
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(
					"insert into pedidoproducto (idpedido,idproducto,unidades,precio) values (?,?,?,?)");
			ps.setInt(1, pedidoProducto.getIdpedido().getIdPedido());
			ps.setInt(2, pedidoProducto.getIdproducto().getIdproducto());
			ps.setInt(3, pedidoProducto.getUnidades());
			ps.setDouble(4, pedidoProducto.getPrecio());
			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<PedidoProducto> getPedidoProductos(int idPedido) {
		List<PedidoProducto> pp = null;
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(
					"select  categorias.nombre,productos.nombre,pedidoproducto.unidades  from pedidoproducto\r\n"
							+ "inner join productos on pedidoproducto.idproducto = productos.idproducto\r\n"
							+ "inner join categorias on productos.idcategoria = categorias.idcategoria\r\n"
							+ "where pedidoproducto.idpedido = ?;");
			ps.setInt(1, idPedido);
			ResultSet rs = ps.executeQuery();
			pp = new ArrayList<>();
			while (rs.next()) {
				Productos productos = new Productos();
				Categorias categorias = new Categorias(0, rs.getString(1));
				productos.setNombre(rs.getString(2));
				productos.setIdcategoria(categorias);
				pp.add(new PedidoProducto(0, null, productos, rs.getInt(3), 0));
			}
			con.close();
			return pp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pp;
	}

	public static List<PedidoProducto> pedidosPorCliente(int codigoCliente) {
		List<PedidoProducto> pedidoP = null;

		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement(
					"select cli.codigo, pe.fecha, pp.precio,pe.direccionEnvio, cat.nombre, pro.nombre,pp.unidades from pedidoproducto pp\r\n"
							+ "inner join pedidos pe on pp.idpedido = pe.idpedido\r\n"
							+ "inner join productos pro on pp.idproducto = pro.idproducto\r\n"
							+ "inner join categorias cat on pro.idcategoria = cat.idcategoria\r\n"
							+ "inner join clientes cli on pe.idcliente = cli.idcliente\r\n" + "where cli.codigo=?");
			ps.setInt(1, codigoCliente);
			ResultSet rs = ps.executeQuery();
			pedidoP = new ArrayList<>();
			while (rs.next()) {
				Pedidos pe = new Pedidos(rs.getString("direccionEnvio"),
						rs.getDate("fecha"));
				Categorias cat = new Categorias(rs.getString("nombre"));
				Productos pro = new Productos(0, cat, rs.getString("nombre"), 0, "", "", "", 0);
				PedidoProducto pp = new PedidoProducto(0, pe, pro, rs.getInt("unidades"),
						rs.getDouble("precio"));
				pedidoP.add(pp);
			}
			con.close();
			return pedidoP;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidoP;

	}

}
