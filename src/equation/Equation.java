package equation;

import java.util.*;

public class Equation {

    private final List<Term> terms;

    public Equation (List<Term> terms) {
        this.terms = terms;
    }

    public static Equation parse (String input) {
        input = input.replace(" ", "").replaceAll("(?=[+-])", " ");
        List<Term> term = new ArrayList<>();
        for (String s : input.trim().split(" ")) {
            int ind = 0;
            int n = s.length();
            int coeff = 1;
            if (s.startsWith("-")) {
                coeff = -1;
                ind++;
            } else if (s.startsWith("+")) {
                ind++;
            }
            int start = ind;
            List<Variables> variables = new ArrayList<>();
            while (ind < n && s.charAt(ind) >= '0' && s.charAt(ind) <= '9') {
                ind++;
            }
            coeff *= (ind - start + 1 == 1) ? 1 : Integer.parseInt(s.substring(start, ind));
            while (ind < n) {
                int power = (ind + 1 < n) ?  s.charAt(ind + 1) - '0' : 1;
                Variables var = new Variables(s.charAt(ind), power);
                variables.add(var);
                ind += 2;
            }
            term.add(new Term(coeff, variables));
        }
        return new Equation(term);
    }

    public Equation multiply (Equation eq) {
        Map<String, Integer> values = new HashMap<>();
        Map<String, Term> references = new HashMap<>();
        for (int i = 0; i < this.terms.size(); i++) {
            Term term1 = this.terms.get(i);
            for (int j = 0; j < eq.terms.size(); j++) {
                Term term2 = eq.terms.get(j);
                Term ans = term1.multiply(term2);
                String key = ans.createKey();
                values.put(key, values.getOrDefault(key, 0) + ans.getCoefficient());
                references.put(key, ans);
            }
        }
        List<Term> finalTerm = addToAnswer(values, references);
        return new Equation(finalTerm);
    }

    private List<Term> addToAnswer(Map<String, Integer> values, Map<String, Term> references) {
        List<Term> ans = new ArrayList<>();
        for (String key : values.keySet()) {
            Term term = references.get(key);
            ans.add(new Term(values.get(key), term.getVariables()));
        }
        return ans;
    }

    public String toString () {
        StringBuilder ans = new StringBuilder();
        for (Term t : this.terms) {
            ans.append(t.toString());
        }
        return ans.toString();
    }

}
