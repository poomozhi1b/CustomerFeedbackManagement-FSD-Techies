package Customer_Feedback_Management;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminService {
    Scanner sc = new Scanner(System.in);

    public void viewAllFeedback() {
        try (Connection con = DBManager.getConnection()) {
            String query = "SELECT * FROM feedback";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " | User: " + rs.getString("username") +
                                   " | Domain: " + rs.getString("domain") +
                                   " | Comment: " + rs.getString("comment") +
                                   " | Rating: " + rs.getInt("rating") +
                                   " | Response: " + rs.getString("response"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void respondToFeedback() {
        System.out.print("Enter feedback ID to respond: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter response: ");
        String response = sc.nextLine();

        try (Connection con = DBManager.getConnection()) {
            String query = "UPDATE feedback SET response = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, response);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Response added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFeedback() {
        System.out.print("Enter feedback ID to delete: ");
        int id = sc.nextInt();

        try (Connection con = DBManager.getConnection()) {
            String query = "DELETE FROM feedback WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Feedback deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void topRatedDomain() {
        try (Connection con = DBManager.getConnection()) {
            String sql = "select domain,avg(rating) as avg_rating from feedback group by domain order by avg_rating desc";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            double maxAvg=0.0;
            Map<String, Double>domainAvgMap = new HashMap<>();
            while(rs.next()) {
            	String domain = rs.getString("domain");
            	double avg=rs.getDouble("avg_rating");
            	domainAvgMap.put(domain, avg);
            	if(avg>maxAvg) {
            		maxAvg=avg;
            	}
            }
            System.out.println("Top Rated Domain(s):");
            for (Map.Entry<String,Double> entry: domainAvgMap.entrySet()) {
				if(entry.getValue()==maxAvg) {
					System.out.println("- "+entry.getKey()+"Average Rating: ("+entry.getValue()+")");
				}
			}
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured while fetching top-rated domains.");
        }
    }
}
