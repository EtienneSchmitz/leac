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


/////////////////////////////////
//							   //	
// Utility code	        	   //
//							   //
/////////////////////////////////

%{
	// String builder used for creating string between string delimiters.
	private StringBuilder stringBuilder = new StringBuilder();
	
	private Symbol createSymbol(short terminal)
	{
		return createSymbol(terminal, null);
	}
	
	private Symbol createSymbol(short terminal, Object symbolObject)
	{
		System.out.println("--> " + Terminals.NAMES[terminal] + " : " + yytext());
		return new Symbol(terminal, yyline, yycolumn, symbolObject);
	}
%}

/////////////////////////////////
//							   //	
// Basic regex 	        	   //
//							   //
/////////////////////////////////

Identifier						= [a-zA-Z_][a-zA-Z0-9_]*
Integer 						= ([0-9]+)|(0x[1-9A-F])+)
//Decimal 							= ({Integer}(\.{Integer})?)|(\.{Integer})
//Float 							= {Decimal}([eE][+-]?{Integer})?
StringDelimiter 				= \"


//////////////////////////////////////////////////////////////////////////////
//							   												//	
// Comments regex (from jflex manual : https://jflex.de/manual.html). 		//
//							   												//
//////////////////////////////////////////////////////////////////////////////

LineTerminator 					= \r|\n|\r\n
InputCharacter 					= [^\r\n]
    
TraditionalComment   			= "/*" [^*] ~"*/" | "/*" "*"+ "/"

EndOfLineComment     			= "//" {InputCharacter}* {LineTerminator}?

