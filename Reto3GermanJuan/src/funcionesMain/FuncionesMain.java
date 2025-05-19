package funcionesMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import clasesDAO.*;
import clases.Clientes;
import clases.PedidoProducto;
import clases.Pedidos;
import clases.PedidosDAO;
import clases.Productos;
import util.Functions;

public class FuncionesMain {
	
	
	public static void crearPedido(Scanner sc) {
		List<Clientes> clientes = ClientesDAO2.listaClientes();
		Clientes cliente = new Clientes();
		boolean found = false;
		do {
			int codigo = Functions.dimeEntero("Dime tu codigo de cliente", sc);
			cliente.setCodigo(codigo);
			for (Clientes clientes2 : clientes) {
				if (clientes2.getCodigo()==cliente.getCodigo()) {
					found = true;
					cliente=clientes2;
					break;
				}
			}
		} while (!found);
		List<Productos> productos = ProductosDAO.listProductos();
		Functions.displayProductos(productos);
		found = false;
		String nombre = "";
		Productos producto = new Productos();
		PedidoProducto pedidoProducto = new PedidoProducto();
		List<PedidoProducto> pedidoProductos = new ArrayList<>();
		int unidades = 0;
		do {
			System.out.println("Escribe el nombre del producto para annadirlo, pulsa enter para acabar");
			do {
				nombre = sc.nextLine();
				if (nombre.isBlank()) {
					break;
				}
				for (Productos productos2 : productos) {
					if (productos2.getNombre().equalsIgnoreCase(nombre)) {
						producto=productos2;
						break;
					}
				}
				found = Functions.searchProductoNombre(productos, producto);
				if (!found)
					System.out.println("Introduce un producto valido");
				else if (pedidoProductos.contains(pedidoProducto)) {
					System.out.println("Introduce un producto distinto");
				}
			} while (!found || pedidoProductos.contains(pedidoProducto));
			if (!nombre.isBlank()) {
				unidades = Functions.dimeEntero("Cuantas unidades quieres?", sc);
				while (unidades < 1) {
					unidades = Functions.dimeEntero("Debes seleccionar una o mas unidades", sc);
				}
				if (producto.getStock() < unidades) {
					System.out.println("No tenemos tantas unidades disponibles, se han annadido el maximo posible");
					pedidoProducto.setUnidades(producto.getStock());
					unidades = producto.getStock();
				} else
					pedidoProducto.setUnidades(unidades);
				pedidoProducto.setIdproducto(producto);
				pedidoProducto.setIdpedido(new Pedidos());
				pedidoProducto.getIdpedido().setIdCliente(cliente);
				pedidoProductos.add(pedidoProducto);
			}
		} while (!nombre.isBlank());
		if (pedidoProductos.size()>=1) {
			String direccion = Functions
					.dimeString("Su direccion es: " + cliente.getDireccion() + ". Desea cambiarla? (Si/No)", sc);
			if (direccion.equalsIgnoreCase("si")) {
				direccion = Functions.dimeString("Introduzca la nueva direccion", sc);
				for (PedidoProducto pedidoProducto2 : pedidoProductos) {
					pedidoProducto2.getIdpedido().setDireccionEnvio(direccion);
				}
			}else {
				for (PedidoProducto pedidoProducto2 : pedidoProductos) {
					pedidoProducto2.getIdpedido().setDireccionEnvio(pedidoProducto2.getIdpedido().getIdCliente().getDireccion());
				}
			}
			for (PedidoProducto pedidoProducto2 : pedidoProductos) {
				pedidoProducto2.getIdpedido().setIdCliente(cliente);
				pedidoProducto2.getIdpedido().setPrecioTotal(pedidoProducto.getIdproducto().getPrecio() * unidades);
				pedidoProducto2.setPrecio(pedidoProducto.getIdproducto().getPrecio() * unidades);
				int idPedido=PedidosDAO.insertPedido(pedidoProducto2.getIdpedido());
				pedidoProducto2.getIdpedido().setIdPedido(idPedido);
				PedidoProductosDAO.insertPedidoProductos(pedidoProducto2);
			}
			System.out.println("Annadido con exito");
		}
	}
	public static verPedidos () {
		
	}
}
