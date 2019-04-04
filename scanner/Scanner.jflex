package ubordeaux.deptinfo.compilation.project.main;

import beaver.Symbol;
import beaver.Scanner;

%%
%class ScannerLea
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
Integer 						= ([0-9]+)|(0x[0-9A-F])+
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
Dot								= "."


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
	{Integer}								{ return createSymbol(Terminals.TOKEN_LIT_INTEGER, new Integer(yytext()));	}
	
	
	/////////////////////////////////////////// Keywords
	
	{VariableDeclaration}					{ return createSymbol(Terminals.TOKEN_VAR); 							}
	
	{StructureDeclaration}					{ return createSymbol(Terminals.TOKEN_STRUCT); 							}
	
	{ProcedureDefinition}					{ return createSymbol(Terminals.TOKEN_PROCEDURE); 							}
	{FunctionDefinition}					{ return createSymbol(Terminals.TOKEN_FUNCTION); 							}
	
	{StatementBlock_StartDelimiter}			{ return createSymbol(Terminals.TOKEN_BEGIN); 							}
	{StatementBlock_EndDelimiter}			{ return createSymbol(Terminals.TOKEN_END); 							}
	
	{DynamicAllocation}						{ return createSymbol(Terminals.TOKEN_NEW); 							}
	{Deallocation}							{ return createSymbol(Terminals.TOKEN_DISPOSE); 							}
	
	{StdWrite}								{ return createSymbol(Terminals.TOKEN_PRINTLN); 							}
	{StdRead}								{ return createSymbol(Terminals.TOKEN_READLN); 							}
	
	{FunctionReturn}						{ return createSymbol(Terminals.TOKEN_RETURN); 							}
	
	{IfStatement}							{ return createSymbol(Terminals.TOKEN_IF); 							}
	{IfStatement_StartDelimiter}			{ return createSymbol(Terminals.TOKEN_THEN); 							}
	{IfStatement_ElseDelimiter}				{ return createSymbol(Terminals.TOKEN_ELSE); 							}
	
	{WhileStatement}						{ return createSymbol(Terminals.TOKEN_WHILE); 							}
	{WhileStatement_StartDelimiter}			{ return createSymbol(Terminals.TOKEN_DO); 							}
	
	{SwitchStatement}						{ return createSymbol(Terminals.TOKEN_SWITCH); 							}
	{SwitchStatement_CaseIdentifier}		{ return createSymbol(Terminals.TOKEN_CASE); 							}
	{SwitchStatement_DefaultCase}			{ return createSymbol(Terminals.TOKEN_DEFAULT); 							}
	
	{TrueBoolean}							{ return createSymbol(Terminals.TOKEN_TRUE); 							}
	{FalseBoolean}							{ return createSymbol(Terminals.TOKEN_FALSE); 							}
	
	{NullPointer}							{ return createSymbol(Terminals.TOKEN_NULL); 							}
	
	
	/////////////////////////////////////////// Operators
	
	{Plus}									{ return createSymbol(Terminals.TOKEN_PLUS); 							}
	{Minus}									{ return createSymbol(Terminals.TOKEN_MINUS); 							}
	{Times}									{ return createSymbol(Terminals.TOKEN_TIMES); 							}
	{Divide}								{ return createSymbol(Terminals.TOKEN_DIV); 							}
	
	{LogicalOr}								{ return createSymbol(Terminals.TOKEN_OR); 							}
	{LogicalAnd}							{ return createSymbol(Terminals.TOKEN_AND); 							}
	{Negation}								{ return createSymbol(Terminals.TOKEN_NOT); 							}
		
	{Less}									{ return createSymbol(Terminals.TOKEN_LT); 							}
	{LessOrEquals}							{ return createSymbol(Terminals.TOKEN_LE); 							}
	{Higher}								{ return createSymbol(Terminals.TOKEN_GT); 							}
	{HigherOrEquals}						{ return createSymbol(Terminals.TOKEN_GE); 							}
	{Equals}								{ return createSymbol(Terminals.TOKEN_EQ); 							}
	{NotEquals}								{ return createSymbol(Terminals.TOKEN_NE); 							}
	
	{LeftParenthesis}						{ return createSymbol(Terminals.TOKEN_LPAR); 							}
	{RightParenthesis}						{ return createSymbol(Terminals.TOKEN_RPAR); 							}
	{LeftBracket}							{ return createSymbol(Terminals.TOKEN_LBRACKET); 							}
	{RightBracket}							{ return createSymbol(Terminals.TOKEN_RBRACKET); 							}
	{LeftCurlyBracket}						{ return createSymbol(Terminals.TOKEN_LBRACE); 							}
	{RightCurlyBracket}						{ return createSymbol(Terminals.TOKEN_RBRACE); 							}
	
	{Pointer}								{ return createSymbol(Terminals.TOKEN_CIRC); 							}
	
	{Subrange}								{ return createSymbol(Terminals.TOKEN_DOTDOT); 							}
	
	{Affectation}							{ return createSymbol(Terminals.TOKEN_AFF); 							}
	
	
	/////////////////////////////////////////// Separators
	
	{Colons}								{ return createSymbol(Terminals.TOKEN_COLON); 							}
	{SemiColon}								{ return createSymbol(Terminals.TOKEN_SEMIC); 							}
	{Coma}									{ return createSymbol(Terminals.TOKEN_COMMA); 							}
	//{Dot}									{ return createSymbol(Terminals.TOKEN_DOT); 							}
	
	
	/////////////////////////////////////////// Primitive types
	
	{StringType}							{ return createSymbol(Terminals.TOKEN_STRING); 							}
	{IntegerType}							{ return createSymbol(Terminals.TOKEN_INTEGER); 							}
	{Boolean}								{ return createSymbol(Terminals.TOKEN_BOOLEAN); 							}

	{StringDelimiter}						{ stringBuilder.setLength(0); yybegin(STRING); 				}
	{Comment}								{ 				                                            } // Do nothing, comments are not treated.
	{Identifier}							{ return createSymbol(Terminals.TOKEN_IDENTIFIER, yytext());				}
}

// State between two string delimiters. Our grammar has no effects here.
// Some regex below are from the jflex manual (https://jflex.de/manual.html).
<STRING> 
{
	{StringDelimiter}						{ yybegin(YYINITIAL); return createSymbol(Terminals.TOKEN_LIT_STRING, stringBuilder.toString()); }
	\\{StringDelimiter}						{ stringBuilder.append(yytext()); }


	"\t"									{ stringBuilder.append('\t'); }
	[^\n\r\"\\]+                   			{ stringBuilder.append(yytext()); }
	"\n"									{ stringBuilder.append('\n'); }
	"\r"									{ stringBuilder.append('\r'); }	
	"\\"									{ stringBuilder.append('\\'); }					
}

[^]|\n	{}
