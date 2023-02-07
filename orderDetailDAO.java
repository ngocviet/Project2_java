package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.orderDetail;

public class orderDetailDAO implements DAOinterface<orderDetail> {

    public static orderDetailDAO getInstance() {
        return new orderDetailDAO();
    }

    public ArrayList<orderDetail> getListProductOneOrder(int id_order) {
        ArrayList<orderDetail> kq = getAll();

        kq = (ArrayList<orderDetail>) kq.stream().filter((v) -> {
            return v.getOrder_id()==id_order;
        }).collect(Collectors.toList());

        return kq;
    }

    public void deleteByOrder_id(int id) {
        ArrayList<orderDetail> list = selectAll();
        for (orderDetail v : list) {
            if (v.getOrder_id() == id) {
                v.setStatus(0);
                update(v);
            }
        }
    }

    public ArrayList<orderDetail> getAll() {
        ArrayList<orderDetail> kq = selectAll();

        kq = (ArrayList<orderDetail>) kq.stream().filter((v) -> {
            return v.getStatus() == 1;
        }).collect(Collectors.toList());

        return kq;
    }

    @Override
    public int insert(orderDetail t) {
        int kq = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO orderdetail(order_id, produc_id, quantity, status)"
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getOrder_id());
            st.setInt(2, t.getProduct_id());
            st.setInt(3, t.getQuantity());
            st.setInt(4, t.getStatus());

            kq = st.executeUpdate();

            System.out.println("Ban da thuc hien: " + sql);
            System.out.println("Co " + kq + " thay doi!");

            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(orderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(orderDetail t) {
        int kq = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE orderdetail SET quantity = ?, status = ? WHERE id_orderdetail = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getQuantity());
            pst.setInt(2, t.getStatus());
            pst.setInt(3, t.getId_orderDetail());
            kq = pst.executeUpdate();

            System.out.println("Ban da thuc hien " + sql + "\nCo " + kq + " dong thay doi!");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(orderDetail t) {
        int kq = 0;
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "DELETE FROM orderdetail WHERE id_orderdetail = ?";
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setInt(1, t.getId_orderDetail());
//            kq = st.executeUpdate();
//
//            System.out.println("Ban da thuc hien: " + sql);
//            System.out.println("Co " + kq + " thay doi!");
//
//            JDBCUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(orderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return kq;
    }

    @Override
    public ArrayList<orderDetail> selectAll() {
        ArrayList<orderDetail> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM orderdetail";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id_orderdetail = rs.getInt("id_orderdetail");
                int order_id = rs.getInt("order_id");
                int product_id = rs.getInt("produc_id");
                int quantity = rs.getInt("quantity");
                int status = rs.getInt("status");

                orderDetail o = new orderDetail(id_orderdetail, order_id, product_id, quantity);
                o.setStatus(status);

                list.add(o);
            }

            System.out.println("Ban da thuc hien " + sql);

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public orderDetail selectByid(orderDetail t) {
        orderDetail kq = new orderDetail();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM orderdetail WHERE id_orderdetail = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getId_orderDetail());

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id_orderdetail = rs.getInt("id_orderdetail");
                int order_id = rs.getInt("order_id");
                int product_id = rs.getInt("produc_id");
                int quantity = rs.getInt("quantity");
                int status = rs.getInt("status");

                kq = new orderDetail(id_orderdetail, order_id, product_id, quantity);
                kq.setStatus(status);

            }

            System.out.println("Ban da thuc hien " + sql);

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public ArrayList<orderDetail> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
