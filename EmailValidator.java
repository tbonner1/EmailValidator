package pack;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator 
{
	//The regular expression for a valid email
	public static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$";
	
	public static void main(String[] args) 
	{
		List <String> emailIDs = new ArrayList<String>();

		char userDecision = '-';
		String testEmail = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the email entry and lookup.");
		
		//Loop until user decides to quit
		do 
		{
			System.out.println("\nWhat would you like to do next?");
			System.out.println("Press 'a' for adding a new email.");
			System.out.println("Press 'l' to look up a existing email.");
			System.out.println("Press 'q' to quit.\n");
			
			userDecision = scan.next().charAt(0);
			
			switch(userDecision)
			{
				case('a'):
					System.out.println("ADDING NEW EMAIL.");
					System.out.println("Enter the email you want to add: ");
					scan = new Scanner(System.in);
					testEmail = scan.nextLine();
					
					//If email is valid based on regex
					if (validEmail(testEmail))
					{	
						System.out.println("EMAIL ADDED");
						emailIDs.add(testEmail);
					}
					else
						System.out.println("INVALID EMAIL. TRY AGAIN");
					break;
					
				case('l'):
					System.out.println("LOOKUP EXISTING EMAIL.");
					System.out.println("Enter the email you want to lookup: ");
					scan = new Scanner(System.in);
					testEmail = scan.nextLine();
					
					//Go through arraylist and find email if it's in there
					for(int i = 0; i < emailIDs.size(); i++)
					{
						if(emailIDs.get(i).equals(testEmail))
						{
							System.out.println("That email is in the ArrayList.");
							break;
						}
						
						if(i == emailIDs.size())
						{
							System.out.println("That email is not in the ArrayList.");
						}
					}
					break;
					
				case('q'):
					System.out.println("QUITING.");
					break;
				default:
					System.out.println("INVALID CHOICE. TRY AGAIN.");
					break;
			}
		}
		while (userDecision != 'q');
		
		scan.close();
	}

	
	private static boolean validEmail(String emailTest)
	{
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(emailTest);
		//Checks if emailTest matches regex
		if (matcher.matches())
			return true;
		else
			return false;
		
	}
}
