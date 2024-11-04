package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private final HashMap<String, ArrayList<String>> menuMap;
    private final Random rnd = new Random();

    DinnerConstructor(){
        menuMap = new HashMap<>();
        {
            menuMap.put("первое", new ArrayList<>());
            menuMap.put("второе", new ArrayList<>());
            menuMap.put("напиток", new ArrayList<>());

            menuMap.get("первое").add("лапша");
            menuMap.get("первое").add("солянка");
            menuMap.get("первое").add("борщ");

            menuMap.get("второе").add("котлеты");
            menuMap.get("второе").add("голубцы");
            menuMap.get("второе").add("стейк");

            menuMap.get("напиток").add("кофе");
            menuMap.get("напиток").add("чай");
            menuMap.get("напиток").add("сок");
        }
    }

    public void addNewDish(String nameCategory, String nameDish){
        if (menuMap.containsKey(nameCategory)){
            if(menuMap.get(nameCategory).contains(nameDish)){
                System.out.println("Такое блюдо уже добавлено в категорию " + nameCategory);
            }else {
                menuMap.get(nameCategory).add(nameDish);
                System.out.println("блюдо " + nameDish + " добавлено в категорию " + nameCategory);
            }
        }else {
            menuMap.put(nameCategory, new ArrayList<>());
            menuMap.get(nameCategory).add(nameDish);
            System.out.println("блюдо " + nameDish + " добавлено в категорию " + nameCategory);
        }
    }

    public void generateDishCombo(ArrayList<String> categories, int numCombo){
        ArrayList<ArrayList<String>> rezult = new ArrayList<>();

        for (int i = 0; i < numCombo; i++){ //проходимся по конкретному обеду
            rezult.add(new ArrayList<>());
            for (String el : categories) { //проходимся по конкретной категории
                if (menuMap.containsKey(el)){
                    ArrayList<String> dishListInCategory = menuMap.get(el);
                    String nameDish;
                    if (dishListInCategory.size() > 1){
                        nameDish = dishListInCategory.get(rnd.nextInt(dishListInCategory.size() - 1));
                    }else{
                        nameDish = dishListInCategory.getFirst();
                    }
                    rezult.get(i).add(nameDish);
                }else {
                    System.out.println("категории " + el + " нет в нашем меню");
                }
            }
        }

        for (int i = 0; i < rezult.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(rezult.get(i));
        }

    }
}
