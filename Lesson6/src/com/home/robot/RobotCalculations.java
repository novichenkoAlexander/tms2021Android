package com.home.robot;

public class RobotCalculations {
    public static Robot getMostExpensiveRobot(Robot[] robots) {
        int maxRobotPrice = 0;
        Robot mostExpensiveRobot = robots[maxRobotPrice];
        for (Robot robot : robots) {
            if (robot.getPrice() >= maxRobotPrice) {
                maxRobotPrice = robot.getPrice();
            }
        }
        return mostExpensiveRobot;
    }
}
