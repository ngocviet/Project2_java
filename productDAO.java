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
import model.product;

public class productDAO implements DAOinterface<product> {

    public static productDAO getInstance() {
        return new productDAO();
    }

    public product getProductByName(String name) {
        product kq = null;
        ArrayList<product> list = this.selectAll();
        for (product v : list) {
            if (v.getName().equals(name) && v.getStatus() == 1) {
                kq = v;
            }
        }
        return kq;
    }

    public product getProductByPosition(int v) {
        product kq = null;
        ArrayList<product> list = this.selectAll();
        for (product vi : list) {
            if (vi.getPosition() == v && vi.getStatus() == 1) {
                kq = vi;
            }
        }
        return kq;
    }

    public product getPrHasPositionMax() {
        product kq = new product();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM product WHERE position = (SELECT MAX(position) FROM product WHERE status =1)";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_product = rs.getInt("id_product");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String img = rs.getString("img");
                int position = rs.getInt("position");

                kq = new product(id_product, name, price, img, position);
            }

            System.out.println("Ban da thuc hien: " + sql);
            System.out.println("Co " + kq + " thay doi!");

            JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public ArrayList<product> getAll() {
        ArrayList<product> kq = selectAll();

        kq = (ArrayList<product>) kq.stream().filter((v) -> {
            return v.getStatus() == 1;
        }).collect(Collectors.toList());

        return kq;
    }

    public ArrayList<product> selectProductDisplay(int soTrang) {

        int indexE = 8 * soTrang;
        int indexS = (soTrang - 1) * 8 + 1;
        ArrayList<product> list = this.getAll();
        list = (ArrayList<product>) list.stream().filter((v) -> {
            return v.getPosition() != 0 && v.getPosition() <= indexE && v.getPosition() >= (soTrang == 1 ? 1 : indexS);
        }).collect(Collectors.toList());
//        list = (ArrayList<product>) list.stream().filter((v) -> {
//            return v.getPosition() <= 16 && v.getPosition() >= 9;
//        }).collect(Collectors.toList());

        list = (ArrayList<product>) list.stream().sorted((o1, o2) -> {
            int kq = (int) (o1.getPosition() - o2.getPosition());
            return kq;
        }).collect(Collectors.toList());

        return list;
    }

    @Override
    public int insert(product t) {
        int kq = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO product (name, price, img, position, status) VALUES(?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getName());
            pst.setFloat(2, t.getPrice());
            pst.setString(3, t.getImg());
            pst.setInt(4, t.getPosition());
            pst.setInt(5, t.getStatus());

            kq = pst.executeUpdate();

            System.out.println("Ban da thuc hien " + sql + "\nCo " + kq + " thay doi");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int update(product t) {
        int kq = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE product SET name = ?, price = ?, img = ?, position = ?, status = ? WHERE id_product = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getName());
            pst.setFloat(2, t.getPrice());
            pst.setString(3, t.getImg());
            pst.setInt(4, t.getPosition());
            pst.setInt(5, t.getStatus());
            pst.setInt(6, t.getId_product());

            kq = pst.executeUpdate();

            System.out.println("Ban da thuc hien " + sql + "\nCo " + kq + " thay doi");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(product t) {
        int kq = 0;
//        try {
//            Connection con = JDBCUtil.getConnection();
//
//            String sql = "DELETE FROM product WHERE id_product = ?";
//
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, t.getId_product());
//
//            kq = pst.executeUpdate();
//
//            System.out.println("Ban da thuc hien " + sql + "\nCo " + kq + " thay doi");
//
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return kq;
    }

    @Override
    public ArrayList<product> selectAll() {
        ArrayList<product> kq = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM product";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_product = rs.getInt("id_product");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String img = rs.getString("img");
                int position = rs.getInt("position");
                int status = rs.getInt("status");

                product pr = new product(id_product, name, price, img, position);
                pr.setStatus(status);
                kq.add(pr);
            }

            System.out.println("Ban da thuc hien: " + sql);
            System.out.println("Co " + kq + " thay doi!");

            JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public product selectByid(product t) {
        product kq = new product();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM product WHERE id_product = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getId_product());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_product = rs.getInt("id_product");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String img = rs.getString("img");
                int position = rs.getInt("position");
                int status = rs.getInt("status");

                kq = new product(id_product, name, price, img, position);
                kq.setStatus(status);
            }

            System.out.println("Ban da thuc hien: " + sql);
            System.out.println("Co " + kq + " thay doi!");

            JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public ArrayList<product> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
