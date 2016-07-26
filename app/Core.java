package app;

import java.util.Iterator;
import java.util.Scanner;

import entity.User;
import util.HibernateUtil;


public class Core {

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		CRUDMethod crud = new CRUDMethod();
		Scanner sc = new Scanner(System.in);
		String choice = "";
		try {
			while (!choice.equalsIgnoreCase("exit")) {
				System.out.println(
						  "1 - Add \n" 
						+ "2 - Remove\n" 
						+ "3 - Update\n"
						+ "4 - See all users\n"
						+ "exit - for exit");
				
				choice = sc.nextLine().trim();
				if (choice.equals("1")) {
					
					User user = new User();
					String tmp;
					System.out.println("Enter first name: ");
					if(!(tmp = sc.nextLine().trim()).equals("")){
					user.setFirstName(tmp);
					}
					
					System.out.println("Entre last name: ");
					if(!(tmp = sc.nextLine().trim()).equals("")){
					user.setLastName(tmp);
					}
					
					System.out.println("Enter EMail: ");
					if(!(tmp = sc.nextLine().trim()).equals("")){
					user.setEmail(tmp);
					}
					
					System.out.println("Enter phone number" );
					if(!(tmp = sc.nextLine().trim()).equals("")){
					user.setPhone(tmp);
					}
					
					crud.addUser(user);

				} else if (choice.equals("2")) {

					User user = new User();
					System.out.println("Enter id user for delete: ");
					user.setId(Integer.valueOf(sc.nextLine()));
					crud.deleteUser(user);
					
				} else if (choice.equals("3")) {

					User user = new User();
					String tmp;
					
					System.out.println("Entre id for change: ");
					user.setId(Integer.valueOf(sc.nextLine().trim()));
					
					System.out.println("Enter first name: ");
					if(!(tmp = sc.nextLine().trim()).equals("")){
					user.setFirstName(tmp);
					}
					
					
					System.out.println("Entre last name: ");
					if(!(tmp = sc.nextLine().trim()).equals("")){
					user.setLastName(tmp);
					}
					
					System.out.println("Enter EMail: ");
					if(!(tmp = sc.nextLine().trim()).equals("")){
					user.setEmail(tmp);
					}
					
					System.out.println("Enter phone number: " );
					if(!(tmp = sc.nextLine().trim()).equals("")){
					user.setPhone(tmp);
					}
					
					crud.updateUser(user);
				} else if (choice.equals("4")) {
					
					for(Iterator<User> i = crud.readAllUsers().iterator(); i.hasNext();){
						User user = (User) i.next();
						System.out.println(user.toString());
					}
					System.out.println();
					
				}
			}
		} finally {
			HibernateUtil.close();
		}
	}
}

