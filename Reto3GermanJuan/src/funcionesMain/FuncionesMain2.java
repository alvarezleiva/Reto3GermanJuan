package funcionesMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.PedidoProducto;
import clases.Pedidos;
import clases.Productos;
import clasesDAO.ClientesDAO2;
import clasesDAO.PedidoProductosDAO;

public class FuncionesMain2 {
	public static void verPedidos() {
		List<Pedidos> pedidos = clasesDAO.PedidosDAO.getPedidos(LocalDate.now().getMonthValue());
		if (pedidos != null) {
			System.out.println(
					"Pedidos de " + LocalDate.now().getMonth().toString() + " de " + LocalDate.now().getYear());
			for (Pedidos pedidos2 : pedidos) {
				pedidos2.setIdCliente(ClientesDAO2.getCliente(pedidos2.getIdCliente().getIdCliente()));
				System.out.println("Fecha pedido: " + pedidos2.getFecha() + ", Cliente: "
						+ pedidos2.getIdCliente().getNombre() + ", Precio total: " + pedidos2.getPrecioTotal()
						+ ", Direccion:  " + pedidos2.getDireccionEnvio() + "\nProductos:");
				List<PedidoProducto> pps = PedidoProductosDAO.getPedidoProductos(pedidos2.getIdPedido());
				for (PedidoProducto pp : pps) {
					System.out.println(
							"Categoria: " + pp.getIdproducto().getIdcategoria().getNombre() + ", Nombre producto: "
									+ pp.getIdproducto().getNombre() + ", Unidades compradas: " + pp.getUnidades());
				}
			}
		}
	}

	public static void productosMasVendidos() {
		List<PedidoProducto> pMas = new ArrayList<>();
		List<PedidoProducto> pps = PedidoProductosDAO.getPedidoProductos();
		pps.sort(null);
		PedidoProducto pp = pps.getFirst();
		pps.remove(pp);
		while (pp.getUnidades() == pps.getFirst().getUnidades()) {
			pMas.add(pps.getFirst());
			pps.remove(pps.getFirst());
		}
		if (pMas.size() == 1) {
			System.out.println("Producto mas vendido: \nCategoria: " + pMas.getFirst().getIdproducto().getIdcategoria().getNombre()
					+", Nombre: "+ pMas.getFirst().getIdproducto().getNombre() +", Stock: "+ pMas.getFirst().getIdproducto().getStock());
		}else {for (PedidoProducto pedidoProducto : pMas) {
			System.out.println("Producto mas vendidos: \nCategoria: " + pedidoProducto.getIdproducto().getIdcategoria().getNombre()
					+", Nombre: "+ pedidoProducto.getIdproducto().getNombre() +", Stock: "+ pedidoProducto.getIdproducto().getStock());
		}
		}
	}

}
