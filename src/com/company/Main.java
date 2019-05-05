package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    private static int i = 0;
    private static ArrayList<AKniga> base = new ArrayList<>();
    private static DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    static DateFormat getFormat() {
        return format;
    }

    private static String vvod() {
        try {
                BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                String s = r.readLine();
                if (s.equals("")) throw new Exception();
                return s;
        } catch (Exception e) {
            System.out.println("Что-то не то ты ввел, приятель.");
            return vvod();
        }
    }

    private static Date parseDate(String s) {
        try {
             return format.parse(s);
        } catch (Exception e) {
            System.out.println("Ошибка при вводе даты! Попробуйте еще раз.");
            return parseDate(s);
        }

    }

    private static ArrayList<String> addPhones(){
        ArrayList<String> phones = new ArrayList<>();
        while (true) {
            String phone = vvod();
            if (phone.equals("хватит")) {
                if (phones.size()==0) {
                    System.out.println("Это телефонная книга, тут обязан быть хотя бы один номер");
                    return addPhones();
                }
                else break;
            }
            phones.add(phone);
        }
        return phones;
    }

    private static AKniga newData() {
        System.out.println("Введите данные новой записи");
        System.out.println("Фамилия:");
        String surname = vvod();
        System.out.println("Имя:");
        String name = vvod();
        System.out.println("Отчество:");
        String middlename = vvod();
        System.out.println("Дата рождения (в формате ДД.ММ.ГГГГ):");
        Date birthday = parseDate(vvod());
        System.out.println("Номер телефона (один или несколько; для прекращения ввода введите \"хватит\"):");
        ArrayList<String> phones = addPhones();
        System.out.println("Адрес:");
        String address = vvod();
        i++;
        return new AKniga(surname, name, middlename, birthday, phones, address, new Date());



    }
    private static void writeBase() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/base.txt"));
        for (AKniga a: base) {
            bw.write(a.toFile());
        }

            bw.close();
    }

    private static void readBase() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:/base.txt"));
        String str = br.readLine();
        br.close();
        String[] words = str.split("%");
        for (String s:words
             ) {
            System.out.println(s);
        }
        for (int j = 0; j < words.length-1; j++) {
            String surname = words[j];
            String name = words[++j];
            String middlename = words[++j];
            Date birthday = parseDate(words[++j]);
            String[] phone = words[++j].split(",");
            for (int k = 0; k < phone.length-1; k++) {
                phone[k]= phone[k].substring(1);
            }
            phone[phone.length-1] = phone[phone.length-1].substring(1,phone[phone.length-1].length()-1);
            ArrayList<String> phones = new ArrayList<>(Arrays.asList(phone));
            String address = words [++j];
            Date editDate = parseDate(words[++j]);
            base.add(new AKniga(surname, name, middlename, birthday, phones, address, editDate));
            i++;
        }

    }

    private static void shuffleSurname(){
        for (int j = base.size()-1; j >= 1; j--) {
            for (int k = 0; k < j; k++) {
                if (base.get(k).getSurname().compareTo(base.get(k+1).getSurname())>0){

                    AKniga dummy = base.get(k);
                    base.set(k, base.get(k+1));
                    base.set(k+1, dummy);
                }
            }
        }
    }

    private static void shuffleDate(){
        for (int j = base.size()-1; j >= 1; j--) {
            for (int k = 0; k < j; k++) {
                if (base.get(k).getBirthday().after(base.get(k+1).getBirthday())){
                    AKniga dummy = base.get(k);
                    base.set(k, base.get(k+1));
                    base.set(k+1, dummy);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("МЕНЮ");
            System.out.println("-------------------");
            System.out.println("Выберите пункт меню путем ввода соответствующей цифры:");
            System.out.println("Добавить запись - 1");
            System.out.println("Посмотреть имеющиеся в базе записи - 2");
            System.out.println("Записать базу в файл - 3");
            System.out.println("Считать базу из файла - 4");
            System.out.println("Закрыть программу - 5");

            String s = vvod();
            if (s.equals("1")) {
                base.add(newData());
            } else if (s.equals("2")) {
                System.out.println("В базе сейчас " + i + " записей.");
                System.out.println("Фамилия Имя Отчество Дата Рождения Телефоны Адрес Дата изменения");
                shuffleSurname();
                for (AKniga b: base) {
                    System.out.println(b.toString());
                }
            } else if (s.equals("3")) {
                writeBase();
            } else if (s.equals("4")) {
                readBase();
            } else if (s.equals("5")) break;
            else System.out.println("Введен неверный символ");
        }

    }
}
