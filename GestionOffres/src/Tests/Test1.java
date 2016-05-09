/*
 *  Projet Dev Objet Master 2 IGSI-FC
 *  Nicolas Méjane / Gaëtan Bascoulès
 *        --> GestionOffres <--
 */
package Tests;

import GestionOffres.Emploi ;
import GestionOffres.Stage;
import GestionOffres.TableauResultatRecherche;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author gaetan
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        ArrayList<String> listeOffreSaisies = new ArrayList<>() ;
        String regionRecherchee ="" ;
        ArrayList<String> listeCompetenceRecherchees = new ArrayList<>() ;
        
        // Stage 1
        Stage stage1 ;
        stage1 = new Stage("nomStage1", "nomRegion1", "01/01/2016", "31/12/2016") ;
        stage1.setCompetence("java", "s");
        stage1.setCompetence("unix", "o");
        listeOffreSaisies.add(stage1.getTitre()) ;
        // Stage 2
        Stage stage2 ;
        stage2 = new Stage("nomStage2", "nomRegion1", "01/01/2016", "31/12/2016") ;
        stage2.setCompetence("java", "o");
        stage2.setCompetence("unix", "o");
        listeOffreSaisies.add(stage2.getTitre()) ;
        // Emploi 1
        Emploi emploi1 ;
        emploi1 = new Emploi("nomEmploi1", "nomRegion1", 1, 10000, 15000, "01/01/2016", "31/12/2016") ;
        emploi1.setCompetence("java", "s");
        emploi1.setCompetence("unix", "s");
        listeOffreSaisies.add(emploi1.getTitre()) ;
        
        // Recherches
        regionRecherchee = "nomRegion1" ;
        listeCompetenceRecherchees.add("java");
        listeCompetenceRecherchees.add("unix");

        // Construit la structure de RX des offres sélectionnées
        TableauResultatRecherche res2 = new TableauResultatRecherche() ;
        
        //System.out.println("Test1.main()" + stage1.Recherche1(regionRecherchee, listeCompetenceRecherchees));
        res2.ajouteResultat(stage1, stage1.Recherche1(regionRecherchee, listeCompetenceRecherchees));
        res2.ajouteResultat(stage2, stage2.Recherche1(regionRecherchee, listeCompetenceRecherchees));
        res2.ajouteResultat(emploi1, emploi1.Recherche1(regionRecherchee, listeCompetenceRecherchees));

        // Parcours des résultats
        System.out.println("Rappel des critères de recherche : ");
        System.out.println("Région : " + regionRecherchee);
        System.out.println("Compétences : " + listeCompetenceRecherchees.toString());
        Iterator indexMapResultats = res2.afficheResultatRecherche().entrySet().iterator() ;
        while(indexMapResultats.hasNext()){
            System.out.println(indexMapResultats.next().toString());
        }        
        
    }
    
}
