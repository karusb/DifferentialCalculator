package bazsoft.differentialcalc;
public class Constant implements Expression {
private double value;
public Constant(double v) {
value = v;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
public Expression derive() {
return new Constant(0.0f);
}
public double evaluate(double a) {
return value;
}
public String toString() {
return Double.toString(value);
}
}

