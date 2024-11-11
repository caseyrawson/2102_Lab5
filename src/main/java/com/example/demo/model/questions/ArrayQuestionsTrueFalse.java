package com.example.demo.model.questions;

import java.util.ArrayList;
import java.util.List;

public class ArrayQuestionsTrueFalse {
    private List<QuestionTrueFalse> arrayListQuestionsTF = new ArrayList<QuestionTrueFalse>();

    public ArrayQuestionsTrueFalse() {
        arrayListQuestionsTF.add(new QuestionTrueFalse("The earth is the 3rd planet from its star", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("The earth and mars have the same atmosphere", false));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Saturn is the largest planet", false));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Jupiter is the largest planet", true));
    }
    public List<QuestionTrueFalse> getAllQuestions() {
        return arrayListQuestionsTF;
    }
    
}