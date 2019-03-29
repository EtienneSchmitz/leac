import beaver.Symbol;
import beaver.Scanner;

%%

%class ScannerExpr
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
    return new Symbol(Terminals.EOF,yyline, yycolumn, yytext());
%eofval}
%unicode
%line
%column

Identificateur= [a-zA-Z_][a-zA-Z0-9_]*
Entiers = [0-9]+
Entiers_Float = [0-9]*
Middle_Float = "."
Float = {Entiers_Float}{Middle_Float}{Entiers_Float}

%%