package bazsoft.differentialcalc;
public class Cos implements Expression{
	private Expression f;
	private boolean derived=false;
	public Cos(Expression x){
	f = x;
	}
	public boolean isDerived() {
		return derived;
	}
	public void setDerived(boolean derived) {
		this.derived = derived;
	}
	public Expression derive() {
	Sin sind = new Sin(f);
	Expression minuschange = new Product(f.derive(),sind);
	return new Product(minuschange,new Constant(-1.0));
	}
	public double evaluate(double a) {
	return(Math.cos(a));
	}
	public String toString() {
	if(derived==true)
	{
		return("-cos("+f+")");
	}
	return ("cos("+f+")");
		
	}


}