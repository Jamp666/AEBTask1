package aebTask1;
//Класс логики программы

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GoldenNumberDetector {
        private TypeDetector typeDetector = new TypeDetector();
        private List<String> goldList = new LinkedList<>();

        public List<String> parseNumbers(String path) throws IOException {
                //Обработка тхт файла с добавлением в массив
                File txtFile = new File(path);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile));
                String number = "";
                char[] chars;
                while ((number = bufferedReader.readLine()) != null) {
                        chars = number.toCharArray();
                        if (typeDetector.is112233type(chars) ||
                                typeDetector.is123321type(chars) ||
                                typeDetector.is111222type(chars) ||
                                typeDetector.is123456type(chars) ||
                                typeDetector.is123123type(chars) ||
                                typeDetector.is121212type(chars)) {
                                goldList.add(number);
                        }
                }
                goldList.add("Всего: " + goldList.size());
                return goldList;
        }
}
