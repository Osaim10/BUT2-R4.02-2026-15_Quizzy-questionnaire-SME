package org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto;

import java.util.ArrayList;

public class QuestionnaireDTO {

    private int identifiant = 0;
    private String nom;
    private ArrayList<QuestionDTO> questions;
    private String theme;

    public QuestionnaireDTO(String nom, ArrayList<QuestionDTO> quests, String theme) {
        this.nom = nom;
        this.questions = quests;
        this.theme = theme;

        identifiant++;

    }

    public String getNom() {
        return nom;
    }

    public String getTheme() {
        return theme;
    }

    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setQuestions(ArrayList<QuestionDTO> questions) {
        this.questions = questions;
    }
}
