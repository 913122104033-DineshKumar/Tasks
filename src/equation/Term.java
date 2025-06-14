package equation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Term {
    private int coefficient;
    private List<Variables> variables;

    public Term(int coefficient, List<Variables> variables) {
        this.coefficient = coefficient;
        variables.sort(new Comparator<Variables>() {
            @Override
            public int compare(Variables v1, Variables v2) {
                return Character.compare(v1.getVariable(), v2.getVariable());
            }
        });
        this.variables = variables;
    }

    public String createKey() {
        StringBuilder ans = new StringBuilder();
        for (Variables var : this.variables) {
            ans.append(var.toString());
        }
        return ans.toString();
    }

    public Term multiply(Term term) {
        List<Variables> var = new ArrayList<>();
        List<Variables> var1 = this.variables;
        List<Variables> var2 = term.variables;
        int i = 0, j = 0;
        while (i < var1.size() && j < var2.size()) {
            if (var1.get(i).getVariable() != var2.get(j).getVariable()) {
                break;
            }
            var.add((var1.get(i)).addPower(var2.get(j)));
            i++;
            j++;
        }
        while (i < var1.size()) {
            var.add(var1.get(i));
            i++;
        }
        while (j < var2.size()) {
            var.add(var2.get(j));
            j++;
        }
        return new Term(this.coefficient * term.coefficient, var);
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public List<Variables> getVariables() {
        return variables;
    }

    public void setVariables(List<Variables> variables) {
        this.variables = variables;
    }

    public String toString () {
        StringBuilder ans = new StringBuilder();
        if (this.coefficient < 0) {
            ans.append('-');
        } else {
            ans.append('+');
        }
        ans.append(this.coefficient);
        for (Variables v : this.variables) {
            ans.append(v.toString());
        }
        ans.append(" ");
        return ans.toString();
    }

}
