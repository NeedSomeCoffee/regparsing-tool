package edu.regparsing.app;

import java.util.logging.Logger;

import edu.regparsing.exceptions.ParsingException;
import edu.regparsing.exceptions.ResourceNotFoundException;
import edu.regparsing.exceptions.WritingException;
import edu.regparsing.models.Account;
import edu.regparsing.models.Product;
import edu.regparsing.parser.DocumentLoader;
import edu.regparsing.parser.DocumentParser;
import edu.regparsing.parser.FileWriteService;
import edu.regparsing.parser.XmlGenerator;
import edu.regparsing.registration.RegistrationService;

public class Application {
	private static final Logger LOGGER = Logger.getLogger("App");
	
	public static void main(String[] args) {
		String url = "https://www.amazon.com/LG-gram-Thin-Light-Laptop/dp/B078WRSHV4/ref=sr_1_82_sspa";

		DocumentLoader loader = new DocumentLoader();

		try {
			Product parsed = new DocumentParser().parseProductInfo(loader.getDataFromUrl(url));
			String title = parsed.getTitle();			

			new FileWriteService("./data/", title).writeToFile(new XmlGenerator().createXmlForProduct(parsed));
			
		} catch (ParsingException | WritingException | ResourceNotFoundException e) {
			LOGGER.severe(e.getMessage());
		}
		
		
		RegistrationService registrator = new RegistrationService();

		Account acc = new Account("tryme", "tryme123", "tryme@gmail.com");

		registrator.registerUser(acc);
	}
}
