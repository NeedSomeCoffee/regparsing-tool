package edu.regparsing.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	@XmlElement
	private String title;
	@XmlElement
	private String price;
	@XmlElement
	private List<String> features;
		
	public String getTitle() {
		return title;
	}
		
	public String getPrice() {
		return price;
	}
	
	public List<String> getFeatures() {
		return features;
	}
	
	public Product setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public Product setPrice(String price) {
		this.price = price;
		return this;
	}
	
	public Product setFeatures(List<String> features) {
		this.features = features;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [title=");
		builder.append(title);
		builder.append(", price=");
		builder.append(price);
		builder.append(", features=");
		builder.append(features);
		builder.append("]");
		return builder.toString();
	}
	
	
}
