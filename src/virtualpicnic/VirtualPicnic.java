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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VirtualPicnic {
    public static void main(String[] args) {
        String filename = "input.txt";
        List<String> ls = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
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

        System.out.println(ls.getLast());


    }
}
