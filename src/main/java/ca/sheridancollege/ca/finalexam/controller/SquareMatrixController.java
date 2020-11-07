package ca.sheridancollege.ca.finalexam.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.sheridancollege.ca.finalexam.entity.User;
import ca.sheridancollege.ca.finalexam.service.SquareMatrixService;
import ca.sheridancollege.ca.finalexam.service.UserService;

@Controller
public class SquareMatrixController {

	private SquareMatrixService squareMatrixService;
	private UserService userService;
	private PatternResponse response;
	private char[][] squareMatrix;

	@Autowired
	public SquareMatrixController(SquareMatrixService squareMatrixService, UserService userService,
			char[][] squareMatrix, PatternResponse response) {
		this.squareMatrixService = squareMatrixService;
		this.userService = userService;
		this.response = response;
		this.squareMatrix = squareMatrix;

	}

//	get square length
	@PostMapping(value = "/square/{length}")
	public String getSquareLength(HttpServletRequest request, Model model) {
		Integer length = Integer.parseInt(request.getParameter("length"));
		this.squareMatrix = squareMatrixService.generateSquareMatrix(length);
		if (length.equals(null) || length < 5) {
			length = 5;
		}

		return "SearchPattern";

	}

//	search pattern
	@PostMapping("/square/{username}/{pattern}")
	@ResponseBody
	public String searchPattern(HttpServletRequest request) {
		String pattern = request.getParameter("pattern");
		String username = request.getParameter("username");
		String patternFound = "";
		String output = "";
		
		if (!userService.findUserByName(username).isPresent()) {
			userService.saveUser(username);
		} else {
			Optional<User> user = userService.findUserByName(username);
			boolean result;
			

			if (pattern.isEmpty() || pattern.equals(null)) {
				result = false;
			} else
				result = squareMatrixService.searchPattern(pattern);

			if (result) {
				patternFound = "true";
				userService.addGamePlayed(user.get().getName(), true);
			} else {
				patternFound = "false";
				userService.addGamePlayed(user.get().getName(), false);
			}
		}
			if (patternFound.equals("true")) {
				 output += response.generatePatternFoundResponse(squareMatrix, pattern);
				 return output;
			} else {
				 output += response.generatePatternNotFoundResponse(squareMatrix, pattern);
				 return output;
			}
		
	}

	@GetMapping("/square/continue")
	public String continuePlaying() {
		return "matrix";
	}
}