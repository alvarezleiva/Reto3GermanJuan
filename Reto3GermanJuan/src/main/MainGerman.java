package main;

import java.util.List;
import java.util.Scanner;

import clases.Categorias;
import clases.Clientes;
import clases.PedidoProducto;
import clases.Productos;
import clasesDAO.CategoriasDAO;
import clasesDAO.ClientesDAO;
import clasesDAO.ClientesDAO2;
import clasesDAO.PedidoProductosDAO;
import clasesDAO.ProductosDAO;
import funcionesMain.FuncionesMain;
import util.Functions;

public class MainGerman {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Clientes> list = ClientesDAO2.listaClientes();
		for (Clientes clientes : list) {
			System.out.println(clientes.getCodigo());
		}
		Clientes cliente = new Clientes();

		boolean found = false;
		do {
			cliente.setCodigo(Functions.dimeEntero("Introduce un codigo de cliente", sc));

			found = Functions.searchClienteCodigo(list, cliente);
		} while (!found);

		if (cliente != null) {
			List<PedidoProducto> prod = PedidoProductosDAO.pedidosPorCliente(cliente.getCodigo());

			if (prod.isEmpty()) {
				System.out.println("Este cliente no tiene pedidos");
			} else {
				for (PedidoProducto pedidoProducto : prod) {
					System.out.println("direccion envio: " + pedidoProducto.getIdpedido().getDireccionEnvio()
							+ ", nombre prod: " + pedidoProducto.getIdproducto().getNombre() + ", unidades vendidas: "
							+ pedidoProducto.getUnidades() + ", precio total: " + pedidoProducto.getPrecio()
							+ ", fecha: " + pedidoProducto.getIdpedido().getFecha() + ",categoria: "
							+ pedidoProducto.getIdproducto().getIdcategoria().getNombre());
				}
			}
		}

	}

}
