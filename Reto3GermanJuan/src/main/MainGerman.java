package main;

import java.util.List;
import java.util.Scanner;

import clases.Categorias;
import clases.CategoriasDAO;
import clases.Clientes;
import clases.Productos;
import clases.ProductosDAO;
import util.Functions;
import clases.ClientesDAO;

public class MainGerman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	String nombre = Functions.dimeString("Introduce el nombre del cliente", sc);
	String direccion = Functions.dimeString("Introduce la dirección del cliente", sc);
	int numero = Functions.dimeEntero("Introduce su código", sc);
	Clientes c = new Clientes(nombre,direccion, numero);
	
	ClientesDAO.inserta(c);
	

	}
}
