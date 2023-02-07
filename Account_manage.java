package jf;

import dao.accountDAO;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.account;

public class Account_manage extends javax.swing.JFrame {

    private ManageAccount manageAccount;
    String acctionPass = "hide";

    public ManageAccount getManageAccount() {
        return manageAccount;
    }

    public void setManageAccount(ManageAccount manageAccount) {
        this.manageAccount = manageAccount;
    }

    public void changeIcon() {
        if (acctionPass.equals("hide")) {
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/img/invisible.png"));
            Image img1 = icon1.getImage().getScaledInstance(jlanh.getWidth(), jlanh.getHeight(), Image.SCALE_SMOOTH);
            jlanh.setIcon(new ImageIcon(img1));
        } else {
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/img/visible.png"));
            Image img1 = icon1.getImage().getScaledInstance(jlanh.getWidth(), jlanh.getHeight(), Image.SCALE_SMOOTH);
            jlanh.setIcon(new ImageIcon(img1));
        }
    }

    public Account_manage() {
        initComponents();
        changeIcon();
    }

    public void setContent(String v) {
        jLabel1.setText(v);
    }

    public void setDataToUpdate(account ac) {
        jTextField1.setText(ac.getUsername());
        jTextField2.setText(ac.getName());
        jPasswordField1.setText(ac.getPass());
        acctionPass = "show";
        changeIcon();
        jPasswordField1.setEchoChar((char) 0);
        jComboBox1.setSelectedIndex(ac.getPermission() == 1 ? 1 : 2);
        jTextField1.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jlanh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 130, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 130, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Permission");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 130, -1));

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("OK");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 100, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 100, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 210, 30));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 210, 30));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 210, 30));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chose--", "Admin", "User" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 210, 30));

        jlanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlanhMouseClicked(evt);
            }
        });
        jPanel1.add(jlanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlanhMouseClicked
        if (acctionPass.equals("hide")) {
            acctionPass = "show";
            jPasswordField1.setEchoChar((char) 0);
        } else {
            jPasswordField1.setEchoChar('*');
            acctionPass = "hide";
        }
        changeIcon();
    }//GEN-LAST:event_jlanhMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (int i = 10; i > 1; i--) {
            float v = (float) i / 10;
            this.setOpacity(v);
            try {
                Thread.sleep(40);
            } catch (Exception e) {
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (int i = 0; i < 10; i++) {
            float v = (float) i / 10;
            this.setOpacity(v);
            try {
                Thread.sleep(30);
            } catch (Exception e) {
            }
        }
        this.setOpacity(1);
    }//GEN-LAST:event_formWindowOpened

    public void resetForm() {
        jTextField1.setText("");
        jTextField2.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
    }

    public boolean checkEmpty() {
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("") || jPasswordField1.getText().equals("") || jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter all infomation!");
            return true;
        }
        return false;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checkEmpty()) {
            return;
        }
        String username = jTextField1.getText();
        if (jLabel1.getText().equals("Add Account")) {
            ArrayList<account> list = accountDAO.getInstance().selectAll();

            for (account v : list) {
                if (v.getUsername().equals(username)) {
                    JOptionPane.showMessageDialog(null, "Account exits! Please enter adgain!");
                    resetForm();
                    return;
                }
            }
            int permission = jComboBox1.getSelectedIndex();
            account ac = new account(1, username, jPasswordField1.getText(), "", permission == 1 ? 1 : 0, jTextField2.getText());
            accountDAO.getInstance().insert(ac);
        } else {
            int permission = jComboBox1.getSelectedIndex();
            account ac = accountDAO.getInstance().getAccByUsername(username);
            int id = ac.getId_account();
            ac = new account(id, username, jPasswordField1.getText(), "", permission == 1 ? 1 : 0, jTextField2.getText());
            accountDAO.getInstance().update(ac);
        }
        manageAccount.displayDataFromSQL();
        for (int i = 10; i > 1; i--) {
            float v = (float) i / 10;
            this.setOpacity(v);
            try {
                Thread.sleep(30);
            } catch (Exception e) {
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account_manage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jlanh;
    // End of variables declaration//GEN-END:variables
}
