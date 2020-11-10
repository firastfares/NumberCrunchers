/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package NC;

/**
 *
 * @author firasfares
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BackgroundImageJFrame extends JFrame {

    public BackgroundImageJFrame() {
        
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Desktop\\NCLOGO")));
        setLayout(new FlowLayout());
        
        // Just for refresh :) Not optional!
        setSize(399,399);
        setSize(400,400);
    }

    public static void main(String args[])
    {
        new BackgroundImageJFrame();
    }
    
    
}
