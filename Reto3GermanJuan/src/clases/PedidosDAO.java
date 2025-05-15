package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import util.Functions;
import util.SqlConnection;

public class PedidosDAO {
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

}
