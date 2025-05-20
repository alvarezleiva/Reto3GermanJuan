package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Categorias;
import clases.PedidoProducto;
import clases.Pedidos;
import clases.Productos;
import util.SqlConnection;

public class PedidoProductosDAO {
	public static void insertPedidoProductos(PedidoProducto pedidoProducto) {
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement("insert into pedidoproducto (idpedido,idproducto,unidades,precio) values (?,?,?,?)");
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
			PreparedStatement ps = con.prepareStatement("select  categorias.nombre,productos.nombre,pedidoproducto.unidades  from pedidoproducto\r\n"
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
	
}
