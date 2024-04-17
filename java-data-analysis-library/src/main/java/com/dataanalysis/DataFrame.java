package com.dataanalysis;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataFrame {
    private List<String> columns ;
    private List<List<Object>> data ;

    public DataFrame() {
        this.columns = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    public DataFrame(List<String> columns, List<List<Object>> data) {
        this.columns = columns;
        this.data = data;
    }
    
    // Méthode pour ajouter une colonne avec un label spécifique
    public void addColumn(String label, List<Object> columnData) {
        columns.add(label);
        data.add(columnData);
    }

    // Méthode pour afficher tout le DataFrame
    public void display() {
        for (String column : columns) {
            System.out.print(column + "\t");
        }
        System.out.println();
        for (int i = 0; i < data.get(0).size(); i++) {
            for (int j = 0; j < data.size(); j++) {
                System.out.print(data.get(j).get(i) + "\t");
            }
            System.out.println();
        }
    }

    // Méthode pour afficher les premières lignes du DataFrame
    public void displayHead(int numRows) {
        for (String column : columns) {
            System.out.print(column + "\t");
        }
        System.out.println();
        for (int i = 0; i < Math.min(numRows, data.get(0).size()); i++) {
            for (int j = 0; j < data.size(); j++) {
                System.out.print(data.get(j).get(i) + "\t");
            }
            System.out.println();
        }
    }

    // Méthode pour afficher les dernières lignes du DataFrame
    public void displayTail(int numRows) {
        for (String column : columns) {
            System.out.print(column + "\t");
        }
        System.out.println();
        int dataSize = data.get(0).size();
        for (int i = Math.max(0, dataSize - numRows); i < dataSize; i++) {
            for (int j = 0; j < data.size(); j++) {
                System.out.print(data.get(j).get(i) + "\t");
            }
            System.out.println();
        }
    }

    // Méthode pour sélectionner un sous-ensemble de lignes à partir de leurs index
    public DataFrame selectRows(List<Integer> rowIndexes) {
        DataFrame selectedData = new DataFrame();
        for (String column : columns) {
            selectedData.addColumn(column, new ArrayList<>());
        }
        for (int rowIndex : rowIndexes) {
            for (int j = 0; j < data.size(); j++) {
                selectedData.data.get(j).add(data.get(j).get(rowIndex));
            }
        }
        return selectedData;
    }

    // Méthode pour sélectionner un sous-ensemble de colonnes en utilisant les labels des colonnes
    public DataFrame selectColumns(List<String> columnLabels) {
        DataFrame selectedData = new DataFrame();
        for (String label : columnLabels) {
            int columnIndex = columns.indexOf(label);
            if (columnIndex != -1) {
                selectedData.addColumn(label, data.get(columnIndex));
            } else {
                System.out.println("Column with label " + label + " not found.");
            }
        }
        return selectedData;
    }

    // Méthode pour calculer la moyenne des valeurs dans chaque colonne numérique du DataFrame
    public List<Double> calculateMean() {
        List<Double> means = new ArrayList<>();
        for (List<Object> column : data) {
            double sum = 0;
            int count = 0;
            for (Object value : column) {
                if (value instanceof Number) {
                    sum += ((Number) value).doubleValue();
                    count++;
                }
            }
            means.add(count == 0 ? 0 : sum / count);
        }
        return means;
    }

    // Méthode pour obtenir le nombre de lignes dans le DataFrame
    public int getRowCount() {
        if (data.isEmpty()) {
         return 0;
        }
     return data.get(0).size();
    }

    // Méthode pour obtenir le nombre de colonnes dans le DataFrame
    public int getColumnCount() {
        return columns.size();
    }

    // Méthode pour obtenir les colonnes du DataFrame
    public List<String> getColumns() {
     return columns;
    }

    // Méthode pour obtenir une ligne spécifique du DataFrame
    public List<Object> getRow(int index) {
        List<Object> rowData = new ArrayList<>();
        for (List<Object> columnData : data) {
         rowData.add(columnData.get(index));
        }
        return rowData;
    }
    // Méthode pour obtenir une colonne spécifique du DataFrame en fonction de son libellé
    public List<Object> getColumn(String label) {
        List<Object> columnData = new ArrayList<>();
        int columnIndex = columns.indexOf(label);
        if (columnIndex != -1) {
            columnData = data.get(columnIndex);
        } else {
            System.out.println("Column with label " + label + " not found.");
        }
        return columnData;
    }
    // Méthode pour lire un DataFrame à partir d'un fichier CSV
    public static DataFrame readCSV(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> columns = new ArrayList<>();
        List<List<Object>> data = new ArrayList<>();
        
        // Ignorer la première ligne (ligne d'en-tête )
        String headerLine = reader.readLine();
        String[] header = headerLine.split(",");
    
        // Ajouter les colonnes à partir de la ligne d'en-tête
        columns.addAll(Arrays.asList(header));
    
        // Lire les lignes de données restantes
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            List<Object> rowData = new ArrayList<>();
            for (String value : values) {
                // Ajouter la valeur à la ligne de données sans conversion de type
                rowData.add(value);
            }
            data.add(rowData);
        }
    
        reader.close();
        return new DataFrame(columns, data);
    }
    // Autres méthodes pour d'autres statistiques (min, max, etc.) peuvent être ajoutées ici, elles seront réalisées si le temps nous le permet
}