DocumentationComment 			= "/**" {CommentContent} "*"+ "/"
CommentContent       			= ( [^*] | \*+ [^/*] )*

/* comments */
Comment 						= {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}


/////////////////////////////////
//							   //	
// Language keywords      	   //
//							   //
/////////////////////////////////

VariableDeclaration				= "var"

StructureDeclaration			= "struct"

ProcedureDefinition				= "procedure"
FunctionDefinition				= "function"

StatementBlock_StartDelimiter	= "begin"
StatementBlock_EndDelimiter		= "end"

DynamicAllocation 				= "new"
Deallocation 	 				= "dispose"

StdWrite						= "println"
StdRead							= "readln"

FunctionReturn					= "return"

IfStatement						= "if"
IfStatement_StartDelimiter		= "then"
IfStatement_ElseDelimiter		= "else"

WhileStatement					= "while"
WhileStatement_StartDelimiter	= "do"

SwitchStatement					= "switch"
SwitchStatement_CaseIdentifier	= "case"
SwitchStatement_DefaultCase		= "default"

TrueBoolean						= "true"
FalseBoolean					= "false"

NullPointer						= "null"


/////////////////////////////////
//							   //	
// Operators        		   //
//							   //
/////////////////////////////////

Plus							= "+"
Minus							= "-"
Times							= "*"
Divide							= "/"

LogicalOr						= "||"
LogicalAnd						= "&&"
Negation						= "!"

Less							= "<"
LessOrEquals					= "<="
Higher							= ">"
HigherOrEquals					= ">="
Equals							= "=="
NotEquals						= "!="

LeftParenthesis					= "("
RightParenthesis				= ")"
LeftBracket						= "["
RightBracket					= "]"
LeftCurlyBracket				= "{"
RightCurlyBracket				= "}"

Pointer							= "^"

Subrange						= ".."

Affectation						= "="


/////////////////////////////////
//							   //	
// Separators	      		   //
//							   //
/////////////////////////////////

Colons							= ":"
SemiColon						= ";"
Coma							= ","


/////////////////////////////////
//							   //	
// Primitive types    		   //
//							   //
/////////////////////////////////

StringType						= "string"
IntegerType						= "integer"
Boolean							= "boolean"


// Define states here

%state STRING 


//////////////////////////////////////////////////////////////////////////////
%% ////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////

/////////////////////////////////
//							   //	
// HERE THE LEXER STARTS	   //
//							   //
/////////////////////////////////

// Standard state. Our grammar is scanned in this section.
<YYINITIAL> 
{	
	{Identifier}							{ return createSymbol(Terminals., yytext());				}
	{Integer}								{ return createSymbol(Terminals., new Integer(yytext()));	}
	
	
	/////////////////////////////////////////// Keywords
	
	{VariableDeclaration}					{ return createSymbol(Terminals.); 							}	
	
	{StructureDeclaration}					{ return createSymbol(Terminals.); 							}
	
	{ProcedureDefinition}					{ return createSymbol(Terminals.); 							}
	{FunctionDefinition}					{ return createSymbol(Terminals.); 							}
	
	{StatementBlock_StartDelimiter}			{ return createSymbol(Terminals.); 							}
	{StatementBlock_EndDelimiter}			{ return createSymbol(Terminals.); 							}
	
	{DynamicAllocation}						{ return createSymbol(Terminals.); 							}
	{Deallocation}							{ return createSymbol(Terminals.); 							}
	
	{StdWrite}								{ return createSymbol(Terminals.); 							}
	{StdRead}								{ return createSymbol(Terminals.); 							}
	
	{FunctionReturn}						{ return createSymbol(Terminals.); 							}
	
	{IfStatement}							{ return createSymbol(Terminals.); 							}
	{IfStatement_StartDelimiter}			{ return createSymbol(Terminals.); 							}
	{IfStatement_ElseDelimiter}				{ return createSymbol(Terminals.); 							}
	
	{WhileStatement}						{ return createSymbol(Terminals.); 							}
	{WhileStatement_StartDelimiter}			{ return createSymbol(Terminals.); 							}
	
	{SwitchStatement}						{ return createSymbol(Terminals.); 							}
	{SwitchStatement_CaseIdentifier}		{ return createSymbol(Terminals.); 							}
	{SwitchStatement_DefaultCase}			{ return createSymbol(Terminals.); 							}
	
	{TrueBoolean}							{ return createSymbol(Terminals.); 							}
	{FalseBoolean}							{ return createSymbol(Terminals.); 							}
	
	{NullPointer}							{ return createSymbol(Terminals.); 							}
	
	
	/////////////////////////////////////////// Operators
	
	{Plus}									{ return createSymbol(Terminals.); 							}
	{Minus}									{ return createSymbol(Terminals.); 							}
	{Times}									{ return createSymbol(Terminals.); 							}
	{Divide}								{ return createSymbol(Terminals.); 							}
	
	{LogicalOr}								{ return createSymbol(Terminals.); 							}
	{LogicalAnd}							{ return createSymbol(Terminals.); 							}
	{Negation}								{ return createSymbol(Terminals.); 							}
		
	{Less}									{ return createSymbol(Terminals.); 							}
	{LessOrEquals}							{ return createSymbol(Terminals.); 							}
	{Higher}								{ return createSymbol(Terminals.); 							}
	{HigherOrEquals}						{ return createSymbol(Terminals.); 							}
	{Equals}								{ return createSymbol(Terminals.); 							}
	{NotEquals}								{ return createSymbol(Terminals.); 							}
	
	{LeftParenthesis}						{ return createSymbol(Terminals.); 							}
	{RightParenthesis}						{ return createSymbol(Terminals.); 							}
	{LeftBracket}							{ return createSymbol(Terminals.); 							}
	{RightBracket}							{ return createSymbol(Terminals.); 							}
	{LeftCurlyBracket}						{ return createSymbol(Terminals.); 							}
	{RightCurlyBracket}						{ return createSymbol(Terminals.); 							}
	
	{Pointer}								{ return createSymbol(Terminals.); 							}
	
	{Subrange}								{ return createSymbol(Terminals.); 							}
	
	{Affectation}							{ return createSymbol(Terminals.); 							}
	
	
	/////////////////////////////////////////// Separators
	
	{Colons}								{ return createSymbol(Terminals.); 							}
	{SemiColon}								{ return createSymbol(Terminals.); 							}
	{Coma}									{ return createSymbol(Terminals.); 							}
	
	
	/////////////////////////////////////////// Primitive types
	
	{StringType}							{ return createSymbol(Terminals.); 							}
	{IntegerType}							{ return createSymbol(Terminals.); 							}
	{Boolean}								{ return createSymbol(Terminals.); 							}

	{StringDelimiter}						{ stringBuilder.setLength(0); yybegin(STRING); 				}
	{Comment}								{ // Do nothing, comments are not treated. 					}
}

// State between two string delimiters. Our grammar has no effects here.
// Some regex below are from the jflex manual (https://jflex.de/manual.html).
<STRING> 
{
	{StringDelimiter}						{ yybegin(YYINITIAL); return createSymbol(Terminals., stringBuilder.toString()); }
	\\{StringDelimiter}						{ stringBuilder.append(yytext()); }
	
	[^\n\r\"\\]+                   			{ stringBuilder.append(yytext()); }
	"\n"									{ stringBuilder.append('\n'); }				
	"\t"									{ stringBuilder.append('\t'); }			
	"\r"									{ stringBuilder.append('\r'); }	
	"\\"									{ stringBuilder.append('\\'); }					
}
