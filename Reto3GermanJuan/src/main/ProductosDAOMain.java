package main;

import java.util.List;
import java.util.Scanner;

import clases.Categorias;
import clases.CategoriasDAO;
import clases.Productos;
import clases.ProductosDAO;
import util.Functions;

public class ProductosDAOMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String nombre = Functions.dimeString("Introduce el nombre", sc);
		double precio = Functions.dimeDouble("Introduce el precio", sc);
		String descripcion = Functions.dimeString("Introduce su descripción", sc);
		String color = Functions.dimeString("Introduce su color", sc);
		String talla = Functions.dimeString("Introduce su talla", sc);
		int stock = Functions.dimeEntero("Introduce stock", sc);

		Productos pro = new Productos(nombre, precio, descripcion, color, talla, stock);

		List<Categorias> list = CategoriasDAO.displayCategoriasLista();
		boolean existe = false;
		for (Categorias categorias : list) {
			System.out.println(categorias.toString());
		}

		do {
			int idCategoria = Functions.dimeEntero("Introduce el idCategoria", sc);
			for (Categorias categorias : list) {
				if (idCategoria == categorias.getIdCategoria()) {
					pro.setIdcategoria(new Categorias(idCategoria, null));
					existe = true;
					break;
				}
			}

		} while (!existe);
		
		ProductosDAO.gestionProductos(pro);

	}
}
