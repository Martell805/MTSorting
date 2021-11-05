import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class MTSFrame extends JFrame implements ActionListener {
    ArrayPanel arrayPanel;
    ArrayList<Integer> list;

    QuickSorterThread quickSorterThread;
    MergeSorterThread mergeSorterThread;

    ControlPanel controlPanel;

    MTSFrame(){
        int NUMBER_OF_ELEMENTS = 500;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        list = new ArrayList<>();
        for(int q = 1; q < NUMBER_OF_ELEMENTS; q++) {
            list.add(q);
        }

        Collections.shuffle(list);

        arrayPanel = new ArrayPanel(list);
        this.add(arrayPanel);

        controlPanel = new ControlPanel(this);
        this.add(controlPanel);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == controlPanel.qsBtn){
            quickSorterThread = new QuickSorterThread(arrayPanel, list);
            quickSorterThread.start();
        }
        else if(e.getSource() == controlPanel.msBtn){
            mergeSorterThread = new MergeSorterThread(arrayPanel, list);
            mergeSorterThread.start();
        }
        else if(e.getSource() == controlPanel.resetBtn){
            Collections.shuffle(list);
            arrayPanel.update(list);
        }
    }
}
