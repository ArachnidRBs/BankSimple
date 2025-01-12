/**
* A banking app made for withdrawing, depositing, viewing transactions and setting a budget. This helps users bank with ease while being in their budget. The GUI is easy to navigate and user friendly
* This part is GUI
* 
* @author Noor Syed, Smit Patel, Shaan Mehta, Jinay Desai
* @version 1.0
* @since 2024-07-23
*/

import java.io.BufferedReader;//imports buffer reader
import java.io.FileReader;//imports file reader
import java.util.*;//imports utils
import javax.swing.*;//this is for the GUI



public class TransactionsPage extends javax.swing.JFrame {

    public static String username;

    public TransactionsPage() {
    initComponents();
    try {
        BufferedReader reader = new BufferedReader(new FileReader("src\\AuthenticatedUser.txt"));
        String username = reader.readLine();
        reader.close();

        String[] balanceResponse = Balance.getBalance(username);
        welcomeText.setText("Welcome " + username);

        // Fetch the transactions for the user
        String[][] responseText = Transactions.viewTransactions(username);
        String[][] hieghestTransaction = new String[10][4];

        // Initialize hieghestTransaction with default values
        for (int i = 0; i < 10; i++) {
            hieghestTransaction[i][0] = "0";
            hieghestTransaction[i][1] = "Deposit";
            hieghestTransaction[i][2] = "0";
            hieghestTransaction[i][3] = "0";
        }

        // Sort the transactions by transaction number in descending order
        for (int i = 0; i < responseText.length; i++) {
            for (int k = i + 1; k < responseText.length; k++) {
                if (Integer.parseInt(responseText[k][0]) > Integer.parseInt(responseText[i][0])) {
                    String[] temp = responseText[i];
                    responseText[i] = responseText[k];
                    responseText[k] = temp;
                }
            }
        }

        // Copy sorted transactions to hieghestTransaction
        for (int i = 0; i < responseText.length && i < hieghestTransaction.length; i++) {
            hieghestTransaction[i] = responseText[i];
        }

        // Update the JLabel components with the transactions
        for (int i = 0; i < 10; i++) {
            JLabel[] allIndexes = getTransactionIndex(i);
            allIndexes[0].setText(hieghestTransaction[i][0]);
            allIndexes[1].setText(hieghestTransaction[i][1]);
            allIndexes[2].setText(hieghestTransaction[i][2]);
            allIndexes[3].setText(hieghestTransaction[i][3]);
        }
    } catch (Exception e) {
        System.out.println("Error getting name or reading file: " + e);
    }
}

private JLabel[] getTransactionIndex(int index) {
    JLabel[] allIndexes = new JLabel[4];
    switch (index) {
        case 0: 
            allIndexes[0] = transactionNumber1;
            allIndexes[1] = type1;
            allIndexes[2] = price1;
            allIndexes[3] = budgetAdjustment1;
            return allIndexes;
        case 1: 
            allIndexes[0] = transactionNumber2;
            allIndexes[1] = type2;
            allIndexes[2] = price2;
            allIndexes[3] = budgetAdjustment2;
            return allIndexes;
        case 2: 
            allIndexes[0] = transactionNumber3;
            allIndexes[1] = type3;
            allIndexes[2] = price3;
            allIndexes[3] = budgetAdjustment3;
            return allIndexes;
        case 3: 
            allIndexes[0] = transactionNumber4;
            allIndexes[1] = type4;
            allIndexes[2] = price4;
            allIndexes[3] = budgetAdjustment4;
            return allIndexes;
        case 4: 
            allIndexes[0] = transactionNumber5;
            allIndexes[1] = type5;
            allIndexes[2] = price5;
            allIndexes[3] = budgetAdjustment5;
            return allIndexes;
        case 5: 
            allIndexes[0] = transactionNumber6;
            allIndexes[1] = type6;
            allIndexes[2] = price6;
            allIndexes[3] = budgetAdjustment6;
            return allIndexes;
        case 6: 
            allIndexes[0] = transactionNumber7;
            allIndexes[1] = type7;
            allIndexes[2] = price7;
            allIndexes[3] = budgetAdjustment7;
            return allIndexes;
        case 7: 
            allIndexes[0] = transactionNumber8;
            allIndexes[1] = type8;
            allIndexes[2] = price8;
            allIndexes[3] = budgetAdjustment8;
            return allIndexes;
        case 8: 
            allIndexes[0] = transactionNumber9;
            allIndexes[1] = type9;
            allIndexes[2] = price9;
            allIndexes[3] = budgetAdjustment9;
            return allIndexes;
        case 9: 
            allIndexes[0] = transactionNumber10;
            allIndexes[1] = type10;
            allIndexes[2] = price10;
            allIndexes[3] = budgetAdjustment10;
            return allIndexes;
        default: 
            throw new IllegalArgumentException("Invalid index");
    }
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        balanceButton = new javax.swing.JLabel();
        welcomeText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        transactionNumber1 = new javax.swing.JLabel();
        price1 = new javax.swing.JLabel();
        type1 = new javax.swing.JLabel();
        budgetAdjustment1 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        transactionNumber2 = new javax.swing.JLabel();
        price2 = new javax.swing.JLabel();
        type2 = new javax.swing.JLabel();
        budgetAdjustment2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        transactionNumber3 = new javax.swing.JLabel();
        price3 = new javax.swing.JLabel();
        type3 = new javax.swing.JLabel();
        budgetAdjustment3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        transactionNumber4 = new javax.swing.JLabel();
        price4 = new javax.swing.JLabel();
        type4 = new javax.swing.JLabel();
        budgetAdjustment4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        transactionNumber5 = new javax.swing.JLabel();
        price5 = new javax.swing.JLabel();
        type5 = new javax.swing.JLabel();
        budgetAdjustment5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        transactionNumber6 = new javax.swing.JLabel();
        price6 = new javax.swing.JLabel();
        type6 = new javax.swing.JLabel();
        budgetAdjustment6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        transactionNumber7 = new javax.swing.JLabel();
        price7 = new javax.swing.JLabel();
        type7 = new javax.swing.JLabel();
        budgetAdjustment7 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        transactionNumber8 = new javax.swing.JLabel();
        price8 = new javax.swing.JLabel();
        type8 = new javax.swing.JLabel();
        budgetAdjustment8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        transactionNumber9 = new javax.swing.JLabel();
        price9 = new javax.swing.JLabel();
        type9 = new javax.swing.JLabel();
        budgetAdjustment9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        transactionNumber10 = new javax.swing.JLabel();
        price10 = new javax.swing.JLabel();
        type10 = new javax.swing.JLabel();
        budgetAdjustment10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(815, 597));
        jPanel1.setMinimumSize(new java.awt.Dimension(815, 597));
        jPanel1.setPreferredSize(new java.awt.Dimension(815, 597));

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));

        balanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/walletIcon.png"))); // NOI18N

        welcomeText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        welcomeText.setText("Welcome ......................");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoSmall.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(welcomeText)
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(balanceButton)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(welcomeText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balanceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));
        jPanel3.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel3.setMinimumSize(new java.awt.Dimension(815, 46));
        jPanel3.setPreferredSize(new java.awt.Dimension(815, 46));

        jLabel4.setText("Transaction #");

        jLabel5.setText("Price");

        jLabel6.setText("Type");

        jLabel7.setText("New Budget");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel4)
                .addGap(135, 135, 135)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(165, 165, 165)
                .addComponent(jLabel7)
                .addGap(85, 85, 85))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14))
        );

        jPanel6.setBackground(new java.awt.Color(102, 255, 102));
        jPanel6.setAlignmentX(0.0F);
        jPanel6.setAlignmentY(0.0F);
        jPanel6.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel6.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber1.setText("0");
        transactionNumber1.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber1.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber1.setPreferredSize(new java.awt.Dimension(71, 16));

        price1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price1.setText("$0");
        price1.setMaximumSize(new java.awt.Dimension(26, 16));
        price1.setMinimumSize(new java.awt.Dimension(26, 16));
        price1.setPreferredSize(new java.awt.Dimension(26, 16));

        type1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type1.setText("Deposit");

        budgetAdjustment1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment1.setText("$0");
        budgetAdjustment1.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment1.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type1)
                    .addComponent(budgetAdjustment1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        homeButton.setBackground(new java.awt.Color(102, 255, 102));
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homeIcon.png"))); // NOI18N
        homeButton.setBorder(null);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 204, 51));
        jPanel7.setAlignmentX(0.0F);
        jPanel7.setAlignmentY(0.0F);
        jPanel7.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel7.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber2.setText("0");
        transactionNumber2.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber2.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber2.setPreferredSize(new java.awt.Dimension(71, 16));

        price2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price2.setText("$0");
        price2.setMaximumSize(new java.awt.Dimension(26, 16));
        price2.setMinimumSize(new java.awt.Dimension(26, 16));
        price2.setPreferredSize(new java.awt.Dimension(26, 16));

        type2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type2.setText("Deposit");

        budgetAdjustment2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment2.setText("$0");
        budgetAdjustment2.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment2.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type2)
                    .addComponent(budgetAdjustment2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel8.setBackground(new java.awt.Color(102, 255, 102));
        jPanel8.setAlignmentX(0.0F);
        jPanel8.setAlignmentY(0.0F);
        jPanel8.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel8.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber3.setText("0");
        transactionNumber3.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber3.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber3.setPreferredSize(new java.awt.Dimension(71, 16));

        price3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price3.setText("$0");
        price3.setMaximumSize(new java.awt.Dimension(26, 16));
        price3.setMinimumSize(new java.awt.Dimension(26, 16));
        price3.setPreferredSize(new java.awt.Dimension(26, 16));

        type3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type3.setText("Deposit");

        budgetAdjustment3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment3.setText("$0");
        budgetAdjustment3.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment3.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type3)
                    .addComponent(budgetAdjustment3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel9.setBackground(new java.awt.Color(0, 204, 51));
        jPanel9.setAlignmentX(0.0F);
        jPanel9.setAlignmentY(0.0F);
        jPanel9.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel9.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber4.setText("0");
        transactionNumber4.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber4.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber4.setPreferredSize(new java.awt.Dimension(71, 16));

        price4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price4.setText("$0");
        price4.setMaximumSize(new java.awt.Dimension(26, 16));
        price4.setMinimumSize(new java.awt.Dimension(26, 16));
        price4.setPreferredSize(new java.awt.Dimension(26, 16));

        type4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type4.setText("Deposit");

        budgetAdjustment4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment4.setText("$0");
        budgetAdjustment4.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment4.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type4)
                    .addComponent(budgetAdjustment4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel10.setBackground(new java.awt.Color(102, 255, 102));
        jPanel10.setAlignmentX(0.0F);
        jPanel10.setAlignmentY(0.0F);
        jPanel10.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel10.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber5.setText("0");
        transactionNumber5.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber5.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber5.setPreferredSize(new java.awt.Dimension(71, 16));

        price5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price5.setText("$0");
        price5.setMaximumSize(new java.awt.Dimension(26, 16));
        price5.setMinimumSize(new java.awt.Dimension(26, 16));
        price5.setPreferredSize(new java.awt.Dimension(26, 16));

        type5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type5.setText("Deposit");

        budgetAdjustment5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment5.setText("$0");
        budgetAdjustment5.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment5.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type5)
                    .addComponent(budgetAdjustment5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel11.setBackground(new java.awt.Color(0, 204, 51));
        jPanel11.setAlignmentX(0.0F);
        jPanel11.setAlignmentY(0.0F);
        jPanel11.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel11.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber6.setText("0");
        transactionNumber6.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber6.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber6.setPreferredSize(new java.awt.Dimension(71, 16));

        price6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price6.setText("$0");
        price6.setMaximumSize(new java.awt.Dimension(26, 16));
        price6.setMinimumSize(new java.awt.Dimension(26, 16));
        price6.setPreferredSize(new java.awt.Dimension(26, 16));

        type6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type6.setText("Deposit");

        budgetAdjustment6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment6.setText("$0");
        budgetAdjustment6.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment6.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type6)
                    .addComponent(budgetAdjustment6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel12.setBackground(new java.awt.Color(102, 255, 102));
        jPanel12.setAlignmentX(0.0F);
        jPanel12.setAlignmentY(0.0F);
        jPanel12.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel12.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber7.setText("0");
        transactionNumber7.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber7.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber7.setPreferredSize(new java.awt.Dimension(71, 16));

        price7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price7.setText("$0");
        price7.setMaximumSize(new java.awt.Dimension(26, 16));
        price7.setMinimumSize(new java.awt.Dimension(26, 16));
        price7.setPreferredSize(new java.awt.Dimension(26, 16));

        type7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type7.setText("Deposit");

        budgetAdjustment7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment7.setText("$0");
        budgetAdjustment7.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment7.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type7)
                    .addComponent(budgetAdjustment7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel13.setBackground(new java.awt.Color(0, 204, 51));
        jPanel13.setAlignmentX(0.0F);
        jPanel13.setAlignmentY(0.0F);
        jPanel13.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel13.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber8.setText("0");
        transactionNumber8.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber8.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber8.setPreferredSize(new java.awt.Dimension(71, 16));

        price8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price8.setText("$0");
        price8.setMaximumSize(new java.awt.Dimension(26, 16));
        price8.setMinimumSize(new java.awt.Dimension(26, 16));
        price8.setPreferredSize(new java.awt.Dimension(26, 16));

        type8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type8.setText("Deposit");

        budgetAdjustment8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment8.setText("$0");
        budgetAdjustment8.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment8.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type8)
                    .addComponent(budgetAdjustment8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel14.setBackground(new java.awt.Color(102, 255, 102));
        jPanel14.setAlignmentX(0.0F);
        jPanel14.setAlignmentY(0.0F);
        jPanel14.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel14.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber9.setText("0");
        transactionNumber9.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber9.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber9.setPreferredSize(new java.awt.Dimension(71, 16));

        price9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price9.setText("$0");
        price9.setMaximumSize(new java.awt.Dimension(26, 16));
        price9.setMinimumSize(new java.awt.Dimension(26, 16));
        price9.setPreferredSize(new java.awt.Dimension(26, 16));

        type9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type9.setText("Deposit");

        budgetAdjustment9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment9.setText("$0");
        budgetAdjustment9.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment9.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type9)
                    .addComponent(budgetAdjustment9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel15.setBackground(new java.awt.Color(0, 204, 51));
        jPanel15.setAlignmentX(0.0F);
        jPanel15.setAlignmentY(0.0F);
        jPanel15.setMaximumSize(new java.awt.Dimension(815, 46));
        jPanel15.setMinimumSize(new java.awt.Dimension(815, 46));

        transactionNumber10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionNumber10.setText("0");
        transactionNumber10.setMaximumSize(new java.awt.Dimension(71, 16));
        transactionNumber10.setMinimumSize(new java.awt.Dimension(71, 16));
        transactionNumber10.setPreferredSize(new java.awt.Dimension(71, 16));

        price10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price10.setText("$0");
        price10.setMaximumSize(new java.awt.Dimension(26, 16));
        price10.setMinimumSize(new java.awt.Dimension(26, 16));
        price10.setPreferredSize(new java.awt.Dimension(26, 16));

        type10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type10.setText("Deposit");

        budgetAdjustment10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        budgetAdjustment10.setText("$0");
        budgetAdjustment10.setMaximumSize(new java.awt.Dimension(26, 16));
        budgetAdjustment10.setMinimumSize(new java.awt.Dimension(26, 16));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(transactionNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(type10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(price10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(budgetAdjustment10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionNumber10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type10)
                    .addComponent(budgetAdjustment10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(homeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(homeButton)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        new MainPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransactionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceButton;
    private javax.swing.JLabel budgetAdjustment1;
    private javax.swing.JLabel budgetAdjustment10;
    private javax.swing.JLabel budgetAdjustment2;
    private javax.swing.JLabel budgetAdjustment3;
    private javax.swing.JLabel budgetAdjustment4;
    private javax.swing.JLabel budgetAdjustment5;
    private javax.swing.JLabel budgetAdjustment6;
    private javax.swing.JLabel budgetAdjustment7;
    private javax.swing.JLabel budgetAdjustment8;
    private javax.swing.JLabel budgetAdjustment9;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel price1;
    private javax.swing.JLabel price10;
    private javax.swing.JLabel price2;
    private javax.swing.JLabel price3;
    private javax.swing.JLabel price4;
    private javax.swing.JLabel price5;
    private javax.swing.JLabel price6;
    private javax.swing.JLabel price7;
    private javax.swing.JLabel price8;
    private javax.swing.JLabel price9;
    private javax.swing.JLabel transactionNumber1;
    private javax.swing.JLabel transactionNumber10;
    private javax.swing.JLabel transactionNumber2;
    private javax.swing.JLabel transactionNumber3;
    private javax.swing.JLabel transactionNumber4;
    private javax.swing.JLabel transactionNumber5;
    private javax.swing.JLabel transactionNumber6;
    private javax.swing.JLabel transactionNumber7;
    private javax.swing.JLabel transactionNumber8;
    private javax.swing.JLabel transactionNumber9;
    private javax.swing.JLabel type1;
    private javax.swing.JLabel type10;
    private javax.swing.JLabel type2;
    private javax.swing.JLabel type3;
    private javax.swing.JLabel type4;
    private javax.swing.JLabel type5;
    private javax.swing.JLabel type6;
    private javax.swing.JLabel type7;
    private javax.swing.JLabel type8;
    private javax.swing.JLabel type9;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
