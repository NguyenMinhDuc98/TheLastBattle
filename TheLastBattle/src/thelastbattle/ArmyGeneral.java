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
public class ArmyGeneral extends Minion {

    private float experience;

    Minion m = new Minion();
    
    public ArmyGeneral(String code, float attack, float defend, boolean equipment, int strength, float experience) {
        super(code, attack, defend, equipment, strength);
        this.experience = experience;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public void info(){
        System.out.println(m.getCode() + " " + m.getAttack() + " " + m.getDefend() + " " + m.isEquipment() + " " + m.getStrength() + " "+ experience);
    }
    
    @Override
    public void checkEquipment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
