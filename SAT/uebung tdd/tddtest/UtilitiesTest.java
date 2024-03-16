package tddtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tdd.Utilities;

class UtilitiesTest {

	// ---------------------- Test Cases Exercise B ----------------------
	/*
	 * These Test Cases have been written by us
	 */
	@Test
	public void bTestStringEmpty() {
		// Test1: String ist leer
		String s = "";
		String expected = null;
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTestConvertSpecialCharacterInString() {
		// Test2: wandel von ?, &, # in String
		String s = "t?e&s#t";
		String expected = "tqmeampshasht";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTtestConvertSpecialCharacterInMinus() {
		// Test3: Buchstaben, Leer-/und Sonderzeichen in "-"
		String s = "aäuüoöe e€e";
		String expected = "a-u-o-e-e-e";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTestNoConsecutiveMinus() {
		// Test4: keine aufeinanderfolgenden Minuszeichen (2 hintereinander)
		String s = "abc €xy";
		String expected = "abc-xy";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTestMultipleConsecutiveMinus() {
		// Test5: keine mehrere aufeinanderfolgenden Minuszeichen (4 Stück)
		String s = "abc €!*xy";
		String expected = "abc-xy";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTestConvertUppercaseIntoLowercase() {
		// Test6: Großbuchstaben in Kleinbuchstaben konvertieren
		String s = "HALLOwELT";
		String expected = "hallowelt";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTestRemoveFirstMinus() {
		// Test7: Minuszeichen am Anfang entfernen
		String s = "-plus";
		String expected = "plus";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTestRemoveLastMinus() {
		// Test8: Minuszeichen am Ende entfernen
		String s = "plus-";
		String expected = "plus";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTestRemoveMultipleLastMinus() {
		// Test9: mehrere Minuszeichen am Ende entfernen
		String s = "plus----------";
		String expected = "plus";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	@Test
	void bTestSuccessfulTextConversion() {
		// Test10: text erfolgreich Konvertieren (Test 1-9 zusammen)
		String s = "?Das ist meine Webseite, bei dem ich zeigen möchte wie man Programmieren lernt & dabei (viel) Spaß hat !! #vielSpaß";
		String expected = "qmdas-ist-meine-webseite-bei-dem-ich-zeigen-m-chte-wie-man-programmieren-lernt-amp-dabei-viel-spa-hat-hashvielspa";
		String output = Utilities.prepareStringForUrl(s);
		assertEquals(expected, output);
	}

	// ---------------------- Test Cases Exercise A ----------------------
	/*
	 * These Test Cases have been written by other group Im Dokument Lösung haben
	 * wir dokumentiert, was uns aufgefallen ist, beim Testen unseres Codes mit
	 * diesen Tests
	 */

	@Test
	public void aTestShorterThen140() throws Exception {

		assertOutcome(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam",
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam");

	}

	@Test
	public void aTestExact140() throws Exception {

		assertOutcome(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed",
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed");

	}

	@Test
	public void aTestLongerThen140() throws Exception {

		assertOutcome(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.",
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed...");

	}

	@Test
	public void aTestLongerThen140AndNotCutWord() throws Exception {

		assertOutcome(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat diam diam volu",
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat...");

	}

	@Test
	public void aTestLongerThen140AndNotCutWordWithComma() throws Exception {

		assertOutcome(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, diam diam volu",
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat...");

	}

	@Test
	public void aTestEmpty() throws Exception {

		assertOutcome("", "no preview possible because its empty");

	}

	@Test
	public void aTestAllJustOneString() throws Exception {

		assertOutcome(
				"fbadohfdhadfhboadbfhoadbahfhaodfbdahfabfidahfobaohfbazfhgaofbhafhabfhdsaooshdbfdhsasfgsdghshgfdgssgsfghsgjgfhhsgjfhltzutfdfgsfghgfsgfshkjzrtueweqrziutizujh",
				"fbadohfdhadfhboadbfhoadbahfhaodfbdahfabfidahfobaohfbazfhgaofbhafhabfhdsaooshdbfdhsasfgsdghshgfdgssgsfghsgjgfhhsgjfhltzutfdfgsfghgfsgfshkjzrt...");

	}

	// F�r "Blogeintr�gen oder News-Beitr�gen" deswegen bin ich von HTML
	// ausgegangen.
	@Test
	public void aTestSpecialCharacter() throws Exception {

		assertOutcome(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam er&auml;t, sed diam voluptua.",
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam er&auml;t...");

	}

	private void assertOutcome(String input, String expectedOutcome) {

		String output = Utilities.shortenText(input);
		assertTrue(output.contains(expectedOutcome), "Incorrect output: " + output);

	}

}
