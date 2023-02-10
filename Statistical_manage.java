package jf;

import dao.orderDAO;
import dao.orderDetailDAO;
import dao.productDAO;
import java.util.ArrayList;
import java.util.stream.Collectors;
import model.order;
import model.orderDetail;
import model.product;

public class Statistical_manage extends javax.swing.JFrame {

    private ManageProduct manageProduct;
    private int order_id = 0;
    private int totalQuantity = 0;
    private float total = 0;

    public ManageProduct getManageProduct() {
        return manageProduct;
    }

    public void setManageProduct(ManageProduct manageProduct) {
        this.manageProduct = manageProduct;
    }

    public Statistical_manage() {
        initComponents();
        setOrder();
    }

    public void setOrder() {
        jComboBoxOrder.removeAllItems();
        jComboBoxOrder.addItem("--Choose--");
        ArrayList<order> list = orderDAO.getInstance().getAll();
        for (order v : list) {
            jComboBoxOrder.addItem(v.getId_order() + "");
        }
        setProducts();
    }
    
    public void setOrderBySearch(String selers){
        jComboBoxOrder.removeAllItems();
        jComboBoxOrder.addItem("--Choose--");
        ArrayList<order> list = orderDAO.getInstance().getAll();
        list = (ArrayList<order>) list.stream().filter((v)->{
            return v.getSelers().equals(selers);
        }).collect(Collectors.toList());
        for (order v : list) {
            jComboBoxOrder.addItem(v.getId_order() + "");
        }
        setProducts();
    }

    public void setProducts() {
        jComboBoxProduct.removeAllItems();
        jComboBoxProduct.addItem("-----All-----");
        try {
            int id_orderr = Integer.parseInt(jComboBoxOrder.getSelectedItem().toString());

            ArrayList<orderDetail> list = orderDetailDAO.getInstance().getListProductOneOrder(id_orderr);

            for (orderDetail v : list) {
                product pr = new product();
                totalQuantity += v.getQuantity();
                pr.setId_product(v.getProduct_id());
                jComboBoxProduct.addItem(productDAO.getInstance().selectByid(pr).getName());
            }
            total = totalQuantity;
            jTQuantity.setText(totalQuantity + "");
        } catch (Exception e) {
            jComboBoxProduct.addItem("---None---");
            jComboBoxProduct.setSelectedItem("---None---");
            jComboBoxProduct.removeItem("-----All-----");
        }
    }

    public void setDataToUpdate(int id) {
        order_id = id;
        setOrder();
        jComboBoxOrder.setSelectedItem(order_id + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxProduct = new javax.swing.JComboBox<>();
        jComboBoxOrder = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTselers1 = new javax.swing.JLabel();
        jTQuantity = new javax.swing.JLabel();

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
        jLabel1.setText("Statistical");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Order");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 130, -1));

        jTTotal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTTotal.setText("...");
        jPanel1.add(jTTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Products");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 130, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 100, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setText("Total money");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 130, -1));

        jComboBoxProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----All----" }));
        jComboBoxProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 190, -1));

        jComboBoxOrder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose--" }));
        jComboBoxOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrderActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 190, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setText("Quantity");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 130, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Selers");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 130, -1));

        jTselers1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTselers1.setText("...");
        jPanel1.add(jTselers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 150, -1));

        jTQuantity.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jTQuantity.setText("...");
        jPanel1.add(jTQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jComboBoxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrderActionPerformed
        totalQuantity = 0;
        try {
            order_id = Integer.parseInt(jComboBoxOrder.getSelectedItem().toString());
            order o = new order();
            o.setId_order(order_id);
            o = orderDAO.getInstance().selectByid(o);
            jTselers1.setText(o.getSelers());
            jTTotal.setText(o.getTotalPrice() + " $");
            total = o.getTotalPrice();
        } catch (Exception e) {
            jTselers1.setText("...");
            jTTotal.setText("...");
            jTQuantity.setText("...");
            total = 0;
        }
        setProducts();
    }//GEN-LAST:event_jComboBoxOrderActionPerformed

    private void jComboBoxProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductActionPerformed
        if (jComboBoxProduct.getSelectedIndex() != 0) {
            try {
                String name_product = jComboBoxProduct.getSelectedItem().toString();
                product pr = new product();
                pr = productDAO.getInstance().getProductByName(name_product);
                ArrayList<orderDetail> list = orderDetailDAO.getInstance().getListProductOneOrder(order_id);
                for (orderDetail detail : list) {
                    product prr = new product();
                    prr.setId_product(detail.getProduct_id());
                    float price = productDAO.getInstance().selectByid(prr).getPrice();
                    if (detail.getProduct_id() == pr.getId_product()) {
                        jTQuantity.setText(detail.getQuantity() + "");
                        float totall = price * detail.getQuantity();
                        jTTotal.setText(totall + " $");
                    }
                }
            } catch (Exception e) {
            }
        } else {
            jTQuantity.setText(totalQuantity + "");
            jTTotal.setText(total + " $");
        }
    }//GEN-LAST:event_jComboBoxProductActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistical_manage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxOrder;
    private javax.swing.JComboBox<String> jComboBoxProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jTQuantity;
    private javax.swing.JLabel jTTotal;
    private javax.swing.JLabel jTselers1;
    // End of variables declaration//GEN-END:variables
}
