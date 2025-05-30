package main;

import java.util.List;
import java.util.Scanner;

import clases.Categorias;
import clases.Productos;
import clases.Clientes;
import clasesDAO.CategoriasDAO;
import clasesDAO.ClientesDAO;

import clasesDAO.ProductosDAO;

import funcionesMain.FuncionesMain;

import util.Functions;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			option = Functions.dimeEntero("1-Mantenimientos\n2-Catalogo de productos\n3-Pedidos\n4-Informes\n5-Salir",
					sc);
			switch (option) {
			case 1:
				// 1
				do {
					option = Functions.dimeEntero(
							"1.1- Gestion de categorias\n1.2- Gestion de productos\n1.3- Gestion de clientes\n1.4- Salir",
							sc);
					switch (option) {
					case 1:
						// 1.1
						
						String nombre;
						do{
							nombre = Functions.dimeString("Dime el nombre de la categoria", sc);
						}while(nombre.equals(""));
						Categorias categoria = new Categorias();
						categoria.setNombre(nombre);

						CategoriasDAO.inserta(categoria);
						break;
					case 2:
						// 1.2
						ProductosDAO.gestionCategorias();
						break;
					case 3:
						// 1.3
						do {
							option = Functions.dimeEntero(
									"1.3.1- Alta de nuevos clientes\n1.3.2- Busqueda por codigo\n1.3.3- Salir", sc);
							switch (option) {
							case 1:
								String nombreNuevoCliente = Functions.dimeString("Introduce el nombre del cliente", sc);
								String direccionNuevoCliente = Functions
										.dimeString("Introduce la dirección del cliente", sc);
								
								List<Clientes> lista = ClientesDAO.listaClientes();
								int numeroNuevoCliente = Functions.dimeEntero("Introduce su código", sc);
								
								for (Clientes clientes : lista) {
									while(clientes.getCodigo() == numeroNuevoCliente) {
										numeroNuevoCliente = Functions.dimeEntero("Introduce su código", sc);

									}
								}

								Clientes c = new Clientes(nombreNuevoCliente, direccionNuevoCliente,
										numeroNuevoCliente);

								ClientesDAO.inserta(c);

								break;
							case 2:
								funcionesMain.FuncionesMain.busquedaPorCodigo();
								break;
								
							}
						} while (option != 3);
						break;
					}
				} while (option != 4);
				break;
			case 2:
				// 2
				do {
					option = Functions
							.dimeEntero("2.1- Listar productos por categoria\n2.2- Buscar productos\n2.3- Salir", sc);
					System.out.println(option);
					switch (option) {
					case 1:
						// 2.1
						FuncionesMain.listarProductosPorCategorias();
						break;
					case 2:
						// 2.2
						String nombre = Functions.dimeString("Dime el nombre del producto (Pulsa enter para saltar)",
								sc);
						if (nombre.isBlank()) {
							nombre = "%";
						}else {
							nombre="%"+nombre+"%";
						}
						String talla = Functions.dimeString("Dime la talla del producto (Pulsa enter para saltar)", sc);
						if (talla.isBlank()) {
							talla = "%";
						}
						String color = Functions.dimeString("Dime el color del producto (Pulsa enter para saltar)", sc);
						if (color.isBlank()) {
							color = "%";
						}
						List<Productos> listProductos = ProductosDAO.buscarProductos(nombre, talla, color);
						Functions.displayProductos(listProductos);
						break;
					}
				} while (option != 3);
				break;
			case 3:
				// 3
				do {
					option = Functions.dimeEntero("3.1- Crear pedido\n3.2- Ver pedidos\n3.3- Salir", sc);
					switch (option) {
					case 1:
						// 3.1
						FuncionesMain.crearPedido(sc);
						break;
					case 2:
						// 3.2
						FuncionesMain.verPedidos();
						break;
					}
				} while (option != 3);
				break;
			case 4:
				// 4
				do {
					option = Functions.dimeEntero(
							"4.1- Bajo stock\n4.2- Pedidos por cliente\n4.3- Pedidos mas vendidos\n4.4- Salir", sc);
					switch (option) {
					case 1:
						// 4.1
						funcionesMain.FuncionesMain.bajoStock();

						break;
					case 2:
						// 4.2
						funcionesMain.FuncionesMain.pedidosPorCliente();
						break;
					case 3:
						// 4.3
						FuncionesMain.productosMasVendidos();
						break;
					}
				} while (option != 4);
				break;
			}
		} while (option != 5);
	}
}
