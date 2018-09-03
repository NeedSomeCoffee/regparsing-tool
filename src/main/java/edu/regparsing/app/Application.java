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
		String url = "https://www.amazon.com/dp/B06XX51DFX/ref=sspa_dk_detail_4?psc=1&pd_rd_i=B06XX51DFX&pf_rd_m=ATVPDKIKX0DER&pf_rd_p=a54d13fc-b8a1-4ce8-b285-d77489a09cf6&pf_rd_r=4H2VRYV1GA8H99F1J4TR&pd_rd_wg=PBfWV&pf_rd_s=desktop-dp-sims&pf_rd_t=40701&pd_rd_w=myqwH&pf_rd_i=desktop-dp-sims&pd_rd_r=b868f197-afca-11e8-9f1d-0fdf2b561195";
		
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
