package Persistence;

import domain.user.User;
import domain.user.Producer;

import java.sql.*;

public class PersistenceHandler {

//        private static PersistanceHandler instance;
        private String url = "localhost";
        private int port = 5432;
        private String databaseName = "SE03";
        private String username = "postgres";
        private String password = "aaaa2104A100";
        private Connection connection = null;
        private static PersistenceHandler instance;

        private PersistenceHandler(){
            initializePostgresqlDatabase();
        }

        public static PersistenceHandler getInstance(){
            if (instance == null) {
                instance = new PersistenceHandler();
            }
            return instance;
        }

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


       // check for specified user Object

        public User getLoginUserObj(String username, String password) {
            try {
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
                stmt.setString(1, username);
                stmt.setString(2, password);
// Useless (Already specified in DB)                stmt.setInt(3, type);

                ResultSet sqlReturnValues = stmt.executeQuery();
                if (!sqlReturnValues.next()){
                    return null;
                }
                return new User(
                        sqlReturnValues.getInt(1),
                        sqlReturnValues.getString(2),
                        sqlReturnValues.getString(3),
                        sqlReturnValues.getString(4),
                        sqlReturnValues.getString(5),
                        sqlReturnValues.getString(6),
                        sqlReturnValues.getInt(7));

            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
        }

 /*
 public User addUser(String username, String password) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? AND type ");
            stmt.setString(1, username);
            stmt.setString(2, password);
//Useless          stmt.setInt(3, type);
            ResultSet sqlReturnValues = stmt.executeQuery();
            if (!sqlReturnValues.next()){
                return null;
            }
            return new User(sqlReturnValues.getInt(1), sqlReturnValues.getString(2), sqlReturnValues.getString(3), sqlReturnValues.getString(4), sqlReturnValues.getString(5), sqlReturnValues.getString(6), sqlReturnValues.getInt(7));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    */

    //Producer

    public User addUser(User user) {

        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO users(name, username, password, email, dato) VALUES (?,?,?,?,?)");
            //insertStatement.setInt(1, user.getId()); //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            insertStatement.setString(1, user.getName());
            insertStatement.setString(2, user.getUsername());
            insertStatement.setString(3, user.getPassword());
            insertStatement.setString(4, user.getEmail());
            insertStatement.setString(5, user.getDate());
            //insertStatement.setInt(4, user.getType());
            //insertStatement.setInt(7, user.getId());

            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean addProducer(Producer producer) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT producers user (name, cpr) VALUES (?,?,?,?,?)");
            insertStatement.setInt(1, producer.getId()); //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            insertStatement.setString(2, producer.getName());
            insertStatement.setString(3, producer.getUsername());
            insertStatement.setString(4, producer.getPassword());
            insertStatement.setString(5, producer.getEmail());
           // insertStatement.setString(6, producer.getBusiness());
            insertStatement.setInt(7, producer.getId());

            insertStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }

    //credits



}







