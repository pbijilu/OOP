package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    private static int i = 0;
    private static ArrayList<AKniga> base = new ArrayList<>();

    private static String vvod() throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        return r.readLine();

    }
    private static Date parseDate() throws Exception {
        DateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        return format.parse(vvod());

    }
    private static AKniga newData() throws Exception {
        System.out.println("Введите данные новой записи");
        System.out.println("Фамилия:");
        String surname = vvod();
        System.out.println("Имя:");
        String name = vvod();
        System.out.println("Отчество:");
        String middlename = vvod();
        System.out.println("Дата рождения (в формате ДД.ММ.ГГГГ):");
        Date birthday = parseDate();
        System.out.println("Номер телефона (один или несколько; для прекращения ввода нажмите \"Enter\") повторно:");
        ArrayList<String> phones = new ArrayList<>();
        while (!vvod().isEmpty())
        phones.add(vvod());
        i = i+1;
        return new AKniga(i,surname, name, middlename, birthday, phones, new Date());



    }
    private static void mainMenu() throws Exception {
        System.out.println("МЕНЮ");
        System.out.println("-------------------");
        System.out.println("Выберите пункт меню путем ввода соответствующей цифры");
        System.out.println("Добавить запись - 1");
        System.out.println("Посмотреть имеющиеся записи - 2");

        int s = Integer.parseInt(vvod());
        if (s == 1) {
            base.add(newData());
        }
        else if (s == 2) {
            System.out.println("В базе сейчас " + i + " записей.");
            System.out.println(base);
        }
        mainMenu();

    }

    public static void main(String[] args) throws Exception {
	// write your code here
        mainMenu();

    }
}
