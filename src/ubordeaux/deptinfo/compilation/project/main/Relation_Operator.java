package ubordeaux.deptinfo.compilation.project.main;

public enum Relation_Operator {
    EQ("="),
    NE("!="),
    LT("<"),
    GT(">"),
    LE("<="),
    GE(">=")
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
