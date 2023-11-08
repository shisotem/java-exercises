class CountThread extends Thread {
  Counter counter;

  CountThread(Counter counter) {
    this.counter = counter;
  }

  public void run() {
    for (int i = 0; i < 10000; i++) {
      counter.countUp();
    }
  }
}
