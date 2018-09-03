package edu.regparsing.parser;

import java.io.IOException;

import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.regparsing.exceptions.ParsingException;

public class DocumentLoader {
	private Logger logger = Logger.getLogger("DocumentLoader");

	public Document getDataFromUrl(String url) throws ParsingException {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new ParsingException("Error while parsing url: ", e);
		}
	}
}
