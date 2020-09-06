package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            System.out.println("1.Проверить 2 многочлена на равенство\n" +
                    "2.Вычислить значение многочлена в точке x\n" +
                    "3.Вычислить сумму многочленов\n" +
                    "4.Выход\n");

            Scanner scan = new Scanner(System.in);
            if (scan.hasNextInt()) {
                int n = scan.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Ввод первого многочлена");
                        MyList list1 = enter();
                        System.out.println("Ввод второго многочлена");
                        MyList list2 = enter();
                        equality(list1, list2);
                        break;
                    case 2:
                        System.out.println("Ввод многочлена");
                        meaning(enter(), enterx());
                        break;
                    case 3:
                        //addDetailByIndex();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Пункт меню введен не верно!");
                }
            } else {
                System.out.println("Пункт меню введен не верно!");
            }
        }

    }

    public static MyList enter() {
        MyList list = new MyList();
        while (true) {
            int degree;
            System.out.println("Введите степень слагаемого многочлена");
            while (true) {
                Scanner scan = new Scanner(System.in);
                if (scan.hasNextInt()) {
                    degree = scan.nextInt();
                    if (degree >= 0) {
                        break;
                    }
                } else {
                    System.out.println("Степень должна быть целым положительным числом!");
                }
            }
            double num;
            System.out.println("Введите коэффициента слагаемого многочлена");
            while (true) {
                Scanner scan = new Scanner(System.in);
                if (scan.hasNextDouble()) {
                    num = scan.nextDouble();
                    break;
                } else {
                    System.out.println("Вы ввели не число!");
                }
            }
            if (num != 0) {
                list.add(new Number(degree, num));
            }
            System.out.println("Желаете ввести еще одно слагаемое?\n" +
                    "1.да\n" +
                    "2.нет\n");
            while (true) {
                Scanner scan = new Scanner(System.in);
                if (scan.hasNextInt()) {
                    int n = scan.nextInt();
                    if (n == 1) {
                        break;
                    } else if (n == 2) {
                        return list;
                    }
                    System.out.println("Пункт меню введен не верно!");
                } else {
                    System.out.println("Пункт меню введен не верно!");
                }
            }
        }
    }

    public static double enterx() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextDouble()) {
                return scan.nextDouble();
            } else {
                System.out.println("Вы ввели не число!");
            }
        }
    }

    public static void equality(MyList p, MyList q) {
        if (p.size() == q.size()) {
            for (int i = 0; i < p.size(); i++) {
                if (getString(p).equals(getString(q))) {
                    break;
                }
            }
            System.out.println("Многочлены P(x) = " + getString(p) + " и Q(x) = " +(getString(q)+ " равны");
        } else {
            System.out.println("Многочлены P(x) = " + getString(p) + " и Q(x) = " +(getString(q)+ "не равны");
        }
    }

    public static void meaning(MyList list, double x) {

    }

    public static String getString(MyList list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i).getNum() + "x^" + list.get(i).getDegree() + " ";
        }
        return str;
    }
}
