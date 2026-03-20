package org.univ_paris8.iut.qdev.tp2026.gr15;

import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import mocks.QuestionnairesInexistantsImplMock;
import mocks.QuestionnairesInvalidesImplMock;
import mocks.QuestionnairesOKsImplMock;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.CSVInexistantException;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.DonneesCorrompuesException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChargerQuestionnairesTest {

    @Test
    public void questsOKTest() {
        ArrayList<QuestionnaireDTO> questionnaires = (ArrayList<QuestionnaireDTO>) List.of(new QuestionnaireDTO("Sport niv 1", new ArrayList<>(), "Sport"));
        QuestionnairesOKsImplMock questOK = new QuestionnairesOKsImplMock();
        assertEquals(questOK.chargerQuestionnaires("src/test/resources/questionsOKsQuizz_2026_V1.csv"), questionnaires);
    }

    @Test
    public void questsInvalideTest() {
        QuestionnairesInvalidesImplMock questInv = new QuestionnairesInvalidesImplMock();
        assertThrows(DonneesCorrompuesException.class, () -> questInv.chargerQuestionnaires("src/test/resources/questionsInvalidesQuizz_2026_V1.csv"));
    }

    @Test
    public void questsInexistantTest() {
        QuestionnairesInexistantsImplMock questInex = new QuestionnairesInexistantsImplMock();
        assertThrows(CSVInexistantException.class, () -> questInex.chargerQuestionnaires("src/test/resources/questionsMirages.csv"));
    }

}
