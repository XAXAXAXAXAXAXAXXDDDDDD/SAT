package chainofresponsibility;

public class Client {

	public Client() {

	}

	public static void main(String[] args) {
		// set up chain of responsibility frankierung
		Handler quarterF = new QuarterEuroFrankierungsHandler(null);
		Handler halfF = new HalfEuroFrankierungsHandler(quarterF);
		Handler oneF = new OneEuroFrankierungHandler(halfF);
		Handler textF = new FrankierungsTextHandler(oneF);

		// set up chain of responsibility order handling
		Handler hdh = new HugeDomesticHandler(textF);
		Handler sdh = new SmallDomesticHandler(hdh);
		Handler euh = new EuropeanUnionHandler(sdh);
		Handler inh = new InternationalHandler(euh);
		Handler orderHandler = new LargeDomesticHandler(inh);

		Order o1 = new Order(Adress.DOMESTIC, 1.5, 15, 10, 25);
		Order o2 = new Order(Adress.INTERNATIONAL, 35.0, 76, 70, 50);
		Order o3 = new Order(Adress.DOMESTIC, 4.5, 48, 9, 19);
		Order o4 = new Order(Adress.EUROPEAN_UNION, 9.5, 80, 100, 50);
		Order o5 = new Order(Adress.DOMESTIC, 3.5, 17, 15, 30);
		Order o6 = new Order(Adress.DOMESTIC, 29.5, 26, 15, 30);

		System.out.println(o1);
		orderHandler.handleOrder(o1);
		System.out.print(System.lineSeparator());

		System.out.println(o2);
		orderHandler.handleOrder(o2);
		System.out.print(System.lineSeparator());

		System.out.println(o3);
		orderHandler.handleOrder(o3);
		System.out.print(System.lineSeparator());

		System.out.println(o4);
		orderHandler.handleOrder(o4);
		System.out.print(System.lineSeparator());

		System.out.println(o5);
		orderHandler.handleOrder(o5);
		System.out.print(System.lineSeparator());

		System.out.println(o6);
		orderHandler.handleOrder(o6);
		System.out.print(System.lineSeparator());
	}

}
