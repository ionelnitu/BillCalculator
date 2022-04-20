package main;

import javafx.scene.control.Alert;

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


    public boolean verify(String name,String pass) throws SQLException {
        Statement st= conn.createStatement();
        st.executeQuery("select * from bill where user_name=\'"+name+"\' and password=\'"+pass+"\'");
        ResultSet rs=st.getResultSet();
        if(rs.next()){
            return true;
        }
        return false;
    }
}


