package org.univ_paris8.iut.qdev.tp2026.gr15.services.impl;

import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.qdev.tp2026.gr15.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.CSVInexistantException;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.DonneesCorrompuesException;

import java.util.ArrayList;

public class QuestionnaireInvalideTest implements IQuestionnaireServices {

    @Override
    public ArrayList<QuestionnaireDTO> chargerQuestionnaires(String chemin) throws DonneesCorrompuesException {
        throw new DonneesCorrompuesException();
    }

    @Override
    public void fournirListeQuestionnaires(String chemin) throws DonneesCorrompuesException {
        throw new DonneesCorrompuesException();
    }
}
