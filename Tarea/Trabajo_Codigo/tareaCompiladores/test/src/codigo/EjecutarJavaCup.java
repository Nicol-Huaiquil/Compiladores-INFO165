package codigo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjecutarJavaCup {
    public static void main(String[] args) throws Exception {
        String[] rutaS = {"-parser", "a_sintaxis", "C:/Users/Administrador/Desktop/COMPILADORES/compiladores/Tarea_Parte1/tarea1CompiladoresCodigo/test/src/codigo/a_sintaxis.cup"};
        generar(rutaS);
    }
    public static void generar(String[] rutaS) throws IOException, Exception{
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/Administrador/Desktop/COMPILADORES/compiladores/Tarea_Parte1/tarea1CompiladoresCodigo/test/src/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/Administrador/Desktop/COMPILADORES/compiladores/Tarea_Parte1/tarea1CompiladoresCodigo/sym.java"), 
                Paths.get("C:/Users/Administrador/Desktop/COMPILADORES/compiladores/Tarea_Parte1/tarea1CompiladoresCodigo/test/src/codigo/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/Administrador/Desktop/COMPILADORES/compiladores/Tarea_Parte1/tarea1CompiladoresCodigo/test/src/codigo/a_sintaxis.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/Administrador/Desktop/COMPILADORES/compiladores/Tarea_Parte1/tarea1CompiladoresCodigo/a_sintaxis.java"), 
                Paths.get("C:/Users/Administrador/Desktop/COMPILADORES/compiladores/Tarea_Parte1/tarea1CompiladoresCodigo/test/src/codigo/a_sintaxis.java")
        );
    }
}