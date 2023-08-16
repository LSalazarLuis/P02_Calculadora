package dom;
import java.awt.event.*;
import java.text.*;

public class Operaciones implements ActionListener{
	
	private boolean principio;
	private boolean puntoDecimal;
	private double resultado;
	private double operando1;
	private double operando2;
	private String operadorMatematico;
	private boolean signo;
	private NumberFormat formatoNumero;
	
	public Operaciones() {
		
		this.principio = true;
		this.puntoDecimal = false;
		this.operadorMatematico = "";
		this.signo = true;
		this.formatoNumero = NumberFormat.getInstance();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String entrada = e.getActionCommand();
		
		if(entrada.equalsIgnoreCase("%") || entrada.equalsIgnoreCase("/") || entrada.equalsIgnoreCase("^") ||
		   entrada.equalsIgnoreCase("+") || entrada.equalsIgnoreCase("-") || entrada.equalsIgnoreCase("X")){
			Number n = null;
			// dentro del bloque try-catch, se usa la clase Number/NumberFormat, para dar formato a los números
			// los miles se marcan con punto y los decimales con la coma.
			try {
				n = this.formatoNumero.parse(Marco_Principal.getTextoPantalla());
				this.operando1 = n.doubleValue();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			this.principio = true;
			this.puntoDecimal = false;
			this.operadorMatematico = entrada;

		}
		else if(entrada.equalsIgnoreCase(",")) {
			
			if(!this.puntoDecimal && this.principio) {
				
				Marco_Principal.setTextoPantalla("0,");
				this.puntoDecimal = true; // la variable se limita a un solo punto decimal
				this.principio = false;
				
			}
			else {
				Marco_Principal.setTextoPantalla(Marco_Principal.getTextoPantalla() + ",");
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
			
			Number n = null;
			try {
				n = this.formatoNumero.parse(Marco_Principal.getTextoPantalla());
				this.operando1 = n.doubleValue();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			this.operadorMatematico = entrada;
			this.obtenerResultado();
			//Aquí evaluó si el método obtenerResultado() me devuelve un valor negativo, lo que quiere decir que se está tratando de obtener la raíz de un numero negativo
			Marco_Principal.setTextoPantalla("" + (this.resultado >= 0 ? this.formatoNumero.format(this.resultado) : "Error: Entrada no válida"));
			this.operadorMatematico ="";
			
		}
		
		else if(entrada.equalsIgnoreCase("=")) {
			
			System.out.println("valor 1 = " +this.operando1 +"\n");
			Number n = null;
			
			try {
				n = this.formatoNumero.parse(Marco_Principal.getTextoPantalla());
				this.operando2 = n.doubleValue();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("valor 2 = " + this.operando2 +"\n");
			this.obtenerResultado();
			System.out.println("operacion matematica:" + this.operadorMatematico);
			System.out.println("El resultado es:" + this.resultado + "\n");
			Marco_Principal.setTextoPantalla("" + this.formatoNumero.format(this.resultado));
			this.resetear();

			
		}
		
		else if(entrada.equalsIgnoreCase("C")) {
			
			this.resetear();
			Marco_Principal.setTextoPantalla("0");
			this.signo = true;

		}
		else {//ingresara en este bloque de código solo si se presiona un número.
			
			//para borrar el contenido de la pantalla al principio.
			if(principio) {
				
				Marco_Principal.setTextoPantalla("");
				this.principio = false;

			}
			
			//Para mantener los datos de pantalla hasta que se presione la tecla de una operación
			Marco_Principal.setTextoPantalla(Marco_Principal.getTextoPantalla() + entrada);
			
		}
		
	}
	
	// Método para realizar las operaciones matemáticas:
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
	
	//Método para resetear los valores
	private void resetear() {
		
		this.operando1 = this.operando2 = 0;
		this.operadorMatematico = "";
		this.principio = true;
		this.puntoDecimal = false;
		
	}

}
