package jf;

import dao.orderDAO;
import dao.orderDetailDAO;
import dao.productDAO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.order;
import model.orderDetail;
import model.product;
import java.sql.Date;
import java.util.stream.Collectors;

public class ManageStatistical extends javax.swing.JPanel {

    public ManageStatistical() {
        initComponents();
        displayDataFromSQL();
        showInfo();
    }

    public void showInfo() {
        jlQuantityOrder.setText(jTable.getRowCount() + "");

        int v = jTable.getRowCount();
        float tongg = 0;
        for (int i = 0; i < v; i++) {
            tongg += Float.parseFloat(jTable.getValueAt(i, 4).toString().substring(0, jTable.getValueAt(i, 4).toString().indexOf(" ")));
        }
        jlTotalPrice.setText(tongg + " $");
    }

    public void removeTable() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) this.jTable.getModel();
            int soLuongDong = model_table.getRowCount();
            if (soLuongDong == 0) {
                break;
            } else {
                model_table.removeRow(0);
            }
        }
    }

    public void displayDataFromSQL() {
        this.jTable.setRowHeight(30);
        this.jTable.setShowGrid(true);
        this.jTable.setGridColor(Color.blue);
        this.jTable.setSelectionBackground(Color.blue);
        this.jTable.setSelectionForeground(Color.white);
        removeTable();
        ArrayList<order> listOrder = orderDAO.getInstance().getAll();
        int index = listOrder.size();

        for (int i = 0; i < index; i++) {
//            String products = "";
//            ArrayList<orderDetail> list = orderDetailDAO.getInstance().getListProductOneOrder(listOrder.get(i).getId_order());
//            int v = list.size();
//            int vi = 0;
//            for (orderDetail detail : list) {
//                vi++;
//                product pr = new product();
//                pr.setId_product(detail.getProduct_id());
//                products += productDAO.getInstance().selectByid(pr).getName()+"("+detail.getQuantity()+")";
//                if(vi!=v){
//                    products += ", ";
//                } 
//            }
//            String[] data = {i + 1 + "", listOrder.get(i).getId_order() + "", listOrder.get(i).getSelers(), products, listOrder.get(i).getCreateDate() + "", listOrder.get(i).getTotalPrice() + " $"};
//            total += listOrder.get(i).getTotalPrice();
            String[] data = {i + 1 + "", listOrder.get(i).getId_order() + "", listOrder.get(i).getSelers(), listOrder.get(i).getCreateDate() + "", listOrder.get(i).getTotalPrice() + " $"};
            DefaultTableModel tbModel = (DefaultTableModel) this.jTable.getModel();
            tbModel.addRow(data);
        }
    }

    public void searchByProduct(product pr) {

    }

    public void searchByDate(String d1, String d2) {
        DefaultTableModel tbModel = (DefaultTableModel) this.jTable.getModel();
        removeTable();
        int i = 0;
        orderDAO.getInstance().selectByCondition("`createDate` BETWEEN '" + d1 + "' AND '" + d2 + "'").forEach((v) -> {
            String[] data = {i + 1 + "", v.getId_order() + "", v.getSelers(), v.getCreateDate() + "", v.getTotalPrice() + " $"};
            tbModel.addRow(data);
        });
        showInfo();
    }

    public void searchByTotalPrice(float totalFrom, float totalTo) {
        DefaultTableModel tbModel = (DefaultTableModel) this.jTable.getModel();
        removeTable();
        int i = 0;
        orderDAO.getInstance().selectByCondition("`TotalPrice` BETWEEN '" + totalFrom + "' AND '" + totalTo + "'").forEach((v) -> {
            String[] data = {i + 1 + "", v.getId_order() + "", v.getSelers(), v.getCreateDate() + "", v.getTotalPrice() + " $"};
            tbModel.addRow(data);
        });
        showInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jlTotalPrice = new javax.swing.JLabel();
        jlQuantityOrder = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 30, 40));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(198, 226, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Statistical");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 940, 60));

        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "3", "Viet", "2022-08-08", "100$"}
            },
            new String [] {
                "STT", "Order", "Selers", "Date", "Price"
            }
        ));
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 940, 550));

        jButton1.setBackground(new java.awt.Color(139, 0, 9));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reset");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 120, 40));

        jButton3.setBackground(new java.awt.Color(139, 0, 9));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("See details");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 40));

        jlTotalPrice.setBackground(new java.awt.Color(139, 0, 9));
        jlTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalPrice.setText("100");
        add(jlTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, 40));

        jlQuantityOrder.setBackground(new java.awt.Color(139, 0, 9));
        jlQuantityOrder.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlQuantityOrder.setForeground(new java.awt.Color(255, 255, 255));
        jlQuantityOrder.setText(" $");
        add(jlQuantityOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, 40));

        jLabel4.setBackground(new java.awt.Color(139, 0, 9));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, 40));

        jLabel5.setBackground(new java.awt.Color(139, 0, 9));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Price:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, 40));

        jButton2.setBackground(new java.awt.Color(139, 0, 9));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Serch");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 120, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        displayDataFromSQL();
        showInfo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel tbmodel = (DefaultTableModel) jTable.getModel();
        if (jTable.getSelectedRowCount() == 1) {
            int order_id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 1).toString());

            Statistical_manage t = new Statistical_manage();
            t.setVisible(true);
            t.setDataToUpdate(order_id);
            t.pack();
        } else {
            JOptionPane.showMessageDialog(null, "Please choose one row!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Statistical_search v = new Statistical_search();
        v.setVisible(true);
        v.pack();
        v.setManageStatistical(this);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel jlQuantityOrder;
    private javax.swing.JLabel jlTotalPrice;
    // End of variables declaration//GEN-END:variables
}
