package ubordeaux.deptinfo.compilation.project.node;

import java.util.Map;

import ubordeaux.deptinfo.compilation.project.environment.FunctionEnvironment;
import ubordeaux.deptinfo.compilation.project.environment.TypeEnvironment;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;
import ubordeaux.deptinfo.compilation.project.intermediateCode.StmList;
import ubordeaux.deptinfo.compilation.project.main.ClonableSymbol;
import ubordeaux.deptinfo.compilation.project.main.CompilationException;

public class NodeMain extends Node {

	private TypeEnvironment typeEnv;
	private FunctionEnvironment funcEnv;
	
	public NodeMain(TypeEnvironment typeEnv,
					NodeList variableDecl,
					FunctionEnvironment funcEnv,
					NodeList statements) {
		super();
		
		if(typeEnv == null || variableDecl == null || 
				funcEnv == null || statements == null) 
		{
			CompilationException.halt("One or many of : type_decl / variable_decl / function_decl / statements are null when creating the main node.");
		}
		
		this.add(variableDecl);
		this.add(statements);
		
		this.typeEnv = typeEnv;
		this.funcEnv = funcEnv;
	}
	
	public NodeList getVariableDeclaration() {
		return (NodeList)this.get(0);
	}
	
	public NodeList getStatements() {
		return (NodeList)this.get(1);
	}
	
	public TypeEnvironment getTypeEnvironment() {
		return this.typeEnv;
	}
	
	public FunctionEnvironment getFunctionEnvironment() {
		return this.funcEnv;
	}
	
	@Override
	public ClonableSymbol clone() {
		return new NodeMain(getTypeEnvironment(),
				            getVariableDeclaration(),
				            getFunctionEnvironment(),
				            getStatements());
	}

	@Override
	public boolean checksType() {
		return getStatements().checksType();
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		StmList list = null;
		
		for(Map.Entry<String, NodeFunction> pair : getFunctionEnvironment().getAll()) {
			if(pair.getValue().isDefined()) {
				list = new StmList((Stm)pair.getValue().getDefinition().generateIntermediateCode(), list);
			}
		}
		
		return new StmList((Stm)getStatements().generateIntermediateCode(), list);
	}
}
