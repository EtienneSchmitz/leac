package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class ExpStm extends Stm {

    Exp exp;

    public ExpStm(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return exp.toString();
    }
}
