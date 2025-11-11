package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket("localhost", 3000);

         BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
       
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
       
        Scanner keyboard = new Scanner(System.in);

        //MESSAGGIO WELCOME
        String messaggioBenvenuto = in.readLine();
        System.out.println(messaggioBenvenuto); 

        System.out.println("Esegui il login");


        //LOGIN CON CONTROLLO
        String username;

        while(true){
                username = keyboard.nextLine();
                out.println(username);

            String risultatoLogin = in.readLine();

            if(risultatoLogin.equals("OK")){
                System.out.println("Login effettuato correttamente.");
                break;

            } else{
                System.out.println("Login non corretto o sintassi errata.");
            }
        }

        System.out.println("Digita 1 per: disponibilità biglietti");
        System.out.println("Digita 2 per: comprare biglietti");
        System.out.println("Digita 3 per: disconnetterti");
        

        while(true){

            String richiestaDisponibilita = keyboard.nextLine();

            if(richiestaDisponibilita.equals("1")){
                out.println("N");

                String risposta = in.readLine();
                System.out.println(risposta);

            } else if(richiestaDisponibilita.equals("2")){
                out.println("BUY");

            } else if(richiestaDisponibilita.equals("3")){
                out.println("QUIT");

                String risposta = in.readLine();
                System.out.println(risposta);
                break;

            }

             else{
                System.out.println("Inserisci un valore valido");
            }
            
        }
        s.close();
    keyboard.close();
       

    }
}