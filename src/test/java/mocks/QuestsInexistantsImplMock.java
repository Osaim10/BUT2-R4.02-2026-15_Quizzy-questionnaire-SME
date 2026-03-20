package mocks;

import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.qdev.tp2026.gr15.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.CSVInexistantException;

import java.util.ArrayList;

public class QuestsInexistantsImplMock implements IQuestionnaireServices {

    @Override
    public ArrayList<QuestionnaireDTO> chargerQuestionnaires(String chemin) throws CSVInexistantException {
        throw new CSVInexistantException();
    }

    @Override
    public void fournirListeQuestionnaires(String chemin) throws CSVInexistantException {
        throw new CSVInexistantException();
    }
}
