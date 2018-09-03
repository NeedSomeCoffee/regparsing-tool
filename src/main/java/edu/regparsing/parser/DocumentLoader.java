package edu.regparsing.parser;

import java.io.IOException;

import java.util.logging.Logger;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.regparsing.exceptions.ParsingException;
import edu.regparsing.exceptions.ResourceNotFoundException;

public class DocumentLoader {
	private Logger logger = Logger.getLogger("DocumentLoader");

	public Document getDataFromUrl(String url) throws ParsingException, ResourceNotFoundException {
		try {
			Connection connection = Jsoup.connect(url);
			Document document = connection.get();
			if (connection.response().statusCode() == 404) {
				throw new ResourceNotFoundException("Product not found by url: " + url);
			}
			
			
			return document;
		} catch (IOException e) {
			throw new ParsingException("Error while fetching url: ", e);
		}
	}
}
