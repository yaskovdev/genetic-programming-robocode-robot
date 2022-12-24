package org.example;


import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

import java.io.File;

public class BattleRunner {
    public static void main(String[] args) {
        System.setProperty("NOSECURITY", "true");
        System.setProperty("robocode.options.battle.desiredTPS", "10000");
//        System.setProperty("robocode.options.battle.desiredTPS", "27");
        RobocodeEngine.setLogMessagesEnabled(false);

        RobocodeEngine engine = new RobocodeEngine(new File("/Users/yaskovdev/robocode"));
        engine.addBattleListener(new BattleObserver());
        engine.setVisible(false);
        int numberOfRounds = 1;

        for (int i = 0; i < 70; i++) {
            BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600);
            RobotSpecification[] selectedRobots = engine.getLocalRepository("org.example.PushRobot,sample.Tracker");
            BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);
            engine.runBattle(battleSpec, true);
            System.out.println("Battle " + i + " is over");
        }

        engine.close();
        System.exit(0);
    }
}