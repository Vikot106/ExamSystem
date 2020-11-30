package com.bean;

public class ManageData {
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQuestSubject() {
        return questSubject;
    }

    public void setQuestSubject(String questSubject) {
        this.questSubject = questSubject;
    }

    public String getQuestObject() {
        return questObject;
    }

    public void setQuestObject(String questObject) {
        this.questObject = questObject;
    }

    String subject;
    String time;
    String questSubject;
    String questObject;
}
