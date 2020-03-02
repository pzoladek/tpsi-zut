package lab3;

import lab2.Student;
import lab2.Teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void zad1() {
        //brak porzadku
        Set<String> hashSetZbiorDni = new HashSet<>();
        hashSetZbiorDni.add("pon");
        hashSetZbiorDni.add("wt");
        hashSetZbiorDni.add("sr");
        hashSetZbiorDni.add("czw");
        hashSetZbiorDni.add("pt");

        System.out.println(hashSetZbiorDni);

        //elementy sa sortowane (tu: alfabetycznie)
        Set<String> treeSetZbiorDni = new TreeSet<>();
        treeSetZbiorDni.add("pon");
        treeSetZbiorDni.add("wt");
        treeSetZbiorDni.add("sr");
        treeSetZbiorDni.add("czw");
        treeSetZbiorDni.add("pt");

        System.out.println(treeSetZbiorDni);
    }

    public static void zad2() {
        Map<String, Teacher> teacherMap = new HashMap<>();
        teacherMap.put("programowanie obiektowe", new Teacher("Ticzer", "On", "ma@il.com", "programowanie obiektowe"));
        teacherMap.put("matma", new Teacher("Ticzerowa", "Ona", "mai@l.com", "matma"));
        teacherMap.put("matma", new Teacher("Prawdziwa", "Matma", "m@il.com", "matma"));
        System.out.println(teacherMap);
        System.out.println("Nauczyciel programowania: " + teacherMap.get("programowanie obiektowe").getFirstName());
        System.out.println("Nauczyciel matmy: " + teacherMap.get("matma").getFirstName());

        Student s1 = new Student("Stud1", "Ent", "mail@com.pl", "32");
        Student s2 = new Student("Stud2", "Encik", "m@il.com", "32");
        Student s3 = new Student("Stud3", "Entka", "m@ikl.com", "33");
        Student s4 = new Student("Stud3", "Enciara", "m@iklk.com", "34");

        List<Student> students1 = Arrays.asList(s1, s2);
        List<Student> students2 = Arrays.asList(s3);
        List<Student> students3 = Arrays.asList(s4);
        Map<String, List<Student>> studentListMap = new HashMap<>();
        studentListMap.put("32", students1);
        studentListMap.put("33", students2);
        studentListMap.put("34", students3);
        System.out.println(studentListMap.get("32"));
    }

    public static void zad3() {
        List<Product> products = new ArrayList<>();
        Map<Integer, Product> productIdMap = new HashMap<>();

        Set<String> categories = new HashSet<>();
        Map<String, List<Product>> productCategoriesListMap = new HashMap<>();

        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {
            String s = in.readLine();
            while(s!=null) {
         //       System.out.println(s);
                String[] fields = s.split(";");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                Product product = new Product(id, name, category, price);

                products.add(product);
                productIdMap.put(id, product);
                categories.add(category);

                s = in.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (String category : categories) {
            List<Product> categorizedProducts = new ArrayList<>();
            for (Product product : products) {
                if (category.equals(product.getCategory())) {
                    categorizedProducts.add(product);
                }
            }
            productCategoriesListMap.put(category, categorizedProducts);
        }

        System.out.println("Mapa z id produktow: ");
        printMap(productIdMap);
        System.out.println("Mapa z kategoriami: ");
        printMap(productCategoriesListMap);
    }

    public static void printMap(Map map) {
        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
    }
}
