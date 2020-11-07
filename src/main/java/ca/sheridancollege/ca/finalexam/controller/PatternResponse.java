package ca.sheridancollege.ca.finalexam.controller;

import org.springframework.stereotype.Component;

@Component
public class PatternResponse {
	public String generatePatternFoundResponse(char[][] squareMatrix, String pattern) {
		String response = "";
		String table = "";
		table += "<table border = '1'>"; 
		for(int a = 0; a < squareMatrix.length; a++) {
			table += "<tr>";
			for (int b = 0; b <squareMatrix[0].length; b++) {
				table += "<td>";
				table += squareMatrix[a][b];
				table += "</td>";
			}
			table += "</tr>";
		}
		
		table += "</table>";
		
		response += "<!DOCTYPE html>" +
				 "<html xmlns:th='http://www.thymeleaf.org'>"
				+"<head>"
				+"<meta charset='ISO-8859-1'>"
				+"<title>Pattern Found</title>"
				+"<style type='text/css'>"
				+"label {"
				+"	display: inline-block;"
				+	"width: 150px;"
				+	"margin: 5px;"
				+	"text-align: left;"
				+"}"
				+"button {"
				+		"margin: 10px;"
				+		"padding: 10px;"
				+		"width: 200px;"
				+		"color: green;"
				+"}"

				+"</style>"
				+"</head>"
				+"<body>"
				+ "<div align='center'>"
				+"<h1>"
				+"The pattern "+ pattern + " you entered has been found" 
				+"<br>"
				+"<br>"
				+table
				+"<p>"
				+"-------------- You Win------------------"
				+"<form method='get' action='/user/continue'>"
				+"<button> Continue </button>"
				+"</form>"
				+"</button>"
				+"</p"
				+"</h1>"
				+"</div>"
				+"</body>"
				+"</html>";
		
		
		
		return response;
	}
	public String generatePatternNotFoundResponse(char[][] squareMatrix, String pattern) {
		String response = "";
		String table = "";
		table += "<table border = '1'>"; 
		for(int a = 0; a < squareMatrix.length; a++) {
			table += "<tr>";
			for (int b = 0; b <squareMatrix[0].length; b++) {
				table += "<td>";
				table += squareMatrix[a][b];
				table += "</td>";
			}
			table += "</tr>";
		}
		
		table += "</table>";
		
		response += "<!DOCTYPE html>" +
				 "<html xmlns:th='http://www.thymeleaf.org'>"
				+"<head>"
				+"<meta charset='ISO-8859-1'>"
				+"<title>Pattern Not Found</title>"
				+"<style type='text/css'>"
				+"label {"
				+"	display: inline-block;"
				+	"width: 150px;"
				+	"margin: 5px;"
				+	"text-align: left;"
				+"}"
				+"button {"
				+		"margin: 10px;"
				+		"padding: 10px;"
				+		"width: 200px;"
				+		"color: red;"
				+"}"

				+"</style>"
				+"</head>"
				+"<body>"
				+ "<div align='center'>"
				+"<h1>"
				+"The pattern "+ pattern + " you entered has not been found" 
				+"<br>"
				+"<br>"
				+table
				+"<p>"
				+"-------------- You Loose------------------"
				+"<form method='get' action='/square/continue'>"
				+"<button> Continue </button>"
				+"</form>"
				+"</p"
				+"</h1>"
				+"</div>"
				+"</body>"
				+"</html>";
		
		
		
		return response;
	}
}
