package org.univ_paris8.iut.qdev.tp2026.gr15;

import org.univ_paris8.iut.qdev.tp2026.gr15.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.qdev.tp2026.gr15.services.QuestionnaireServicesImpl;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.CSVInexistantException;
import org.univ_paris8.iut.qdev.tp2026.gr15.utils.exceptions.DonneesCorrompuesException;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        QuestionnaireServicesImpl service = new QuestionnaireServicesImpl();

        try {
            ArrayList<QuestionnaireDTO> questionnaires = service.chargerQuestionnaires("src/test/resources/questionsOKsQuizz_2026_V1.csv");
            System.out.println("Fichier chargé avec succès !");
            System.out.println("Nombre de questionnaires : " + questionnaires.size());

            service.fournirListeQuestionnaires("src/test/resources/questionsOKsQuizz_2026_V1.csv");

        } catch (CSVInexistantException e) {
            System.out.println("Erreur : fichier introuvable.");
        } catch (DonneesCorrompuesException e) {
            System.out.println("Erreur : le fichier CSV est mal formaté.");
        }
    }
}