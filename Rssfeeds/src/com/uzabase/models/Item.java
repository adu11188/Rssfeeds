package com.uzabase.models;
/**
 * 
 * Model class for item in RSS Feed 
 * @author adarshsumma
 *
 */
public class Item {

	private String title;
	private String link;
	private String description;
	private String pubDate;
	private String guid;
	private String enclosure;

	public Item(String title, String link, String description, String pubDate, String guid, String enclosure) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
		this.guid = guid;
		this.enclosure = enclosure;
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


	public String getPubDate() {
		return pubDate;
	}


	public String getGuid() {
		return guid;
	}


	public String getEnclosure() {
		return enclosure;
	}
	
	@Override
	public String toString() {
		return "Item [title=" + title + ", link=" + link + ", description=" + description + ", pubDate=" + pubDate
				+ ", guid=" + guid + ", enclosure=" + enclosure + "]";
	}

/**
 * Builder helper class for Item object
 * 
 * @author adarshsumma
 *
 */
	public static class ItemBuilder{
		private  String title;
		private  String link;
		private  String description;
		private  String pubDate;
		private  String guid;
		private  String enclosure;
		
		public  ItemBuilder title(String t) {
			title = t;
			return this;
		}
		public  ItemBuilder link(String l) {
			link = l;
			return this;
		}
		public  ItemBuilder description(String d) {
			description = d;
			return this;
		}
		public  ItemBuilder pubDate(String p) {
			pubDate = p;
			return this;
		}
		public  ItemBuilder guid(String g) {
			guid = g;
			return this;
		}
		public  ItemBuilder enclosure(String e) {
			enclosure = e;
			return this;
		}
		
		public  Item build() {
			return new Item(title,link,description,pubDate,guid,enclosure);
		}
		
	}
	
	

}
