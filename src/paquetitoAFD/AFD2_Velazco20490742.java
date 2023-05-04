package paquetitoAFD;
import java.util.Scanner;
 
public class AFD2_Velazco20490742 {
	static char [] caracteres;
	boolean aceptacion;
    int contador;
 
    public static void main(String[] args) {
    	String str;
    	Scanner sn = new Scanner(System.in);
        AFD2_Velazco20490742  automata = new AFD2_Velazco20490742();
        
        System.out.print("Ingrese La cadena: ");
        str = sn.nextLine();
 
         while (!str.contains("a")||(!str.contains("b")||(!str.contains("c")))){
            System.out.println("Cadena no aceptada");
            System.out.println("\n");
            System.out.print("Ingrese La cadena que desea determinar si se encuentra en el AFD: ");
            str = sn.nextLine();
         }
         sn.close();
 
        caracteres = str.toCharArray();
        automata.Inicial();
 
        if(automata.aceptacion){
            System.out.println("\n");
            System.out.println("La Cadena es Aceptada");
        }else{
            System.out.println("\n");
            System.out.println("La Cadena no es Aceptada");
        }
    }

    public void Inicial() {
        contador = 0; 
        p();
    }
  
    public void p() {
    	aceptacion = false;
        if(contador < caracteres.length){
            if(caracteres[contador] == 'a'){ 
                System.out.println("Estado q");
                contador++;
                q(); 
 
            }else if (caracteres[contador]=='b' || caracteres[contador]=='c'){
                contador++;
                u();
            }
        }
    }
    
    public void q() {
    	aceptacion = false;
        System.out.println("Estado q");
        
         if(contador < caracteres.length){
            if(caracteres[contador] == 'c'){
                contador++;
                r();
            }else if (caracteres[contador] =='a'||caracteres[contador] == 'b'){
                contador++;
                u();
            }
        }
    }
    
    public void r() {
        System.out.println("Estado r");
        aceptacion = false;
        
        if(contador < caracteres.length){
            if(caracteres[contador]== 'a'){
                contador++;
                s();
            }else if (caracteres[contador]=='b' || caracteres[contador]=='c'){
                contador++;
                r();
                return;
            }
        }
    }
    
    public void s() {
        System.out.println("Estado s");
        aceptacion = false;
        if(contador<caracteres.length){
            if(caracteres[contador]== 'b'){
                contador++;
                t();
            }else if (caracteres[contador]=='a'){
                contador++;
                s();
                return;
            }else if(caracteres[contador]=='c') {
            	contador++;
                r();
            }
        }
     }
    
    public void t() {
        System.out.println("Estado t");
        aceptacion = true;
        
        if(contador<caracteres.length){
            if(caracteres[contador]== 'a'){
                contador++;
                s();
            }else if (caracteres[contador]=='b' || caracteres[contador]=='c'){
                contador++;
                r();
                return;
            }
        }
    }
    
    public void u() {
        System.out.println("Estado q2");
        aceptacion = false;
        if(contador<caracteres.length){
            if(caracteres[contador]== 'a' || caracteres[contador] == 'b' || caracteres[contador] == 'c'){
                contador++;
                u();
            }
        }
    }
}