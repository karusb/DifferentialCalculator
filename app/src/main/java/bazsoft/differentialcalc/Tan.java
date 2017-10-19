package bazsoft.differentialcalc;
public class Tan implements Expression {
	private Expression f;
	public Tan(Expression x){
	f = x;
	}
	public Expression derive() {
		Expression quot = new Quotient(new Sin(f),new Cos(f));
		Expression dquot = quot.derive();
	return dquot;
	}
	public double evaluate(double a) {
	return(Math.tan(a));
	}
	public String toString() {

	return ("tan("+f+")");
		
	}


}