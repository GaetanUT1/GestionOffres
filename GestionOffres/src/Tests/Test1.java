/*
 *  Projet Dev Objet Master 2 IGSI-FC
 *  Nicolas Méjane / Gaëtan Bascoulès
 *        --> GestionOffres <--
 */
package Tests;


import GestionOffres.Emploi ;
import GestionOffres.Offre;
import GestionOffres.Stage;
import GestionOffres.TableauResultatRecherche;
import java.util.ArrayList;


/**
 * Test du Use Case 1 : recherche par compétences dans une région
 * @author gaetan
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        ArrayList<Offre> listeOffreSaisies = new ArrayList<>() ;
        String regionRecherchee ;
        ArrayList<String> listeCompetenceRecherchees = new ArrayList<>() ;
        

        System.out.println("<<<<< -- RUN du TEST1 -- >>>>>");
        
        // Stage 1
        Stage stage1 ;
        stage1 = new Stage("nomStage1", "nomRegion1", "01/01/2016", "31/12/2016") ;
        stage1.setCompetence("java", "s");
        stage1.setCompetence("unix", "o");
        listeOffreSaisies.add(stage1) ;
        // Stage 2
        Stage stage2 ;
        stage2 = new Stage("nomStage2", "nomRegion1", "01/01/2016", "31/12/2016") ;
        stage2.setCompetence("java", "o");
        stage2.setCompetence("unix", "o");
        listeOffreSaisies.add(stage2) ;
        // Emploi 1
        Emploi emploi1 ;
        emploi1 = new Emploi("nomEmploi1", "nomRegion1", 1, 10000, 15000, "01/01/2016", "31/12/2016") ;
        emploi1.setCompetence("java", "s");
        emploi1.setCompetence("unix", "s");
        listeOffreSaisies.add(emploi1) ;
        
        // Recherches
        regionRecherchee = "nomRegion1" ;
        listeCompetenceRecherchees.add("java");
        listeCompetenceRecherchees.add("unix");

        // Construit la structure de RX des offres sélectionnées
        TableauResultatRecherche resultat = new TableauResultatRecherche() ;
        
        for (int j=0;j<listeOffreSaisies.size();j++) {
            if (listeOffreSaisies.get(j) instanceof Stage){
                resultat.ajouteResultat((Stage) listeOffreSaisies.get(j), listeOffreSaisies.get(j).recherche1(regionRecherchee, listeCompetenceRecherchees));
            }
            else {
                resultat.ajouteResultat((Emploi) listeOffreSaisies.get(j), listeOffreSaisies.get(j).recherche1(regionRecherchee, listeCompetenceRecherchees));
            }
        }
      
        // Parcours des résultats
        System.out.println("Rappel des critères de recherche : ");
        System.out.println("Région : " + regionRecherchee);
        System.out.println("Compétences : " + listeCompetenceRecherchees.toString());
        
        for (int i=0; i<resultat.afficheResultatRecherche().size();i++){
            System.out.println(resultat.afficheResultatRecherche().get(i));
        }
        System.out.println("score de stage 1 : " + stage1.getScore());
        System.out.println("score de stage 1 dans le tableau de recherche : " + resultat.afficheResultatRecherche().get(0).getScore());
 
    }
}
