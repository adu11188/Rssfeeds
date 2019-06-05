package com.uzabase.output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.uzabase.models.Item;
import com.uzabase.models.RSSFeed;
/**
 * Adapter class for RSS feed output
 * 
 * @author adarshsumma
 *
 */
public class RSSFeedOutputAdapter {

	
public String OutputAsString(RSSFeed rssFeed) {
	if(rssFeed==null)return "";
	
	StringBuilder output = new StringBuilder();
	output.append(rssFeed.toString());
	
	 List<Item> items = rssFeed.getItems();
	 
	 for(Item item:items) {
		 output.append(item.toString()+'\n');
	 }
		return output.toString();
	}

public void OutputToFile(RSSFeed rssFeed,String filepath) {
	 try {
		Files.write(Paths.get(filepath), OutputAsString(rssFeed).getBytes(), StandardOpenOption.CREATE);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
