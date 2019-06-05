package com.uzabase.models;

import java.util.List;
/**
 * RSS Feed model class
 * 
 * @author adarshsumma
 *
 */
public class RSSFeed {
	private String title;
	private String link;
	private String description;
	private String lastBuildDate;
	private String docs;
	private String generator;
	private List<Item> items;
	
	public RSSFeed(String title, String link, String description,String lastBuildDate, String docs, String generator,List<Item> items) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.lastBuildDate = lastBuildDate;
		this.docs = docs;
		this.generator = generator;
		this.items =items;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public String getLastBuildDate() {
		return lastBuildDate;
	}


	public String getDocs() {
		return docs;
	}


	public String getGenerator() {
		return generator;
	}


	public String getTitle() {
		return title;
	}


	public String getLink() {
		return link;
	}


	public String getDescription() {
		return description;
	}


	@Override
	public String toString() {
		return "RSSFeed [title=" + title + ", link=" + link + ", description=" + description + ", lastBuildDate="
				+ lastBuildDate + ", docs=" + docs + ", generator=" + generator + ", items=" + items + "]";
	}

/**
 * Builder for RSS Feed model object
 * 
 * @author adarshsumma
 *
 */
	public static class RSSFeedBuilder{
		private  String title;
		private  String link;
		private  String description;
		private  String lastBuildDate;
		private  String docs;
		private  String generator;
		private List<Item> items;
		public  RSSFeedBuilder title(String t) {
			title = t;
			return this;
		}
		public  RSSFeedBuilder link(String l) {
			link = l;
			return this;
		}
		public  RSSFeedBuilder description(String d) {
			description = d;
			return this;
		}
		public  RSSFeedBuilder lastBuildDate(String lastBuildDate) {
			this.lastBuildDate = lastBuildDate;
			return this;
		}
		public  RSSFeedBuilder docs(String docs) {
			this.docs = docs;
			return this;
		}
		public  RSSFeedBuilder generator(String generator) {
			this.generator = generator;
			return this;
		}
		
		public  RSSFeedBuilder items(List<Item> items) {
			this.items = items;
			return this;
		}
		public  RSSFeed build() {
			return new RSSFeed(title,link,description,lastBuildDate,docs,generator,items);
		}
		
	}
	
	
}
