package majasDarbi;

import java.util.ArrayList;

public class InstagramPost {
	String username;
	String text;
	int likeCount;
	
	static ArrayList<InstagramPost> all = new ArrayList<InstagramPost>();
	
	InstagramPost(String u, String t, int l){
		this.username = u;
		this.text = t;
		this.likeCount = l;
		
		InstagramPost.all.add(this);
		
	}
	static void likesForUser(String a) {
		int likeCount = 0;
		int divider = 0;
		for (int i = 0; i < all.size(); i++) {
			if(a.matches(all.get(i).username)) {
				likeCount += all.get(i).likeCount;
				divider++;
			}
		}
		if(divider>0) {
			System.out.println("Average like count for "+a+" is "+likeCount/divider);			
		} else {
			System.out.println("Couldn't find anyone named "+a);
		}
	}
	static void isLame() {
		System.out.println("Lame posts:");
		int lameCount = 0;
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).text.contains("#flatEarth") || all.get(i).text.contains("#livelovelaugh") || all.get(i).text.contains("#blm")){
				System.out.println(all.get(i).text);
				lameCount++;
			}
		}
		if(lameCount == 0) {
			System.out.println("(None!)");
		}
	}
	static void isLonely() {
		System.out.println("Lonely posts:");
		int lonelyCount = 0;
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).likeCount < 2){
				System.out.println(all.get(i).text);
				lonelyCount++;
			}
		}
		if(lonelyCount == 0) {
			System.out.println("(None!)");
		}
	}
	static void isLameLonely() {
		System.out.println("Lame and Lonely posts:");
		int Count = 0;
		for (int i = 0; i < all.size(); i++) {
			if((all.get(i).likeCount < 2) && ((all.get(i).text.contains("#flatEarth") || all.get(i).text.contains("#livelovelaugh") || all.get(i).text.contains("#blm")))){
				System.out.println(all.get(i).text);
				Count++;
			}
		}
		if(Count == 0) {
			System.out.println("(None!)");
		}
	}
}
