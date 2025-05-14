package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.Functions;
import util.SqlConnection;

public class ClientesDAO2 {
	public static List<Clientes> listaClientes () {
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
	public static void crearPedido() {
		List<Clientes> clientes = listaClientes();
		Scanner sc = new Scanner(System.in);
		int codigo;
		boolean found=false;
		do {
			codigo=Functions.dimeEntero("Dime tu codigo de cliente", sc);
			for (Clientes clientes2 : clientes) {
				if (clientes2.getCodigo()==codigo) {
					found=true;
					break;
				}
			}
		} while (!found);
	}
}
