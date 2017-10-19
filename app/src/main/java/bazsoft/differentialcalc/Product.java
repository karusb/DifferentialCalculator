package bazsoft.differentialcalc;
public class Product implements Expression{
	private Expression f;
	private Expression g;
	public Product(Expression x,Expression y){
	f = x;
	g = y;
	}
	public Expression derive() {

	Expression first = new Product (f,g.derive());
	Expression second = new Product (g,f.derive());

	return new Sum(first,second);
	}
	public double evaluate(double a) {
		double sum = f.evaluate(a) * g.evaluate(a);
		return sum;
	}
	public String toString() {
	return ("("+g.toString() +"*"+f.toString()+")");
		
	}


}