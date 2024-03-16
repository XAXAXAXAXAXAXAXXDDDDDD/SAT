package uebung01;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOHelper {

	private static Scanner inputScanner;
	
	private InputStream input;
	private PrintStream output;
	private PrintStream err;
	
	public IOHelper(InputStream inputStream, PrintStream outputStream, PrintStream errorStream) {
		input = inputStream;
		output = outputStream;
		err = errorStream;

		inputScanner = new Scanner(this.input);
	}
	
	void WriteToOutput(String text) {
		output.println(text);
	}
	
	void WriteToError(String text) {
		err.println(text);
	}
	
	String ReadTextFromInput() {
		return inputScanner.next();
	}
	
	int ReadIntFromInput() {
		return inputScanner.nextInt();
	}
	
	/**
	 * @param text -> Bildschirmausgabe
	 * @return Tastatureingabe
	 */
	int eingabeInt(String text) {
		this.WriteToOutput(text);

		return this.ReadIntFromInput();
	}

	/**
	 * @param text -> Bildschirmausgabe
	 * @return -> Tastatureingabe
	 */
	String eingabeString(String text) {
		this.WriteToOutput(text);

		return this.ReadTextFromInput();
	}
}
