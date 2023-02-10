package jf;

import dao.orderDAO;
import dao.orderDetailDAO;
import dao.productDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.account;
import model.order;
import model.orderDetail;
import model.product;

public class ManageOrderDetail extends javax.swing.JPanel {

    public ManageOrderDetail() {
        initComponents();
        displayDataFromSQL();
    }

    public void displayDataFromSQL() {
        this.jTable.setRowHeight(30);
        this.jTable.setShowGrid(true);
        this.jTable.setGridColor(Color.blue);
        this.jTable.setSelectionBackground(Color.blue);
        this.jTable.setSelectionForeground(Color.white);
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) this.jTable.getModel();
            int soLuongDong = model_table.getRowCount();
            if (soLuongDong == 0) {
                break;
            } else {
                model_table.removeRow(0);
            }
        }
        orderDetailDAO.getInstance().getAll().forEach((v) -> {
            product pr = new product();
            pr.setId_product(v.getProduct_id());
            pr = productDAO.getInstance().selectByid(pr);
            String[] data = {v.getId_orderDetail() + "", v.getOrder_id() + "", pr.getName(), v.getQuantity() + ""};
            DefaultTableModel tbModel = (DefaultTableModel) this.jTable.getModel();
            tbModel.addRow(data);
        });
        jlrowCount.setText("" + jTable.getRowCount());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jlrowCount = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 30, 40));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(198, 226, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Order Detail");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 940, 60));

        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dasd", "dsa", "dsa", "dsa"}
            },
            new String [] {
                "Id", "Order", "Product", "Quantity"
            }
        ));
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 940, 550));

        jButton1.setBackground(new java.awt.Color(139, 0, 9));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 120, 40));

        jButton3.setBackground(new java.awt.Color(139, 0, 9));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 40));

        jLabel4.setBackground(new java.awt.Color(139, 0, 9));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Amount Row :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, 40));

        jlrowCount.setBackground(new java.awt.Color(139, 0, 9));
        jlrowCount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlrowCount.setForeground(new java.awt.Color(255, 255, 255));
        jlrowCount.setText(" $");
        add(jlrowCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 80, -1, 40));
    }// </editor-fold>//GEN-END:initComponents

    public void updateOrder() {
        int id_orderdetail = Integer.parseInt((String) this.jTable.getValueAt(this.jTable.getSelectedRow(), 0));
        orderDetail o = new orderDetail();
        o.setId_orderDetail(id_orderdetail);
        o = orderDetailDAO.getInstance().selectByid(o);
        int order_id = o.getOrder_id();
        ArrayList<orderDetail> list = orderDetailDAO.getInstance().getListProductOneOrder(order_id);

        list = (ArrayList<orderDetail>) list.stream().filter((v) -> {
            return v.getId_orderDetail() != id_orderdetail;
        }).collect(Collectors.toList());

        int quantity = 0;
        float tong = 0;
        for (orderDetail detail : list) {
            System.out.println(detail.getQuantity());
            quantity += detail.getQuantity();
            product pr = new product();
            pr.setId_product(detail.getProduct_id());
            pr = productDAO.getInstance().selectByid(pr);
            tong += productDAO.getInstance().selectByid(pr).getPrice() * detail.getQuantity();
        }
        System.out.println(tong);
        int vi = 0;
        int kq = quantity / 3;
        if (kq >= 1) {
            vi += kq;
        }
        float tax = (float) (vi * 0.5);
        tong += tax;
        order or = new order();
        or.setId_order(order_id);
        or = orderDAO.getInstance().selectByid(or);
        or.setTotalPrice(tong);
        orderDAO.getInstance().update(or);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tbmodel = (DefaultTableModel) jTable.getModel();
        if (jTable.getSelectedRowCount() == 1) {
            int id_orderdetail = Integer.parseInt((String) this.jTable.getValueAt(this.jTable.getSelectedRow(), 0));
            orderDetail o = new orderDetail();
            o.setId_orderDetail(id_orderdetail);
            o = orderDetailDAO.getInstance().selectByid(o);
            int luaChon = JOptionPane.showConfirmDialog(this, "You sure!");
            if (luaChon == JOptionPane.YES_OPTION) {
                o.setStatus(0);
                orderDetailDAO.getInstance().update(o);
                updateOrder();
                displayDataFromSQL();
                JOptionPane.showMessageDialog(this, "Delete Successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please choose one row to delete!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel tbmodel = (DefaultTableModel) jTable.getModel();
        if (jTable.getSelectedRowCount() == 1) {
            int orderDetail_id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
            int order_id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 1).toString());
            int product_id = productDAO.getInstance().getProductByName(jTable.getValueAt(jTable.getSelectedRow(), 2).toString()).getId_product();
            int quantity = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 3).toString());

            orderDetail o = new orderDetail(orderDetail_id, order_id, product_id, quantity);

            OrderDetail_manage t = new OrderDetail_manage();
            t.setVisible(true);
            t.setDataToUpdate(o);
            t.pack();
            t.setManageOrderDetail(this);
        } else {
            JOptionPane.showMessageDialog(null, "Please choose one row!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel jlrowCount;
    // End of variables declaration//GEN-END:variables
}
