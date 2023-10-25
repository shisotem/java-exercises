import java.io.*;
import java.util.*;

public class ExpSimple {
  // フィールド：変数名と数値の対応表（状態，state）
  static Map<String, Integer> state = new HashMap<String, Integer>();

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(
          new InputStreamReader(System.in)); // 標準入力
      String line;
      while ((line = br.readLine()) != null) { // 対話的な入出力のループ
        if (line.equals("")) { // 空行の場合
          continue;
        }
        if (line.equals("exit")) { // exit コマンド：プログラム終了
          break;
        }
        if (line.startsWith("set")) { // set コマンド：変数と数値の対応付け
          // line から変数名の文字列と数値の文字列を取り出す
          String key = line.split("\s+")[1];
          // 数値の文字列を int 型の値に変換
          int value = Integer.parseInt(line.split("\s+")[2]);
          // 変数名の文字列が英字で始まる英数字列かどうか確認
          if (!key.matches("[a-zA-Z][a-zA-Z0-9]*")) {
            System.out.println("変数名" + key + "は不正です");
            continue;
          }
          // マップ（state）に変数名と数値の関係を設定する
          state.put(key, value);
          System.out.println("変数" + key + "に" + value + "を割り当てました");
        } else if (line.equals("show")) { // show コマンド
          // マップ（state）の記憶内容を出力
          for (String key : state.keySet()) {
            System.out.println(key + "   " + state.get(key));
          }
        } else {
          // line を変数名と考えて、マップ（state）から対応する数値を取得
          // この際、直接 int に代入するのでなく、いったん Integer 型変数に
          // 代入し、それが null と等しければ未定義メッセージを出力する
          // そうでなければその値（整数値）を出力する
          Integer value = state.get(line);
          if (value == null) {
            System.out.println("変数" + line + "は未定義です");
          } else {
            System.out.println(value);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
