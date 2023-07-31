package dom;
import javax.swing.*;
import java.awt.*;

public class Marco_Principal extends JFrame{
	
	private JLabel pantalla;
	
	public Marco_Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,500);
		setTitle("Calculadora");
		setLayout(new BorderLayout());
		
		//Pantalla de la calculadora
		
		pantalla = new JLabel("0", SwingConstants.RIGHT);
		pantalla.setFont(new Font("Arial",Font.BOLD,80));
		
		add(pantalla, BorderLayout.NORTH);
		
		// Botones de la calculadora
		
		Lamina_Botones botones = new Lamina_Botones();
		add(botones, BorderLayout.CENTER);
		add(new JPanel(),BorderLayout.WEST);
		add(new JPanel(),BorderLayout.EAST);
		add(new JPanel(),BorderLayout.SOUTH);
		
	}

}
