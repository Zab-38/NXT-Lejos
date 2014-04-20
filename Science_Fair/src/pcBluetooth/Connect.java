/*Copyright (c) 2011 Aravind Rao

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, 
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS 
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT 
 * OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class Connect {

	JButton shutdown;// a lot of objects are created
	JButton options;
	JButton disconnect;
	JButton reconnect;
	JFrame frame;
	JTextArea console;
        JTextArea keyArea;
	JPanel buttonPanel;
	JPanel textPanel;
	JScrollPane pScroll;
        DataOutputStream dos;
	DataInputStream dis;

	public static void main(String[] args) {

	    send send = new send();
	    send.buildGUI();//GUI Building 
	    send.connect();//Start connection

	}

	public void buildGUI() //Simple GUI building
	{

	frame = new JFrame("Controller: By Aravind"); //new JFrame
	frame.setSize(624,350);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);

	buttonPanel = new JPanel(new GridLayout(2,2)); //Some JPanels
	textPanel = new JPanel(new GridLayout(1,2));


	shutdown = new JButton("Shutdown"); //Four new buttons
        shutdown.addActionListener(new shutdownListener());
	options = new JButton("Options");
	disconnect = new JButton("Disconnect");
        disconnect.addActionListener(new disconnectListener());
	reconnect = new JButton("Reconnect");
        reconnect.addActionListener(new reconnectListener());

	buttonPanel.add(reconnect);
	buttonPanel.add(disconnect);
	buttonPanel.add(shutdown);
	buttonPanel.add(options);

	console = new JTextArea();
        keyArea = new JTextArea();
        keyArea.setPreferredSize(new Dimension(100, 100));
        keyArea.addKeyListener(new keyListener());//add key listener to listen to key events such as press, etc

	pScroll = new JScrollPane(console, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	pScroll.setPreferredSize(new Dimension(500, 250));

	textPanel.add(pScroll);
        textPanel.add(keyArea);

	frame.getContentPane().add(textPanel, BorderLayout.NORTH);
	frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

	public void connect()
	{

		NXTConnector conn = new NXTConnector();//create a new NXT connector
		boolean connected = conn.connectTo("btspp://"); //try to connect to any NXT over bluetooth


		if (!connected) {//failure
			console.append("Failed to connect to any NXT\n");
			console.append("Press Reconect to retry.\n");
		}

		else//success!
		{
		console.append("Connected to " + conn.getNXTInfo() + "\n");
		dos = conn.getDataOut(); //create data input and output streams to send and recieve data.
		dis = conn.getDataIn();
		}

	}

        public void shutdownAction() //shutdown method of shutdown button
        {
            try{dos.writeInt(-1);dos.flush();console.append("NXT shut down. Connection lost.\n");}//NXT recognizes input of -1 as signal to shutdown
            catch(Exception e){console.append("Could not send command\n");}//catch exception, try to save face:)
        }

         public void disconnectAction()
        {
            try{dos.writeInt(0);dos.flush();console.append("NXT disconnected. Press Reconnect to reconnect.\n");}//NXT recognizes 0 as command to terminate bluetooth connection and seek a new one.
            catch(Exception e){console.append("Could not send command\n");}
        }

         class shutdownListener implements ActionListener // listeners for three buttons, options button does not do anything yet
         {
             public void actionPerformed(ActionEvent evt)
             {
                 shutdownAction();
             }
         }

          class disconnectListener implements ActionListener
         {
             public void actionPerformed(ActionEvent evt)
             {
                 disconnectAction();
             }
         }

           class reconnectListener implements ActionListener
         {
             public void actionPerformed(ActionEvent evt)
             {
                 connect();// call main connect method to try to connect again
             }
         }

            class keyListener implements KeyListener// three of the methods that have to be implemented in keylistener, we only need keyPressed and keyReleased
         {

    public void keyTyped(KeyEvent e)
    {

    }


    public void keyPressed(KeyEvent e)
    {
        try{
        if(e.getKeyCode() == 37)//right arrow keycode, tell NXT to turn right
        {console.append("Right command sent.\n");
        dos.writeInt(e.getKeyCode());
        dos.flush();}
        else if(e.getKeyCode() == 38)//up arrow keycode, tell NXT to go forward
        {console.append("Forward command sent.\n");
         dos.writeInt(e.getKeyCode());
        dos.flush();}
        else if(e.getKeyCode() == 39)//left arrow keycode, tell NXT to turn left
        {console.append("Left command sent.\n");
         dos.writeInt(e.getKeyCode());
        dos.flush();}
        else if(e.getKeyCode() == 40)//down arrow keycode, tell NXT to go backwards
        {console.append("Backwards command sent.\n");
         dos.writeInt(e.getKeyCode());
        dos.flush();}
        else{console.append("Unrecognized command.\n");}//some other key pressed, not any of the four arrow keys, warn that the command is unrecognized
        }

        catch(Exception E){console.append("Could not send command\n");}//catch exception, save face
        }



    public void keyReleased(KeyEvent e)
    {try{
 dos.writeInt(-2);//NXT recognises -2 as command to stop whatever it is doing whether it is turning left, right or going forwards or backwards.
        dos.flush();}
    catch(Exception E){}
    }
         }

}
