package commandpattern;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator t = new Calculator();
		CalculatorView tv = new CalculatorView(t);

		// TaschenrechnerView tv2 = new TaschenrechnerView(t);
		CalculatorController tc = new CalculatorController(t, tv);
	}

}
