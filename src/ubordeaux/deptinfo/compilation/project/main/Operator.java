package ubordeaux.deptinfo.compilation.project.main;

public enum Operator {
    PLUS("plus"),
    MINUS("minus"),
    TIMES("times"),
    DIVIDE("divide");

    ;

    private String name = "";

    //Constructeur
    Operator(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
