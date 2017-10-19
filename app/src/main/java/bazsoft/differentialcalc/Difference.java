package bazsoft.differentialcalc;
public class Difference implements Expression{
	private Expression f;
	private Expression g;
	public Difference(Expression x,Expression y){
	f = x;
	g = y;
	}
	public Expression derive() {
	Expression sumx = f.derive();
	Expression sumy = g.derive();
//	double ercan = Double.parseDouble(sumx.toString());
//	double erman = Double.parseDouble(sumy.toString());
//	Expression right = new Constant(ercan);
//	Expression left = new Variable(erman);
	return new Difference(sumx,sumy);
	}
	public double evaluate(double a) {
		double sum = f.evaluate(a) - g.evaluate(a);
		return sum;
	}
	public String toString() {
	return (f.toString() +" - " +g.toString());
		
	}


}