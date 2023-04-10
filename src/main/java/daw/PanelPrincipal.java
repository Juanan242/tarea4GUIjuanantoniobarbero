/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Juanan
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    private double operando1;
    private double operando2;
    private double resultado;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
        operando1 = 0;
        operando2 = 0;
        resultado = 0;
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 25);
        areaTexto.setEditable(false);

        areaTexto.setBackground(Color.white);
        areaTexto.setFont(new java.awt.Font("Dialog", 0, 25));
        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();

        //si es un botón
        if (o instanceof JButton) {
            String buttonText = ((JButton) o).getText();
            switch (buttonText) {
                case "+":
                    //sumas
                    tipoOperacion = 1;
                    operando1 = Double.parseDouble(areaTexto.getText());
                    areaTexto.setText("");
                    break;
                case "-":
                    //restas
                    tipoOperacion = 2;
                    operando1 = Double.parseDouble(areaTexto.getText());
                    areaTexto.setText("");
                    break;
                case "*":
                    //multiplicaiones
                    tipoOperacion = 3;
                    operando1 = Double.parseDouble(areaTexto.getText());
                    areaTexto.setText("");
                    break;
                case "/":
                    tipoOperacion = 4; // División
                    operando1 = Double.parseDouble(areaTexto.getText());
                    areaTexto.setText("");
                    break;
                case "=":
                    //resultado de los operando
                    double operando2 = Double.parseDouble(areaTexto.getText());
                    double resultado = 0.0;
                    switch (tipoOperacion) {
                        case 1:
                            //sumas
                            resultado = operando1 + operando2;
                            break;
                        case 2:
                            //restas
                            resultado = operando1 - operando2;
                            break;
                        case 3:
                            //multiplicaciones
                            resultado = operando1 * operando2;
                            break;
                        case 4:
                            //divisiones
                            resultado = operando1 / operando2;
                            break;
                    }

                    areaTexto.setText(Double.toString(resultado));
                    //reseteo la operacion
                    tipoOperacion = -1;
                    break;
                case "C":
                    //borra lo que hay en pantalla
                    areaTexto.setText("");
                    //se resetea la operacion
                    tipoOperacion = -1;
                    break;

                default:
                    //por defecto los numeros
                    areaTexto.setText(areaTexto.getText() + buttonText);
                    break;
            }
        }
    }
}
