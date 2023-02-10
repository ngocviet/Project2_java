package jf;

import dao.accountDAO;
import java.awt.Image;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.account;

public class login extends javax.swing.JFrame {

    String acctionPass = "hide";

    public login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        changeIcon();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jlanh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 3, true));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Viog Coffee");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, -1));

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 82, 250, 30));

        password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 132, 250, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 82, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 132, -1, 30));

        jButton1.setBackground(new java.awt.Color(51, 204, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 100, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Exit");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 100, 40));

        jlanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlanhMouseClicked(evt);
            }
        });
        jPanel1.add(jlanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 132, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (int i = 10; i > 1; i--) {
            float v = (float) i / 10;
            this.setOpacity(v);
            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }
        }
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed
    int xx, xy;
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (float i = (float) 0.0; i < 1.0; i += 0.1) {
            this.setOpacity(i);
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setOpacity(1);
    }//GEN-LAST:event_formWindowOpened

    private void jlanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlanhMouseClicked
        if (acctionPass.equals("hide")) {
            acctionPass = "show";
            password.setEchoChar((char) 0);
        } else {
            password.setEchoChar('*');
            acctionPass = "hide";
        }
        changeIcon();
    }//GEN-LAST:event_jlanhMouseClicked

    public boolean isEmpty() {
        if (username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username is missing", "Warning", 1);
            return false;
        }
        if (String.valueOf(password.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password is missing", "Warning", 1);
            return false;
        }
        return true;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (isEmpty()) {
            String user = username.getText();
            String pass = String.valueOf(password.getPassword());
            String passHash = "";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(pass.getBytes());
                byte[] resultByteArray = messageDigest.digest();
                StringBuilder sb = new StringBuilder();

                for (byte b : resultByteArray) {
                    sb.append(String.format("%02x", b));
                }
                passHash = sb.toString();
            } catch (Exception e) {
            }
            System.out.println(passHash);
            ArrayList<account> listAc = accountDAO.getInstance().getAll();
            for (account ac : listAc) {
                if (ac.getUsername().equals(user) && ac.getPass().equals(pass) && ac.getPassHash().equals(passHash)) {
                    if (ac.getPermission() == 0) {
                        mainCafe main = new mainCafe();
                        main.setVisible(true);
                        main.setSelers(ac.getName());
                        main.pack();
                        this.dispose();
                    } else {
                        mainAdmin main = new mainAdmin();
                        main.setVisible(true);
                        main.pack();
                        this.dispose();
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Invalidate username or password", "Warning", 1);
            username.setText("");
            password.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlanh;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
