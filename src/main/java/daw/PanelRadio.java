/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author aiman
 */
public class PanelRadio extends JPanel {
    // Tamaño del panel. Constantes
    public static final int ANCHO_PANEL = 600;
    public static final int ALTO_PANEL = 200;

    // Atributos del panel
    private JButton btnGenerar, btnCerrar;
    private JLabel lblUrl, lblFichero;
    private JTextField tfUrl, tfFichero;
    private String nombreFichero;
    private PanelFichero panel; 

    // Constructor 
    public PanelRadio() {
        // Establece el layout del panel
        this.setLayout(new FlowLayout());
        // Establece el color del fondo del panel
        this.setBackground(Color.gray);
        // Establece el tamaño del panel
        this.setSize(ANCHO_PANEL, ALTO_PANEL);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Añade URL Label
        lblUrl = new JLabel("Introduce el texto: ");
        this.add(lblUrl);

        // Añade área de texto para la URL
        // Ancho de unos 40 caracteres aprox
        tfUrl = new JTextField(40);
        this.add(tfUrl);

        // Añade Fichero Label
        lblFichero = new JLabel("Nombre del fichero: ");
        this.add(lblFichero);

        // Añade área de texto para el nombre del fichero
        tfFichero = new JTextField(40);
        this.add(tfFichero);

        
        JRadioButton jpgButton = new JRadioButton("JPG");
        JRadioButton pngButton = new JRadioButton("PNG");

        // Agrupa los botones de radio para que solo se pueda seleccionar uno a la vez
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jpgButton);
        buttonGroup.add(pngButton);

        // Añade los botones de radio al panel
        panel.add(jpgButton);
        panel.add(pngButton);

        // Añade el panel a la ventana
        
        // Comportamiento del botón generar
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Si el contenido de los textField no está vacío
                if (!tfUrl.getText().isEmpty()&&!tfFichero.getText().isEmpty()){
                    // Genera el fichero con la imagen del QR
                    // El fichero se genera en la raíz del proyecto
                    if(combo.getSelectedItem().toString().equalsIgnoreCase(".png")){
                        QR.escribirQR(tfUrl.getText(), tfFichero.getText()+".png",combo.getSelectedItem().toString());
                    new VentanaResultado(tfFichero.getText()+".png");
                    }else{
                        QR.escribirQR(tfUrl.getText(), tfFichero.getText()+".jpg",combo.getSelectedItem().toString());
                    new VentanaResultado(tfFichero.getText()+".jpg");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No puede haber campos vacíos.");
                }
            }
        });
        // Añade botón cerrar
        btnCerrar = new JButton("Salir");
        this.add(btnCerrar);
        // Comportamiento del botón Cerrar
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }
}
