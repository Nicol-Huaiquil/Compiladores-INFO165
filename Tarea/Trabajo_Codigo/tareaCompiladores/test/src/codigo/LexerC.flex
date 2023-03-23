package codigo;
import java_cup.runtime.Symbol;

%%

%class LexerC
%type java_cup.runtime.Symbol
%cup
%full
%line
%column

Low=[a-z]
Upper=[A-Z]
Nombre1={Upper}{Low}+
Ocupacion=[a-z]+[a-z' ']+
Archivo=[0-9a-zA-Z]+"."[0-9a-zA-Z]+
Espacio=" "
Numero=[0-9]+
Simbolos=[)(,]

%{
    private Symbol symbol(int type, Object value){
    	return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
    	return new Symbol(type, yyline, yycolumn);
    }
%}

%%

inicia { return new Symbol(sym.INICIA, yycolumn, yyline, yytext());}
crea { return new Symbol(sym.CREA, yycolumn, yyline, yytext());}
abre { return new Symbol(sym.ABRE, yycolumn, yyline, yytext());}
ingresa { return new Symbol(sym.INGRESA, yycolumn, yyline, yytext());}
lista { return new Symbol(sym.LISTA, yycolumn, yyline, yytext());}
muestra { return new Symbol(sym.MUESTRA, yycolumn, yyline, yytext());}
cierra { return new Symbol(sym.CIERRA, yycolumn, yyline, yytext());}
termina { return new Symbol(sym.TERMINA, yycolumn, yyline, yytext());}

{Nombre1}{Espacio}{Nombre1} { return new Symbol(sym.NOMBRE, yycolumn, yyline, yytext());}
{Nombre1}{Espacio}{Numero} { return new Symbol(sym.DIRECCION, yycolumn, yyline, yytext());}

{Archivo} { return new Symbol(sym.ARCHIVO, yycolumn, yyline, yytext());}
{Ocupacion} { return new Symbol(sym.OCUPACION, yycolumn, yyline, yytext());}
{Numero} { return new Symbol(sym.ENTERO, yycolumn, yyline, yytext());}
{Simbolos} { return new Symbol(sym.SIMBOLO, yycolumn, yyline, yytext());}

 . { return new Symbol(sym.ERROR, yycolumn, yyline, yytext());}