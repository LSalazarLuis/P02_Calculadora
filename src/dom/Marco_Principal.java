package dom;
import javax.swing.*;
import java.awt.*;

public class Marco_Principal extends JFrame{
	
	private static JLabel pantalla;
	
	public Marco_Principal() {
		
		// Características de la ventana:
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,500);
		setTitle("Calculadora");
		setLayout(new BorderLayout());
		
		// Pantalla de la calculadora:
		
		Marco_Principal.pantalla = new JLabel("0", SwingConstants.RIGHT);
		Marco_Principal.pantalla.setFont(new Font("Arial",Font.BOLD,80));
		
		add(Marco_Principal.pantalla, BorderLayout.NORTH);
		
		
		// Botones de la calculadora:
		
		Lamina_Botones botones = new Lamina_Botones();
		add(botones, BorderLayout.CENTER);
		
		// Se agregan los siguientes JPanel, con su respectiva posición BorderLayout, para generar un pequeño margen con la ventana
		add(new JPanel(),BorderLayout.WEST);
		add(new JPanel(),BorderLayout.EAST);
		add(new JPanel(),BorderLayout.SOUTH);
		
	}
	
	public static String getTextoPantalla() {
		
		return Marco_Principal.pantalla.getText();
	}
	
	public static void setTextoPantalla(String texto) {
		
		Marco_Principal.pantalla.setText(texto);
		
		
	}
	
	

}
