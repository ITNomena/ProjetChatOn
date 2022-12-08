package dossier;

import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frameclient extends JFrame{
    
    String name;
    Socket socket;
    int lastheigth;
    PrintWriter output;
    JTextField text;
    JButton envoyer;

    public Frameclient(String name, String host)throws Exception{

        setSocket(new Socket(host,5000));
        setName(name);
        setTitle(getName());
        setOutput(new PrintWriter(socket.getOutputStream(),true));

        ClientReq clientR = new ClientReq(this);
        new Thread(clientR).start();
       
        setSize(800, 800);
        setResizable(false);
        setLayout(null);
        setLastheigth(25);


        setText(new JTextField());
        getText().setBounds(50, 700, 500, 40);
        this.add(getText());

        setEnvoyer(new JButton("Envoyer"));
        getEnvoyer().setBounds(600, 700, 100, 40);
        getEnvoyer().addActionListener(new ListenerReq(this));
        this.add(getEnvoyer());

        setVisible(true);
        getOutput().println(getName()+" vous a rejoint .");
    }

    public int getLastheigth() {
        return lastheigth;
    }

    public void setLastheigth(int lastheigth) {
        this.lastheigth = lastheigth;
    }

    public JTextField getText() {
        return text;
    }

    public void setText(JTextField text) {
        this.text = text;
    }

    public JButton getEnvoyer() {
        return envoyer;
    }

    public void setEnvoyer(JButton envoyer) {
        this.envoyer = envoyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }    

    
    public PrintWriter getOutput() {
        return output;
    }

    public void setOutput(PrintWriter output) {
        this.output = output;
    }
    
    public void sendmessage(){
        String message = ( "(" +getName()+ ")" + " : " );
        message = message + this.getText().getText();
        getOutput().println(message);
        getEnvoyer().setText("");
    }

}
