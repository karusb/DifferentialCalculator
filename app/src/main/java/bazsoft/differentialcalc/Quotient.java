package bazsoft.differentialcalc;
public class Quotient implements Expression{
	private Expression f;
	private Expression g;
//	private boolean derived = false;
	public Quotient(Expression x,Expression y){
	f = x;
	g = y;
	}
	public Expression derive() {

	Expression first = new Product (f,g.derive());
	Expression second = new Product (g,f.derive());
	Expression diff = new Difference (second,first);
    Quotient result = new Quotient (diff,new Pwr(g,2));
//    result.setDerived(true);
	return result;
	}
//	public void setDerived(boolean f)
//	{
//		this.derived = f;
//	}
	public double evaluate(double a) {
		double sum = f.evaluate(a) / g.evaluate(a);
		return sum;
	}
	public String toString() {
//		if(this.derived == true)
//		{
//			return ("("+f.toString() +"/("+g.toString()+")^2)");
//		}
	return ("("+f.toString() +"/" +g.toString()+")");
		
	}


}