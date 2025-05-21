package clasesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Clientes;
import util.SqlConnection;

public class ClientesDAO {
	public static void inserta(Clientes cliente) {
		try {
			// abro conexion
			Connection con = SqlConnection.abirConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement("insert into clientes(nombre, direccion, codigo) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getDireccion());
			pst.setInt(3, cliente.getCodigo());
			pst.execute();
			// recupero clave
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
				cliente.getIdCliente();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlConnection.cierraConexion();
		}
	}
	
	public static void actualiza(Clientes cliente)
	{
		try {
			//abro conexion
			Connection con = SqlConnection.abirConexion();
			//genero el sql
			PreparedStatement pst = con.prepareStatement("update clientes set nombre=?, direccion=?, codigo=? where idCliente=?");
			pst.setString(1,cliente.getNombre());
			pst.setString(2,cliente.getDireccion());
			pst.setInt(3, cliente.getCodigo());
			pst.setInt(4, cliente.getIdCliente());
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			SqlConnection.cierraConexion();
		}

	}
	public static List<Clientes> listaClientes() {
		List<Clientes> list = null;
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement("SELECT idcliente,nombre,direccion,codigo from clientes");
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Clientes getCliente(int idCliente) {
		Clientes cliente =null;
		try {
			Connection con = SqlConnection.abirConexion();
			PreparedStatement ps = con.prepareStatement("SELECT idcliente,nombre,direccion,codigo from clientes where idcliente = ?");
			ps.setInt(1, idCliente);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente= new Clientes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
}
