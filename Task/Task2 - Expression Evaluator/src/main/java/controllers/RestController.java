package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import exceptions.ExpressionErrorException;
import exceptions.ServiceNotAvailbleException;

public class RestController {
	private static final String BASE_URL = "http://api.mathjs.org/v4/?expr=";
	
	public String get(String problem) throws IOException, ExpressionErrorException, ServiceNotAvailbleException {
		String url = BASE_URL.concat(problem);
		URL urlObj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("GET");
		int responeCode = con.getResponseCode();
		if(responeCode == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String result = in.readLine();
			in.close();
			return result;
		}
		if(responeCode == 400) {
			String errorMsg = extractErrorMessage(con);
			throw new ExpressionErrorException("Error in expression : ".concat(errorMsg));
		}
		throw new ServiceNotAvailbleException("Service Not Available");
	}
	
	private String extractErrorMessage(HttpURLConnection con) throws IOException {
	    try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(con.getErrorStream()))) {
	        StringBuilder errorMessageBuilder = new StringBuilder();
	        String line;
	        while ((line = errorReader.readLine()) != null) {
	            errorMessageBuilder.append(line);
	        }
	        return errorMessageBuilder.toString();
	    }
	}

}
