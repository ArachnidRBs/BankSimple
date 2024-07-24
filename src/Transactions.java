/**
* A banking app made for withdrawing, depositing, viewing transactions and setting a budget. This helps users bank with ease while being in their budget. The GUI is easy to navigate and user friendly
* This part is for handling and viewing transaction methods
* 
* @author Noor Syed, Smit Patel, Shaan, Jinay
* @version 1.0
* @since 2024-07-23
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



public class Transactions {

    public static String[][] viewTransactions(String username) {
        String[][] returnResponse = new String[10][4];
        ArrayList<String> allUsers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\Transactions.txt"));//opens reader
            String line;
            boolean foundUser = false;//makes boolean false
            while ((line = reader.readLine()) != null) {//reads each line
                int startIndex = line.indexOf("[[");//gets the text before array starts
                if (startIndex == -1) {//if the array is not ofund
                    System.out.println("No transactions found in line: " + line);//says no transactions found
                    continue;
                }
                String user = line.substring(0, startIndex).trim();//gets username before array starts
                System.out.println("Reading line for user: " + user);  // Debugging statement
                if (user.equals(username)) {//if user is found
                    foundUser = true;
                    String array = line.substring(startIndex + 2, line.length() - 2); // Remove the outer brackets
                    System.out.println("Parsed array string: " + array);  // Debugging statement
                    String[] entries = array.split("\\], \\[");//splits between inner arrays
                    String[][] dataArray = new String[entries.length][4];//creates an array with 4 values
                    for (int i = 0; i < entries.length; i++) {//for loop for each entry (transaction)
                        String entry = entries[i];//gets the entries
                        System.out.println("Parsing entry: " + entry);  // Debugging statement
                        String[] parts = entry.split(", ");//splits
                        if (parts.length != 4) {
                            System.out.println("Invalid entry format: " + Arrays.toString(parts));
                            continue;
                        }
                        for (int j = 0; j < parts.length; j++) {
                            dataArray[i][j] = parts[j].trim();
                            System.out.println("Parsed part [" + i + "][" + j + "]: " + dataArray[i][j]);  // Debugging statement
                        }
                    }
                    returnResponse = dataArray;//returns array
                    break;
                } else {
                    allUsers.add(line);  // only add non-matching lines to allUsers
                }
            }
            reader.close();

            if (!foundUser) {
                for (int i = 0; i < 10; i++) {
                    returnResponse[i][0] = "0";
                    returnResponse[i][1] = "deposit";
                    returnResponse[i][2] = "0.0";
                    returnResponse[i][3] = "0.0";
                }
                allUsers.add(username + Arrays.deepToString(returnResponse));
                BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Transactions.txt"));//opens writer
                for (String user : allUsers) {//for user in all users
                    writer.write(user + "\n");//writes to file with new line each one
                }
                writer.close();//closes writer
            }

            return returnResponse;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());//error reading file
            returnResponse[0][0] = "false";
            return returnResponse;
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String index out of bounds: " + e.getMessage());
            returnResponse[0][0] = "false";//error message
            return returnResponse;
        }
    }

    //method to add transaction
    public static void addTransaction(String username, String type, double amount) {
        String[][] currentTransaction = viewTransactions(username);//makes a array inside of an array and calls viewTransactions
        String allUsers = "";//all users as a string of text

        int highestTransactionNumber = 0;//placeholder
        int lowestNumber = 10000;//placeholder
        
        //gets the highest transaction number
        for (int i = 0; i < 10; i++) {
            if (highestTransactionNumber <= Integer.parseInt(currentTransaction[i][0])) {
                highestTransactionNumber = Integer.parseInt(currentTransaction[i][0]) + 1;
            } else {
                System.out.println("Could not find highest");
            }
        }
        
        //gets the lowest transaction number
        for (int i = 0; i < 10; i++) {
            if (Integer.parseInt(currentTransaction[i][0]) == 0) {
                lowestNumber = 0;
                break;
            } else if (Integer.parseInt(currentTransaction[i][0]) < lowestNumber) {
                lowestNumber = Integer.parseInt(currentTransaction[i][0]);
            } else {
                System.out.println("Could not find lowest1");
            }
        }
        
        //replaces lowest transaction with newer one if no empty spaces available
        for (int i = 0; i < 10; i++) {
            if (Integer.parseInt(currentTransaction[i][0]) == lowestNumber) {
                currentTransaction[i][0] = "" + (highestTransactionNumber);
                currentTransaction[i][1] = type;
                currentTransaction[i][2] = "" + amount;
                String[] balance = Balance.getBalance(username);
                if (balance[0].equals("true")) {
                    currentTransaction[i][3] = balance[4];
                } else {
                    System.out.println("Not true");
                    return;
                }
                System.out.println(Arrays.deepToString(currentTransaction));//gets array as a string
                break;
            } else {
                System.out.println("Could not find lowest");
            }
        }

        //same thing as above but for writing
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\Transactions.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                int startIndex = line.indexOf("[[");
                String user = line.substring(0, startIndex).trim();
                if (user.equals(username)) {
                    allUsers += username + Arrays.deepToString(currentTransaction) + "\n";
                } else {
                    allUsers += line + "\n";
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Transactions.txt"));
            writer.write(allUsers);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error reading or writing file");
        }
    }
}
