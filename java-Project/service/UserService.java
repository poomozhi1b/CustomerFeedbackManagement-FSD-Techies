package Customer_Feedback_Management;

import java.sql.*;
import java.util.Scanner;

public class UserService {
    Scanner sc = new Scanner(System.in);

    public void registerUser() {
        try (Connection con = DBManager.getConnection()) {
            System.out.print("Enter username: ");
            String uname = sc.nextLine().trim().toLowerCase();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            
            String checkQuary = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = con.prepareStatement(checkQuary);
            checkStmt.setString(1, checkQuary);
            ResultSet rs= checkStmt.executeQuery();
            
            if(rs.next()) {
            	System.out.println("Username is already Exists!Try a different one!!");
            	return;
            }

            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pass);
            ps.executeUpdate();
            System.out.println("Registration successful!");
        } catch (SQLIntegrityConstraintViolationException e) {
        	System.out.println("Username already Exit.");
        }catch (SQLException e) {
			System.out.println("Database Error:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("Somthing Went Wrong");
		}
    }

    public boolean loginUser(String[] userData) {
        try (Connection con = DBManager.getConnection()) {
            System.out.print("Enter username: ");
            String uname = sc.nextLine();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                userData[0] = uname;
                return true;
            } else {
                System.out.println("Invalid Username Or Password!.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}