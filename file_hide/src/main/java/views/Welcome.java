package views;

import dao.UserDAO;
import model.User;
import service.GenerateOtp;
import service.SendOTPService;
import service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Welcome {
    public void welcomeScreen() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to app");
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to sign up");
        System.out.println("Press 0 to exit");
        int choice = 0;
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        switch (choice) {
            case 1 -> login();
            case 2 -> signUp();
            case 0 -> System.exit(0);
            default -> System.out.println("Invalid option.");
        }
    }

    private void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email:");
        String email = sc.nextLine().trim();

        try {
            if (UserDAO.isExists(email)) {
                String genOtp = GenerateOtp.getOtp().trim();
                SendOTPService.sendOtp(email, genOtp);

                System.out.println("Enter the OTP:");
                String enteredOtp = sc.nextLine().trim();

                System.out.println("DEBUG: Generated OTP = [" + genOtp + "]");
                System.out.println("DEBUG: Entered OTP   = [" + enteredOtp + "]");

                if (enteredOtp.equals(genOtp)) {
                    new UserView(email).home();

                } else {
                    System.out.println("❌ Wrong OTP!!");
                }

            } else {
                System.out.println("⚠️ User not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = sc.nextLine().trim();
        System.out.println("Enter email:");
        String email = sc.nextLine().trim();

        String genOtp = GenerateOtp.getOtp().trim();
        SendOTPService.sendOtp(email, genOtp);

        System.out.println("Enter the OTP sent to your email:");
        String enteredOtp = sc.nextLine().trim();

        System.out.println("DEBUG: Generated OTP = [" + genOtp + "]");
        System.out.println("DEBUG: Entered OTP   = [" + enteredOtp + "]");

        if (enteredOtp.equals(genOtp)) {
            User user = new User(name, email);
            int response = UserService.saveUser(user);
            switch (response) {
                case 0 -> System.out.println("✅ User registered.");
                case 1 -> System.out.println("⚠️ User already exists.");
                default -> System.out.println("⚠️ Unknown error occurred.");
            }
        } else {
            System.out.println("❌ Wrong OTP!!");
        }
    }
}
