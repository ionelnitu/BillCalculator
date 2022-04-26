package main;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.*;

public class MySql {
    //UserName and Password to connect on database;
    static String user = "root";
    static String pass = "Parola123!";
    //Link to database
    static String link = "jdbc:mysql://localhost/billcalculator";
    static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(link, user, pass);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
        }
    }

    //insert into database the user
    public boolean insert(String name, String pass,String email) throws SQLException {
        PreparedStatement st = conn.prepareStatement("insert into bill (user_name,password,email) values(?,?,?)");
        st.setString(1, name);
        st.setString(2, pass);
        st.setString(3,email);
        return st.execute();
    }

    public boolean insertGas(String pcs,String price,Double oldIndex,Double newIndex) throws SQLException {
        PreparedStatement st=conn.prepareStatement("insert into gasbill (pcs,price,new_index,old_index) values(?,?,?,?)");
        st.setString(1,pcs);
        st.setString(2,price);
        st.setDouble(3,newIndex);
        st.setDouble(4,oldIndex);
        return st.execute();
    }

    public boolean insertElectricity(Double price,Double oldIndex,Double newIndex) throws SQLException {
        PreparedStatement st=conn.prepareStatement("insert into electricitybill (price,old_index,new_index) values(?,?,?)");
        st.setDouble(1,price);
        st.setDouble(2,oldIndex);
        st.setDouble(3,newIndex);
        return st.execute();
    }




    public Double select(String name, String pass) throws SQLException {
        Statement st = conn.createStatement();
        st.executeQuery("select electricity_old,electricity_new from bill where user_name=\'" + name + "\' and password=\'" + pass + "\'");
        ResultSet rs = st.getResultSet();
        Double oldNumber = null;
        Double newNumber = null;
        while (rs.next()) {
            oldNumber = rs.getDouble(1);
            newNumber = rs.getDouble(2);
        }
        Double result = newNumber - oldNumber;
        return result;
    }

    public boolean update(String name, String pass, Double modify) throws SQLException {
        return false;
    }


    public boolean verify(String email,String pass) throws SQLException {
        Statement st= conn.createStatement();
        st.executeQuery("select * from bill where email=\'"+email+"\' and password=\'"+pass+"\'");
        ResultSet rs=st.getResultSet();
        if(rs.next()){
            return true;
        }
        return false;
    }
}


