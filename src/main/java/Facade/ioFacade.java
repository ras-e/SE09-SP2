package Facade;

import domain.Program.Credits;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ioFacade implements Serializable {

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
    }

    public void writeobjecttofile(Credits credits, String filename) {
        try {

            FileOutputStream fileOut = new FileOutputStream(filename, true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(credits);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file:DD");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}