package my_util;

import java.util.*;

public class ListUtil {
  public static List<Integer> makeIntList(int start, int end) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = start; i <= end; i++) {
      list.add(i);
    }
    return list;
  }

  public static List<Integer> makeIntList(int n) {
    return makeIntList(1, n);
  }

  // 非破壊的メソッド
  public static List<Integer> reverse(List<Integer> list) {
    List<Integer> res = new ArrayList<Integer>();
    for (int i = list.size() - 1; i >= 0; i--) {
      res.add(list.get(i));
    }
    return res;
  }

  public static int max(List<Integer> list) {
    int res = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      if (res < list.get(i)) {
        res = list.get(i);
      }
    }
    return res;
  }

  public static int sum(List<Integer> list) {
    int res = 0;
    for (int i = 0; i < list.size(); i++) {
      res += list.get(i);
    }
    return res;
  }
}
