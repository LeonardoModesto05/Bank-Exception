package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.SysBank;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		try
		{
			System.out.println("Enter account data: ");
			
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double iBalance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			double withDrawLimit = sc.nextDouble();
			SysBank bank = new SysBank(number, holder, iBalance, withDrawLimit);
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double withDraw = sc.nextDouble();
			bank.withDraw(withDraw);
			
			System.out.println("New Balance: " + bank.getBalance());
		}
		catch(DomainException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		catch (RuntimeException e)
		{
			System.out.println("Unexpected error");
		}	
		sc.close();

	}

}
