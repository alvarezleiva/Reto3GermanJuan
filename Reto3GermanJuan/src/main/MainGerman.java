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
import clases.ClientesDAO2;

public class MainGerman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Clientes> list = ClientesDAO2.listaClientes();
		boolean codigoRepetido = true;

		System.out.println("----Código de los clientes----");
		for (Clientes clientes : list) {

			System.out.println(clientes.getCodigo());
		}
		int codigo = Functions.dimeEntero("Introduce el código del cliente", sc);
		Clientes clienteExiste = null;

		for (Clientes clientes : list) {
			if (codigo == clientes.getCodigo()) {
				clienteExiste = clientes;
				break;
			}
		}

		if (clienteExiste != null) {
			System.out.println("Datos del cliente:");
			System.out.println(clienteExiste);

			String nombreUpdate = Functions.dimeString("Introduce su nuevo nombre", sc);
			String direccionUpdate = Functions.dimeString("Introduce su nueva direccion", sc);
			int codigoUpdate = 0;
			clienteExiste.setNombre(nombreUpdate);
			clienteExiste.setDireccion(direccionUpdate);

			do {
				codigoUpdate = Functions.dimeEntero("Introduce su nuevo codigo", sc);
				codigoRepetido = false;

				for (Clientes clientes : list) {
					if (codigoUpdate == clientes.getCodigo()) {
						System.out.println("Ese codigo existe. Introduce otro");
						codigoRepetido = true;
						break;
					}
				}

			} while (codigoRepetido);
			clienteExiste.setCodigo(codigoUpdate);

			ClientesDAO.actualiza(clienteExiste);
			System.out.println("Cliente actualizado");

		} else {
			System.out.println("No existe ese cliente");
		}

		sc.close();

	}
}
