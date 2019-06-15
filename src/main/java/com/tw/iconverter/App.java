package com.tw.iconverter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tw.iconverter.lexer.CustomEvaluator;

public class App {
	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		
		CustomEvaluator evaluator = new CustomEvaluator();

		if (args.length > 0) {
			try (Stream<String> lines = Files.lines(Paths.get(args[0]))) {
				lines.forEach((line) -> evaluator.processInput(line));
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("No file exists");
			}
		} else {
			logger.info("Usage ");
			logger.info("com.tw.iconverter.App <FileName>");
		}

	}
}
