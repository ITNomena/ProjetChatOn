package dossier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dossier.Frameclient;

public class ListenerReq implements ActionListener{

    Frameclient frameclient;

    
    public ListenerReq(Frameclient frameclient) {
        setFrameclient(frameclient);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getFrameclient().sendmessage();
    }

    public Frameclient getFrameclient() {
        return frameclient;
    }

    public void setFrameclient(Frameclient frameclient) {
        this.frameclient = frameclient;
    }
    
}
