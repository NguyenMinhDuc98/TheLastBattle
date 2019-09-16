/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thelastbattle;

import java.io.FileNotFoundException;

/**
 *
 * @author ASUS
 */
public class TheLastBattle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        War war = new War();
        war.createListTeam();
        war.fight();
        war.result("C:/Users/ASUS/Desktop/Input.txt");
    }
    
}
