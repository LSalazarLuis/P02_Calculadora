package dom;
import java.awt.event.*;

public class Operaciones implements ActionListener{
	
	private boolean principio;
	private boolean puntoDecimal;
	private double resultado;
	private double operando1;
	private double operando2;
	private String operadorMatematico;
	private boolean signo;
	
	public Operaciones() {
		
		this.principio = true;
		this.puntoDecimal = false;
		this.operadorMatematico = "";
		this.signo = true;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String entrada = e.getActionCommand();
		
		if(entrada.equalsIgnoreCase("%") || entrada.equalsIgnoreCase("/") || entrada.equalsIgnoreCase("^") ||
		   entrada.equalsIgnoreCase("+") || entrada.equalsIgnoreCase("-") || entrada.equalsIgnoreCase("X")){
			
			this.operando1 = Double.parseDouble(Marco_Principal.getTextoPantalla());
			this.principio = true;
			this.puntoDecimal = false;
			this.operadorMatematico = entrada;

		}
		else if(entrada.equalsIgnoreCase(".")) {
			
			if(!this.puntoDecimal && this.principio) {
				
				Marco_Principal.setTextoPantalla("0.");
				this.puntoDecimal = true; // la variable me limita a un solo punto decimal
				this.principio = false;
				
			}
			else {
				Marco_Principal.setTextoPantalla(Marco_Principal.getTextoPantalla() + ".");
				this.puntoDecimal = true;
				this.principio = false;
			}
			
			
		}
		else if(entrada.equalsIgnoreCase("+/-")) {
			
			if(signo && !Marco_Principal.getTextoPantalla().equals("0")) {
				
				Marco_Principal.setTextoPantalla("-" + Marco_Principal.getTextoPantalla());
				this.signo = false;
			}
			else {
				
				Marco_Principal.setTextoPantalla(Marco_Principal.getTextoPantalla().replace("-", ""));
				this.signo = true;
			}
			
			
		}
		else if(entrada.equals("√")) {
			
			this.operando1 = Double.parseDouble(Marco_Principal.getTextoPantalla());
			this.operadorMatematico = entrada;
			this.obtenerResultado();
			Marco_Principal.setTextoPantalla("" + (this.resultado >= 0 ? this.resultado : "Error: Entrada no válida"));
			this.operadorMatematico ="";
			
		}
		
		else if(entrada.equalsIgnoreCase("=")) {
			
			System.out.println("valor 1 = " +this.operando1);
			this.operando2 = Double.parseDouble(Marco_Principal.getTextoPantalla());
			System.out.println("valor 2 = " + this.operando2);
			this.obtenerResultado();
			System.out.println("operacion matematica:" + this.operadorMatematico);
			System.out.println("El resultado es:" + this.resultado);
			Marco_Principal.setTextoPantalla("" + this.resultado);
			this.resetear();

			
		}
		
		else if(entrada.equalsIgnoreCase("C")) {
			
			this.resetear();
			Marco_Principal.setTextoPantalla("0");
			this.signo = true;

		}
		else {//ingresara en este bloque de codigo solo si se preciona un número.
			
			//para borrar el contenido de la pantalla al principio
			if(principio) {
				
				Marco_Principal.setTextoPantalla("");
				this.principio = false;

			}
			
			//Para mantener los datos de pantalla hasta que se precione la tecla de una operacion
			Marco_Principal.setTextoPantalla(Marco_Principal.getTextoPantalla() + entrada);
			
		}
		
	}
	
	// Metodo para realizar las operaciones matematicas:
	private void obtenerResultado() {
		
		switch(this.operadorMatematico) {
		
		case "+":
			this.resultado = this.operando1 + this.operando2;
			break;
		case "-":
			this.resultado = this.operando1 - this.operando2;
			break;
		case "x":
			this.resultado = this.operando1 * this.operando2;
			break;
		case "/":
			this.resultado = this.operando1 / this.operando2;
			break;
		case "^":
			this.resultado = Math.pow(this.operando1, this.operando2);
			break;
		case "√":
			
			if(this.operando1 >= 0) {
				this.resultado = Math.sqrt(operando1);
			}
			else {
				this.resultado = -1; //se le asigna un valor, para luego evaluarlo e imprimir un mensaje de error
			}
			break;
		default:
			this.resultado = 0;
			break;
		
		}
		
	}
	
	//Metodo para resetear los valores
	private void resetear() {
		
		this.operando1 = this.operando2 = 0;
		this.operadorMatematico = "";
		this.principio = true;
		this.puntoDecimal = false;
		
	}

}
