/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residence;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * This class represents the model of a Residence. It's used by its graphical representation class ResidenceNode
 * @author dadda
 */
public class Residence {
    private String name;
    private int population;
    public static final int DEFAULT_MAX_POPULATION = 100;

    public Residence() {
    }

    public Residence(String name, int population) {
        this.name = name;
        this.population = population;
        if(population > DEFAULT_MAX_POPULATION) {
            JOptionPane.showMessageDialog(null, "Population shall be less then: " + DEFAULT_MAX_POPULATION, "Error",
                    ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
}
