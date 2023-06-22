package simpleCrud.application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "─────█─▄▀█──█▀▄─█──\n"
				+ "────▐▌──────────▐▌──\n"
				+ "────█▌▀▄──▄▄──▄▀▐█──\n"
				+ "───▐██──▀▀──▀▀──██▌──\n"
				+ "──▄████▄──▐▌──▄████▄─\n"
				+ "\n"
				+ "");
		System.out.println("WELCOME TO SIMPLE CRUD");
		System.out.println();
		System.out.println("Escolha uma opção:");
		
		String q = "1- list users\n 2- search user\n 3- add user\n 4- update user\n 5- delete user\n 6- sair";
		
		String resp;
		
		do {
			System.out.println(q);
			resp = sc.next();
			
			if(resp.equals("1")) {
				System.out.println("vc digitou 1");
				System.out.println();
			}else if(resp.equals("2")) {
				System.out.println("vc digitou 2");
				System.out.println();
			}else if(resp.equals("3")) {
				System.out.println("vc digitou 3");
				System.out.println();
			}else if(resp.equals("4")) {
				System.out.println("vc digitou 4");
				System.out.println();
			}else if(resp.equals("5")) {
				System.out.println("vc digitou 5");
				System.out.println();
			}else if(resp.equals("6")) {
				break;
			}else {
				System.out.println("Opção inválida! Digite outra opção!");
			}
			
		}while(true);
		
		sc.close();
	}
}
