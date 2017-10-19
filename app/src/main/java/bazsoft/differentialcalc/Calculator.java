package bazsoft.differentialcalc;

import java.math.*;
import java.util.*;



public class Calculator {
public static void main(String[] args) {
Expression c = new Constant(3.0);
Expression dc = c.derive();
Expression d = new Variable(7.0);
Expression aq = d.derive();
Expression got = new Sum(new Constant(1.0),new Variable(1.0));
Expression dgot = got.derive();
Expression prod = new Product(new Variable(3.0),new Variable(1.0));
Expression dprod = prod.derive();
Expression quot = new Quotient(new Constant(1.0),new Variable(1.0));
Expression dquot = quot.derive();
Expression sin = new Sin(quot);
Expression dsin = sin.derive();
Expression cos = new Cos(got);
Expression dcos = cos.derive();
Expression tan = new Tan(new Variable(1.0));
Expression dtan = tan.derive();
double eval = 10.0;

System.out.println("The derivative of " +tan + " equals " + dtan);
System.out.println("Evaluated at " +eval + " equals " + dcos.evaluate(eval));
}
}