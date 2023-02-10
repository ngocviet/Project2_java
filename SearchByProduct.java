package jf;

import dao.orderDetailDAO;
import dao.productDAO;
import java.util.ArrayList;
import java.util.stream.Collectors;
import model.orderDetail;
import model.product;

public class SearchByProduct extends javax.swing.JFrame {

    public SearchByProduct() {
        initComponents();
        setDataProduct();
    }

    public void reset() {
        setDataProduct();
        jComboBoxprodcut.setSelectedIndex(0);
        jLQuantity.setText("...");
        jLPrice.setText("...");
        jCheckBoxPriceMax.setSelected(false);
        jCheckBoxQuantityMax.setSelected(false);
    }

    public void setDataProduct() {
        ArrayList<product> list = productDAO.getInstance().getAll();
        for (product object : list) {
            jComboBoxprodcut.addItem(object.getName());
        }
    }

    public void setProduct(String name_product) {
        jComboBoxprodcut.setSelectedItem(name_product);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jComboBoxprodcut = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLPrice = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLQuantity = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBoxQuantityMax = new javax.swing.JCheckBox();
        jCheckBoxPriceMax = new javax.swing.JCheckBox();
        jButtonCancel1 = new javax.swing.JButton();

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 395, -1));

        jButtonCancel.setBackground(new java.awt.Color(0, 51, 204));
        jButtonCancel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setText("Reset");
        jButtonCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 100, -1));

        jComboBoxprodcut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBoxprodcut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose--", "----All----" }));
        jComboBoxprodcut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxprodcutActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxprodcut, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setText("Product");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 30));

        jLPrice.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLPrice.setText("0 $");
        jPanel1.add(jLPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel7.setText("Quantity :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, 30));

        jLQuantity.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLQuantity.setText("...");
        jPanel1.add(jLQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 130, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel9.setText("Total Price :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 30));

        jCheckBoxQuantityMax.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckBoxQuantityMax.setText("Product have quantity max");
        jCheckBoxQuantityMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxQuantityMaxActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxQuantityMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 365, 30));

        jCheckBoxPriceMax.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jCheckBoxPriceMax.setText("Product have total price max");
        jCheckBoxPriceMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPriceMaxActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxPriceMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 365, 30));

        jButtonCancel1.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCancel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jButtonCancel1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancel1.setText("Cancel");
        jButtonCancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancel1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        reset();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    public void checkMax(String action) {
        int quantityMax = 0;
        float totalMax = 0;
        int id_pr = 0;
        ArrayList<Integer> listId = new ArrayList<>();

        ArrayList<orderDetail> list = orderDetailDAO.getInstance().getAll();

        int index = list.size();

        if (action.equals("quantity")) {
            quantityMax = getQuantity(list.get(0).getProduct_id());
            id_pr = list.get(0).getProduct_id();
            for (int i = 1; i < index; i++) {
                if (getQuantity(list.get(i).getProduct_id()) > quantityMax) {
                    quantityMax = getQuantity(list.get(i).getProduct_id());
                    id_pr = list.get(i).getProduct_id();
                }
            }
            for (int i = 0; i < index; i++) {
                if (getQuantity(list.get(i).getProduct_id()) == quantityMax) {
                    boolean status = true;
                    for (Integer detail : listId) {
                        if (detail == list.get(i).getProduct_id()) {
                            status = false;
                        }
                    }
                    if (status) {
                        listId.add(list.get(i).getProduct_id());
                    }
                }
            }

        } else if (action.equals("price")) {
            totalMax = getPrice(list.get(0).getProduct_id());
            id_pr = list.get(0).getProduct_id();
            for (int i = 1; i < index; i++) {
                if (getPrice(list.get(i).getProduct_id()) > totalMax) {
                    totalMax = getPrice(list.get(i).getProduct_id());
                    id_pr = list.get(i).getProduct_id();
                }
            }
            for (int i = 0; i < index; i++) {
                if (getPrice(list.get(i).getProduct_id()) == totalMax) {
                    boolean status = true;
                    for (Integer detail : listId) {
                        if (detail == list.get(i).getProduct_id()) {
                            status = false;
                        }
                    }
                    if (status) {
                        listId.add(list.get(i).getProduct_id());
                    }
                }
            }
        }
        setJcomProductByListID(listId);
    }

    public void setJcomProductByListID(ArrayList<Integer> list) {
        jComboBoxprodcut.removeAllItems();
        jComboBoxprodcut.addItem("--Choose--");
        for (Integer v : list) {
            product pr = new product();
            pr.setId_product(v);
            pr = productDAO.getInstance().selectByid(pr);
            jComboBoxprodcut.addItem(pr.getName());
        }
    }

    private void jCheckBoxQuantityMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxQuantityMaxActionPerformed
        jCheckBoxPriceMax.setSelected(false);
        checkMax("quantity");
    }//GEN-LAST:event_jCheckBoxQuantityMaxActionPerformed

    private void jCheckBoxPriceMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPriceMaxActionPerformed
        jCheckBoxQuantityMax.setSelected(false);
        checkMax("price");
    }//GEN-LAST:event_jCheckBoxPriceMaxActionPerformed

    public void setDataByProduct() {
        try {
            String name_pr = jComboBoxprodcut.getSelectedItem().toString();
            product pr = productDAO.getInstance().getProductByName(name_pr);

            ArrayList<orderDetail> list = orderDetailDAO.getInstance().getAll();

            list = (ArrayList<orderDetail>) list.stream().filter((v) -> {
                return v.getProduct_id() == pr.getId_product();
            }).collect(Collectors.toList());
            int quantity = 0;
            float total = 0;
            for (orderDetail v : list) {
                quantity += v.getQuantity();
                total += v.getQuantity() * pr.getPrice();
            }
            jLQuantity.setText(quantity + "");
            jLPrice.setText(total + " $");
        } catch (Exception e) {
            System.out.println("er");
        }
    }

    public int getQuantity(int id_pr) {
        ArrayList<orderDetail> list = orderDetailDAO.getInstance().getAll();

        list = (ArrayList<orderDetail>) list.stream().filter((v) -> {
            return v.getProduct_id() == id_pr;
        }).collect(Collectors.toList());
        int quantity = 0;
        for (orderDetail v : list) {
            quantity += v.getQuantity();
        }
        return quantity;
    }

    public float getPrice(int id_pr) {
        float price = 0;
        product pr = new product();
        pr.setId_product(id_pr);
        pr = productDAO.getInstance().selectByid(pr);
        ArrayList<orderDetail> list = orderDetailDAO.getInstance().getAll();

        list = (ArrayList<orderDetail>) list.stream().filter((v) -> {
            return v.getProduct_id() == id_pr;
        }).collect(Collectors.toList());
        for (orderDetail v : list) {
            price += v.getQuantity() * pr.getPrice();
        }
        return price;
    }

    private void jComboBoxprodcutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxprodcutActionPerformed
        if (jComboBoxprodcut.getSelectedIndex() != 0) {
            setDataByProduct();
        } else {
            jLQuantity.setText("...");
            jLPrice.setText("...");
        }
    }//GEN-LAST:event_jComboBoxprodcutActionPerformed

    private void jButtonCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancel1ActionPerformed
        for (int i = 10; i > 1; i--) {
            float v = (float) i / 10;
            this.setOpacity(v);
            try {
                Thread.sleep(40);
            } catch (Exception e) {
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButtonCancel1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchByProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCancel1;
    private javax.swing.JCheckBox jCheckBoxPriceMax;
    private javax.swing.JCheckBox jCheckBoxQuantityMax;
    private javax.swing.JComboBox<String> jComboBoxprodcut;
    private javax.swing.JLabel jLPrice;
    private javax.swing.JLabel jLQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
