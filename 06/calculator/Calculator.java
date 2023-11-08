import java.util.*;

// 数値加算を実行するクラス（の雛型）
public class Calculator {
  // フィールドの宣言と初期化（3 つ）
  List<Integer> dataList = new ArrayList<Integer>();
  List<CalcNode> nodeList = new ArrayList<CalcNode>();
  long sum = 0;

  // コンストラクタの定義
  Calculator(String fileName) {
    try {
      Scanner sc = new Scanner(new java.io.File(fileName));
      while (sc.hasNext()) {
        dataList.add(sc.nextInt());
      }
      sc.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // メソッド createNodes の定義
  void createNodes(int n) {
    for (int i = 0; i < n; i++) {
      CalcNode node = new CalcNode();
      node.assign(i, n);
      nodeList.add(node);
      node.start();
    }
  }

  // メソッド addSum の定義
  synchronized void addSum(long sum) {
    this.sum += sum;
  }

  // メソッド getSum の定義
  long getSum() {
    for (CalcNode node : nodeList) {
      try {
        node.join();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return this.sum;
  }

  // 内部クラス CalcNode の定義（並行に動作する計算ノードを表す）以下は完成済み
  class CalcNode extends Thread {
    int myId;
    int numNodes;

    void assign(int i, int n) {
      this.myId = i;
      this.numNodes = n;
    }

    public void run() {
      long sum = 0;
      int numData = dataList.size();
      long start = System.nanoTime();
      // このノードの担当範囲の加算を実行
      for (int i = this.myId * numData / this.numNodes; i < (this.myId + 1) * numData / this.numNodes; i++) {
        sum += dataList.get(i);
        try {
          Thread.sleep(1); // 計算コストの代わり
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      addSum(sum); // 計算結果を全体の sum に加える
      long end = System.nanoTime();
      System.out.println("ThreadTime:" + (end - start) / 1000000f + "ms");
    }
  }
}