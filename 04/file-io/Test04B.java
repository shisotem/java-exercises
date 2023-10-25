import java.io.*;

public class Test04B {
  public static void main(String[] args) {
    try {
      // 読み込み準備
      FileInputStream fis = new FileInputStream("input.txt");
      InputStreamReader isr = new InputStreamReader(fis, "SJIS");
      BufferedReader br = new BufferedReader(isr);
      String line;

      // 書き出し準備
      // PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt"))); // -> UTF-8
      FileOutputStream fos = new FileOutputStream("output.txt");
      OutputStreamWriter osw = new OutputStreamWriter(fos, "SJIS");
      BufferedWriter bw = new BufferedWriter(osw);
      PrintWriter pw = new PrintWriter(bw);

      while ((line = br.readLine()) != null) {
        System.out.println(line);
        pw.println(line);
      }

      pw.close();
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
