import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    ActionListener actionListener;
    JButton qsBtn, msBtn, resetBtn;

    ControlPanel(ActionListener actionListener){
        this.setPreferredSize(new Dimension(100, 400));

        this.actionListener = actionListener;

        qsBtn = new JButton("QuickSort");
        qsBtn.setPreferredSize(new Dimension(80, 80));
        qsBtn.setFocusable(false);
        qsBtn.addActionListener(actionListener);

        this.add(qsBtn);

        msBtn = new JButton("MergeSort");
        msBtn.setPreferredSize(new Dimension(80, 80));
        msBtn.setFocusable(false);
        msBtn.addActionListener(actionListener);

        this.add(msBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setPreferredSize(new Dimension(80, 80));
        resetBtn.setFocusable(false);
        resetBtn.addActionListener(actionListener);

        this.add(resetBtn);
    }
}
