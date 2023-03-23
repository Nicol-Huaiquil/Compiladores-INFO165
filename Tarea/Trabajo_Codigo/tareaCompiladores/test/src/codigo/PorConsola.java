package codigo;

import java.io.StringReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java_cup.runtime.Symbol;

public class PorConsola{
	public static void main(String[] args) throws IOException {
		System.out.println("----Instrucciones----\n"
                + "inicia: Debe ser la primera instruccion.\r\n"
                + "crea(arch): crea y abre el archivo llamado arch.\r\n"
                + "abre(arch): abre un archivo arch ya existente.\r\n"
                + "ingresa(codigo, nombre, edad, ocupacion, direccion): agrega luego del Ultimo registro del archivo abierto, un nuevo registro con los datos entregados.\r\n"
                + "lista: Despliega en pantalla el contenido del archivo abierto actualmente.\r\n"
                + "muestra(codigo): Despliega en pantalla el registro del documento abierto cuyo codigo se ingreso.\r\n"
                + "cierra: cierra el archivo en uso.\r\n"
                + "termina: Ultima instruccion del programa y cierra este.\r\n\n"
                + "NOTAS:\n"
                + "\t arch debe ser un archivo de formato .txt, Ejemplo: crea(hola.txt)\n"
                + "\t Informacion con caracteres que tengan ñ o tilde no pueden ser ingresados.\n\n"
                + "-----Ingrese instrucciones------");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buffIn = new BufferedReader(input);
		while(true) {
	        String st = buffIn.readLine();
			a_sintaxis s = new a_sintaxis(new codigo.LexerC(new StringReader(st)));
			try {
				s.parse();
			}
			catch (Exception ex) {
				Symbol sym = s.getS();
				System.out.println("Error de sintaxis -- Linea "+(sym.right + 1)+" | Columna "+(sym.left + 1)+" | En : "+sym.value+"\nIntentelo de nuevo.");
			}
		}
	}
}