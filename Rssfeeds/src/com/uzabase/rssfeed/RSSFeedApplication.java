package com.uzabase.rssfeed;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.uzabase.exceptions.RSSFeedParserException;
import com.uzabase.exceptions.RSSFeedVersionNotSupportedException;
import com.uzabase.input.RSSFeedInputAdapter;
import com.uzabase.models.RSSFeed;
import com.uzabase.output.RSSFeedOutputAdapter;

/**
 * Sample test application
 * 
 * @author adarshsumma
 *
 */
public class RSSFeedApplication {

	public static void main(String[] args) {
		/**
		 * Sample urls http://feeds.reuters.com/Reuters/worldNews
		 * http://tech.uzabase.com/rss http://feeds.bbci.co.uk/news/rss.xml
		 */
		System.out.println("Please enter RSS Feed URL:");
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNext()) {
				String input = in.next();
				System.out.println("Entered Rss feed URL:" + input);
				try {

					RSSFeedInputAdapter inputAdapter = new RSSFeedInputAdapter();
					RSSFeedOutputAdapter rssFeedOutput = new RSSFeedOutputAdapter();

					RSSFeed rssFeed = inputAdapter.getRSSFeedFromURL(input);
					System.out.println(rssFeedOutput.OutputAsString(rssFeed));
					rssFeedOutput.OutputToFile(rssFeed, "sample.txt");

					// To read from xml file use below
					/**
					 * rssFeed = inputAdapter.getRSSFeedFromFile("Example.xml");
					 * System.out.println(rssFeedOutput.OutputAsString(rssFeed));
					 */

				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (RSSFeedVersionNotSupportedException e) {
					e.printStackTrace();
				} catch (RSSFeedParserException e) {
					e.printStackTrace();
				} finally {
					System.out.println("Please enter RSS Feed URL:");
				}

			}
		}

	}
}
