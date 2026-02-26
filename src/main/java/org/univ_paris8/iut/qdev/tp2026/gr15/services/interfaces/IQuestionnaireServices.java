package org.univ_paris8.iut.qdev.tp2026.gr15.services.interfaces;

import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import java.util.ArrayList;

public interface IQuestionnaireServices {

    public ArrayList<QuestionnaireDTO> chargerQuestionnaires (String chemin);

    public void fournirListeQuestionnaires (String chemin);
}
