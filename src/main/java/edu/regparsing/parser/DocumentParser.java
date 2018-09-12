package edu.regparsing.parser;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.regparsing.models.Feature;
import edu.regparsing.models.Product;

public class DocumentParser {
	
	public Product parseProductInfo(Document doc) {
		Product product = new Product();
		
		product.setTitle(parseProductTitle(doc))
				.setDescription(parseProductDescription(doc))
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
	
	private String parseProductDescription(Document doc) {
		Elements selected = doc.select("#productDescription p");
		String description = "";
		
		
		if(!selected.isEmpty()) {
			description = selected.first().text();
		}
		
		return description;
	}

	private String parseProductPrice(Document doc) {
		Elements selected = doc.select("#priceblock_ourprice");
		String price = "";
		
		
		if(!selected.isEmpty()) {
			price = selected.first().text();
		}
		
		return price;
	}

	private List<Feature> parseProductFeatures(Document doc) {
		Elements selected = doc.select("#feature-bullets ul li:not(.aok-hidden)");
		List<Feature> features = new ArrayList<Feature>();
		
		
		if(!selected.isEmpty()) {
			for(Element singleFeature : selected) {
				features.add(new Feature(singleFeature.text()));
			}
		}
		
		return features;
	}
}
