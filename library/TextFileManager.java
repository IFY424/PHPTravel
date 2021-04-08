package com.selenium.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.message.BufferedHeader;

public class TextFileManager {
	private String fileName;

	public TextFileManager(String filePathName) {
		fileName = filePathName;

	}

	public String readFile() {
		String finalText = null;
		String line = null;
		// reading the file
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			StringBuffer sb = new StringBuffer();
			while ((line = bufferReader.readLine()) != null) {
				sb.append(line);

			}
			finalText = sb.toString();
			bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return finalText;
	}

	public void writeFile(String inputData) {

		try {

			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write(inputData);
			bw.close();
			System.out.println("File Created" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		TextFileManager fileManager=new TextFileManager("src/test/resources/Data/welcome.txt");
		// testing creating file
		//String nextLine=System.lineSeparator();
		//fileWriter.writeFile("this is frank"+nextLine+"thank you so much working with you");
	// testing read file
	String data=fileManager.readFile();
	System.out.println("data: ");
	System.out.println(data);
	}
}
