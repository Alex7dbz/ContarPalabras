/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicioapp;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class InicioApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
		InicioApp ia = new InicioApp();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca conjunto de caracteres");
		String frase = sc.nextLine();
		ia.contarPalabras(frase);
		ia.mostrarResultado();
		sc.close();
	}

	int [] contador;
	char [] letras;
	int palabras;
	int numCaracteresSinEspacios = 0;
        
	public InicioApp(){
		contador = new int[65536];
		letras = new char[65536];
		palabras = 1;
	}
	
	private void contarPalabras(String frase){
		char car2 = ' ';
		for (int i = 0;i<frase.length();i++){ 
			char car = frase.charAt(i); 
			int ascii = car; 
			contador[ascii]++; 
			letras[ascii] = car;
			if (car != ' ') numCaracteresSinEspacios++; 
			if (car == ' ' && car2!=' ') { 
				palabras++;
			}
			car2 = car;
 		}
	}
	
	private void mostrarResultado(){
		System.out.println("Se han introducido un total de " + numCaracteresSinEspacios+ " letras/caracteres");
		System.out.println("Se han introducido "  + palabras + " palabras");
		System.out.println("las letras que se repiten son: ");
		for (int i = 0;i<letras.length;i++) {
			if (contador[i]>0 && letras[i] != ' ') {
				if (contador[i]==1)
					System.out.println(""+letras[i]+ "-->" + contador[i] + " vez.");
				else
					System.out.println(""+letras[i]+ "-->" + contador[i] + " veces.");
			}
		}
	}
	


}

    

