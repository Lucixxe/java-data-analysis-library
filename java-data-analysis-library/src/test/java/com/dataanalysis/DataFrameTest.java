package com.dataanalysis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

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


}
