package edu.regparsing.parser;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.regparsing.models.Product;

public class DocumentParser {
	
	public Product parseProductInfo(Document doc) {
		Product product = new Product();
		
		product.setTitle(parseProductTitle(doc))
				.setPrice(parseProductPrice(doc))
				.setFeatures(parseProductFeatures(doc));
				
		return product;
	}

	private String parseProductTitle(Document doc) {
		Elements selected = doc.select("#productTitle");
		String title = "";
		
		
		if(!selected.isEmpty()) {
			title = selected.first().text();
		}
		
		return title;
	}

	private String parseProductPrice(Document doc) {
		Elements selected = doc.select("#priceblock_ourprice");
		String price = "";
		
		
		if(!selected.isEmpty()) {
			price = selected.first().text();
		}
		
		return price;
	}

	private List<String> parseProductFeatures(Document doc) {
		Elements selected = doc.select("#feature-bullets ul li span");
		List<String> features = new ArrayList<String>();
		
		
		if(!selected.isEmpty()) {
			for(Element singleFeature : selected) {
				features.add(singleFeature.text());
			}
		}
		
		return features;
	}
}
