package com.bean;

import java.util.ArrayList;
import java.util.List;

public class SubmitData {

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    String answer;

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        System.out.println("awaawawaaa"+answers);
        this.answers.add(answers);
    }

    List<String> answers = new ArrayList<>();
}
