package com.game;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void start(){
        System.out.println("猜数字小游戏");
        System.out.println("请输入一个0-20之间的数字");
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int target = random.nextInt(21);
//        System.out.println(target);
        int i =1;
        while(true){
            int guess = scan.nextInt();
            if(guess>target){
                System.out.println("猜大了请重新尝试");
//                System.out.println("猜大了请重新尝试已经猜了"+i);
                i++;
            }
            else if(guess<target){
                System.out.println("猜小了请重新尝试");
//                System.out.println("猜小了请重新尝试已经猜了"+i);
                i++;

            }
            else if(guess==target){
                System.out.println("猜对了！！");
                System.out.println("你一共尝试了" +
                        i+"次");
                break;
            }
        }
    }
}
