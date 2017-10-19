package bazsoft.differentialcalc;
public class Pwr implements Expression{
	private Expression f;
	private int power;
	public Pwr(Expression x,int pwr){
	f = x;
	power = pwr;
	}
	public Expression derive() {

	return new Product(f.derive(),new Constant(power));
	}
	public double evaluate(double a) {
	return(Math.pow(f.evaluate(a), this.power));
	}
	public String toString() {

	return ("("+f+")"+"^"+power);
		
	}


}