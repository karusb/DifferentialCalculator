package bazsoft.differentialcalc;
public class Variable implements Expression {
	private double value;
	private boolean derived=false;
	public Variable(double v){
	value = v;
	}
	public Expression derive() {
		Constant aq = new Constant(value*1.0f);

	return aq;
	}
	public double getValue() {
		return value;
	}
	public void setDerived() {
		this.derived = true;
	}
	public double evaluate(double a) {
	return(value*a);
	}
	public String toString() {

	return (Double.toString(value) + "x");
	}

}
