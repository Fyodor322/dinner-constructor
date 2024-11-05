package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private final HashMap<String, ArrayList<String>> menuMap;
    private final Random rnd = new Random();

    public HashMap<String, ArrayList<String>> getMenuMap() {
        return menuMap;
    }

    DinnerConstructor() {
        menuMap = new HashMap<>();
    }

    public void addNewDish(String nameCategory, String nameDish) {
        //ArrayList<String> dishes = menuMap.get(nameCategory);
        ArrayList<String> dishes = menuMap.computeIfAbsent(nameCategory, k -> new ArrayList<>());

        if (dishes.contains(nameDish)) {
            System.out.println("Такое блюдо уже добавлено в категорию " + nameCategory);
        } else {
            dishes.add(nameDish);
            System.out.println("блюдо " + nameDish + " добавлено в категорию " + nameCategory);
        }
    }

    public void generateDishCombo(ArrayList<String> categories, int numCombo) {
        ArrayList<ArrayList<String>> rezult = new ArrayList<>();

        for (int i = 0; i < numCombo; i++) { //проходимся по конкретному обеду
            rezult.add(new ArrayList<>());
            for (String categoryDish : categories) { //проходимся по конкретной категории

                ArrayList<String> dishListInCategory = menuMap.get(categoryDish);
                String nameDish;
                if (dishListInCategory.size() > 1) {
                    nameDish = dishListInCategory.get(rnd.nextInt(dishListInCategory.size() - 1));
                } else {
                    nameDish = dishListInCategory.getFirst();
                }
                rezult.get(i).add(nameDish);

            }
        }

        for (int i = 0; i < rezult.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(rezult.get(i));
        }

    }
}
