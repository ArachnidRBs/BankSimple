/**
* A banking app made for withdrawing, depositing, viewing transactions and setting a budget. This helps users bank with ease while being in their budget. The GUI is easy to navigate and user friendly
* This part is the main methods for getting balance, setting budget and updating balance
* 
* @author Noor Syed, Smit Patel, Shaan, Jinay
* @version 1.0
* @since 2024-07-23
*/

import java.io.*;//imports java reader/writer
import java.util.*;//imports all java utils

public class Balance {
    //method for getting balance
    public static String[] getBalance(String username) {
        ArrayList<String> allData = new ArrayList<String>();//makes an ArrayList for storing all the string data
        String[] returnResponse = new String[5];//makes a string to return with an array of 5
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserData.txt"));//opens reader for this page
            String line;//line variable
            boolean foundUser = false;//boolean to check if user was found
            while ((line = reader.readLine()) != null) {//while loop to read every line
                String[] parts = line.split(",");//splits the parts where it has commas. This makes it into an array
                String user = parts[0];//gets content and sets before first comma: username
                String balance = parts[1];//gets content and sets before second comma: balance
                String withdrawn = parts[2];//gets content and sets before third comma: total withdrawn
                String deposited = parts[3];//gets contents and sets before fourth comma: total deposit
                String budget = parts[4];//gets content and sets before end: budget
                allData.add(user + "," + balance + "," + withdrawn + "," + deposited + "," + budget);//adds string to ArrayList
                if (user.equals(username)) {//if the user is equal to username
                    foundUser = true;//makes user found
                    returnResponse[0] = "true";//return response true
                    returnResponse[1] = balance;//balance
                    returnResponse[2] = withdrawn;//withdrawn
                    returnResponse[3] = deposited;//deposited
                    returnResponse[4] = budget;//budget
                    break;//breaks while loop since found
                }
            }
            
            if (foundUser == false) {//if unable to find user in database
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserData.txt"));//opens writer
                    allData.add(username + "0,0,0,0");//adds to array as all 0 and username
                    for (int i = 0; i < allData.size(); i++) {//for loop to loop through arraylist
                        writer.write(allData.get(i));//writes each item in array list
                        writer.newLine();//makes new line
                    }
                    writer.close();//closes writer
                    returnResponse[0] = "true";//return response is true
                    returnResponse[1] = "0";//all below are set to 0
                    returnResponse[2] = "0";
                    returnResponse[3] = "0";
                    returnResponse[4] = "0";
                } catch (Exception e) {
                    returnResponse[0] = "false";//return response is false
                    System.out.println("Error writing UserData.");//logs error
                }
            }
            reader.close();
        } catch (Exception e) {
            returnResponse[0] = "false";//sets returnresponse to false
            System.out.println("Error getting User Data." + e);//logs error
        }
        return returnResponse;//returns returnresponse array
    }
    
    //method for setting a new budget
    public static String[] setNewBudget(String username, double newBudget) {
        ArrayList<String> allData = new ArrayList<String>();//creates an arraylist of all users
        String[] returnResponse = new String[2];//sets array size for return response
        try {//try block
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserData.txt"));//reader
            String line;//string which will change with each line
            boolean foundUser = false;//boolean to see if user was found
            while ((line = reader.readLine()) != null) {//while loop while line is not null
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");//splits and puts into array
                String user = parts[0];
                String balance = parts[1];
                String withdrawn = parts[2];
                String deposited = parts[3];
                String budget = parts[4];
                if (user.equals(username)) {
                    allData.add(user + "," + balance + "," + withdrawn + "," + deposited + "," + newBudget);//adds to ArrayList
                    foundUser = true;//sets foundUser to true
                } else {
                    allData.add(user + "," + balance + "," + withdrawn + "," + deposited + "," + budget);//adds to allData arraylist
                }
            }
            
            //if the user is found
            if (foundUser == true) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserData.txt"));//start a wrier
                    for (int i = 0; i < allData.size(); i++) {//for loop to write each string in arraylist.
                        writer.write(allData.get(i));//writes to file
                        writer.newLine();//new line
                    }
                    returnResponse[0] = "true";
                    writer.close();//closes writer
                } catch (Exception e) {
                    returnResponse[0] = "false";//returnResponse is set to false as it did not complete
                    returnResponse[1] = "Error saving!";//error message
                }
            } else {
                returnResponse[0] = "false";//return response is false as it did not complete
                returnResponse[1] = "Error Finding!";//error message
            }
            reader.close();//closes reader
        } catch (Exception e) {
            returnResponse[0] = "false";//return response is false as it did not complete
            System.out.println("Error getting User Data." + e);//prints error
        }
        return returnResponse;//returns response
    }
    
    //method for updating user balance
    public static String[] updateBalance(String username, double changeInBal) {
        ArrayList<String> allData = new ArrayList<String>();//ArrayList
        String[] returnResponse = new String[2];//return response as an array of 2
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserData.txt"));//opens buffered reader
            String line;
            boolean foundUser = false;//boolean to see if user is found
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");
                String user = parts[0];
                
                //parsing as doubles for numbers
                double balance = Double.parseDouble(parts[1]);
                double withdrawn = Double.parseDouble(parts[2]);
                double deposited = Double.parseDouble(parts[3]);
                double budget = Double.parseDouble(parts[4]);
                
                //if the user was found
                if (user.equals(username)) {
                    if (changeInBal > 0) {//and change in balance is greater than 0
                        allData.add(user + "," + (balance + changeInBal) + "," + withdrawn + "," + (deposited + changeInBal) + "," + (budget + changeInBal));//deposit and budget increase
                        
                    } else if (changeInBal < 0) {
                        allData.add(user + "," + (balance + changeInBal) + "," + (withdrawn + changeInBal) + "," + deposited + "," + (budget + changeInBal));//withdraw increases and budget decrease
                    }
                    foundUser = true;//user was found
                } else {
                    allData.add(user + "," + balance + "," + withdrawn + "," + deposited + "," + budget);//adds to array list
                }
            }
            
            //if user is found
            if (foundUser == true) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserData.txt"));//opens writer
                    for (int i = 0; i < allData.size(); i++) {
                        writer.write(allData.get(i));//writes for each array list string
                        writer.newLine();//new line
                    }
                    returnResponse[0] = "true";//return response
                    writer.close();//closes writer
                } catch (Exception e) {
                    returnResponse[0] = "false";//return response
                    returnResponse[1] = "Error saving!";//error message
                }
            } else {
                returnResponse[0] = "false";//return response
                returnResponse[1] = "Error Finding!";//error message
            }
            reader.close();//closes reader
        } catch (Exception e) {//catches error
            returnResponse[0] = "false";//return response
            System.out.println("Error getting User Data." + e);//logs error
        }
        String type = "";//default string
        
        if (changeInBal <= 0) {//if change is less than 0 it is a withdraw
            type = "withdraw";
        } else {//if change is more than 0 it is a deposit
            type = "deposit";
        }
        Transactions.addTransaction(username, type, (Math.abs(changeInBal)));//calls addTransaction method
        return returnResponse;
    }
}
