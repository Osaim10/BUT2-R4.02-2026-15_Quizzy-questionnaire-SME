package org.univ_paris8.iut.qdev.tp2026.gr15.services;

import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionDTO;
import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.qdev.tp2026.gr15.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.enums.DifficulteEnum;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.enums.LanguesEnum;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.CSVInexistantException;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.DonneesCorrompuesException;

import java.io.*;
import java.util.*;

public class QuestionnaireServicesImpl implements IQuestionnaireServices {

    private static final String SEPARATEUR  = ";";
    private static final int    NB_COLONNES = 9;

    private static final int COL_NOM_QUESTIONNAIRE = 1;
    private static final int COL_DIFFICULTE        = 2;
    private static final int COL_LANGUE            = 3;
    private static final int COL_LIBELLE           = 4;
    private static final int COL_REPONSE           = 5;
    private static final int COL_EXPLICATION       = 7;
    private static final int COL_SOURCE            = 8;


    @Override
    public ArrayList<QuestionnaireDTO> chargerQuestionnaires(String chemin)
            throws CSVInexistantException, DonneesCorrompuesException {

        Map<String, QuestionnaireDTO> questionnairesMap = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(chemin), "UTF-8"))) {

            String ligne;
            boolean premiereLigne = true;

            while ((ligne = reader.readLine()) != null) {

                if (premiereLigne) {
                    ligne = ligne.replace("\uFEFF", "");
                    premiereLigne = false;
                }

                if (ligne.trim().isEmpty()) continue;

                String[] col = ligne.split(SEPARATEUR, -1);

                if (col.length != NB_COLONNES) {
                    throw new DonneesCorrompuesException();
                }

                try {
                    String nomQuestionnaire = col[COL_NOM_QUESTIONNAIRE].trim();
                    DifficulteEnum diff     = DifficulteEnum.values()[Integer.parseInt(col[COL_DIFFICULTE].trim()) - 1];
                    LanguesEnum langue      = LanguesEnum.valueOf(col[COL_LANGUE].trim());
                    String libelle          = col[COL_LIBELLE].trim();
                    String reponse          = col[COL_REPONSE].trim();
                    String explication      = col[COL_EXPLICATION].trim();
                    String source           = col[COL_SOURCE].trim();

                    questionnairesMap.putIfAbsent(nomQuestionnaire,
                            new QuestionnaireDTO(nomQuestionnaire, new ArrayList<>(), nomQuestionnaire));

                    questionnairesMap.get(nomQuestionnaire).ajouterQuestion(
                            new QuestionDTO(diff, langue, libelle, reponse, explication, source));

                } catch (NumberFormatException e) {
                    throw new DonneesCorrompuesException();
                }
            }

        } catch (FileNotFoundException e) {
            throw new CSVInexistantException();
        } catch (IOException e) {
            throw new DonneesCorrompuesException();
        }

        return new ArrayList<>(questionnairesMap.values());
    }


    @Override
    public void fournirListeQuestionnaires(String chemin)
            throws CSVInexistantException, DonneesCorrompuesException {

        ArrayList<QuestionnaireDTO> questionnaires = chargerQuestionnaires(chemin);

        for (QuestionnaireDTO q : questionnaires) {
            System.out.println("Questionnaire : " + q.getNom() + " | Nb questions : " + q.getQuestions().size());
        }
    }
}