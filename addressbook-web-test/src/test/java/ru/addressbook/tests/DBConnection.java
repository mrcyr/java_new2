package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.sql.*;

public class DBConnection {

  @Test
  public void dbConnectionTest() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=" +
      "&useLegacyDatetimeCode=false"
              + "&amp"
              + "&serverTimezone=UTC");
      Statement st = conn.createStatement();
      ResultSet resultSet = st.executeQuery("select group_name from group_list");
      Groups groups = new Groups();
      while (resultSet.next()) {
        groups.add(new GroupData().withName(resultSet.getString("group_name")));
      }
      resultSet.close();
      st.close();
      conn.close();
      System.out.println(groups);

    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
