import java.util.*;

// 式の項（term）を表すクラス

public class Term extends Node {

    public String toString() {
        return "Term";
    }

    // 指定された状態（state）での式の値を求めるメソッド
    double eval(Map<String, Expression> state) {
        double value = childList.get(0).eval(state);
        for (int i = 1; i < childList.size(); i += 2) {
            Token t = (Token) childList.get(i);
            Factor f = (Factor) childList.get(i + 1);

            if (t.str.equals("*")) {
                value *= f.eval(state);
            } else {
                value /= f.eval(state);
            }
        }
        return value;
    }
}
