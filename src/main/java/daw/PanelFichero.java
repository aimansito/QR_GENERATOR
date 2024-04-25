/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aiman
 */
public class PanelFichero extends JPanel{
    private ArrayList<String> paisesArrayList;
    private JComboBox<String> comboArray, comboArrayList;
    private JFrame frame;
    private JPanel panel;

    public PanelFichero() {
        frame = new JFrame();
        panel = new JPanel();
        frame.add(panel);

        frame.setTitle("JComboBox");

        /* Directamente con un Array */
        String[] opciones = new String[] { "png", "jpg"};
        comboArray = new JComboBox<String>(opciones);
        panel.add(comboArray);
        /* Probamos el seleccionador por la consola */
        comboArray.addActionListener(event -> System.out.println(comboArray.getSelectedItem()));

        /* Directamente desde un ArrayList<String>, pasamos el ArrayList a un array */
        paisesArrayList = new ArrayList<>();
        paisesArrayList.add("png");
        paisesArrayList.add("jpg");
        /*
         * Una vez creado y cargado el AL, utilizamos toArray() para pasarlo a array
         * comun y le decimos que el array tiene que tener el tamño exacto que cantidad
         * de objetos que tiene el AL
         */
        comboArrayList = new JComboBox<String>(paisesArrayList.toArray(new String[paisesArrayList.size()]));
        panel.add(comboArrayList);
        /* Probamos el seleccionador por la consola */
        comboArrayList.addActionListener(event -> System.out.println(comboArrayList.getSelectedItem()));

        frame.setBounds(100, 100, 300, 250);
        frame.setVisible(true);

    }
}
