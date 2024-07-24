/**
* A banking app made for withdrawing, depositing, viewing transactions and setting a budget. This helps users bank with ease while being in their budget. The GUI is easy to navigate and user friendly
* This part is for signup methods
* 
* @author Noor Syed, Smit Patel, Shaan, Jinay
* @version 1.0
* @since 2024-07-23
*/

import java.io.*;
import java.util.*;

public class Signup {

    public static String[] signupMethod(String username, String password) {
        try {
            ArrayList<String> allUsers = new ArrayList<String>();
            System.out.println("Attempting to read from file...");
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserPass.txt"));//opens reader
            String line;
            String[] returnResponse = new String[2];//return response string
            boolean foundUser = false;//boolean for found user
            while ((line = reader.readLine()) != null) {//read each line
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");//splits commas, puts into array
                
                String user = parts[0];
                String pass = parts[1];
                
                allUsers.add(user.toLowerCase() + "," + pass);//adds user to arrayList
                if (user.toLowerCase().equals(username.toLowerCase())) {//if username is in database
                    returnResponse[0] = "false";
                    foundUser = true;
                    returnResponse[1] = "User Already Exists!";//error message already registered
                }
            }
            reader.close(); // Close the reader after reading all lines

            if (!foundUser) {//if user is not found
                try {
                    System.out.println("Attempting to write to file...");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserPass.txt"));//opens writer
                    for (String userPass : allUsers) {//for loop each arrayList
                        writer.write(userPass);//writes to file
                        writer.newLine();//new line
                    }
                    writer.write(username.toLowerCase() + "," + password);//writes newly made acc
                    writer.close();//closes writer
                    returnResponse[0] = "true";
                } catch (Exception e) {
                    returnResponse[0] = "false";
                    returnResponse[1] = "An error happened while trying to read/write";//error message
                    return returnResponse;
                }
                try {
                    System.out.println("Attempting to authenticate user...");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\AuthenticatedUser.txt"));//opens writer
                    writer.write(username.toLowerCase());//writes to file
                    writer.close();//closes writer
                    returnResponse[0] = "true";
                } catch (Exception e) {
                    returnResponse[0] = "false";
                    returnResponse[1] = "Error Authenticating";
                    return returnResponse;
                }
                try {
                    System.out.println("Attempting to authenticate user...");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserData.txt"));//writes balance, withdraws, deposits, budget to file
                    writer.write(username.toLowerCase() + ",0,0,0,0");//all 0's
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
