package commandpattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CalculatorView extends JFrame implements Observer {

	Calculator calc;
	JButton eins, zwei, drei, vier, fuenf, sechs, sieben, acht, neun, nul, div,
			mult, minus, punkt, gleich, plus, rezi, undo, pi, clear;
	JLabel resultLabel;


	public CalculatorView(Calculator calc) {
		this.calc = calc;
		this.calc.addObserver(this);
		
		this.setTitle("Calculator Engine");
		resultLabel = new JLabel("0", SwingConstants.RIGHT);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.WHITE);
		resultLabel.setBorder(new LineBorder(Color.BLACK, 2));

		JPanel number = new JPanel();
		JPanel oppanel = new JPanel();
		number.setLayout(new GridLayout(4, 3));
		oppanel.setLayout(new GridLayout(4, 5));

		sieben = new JButton("7");
		number.add(sieben);

		acht = new JButton("8");
		number.add(acht);

		neun = new JButton("9");
		number.add(neun);

		div = new JButton("/");
		oppanel.add(div);

		vier = new JButton("4");
		number.add(vier);

		fuenf = new JButton("5");
		number.add(fuenf);

		sechs = new JButton("6");
		number.add(sechs);

		mult = new JButton("*");
		oppanel.add(mult);

		eins = new JButton("1");
		number.add(eins);

		zwei = new JButton("2");
		number.add(zwei);

		drei = new JButton("3");
		number.add(drei);

		minus = new JButton("-");
		oppanel.add(minus);

		nul = new JButton("0");
		number.add(nul);

		punkt = new JButton(".");
		number.add(punkt);

		clear = new JButton("C");
		number.add(clear);

		gleich = new JButton("=");
		oppanel.add(gleich);

		plus = new JButton("+");
		oppanel.add(plus);

		undo = new JButton("undo");
		oppanel.add(undo);

		pi = new JButton("\u03A0");
		oppanel.add(pi);

		rezi = new JButton("1/x");
		oppanel.add(rezi);

		this.add(resultLabel, BorderLayout.NORTH);
		this.add(number, BorderLayout.WEST);
		this.add(oppanel, BorderLayout.EAST);
		this.pack();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void update(Observable ob, Object o) {

		setResultLabel(calc.getResult());

	}

	public void setResultLabel(double result) {
		long l = (long) result;
		if (new Double(result).compareTo(new Double(l)) == 0)
			resultLabel.setText(String.valueOf(l));

		else
			resultLabel.setText(String.valueOf(result));
	}

}
