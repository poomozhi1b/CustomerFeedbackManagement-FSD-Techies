package Customer_Feedback_Management;

import java.sql.*;
import java.util.Scanner;

public class FeedbackService {
    Scanner sc = new Scanner(System.in);

    public void submitFeedback(String username) {
        System.out.println("Enter feedback domain (SD, FSD, WD, IMS, MAYA): ");
        String domain = sc.nextLine().toUpperCase();
        System.out.println("Enter your feedback: ");
        String feedback = sc.nextLine();
        System.out.print("Give rating (1 to 5): ");
        int rating = sc.nextInt();
        sc.nextLine();

        try (Connection con = DBManager.getConnection()) {
            String query = "INSERT INTO feedback (username, domain, comment, rating) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, domain);
            ps.setString(3, feedback);
            ps.setInt(4, rating);
            ps.executeUpdate();
            System.out.println("Feedback submitted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewUserFeedback(String username) {
        try (Connection con = DBManager.getConnection()) {
            String query = "SELECT * FROM feedback WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " | Domain: " + rs.getString("domain") +
                                   " | Comment: " + rs.getString("comment") +
                                   " | Rating: " + rs.getInt("rating") +
                                   " | Response: " + rs.getString("response"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}