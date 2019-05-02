package ubordeaux.deptinfo.compilation.project.main;

import java.util.ArrayList;
import java.util.List;
import beaver.Symbol;

public class IdentifierListSymbol extends Symbol {
    private List<String> identifierList = new ArrayList<String>();

    public void add(String id) {
        identifierList.add(id);
    }
    
    public List <String> getList() {
        return identifierList;
    }
}
