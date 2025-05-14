package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Functions;
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
}
