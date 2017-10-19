package bazsoft.differentialcalc;

public interface Expression {
public double evaluate(double a);
public Expression derive();
    //public Expression integrate();
}