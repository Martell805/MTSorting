import java.util.ArrayList;

public class MergeSorterThread extends SorterThread{
    MergeSorterThread(ArrayPanel arrayPanel, ArrayList<Integer> list) {
        super(arrayPanel, list);
    }

    MergeSorterThread(ArrayPanel arrayPanel, ArrayList<Integer> list, int low, int high){
        super(arrayPanel, list, low, high);
    }

    @Override
    public void run(){
        mergeSort(this.list, this.low, this.high);
    }

    private void mergeSort(ArrayList<Integer> A, int low, int high){
        if(low == high)
            return;
        else{
            int mid = (low + high) / 2;
            MergeSorterThread threadL = new MergeSorterThread(arrayPanel, list, low, mid);
            //mergeSort(A, low, mid);
            MergeSorterThread threadR = new MergeSorterThread(arrayPanel, list, mid + 1, high);
            //mergeSort(A, mid + 1, high);
            threadL.start();
            threadR.start();
            try {
                threadL.join();
                threadR.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(A, low, mid + 1, high);
        }
    }

    private void merge(ArrayList<Integer> A, int low, int mid, int high) {
        ArrayList<Integer> merged = new ArrayList<>();

        int index1 = low, index2 = mid;

        while(index1 < mid && index2 <= high){
            if(A.get(index1) < A.get(index2)){
                merged.add(A.get(index1));
                index1++;
            }
            else{
                merged.add(A.get(index2));
                index2++;
            }
        }

        while(index1 < mid){
            merged.add(A.get(index1));
            index1++;
        }

        while(index2 <= high){
            merged.add(A.get(index2));
            index2++;
        }

        int index = low;

        for(Integer q: merged){
            A.set(index, q);
            arrayPanel.update(A);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            index++;
        }
    }
}
