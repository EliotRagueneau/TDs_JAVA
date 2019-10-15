package fr.ubordeaux.ao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TownFactory {
    private BufferedReader br;
    private final String file = "./villes_france.csv";
    private Set<Town> towns = new HashSet<Town>();

    public TownFactory() {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("le fichier n'est pas accessible !");
        }
    }

    public Town getNextTown() {
        String line;
        try {
            line = br.readLine();
            if (line == null) return null;

            String[] cells = line.split(",");
            return new Town(cells[4], Integer.parseInt(cells[8].substring(1, cells[10].length() - 1)));
        } catch (IOException e) {
            return null;
        }
    }

    public Town getTown(String name, int zipcode) {
        for (Town town : towns) {
            if (name.equals(town.getName()) & zipcode == town.getZipCode()) {
                return town;
            }
        }
        Town newTown = new Town(name, zipcode);
        towns.add(newTown);
        return newTown;
    }

    public static void main(String[] args) {
        TownFactory tf = new TownFactory();
        for (int i = 0; i < 36700; i++) {
            System.out.println(tf.getNextTown().toString());
        }
    }
}