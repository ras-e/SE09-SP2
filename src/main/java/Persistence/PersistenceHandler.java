package Persistence;

import domain.Program.Credits;
import domain.Program.Program;
import domain.Program.mvPerson;
import domain.user.Producer;
import domain.user.User;

import java.sql.*;
import java.util.ArrayList;

public class PersistenceHandler {

//        private static PersistanceHandler instance;
        private String url = "localhost";
        private int port = 5432;
        private String databaseName = "postgres";
        private String username = "postgres";
        private String password = "Pletmus123";
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
                        //sqlReturnValues.getInt(1),
                        sqlReturnValues.getString(2),
                        sqlReturnValues.getString(3),
                        sqlReturnValues.getString(4),
                        sqlReturnValues.getString(5));
                       // sqlReturnValues.getString(6);
                        //sqlReturnValues.getInt(7));

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

    public boolean addProducer(Producer producer) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO producers (ddd) VALUES (?,?,?,?,?)");
            //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            insertStatement.setString(2, producer.getName());
            insertStatement.setString(3, producer.getUsername());
            insertStatement.setString(4, producer.getPassword());
            insertStatement.setString(5, producer.getEmail());
            // insertStatement.setString(6, producer.getBusiness());


            return insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public User addUser(User user) {
        int account_type = 1;

        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO users(name, username, password, email, account_type ) VALUES (?,?,?,?,?)");
            //insertStatement.setInt(1, user.getId()); //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            insertStatement.setString(1, user.getName());
            insertStatement.setString(2, user.getUsername());
            insertStatement.setString(3, user.getPassword());
            insertStatement.setString(4, user.getEmail());
            //.setDate(5, new Date(620611200000L));
            insertStatement.setInt(5, account_type);
            //insertStatement.setInt(7, user.getId());
            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User deleteUser(User user) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE (username, password) VALUES (?,?)");
            insertStatement.setString(2, user.getUsername());
            insertStatement.setString(3, user.getPassword());
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public String addbusiness(String business) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO business (business) VALUES (?)");
            //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            insertStatement.setString(1, business);

            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return business;
    }

    // program&kategori

    public String addprogram (String name) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO programz(name, dato) VALUES (?,?)");
            //insertStatement.setInt(1, user.getId()); //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            insertStatement.setString(1, name);
            insertStatement.setDate(2, new Date(620611200000L));
            //insertStatement.setInt(7, user.getId());
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
return name;
    }
    public String addprogramkategori (String kategori) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO program_kategori(kategori) VALUES (?)");
            //insertStatement.setInt(1, user.getId()); //"INSERT INTO users (name, cpr) VALUES ("jennerboy", ?)" indsætter stringen under 1 spørgsmålstegn
            insertStatement.setString(1, kategori);
            //insertStatement.setInt(7, user.getId());
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kategori;
    }

    public Program searchprogram(Program program) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Programz WHERE name = ?");
            stmt.setString(1, program.getName());

// Useless (Already specified in DB)                stmt.setInt(3, type);

            ResultSet sqlReturnValues = stmt.executeQuery();
            if (!sqlReturnValues.next()){
                return null;
            }
            return new Program(
                    sqlReturnValues.getString(1));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


//    public ArrayList<Credits> getCreditsbyname(String programname) {
//        try {
//            PreparedStatement selectstatement = connection.prepareStatement(
//                    "SELECT * FROM medvirkende\n" +
//                            "INNER JOIN kredittering ON medvirkende.id = medvirkendeid\n" +
//                            "INNER JOIN programz ON programzid = programz.id\n" +
//                            "Where programz.name = ?;");
//            selectstatement.setString(1, programname);
//            ResultSet sqlReturnValues = selectstatement.executeQuery();
//            ArrayList<Credits> credarry = new ArrayList<>();
//            while (sqlReturnValues.next()) {
//                credarry.add(new Credits(sqlReturnValues.getString(1),
//                        (mvPerson) sqlReturnValues.getObject(String.valueOf(new mvPerson(sqlReturnValues.getString(2))))));
//            }
//            return credarry;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }


    //credits

}








