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

	public static void crearPedido() {
		List<Clientes> clientes = listaClientes();
		Scanner sc = new Scanner(System.in);
		Clientes cliente = new Clientes();
		boolean found = false;
		do {
			int codigo = Functions.dimeEntero("Dime tu codigo de cliente", sc);
			cliente.setCodigo(codigo);
			found = Functions.searchClienteCodigo(clientes, cliente);
		} while (!found);
		List<Productos> productos = ProductosDAO.listProductos();
		Functions.displayProductos(productos);
		System.out.println("Escribe el nombre del producto para annadirlo, pulsa enter para acabar");
		found = false;
		String nombre = "";
		Productos producto = new Productos();
		PedidoProducto pedidoProducto = new PedidoProducto();
		List<PedidoProducto> pedidoProductos = new ArrayList<>();
		do {
			do {
				nombre = Functions.dimeString("", sc);
				producto.setNombre(nombre);
				found = Functions.searchProductoNombre(productos, producto);
				if (!found)
					System.out.println("Introduce un producto valido");
				else if (pedidoProductos.contains(pedidoProducto)) {
					System.out.println("Introduce un producto distinto");
				}
			} while (!found || pedidoProductos.contains(pedidoProducto));
			int unidades = Functions.dimeEntero("Cuantas unidades quieres?", sc);
			while (unidades < 1) {
				unidades = Functions.dimeEntero("Debes seleccionar una o mas unidades", sc);
			}
			if (producto.getStock() < unidades) {
				System.out.println("No tenemos tantas unidades disponibles, se han annadido el maximo posible");
				pedidoProducto.setUnidades(producto.getStock());
			} else
				pedidoProducto.setUnidades(unidades);
			pedidoProducto.setIdproducto(producto);
			pedidoProductos.add(pedidoProducto);
		} while (!nombre.equals(""));
		
		String direccion = Functions.dimeString("Su direccion es: "+cliente.getDireccion()+". Desea cambiarla? (Si/No)", sc);
		if (direccion.equalsIgnoreCase("si")) {
			direccion=Functions.dimeString("Introduzca la nueva direccion", sc);
			for (PedidoProducto pedidoProducto2 : pedidoProductos) {
				pedidoProducto2.getIdpedido().setDireccionEnvio(direccion);
			}
		}

	}

}
