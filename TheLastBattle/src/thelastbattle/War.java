/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thelastbattle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class War {

    private ArrayList<Minion> teamA = new ArrayList<>();
    private ArrayList<Minion> teamB = new ArrayList<>();

    public War() {

    }

    public void createListTeam() {
        try (FileReader reader = new FileReader("C:/Users/ASUS/Desktop/Input.txt");
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            int numOfMinions;

            //tạo từng team
            line = br.readLine();
            String[] splited = line.split("\\s+");
            String teamType = splited[0];
            //kiểm tra số lính rồi đọc thông tin từng lính
            numOfMinions = Integer.parseInt(splited[1]);
            System.out.println(numOfMinions);
            for (int j = 0; j < numOfMinions; j++) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                splited = line.split("\\s+");
                //đọc từng trường của 1 dòng        
                if (splited.length == 7) {
                    //tạo object AG và ghi chỉ số
                    String code = splited[1];
                    float attack = Float.parseFloat(splited[2]);
                    float defend = Float.parseFloat(splited[3]);
                    boolean equipment = Boolean.parseBoolean(splited[4]);
                    int strength = Integer.parseInt(splited[5]);
                    float experience = Float.parseFloat(splited[6]);
                    ArmyGeneral AG = new ArmyGeneral(code, attack, defend, equipment, strength, experience);
                    if (teamType.equals("teamA")) {
                        teamA.add(AG);
                    } else {
                        teamB.add(AG);
                    }
                } else {
                    //phân loại, tạo object và ghi chỉ số
                    String type = splited[0];
                    String code = splited[1];
                    float attack = Float.parseFloat(splited[2]);
                    float defend = Float.parseFloat(splited[3]);
                    boolean equipment = Boolean.parseBoolean(splited[4]);
                    int strength = Integer.parseInt(splited[5]);
                    switch (type) {
                        case "V":
                            Valiant v = new Valiant(code, attack, defend, equipment, strength);
                            if (teamType.equals("teamA")) {
                                teamA.add(v);
                            } else {
                                teamB.add(v);
                            }
                            break;
                        case "A":
                            Archer a = new Archer(code, attack, defend, equipment, strength);
                            if (teamType.equals("teamA")) {
                                teamA.add(a);
                            } else {
                                teamB.add(a);
                            }
                            break;
                        case "K":
                            Knight k = new Knight(code, attack, defend, equipment, strength);
                            if (teamType.equals("teamA")) {
                                teamA.add(k);
                            } else {
                                teamB.add(k);
                            }
                            break;
                    }

                }
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    ArmyGeneral AG1 = (ArmyGeneral) teamA.get(0);
    ArmyGeneral AG2 = (ArmyGeneral) teamB.get(0);
    Minion minionA = teamA.get(1);
    Minion minionB = teamB.get(1);
    float AAttack, ADefend, BAttack, BDefend;

    public void AGExperience(ArmyGeneral AG) {
        if (AG.getExperience() == 0) {
            AAttack = minionA.getAttack() / 2;
            ADefend = minionA.getDefend() / 2;
        } else if (0 < AG.getExperience() && AG.getExperience() <= 2) {
            AAttack = (float) (minionA.getAttack() / 1.2);
            ADefend = (float) (minionA.getDefend() / 1.2);
        } else if (2 < AG.getExperience() && AG.getExperience() <= 5) {
            AAttack = (float) (minionA.getAttack() * 1.5);
            ADefend = (float) (minionA.getDefend() * 1.5);
        } else {
            AAttack = minionA.getAttack() * 2;
            ADefend = minionA.getDefend() * 2;
        }
    }

    public void fight() {
        while (!teamA.isEmpty() && !teamB.isEmpty()) {

            //nhân công thủ của quân lính theo kinh nghiệm của tướng team A
            AGExperience(AG1);

            //nhân công thủ của quân lính theo kinh nghiệm của tướng team B
            AGExperience(AG2);

            if (AAttack == BDefend || BAttack == ADefend) {
                if (minionA.getStrength() > minionB.getStrength()) {
                    teamB.remove(minionB);
                    AAttack -= 20;
                    ADefend -= 20;
                } else {
                    teamA.remove(minionA);
                    BAttack -= 20;
                    BDefend -= 20;
                }
            }
        }
    }

    public void result(String output) throws FileNotFoundException {
        //ghi file output
        PrintStream fileOut = new PrintStream(output);
        System.setOut(fileOut);
        if (teamA.size() > 0) {
            System.out.println("Team A WIN");
            for (Minion minion : teamA) {
                minion.info();
            }
        } else {
            System.out.println("Team B WIN");
            for (Minion minion : teamB) {
                minion.info();
            }
        }
    }
}
