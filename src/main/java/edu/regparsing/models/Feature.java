package edu.regparsing.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Feature {
	private String value;
	
	public Feature() {}
	
	public Feature(String feature) {
		this.value = feature;
	}

	public String getFeature() {
		return value;
	}

	public Feature setFeature(String feature) {
		this.value = feature;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feature [value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
}
