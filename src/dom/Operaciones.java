package dom;
import java.awt.event.*;

public class Operaciones implements ActionListener{
	
	private boolean principio;
	private double resultado;
	private String operadorMatematico;
	
	public Operaciones() {
		
		this.principio = true;
		this.operadorMatematico = "=";
		
	}
	
	//Metodo para hacer operaciones Matematicas
	private void operacionMatematica(double valor) {
		
		if(this.operadorMatematico.equalsIgnoreCase("+")) {
			
			this.resultado += valor;
			
		}
		else if(this.operadorMatematico.equalsIgnoreCase("=")) {
			
			this.resultado += valor;
			
		}
		else {
			System.out.println("Falta terminar el codigo.....");
		}
		
		Marco_Principal.setTextoPantalla("" + this.resultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String entrada = e.getActionCommand();
		
		if(entrada.equalsIgnoreCase("%") || entrada.equalsIgnoreCase("/") || entrada.equalsIgnoreCase("^") ||
		   entrada.equalsIgnoreCase("+") || entrada.equalsIgnoreCase("-") ||
		   entrada.equalsIgnoreCase("X") || entrada.equalsIgnoreCase("+/-") || entrada.equalsIgnoreCase("=")) {
			
			
			operacionMatematica(Double.parseDouble(Marco_Principal.getTextoPantalla()));
			
			this.operadorMatematico = entrada;
			
			this.principio = true;
			
		}
		
		else if(entrada.equalsIgnoreCase("C")) {
			
			this.resultado = 0;
			Marco_Principal.setTextoPantalla("0");
			this.principio = true;
			
		}
		else {
			
			//para borrar el contenido de la pantalla al principio
			if(principio) {
				
				Marco_Principal.setTextoPantalla("");
				this.principio = false;

			}
			
			//Para mantener los datos de pantalla hasta que se precione la tecla de una operacion
			Marco_Principal.setTextoPantalla(Marco_Principal.getTextoPantalla() + entrada);
			
		}
		
	}

}
