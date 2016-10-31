package com.semanticsquare.thrillio.entities;

public class WebLink extends Bookmark {

	private String Url;
	private String host;

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
