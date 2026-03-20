package org.univ_paris8.iut.qdev.tp2026.gr15;

import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.qdev.tp2026.gr15.services.impl.QuestionnaireInexistantTest;
import org.univ_paris8.iut.qdev.tp2026.gr15.services.impl.QuestionnaireInvalideTest;
import org.univ_paris8.iut.qdev.tp2026.gr15.services.impl.QuestionnaireOKTest;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.CSVInexistantException;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.DonneesCorrompuesException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChargerQuestionnairesTest {

    @Test
    public void questsOKTest() {
        ArrayList<QuestionnaireDTO> questionnaires = (ArrayList<QuestionnaireDTO>) List.of(new QuestionnaireDTO("Sport niv 1", new ArrayList<>(), "Sport"));
        QuestionnaireOKTest questOK = new QuestionnaireOKTest();
        assertEquals(questOK.chargerQuestionnaires("src/test/resources/questionsOKsQuizz_2026_V1.csv"), questionnaires);
    }

    @Test
    public void questsInvalideTest() {
        QuestionnaireInvalideTest questInv = new QuestionnaireInvalideTest();
        assertThrows(DonneesCorrompuesException.class, () -> questInv.chargerQuestionnaires("src/test/resources/questionsInvalidesQuizz_2026_V1.csv"));
    }

    @Test
    public void questsInexistantTest() {
        QuestionnaireInexistantTest questInex = new QuestionnaireInexistantTest();
        assertThrows(CSVInexistantException.class, () -> questInex.chargerQuestionnaires("src/test/resources/questionsMirages.csv"));
    }

}
