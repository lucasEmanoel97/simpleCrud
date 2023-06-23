package simpleCrud.application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import simpleCrud.entities.User;
import simpleCrud.model.dao.DaoFactory;
import simpleCrud.model.dao.UserDao;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" ██░▀██████████████▀░██\n"
				+ "   █▌▒▒░████████████░▒▒▐█\n"
				+ "   █░▒▒▒░██████████░▒▒▒░█\n"
				+ "   ▌░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▐\n"
				+ "   ░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░\n"
				+ "███▀▀▀██▄▒▒▒▒▒▒▒▄██▀▀▀██\n"
				+ "██░░░▐█░▀█▒▒▒▒▒█▀░█▌░░░█\n"
				+ "▐▌░░░▐▄▌░▐▌▒▒▒▐▌░▐▄▌░░▐▌\n"
				+ "   █░░░▐█▌░░▌▒▒▒▐░░▐█▌░░█\n"
				+ "   ▒▀▄▄▄█▄▄▄▌░▄░▐▄▄▄█▄▄▀▒\n"
				+ "   ░░░░░░░░░░└┴┘░░░░░░░░░\n"
				+ "   ██▄▄░░░░░░░░░░░░░░▄▄██\n"
				+ "   ████████▒▒▒▒▒▒████████\n"
				+ "   █▀░░███▒▒░░▒░░▒▀██████\n"
				+ "   █▒░███▒▒╖░░╥░░╓▒▐█████\n"
				+ "   █▒░▀▀▀░░║░░║░░║░░█████\n"
				+ "   ██▄▄▄▄▀▀┴┴╚╧╧╝╧╧╝┴┴███\n"
				+ "   ██████████████████████");
		
		System.out.println("WELCOME TO SIMPLE CRUD");
		System.out.println();
		System.out.println("Escolha uma opção:");
		
		String q = "1- list users\n 2- search user\n 3- add user\n 4- update user\n 5- delete user\n 6- sair";
		
		UserDao userDao = DaoFactory.createUserDao();
		
		String resp;
		String name;
		String email;
		String birthDate;
		Integer id;
		
		do {
			System.out.println(q);
			resp = sc.nextLine();
			
			if(resp.equals("1")) {
				
				List<User> listUsers = userDao.findAll();
				System.out.println();
				System.out.println("================= ALL USERS ===============");
				for(User u : listUsers) {
					System.out.println();
					System.out.println("Id: " + u.getId() + "\nName: " + u.getName() + "\nEmail: " + u.getEmail() + "\nBirth date: " + u.getBirthDate());
					System.out.println("***************************************");
				}
				System.out.println();
				
			}else if(resp.equals("2")) {
				
				System.out.println();
				System.out.print("Enter the user id you are looking for: ");
				id = sc.nextInt();
				
				User u = userDao.findById(id);
				System.out.println();
				System.out.println("===================== USER ==================");
				System.out.println();
				System.out.println("Id: " + u.getId() + "\nName: " + u.getName() + "\nEmail: " + u.getEmail() + "\nBirth date: " + u.getBirthDate());
				System.out.println("=============================================");
				System.out.println();
				
				sc.nextLine();
				
				
			}else if(resp.equals("3")) {
				
				System.out.print("Set user name: ");
				name = sc.nextLine();
				System.out.print("Set email: ");
				email = sc.nextLine();
				System.out.print("Set birth Date (YYYY-MM-DD): ");
				birthDate = sc.nextLine();
				
				User newUser = new User(null, name, email, LocalDate.parse(birthDate));
				
				userDao.insert(newUser);
				
				System.out.println();
				System.out.println("Add success!");
				System.out.println();
				
			}else if(resp.equals("4")) {
				
				System.out.println();
				System.out.print("Enter the name to be updated: ");
				name = sc.nextLine();
				System.out.println("Enter the email to be updated: ");
				email = sc.nextLine();
				System.out.println("Enter the birth date to be updated (YYYY-MM-DD): ");
				birthDate = sc.nextLine();
				System.out.print("Enter the id user you want to update: ");
				id = sc.nextInt();
				
				User u = userDao.findById(id);
				u.setName(name);
				u.setEmail(email);
				u.setBirthDate(LocalDate.parse(birthDate));
				
				userDao.update(u);
				
				System.out.println();
				System.out.println("Updated sccess!");
				System.out.println();
				
				sc.nextLine();
				
			}else if(resp.equals("5")) {
				
				System.out.println();
				System.out.println("Enter the user id to be deleted: ");
				id = sc.nextInt();
				sc.nextLine();
				
				userDao.deleteById(id);
				
				System.out.println();
				System.out.println("Delete success!");
				System.out.println();
				
			}else if(resp.equals("6")) {
				System.out.println();
				System.out.println("\n"
						+ "█████████\n"
						+ "█▄█████▄█\n"
						+ "█▼▼▼▼▼\n"
						+ "█\n"
						+ " BYE!\n"
						+ "█▲▲▲▲▲\n"
						+ "█████████\n"
						+ " ██ ██\n"
						+ "");
				break;
			}else {
				System.out.println("Opção inválida! Digite outra opção!");
			}
			
		}while(true);
		
		sc.close();
	}
}
