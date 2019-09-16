/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thelastbattle;

/**
 *
 * @author ASUS
 */
public class Valiant extends Minion {

    public Valiant(String code, float attack, float defend, boolean equipment, int strength) {
        super(code, attack, defend, equipment, strength);
    }

    @Override
    public void checkEquipment() {
        if (this.isEquipment()) {
            float vDefend = this.getDefend() * 2;
        }
    }
}
