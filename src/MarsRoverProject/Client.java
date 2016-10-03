package MarsRoverProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
 
public class Client
{
 
    private static Socket socket;
 
    public static void main(String args[]) throws IOException
    {
        
            
            
            while(true){
            	String host = "localhost";
                int port = 25000;
                InetAddress address = InetAddress.getByName(host);
                socket = new Socket(address, port);
     
                //Send the message to the server/rover
                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                Scanner scanner = new Scanner(System.in);
                String command = "";
            	
	            System.out.println("Write command to rover");
	            command = scanner.next();
	 
	            String sendMessage = command + "\n";
	            bufferedWriter.write(sendMessage);
	            bufferedWriter.flush();
	            System.out.println("Message sent to the server : "+ sendMessage);
	            
	 
	            //Get the return message from the server/Rover
	            InputStream inputStream = socket.getInputStream();
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	            String message = bufferedReader.readLine();
	            System.out.println("Message received from the server : " + message);		            
	            	            	                  
            
            }            
    }
}
           
            
        
    
