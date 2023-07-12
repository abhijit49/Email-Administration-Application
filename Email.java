package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String email;
	private String companySuffix = "ab.com";
	
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL CREATED: "+ this.firstName + " "+ this.lastName);
		
		// Call a method asking for the department - return department
		this.department = setDepartment();
		System.out.println("DEPARTMENT: " + this.department);
		if (department == "") {
			System.out.println("No Department Selected!!");
			return ;
		}
		
		// Call a method that returns a random Password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your PASSWORD is: " + this.password);
		
		// Combine elements to generate Email
		email = firstName.toLowerCase()+ "." + lastName.toLowerCase() + "@" + department + "."+ companySuffix;
//		System.out.println("Your Email is: " + email);
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.println("Select from the department codes:\n1 for Sales \n2 for Development \n3 Analytics \n4 Accounting \n0 for none");
		System.out.println("Enter the Department Code: ");
		Scanner in = new Scanner(System.in);
		int depchoice = in.nextInt();
		in.close();	
		if (depchoice == 1) { return "sales";}
		else if (depchoice == 2) { return "dev";}
		else if (depchoice == 3) { return "analytics";}
		else if (depchoice == 4) { return "acct";}
		else {return "";}
		
	
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%*";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int)(Math.random()* passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			
		}
		return new String(password);
	}
	
	// Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set a Alternate Email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change Password
	public void setchangePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return mailboxCapacity; }
	public String getAlternateEmail() {return alternateEmail; }
	public String getPassword() {return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName +" " + lastName+
				"\nCOMPANY EMAIL: " +	email +
				"\nMAILBOX CAPACITY(default): " + mailboxCapacity + "mb";
	}
	
	
}
