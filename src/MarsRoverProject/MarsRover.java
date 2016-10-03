package MarsRoverProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
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
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String instructions = br.readLine();
                System.out.println("Message received from Houston is " + instructions);
                
                //Moving the rover
                String returnMessage;
                Control ctr = new Control();
                ctr.instructions(r, instructions);
                returnMessage = ctr.roversPosition(r);
 
                //Sending the response back to the client.
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Message sent to Houston is "+ returnMessage);
                bw.flush();
                isr.close();
                socket.close();
                
            }
        
       
                
    }
}
    

