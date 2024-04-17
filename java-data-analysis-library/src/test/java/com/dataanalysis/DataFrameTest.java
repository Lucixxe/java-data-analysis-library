package com.dataanalysis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import static org.junit.Assert.fail;

public class DataFrameTest {
    private DataFrame df;

    @Before
    public void setUp() {
        // Création d'un DataFrame de test
        List<String> columns = Arrays.asList("A", "B", "C");
        List<List<Object>> data = Arrays.asList(
            Arrays.asList(1, "foo", 4.5),
            Arrays.asList(2, "bar", 5.2),
            Arrays.asList(3, "baz", 6.7)
        );
        df = new DataFrame(columns, data);
    }

    @Test
    public void testCreation() {
        assertNotNull(df);
    }

    @Test
    public void testDisplay() {
        // Vérification de l'affichage des premières lignes
        df.displayHead(2); // Affiche les deux premières lignes
        // Vérification de l'affichage des dernières lignes
        df.displayTail(1); // Affiche la dernière ligne
    }

    @Test
    public void testSelection() {
        // Vérification de la sélection de lignes par index
        DataFrame selectedRows = df.selectRows(Arrays.asList(1, 2));
        assertEquals(selectedRows.getRowCount(), 2);

        // Vérification de la sélection de colonnes par label
        DataFrame selectedColumns = df.selectColumns(Arrays.asList("A", "C"));
        assertEquals(selectedColumns.getColumnCount(), 2);

        // Vérification de la sélection avancée
        // Exemple: Sélection des lignes où la colonne "A" a une valeur supérieure à 1
        // DataFrame advancedSelection = df.select(df.getColumn("A").isGreaterThan(1));
        // assertTrue(advancedSelection.getRowCount() > 0);
    }

    @Test
    public void testStatistics() {
        // Vérification du calcul de statistiques
        // assertEquals(df.getColumn("A").mean(), 2.0, 0.01); // Moyenne de la colonne "A"
        // assertEquals(df.getColumn("B").min(), "bar"); // Minimum de la colonne "B"
        // assertEquals(df.getColumn("C").max(), 6.7, 0.01); // Maximum de la colonne "C"
    }
    @Test
    public void testReadCSV() {
        // Chemin relatif du fichier CSV dans le répertoire resources
        String csvFilePath = System.getProperty("user.dir") + "/src/test/resources/data.csv";
    
        try {
            // Création d'un DataFrame en lisant le fichier CSV
            DataFrame df = DataFrame.readCSV(csvFilePath);
            
            // Vérification que le DataFrame n'est pas null
            assertNotNull(df);
            
            // Vérification que le DataFrame contient les bonnes données
            assertEquals(df.getColumnCount(), 3);
            assertEquals(df.getRowCount(), 3);
            assertEquals(df.getColumn("A").get(0), Integer.toString(1)); // On s'attend à un entier
            assertEquals(df.getColumn("B").get(0), Integer.toString(2));
            assertEquals(df.getColumn("C").get(0), Integer.toString(3)); // On s'attend à un double
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
    

}
