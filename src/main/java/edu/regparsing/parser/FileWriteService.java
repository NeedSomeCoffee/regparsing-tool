package edu.regparsing.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import edu.regparsing.exceptions.ParsingException;
import edu.regparsing.exceptions.WritingException;


public class FileWriteService {
	private Path filePath;
	
	public FileWriteService(String path, String fileName) throws WritingException {
		try {
			this.filePath = createDocument(path, fileName);

		} catch (IOException e) {
			throw new WritingException("Can't create  file: ", e);
		}
	}
	
	
	private Path createDocument(String folder, String fileName) throws IOException {
		Path declaredPath = Paths.get(".", folder + "/" + fileName.replaceAll(" ", "_") + ".xml");
		
		

		if (!declaredPath.toFile().exists()) {
			Path directory = Paths.get(folder);

			if (!directory.toFile().exists()) {
				Files.createDirectories(directory);
			}

			Files.createFile(declaredPath);
		}
		
		return declaredPath;
	}
	
	public void writeToFile(String xml) throws ParsingException {
		try {
			Files.write(filePath, xml.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

		} catch (IOException e) {
			throw new ParsingException("Error writing data to file ", e);
		}
	}

	public Path getFilePath() {
		return filePath;
	}
}
