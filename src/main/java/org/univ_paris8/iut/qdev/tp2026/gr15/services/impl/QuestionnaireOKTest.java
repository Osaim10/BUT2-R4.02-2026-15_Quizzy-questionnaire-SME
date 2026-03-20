package org.univ_paris8.iut.qdev.tp2026.gr15.services.impl;

import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.qdev.tp2026.gr15.services.interfaces.IQuestionnaireServices;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireOKTest implements IQuestionnaireServices {

    @Override
    public ArrayList<QuestionnaireDTO> chargerQuestionnaires(String chemin) {
        return (ArrayList<QuestionnaireDTO>) List.of(new QuestionnaireDTO("Sport niv 1", new ArrayList<>(), "Sport"));
    }

    @Override
    public void fournirListeQuestionnaires(String chemin) {
        System.out.println("Wow ça marche incroyable");
    }
}
