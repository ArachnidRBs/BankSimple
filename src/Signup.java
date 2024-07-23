
import java.io.*;
import java.util.*;

public class Signup {

    public static String[] signupMethod(String username, String password) {
        try {
            ArrayList<String> allUsers = new ArrayList<String>();
            System.out.println("Attempting to read from file...");
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserPass.txt"));
            String line;
            String[] returnResponse = new String[2];
            boolean foundUser = false;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");
                String user = parts[0];
                String pass = parts[1];
                allUsers.add(user + "," + pass);
                if (user.toLowerCase().equals(username.toLowerCase())) {
                    returnResponse[0] = "false";
                    foundUser = true;
                    returnResponse[1] = "User Already Exists!";
                }
            }
            reader.close(); // Close the reader after reading all lines

            if (!foundUser) {
                try {
                    System.out.println("Attempting to write to file...");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserPass.txt"));
                    for (String userPass : allUsers) {
                        writer.write(userPass);
                        writer.newLine();
                    }
                    writer.write(username + "," + password);
                    writer.close();
                    returnResponse[0] = "true";
                } catch (Exception e) {
                    returnResponse[0] = "false";
                    returnResponse[1] = "An error happened while trying to read/write";
                    return returnResponse;
                }
                try {
                    System.out.println("Attempting to authenticate user...");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\AuthenticatedUser.txt"));
                    writer.write(username);
                    writer.close();
                    returnResponse[0] = "true";
                } catch (Exception e) {
                    returnResponse[0] = "false";
                    returnResponse[1] = "Error Authenticating";
                    return returnResponse;
                }
                try {
                    System.out.println("Attempting to authenticate user...");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserData.txt"));
                    writer.write(username);
                    writer.close();
                    returnResponse[0] = "true";
                } catch (Exception e) {
                    returnResponse[0] = "false";
                    returnResponse[1] = "Error Authenticating";
                    return returnResponse;
                }
                return returnResponse;
            } else {
                return returnResponse;
            }
        } catch (IOException e) {
            String[] returnResponse = new String[2];
            returnResponse[0] = "false";
            returnResponse[1] = "Unable to locate Database";
            return returnResponse;
        }
    }
}
