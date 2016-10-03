package Remote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import MarsRoverProject.Control;
import MarsRoverProject.Rover;
 
public class MarsRover
{
 
    private static Socket socket;
 
    public static void main(String[] args) throws IOException
    {
    
       
 
            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");
            Rover r = new Rover(0,0,0);
            
            
            while(true)
            {
                //Reading the message from client
            	socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String instructions = bufferedReader.readLine();
                System.out.println("Message received from Houston is " + instructions);
                
                //Moving the rover
                String returnMessage;
                Control ctr = new Control();
                ctr.instructions(r, instructions);
                returnMessage = ctr.roversPosition(r);
 
                //Sending the response back to the client.
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bufferedWriter = new BufferedWriter(osw);
                bufferedWriter.write(returnMessage);
                System.out.println("Message sent to Houston is "+ returnMessage);
                bufferedWriter.flush();
                inputStreamReader.close();
                socket.close();
                
            }
        
       
                
    }
}
    

