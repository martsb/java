package r;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Weber {
	
	static Document getPage(String url) {
		System.out.println("GET: " +url);
		pause(300);
		try {
			return Jsoup.connect(url).timeout(10000).get();
		} catch (Exception e) {
			System.out.println("Error on " +url);
			e.printStackTrace();
		}
		return null;
	}
	
	static String postPage(String url, String payload) {
		System.out.println("POST: " +url);
		pause(300);
		try {
			return Jsoup.connect(url)
				.timeout(10000)
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
				.header("Accept", "application/json, text/javascript, */*; q=0.01")
				.userAgent("Whatever we want")
				.ignoreContentType(true)
				.requestBody(payload)
				.post()
				.body()
				.text();
		} catch (Exception e) {
			System.out.println("Error on " +url);
			e.printStackTrace();
		}
		return null;
	}
	
	static void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {}
	}
}
