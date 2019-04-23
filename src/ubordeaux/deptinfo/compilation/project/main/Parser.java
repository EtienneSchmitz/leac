package ubordeaux.deptinfo.compilation.project.main;

import ubordeaux.deptinfo.compilation.project.environment.FunctionEnvironment.Function;
import java.util.Iterator;
import ubordeaux.deptinfo.compilation.project.environment.*;
import ubordeaux.deptinfo.compilation.project.type.*;
import beaver.*;
import java.util.ArrayList;
import ubordeaux.deptinfo.compilation.project.node.*;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "Parser.grammar".
 */
public class Parser extends beaver.Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pjMGbq5TKP$cRcWIsLQAcDRA68IrWYYhA680OaY1e94KDO1PMW4N152agnKWL5q0GL5L6" +
		"K7KGHHL1K5711G15SMnLtN6fRQAjjHN#$kVbdthnvynv9wj5pF8RppR$Sx$x$V##xzywT0n" +
		"1RWM9aeX3TSHOQu47y4lNmAno8#iZ0GJWOlyPlS0X#YnDnF3gXDphWPFJ1AJXLti2hs8wwi" +
		"Ykv3UFn8ix16FJ56IZ1G0p1#MY8hiXbdcto6DkVmQCueBQvoL#DbHYH8lT5IRcJMMUZCNw7" +
		"mr94S98Y12lzHGqgFQrgr2dorFdUyfo47dW9swFpYAJDKrQ3F4tJZgTnsZpdrI1Fi$yZp#W" +
		"Qv6cUDazUsZoNro1FYxHvyjFcUI1bdYmSeRlAh6PzDe6DRBH26noDOz0EHw8H3aUMN8#BCH" +
		"VBi0HBSP$FxHdYPk5mUHrTS5H2v2QOcSn3I#MSJilZFMtsjcUT4EfLwbQ2rjflE4R9YnvN7" +
		"Wrn1njkZd8dikPUVjm98UummsthSo$1PJvtUKJbnohpzxZTvrqQueqZRnBPnobtFXPZfC##" +
		"CCI#rLJGtkTEmmK#TtP41HsLUHrc#BmR8tYTbNTJeD9R8dZTbDSFj$cyh13Fy#Sb#ETYCgx" +
		"7T5o9F#0g$15NOuhlguZmpOhmpOdmROpmROdmxGZuadV7pvwQUgRY2laS2t0FfiekerNITw" +
		"UlZVUrJQeLwDgfnEDu4dVW1joCF#4QN5jjRIhkzt8YJwCUYgruc6km4ezWBUv2ZFfyVmskm" +
		"js#VY$EZ8oQXOSOOH6b6o7FvyVNzqBPBH$pRFk8aLSajHUZo8oh6FsD7A3Z7AHogCfpLPQh" +
		"7AlIcw5vietdsXfv6O$XUSxGEZn1#obimBDu3fln0iUz7g$mtqwyBFy5$tYkTM6Chgow6q$" +
		"1xloTylcExiatTI$ETs$$rx9uMZkScpgeonkH#yxFO7s3UL9cHBGrv5kqCKVMb6Dlnb4svp" +
		"YzF9rvpZVadcxBdLtRt2v$OChSPKcvarbjz5qL7Q5RokfhMgdNBpfFnlUMPmnNW$jxHEV13" +
		"pIUUZ#nF2r$e3nEBVFOFgzgDNlthtFr$jL0Rs2PFELitWNQyAPVo7jGNzuiF6wZ4DScDuFU" +
		"nCZrUTjBvdcSJ5eUpp9xsxDQHLOIduqEp9IgaaHk2MjkxNE7xeSxa6#RLDnWvHUmNeytAiJ" +
		"B9Yyp4DNYdRTzqXtNOvSdL63npjBHvnwVfWABgopLR0LvxGAL7fVsjnZYy#mGp$EtJF1xQw" +
		"A8jx9YtkxxypttO$cITyVFdffxiesdDRKCezMZbkbh3NrjW6hnlJuS8zYx1M$gH$0cVbIrj" +
		"M3EbXerXzyxPvcJuMn#EJhyAh43QtWqTsdypCYCZ6gR235ADq9ydyJNzp7SCwqeMp56ILAx" +
		"DwxQIc#66l6VMsCcd#uCESOUm35RHi$ckDsHkvmSv0Z$w0LUkmh#NmiYWrX9N4mq8FQwxRK" +
		"14BFu60PORyLz$581lod1#oYiDobtKpObcX15H5$0VfTo2kLVATTGDWQS0iPhIydsM7lAKi" +
		"hJA4TGifzJJZc4yjAgFCwLj8TJNiCOU#FvhJBwPZ9ctO1lFH$DANTNsNOEERCf5qIForvB7" +
		"AXvvb7VeVwjj9Soxz7Qjeg#mrHVHxsJwfke5sgVO$bOI1HfspRwpg72kR7hiQRwwd#DzdZQ" +
		"#MhleksEuqZwjcYi3YevHckSwZSJoxJFHk8JsXEg$nlQauZr8T$j7ECCohd4VCRyGkFlrVO" +
		"bn2l4v7WVvttYA#ATAZlMZkX8J50xFywDSKvYXG6x4z6Po5MRy#Dymp4kJQpBsgUvtbFUP9" +
		"KKiLi9zpVDfhnQ$HE9EQfpRfrzWPnt4HnVR1OnZRY2Q15eNq0iLDrTQsxS2hKd1Mgwbez2n" +
		"jxksjnqpr4CgixSfmFZV9quTkYyMWrK5gYSg7AHofqgFwgIjgNoK9MwTkqUAajLZbKvHUNi" +
		"S4tqBK$suV94szbSdV5n3Zk4x2u1lLj03wwRNg7STOYPsjP7VHjKVgb#tOTMQxNxQRl3yUX" +
		"SsitYCQrXwZk4#hU1iQ#kphZsFsvhULolsdUKcmE#N696OXzxPwBjxAvTxjX1MaDbADwUAe" +
		"cir7sTnQ5O1O7wtex8rJdGxjVBTSqp2jC3RNkI#u9deNmhk#3$oVFoh3mZcsIZR92dvIbPB" +
		"q$AWx9I7f3xfS8mdf1x#Ro7c4VSJN27ovt4788dcjn6y8GGdXHo2y6JKtW2o1sc$oofr4Zp" +
		"vIPPOBHrvhbMRfIPCaDkaEcoXgp7wQkGHqnRXQmsyc7pVCWyLsdDcrMk8EvJVRa$ecMoI9O" +
		"QZMy7UKVULlzVv3$obNmf$vP$oJzbh#oHVyZVwVzK$YPV16Q4vxnygFe7yhvgxwhacrN#B6" +
		"yQ$JDvJxrlgLmiIznpIjnvvZakEsM77tUxUMurpnTa2m9$yfAyokStia$j$n5VKnd7xxgw$" +
		"E83OUCy0mk34CDWog8Kw1T08L6iE9tz#ERdhTmnE8EnpwVVGt$6FvESSifoyqKKupSg29lV" +
		"KhRvdXfANmdxbb0VoRQHbAFPDffocBdJsRpLMRpJMRpLkV#xT01lLI0iSxSQeVUk4nYdbDn" +
		"IsjqL9wP13$9xaj#LSYpZZQLl3EECeJo9iXTHGFGcJYRowG#Y3$lruNXFeJoLTPMHKqR$GD" +
		"gZ66yKxLpQkRHppRUU4uATGe#2vICl0XTz1r#bwVa=");

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN4 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 4];
		}
	};

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
		}
	};

	static class Events extends beaver.Parser.Events {
		public void syntaxError(Symbol token) {
			System.err.format("*** Erreur de syntaxe en ligne %d, colonne %d. Token inattendu: %s\n",
				Symbol.getLine(token.getStart()),
				Symbol.getColumn(token.getStart()),
				Terminals.NAMES[token.getId()]);
		}
	}

	public void semanticError(String msg, Symbol token) {
			System.err.format("*** " + msg + " ligne %d, colonne %d\n",
				Symbol.getLine(token.getStart()),
				Symbol.getColumn(token.getStart()));
	}

	public void debug(Object msg) {
        System.out.println(msg);
    }

	private Environment typeEnvironment = new Environment("types");
	private FunctionEnvironment funcEnv = new FunctionEnvironment();
	private StackEnvironment stackEnv = new StackEnvironment();
	private String type_declaration_name;

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			new Action() {	// [0] program = type_declaration_part variable_declaration_part procedure_definition_part TOKEN_BEGIN statement_list.stm TOKEN_END
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_stm = _symbols[offset + 5];
					final NodeList stm = (NodeList) _symbol_stm.value;
					 stackEnv.closeCurrentScope(); return stm;
				}
			},
			Action.NONE,  	// [1] type_declaration_part = 
			RETURN2,	// [2] type_declaration_part = TOKEN_TYPE type_declaration_list; returns 'type_declaration_list' although none is marked
			new Action() {	// [3] type_declaration_list = type_declaration_list type_declaration
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [4] type_declaration_list = type_declaration
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN4,	// [5] type_declaration = type_declaration_head TOKEN_AFF type TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			Action.RETURN,	// [6] type_declaration_head = TOKEN_IDENTIFIER
			Action.RETURN,	// [7] type = simple_type
			Action.RETURN,	// [8] type = named_type
			Action.RETURN,	// [9] type = index_type
			Action.RETURN,	// [10] type = array_type
			Action.RETURN,	// [11] type = pointer_type
			Action.RETURN,	// [12] type = structure_type
			new Action() {	// [13] simple_type = TOKEN_STRING
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeString();
				}
			},
			new Action() {	// [14] simple_type = TOKEN_INTEGER
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeInt();
				}
			},
			new Action() {	// [15] simple_type = TOKEN_BOOLEAN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeBoolean();
				}
			},
			Action.RETURN,	// [16] named_type = TOKEN_IDENTIFIER
			Action.RETURN,	// [17] index_type = enumerated_type
			Action.RETURN,	// [18] index_type = subrange_type
			new Action() {	// [19] enumerated_type = init_enumerated_type TOKEN_LPAR identifier_list.list TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 3];
					final IdentifierListSymbol list = (IdentifierListSymbol) _symbol_list.value;
					int length= list.getList().size(); return new TypeEnumRange(new TypeItemEnum(0,list.getList().get(0)),new TypeItemEnum(length-1,list.getList().get(length-1)));
				}
			},
			Action.NONE,  	// [20] init_enumerated_type = 
			new Action() {	// [21] subrange_type = TOKEN_LIT_INTEGER.int1 TOKEN_DOTDOT TOKEN_LIT_INTEGER.int2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_int1 = _symbols[offset + 1];
					final Integer int1 = (Integer) _symbol_int1.value;
					final Symbol _symbol_int2 = _symbols[offset + 3];
					final Integer int2 = (Integer) _symbol_int2.value;
					 return new TypeArrayRange(new TypeInt(int1),new TypeInt(int2));
				}
			},
			RETURN3,	// [22] subrange_type = TOKEN_IDENTIFIER TOKEN_DOTDOT TOKEN_IDENTIFIER; returns 'TOKEN_IDENTIFIER' although none is marked
			new Action() {	// [23] array_type = TOKEN_ARRAY TOKEN_LBRACKET range_type.rangetype TOKEN_RBRACKET TOKEN_OF type.type
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_rangetype = _symbols[offset + 3];
					final TypeRange rangetype = (TypeRange) _symbol_rangetype.value;
					final Symbol _symbol_type = _symbols[offset + 6];
					final Type type = (Type) _symbol_type.value;
					 return new TypeArray(rangetype,type);
				}
			},
			Action.RETURN,	// [24] range_type = enumerated_type
			Action.RETURN,	// [25] range_type = subrange_type
			Action.RETURN,	// [26] range_type = named_type
			RETURN2,	// [27] pointer_type = TOKEN_CIRC type; returns 'type' although none is marked
			RETURN4,	// [28] structure_type = TOKEN_STRUCT TOKEN_LBRACE feature_list_type TOKEN_RBRACE; returns 'TOKEN_RBRACE' although none is marked
			new Action() {	// [29] feature_list_type = feature_list_type feature_type
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [30] feature_list_type = feature_type
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN4,	// [31] feature_type = TOKEN_IDENTIFIER TOKEN_COLON type TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			new Action() {	// [32] variable_declaration_part = 
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 NodeList list = new NodeList(); stackEnv.addToCurrentScope(list); return list;
				}
			},
			new Action() {	// [33] variable_declaration_part = TOKEN_VAR variable_declaration_list.list
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 2];
					final NodeList list = (NodeList) _symbol_list.value;
					 stackEnv.addToCurrentScope(list); return list;
				}
			},
			new Action() {	// [34] variable_declaration_list = variable_declaration_list.global_list variable_declaration.list
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_global_list = _symbols[offset + 1];
					final NodeList global_list = (NodeList) _symbol_global_list.value;
					final Symbol _symbol_list = _symbols[offset + 2];
					final NodeList list = (NodeList) _symbol_list.value;
					 Iterator<Node> it = list.iterator(); while(it.hasNext()) global_list.add(it.next()); return global_list;
				}
			},
			new Action() {	// [35] variable_declaration_list = variable_declaration.list
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					 return list;
				}
			},
			new Action() {	// [36] variable_declaration = identifier_list.list TOKEN_COLON type.type TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final IdentifierListSymbol list = (IdentifierListSymbol) _symbol_list.value;
					final Symbol _symbol_type = _symbols[offset + 3];
					final Type type = (Type) _symbol_type.value;
					 NodeList nodeList = new NodeList(); 
															   for(String id : list.getList()) nodeList.add(new NodeId(id, type));	 
															   return nodeList;
				}
			},
			new Action() {	// [37] identifier_list = identifier_list.list TOKEN_COMMA TOKEN_IDENTIFIER.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final IdentifierListSymbol list = (IdentifierListSymbol) _symbol_list.value;
					final Symbol _symbol_id = _symbols[offset + 3];
					final String id = (String) _symbol_id.value;
					 list.add(id); return list;
				}
			},
			new Action() {	// [38] identifier_list = TOKEN_IDENTIFIER.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					 IdentifierListSymbol list = new IdentifierListSymbol(); list.add(id); return list;
				}
			},
			Action.NONE,  	// [39] procedure_definition_part = 
			Action.RETURN,	// [40] procedure_definition_part = procedure_definition_list
			new Action() {	// [41] procedure_definition_list = procedure_definition_list procedure_definition
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
				}
			},
			new Action() {	// [42] procedure_definition_list = procedure_definition
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
				}
			},
			new Action() {	// [43] procedure_definition = procedure_definition_head.decl block.def
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_decl = _symbols[offset + 1];
					final TypeFunct decl = (TypeFunct) _symbol_decl.value;
					final Symbol _symbol_def = _symbols[offset + 2];
					final NodeList def = (NodeList) _symbol_def.value;
					 System.out.println("CONTEXT : " + decl.getName()); funcEnv.add(decl.getName(), decl, def);
															   stackEnv.closeCurrentScope();
														   	   return decl;
				}
			},
			new Action() {	// [44] procedure_definition = procedure_declaration_head.decl TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_decl = _symbols[offset + 1];
					final TypeFunct decl = (TypeFunct) _symbol_decl.value;
					 System.out.println("CONTEXT : " + decl.getName()); funcEnv.add(decl.getName(), decl);
														   return decl;
				}
			},
			new Action() {	// [45] procedure_definition_head = procedure_head.funct
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_funct = _symbols[offset + 1];
					final TypeFunct funct = (TypeFunct) _symbol_funct.value;
					 return funct;
				}
			},
			new Action() {	// [46] procedure_declaration_head = procedure_head.funct
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_funct = _symbols[offset + 1];
					final TypeFunct funct = (TypeFunct) _symbol_funct.value;
					 return funct;
				}
			},
			new Action() {	// [47] procedure_head = TOKEN_PROCEDURE TOKEN_IDENTIFIER.id TOKEN_LPAR argt_part.args TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 2];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_args = _symbols[offset + 4];
					final TypeTuple args = (TypeTuple) _symbol_args.value;
					 return new TypeFunct(id, args, new TypeVoid());
				}
			},
			new Action() {	// [48] procedure_head = TOKEN_FUNCTION TOKEN_IDENTIFIER.id TOKEN_LPAR argt_part.args TOKEN_RPAR TOKEN_COLON type.ret_type
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 2];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_args = _symbols[offset + 4];
					final TypeTuple args = (TypeTuple) _symbol_args.value;
					final Symbol _symbol_ret_type = _symbols[offset + 7];
					final Type ret_type = (Type) _symbol_ret_type.value;
					 return new TypeFunct(id, args, ret_type);
				}
			},
			new Action() {	// [49] argt_part = 
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 stackEnv.addNewScope(new NodeList(), false); return new TypeTuple();
				}
			},
			new Action() {	// [50] argt_part = argt_list.list
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					 stackEnv.addNewScope(list, false); // Registers identifiers.
															   TypeTuple tuple = new TypeTuple(); // Creates the TypeList
															   Iterator<Node> it = list.iterator();
															   while(it.hasNext()) tuple.add(new TypeFeature("", ((NodeId)it.next()).getType()));
															   return tuple;
				}
			},
			new Action() {	// [51] argt_list = argt_list.list TOKEN_COMMA argt.node
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					final Symbol _symbol_node = _symbols[offset + 3];
					final NodeId node = (NodeId) _symbol_node.value;
					 list.add(node); return list;
				}
			},
			new Action() {	// [52] argt_list = argt.node
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node = _symbols[offset + 1];
					final NodeId node = (NodeId) _symbol_node.value;
					 return new NodeList(node);
				}
			},
			new Action() {	// [53] argt = TOKEN_IDENTIFIER.id TOKEN_COLON type.t
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Type t = (Type) _symbol_t.value;
					 return new NodeId(id, t);
				}
			},
			new Action() {	// [54] block = variable_declaration_part TOKEN_BEGIN statement_list.stm TOKEN_END
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_stm = _symbols[offset + 3];
					final NodeList stm = (NodeList) _symbol_stm.value;
					 return stm;
				}
			},
			new Action() {	// [55] statement_list = statement_list.list statement.elt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					final Symbol _symbol_elt = _symbols[offset + 2];
					final Node elt = (Node) _symbol_elt.value;
					 list.add(elt); return list;
				}
			},
			new Action() {	// [56] statement_list = statement.elt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_elt = _symbols[offset + 1];
					final Node elt = (Node) _symbol_elt.value;
					 NodeList list = new NodeList(); list.add(elt); return list;
				}
			},
			Action.RETURN,	// [57] statement = simple_statement
			Action.RETURN,	// [58] statement = structured_statement
			Action.RETURN,	// [59] simple_statement = assignment_statement
			Action.RETURN,	// [60] simple_statement = procedure_statement
			Action.RETURN,	// [61] simple_statement = new_statement
			Action.RETURN,	// [62] simple_statement = dispose_statement
			Action.RETURN,	// [63] simple_statement = println_statement
			Action.RETURN,	// [64] simple_statement = readln_statement
			Action.RETURN,	// [65] simple_statement = return_statement
			new Action() {	// [66] assignment_statement = variable_access.var TOKEN_AFF expression.expr TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_var = _symbols[offset + 1];
					final NodeExp var = (NodeExp) _symbol_var.value;
					final Symbol _symbol_expr = _symbols[offset + 3];
					final NodeExp expr = (NodeExp) _symbol_expr.value;
					 return new NodeAssign(var, expr);
				}
			},
			RETURN2,	// [67] procedure_statement = procedure_expression TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			new Action() {	// [68] procedure_expression = TOKEN_IDENTIFIER.id TOKEN_LPAR expression_part.args TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_args = _symbols[offset + 3];
					final NodeList args = (NodeList) _symbol_args.value;
					 TypeFunct decl = funcEnv.get(id).declaration;
																			   return new NodeCallFct(id, decl, args);
				}
			},
			new Action() {	// [69] expression_part = 
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new NodeList();
				}
			},
			new Action() {	// [70] expression_part = expression_list.list
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					 return list;
				}
			},
			new Action() {	// [71] expression_list = expression_list.list TOKEN_COMMA expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 list.add(e); return list;
				}
			},
			new Action() {	// [72] expression_list = expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 1];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return new NodeList(e);
				}
			},
			RETURN3,	// [73] new_statement = TOKEN_NEW variable_access TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			RETURN3,	// [74] dispose_statement = TOKEN_DISPOSE variable_access TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			RETURN3,	// [75] println_statement = TOKEN_PRINTLN expression TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			RETURN3,	// [76] readln_statement = TOKEN_READLN expression TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			RETURN3,	// [77] return_statement = TOKEN_RETURN expression TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			Action.RETURN,	// [78] structured_statement = block
			Action.RETURN,	// [79] structured_statement = if_statement
			Action.RETURN,	// [80] structured_statement = while_statement
			Action.RETURN,	// [81] structured_statement = switch_statement
			new Action() {	// [82] if_statement = TOKEN_IF expression.expr TOKEN_THEN statement.stm
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expr = _symbols[offset + 2];
					final NodeExp expr = (NodeExp) _symbol_expr.value;
					final Symbol _symbol_stm = _symbols[offset + 4];
					final Node stm = (Node) _symbol_stm.value;
					 return new NodeIf(expr, stm);
				}
			},
			new Action() {	// [83] if_statement = TOKEN_IF expression.expr TOKEN_THEN statement.stm1 TOKEN_ELSE statement.stm2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expr = _symbols[offset + 2];
					final NodeExp expr = (NodeExp) _symbol_expr.value;
					final Symbol _symbol_stm1 = _symbols[offset + 4];
					final Node stm1 = (Node) _symbol_stm1.value;
					final Symbol _symbol_stm2 = _symbols[offset + 6];
					final Node stm2 = (Node) _symbol_stm2.value;
					 return new NodeIf(expr, stm1,stm2);
				}
			},
			new Action() {	// [84] while_statement = TOKEN_WHILE expression.expr TOKEN_DO statement.stm
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expr = _symbols[offset + 2];
					final NodeExp expr = (NodeExp) _symbol_expr.value;
					final Symbol _symbol_stm = _symbols[offset + 4];
					final Node stm = (Node) _symbol_stm.value;
					 return new NodeWhile(expr, stm);
				}
			},
			new Action() {	// [85] switch_statement = TOKEN_SWITCH expression.expr TOKEN_BEGIN case_statement_list.stm TOKEN_END
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expr = _symbols[offset + 2];
					final NodeExp expr = (NodeExp) _symbol_expr.value;
					final Symbol _symbol_stm = _symbols[offset + 4];
					final NodeList stm = (NodeList) _symbol_stm.value;
					 return new NodeSwitch(expr, stm);
				}
			},
			new Action() {	// [86] case_statement_list = case_statement_list.list case_statement.elt case_default.dft
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					final Symbol _symbol_elt = _symbols[offset + 2];
					final NodeCaseList elt = (NodeCaseList) _symbol_elt.value;
					final Symbol _symbol_dft = _symbols[offset + 3];
					final NodeCase dft = (NodeCase) _symbol_dft.value;
					 list.add(elt); list.add(dft); return list;
				}
			},
			new Action() {	// [87] case_statement_list = case_statement.elt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_elt = _symbols[offset + 1];
					final NodeCaseList elt = (NodeCaseList) _symbol_elt.value;
					 NodeList list = new NodeList(); list.add(elt); return list;
				}
			},
			new Action() {	// [88] case_statement = TOKEN_CASE identifier_list.idlist TOKEN_COLON statement.stm
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_idlist = _symbols[offset + 2];
					final IdentifierListSymbol idlist = (IdentifierListSymbol) _symbol_idlist.value;
					final Symbol _symbol_stm = _symbols[offset + 4];
					final Node stm = (Node) _symbol_stm.value;
					 NodeCaseList list = new NodeCaseList(); for(String id : idlist.getList()){list.add(new NodeCase(id,stm));} return list;
				}
			},
			new Action() {	// [89] case_default = 
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new NodeCase(null);
				}
			},
			new Action() {	// [90] case_default = TOKEN_DEFAULT TOKEN_COLON statement.stm
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_stm = _symbols[offset + 3];
					final Node stm = (Node) _symbol_stm.value;
					 return new NodeCase(stm);
				}
			},
			new Action() {	// [91] variable_access = TOKEN_IDENTIFIER.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					 System.out.println("Asked for " + id + "."); return stackEnv.get(id);
				}
			},
			new Action() {	// [92] variable_access = variable_access.id TOKEN_LBRACKET expression.exp TOKEN_RBRACKET
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final NodeExp id = (NodeExp) _symbol_id.value;
					final Symbol _symbol_exp = _symbols[offset + 3];
					final NodeExp exp = (NodeExp) _symbol_exp.value;
					 return new NodeArrayAccess(id,exp);
				}
			},
			RETURN2,	// [93] variable_access = expression TOKEN_CIRC; returns 'TOKEN_CIRC' although none is marked
			new Action() {	// [94] expression = expression.e1 TOKEN_PLUS expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("plus",e1, e2);
				}
			},
			new Action() {	// [95] expression = expression.e1 TOKEN_MINUS expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("minus",e1, e2);
				}
			},
			new Action() {	// [96] expression = expression.e1 TOKEN_TIMES expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("times",e1, e2);
				}
			},
			new Action() {	// [97] expression = expression.e1 TOKEN_DIV expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("division",e1, e2);
				}
			},
			new Action() {	// [98] expression = TOKEN_MINUS expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return new NodeOp("minus",e);
				}
			},
			new Action() {	// [99] expression = expression.e1 TOKEN_OR expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("or", e1, e2);
				}
			},
			new Action() {	// [100] expression = expression.e1 TOKEN_AND expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("and", e1, e2);
				}
			},
			new Action() {	// [101] expression = TOKEN_NOT expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return new NodeRel("not", e);
				}
			},
			new Action() {	// [102] expression = expression.e1 TOKEN_LT expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("lesser_than", e1, e2);
				}
			},
			new Action() {	// [103] expression = expression.e1 TOKEN_LE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("lesser_or_equal", e1, e2);
				}
			},
			new Action() {	// [104] expression = expression.e1 TOKEN_GT expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("greater_than", e1, e2);
				}
			},
			new Action() {	// [105] expression = expression.e1 TOKEN_GE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("great_or_equal", e1, e2);
				}
			},
			new Action() {	// [106] expression = expression.e1 TOKEN_EQ expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("equal", e1, e2);
				}
			},
			new Action() {	// [107] expression = expression.e1 TOKEN_NE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("not_equal", e1, e2);
				}
			},
			new Action() {	// [108] expression = TOKEN_LPAR expression.e TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return e;
				}
			},
			new Action() {	// [109] expression = procedure_expression.funcCall
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_funcCall = _symbols[offset + 1];
					final NodeCallFct funcCall = (NodeCallFct) _symbol_funcCall.value;
					 return funcCall;
				}
			},
			Action.RETURN,	// [110] expression = variable_access
			Action.RETURN,	// [111] expression = literal
			new Action() {	// [112] literal = TOKEN_LIT_INTEGER.literal
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_literal = _symbols[offset + 1];
					final Integer literal = (Integer) _symbol_literal.value;
					 return new NodeLiteral(new TypeInt(literal), literal);
				}
			},
			new Action() {	// [113] literal = TOKEN_LIT_STRING.literal
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_literal = _symbols[offset + 1];
					final String literal = (String) _symbol_literal.value;
					 return new NodeLiteral(new TypeString(), literal);
				}
			},
			new Action() {	// [114] literal = TOKEN_TRUE.literal
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_literal = _symbols[offset + 1];
					final Boolean literal = (Boolean) _symbol_literal.value;
					 return new NodeLiteral(new TypeBoolean(), literal);
				}
			},
			new Action() {	// [115] literal = TOKEN_FALSE.literal
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_literal = _symbols[offset + 1];
					final Boolean literal = (Boolean) _symbol_literal.value;
					 return new NodeLiteral(new TypeBoolean(), literal);
				}
			},
			new Action() {	// [116] literal = TOKEN_NULL.literal
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_literal = _symbols[offset + 1];
					final Object literal = (Object) _symbol_literal.value;
					 return new NodeLiteral(new TypePointer(), literal);
				}
			}
		};


	report = new Events();
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
