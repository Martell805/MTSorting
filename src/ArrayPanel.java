import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayPanel extends JPanel {
    final int HEIGHT = 400;
    final int WIDTH = 1000;
    ArrayList<JLabel> labels = new ArrayList<>();

    ArrayPanel(ArrayList<Integer> s){
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);

        for(int q: s){
            JLabel label = new JLabel();
            label.setBackground(Color.WHITE);
            label.setOpaque(true);

            labels.add(label);
            this.add(label);
        }

        update(s);
    }

    void update(ArrayList<Integer> s){
        int maxs = Collections.max(s);

        for(int q = 0; q < s.size(); q++){
            labels.get(q).setBounds(
                    (WIDTH / s.size()) * q + (int)(WIDTH / s.size() * 0.2),
                    HEIGHT - s.get(q) * (HEIGHT - 10) / maxs,
                    WIDTH / s.size() - (int)(WIDTH / s.size() * 0.2),
                    s.get(q) * (HEIGHT - 10) / maxs
            );
        }
    }
}
