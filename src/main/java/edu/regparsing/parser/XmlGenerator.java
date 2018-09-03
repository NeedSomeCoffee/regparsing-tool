package edu.regparsing.parser;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import edu.regparsing.models.Product;

public class XmlGenerator {
	
	public String createXmlForProduct(Product product) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Product.class);
		Marshaller marshaller = context.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(product, writer);
		
		return writer.toString();
	}
}
