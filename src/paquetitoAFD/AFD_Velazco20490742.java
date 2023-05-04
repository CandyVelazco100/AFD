package paquetitoAFD;

import javax.swing.JOptionPane;

public class AFD_Velazco20490742 {
	/* Alumno: Velazco Mendiola Candy Nohemi
	 * No.Contro: 20490742
	 * Lenguajes y Automatas I*/
	
	private static final int p = 0;
	private static final int q = 1;
	private static final int r = 2;
	private static final int s = 3;
	private static final int t = 4;
	private static final int u = 5;
	private int estado;
	public StringBuilder buffer;
	
	public static void main(String args[]) {
		String string = JOptionPane.showInputDialog(null, "Ingrese una cadena que con a, b o c");
		AFD_Velazco20490742 afd = new AFD_Velazco20490742();
		System.out.println("¿La cadena '" + string + "' es aceptable? " + afd.accept(string, true));
	} 
	
	public AFD_Velazco20490742() { 
		estado = p; 
		buffer = new StringBuilder();
	}
	
	public boolean accept(String str, boolean debug) {
		for (char c : str.toCharArray()) {
			int previousState = estado;
			appendChar(c);
			System.out.println("'" + c + "' " + getStateName(previousState) + " -> " + getStateName(estado));
		}
		return estado == t;
	}
	
	private String getStateName(int state) {
		String estadoNom = "";

		switch (state) {
		case p:
			estadoNom = "p";
			break;
		case q:
			estadoNom = "q";
			break;
		case r:
			estadoNom = "r";
			break;
		case s:
			estadoNom = "s";
			break;
		case t:
			estadoNom = "t";
			break;
		case u:
			estadoNom = "u";
			break;
		}
		return estadoNom;
	}
	
	private void appendChar(char caracter) {
		if (caracter != 'a' && caracter != 'b' && caracter != 'c') {
			System.err.println("Invalido");
			return;
		}
		
		buffer.append(caracter);
		
		switch (estado) {
		case p:
			if (caracter == 'a') { estado = q; } else { estado = u; }
			break;
			
		case q:
			if (caracter == 'c') { estado = r; } else { estado = u; }
			break;
			
		case r:
			if (caracter == 'a') { estado = s; } else { estado = r; }
			break;
			
		case s:
			if (caracter == 'b') { 
				estado = t; 
			} else { 
				if (caracter == 'c') { 
					estado = r; 
				} else { 
					estado = s;
				}
			}
			break;
			
		case t:
			if (caracter == 'a') { estado = s; } else { estado = r; }
			break;
			
		case u:
			estado = u;
			break;
		default:
			System.err.println("Chale... ¿A que venia?");
		}
	}
}