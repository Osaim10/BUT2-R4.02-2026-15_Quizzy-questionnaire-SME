package org.univ_paris8.iut.qdev.tp2026.gr15.services.interfaces;

import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.CSVInexistantException;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.DonneesCorrompuesException;

import java.util.ArrayList;

public interface IQuestionnaireServices {

    public ArrayList<QuestionnaireDTO> chargerQuestionnaires (String chemin) throws CSVInexistantException, DonneesCorrompuesException;

    public void fournirListeQuestionnaires (String chemin) throws CSVInexistantException, DonneesCorrompuesException;
}
