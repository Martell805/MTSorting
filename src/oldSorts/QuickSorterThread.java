/*

package oldSorts;

import java.util.ArrayList;
import java.util.Random;

public class QuickSorterThread extends Thread{
    ArrayPanel arrayPanel;
    ArrayList<Integer> list;
    int low, high;

    QuickSorterThread(ArrayPanel arrayPanel, ArrayList<Integer> list){
        this.arrayPanel = arrayPanel;
        this.list = list;
        this.low = 0;
        this.high = list.size() - 1;
    }

    private QuickSorterThread(ArrayPanel arrayPanel, ArrayList<Integer> list, int low, int high){
        this.arrayPanel = arrayPanel;
        this.list = list;
        this.low = low;
        this.high = high;
    }

    @Override
    public void run(){
        quickSortStart(this.list, this.low, this.high);
    }

    public void quickSortStart(ArrayList<Integer> A){
        quickSort(A, 0, A.size() - 1);
    }

    private void quickSortStart(ArrayList<Integer> A, int low, int high){
        quickSort(A, low, high);
    }

    private void quickSort(ArrayList<Integer> A, int low, int high){
        if(low < high + 1){
            int p = particion(A, low, high);
            QuickSorterThread threadL = new QuickSorterThread(arrayPanel, list, low, p - 1);
            // quickSort(A, low, p - 1);
            QuickSorterThread threadR = new QuickSorterThread(arrayPanel, list, p + 1, high);
            // quickSort(A, p + 1, high);
            threadL.start();
            threadR.start();
        }
    }

    private void swap(ArrayList<Integer> A, int index1, int index2){
        int temp = A.get(index1);
        A.set(index1, A.get(index2));
        A.set(index2, temp);
        arrayPanel.update(A);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getPivot(int low, int high){
        Random random = new Random();
        return random.nextInt((high - low) + 1) + low;
    }

    private int particion(ArrayList<Integer> A, int low, int high){
        swap(A, low, getPivot(low, high));
        int border = low + 1;
        for(int q = border; q <= high; q++){
            if(A.get(q) < A.get(low)){
                swap(A, q, border++);
            }
        }
        swap(A, low, border - 1);
        return border - 1;
    }
}

 */