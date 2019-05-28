package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Autoclick Interfaz"); //Titulo de la aplicacion

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Asi se puede escribir");
        JButton button = new JButton();
        JButton button2 = new JButton();
        button.setText("Empezar");
        button2.setText("Test click");

        panel.add(label); //Añadimos el label al panel.
        panel.add(button); //Añadimos el boton al panel.
        panel.add(button2);


        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while(true){
            button2.doClick();
        }
    }
}
