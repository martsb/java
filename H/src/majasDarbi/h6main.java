package majasDarbi;

public class h6main {

	public static void main(String[] args) {
		Shop s1 = new Shop("bread", true);
		Shop s2 = new Shop("milk", true);
		Shop s3 = new Shop("chocolate", false);
		Shop s4 = new Shop("cheese", true);
		Shop s5 = new Shop("cheese_cake", false);
		s1.addPrice(20.23);
		s2.addPrice(14.53);
		s3.addPrice(43.51);
		s4.addPrice(143.02);
		s5.addPrice(4.10);
		
		Shop.find("cheese");
		System.out.println("All products: " + Shop.getProductList());
		Shop.healthyProductPrcnt();
	}

}
