package com.example.demo;

import com.example.demo.model.PasswordService;
import com.example.demo.model.EmailService;
import com.example.demo.model.questions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
class WebsiteApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testPasswordValidity() {
        assertTrue(PasswordService.isValid("GoodPass123"));
        assertFalse(PasswordService.isValid("short"));
        assertFalse(PasswordService.isValid("NoNumbersHere"));
    }

    @Test
    void testEmailValidity() {
        assertTrue(EmailService.isValid("test@example.com"));
        assertFalse(EmailService.isValid("wrongemail"));
        assertFalse(EmailService.isValid("missing@dot"));
    }

    @Test
    public void testGetQuestions() {
        ArrayQuestionsTrueFalse questionSource = new ArrayQuestionsTrueFalse();
        List<QuestionTrueFalse> questions = questionSource.getAllQuestions();
        assertNotNull(questions);
        assertFalse(questions.isEmpty());
        assertEquals(4, questions.size());
    }
}