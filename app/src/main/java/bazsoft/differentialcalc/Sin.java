package bazsoft.differentialcalc;
public class Sin implements Expression{
	private Expression f;
	private boolean derived=false;
	public Sin(Expression x){
	f = x;
	}
	public boolean isDerived() {
		return derived;
	}
	public void setDerived(boolean derived) {
		this.derived = derived;
	}
	public Expression derive() {
		
		Cos deriv = new Cos(f);

	return new Product(f.derive(),deriv);
	}
	public double evaluate(double a) {
	return(Math.sin(a));
	}
	public String toString() {
		if(derived==true)
		{
			return("-sin("+f+")");
		}
	return ("sin("+f+")");
		
	}


}