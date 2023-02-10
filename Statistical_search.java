package jf;

import dao.orderDAO;
import dao.productDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.order;
import model.product;

public class Statistical_search extends javax.swing.JFrame {

    private ManageStatistical manageStatistical;
    private boolean AcctionSelers = false;
    private boolean AcctionProduct = false;
    private boolean AcctionDate = false;
    private boolean AcctionTotal = false;
    private String action = "";

    public ManageStatistical getManageStatistical() {
        return manageStatistical;
    }

    public void setManageStatistical(ManageStatistical manageStatistical) {
        this.manageStatistical = manageStatistical;
    }

    public Statistical_search() {
        initComponents();
        reset();
        setDataProduct();
    }

    public void reset() {
        jTextFieldSelers.setEnabled(false);
        jComboBoxprodcut.setEnabled(false);
        jDateChooserFrom.setEnabled(false);
        jDateChooserTo.setEnabled(false);
        jSpinnerFrom.setEnabled(false);
        jSpinnerTo.setEnabled(false);
    }

    public void resetByOneAction() {
        AcctionSelers = false;
        AcctionProduct = false;
        AcctionDate = false;
        AcctionTotal = false;
        jCheckBoxSelers.setSelected(false);
        jCheckBoxProduct.setSelected(false);
        jCheckBoxDate.setSelected(false);
        jCheckBoxTotal.setSelected(false);
        reset();
        switch (action) {
            case "selers" -> {
                AcctionSelers = true;
                jCheckBoxSelers.setSelected(true);
            }
            case "product" -> {
                AcctionProduct = true;
                jCheckBoxProduct.setSelected(true);
            }
            case "date" -> {
                AcctionDate = true;
                jCheckBoxDate.setSelected(true);
            }
            case "total" -> {
                AcctionTotal = true;
                jCheckBoxTotal.setSelected(true);
            }
            case "" -> {
                jCheckBoxDate.setSelected(false);
                jCheckBoxSelers.setSelected(false);
                jCheckBoxTotal.setSelected(false);
                jCheckBoxProduct.setSelected(false);
            }
            default -> {
            }
        }
    }
    
