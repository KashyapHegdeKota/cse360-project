package edu.asu.DatabasePart1;
import java.util.*;
import java.sql.Time;
import java.time.*;

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
	
	static void reset(String email) {
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
		if(otp_user.equals(otp_gen)) {
			LocalTime curr_time=LocalTime.now();
			int curr_min=curr_time.getMinute();
			if(curr_min-minutes<=5) {
				System.out.println("Enter the new password: ");
				String new_pass = scan.nextLine();
				
				while(cond == 0) {
					if(PasswordEvaluator.evaluatePassword(new_pass) == "Success") {
						//DatabaseHelper.resetPassword(email, new_pass);
						cond = 1;
					}
					else {
						cond = 0;
					}
				}
			}
			
		
		
		}
	}
	}
		
		
		
	