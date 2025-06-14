package equation;

public class Variables {
    private char variable;
    private int power;

    public Variables(char variable, int power) {
        this.variable = variable;
        this.power = power;
    }

    public Variables addPower(Variables var) {
        int pow = this.power + var.power;
        return new Variables(this.variable, pow);
    }

    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(this.variable).append("^");
        ans.append(this.power == 1 ? "" : this.power);
        return ans.toString();
    }

    public char getVariable() {
        return variable;
    }

    public void setVariable(char variable) {
        this.variable = variable;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
