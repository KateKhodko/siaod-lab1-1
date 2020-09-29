package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("ВВОД ПЕРВОГО МНОГОЧЛЕНА");
        MyList list1 = sort(enter());
        System.out.println("\nВВОД ВТОРОГО МНОГОЧЛЕНА");
        MyList list2 = sort(enter());
        System.out.println("\nВведите целочисленное значение x");
        int x = enterx();
        System.out.println("Первый многочлен: P(x) = "+getString(list1));
        System.out.println("Второй многочлен: Q(x) = "+getString(list2));
        equality(list1, list2);
        meaning(list1, x);
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
                    System.out.println("Степень слишком большая или вы ввели не целое положительное число!");
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
                    "2.нет");
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

    public static int enterx() {
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
                double newNum = list.get(i).getNum() + list.get(i - 1).getNum();
                if (newNum != 0) {
                    list.get(i - 1).setNum(newNum);
                    list.remove(i);
                } else {
                    list.remove(i - 1);
                    list.remove(i - 1);
                }
                i--;
            }
        }
        return list;
    }

    public static void equality(MyList p, MyList q) {
        if (p.size() == q.size()) {
            boolean flag = true;
            for (int i = 0; i < p.size(); i++) {
                if (!(p.get(i).getNum() == q.get(i).getNum() && p.get(i).getDegree() == q.get(i).getDegree())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Многочлены P(x) и Q(x) равны");
            } else {
                System.out.println("Многочлены P(x)  и Q(x) не равны");
            }
        } else {
            System.out.println("Многочлены P(x) и Q(x) не равны");
        }
    }

    public static void meaning(MyList list, int x) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).getNum() * Math.pow(x, list.get(i).getDegree());
        }
        System.out.println("Значение многочлена P(x) в точке x = " + result);
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
        StringBuilder str = new StringBuilder("0");
        if (!list.isEmpty()) {
            str = new StringBuilder(list.get(0).toString());
        }
        for (int i = 1; i < list.size(); i++) {
            str.append(" + ").append(list.get(i).toString());
        }
        return str.toString();
    }
}
