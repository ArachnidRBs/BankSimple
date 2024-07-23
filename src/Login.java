
import java.io.*;
import java.util.*;

public class Login {

    public static String[] loginMethod(String username, String password) {
        try {
            ArrayList<String> allUsers = new ArrayList<String>();
            System.out.println("Attempting to read from file...");
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserPass.txt"));
            String line;
            String[] returnResponse = new String[2];
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");
                String user = parts[0].toLowerCase();
                String pass = parts[1];
                allUsers.add(user + "," + pass);
                if (user.equals(username.toLowerCase()) && pass.equals(password)) {
                    System.out.println("Attempting to authenticate user...");
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\AuthenticatedUser.txt"));
                        writer.write(username);
                        writer.close();
                        returnResponse[0] = "true";
                    } catch (Exception e) {
                        returnResponse[0] = "false";
                        returnResponse[1] = "Error authenticating!";
                    }
                    break;
                }
            }
            reader.close(); // Close the reader after reading all lines
            return returnResponse;
        } catch (IOException e) {
            String[] returnResponse = new String[2];
            returnResponse[0] = "false";
            returnResponse[1] = "Unable to locate Database";
            return returnResponse;
        }
    }
}
