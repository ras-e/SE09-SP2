package Facade;

import domain.Program.Credits;
import domain.user.User;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ioFacade implements Serializable {

    // metoderne skal bruges i javafx-controller klasser

    public List ReadObjects(String filename) {
        List<ioFacade> l = null;
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            try {
                while (true) {
                    l = (List<ioFacade>) ois.readObject();
                    System.out.println("List read: \n" + l);
                }
            } catch (EOFException eof) {
                System.out.println("No more to read!");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ioFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ioFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ioFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }


//    skrivning af objekter til binærfil
//    public void writeCredittofile(Credits credits, String filename) {
//        try {
//
//            FileOutputStream fileOut = new FileOutputStream(filename, true);
//            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
//            objectOut.writeObject(credits);
//            objectOut.close();
//            System.out.println("The Object  was succesfully written to a file:DD");
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    public void writeusertofile(User user, String filename) {
        try {

            FileOutputStream fileOut = new FileOutputStream(filename, true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(user);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file:DD");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void writetotextfile(String credit, String filename) {

//         input fra keyboard
        Scanner in = new Scanner(System.in);
//        kan give input med mellemrum
        filename = in.nextLine().trim();

        FileWriter WriteStream = null;
        try {
            WriteStream = new FileWriter(filename, true);
        }
        catch (IOException e)
        { System.out.println("fejl med at åbne filen" + filename); }
        System.exit(0);

        Scanner incredit = new Scanner(System.in);
//        kan give input med mellemrum
        credit = in.nextLine();
//    indtast tre linjer kode, alt efter hvor meget en kreditering
        try {
            WriteStream.write(credit);
//            WriteStream.flush();
        }
        catch (IOException e) {
            System.out.println("fejl med at åbne filen");
        }
        System.exit(0);


}

    public String readFile(File inFile) {
        // File I/O med lukning af filen
        // stringbuilder = sekvens af karaktere
        StringBuilder sb = new StringBuilder();
        Scanner sc = null;
        try {
            sc = new Scanner(inFile);
            while (sc.hasNext()) {
                sb.append(sc.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            sc.close();
        }
        return sb.toString();
    }



    }
