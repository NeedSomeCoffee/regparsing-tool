package edu.regparsing.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Feature {
	private String feature;
	
	public Feature() {}
	
	public Feature(String feature) {
		super();
		this.feature = feature;
	}

	public String getFeature() {
		return feature;
	}

	public Feature setFeature(String feature) {
		this.feature = feature;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feature [feature=");
		builder.append(feature);
		builder.append("]");
		return builder.toString();
	}
}
