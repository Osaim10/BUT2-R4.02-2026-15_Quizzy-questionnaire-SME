package org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto;

import org.univ_paris8.iut.qdev.tp2026.gr15.utils.enums.DifficulteEnum;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.enums.LanguesEnum;

public class QuestionDTO {

    private int identifiant = 0, difficulte;
    private LanguesEnum langue;
    private String libelle, reponse, explication, source;

    public QuestionDTO(DifficulteEnum diff, LanguesEnum lg, String lib, String rep, String expl, String src) {
        this.difficulte = diff.ordinal()+1;
        this.langue = lg;
        this.libelle = lib;
        this.reponse = rep;
        this.explication = expl;
        this.source = src;

        identifiant++;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public LanguesEnum getLangue() {
        return langue;
    }

    public String getExplication() {
        return explication;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getReponse() {
        return reponse;
    }

    public String getSource() {
        return source;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLangue(LanguesEnum langue) {
        this.langue = langue;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
