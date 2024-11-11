package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.EmailService;
import com.example.demo.model.PasswordService;
import com.example.demo.model.questions.ArrayQuestionsTrueFalse;
import com.example.demo.model.questions.QuestionTrueFalse;

@Controller 
public class HomeController { 

	@GetMapping("/") 
	public String home() { 
		return "home";  //home.html 
	} 

	@GetMapping("/passwordCheck")
    public ResponseEntity<String> checkPassword(@RequestParam String password) {
        boolean isValid = PasswordService.isValid(password);
        return ResponseEntity.ok(isValid ? "Valid password" : "Invalid password");
    }

	@GetMapping("/emailCheck")
	public ResponseEntity<String> checkEmail(@RequestParam String email) {
    	boolean isValid = EmailService.isValid(email);
    	return ResponseEntity.ok(isValid ? "Valid email" : "Invalid email");
	}

	@GetMapping("/quiz")
	public String showQuiz(Model model) {
		ArrayQuestionsTrueFalse questionSource = new ArrayQuestionsTrueFalse();
		List<QuestionTrueFalse> questions = questionSource.getAllQuestions();
		model.addAttribute("questions", questions);
		return "quiz"; //display quiz.html
	}

	@PostMapping("/submitQuiz")
	public String submitQuiz(@RequestParam Map<String, String> answers, Model model) {
		ArrayQuestionsTrueFalse questionSource = new ArrayQuestionsTrueFalse();
		List<QuestionTrueFalse> questions = questionSource.getAllQuestions();
		int score = 0;

		// Iterate through answers calculate score
		for (int i = 0; i < questions.size(); i++) {
			String answerKey = "answers_" + i;
			String userAnswer = answers.get(answerKey);
			boolean correctAnswer = questions.get(i).getAnswer();
			boolean userAnswerB = Boolean.parseBoolean(userAnswer);

			if (userAnswer != null && userAnswerB == correctAnswer) {
				score++;
			}
		}

		model.addAttribute("score", score);
		model.addAttribute("totalQuestions", questions.size());
		return "result"; //display results
	}

}
