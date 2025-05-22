package clasesDAO;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.Clientes;
import clases.Pedidos;
import util.Functions;
import util.SqlConnection;

/**
 * @author german y juan
 */
public class PedidosDAO {
	

	/**
	 * 
	 * @param pedido Pedido
	 * @return devuelve la key del pedido, el idcliente auto_increment
	 */
	public static int insertPedido(Pedidos pedido) {
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement("insert into pedidos (idcliente,preciototal,direccionEnvio,fecha) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, pedido.getIdCliente().getIdCliente());
			ps.setDouble(2, pedido.getPrecioTotal());
			ps.setString(3, pedido.getDireccionEnvio());
			ps.setDate(4,Functions.convierteFecha(Functions.convierte_LocalDate_a_Date(LocalDate.now())));
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next())
				return rs.getInt(1);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * 
	 * @return Devuelve una lista con todos los pedidos
	 */
	public static List<Pedidos> getPedidos() {
		try {
			List<Pedidos> pedidosList = new ArrayList<>();
			Connection con =  SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement("select idpedido,idcliente,preciototal,direccionenvio,fecha from pedidos");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pedidos pedidos = new Pedidos(rs.getInt(1), new Clientes(rs.getInt(2), null, null, 0), rs.getDouble(3), rs.getString(4), rs.getDate(5));
				pedidosList.add(pedidos);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param nMes recibe el numero de mes del que queremos ver los pedidos
	 * @return devuelve una lista con esos pedidos
	 */
	public static List<Pedidos> getPedidos(int nMes) {
		try {
			List<Pedidos> pedidosList = new ArrayList<>();
			Connection con =  SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement("select idpedido,idcliente,preciototal,direccionenvio,fecha from pedidos where month(fecha)=? order by month(fecha) desc");
			ps.setInt(1, nMes);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pedidos pedidos = new Pedidos(rs.getInt(1), new Clientes(rs.getInt(2), null, null, 0), rs.getDouble(3), rs.getString(4), rs.getDate(5));
				pedidosList.add(pedidos);
			}
			con.close();
			return pedidosList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
