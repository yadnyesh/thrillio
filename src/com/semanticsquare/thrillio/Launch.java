package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

public class Launch {
	
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		System.out.println("Loading data....");
		DataStore.loadData();
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		System.out.println("Data Loading complete...");
	}

	
	private static void printUserData(){
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	private static void printBookmarkData(){
		for (Bookmark[] bookmarkList : bookmarks){
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}
	
	private static void startBookmarking() {
		System.out.println("Bookmarking....");
		
		for(User user : users) {
			View.bookmark(user, bookmarks);
		}
			
	}
	
	public static void main(String[] args) {
		loadData();
		startBookmarking();
//		
//		System.out.println("Printing User data...");
//		
//		printUserData();
//		
//		System.out.println("Printing Bookmark data...");
//		
//		printBookmarkData();
	
	}
	


}
