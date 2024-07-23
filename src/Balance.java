
import java.io.*;
import java.util.*;

public class Balance {
    public static String[] getBalance(String username) {
        ArrayList<String> allData = new ArrayList<String>();
        String[] returnResponse = new String[5];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserData.txt"));
            String line;
            boolean foundUser = false;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");
                String user = parts[0].toLowerCase();
                String balance = parts[1];
                String withdrawn = parts[2];
                String deposited = parts[3];
                String budget = parts[4];
                allData.add(user + "," + balance + "," + withdrawn + "," + deposited + "," + budget);
                if (user.equals(username.toLowerCase())) {
                    foundUser = true;
                    returnResponse[0] = "true";
                    returnResponse[1] = balance;
                    returnResponse[2] = withdrawn;
                    returnResponse[3] = deposited;
                    returnResponse[4] = budget;
                    break;
                }
            }
            
            if (foundUser == false) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserData.txt"));
                    for (int i = 0; i < allData.size(); i++) {
                        writer.write(allData.get(i));
                        writer.newLine();
                    }
                    writer.write(username + ",0,0,0,0");
                    returnResponse[0] = "true";
                    returnResponse[1] = "0";
                    returnResponse[2] = "0";
                    returnResponse[3] = "0";
                    returnResponse[4] = "0";
                    writer.close();
                } catch (Exception e) {
                    returnResponse[0] = "false";
                    System.out.println("Error writing UserData.");
                }
            }
            reader.close();
        } catch (Exception e) {
            returnResponse[0] = "false";
            System.out.println("Error getting User Data." + e);
        }
        return returnResponse;
    }
    
    public static String[] setNewBudget(String username, double newBudget) {
        ArrayList<String> allData = new ArrayList<String>();
        String[] returnResponse = new String[2];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserData.txt"));
            String line;
            boolean foundUser = false;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");
                String user = parts[0].toLowerCase();
                String balance = parts[1];
                String withdrawn = parts[2];
                String deposited = parts[3];
                String budget = parts[4];
                if (user.equals(username.toLowerCase())) {
                    allData.add(user + "," + balance + "," + withdrawn + "," + deposited + "," + newBudget);
                    foundUser = true;
                } else {
                    allData.add(user + "," + balance + "," + withdrawn + "," + deposited + "," + budget);
                }
            }
            
            if (foundUser == true) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserData.txt"));
                    for (int i = 0; i < allData.size(); i++) {
                        writer.write(allData.get(i));
                        writer.newLine();
                    }
                    returnResponse[0] = "true";
                    writer.close();
                } catch (Exception e) {
                    returnResponse[0] = "false";
                    returnResponse[1] = "Error saving!";
                }
            } else {
                returnResponse[0] = "false";
                returnResponse[1] = "Error Finding!";
            }
            reader.close();
        } catch (Exception e) {
            returnResponse[0] = "false";
            System.out.println("Error getting User Data." + e);
        }
        return returnResponse;
    }
    
    public static String[] updateBalance(String username, double changeInBal) {
        ArrayList<String> allData = new ArrayList<String>();
        String[] returnResponse = new String[2];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\UserData.txt"));
            String line;
            boolean foundUser = false;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");
                String user = parts[0].toLowerCase();
                double balance = Double.parseDouble(parts[1]);
                double withdrawn = Double.parseDouble(parts[2]);
                double deposited = Double.parseDouble(parts[3]);
                double budget = Double.parseDouble(parts[4]);
                if (user.equals(username.toLowerCase())) {
                    if (changeInBal > 0) {
                        allData.add(user + "," + (balance + changeInBal) + "," + withdrawn + "," + (deposited + changeInBal) + "," + budget);
                        
                    } else if (changeInBal < 0) {
                        allData.add(user + "," + (balance + changeInBal) + "," + (-changeInBal) + "," + deposited + "," + (budget + changeInBal));
                    }
                    foundUser = true;
                } else {
                    allData.add(user + "," + balance + "," + withdrawn + "," + deposited + "," + budget);
                }
            }
            
            if (foundUser == true) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\UserData.txt"));
                    for (int i = 0; i < allData.size(); i++) {
                        writer.write(allData.get(i));
                        writer.newLine();
                    }
                    returnResponse[0] = "true";
                    writer.close();
                } catch (Exception e) {
                    returnResponse[0] = "false";
                    returnResponse[1] = "Error saving!";
                }
            } else {
                returnResponse[0] = "false";
                returnResponse[1] = "Error Finding!";
            }
            reader.close();
        } catch (Exception e) {
            returnResponse[0] = "false";
            System.out.println("Error getting User Data." + e);
        }
        String type = "";
        if (changeInBal <= 0) {
            type = "withdraw";
        } else {
            type = "withdraw";
        }
        Transactions.addTransaction(username, type, Math.abs(changeInBal));
        return returnResponse;
    }
}
