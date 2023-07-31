package dom;
import javax.swing.*;
import java.awt.*;

public class Lamina_Botones extends JPanel{
	
	private JButton[] botones;
	private final String[] rotulos = {"%","C","^","/","7","8","9","x","4","5","6","-","1","2","3","+","+/-","0",",","="};
	
	public Lamina_Botones() {
		
		setLayout(new GridLayout(5,4,5,5));
		
		this.botones = new JButton[this.rotulos.length];
		
		agregarBotones(this.rotulos);
	}
	
	private void agregarBotones(String[] rotulos) {
		
		for(int i = 0; i < rotulos.length; i++) {
			
			this.botones[i] = new JButton(rotulos[i]);
			add(this.botones[i]);
			
		}
		
	}

}
