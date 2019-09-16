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
public class Minion {

    private String code;
    private float attack;
    private float defend;
    private boolean equipment;
    private int strength;

    public Minion() {
    }

    public Minion(String code, float attack, float defend, boolean equipment, int strength) {
        this.code = code;
        this.attack = attack;
        this.defend = defend;
        this.equipment = equipment;
        this.strength = strength;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getDefend() {
        return defend;
    }

    public void setDefend(float defend) {
        this.defend = defend;
    }

    public boolean isEquipment() {
        return equipment;
    }

    public void setEquipment(boolean equipment) {
        this.equipment = equipment;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void checkEquipment(){
        
    }
    
    public void info(){
        System.out.println(code + " " + attack + " " + defend + " " + equipment + " " + strength);
    }
}
