package main;

import java.util.List;
import java.util.Scanner;

import clases.Categorias;
import clases.Clientes;
import clases.Productos;
import clasesDAO.CategoriasDAO;
import clasesDAO.ClientesDAO;
import clasesDAO.ClientesDAO2;
import clasesDAO.ProductosDAO;
import util.Functions;

public class MainGerman {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Clientes> clientes = ClientesDAO2.listaClientes();

		int codigo = Functions.dimeEntero("Introduce el código del cliente", sc);
		Clientes clienteExiste = null;

		for (Clientes cli : clientes) {
			if (cli.getCodigo() == codigo) {
				clienteExiste = cli;
			}
		}
		
		if(clienteExiste != null) {
			System.out.println("Pedidos del cliente ");
		}

	}
}
