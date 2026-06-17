import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static String username = "";
    static String password = "";

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== CYBER SECURITY PASSWORD MANAGER =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Generate Secure Password");
            System.out.println("4. Check Password Strength");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    generatePassword();
                    break;

                case 4:
                    checkStrength();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void register() {

        System.out.print("Enter Username: ");
        username = sc.nextLine();

        System.out.print("Enter Password: ");
        password = sc.nextLine();

        System.out.println("Registration Successful!");
    }

    static void login() {

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Credentials!");
        }
    }

    static void generatePassword() {

        String chars =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz" +
                "0123456789" +
                "!@#$%^&*";

        Random random = new Random();

        StringBuilder pwd = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            pwd.append(chars.charAt(random.nextInt(chars.length())));
        }

        System.out.println("Generated Password: " + pwd);
    }

    static void checkStrength() {

        System.out.print("Enter Password: ");
        String pwd = sc.nextLine();

        int score = 0;

        if (pwd.length() >= 8)
            score++;

        if (pwd.matches(".*[A-Z].*"))
            score++;

        if (pwd.matches(".*[a-z].*"))
            score++;

        if (pwd.matches(".*[0-9].*"))
            score++;

        if (pwd.matches(".*[!@#$%^&*()].*"))
            score++;

        if (score <= 2)
            System.out.println("Weak Password");

        else if (score <= 4)
            System.out.println("Medium Password");

        else
            System.out.println("Strong Password");
    }
}