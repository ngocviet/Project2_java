package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.order;

public class orderDAO implements DAOinterface<order> {

    public static orderDAO getInstance() {
        return new orderDAO();
    }

    public order getOrderNew() {
        order kq = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM orderr WHERE id_order = (SELECT MAX(id_order) FROM orderr) AND status = 1";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id_order = rs.getInt("id_order");
                java.sql.Date date = rs.getDate("createDate");
                Float totalPrice = rs.getFloat("TotalPrice");
                String selers = rs.getString("selers");
                
                kq = new order(id_order, date, totalPrice, selers);
            }

            System.out.println("Ban da thuc thi " + sql);
            System.out.println("Co " + kq + " dong duoc thay doi");

            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public ArrayList<order> getAll() {
        ArrayList<order> kq = selectAll();

        kq = (ArrayList<order>) kq.stream().filter((v) -> {
            return v.getStatus() == 1;
        }).collect(Collectors.toList());

        return kq;
    }

    @Override
    public int insert(order t) {
        int kq = 0;
        try {

            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO orderr(createDate, TotalPrice, selers, status) VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getCreateDate().toString());
            pst.setFloat(2, t.getTotalPrice());
            pst.setString(3, t.getSelers());
            pst.setInt(4, t.getStatus());

            kq = pst.executeUpdate();

            System.out.println("Ban da thuc thi " + sql);
            System.out.println("Co " + kq + " dong duoc thay doi");

            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int update(order t) {
        int kq = 0;
        try {

            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE orderr set createDate = ?, TotalPrice = ?, selers = ?, status = ? WHERE id_order = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, t.getCreateDate());
            pst.setFloat(2, t.getTotalPrice());
            pst.setString(3, t.getSelers());
            pst.setInt(4, t.getStatus());
            pst.setInt(5, t.getId_order());

            kq = pst.executeUpdate();

            System.out.println("Ban da thuc thi " + sql);
            System.out.println("Co " + kq + " dong duoc thay doi");

            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int delete(order t) {
        int kq = 0;
//        try {
//
//            Connection con = JDBCUtil.getConnection();
//            String sql = "DELETE FROM orderr WHERE id_order = ?";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, t.getId_order());
//
//            kq = pst.executeUpdate();
//
//            System.out.println("Ban da thuc thi " + sql);
//            System.out.println("Co " + kq + " dong duoc thay doi");
//
//            JDBCUtil.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return kq;
    }

    @Override
    public ArrayList<order> selectAll() {
        ArrayList<order> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            
            String sql = "SELECT * FROM orderr";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id_order");
                Float price = rs.getFloat("TotalPrice");
                String selers = rs.getString("selers");
                Date date = rs.getDate("createDate");
                int status = rs.getInt("status");
                
                order o = new order(id, date, price, selers);
                o.setStatus(status);
                list.add(o);
            }
            
            System.out.println("Ban da thuc hien "+sql);
            
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public order selectByid(order t) {
        order kq = new order();
        try {
            Connection con = JDBCUtil.getConnection();
            
            String sql = "SELECT * FROM orderr WHERE id_order = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getId_order());
            
            ResultSet rs =  pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id_order");
                Float price = rs.getFloat("TotalPrice");
                String selers = rs.getString("selers");
                Date date = rs.getDate("createDate");
                int status = rs.getInt("status");
                
                kq = new order(id, date, price, selers);
                kq.setStatus(status);
            }
            
            System.out.println("Ban da thuc hien "+sql);
            
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public ArrayList<order> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
