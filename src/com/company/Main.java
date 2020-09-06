package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Ввод первого многочлена");
        MyList list1 = enter();
        System.out.println("Ввод второго многочлена");
        MyList list2 = enter();
        equality(sort(list1), sort(list2));
        System.out.println("Введите x");
        meaning(sort(list1), enterx());
        add(list1, list2);
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
            if (scan.hasNextInt()) {
                return scan.nextInt();
            } else {
                System.out.println("Вы ввели не целое число!");
            }
        }
    }

    public static MyList sort(MyList list) {
        for (int i = 1; i < list.size(); i++) {
            int degree = list.get(i).getDegree();
            double num = list.get(i).getNum();
            int j = i - 1;
            while (j >= 0 && degree >= list.get(j).getDegree()) {
                list.get(j + 1).setDegree(list.get(j).getDegree());
                list.get(j + 1).setNum(list.get(j).getNum());
                j--;
            }
            list.get(j + 1).setNum(num);
            list.get(j + 1).setDegree(degree);
        }
        return checkCommon(list);
    }

    public static MyList checkCommon(MyList list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getDegree() == list.get(i - 1).getDegree()) {
                int newDegree = list.get(i).getDegree() + list.get(i - 1).getDegree();
                double newNum = list.get(i).getNum() + list.get(i - 1).getNum();
                if (newNum != 0) {
                    list.get(i - 1).setDegree(newDegree);
                    list.get(i - 1).setNum(newNum);
                    list.remove(i);
                } else {
                    list.remove(i - 1);
                    list.remove(i - 1);
                }
                i--;
            }
        }
        System.out.println(getString(list));
        return list;
    }

    public static void equality(MyList p, MyList q) {
        if (p.size() == q.size()) {
            for (int i = 0; i < p.size(); i++) {
                if (getString(p).equals(getString(q))) {
                    break;
                }
            }
            System.out.println("Многочлены P(x) = " + getString(p) + " и Q(x) = " + getString(q) + " равны");
        } else {
            System.out.println("Многочлены P(x) = " + getString(p) + " и Q(x) = " + getString(q) + "не равны");
        }
    }

    public static void meaning(MyList list, double x) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += Math.pow(list.get(i).getNum() * x, list.get(i).getDegree());
        }
        System.out.println("Результат " + result);
    }

    public static void add(MyList p, MyList q) {
        MyList r = new MyList();
        for (int i = 0; i < p.size(); i++) {
            r.add(p.get(i));
        }
        for (int i = 0; i < q.size(); i++) {
            r.add(q.get(i));
        }
        System.out.println("Сумма многочленов p и q равна R(x) = " + getString(sort(r)));
    }

    public static String getString(MyList list) {
        String str = "0";
        if (!list.isEmpty()) {
            str = list.get(0).toString();
        }
        for (int i = 1; i < list.size(); i++) {
            str += " + " + list.get(i).toString();
        }
        return str;
    }
}
