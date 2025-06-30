package Customer_Feedback_Management;

import java.util.Scanner;



public class App {
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();
    FeedbackService feedbackService = new FeedbackService();
    AdminService adminService = new AdminService();

    public void start() {
        System.out.println("\n\t\t\tCUSTOMER FEEDBACK MANAGEMENT");
        while (true) {
            System.out.println("\n1. Register\n2. Add Feedback\n3. Admin Panel\n4. Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> userService.registerUser();
                case 2 -> {
                    String[] userData = new String[1];
                    if (userService.loginUser(userData)) {
                        userMenu(userData[0]);
                    }
                }
                case 3 -> {
                    System.out.print("Admin password: ");
                    String adminPass = sc.nextLine();
                    if (adminPass.equals("admin123")) {
                        adminMenu();
                    } else {
                        System.out.println("Wrong admin password.");
                    }
                }
                case 4 -> {
                    System.out.println("Thankyou for your feedback!\n Have a Nice Day!!...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void userMenu(String username) {
        while (true) {
            System.out.println("\n1. Submit Feedback\n2. View My Feedback\n3. Logout");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> feedbackService.submitFeedback(username);
                case 2 -> feedbackService.viewUserFeedback(username);
                case 3 -> {
                    System.out.println("Logged out.");
                    System.out.println("Thanks for your Feedback!!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println("\n1. View All Feedback\n2. Respond to Feedback\n3. Delete Feedback\n4. Top Rated Domain\n5. Logout");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> adminService.viewAllFeedback();
                case 2 -> adminService.respondToFeedback();
                case 3 -> adminService.deleteFeedback();
                case 4 -> adminService.topRatedDomain();
                case 5 -> {
                    System.out.println("Admin logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}