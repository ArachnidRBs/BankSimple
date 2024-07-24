
/**
* A banking app made for withdrawing, depositing, viewing transactions and setting a budget. This helps users bank with ease while being in their budget. The GUI is easy to navigate and user friendly
* This part is for login method
* 
* @author Noor Syed, Smit Patel, Shaan, Jinay
* @version 1.0
* @since 2024-07-23
*/

import java.io.*;
import java.util.*;

public class Login {

    public static String[] loginMethod(String username, String password) {
        try {
            ArrayList<String> allUsers = new ArrayList<String>();//makes a new arraylist
            System.out.println("Attempting to read from file...");
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserPass.txt"));//starts reader
            String line;
            String[] returnResponse = new String[2];
            boolean foundUser = false;//found user
            while ((line = reader.readLine()) != null) {//while loop to read each line
                System.out.println("Reading line: " + line);//reads line
                String[] parts = line.split(",");//gets text inbetween comma and makes it an array
                
                String user = parts[0].toLowerCase();
                String pass = parts[1];
                
                allUsers.add(user + "," + pass);//allUsers array
                if (user.equals(username.toLowerCase())) {//if user is found
                    foundUser = true;//found user true
                    if (pass.equals(password)) {//if password is equal to the actual password
                        System.out.println("Attempting to authenticate user...");
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\AuthenticatedUser.txt"));//opens writer
                            writer.write(username.toLowerCase());//writes user to authenticate in txt file
                            writer.close();//closes writer
                            returnResponse[0] = "true";//returns true
                        } catch (Exception e) {
                            returnResponse[0] = "false";//returns false
                            returnResponse[1] = "Error authenticating!";//error message
                        }
                        break;//stops loop
                    } else {
                        returnResponse[0] = "false";//if password does not match
                        returnResponse[1] = "Incorrect Password";//error message
                    }
                }
            }
            if (foundUser == false) {//if user is not found
                returnResponse[0] = "false";
                returnResponse[1] = "User not Found!";//error message
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
