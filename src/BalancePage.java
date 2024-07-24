/**
* A banking app made for withdrawing, depositing, viewing transactions and setting a budget. This helps users bank with ease while being in their budget. The GUI is easy to navigate and user friendly
* This Part is the balance page GUI
* 
* @author Noor Syed, Smit Patel, Shaan, Jinay
* @version 1.0
* @since 2024-07-23
*/

import java.io.*;//imports reader/writer
import java.awt.*;

public class BalancePage extends javax.swing.JFrame {
    
    public static String username = "";//username
    
    public BalancePage() {
        initComponents();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\AuthenticatedUser.txt"));//reads AuthenticatedUser.txt file
            username = reader.readLine();//reads the line for it and sets it as the authenticated user
            String[] response = Balance.getBalance(username);//gets the balance
            welcomeText.setText("Welcome " + username);//welcome text edit at the top
            if (response[0].equals("true")) {//if the response is true
                double withdraw = Double.parseDouble(response[2]);//gets total withdraw
                double deposit = Double.parseDouble(response[3]);//gets total deposit
                double budget = Double.parseDouble(response[4]);//gets budget
                double budgetLeft = budget + withdraw + deposit;//sets budget left value
                currentBalance.setText("Current Balance: $" + response[1]);//Sets current balance
                totalWithdraw.setText("Total Withdrawn: $" + response[2]);//sets total withdrawn
                totalDeposit.setText("Total Deposit: $" + response[3]);//sets total deposit
                totalBudget.setText("Remaining Budget: $" + budgetLeft + "");//sets remaining budget
            }
            reader.close();//closes reader
        } catch (Exception e) {
            System.out.println("Error getting User Authentication.");//gets user auth error and prints it out.
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        welcomeText = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        withdrawPageButton = new javax.swing.JButton();
        depositPageButton = new javax.swing.JButton();
        currentBalance = new javax.swing.JLabel();
        totalWithdraw = new javax.swing.JLabel();
        totalBudget = new javax.swing.JLabel();
        totalDeposit = new javax.swing.JLabel();
        newBudget = new javax.swing.JTextField();
        setBudget = new javax.swing.JButton();
        errorField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(413, 65));

        welcomeText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        welcomeText.setText("Welcome ......................");

        homeButton.setBackground(new java.awt.Color(0, 204, 51));
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homeIcon.png"))); // NOI18N
        homeButton.setBorder(null);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoSmall.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(welcomeText)
                .addGap(129, 129, 129)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(welcomeText)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankLogo.png"))); // NOI18N

        withdrawPageButton.setBackground(new java.awt.Color(204, 0, 0));
        withdrawPageButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        withdrawPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/withdrawIcon.png"))); // NOI18N
        withdrawPageButton.setText("Withdraw");
        withdrawPageButton.setBorder(null);
        withdrawPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawPageButtonActionPerformed(evt);
            }
        });

        depositPageButton.setBackground(new java.awt.Color(0, 153, 0));
        depositPageButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        depositPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/depositIcon.png"))); // NOI18N
        depositPageButton.setText("Deposit");
        depositPageButton.setBorder(null);
        depositPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositPageButtonActionPerformed(evt);
            }
        });

        currentBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        currentBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentBalance.setText("Current Balance: $0");

        totalWithdraw.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalWithdraw.setForeground(new java.awt.Color(204, 0, 0));
        totalWithdraw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalWithdraw.setText("Total Withdraw: ");

        totalBudget.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalBudget.setForeground(new java.awt.Color(0, 0, 0));
        totalBudget.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBudget.setText("Budget Remaining:");

        totalDeposit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalDeposit.setForeground(new java.awt.Color(0, 153, 51));
        totalDeposit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalDeposit.setText("Total Deposited: ");
        totalDeposit.setMaximumSize(new java.awt.Dimension(100, 20));
        totalDeposit.setMinimumSize(new java.awt.Dimension(100, 20));
        totalDeposit.setPreferredSize(new java.awt.Dimension(100, 20));

        newBudget.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBudget.setText("Enter Budget");
        newBudget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBudgetMouseClicked(evt);
            }
        });
        newBudget.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newBudgetKeyTyped(evt);
            }
        });

        setBudget.setBackground(new java.awt.Color(204, 204, 204));
        setBudget.setForeground(new java.awt.Color(0, 0, 0));
        setBudget.setText("Set Budget");
        setBudget.setBorder(null);
        setBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setBudgetActionPerformed(evt);
            }
        });
        setBudget.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                setBudgetKeyTyped(evt);
            }
        });

        errorField.setForeground(new java.awt.Color(153, 0, 0));
        errorField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(depositPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addGap(43, 43, 43)
                .addComponent(withdrawPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newBudget, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(setBudget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(283, 283, 283)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentBalance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(totalWithdraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(totalBudget))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(withdrawPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(depositPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(currentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(totalDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(totalBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(newBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(errorField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void withdrawPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawPageButtonActionPerformed
        new WithdrawPage().setVisible(true);//leads you to withdraw page
        dispose();
    }//GEN-LAST:event_withdrawPageButtonActionPerformed

    private void depositPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositPageButtonActionPerformed
        new DepositPage().setVisible(true);//leads you do deposit page
        dispose();
    }//GEN-LAST:event_depositPageButtonActionPerformed

    private void setBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setBudgetActionPerformed
        String stringedBudget = newBudget.getText();//gets the text as a string
        try {
            double newSetBudget = Double.parseDouble(stringedBudget);//attempts parsing it
        String[] response = Balance.setNewBudget(username, newSetBudget);//sets new budget using method
        if (response[0].equals("true")) {//if response is true
            BalancePage balancePage = new BalancePage();//gets balance page

            // Make the WithdrawPage instance visible
            balancePage.setVisible(true);//sets it visible

            // Dispose of the current window
            dispose();//disposes current screen
            
            //note: this process refreshed the page.
        } else {
            errorField.setText(response[1]);//if error, sets error field text. Looks cleaner than console
        }
        } catch (NumberFormatException e) {
            errorField.setText("Enter Integers!");//if error, sets error field text. Looks cleaner than console
        }
    }//GEN-LAST:event_setBudgetActionPerformed

    private void newBudgetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newBudgetKeyTyped

    }//GEN-LAST:event_newBudgetKeyTyped

    private void setBudgetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setBudgetKeyTyped

    }//GEN-LAST:event_setBudgetKeyTyped

    private void newBudgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBudgetMouseClicked
        newBudget.setText("");
    }//GEN-LAST:event_newBudgetMouseClicked

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        new MainPage().setVisible(true);//leads you back home
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
            java.util.logging.Logger.getLogger(BalancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BalancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BalancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BalancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BalancePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceButton;
    private javax.swing.JLabel balanceButton1;
    private javax.swing.JLabel balanceButton2;
    private javax.swing.JLabel currentBalance;
    private javax.swing.JButton depositPageButton;
    private javax.swing.JLabel errorField;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField newBudget;
    private javax.swing.JButton setBudget;
    private javax.swing.JLabel totalBudget;
    private javax.swing.JLabel totalDeposit;
    private javax.swing.JLabel totalWithdraw;
    private javax.swing.JLabel welcomeText;
    private javax.swing.JLabel welcomeText1;
    private javax.swing.JLabel welcomeText2;
    private javax.swing.JLabel welcomeText3;
    private javax.swing.JButton withdrawPageButton;
    // End of variables declaration//GEN-END:variables
}
