/*
 * Copyright (C) 2025 dadda27
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
