import java.io.*;
import java.sql.*;

public class Example {

    // Security vulnerability - Plaintext password stored in a variable
    private static String password = "password123";

    // Best practices violation - Naming convention for variables
    private static int X = 10;
    private static int Y = 5;

    public static void main(String[] args) throws IOException, SQLException {

        // Security vulnerability - SQL Injection
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name: ");
        String userInput = br.readLine();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM users WHERE name='" + userInput + "'";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getString("email"));
        }

        // Security vulnerability - Cross-Site Scripting (XSS)
        String user_input = "<script>alert('You have been hacked');</script>";
        System.out.println(user_input);

        // Security vulnerability - Path Traversal
        String filename = request.getParameter("filename");
        FileInputStream inputStream = new FileInputStream("uploads/" + filename);

        // Command Injection
        String cmd = request.getParameter("command");
        Process process = Runtime.getRuntime().exec(cmd);

        // Performance issue - Using a loop to concatenate Strings
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            result.append("a");
        }
        System.out.println(result.toString());

        // Syntax error - Missing closing parenthesis
        if (X == 10 {
            System.out.println("X is 10");
        }

        // Best practices violation - Naming convention for variables
        int myVariable = X + Y;
        System.out.println(myVariable);

        // Security vulnerability - Plaintext password stored in a variable
        System.out.println("My password is: " + password);
    }
}