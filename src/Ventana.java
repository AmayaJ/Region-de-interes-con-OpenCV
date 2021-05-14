import java.awt.*;
import javax.swing.*;

// CLASE PRINCIPAL DEL PROGRAMA (Hereda de JFrame)
public class Ventana extends JFrame {

  public Ventana(Image img) {
	
        // Creo y configuro la ventana
        JFrame frame = new JFrame("Imagen original");
	  	
		// Accion por defecto al cerrar la ventana: salir del programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel1 = new JPanel();
		JLabel jlabel1 = new JLabel();

		//Agrego el jpanel al Frame
		frame.getContentPane().add(panel1);

        // mostrar la ventana
		frame.setSize(515,295); // dimensiones
		frame.setLocation(200,200); // posicion
		frame.setResizable(true); // N cambia dimensiones
        frame.setVisible(true); // Muestro el frame
       
	  	//Creo el Label y le inserto la imagen
        jlabel1.setIcon(new ImageIcon(img));
        panel1.add(jlabel1);
	}  

}