package com.home.robot;

import com.home.robot.hands.Hand;
import com.home.robot.hands.SamsungHand;
import com.home.robot.hands.SonyHand;
import com.home.robot.hands.ToshibaHand;
import com.home.robot.heads.Head;
import com.home.robot.heads.SamsungHead;
import com.home.robot.heads.SonyHead;
import com.home.robot.heads.ToshibaHead;
import com.home.robot.legs.Leg;
import com.home.robot.legs.SamsungLeg;
import com.home.robot.legs.SonyLeg;
import com.home.robot.legs.ToshibaLeg;


public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */

        //Creating hands
        Hand sonyHand = new SonyHand(100);
        Hand toshibaHand = new ToshibaHand(150);
        Hand samsungHand = new SamsungHand(200);

        //Creating heads
        Head sonyHead = new SonyHead(300);
        Head toshibaHead = new ToshibaHead(400);
        Head samsungHead = new SamsungHead(500);

        //Creating legs
        Leg sonyLeg = new SonyLeg(200);
        Leg toshibaLeg = new ToshibaLeg(300);
        Leg samsungLeg = new SamsungLeg(400);


        Robot robot1 = new Robot(sonyHead, sonyHand, samsungLeg);
        Robot robot2 = new Robot(toshibaHead, sonyHand, toshibaLeg);
        Robot robot3 = new Robot(samsungHead, toshibaHand, sonyLeg);


        System.out.println("First robot:");
        robot1.action();
        System.out.println("\n Second robot:");
        robot2.action();
        System.out.println("\n Third robot:");
        robot3.action();

        Robot[] robots = new Robot[]{robot1, robot2, robot3};
        System.out.println();

        /**
         * Getting most expensive robot
         */
        Robot mostExpensiveRobot = RobotCalculations.getMostExpensiveRobot(robots);
        System.out.println("The most expensive robot costs " + mostExpensiveRobot.getPrice());
        mostExpensiveRobot.action();

    }

}
