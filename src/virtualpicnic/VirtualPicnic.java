// Ваш файл `input.txt` содержит множество слов, разделенных
// пробелами. Это слова-фрукты, овощи и другие продукты.
// Представьте, что это ваш виртуальный пикник! 🍎🥕🥧
// Задания:
//        1. Осуществить подсчет слов:
//        Напишите программу, которая подсчитывает количество слов в
// файле `input.txt`.
//        2. Найти самое длинное слово:
//        Создайте программу, которая находит самое длинное слово в
// файле.
// 3. Вычислить частоту слов:
//        Напишите программу, которая анализирует, сколько раз каждое
// слово встречается в файле. Подумайте об этом как о подсчете того,
// какие фрукты и овощи самые популярные на вашем пикнике!

package virtualpicnic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VirtualPicnic {
    public static void main(String[] args) {
        String filename = "input.txt";
        List<String> ls = new ArrayList<String>();

        openFile(filename, ls);

        System.out.println("Количество слов в файле - " + filename + " - " + ls.size());

        checkLongestWord(ls);

        statisticM(ls);


    }

    public static void openFile(String fileName, List<String> ls){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String string = reader.readLine();
            while (string != null){
                Collections.addAll(ls, string.split(" "));
                string = reader.readLine();
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ls.removeIf(String::isEmpty);
    }

    public static void checkLongestWord(List<String> ls)
    {
        int temp = 0;
        String value = "";
        for(String str : ls){
            if(str.length() > temp) {
                temp = str.length();
                value = str;
            }
        }

        System.out.println("Самое длинное слово - " + value + ", " + temp + " символов");
    }

    public static void statisticM(List<String> ls){
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String i : ls  ){
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else map.put(i,  1);
        }

        System.out.println(map);
        String[] values = new String[map.size()];
        //Set<String> mapValues =
        map.keySet().toArray(values);

        int maxVeget = 0;
        String maxVegetKey = values[0];
        for (int i = 0; i < values.length; i++) {
            if (maxVeget < map.get(values[i])) {
                maxVeget = map.get(values[i]);
                maxVegetKey = values[i];
            }
        }

        System.out.println("Самый популярный фрукт/овощ - " + maxVegetKey +
                " - " + map.get(maxVegetKey) + " значений.");
    }

}
