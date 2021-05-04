package Persistence;

import domain.user.Producer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceHandler {

    public class PersistanceHandler {
//        private static PersistanceHandler instance;
        private String url = "localhost";
        private int port = 5432;
        private String databaseName = "DB_Projekt";
        private String username = "postgres";
        private String password = "Huskmig1";
        private Connection connection = null;

//        private PersistanceHandler(){
//            initializePostgresqlDatabase();
//        }

//        public static PersistanceHandler getInstance(){
//            if (instance == null) {
//                instance = new PersistanceHandler();
//            }
//            return instance;
//        }

        private void initializePostgresqlDatabase() {
            try {
                DriverManager.registerDriver(new org.postgresql.Driver());
                connection = DriverManager.getConnection("jdbc:postgresql://" + url + ":" + port + "/" + databaseName, username, password);
            } catch (SQLException | IllegalArgumentException ex) {
                ex.printStackTrace(System.err);
            } finally {
                if (connection == null) System.exit(-1);
            }
        }

//        @Override
//        public List<Producer> getproducers() {
//            try {
//                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees");
//                ResultSet sqlReturnValues = stmt.executeQuery();
//                int rowcount = 0;
//                List<Producer> returnValue = new ArrayList<>();
//                while (sqlReturnValues.next()){
//                    returnValue.add(new Producer(sqlReturnValues.getInt(1), sqlReturnValues.getString(2), sqlReturnValues.getInt(3), sqlReturnValues.getInt(4), sqlReturnValues.getInt(5), sqlReturnValues.getInt(6)));
//                }
//                return returnValue;
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//                return null;
//            }
//        }


        public Producer getProducer(int id) {
            try {
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Producers WHERE id = ?");
                stmt.setInt(1, id);
                ResultSet sqlReturnValues = stmt.executeQuery();
                if (!sqlReturnValues.next()){
                    return null;
                }
                return new Producer(sqlReturnValues.getInt(1), sqlReturnValues.getString(2), sqlReturnValues.getInt(3), sqlReturnValues.getInt(4), sqlReturnValues.getInt(5), sqlReturnValues.getInt(6));
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
        }

//        @Override
//        public boolean createProducer(Producer producer) {
//
//            try {
//                PreparedStatement insertStatement = connection.prepareStatement(
//                        "INSERT INTO producer (name, cpr) VALUES (?,?)");
//                insertStatement.setString(1, "jennerboy"); //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
//                //Husk set.String
//                insertStatement.setString(2,"1234567890");
//                insertStatement.execute();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }

    public void addEmployee(String Fname, String Lname, int id, String business, String email) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO user (name, cpr) VALUES (?,?,?,?,?)");
            insertStatement.setString(1, Fname); //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            insertStatement.setString(2, Lname);
            insertStatement.setInt(3, id);
            insertStatement.setString(4,business);
            insertStatement.setString(5,email);
            insertStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    }




}
