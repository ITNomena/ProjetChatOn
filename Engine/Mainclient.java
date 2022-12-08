package dossier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import dossier.*;

public class Mainclient {

    public static void main(String[] args) {

        try{

             Scanner scanner = new Scanner(System.in);
             String userInput ="";
             String host="";
      
                 System.out.println("Veuillez saisir votre nom : ");
                    userInput = scanner.nextLine();
                    System.out.println("host :");
                    host = scanner.nextLine();
                    Frameclient frame = new Frameclient(userInput,host);
                    
                      
        } catch (Exception e) {
            System.out.println("Exception occured in client main: " + e.getStackTrace());
    }

    
    }
}