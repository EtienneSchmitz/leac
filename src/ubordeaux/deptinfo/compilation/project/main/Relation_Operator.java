package ubordeaux.deptinfo.compilation.project.main;

public enum Relation_Operator {
    EQ("="),
    NEQ("!="),
    LT("<"),
    GT(">"),
    LE("<="),
    GE(">="),
    NOT("!"),
    AND("&&"),
    OR("||")
    ;
    private String name = "";

    //Constructeur
    Relation_Operator(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
