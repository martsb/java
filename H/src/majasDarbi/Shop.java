package majasDarbi;

import java.util.ArrayList;

public class Shop {
	String product;
	int stockPrice;
	boolean isHealthy;
	private static ArrayList<Boolean> healthyList = new ArrayList<Boolean>();
	private static ArrayList<String> productList = new ArrayList<String>();
	private ArrayList<Double> productStockPrices = new ArrayList<Double>();
	
	Shop(String product, boolean isHeathy) {
		this.product = product;
		this.isHealthy = isHeathy;
		Shop.healthyList.add(isHealthy);
		Shop.productList.add(product);
	}

	public void addPrice(double stockPrice) {
		if(stockPrice > 0) {
			this.productStockPrices.add(stockPrice);
		}
	}
	
	public static ArrayList<String> getProductList() {
		return productList;
	}
	
	public static void find(String keyWord) {
		System.out.println("Products found using keyword: " + keyWord);
		for (int i = 0; i < productList.size(); i++) {
			if(productList.get(i).contains(keyWord)) {
				System.out.println(productList.get(i));
			}
		}
	}
	
	public static void healthyProductPrcnt() {
		double count = 0;
		for (int i = 0; i < Shop.healthyList.size(); i++) {
			if(Shop.healthyList.get(i) == true) {
				count++;
			}
		}
		System.out.println("There are " + 100 * count / Shop.healthyList.size() + " % heathy food in this list!");
	}
}
