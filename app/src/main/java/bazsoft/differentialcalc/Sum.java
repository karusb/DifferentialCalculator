package bazsoft.differentialcalc;
public class Sum implements Expression{
	private Expression f;
	private Expression g;
	public Sum(Expression x,Expression y){
	f = x;
	g = y;
	}
	public Expression derive() {
	Expression sumx = f.derive();
	Expression sumy = g.derive();


//	System.out.println("AL AQ" + f.getClass());
//	System.out.println("AL AQ" + g.getClass());
//	if(f.getClass().getName() == "Variable");
//	double ercan = Double.parseDouble(sumx.toString());
//	double erman = Double.parseDouble(sumy.toString());
	
//	if(f.getClass().getName() == "Variable");
//	{
//		right = new Variable(ercan);
//	}
//	if(f.getClass().getName() == "Constant")
//	{
//		right = new Constant(ercan);
//	}
//	if(g.getClass().getName() == "Variable");
//	{
//		left = new Variable(erman);
//	}
//	if(g.getClass().getName() == "Constant")s
//	{
//		left = new Constant(erman);
//	}
	return new Sum(sumx,sumy);
	}
	public double evaluate(double a) {
	double sum = f.evaluate(a) + g.evaluate(a);
	return sum;
	}
	public String toString() {
	return (g.toString() +" + " +f.toString());
		
	}


}
