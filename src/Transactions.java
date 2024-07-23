
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Transactions {

    public static String[][] viewTransactions(String username) {
        String[][] returnResponse = new String[10][4];
        try {
            System.out.println("Attempting to read from file...");
            BufferedReader reader = new BufferedReader(new FileReader("src\\Transactions.txt"));
            String allUsers = "";
            String line;
            boolean foundUser = false;
            while ((line = reader.readLine()) != null) {
                int startIndex = line.indexOf("[[");
                String user = line.substring(0, startIndex).trim();
                allUsers += line + "\n";
                if (user.equals(username.toLowerCase())) {
                    foundUser = true;
                    String array = line.substring(startIndex);
                    array = array.substring(1, array.length() - 1);
                    String[] entries = array.split("\\],\\[");
                    String[][] dataArray = new String[entries.length][2];
                    for (int i = 0; i < entries.length; i++) {
                        // Remove any extra brackets from the entry
                        String entry = entries[i].replace("[", "").replace("]", "");

                        // Split by comma to separate the timestamp and value
                        String[] parts = entry.split(",");

                        // Store in the 2D array
                        dataArray[i] = parts;
                    }
                    returnResponse = dataArray;
                }
            }
            if (foundUser == false) {
                for (int i = 0; i < 10; i++) {
                    returnResponse[i][0] = "0";
                    returnResponse[i][1] = "deposit";
                    returnResponse[i][2] = "0.0";
                    returnResponse[i][3] = "0.0";
                }
                allUsers += username + returnResponse;
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Transactions.txt"));
                    writer.write(allUsers);
                    writer.close();
                } catch (Exception e) {
                    System.out.println("Error writing to file!");
                    returnResponse[0][0] = "false";
                }
            }

            return returnResponse;
        } catch (Exception e) {
            System.out.println("Error reading file");
            returnResponse[0][0] = "false";
            return returnResponse;
        }
    }

    public static void addTransaction(String username, String type, double amount) {
        String[][] currentTransaction = viewTransactions(username);
        String[][] returnResponse = new String[10][4];
        if (!currentTransaction[0][0].equals("false")) {
            int highestTransaction = 0;
            int lowestTransaction = 0;
            for (int i = 0; i < 10; i++) {
                if (Integer.parseInt(currentTransaction[i][0]) > highestTransaction) {
                    highestTransaction = Integer.parseInt(currentTransaction[i][0]);
                } else if (Integer.parseInt(currentTransaction[i][0]) < lowestTransaction) {
                    lowestTransaction = Integer.parseInt(currentTransaction[i][0]);
                }
            }

            for (int i = 0; i < 10; i++) {
                if (Integer.parseInt(currentTransaction[i][0]) == 0) {
                    currentTransaction[i][0] = "" + highestTransaction + 1;
                    currentTransaction[i][1] = type;
                    currentTransaction[i][2] = "" + amount;
                    String[] response = Balance.getBalance(username);
                    currentTransaction[i][3] = response[1];
                } else if (Integer.parseInt(currentTransaction[i][0]) == lowestTransaction) {
                    currentTransaction[i][0] = "" + highestTransaction + 1;
                    currentTransaction[i][1] = type;
                    currentTransaction[i][2] = "" + amount;
                    String[] response = Balance.getBalance(username);
                    currentTransaction[i][3] = response[1];
                }
            }

            String writeBack = username + currentTransaction;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src\\Transactions.txt"));
                String allUsers = "";
                String line;
                boolean foundUser = false;
                while ((line = reader.readLine()) != null) {
                    int startIndex = line.indexOf("[[");
                    String user = line.substring(0, startIndex).trim();
                    if (user.equals(username.toLowerCase())) {
                        foundUser = true;
                        String array = line.substring(startIndex);
                        array = array.substring(1, array.length() - 1);
                        String[] entries = array.split("\\],\\[");
                        String[][] dataArray = new String[entries.length][2];
                        for (int i = 0; i < entries.length; i++) {
                            // Remove any extra brackets from the entry
                            String entry = entries[i].replace("[", "").replace("]", "");

                            // Split by comma to separate the timestamp and value
                            String[] parts = entry.split(",");

                            // Store in the 2D array
                            dataArray[i] = parts;
                        }
                    } else {
                        allUsers += line + "\n";
                        System.out.println(allUsers);
                    }
                }
                if (foundUser == false) {
                    returnResponse = currentTransaction;
                    allUsers += username + Arrays.toString(returnResponse);
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Transactions.txt"));
                        writer.write(allUsers);
                        writer.close();
                    } catch (Exception e) {
                        System.out.println("Error writing to file!");
                        returnResponse[0][0] = "false";
                    }
                }
                System.out.println("Updated Transactions!");
            } catch (IOException e) {
                System.out.println("error reading file");
            }
        }
    }
}
