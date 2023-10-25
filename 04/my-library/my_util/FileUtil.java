package my_util;

import java.io.*;

public class FileUtil {
  public static String readTextFile(String filename) {
    try {
      BufferedReader br = new BufferedReader(
          new FileReader(filename));
      String line;
      String res = "";
      while ((line = br.readLine()) != null) {
        res += line + "\n";
      }
      br.close();
      return res;
    } catch (IOException e) {
      return null;
    }
  }

  public static String readTextFile(String filename, String enc) {
    try {
      BufferedReader br = new BufferedReader(
          new InputStreamReader(
              new FileInputStream(filename), enc));
      String line;
      String res = "";
      while ((line = br.readLine()) != null) {
        res += line + "\n";
      }
      br.close();
      return res;
    } catch (IOException e) {
      return null;
    }
  }

  public static void writeTextFile(String data, String filename) {
    try {
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
      pw.printf(data);
      pw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeTextFile(String data, String filename, String enc) {
    try {
      PrintWriter pw = new PrintWriter(
          new BufferedWriter(
              new OutputStreamWriter(
                  new FileOutputStream(filename), enc)));
      pw.printf(data);
      pw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}