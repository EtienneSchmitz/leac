package ubordeaux.deptinfo.compilation.project.main;

import beaver.Symbol;

public class CompilationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompilationException() {
		super();
	}

	public CompilationException(String arg0) {
		super(arg0);
	}
	
	/**
	 * Stops the program and prints an error message.
	 * Can be used instead of traditional exceptions during parsing.
	 * @param msg
	 * @param symbol
	 */
	public static void halt(String msg, Symbol symbol) {
		System.err.println("COMPILATION ERROR : ");
		System.err.println(msg);
		
		if(symbol != null)
			System.err.println("at line : " + Symbol.getLine(symbol.getStart()) + ", col : " + Symbol.getColumn(symbol.getStart()) + ".");
		
		System.exit(0);
	}
	
	/**
	 * Stops the program and prints an error message.
	 * Can be used instead of traditional exceptions during parsing.
	 * @param msg
	 */
	public static void halt(String msg) {
		halt(msg, null);
	}
}
