package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
       
        ServerSocket server = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000...");

        Disponibilita disponibilita = new Disponibilita();
        disponibilita.init();
        
          

         

        while (true){ 
            
            Socket clientSocket = server.accept();
            System.out.println("Client " + clientSocket.getInetAddress() + " connesso alla rete");


            GestoreClient threadClient = new GestoreClient(clientSocket, disponibilita);
            threadClient.start(); // avvio il thread
            
        }


    
    }
}



class GestoreClient extends Thread{

    private Socket clientSocket;
    private Disponibilita disponibilita;

    
    
    

    // Costruttore che riceve il socket del client
    public GestoreClient(Socket socket, Disponibilita disponibilita) {
        this.clientSocket = socket;
        this.disponibilita = disponibilita;
        
    }

    @Override
    public void run() {

        List<String> utentiCollegati = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("WELCOME");//MESSAGGIO WELCOME AL CLIENT




            //LOGIN CON CONTROLLO
            while(true){

                String nomeUtente = in.readLine();

            for(int i = 0; i < utentiCollegati.size(); i++){
                if(nomeUtente.equals(utentiCollegati.get(i))){
                    out.println("ERR USERINUSE");
                    break;
                }
            }    
                utentiCollegati.add(nomeUtente);
                out.println("OK");
                break;
        }

            
            

            while (true) {

                String richiestaDisponibilita = in.readLine();

                if(richiestaDisponibilita.equals("N")){

                    out.println("AVAIL " + "Gold: " + disponibilita.getGold() + "  Pit: " + disponibilita.getPit() + "  Parterre: " + disponibilita.getParterre());

                } else if(richiestaDisponibilita.equals("BUY")){
                    
                } else{
                    out.println("KO");
                    break;
                }
                
            }


            
            

        
        

        } catch (IOException e) {            
            e.printStackTrace();
        }

        System.out.println("Client " + clientSocket.getInetAddress() + " disconnesso dalla rete");

    }
}


