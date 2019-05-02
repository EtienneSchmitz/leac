package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class StmExp extends Exp {

    Stm stm;

    public StmExp(Stm stm) {
        this.stm = stm;
    }

    @Override
    public String toString() {
        return stm.toString();
    }
}
