package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withDrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withDrawLimit);
				
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double withDraw = sc.nextDouble();
		account.whitDraw(withDraw);
		System.out.println(account);
		}
		catch(DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
				
		sc.close();
		
	}

}
