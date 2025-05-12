package main;

import java.util.Scanner;

import clases.Categorias;
import clases.CategoriasDAO;
import util.Functions;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option=0;
		do {
			option=Functions.dimeEntero("1-Mantenimientos\n2-Catalogo de productos\n3-Pedidos\n4-Informes\n5-Salir", sc);
			switch (option) {
			case 1:
				// 1
				do {
					option=Functions.dimeEntero("1.1- Gestion de categorias\n1.2- Gestion de productos\n1.3- Gestion de clientes\n1.4- Salir", sc);
					switch (option) {
					case 1:
						// 1.1
						String nombre = Functions.dimeString("Dime el nombre de la categoria", sc);
						Categorias categoria = new Categorias();
						categoria.setNombre(nombre);
						
						CategoriasDAO.inserta(categoria);
						break;
					case 2:
						// 1.2
						break;
					case 3:
						// 1.3
						do {
							option = Functions.dimeEntero("1.3.1- Alta de nuevos clientes\n1.3.2- Busqueda por codigo\n1.3.3- Salir", sc);
							switch (option) {
							case 1:
								// 1.3.1
								break;
							case 2:
								// 1.3.2
								break;
							}
						} while (option!=3);
						break;
					}
				} while (option!=4);
				break;
			case 2:
				// 2
				do {
					option=Functions.dimeEntero("2.1- Listar productos por categoria\n2.2- Buscar productos\n2.3- Salir", sc);
					switch (option) {
					case 1:
						// 2.1
						
						break;
					case 2:
						// 2.2
						
						break;
					}
				} while (option!=3);
				break;
			case 3: 
				// 3
				do {
					option=Functions.dimeEntero("3.1- Crear pedido\n 3.2- Ver pedidos\n3.3- Salir", sc);
					switch (option) {
					case 1:
						// 3.1
						
						break;
					case 2:
						// 3.2
						
						break;
					}
				} while (option!=3);
				break;
			case 4:
				// 4
				do {
					option=Functions.dimeEntero("4.1- Bajo stock\n4.2- Pedidos por cliente\n4.3- Pedidos mas vendidos\n4.4- Salir", sc);
					switch (option) {
					case 1:
						// 4.1
						
						break;
					case 2:
						// 4.2
						
						break;
					case 3:
						// 4.3
						
						break;
					}
				} while (option!=3);
				break;
			}
		} while (option!=5);
	}
}
