package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		
		//Test 1: in the URL
		WebLink webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--porn-2.html",	"http://www.javaworld.com");
		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("For Adult message in URL return false", isKidFriendlyEligible);
		
		// Test 2
		webLink = BookmarkManager.getInstance().createWebLink(2000,	"porn Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("For Porn in Title return false", isKidFriendlyEligible);
		
		// Test 3
		webLink = BookmarkManager.getInstance().createWebLink(2000,	"Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.adult.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("For Adult in Host return false", isKidFriendlyEligible);
		
		// Test 4
		webLink = BookmarkManager.getInstance().createWebLink(2000,	"Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--adult-2.html",	"http://www.adult.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("For Adult in URL return true", isKidFriendlyEligible);
		
		// Test 4
		webLink = BookmarkManager.getInstance().createWebLink(2000,	"Tiger, adult 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--adult-2.html",	"http://www.adult.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("For adult in URL return true", isKidFriendlyEligible);
		
	}

}
