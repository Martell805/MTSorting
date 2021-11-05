import java.util.ArrayList;

public abstract class SorterThread extends Thread{
    ArrayPanel arrayPanel;
    ArrayList<Integer> list;
    int low, high;

    SorterThread(ArrayPanel arrayPanel, ArrayList<Integer> list){
        this.arrayPanel = arrayPanel;
        this.list = list;
        this.low = 0;
        this.high = list.size() - 1;
    }

    public SorterThread(ArrayPanel arrayPanel, ArrayList<Integer> list, int low, int high) {
        this.arrayPanel = arrayPanel;
        this.list = list;
        this.low = low;
        this.high = high;
    }

    @Override
    public abstract void run();

}
