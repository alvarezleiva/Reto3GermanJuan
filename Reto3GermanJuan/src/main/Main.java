package main;

import java.util.Scanner;

import util.Functions;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option=0;
		do {
			option=Functions.dimeEntero("1-Mantenimientos\n2-Catalogo de productos\n3-Pedidos\n4-Informes\n5-Salir", sc);
		} while (option!=5);
	}
}
