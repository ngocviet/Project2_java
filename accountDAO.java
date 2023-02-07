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
import model.account;

public class accountDAO implements DAOinterface<account> {

    public static accountDAO getInstance() {
        return new accountDAO();
    }

    public boolean checkAdmin() {
        ArrayList<account> list = this.selectAll();
        int index = 0;
        for (account v : list) {
            if (v.getPermission() == 1 && v.getStatus() == 1) {
                index++;
            }
        }
        if (index == 1) {
            return true;
        }
        return false;
    }

    public account getAccByUsername(String user) {
        account kq = null;
        ArrayList<account> list = this.selectAll();
        for (account v : list) {
            if (v.getUsername().equals(user) && v.getStatus() == 1) {
                kq = v;
            }
        }
        return kq;
    }

    @Override
    public int insert(account t) {
        int kq = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO account(username, pass, passHash, name, permission, status)VALUES(?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getPass());
            pst.setString(3, t.getPassHash());
            pst.setString(4, t.getName());
            pst.setInt(5, t.getPermission());
            pst.setInt(6, t.getStatus());

            kq = pst.executeUpdate();

            System.out.println("Ban da thuc thi " + sql);
            System.out.println("Co " + kq + " dong duoc thay doi");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public ArrayList<account> getAll() {
        ArrayList<account> kq = selectAll();

        kq = (ArrayList<account>) kq.stream().filter((v) -> {
            return v.getStatus() == 1;
        }).collect(Collectors.toList());

        return kq;
    }

    @Override
    public int update(account t) {
        int kq = 0;
        try {
            //Buoc 1: tao ket noi den CSDL
            Connection con = JDBCUtil.getConnection();

            //Buoc 2: tao doi tuong statement
            String sql = "UPDATE account SET pass = ?, passHash = ?, name = ?, permission = ?, status = ? WHERE id_account = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getPass());
            st.setString(2, t.getPassHash());
            st.setString(3, t.getName());
            st.setInt(4, t.getPermission());
            st.setInt(5, t.getStatus());
            st.setInt(6, t.getId_account());

            //Buoc 3: thuc thi cau lenh SQL
            kq = st.executeUpdate();

            //Buoc 4:
            System.out.println("Ban da thuc thi " + sql);
            System.out.println("Co " + kq + " dong duoc thay doi");

            //Buoc 5: Ngat ket noi
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(account t) {
        int kq = 0;
//        try {
//            Connection con = JDBCUtil.getConnection();
//
//            String sql = "DELETE FROM account WHERE id_account = ?";
//
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, t.getId_account());
//
//            kq = pst.executeUpdate();
//
//            System.out.println("Ban da thuc thi " + sql);
//            System.out.println("Co " + kq + " dong duoc thay doi");
//
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return kq;
    }

    @Override
    public ArrayList<account> selectAll() {
        ArrayList<account> kq = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM account";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_account = rs.getInt("id_account");
                String name = rs.getString("name");
                String username = rs.getString("username");
                String pass = rs.getString("pass");
                String passwordHash = rs.getString("passHash");
                int permission = rs.getInt("permission");
                int status = rs.getInt("status");

                account ac = new account(id_account, username, pass, passwordHash, permission, name);
                ac.setStatus(status);
                kq.add(ac);
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
    public account selectByid(account t) {
        account kq = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM account WHERE id_account = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getId_account());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_account = rs.getInt("id_account");
                String name = rs.getString("name");
                String username = rs.getString("username");
                String pass = rs.getString("pass");
                String passwordHash = rs.getString("passHash");
                int permission = rs.getInt("permission");
                int status = rs.getInt("status");

                kq = new account(id_account, username, pass, passwordHash, permission, name);
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
    public ArrayList<account> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
