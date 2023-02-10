package jf;

import dao.productDAO;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.product;

public class Product_manage extends javax.swing.JFrame {

    private ManageProduct manageProduct;
    private int id_product = 0;
    private int current_position = 0;

    public ManageProduct getManageProduct() {
        return manageProduct;
    }

    public void setManageProduct(ManageProduct manageProduct) {
        this.manageProduct = manageProduct;
    }

    public Product_manage() {
        initComponents();
        init();
    }

    public void init() {

    }

    public void setContent(String v) {
        jLabel1.setText(v);
        if (v.equals("Add Product")) {
            product pr = productDAO.getInstance().getPrHasPositionMax();
            jSpinner1.setValue(pr.getPosition() + 1);
            jSpinner1.setEnabled(false);
        }
    }

    public void setDataToUpdate(product pr) {
        jTName.setText(pr.getName());
        jTPrice.setText(pr.getPrice() + "");
        jLLink.setText(pr.getImg());
        id_product = pr.getId_product();
        current_position = pr.getPosition();
        product prr = productDAO.getInstance().getPrHasPositionMax();
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(pr.getPosition(), 1, prr.getPosition(), 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLLink = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTPrice = new javax.swing.JTextField();
        jBImg = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTName = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();

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
        jLabel2.setText("Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 130, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Price");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Posittion");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 130, -1));

        jLLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLLink.setText(" Img");
        jPanel1.add(jLLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 210, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 100, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 100, -1));

        jTPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(jTPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 210, 30));

        jBImg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBImg.setText("--Choose--");
        jBImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImgActionPerformed(evt);
            }
        });
        jPanel1.add(jBImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setText(" Img");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 130, -1));

        jTName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(jTName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 210, 30));

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        jTName.setText("");
        jTPrice.setText("");
        jSpinner1.setValue(0);
        jLLink.setText("");
    }

    public boolean checkEmpty() {
        if (jTPrice.getText().equals("") || jSpinner1.getValue().toString().equals("") || jTName.getText().equals("") || jLLink.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter all infomation!");
            return true;
        }
        return false;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checkEmpty()) {
            return;
        }
        String name = jTName.getText();
        if (jLabel1.getText().equals("Add Product")) {
            ArrayList<product> list = productDAO.getInstance().selectAll();

            for (product v : list) {
                if (v.getName().equals(name)) {
                    JOptionPane.showMessageDialog(null, "Name product exits! Please enter adgain!");
                    jTName.setText("");
                    return;
                }
            }
            product pr = new product(1, jTName.getText(), Float.parseFloat(jTPrice.getText()), jLLink.getText(), Integer.parseInt(jSpinner1.getValue().toString()));
            productDAO.getInstance().insert(pr);
        } else {
            product pr = new product(id_product, jTName.getText(), Float.parseFloat(jTPrice.getText()), jLLink.getText(), Integer.parseInt(jSpinner1.getValue().toString()));
            if (Integer.parseInt(jSpinner1.getValue().toString()) != current_position) {
                int v = JOptionPane.showConfirmDialog(this, "You sure change position!");
                if (v == JOptionPane.YES_OPTION) {
                    product change_pr = productDAO.getInstance().getProductByPosition(Integer.parseInt(jSpinner1.getValue().toString()));
                    change_pr.setPosition(current_position);
                    productDAO.getInstance().update(pr);
                    productDAO.getInstance().update(change_pr);
                }
            } else {
                productDAO.getInstance().update(pr);
            }
        }
        manageProduct.displayDataFromSQL();
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

    private void jBImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImgActionPerformed
        try {
            JFileChooser f = new JFileChooser("C:\\Users\\DELL\\Documents\\NetBeansProjects\\CafeViet\\src\\img");
            f.setDialogTitle("Open file");
            f.showOpenDialog(null);
            File f_img_name = f.getSelectedFile();
            String duongDanImg = f_img_name.getAbsolutePath();
            duongDanImg = duongDanImg.substring(duongDanImg.lastIndexOf("\\") + 1, duongDanImg.length());
            jLLink.setText(duongDanImg);
        } catch (Exception e) {
            System.out.println("Chua chon anh");
        }
    }//GEN-LAST:event_jBImgActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product_manage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBImg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLLink;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTName;
    private javax.swing.JTextField jTPrice;
    // End of variables declaration//GEN-END:variables
}
