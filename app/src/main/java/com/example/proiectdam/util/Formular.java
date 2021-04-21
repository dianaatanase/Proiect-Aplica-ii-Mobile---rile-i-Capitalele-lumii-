package com.example.proiectdam.util;

import java.io.Serializable;
import java.util.Date;

public class Formular implements Serializable {
    private String category;
    private String comment;
    private YESORNO yesorno;


    public Formular(String category,String comment, YESORNO yesorno ) {
        this.category = category;
        this.comment = comment;
        this.yesorno= yesorno;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public YESORNO getAnswer() {
        return yesorno;
    }

    public void setAnswer(YESORNO yesorno) {
        this.yesorno = yesorno;
    }

    public String getCommenty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "You should improve " + category + " because "
                + comment+ ".My answer for question: Will you recommend this app is "+ yesorno;
    }
}