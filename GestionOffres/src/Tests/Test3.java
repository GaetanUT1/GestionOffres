/*
 *  Projet Dev Objet Master 2 IGSI-FC
 *  Nicolas Méjane / Gaëtan Bascoulès
 *        --> GestionOffres <--
 */
package Tests;

import GestionOffres.Emploi;
import GestionOffres.Offre;
import GestionOffres.Stage;
import GestionOffres.TableauResultatRecherche;
import java.util.ArrayList;

/**
 * Test du Use Case 3 : recherche d'une offre d'Emploi par compétences et salaire dans une région 
 * @author gaetan
 */
public class Test3 {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Offre> listeOffreSaisies = new ArrayList<>() ;
        String regionRecherchee = "" ;
        ArrayList<String> listeCompetenceRecherchees = new ArrayList<>() ;
        float salaireRecherche = 0 ;
        
        System.out.println("<<<<< -- RUN du TEST3 -- >>>>>");

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
        // Emploi 2
        Emploi emploi2 ;
        emploi1 = new Emploi("nomEmploi2", "nomRegion1", 1, 5000, 20000, "01/01/2016", "31/12/2016") ;
        emploi1.setCompetence("java", "s");
        emploi1.setCompetence("unix", "s");
        listeOffreSaisies.add(emploi1) ;


        
         // Recherches
        regionRecherchee = "nomRegion1" ;
        listeCompetenceRecherchees.add("java");
        listeCompetenceRecherchees.add("unix");
        salaireRecherche = 2500 ;

        // Construit la structure de réception des offres sélectionnées
        TableauResultatRecherche resultat3 = new TableauResultatRecherche() ; 
        // Construit la liste des offres correspondant à des emplois
        ArrayList<Emploi> listeOffreEmplois = new ArrayList<>() ;
        
              
        for (int j=0;j<listeOffreSaisies.size();j++){
            System.out.println("Tests.Test3.main()" + listeOffreSaisies.get(j).getTitre());
            if (listeOffreSaisies.get(j).rechercheTypOffre().equalsIgnoreCase("emploi")){
                listeOffreEmplois.add((Emploi)listeOffreSaisies.get(j)) ;
            }
            else {
                System.out.println("INFO : " + listeOffreSaisies.get(j).getTitre() + " n'est pas un EMPLOI.");
            }
        }
        
        for (int k=0;k<listeOffreEmplois.size();k++){
            resultat3.ajouteResultat(listeOffreEmplois.get(k), listeOffreEmplois.get(k).recherche2(regionRecherchee, listeCompetenceRecherchees, salaireRecherche, listeOffreEmplois));
        }
        
        // Parcours des résultats
        System.out.println("Rappel des critères de recherche : ");
        System.out.println("Région : " + regionRecherchee);
        System.out.println("Compétences : " + listeCompetenceRecherchees.toString());
        
        for (int i=0; i<resultat3.afficheResultatRecherche().size();i++){
            System.out.println(resultat3.afficheResultatRecherche().get(i));
        }
        
        
        System.out.println("score de stage 1 : " + stage1.getScore());
        System.out.println("score de stage 1 dans le tableau de recherche : " + resultat3.afficheResultatRecherche().get(0).getScore());
    }
    
}