    public void setDataProduct(){
        ArrayList<product> list = productDAO.getInstance().getAll();
        for (product object : list) {
            jComboBoxprodcut.addItem(object.getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jCheckBoxTotal = new javax.swing.JCheckBox();
        jCheckBoxSelers = new javax.swing.JCheckBox();
        jCheckBoxProduct = new javax.swing.JCheckBox();
        jCheckBoxDate = new javax.swing.JCheckBox();
        jButtonCancel = new javax.swing.JButton();
        jTextFieldSelers = new javax.swing.JTextField();
        jComboBoxprodcut = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerTo = new javax.swing.JSpinner();
        jSpinnerFrom = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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
        jLabel1.setText("Statistical Search");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 575, -1));

        jButtonOk.setBackground(new java.awt.Color(0, 255, 0));
        jButtonOk.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jButtonOk.setForeground(new java.awt.Color(255, 255, 255));
        jButtonOk.setText("OK");
        jButtonOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 100, -1));

        jCheckBoxTotal.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckBoxTotal.setText("Total Price");
        jCheckBoxTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxTotalActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 150, 30));

        jCheckBoxSelers.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckBoxSelers.setText("Selers");
        jCheckBoxSelers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSelersActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxSelers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jCheckBoxProduct.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckBoxProduct.setText("Product");
        jCheckBoxProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProductActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 30));

        jCheckBoxDate.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckBoxDate.setText("Date");
        jCheckBoxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDateActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 150, 30));

        jButtonCancel.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCancel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setText("Cancel");
        jButtonCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 100, -1));

        jTextFieldSelers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(jTextFieldSelers, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 200, 30));

        jComboBoxprodcut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxprodcut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose--" }));
        jPanel1.add(jComboBoxprodcut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("$");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 30, 30));
        jPanel1.add(jDateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 120, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("From");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 50, 30));
        jPanel1.add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 120, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("From");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 50, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("To");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 30, 30));

        jSpinnerTo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSpinnerTo.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(jSpinnerTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 70, 30));

        jSpinnerFrom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSpinnerFrom.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(jSpinnerFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 70, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("To");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 30, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("$");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void searchBySeler() {
        String seler = jTextFieldSelers.getText();
        if (seler.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter data!");
            return;
        }
        ArrayList<order> list = orderDAO.getInstance().getAll();
        boolean status = false;
        for (order object : list) {
            System.out.println("check");
            if (object.getSelers().equals(seler)) {
                status = true;
            }
        }
        if (status) {
            Statistical_manage v = new Statistical_manage();
            v.setVisible(true);
            v.pack();
            v.setOrderBySearch(seler);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Don't staff named " + seler);
        }
    }

    public boolean checkPrice(float pF, float pT) {
        if (pF > pT) {
            return false;
        }
        return true;
    }

    public void searchByTotal() {
        float priceFrom = Float.parseFloat(jSpinnerFrom.getValue().toString());
        float priceTo = Float.parseFloat(jSpinnerTo.getValue().toString());

        if (!checkPrice(priceFrom, priceTo)) {
            JOptionPane.showMessageDialog(null, "Data unsuccess!");
            jSpinnerFrom.setValue(0);
            jSpinnerTo.setValue(0);
            action = "";
            resetByOneAction();
            return;
        }
        manageStatistical.searchByTotalPrice(priceFrom, priceTo);
        this.dispose();
    }

    public boolean checkDate(String dF, String dT) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        var dateee = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String dateNow = df.format(dateee);

        int yearF = Integer.parseInt(dF.substring(0, 4));
        int yearT = Integer.parseInt(dT.substring(0, 4));
        int monthF = Integer.parseInt(dF.substring(5, 7));
        int monthT = Integer.parseInt(dT.substring(5, 7));
        int dateF = Integer.parseInt(dF.substring(8, 10));
        int dateT = Integer.parseInt(dT.substring(8, 10));
        int yearN = Integer.parseInt(dateNow.substring(0, 4));
        int monthN = Integer.parseInt(dateNow.substring(5, 7));
        int dateN = Integer.parseInt(dateNow.substring(8, 10));

        if (yearT > yearN || yearF > yearT) {
            return false;
        }
        if (yearF == yearT && yearT == yearN) {
            if (monthF > monthT || monthT > monthN) {
                return false;
            }
            if (monthF == monthT && monthT == monthN) {
                if (dateF > dateT || dateT > dateN) {
                    return false;
                }
            }
        }
        return true;
    }

    public void searchBtDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dayF = df.format(jDateChooserFrom.getDate());
        String dayT = df.format(jDateChooserTo.getDate());

        String sd1 = df.format(this.jDateChooserFrom.getDate());
        java.sql.Date dayFrom = Date.valueOf(sd1);

        if (!checkDate(dayF, dayT)) {
            JOptionPane.showMessageDialog(null, "Data unsuccess!");
            jDateChooserFrom.setDate(null);
            jDateChooserTo.setDate(null);
            action = "";
            resetByOneAction();
            return;
        }
        manageStatistical.searchByDate(dayF, dayT);
        this.dispose();
    }

    public void searchByProduct() {
        if (jComboBoxprodcut.getSelectedIndex() != 0) {
            String name_product = jComboBoxprodcut.getSelectedItem().toString();
            
            SearchByProduct v = new SearchByProduct();
            v.setVisible(true);
            v.pack();
            v.setProduct(name_product);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Please choose one product!");
        }
    }

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        if (AcctionSelers) {
            searchBySeler();
        } else if (AcctionProduct) {
            searchByProduct();
        } else if (AcctionDate) {
            searchBtDate();
        } else if (AcctionTotal) {
            searchByTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Please one action to search!");
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

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

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        for (int i = 10; i > 1; i--) {
            float v = (float) i / 10;
            this.setOpacity(v);
            try {
                Thread.sleep(40);
            } catch (Exception e) {
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jCheckBoxSelersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSelersActionPerformed
        if (!AcctionSelers) {
            AcctionSelers = true;
            action = "selers";
            resetByOneAction();
            jTextFieldSelers.setEnabled(true);
        } else {
            AcctionSelers = false;
            jTextFieldSelers.setEnabled(false);
            jTextFieldSelers.setText("");
        }
    }//GEN-LAST:event_jCheckBoxSelersActionPerformed

    private void jCheckBoxProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProductActionPerformed
        if (!AcctionProduct) {
            AcctionProduct = true;
            action = "product";
            resetByOneAction();
            jComboBoxprodcut.setEnabled(true);
        } else {
            AcctionProduct = false;
            jComboBoxprodcut.setEnabled(false);
            jComboBoxprodcut.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jCheckBoxProductActionPerformed

    private void jCheckBoxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDateActionPerformed
        if (!AcctionDate) {
            AcctionDate = true;
            action = "date";
            resetByOneAction();
            jDateChooserTo.setEnabled(true);
            jDateChooserFrom.setEnabled(true);
            System.out.println(AcctionSelers + "seler");
        } else {
            AcctionDate = false;
            jDateChooserTo.setEnabled(true);
            jDateChooserFrom.setEnabled(true);
            jDateChooserTo.setDate(null);
            jDateChooserFrom.setDate(null);
        }
    }//GEN-LAST:event_jCheckBoxDateActionPerformed

    private void jCheckBoxTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxTotalActionPerformed
        if (!AcctionTotal) {
            AcctionTotal = true;
            action = "total";
            resetByOneAction();
            jSpinnerTo.setEnabled(true);
            jSpinnerFrom.setEnabled(true);
        } else {
            AcctionTotal = false;
            jSpinnerTo.setEnabled(true);
            jSpinnerFrom.setEnabled(true);
            jSpinnerTo.setValue(0);
            jSpinnerFrom.setValue(0);
        }
    }//GEN-LAST:event_jCheckBoxTotalActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistical_search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JCheckBox jCheckBoxDate;
    private javax.swing.JCheckBox jCheckBoxProduct;
    private javax.swing.JCheckBox jCheckBoxSelers;
    private javax.swing.JCheckBox jCheckBoxTotal;
    private javax.swing.JComboBox<String> jComboBoxprodcut;
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerFrom;
    private javax.swing.JSpinner jSpinnerTo;
    private javax.swing.JTextField jTextFieldSelers;
    // End of variables declaration//GEN-END:variables
}
