import java.util.*;
import java.io.*;

class Test05C {
  public static void main(String[] args) {
    WordCounter counter = new WordCounter(); // カウンタの初期化
    // String str = "This is a pen. That is an apple. Apple and pen!";
    System.out.print("Input file name: ");
    String str = "";
    try {
      BufferedReader reader = new BufferedReader(new FileReader(new File(new Scanner(System.in).nextLine())));
      String line;
      while ((line = reader.readLine()) != null) {
        str += line + " ";
      }
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }

    String[] split = str.split("\s+");
    for (int i = 0; i < split.length; i++) {
      split[i] = split[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
      counter.add(split[i]); // 単語を 1 つずつカウンタに追加（add）
    }
    List<String> wordList = counter.getSortedWordList();
    int loop = wordList.size() < 20 ? wordList.size() : 20;
    for (int i = 0; i < loop; i++) {
      String w = wordList.get(i);
      System.out.printf("%4d\t%s\n", counter.getNumber(w), w);
    }
  }
}
