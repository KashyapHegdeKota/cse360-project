package edu.asu.DatabasePart1;
import java.util.*;


public class Admin{
	private String username;
	static Scanner scan = new Scanner(System.in);
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
	
	static void reset(String username) {
		char[] otp = generateOTP();
		int cond = 0;
		String otp_gen = "";
		for(int i = 0; i < 5; i++) {
			otp_gen = otp_gen + Character.toString(otp[i]);
			}
		System.out.println("Enter OTP: ");
		String otp_user = scan.nextLine();
		
		if(otp_user.equals(otp_gen)) {
			System.out.println("Enter the new password: ");
			String new_pass = scan.nextLine();
		}
		
		}
		
		
		
	}