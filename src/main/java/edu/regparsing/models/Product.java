package edu.regparsing.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	@XmlElement
	private String title;
	@XmlElement
	private String description;
	@XmlElement
	private String price;
	@XmlElementWrapper( name="features")
	@XmlElement(name = "feature")
	private List<Feature> features;
		
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
		
	public String getPrice() {
		return price;
	}
	
	public List<Feature> getFeatures() {
		return features;
	}
	
	public Product setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public Product setPrice(String price) {
		this.price = price;
		return this;
	}
	
	public Product setFeatures(List<Feature> features) {
		this.features = features;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", features=");
		builder.append(features);
		builder.append("]");
		return builder.toString();
	}
}
