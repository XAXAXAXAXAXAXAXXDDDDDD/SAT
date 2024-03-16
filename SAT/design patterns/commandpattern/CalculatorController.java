package commandpattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorController {

	Calculator calc; // model
	CalculatorView view; // view
	NumberHandler nHandler = new NumberHandler();
	OpHandler opHandler = new OpHandler();
	String input = "";

	public CalculatorController(Calculator t, CalculatorView view) {

		this.calc = t;
		this.view = view;

		view.sieben.addActionListener(nHandler);
		view.acht.addActionListener(nHandler);
		view.neun.addActionListener(nHandler);
		view.vier.addActionListener(nHandler);
		view.fuenf.addActionListener(nHandler);
		view.sechs.addActionListener(nHandler);
		view.eins.addActionListener(nHandler);
		view.zwei.addActionListener(nHandler);
		view.drei.addActionListener(nHandler);
		view.nul.addActionListener(nHandler);
		view.punkt.addActionListener(nHandler);
		
		view.mult.addActionListener(opHandler);
		view.minus.addActionListener(opHandler);
		view.div.addActionListener(opHandler);
		view.gleich.addActionListener(opHandler);
		view.plus.addActionListener(opHandler);
		view.undo.addActionListener(opHandler);
		view.rezi.addActionListener(opHandler);
		view.clear.addActionListener(opHandler);
		view.pi.addActionListener(opHandler);
	}

	class NumberHandler implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Object o = a.getSource();

			if (o == view.nul) {
				input += "0";
				if (input.contains(".")) {
					// System.out.println("i:" + input);
					view.resultLabel.setText(input);
				}
			}
			if (o == view.eins)
				input += "1";
			if (o == view.zwei)
				input += "2";
			if (o == view.drei)
				input += "3";
			if (o == view.vier)
				input += "4";
			if (o == view.fuenf)
				input += "5";
			if (o == view.sechs)
				input += "6";
			if (o == view.sieben)
				input += "7";
			if (o == view.acht)
				input += "8";
			if (o == view.neun)
				input += "9";

			if (o == view.punkt) {

				if (input.equals(""))
					input += "0.";
				else {
					if (input.charAt(input.length() - 1) != '.') {
						input += ".";
					}
				}
			}

			// System.out.println("i=" + input);
			// t.setOperand(Double.parseDouble(input));
			view.setResultLabel(Double.parseDouble(input));

		}
	}

	class OpHandler implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Object o = a.getSource();
			if (!input.equals("")) {
				calc.setOperand(Double.parseDouble(input));
				input = "";
			}
			
			Command cmd = null;

			if (o == view.mult) {
				cmd = new MultiplyCommand(calc);
				calc.execCommand(cmd);
			}
			
			if (o == view.div) {
				cmd = new DivisionCommand(calc);
				calc.execCommand(cmd);
			}
			
			if (o == view.plus) {
				cmd = new AdditionCommand(calc);
				calc.execCommand(cmd);
			}
			
			if (o == view.minus) {
				cmd = new SubtractionCommand(calc);
				calc.execCommand(cmd);
			}
			if (o == view.pi) {
				cmd = new PiCommand(calc);
				calc.execCommand(cmd);
			}
			
			if (o == view.rezi) {
				cmd = new ReziprokCommand(calc);
				calc.execCommand(cmd);
			}
			
			if (o == view.gleich)
				calc.equalsResult();
			
			if (o == view.undo)
				calc.undo();

			
			if (o == view.clear)
				calc.clearAll();

		}
	}

}
