package edu.regparsing.app;


import javax.xml.bind.JAXBException;

import edu.regparsing.exceptions.ParsingException;
import edu.regparsing.exceptions.ResourceNotFoundException;
import edu.regparsing.exceptions.WritingException;
import edu.regparsing.models.Product;
import edu.regparsing.parser.DocumentLoader;
import edu.regparsing.parser.DocumentParser;
import edu.regparsing.parser.FileWriteService;
import edu.regparsing.parser.XmlGenerator;

public class Application {
	public static void main(String[] args) {
		String url = "https://www.amazon.com/LG-gram-Thin-Light-Laptop/dp/B078WRSHV4/ref=sr_1_82_sspa";
		
		DocumentLoader loader = new DocumentLoader();
		
		try {
			Product parsed = new DocumentParser().parseProductInfo(loader.getDataFromUrl(url));
			String title = parsed.getTitle();			
			
		new FileWriteService("./data/", title).writeToFile(new XmlGenerator().createXmlForProduct(parsed));
		} catch (ParsingException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (WritingException e) {
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
