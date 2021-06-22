package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	String path = getFilePath();

	public String getFilePath() {
		String filepath = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		filepath = absolutePathOfFirstFile.replaceAll("\\\\+", "/");

		return filepath;
	}

	public String readTestData(String key) {
		String value = "";
		try {
			Properties prop = new Properties();
			File f = new File(path + "//src//test//resources//config//testData.properties");
			if (f.exists()) {
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
			}
		} catch (Exception e) {

		}
		return value;
	}

	public void updateTestData(String key, String value) {
		Properties props = new Properties();
		String propsFileName = path + "//src//test//resources//config//testData.properties";
		try {
			// first load old property file:
			FileInputStream configStream = new FileInputStream(propsFileName);
			props.load(configStream);
			configStream.close();

			// modifies new property
			props.setProperty(key, value);

			// save modified property file
			FileOutputStream output = new FileOutputStream(propsFileName);
			props.store(output, "");
			output.close();

		} catch (IOException ex) {

		}
	}
}
