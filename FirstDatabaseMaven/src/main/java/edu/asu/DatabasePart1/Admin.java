package edu.asu.DatabasePart1;
import java.sql.SQLException;
import java.util.*;
import java.sql.SQLException;
import java.time.*;

public class Admin{
	private static String username; 
	static Scanner scan = new Scanner(System.in);
	
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> Kashyap
	public static void main(String[] args) {
		System.out.println("Enter username: ");
		username = scan.nextLine();
		System.out.println("-----------------------------------------");
		System.out.printf("Welcome %s to the Admin Page\n", username);
		System.out.println("-----------------------------------------");
		
		String cont="y";
		while (cont.toLowerCase()=="y"){
			int choice;
			System.out.println("What action would you like to perform?\n"+
								"1. Invite an individual to join the application.\n"+
								"2. Reset a user account.\n"+
								"3. Delete a user account.\n"+
								"4. List the user accounts.\n"+
								"5. Add or remove a role from a user.\n"+
								"6. Log out.\n");
			System.out.print("Enter your choice (1-6): ");
			choice = scan.nextInt();
			if (choice==1){
				//invite();
			}
			else if (choice==2){
				reset(username);
			}
			else if (choice==3){
				String username_del;
				System.out.println("Enter the username you want to delete: ");
				username_del = scan.nextLine();
				System.out.println("Are you sure?(yes if you want to continue): ");
				String ans= scan.nextLine();
				try {
					if (ans.toLowerCase()=="yes") {
						DatabaseHelper.deleteUserByEmail(username_del);
						System.out.println("Successfully deleted the user.");
					}
					else {
						System.out.println("Admin changed their mind.");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (choice==4){
				try {
					DatabaseHelper.displayUsersByAdmin();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (choice==5){
				
			}
			else if (choice==6){
				System.out.println("Logging Out");
				break;
			}
			else {
				System.out.println("Invalid Choice.");
			}
	
			System.out.println("Do you want to continue?(y/Y for yes): ");
			cont = scan.nextLine();
		}
				
	}
	
<<<<<<< HEAD
>>>>>>> Kashyap
=======
>>>>>>> Kashyap
	static char[] generateOTP() {
		char[] otp = new char[5]; // Array to hold the characters
        int index = 0;
        
       for(int i=0;i<5;i++) {
    	   Random r = new Random();
    	   char c = (char)(r.nextInt(100)+'0');
    	   otp[i] = c;
       }
       
        return otp;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	static String charToStringOTP(char[] otp) {
=======
	static void reset(String email) {
		char[] otp = generateOTP();
		int cond = 0;
		
>>>>>>> Kashyap
		String otp_gen = "";
		LocalTime otp_time =LocalTime.now();
		int minutes = otp_time.getMinute();
		
		for(int i = 0; i < 5; i++) {
			otp_gen = otp_gen + Character.toString(otp[i]);
		}
		return otp_gen;
	}
	
	static void addOTPToDB(String otp) throws SQLException {
		DatabaseHelper.addOTP(otp);
	}
	
	static void reset(String username) {
=======
	static void reset(String email) {
>>>>>>> Kashyap
		char[] otp = generateOTP();
		int cond = 0;
		
		String otp_gen = "";
		LocalTime otp_time =LocalTime.now();
		int minutes = otp_time.getMinute();
		
		for(int i = 0; i < 5; i++) {
			otp_gen = otp_gen + Character.toString(otp[i]);
			}
		
		System.out.println("Enter OTP: ");
		String otp_user = scan.nextLine();
//		String str_otp_time= otp_time.toString();
//		String str_otp_exp= otp_expiration.toString();
//		
		if(otp_user.equals(otp_gen)){
			LocalTime curr_time=LocalTime.now();
			int curr_min=curr_time.getMinute();
			if(curr_min-minutes<=5) {
				System.out.println("Enter the new password: ");
				String new_pass = scan.nextLine();
				
				while(cond == 0) {
					if(PasswordEvaluator.evaluatePassword(new_pass) == "Success") {
						try {
							DatabaseHelper.resetPassword(email, new_pass);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println("Error in Reset password: "+ e);
						}
						cond = 1;
					}
					else {
						cond = 0;
					}
				}
			}
			
<<<<<<< HEAD
<<<<<<< HEAD
			while(cond == 0) {
				if(PasswordEvaluator.evaluatePassword(new_pass) == "Success") {
					cond = 1;
				}
				else {
					cond = 0;
				}
			}
		}
=======
		
>>>>>>> Kashyap
=======
		
>>>>>>> Kashyap
		
		}
	}
}
		
		
		
	