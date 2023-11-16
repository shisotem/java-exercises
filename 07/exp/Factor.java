import java.util.*;

// 式の因子（factor）を表すクラス

public class Factor extends Node {

    public String toString() {
        return "Factor";
    }

    // 指定された状態（state）での式の値を求めるメソッド
    double eval(Map<String, Expression> state) {
        Token t = (Token) childList.get(0);
        if (t.kind.equals("number")) {
            return t.value;
        } else if (t.kind.equals("name")) {
            Expression e = state.get(t.str);
            return e.eval(state);
        } else {
            return childList.get(1).eval(state);
        }
    }
}
