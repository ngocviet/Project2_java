package jf;

import dao.orderDAO;
import dao.orderDetailDAO;
import dao.productDAO;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import model.order;
import model.orderDetail;
import model.product;

public class OrderDetail_manage extends javax.swing.JFrame {

    private ManageOrderDetail manageOrderDetail;
    private orderDetail orderDetail;

    public ManageOrderDetail getManageOrderDetail() {
        return manageOrderDetail;
    }

    public void setManageOrderDetail(ManageOrderDetail manageOrderDetail) {
        this.manageOrderDetail = manageOrderDetail;
    }

    public OrderDetail_manage() {
        initComponents();
    }

    public void setContent(String v) {
        jLabel1.setText(v);
    }

    public void setDataToUpdate(orderDetail o) {
        orderDetail = o;
        jSpinner1.setValue(o.getQuantity());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        jLabel1.setText("Update Order Detail");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Quantity");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 130, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 100, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 100, -1));

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public boolean checkEmpty() {
        if (this.jSpinner1.getValue().toString().equals("0")) {
            JOptionPane.showMessageDialog(null, "Please enter all infomation!");
            return true;
        }
        return false;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checkEmpty()) {
            return;
        }

        int quantity = Integer.parseInt(jSpinner1.getValue().toString());
        int id_order = orderDetail.getOrder_id();

        order o = orderDAO.getInstance().selectByid(new order(id_order, null, 0, null));

        ArrayList<orderDetail> listOrderDetail = orderDetailDAO.getInstance().getListProductOneOrder(id_order);
        listOrderDetail = (ArrayList<orderDetail>) listOrderDetail.stream().filter((v) -> {
            return v.getId_orderDetail() != orderDetail.getId_orderDetail();
        }).collect(Collectors.toList());
        int quantity_product = 0;
        float total_default = 0;
        for (orderDetail detail : listOrderDetail) {
            quantity_product += detail.getQuantity();
            total_default += detail.getQuantity() * (productDAO.getInstance().selectByid(new product(detail.getProduct_id(), "", 0, "", 0)).getPrice());
        }

        int vi = 0;
        int kq = (quantity + quantity_product) / 3;
        if (kq >= 1) {
            vi += kq;
        }
        float tax = (float) (vi * 0.5);
        float total = (quantity * (productDAO.getInstance().selectByid(new product(orderDetail.getProduct_id(), "", 0, "", 0)).getPrice()));
        total += tax + total_default;
        
        o.setTotalPrice(total);
        orderDAO.getInstance().update(o);
        orderDetail.setQuantity(quantity);
        orderDetailDAO.getInstance().update(orderDetail);

        manageOrderDetail.displayDataFromSQL();
        JOptionPane.showMessageDialog(this, "Update success!");
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
                new OrderDetail_manage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
