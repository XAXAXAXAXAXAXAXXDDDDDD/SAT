package command;

import java.awt.BorderLayout;
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

public class TaschenrechnerView extends JFrame implements Observer {

	CommandProcessor taschenrechnerSteuerung;
	ICommand currentCommand;
	Taschenrechner t;
	boolean firstTParam = true;

	JButton eins, zwei, drei, vier, fuenf, sechs, sieben, acht, neun, nul, slash, mal, minus, punkt, gleich, plus, undo,
			redo;
	JLabel resultLabel;
	NumberHandler nHandler = new NumberHandler();
	OpHandler opHandler = new OpHandler();
	String input = new String();

	public TaschenrechnerView(Taschenrechner t) {
		this.taschenrechnerSteuerung = new CommandProcessor();

		this.t = t;
		this.t.addObserver(this);
		resultLabel = new JLabel("0.", SwingConstants.RIGHT);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5, 4));

		sieben = new JButton("7");
		sieben.addActionListener(nHandler);

		p.add(sieben);
		acht = new JButton("8");
		acht.addActionListener(nHandler);
		p.add(acht);
		neun = new JButton("9");
		neun.addActionListener(nHandler);
		p.add(neun);
		slash = new JButton("/");
		slash.addActionListener(opHandler);
		p.add(slash);
		vier = new JButton("4");
		vier.addActionListener(nHandler);
		p.add(vier);
		fuenf = new JButton("5");
		fuenf.addActionListener(nHandler);
		p.add(fuenf);
		sechs = new JButton("6");
		p.add(sechs);
		sechs.addActionListener(nHandler);
		mal = new JButton("*");
		mal.addActionListener(opHandler);
		p.add(mal);
		eins = new JButton("1");
		eins.addActionListener(nHandler);
		p.add(eins);
		zwei = new JButton("2");
		zwei.addActionListener(nHandler);
		p.add(zwei);
		drei = new JButton("3");
		drei.addActionListener(nHandler);
		p.add(drei);
		minus = new JButton("-");
		minus.addActionListener(opHandler);
		p.add(minus);
		// UNDO hinzufügen
		undo = new JButton("undo");
		undo.addActionListener(opHandler);
		p.add(undo);
		nul = new JButton("0");
		nul.addActionListener(nHandler);
		p.add(nul);
		// REDO hinzufügen
		redo = new JButton("redo");
		redo.addActionListener(opHandler);
		p.add(redo);
		plus = new JButton("+");
		plus.addActionListener(opHandler);
		p.add(plus);

		gleich = new JButton("=");
		gleich.addActionListener(opHandler);
		p.add(gleich);

		this.add(resultLabel, BorderLayout.NORTH);
		this.add(p, BorderLayout.SOUTH);

		setSize(300, 400);
		this.pack();
		this.setVisible(true);

	}

	public void setResultLabel(double result) {
		long l = (long) result;
		if (new Double(result).compareTo(new Double(l)) == 0)
			resultLabel.setText(String.valueOf(l));
		else
			resultLabel.setText(String.valueOf(result));
	}

	class NumberHandler implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Object o = a.getSource();

			if (o == nul) {
				input += "0";
				if (input.contains(".")) {
					resultLabel.setText(input);
				}
			}

			if (o == eins)
				input += "1";
			if (o == zwei)
				input += "2";
			if (o == drei)
				input += "3";
			if (o == vier)
				input += "4";
			if (o == fuenf)
				input += "5";
			if (o == sechs)
				input += "6";
			if (o == sieben)
				input += "7";
			if (o == acht)
				input += "8";
			if (o == neun)
				input += "9";

			if (firstTParam) {
				t.setLastOp(Double.parseDouble(input));
			} else {
				t.setOperand(input);
			}

			if (currentCommand != null) {
				taschenrechnerSteuerung.befehlAusfuehren(currentCommand);
				currentCommand = null;
				setResultLabel(t.getResult());
			} else {
				setResultLabel(Double.parseDouble(input));
			}

		}
	}

	class OpHandler implements ActionListener {
		public void actionPerformed(ActionEvent a) {

			Object o = a.getSource();

			if (o == slash) {
				currentCommand = new DivideCommand(t);
			}
			if (o == mal) {
				currentCommand = new MultiplyCommand(t);
			}
			if (o == minus) {
				currentCommand = new SubtractCommand(t);
			}
			if (o == plus) {
				currentCommand = new AddCommand(t);
			}

			if (o == gleich)
				setResultLabel(t.getResult());
			if (o == undo)
				taschenrechnerSteuerung.undoLetztenBefehl();
			if (o == redo)
				taschenrechnerSteuerung.redoLetztenBefehl();

			input = "";
			firstTParam = false;
		}
	}

	public void update(Observable ob, Object o) {
		setResultLabel(t.getResult());
	}
}
