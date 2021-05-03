package Data;

import java.sql.*;

public class DB_connector {

    static Connection connection = null;


    public static void main(String[] args) {

//     opret forbindelse til databse
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/DB_Projekt",
                    "postgres",
                    "Huskmig1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    indsæt user i databsen
//    indsæt sql statements: sql ""
//    sql statement er et eksempel, ikke korrekt data. HUSK ingen variable i statement
//    Youtube DM07 23:00
//


    {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO user (name, cpr) VALUES (?,?)");
            insertStatement.setString(1, "jennerboy"); //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            //Husk set.String
            insertStatement.setString(2,"1234567890");
            insertStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // hent data fra db. Query Databse til User med bestemt CPR
        try {
            PreparedStatement querystatement = connection.prepareStatement("SELECT * FROM user WHERE cpr = ?");
            querystatement.setString(1, "1234567890");
            ResultSet queryResultset = querystatement.executeQuery();

            System.out.println("The following users matched the query");
            while (queryResultset.next()) {
                System.out.println("The users name was"
                        + queryResultset.getString("name")
                        + "and his cpr was" + queryResultset.getString("cpr"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

