import java.awt.*;
import java.util.ArrayList;

public class Column extends Chart {

    public Column(ArrayList<Double> data, ArrayList<String> labels) {
        super(data, labels);
    }

    public void draw(Graphics g, int x, int y, int width, int height) {
        double max = maxValue();
        int newX = x;
        int lines = (height - y) / 50;
        int lineY = height - 20;
        int newY = lineY;
        int grow = (int) (max * 1.5) / lines;
        for (int i = 0; i < lines; i++) {
            g.drawString("" + (grow * i), x - 20, newY + 5);
            g.setColor(Color.GRAY);
            g.drawLine(x + 10, newY, width + 25, newY);
            newY -= 40;
        }
        for (int i = 0; i < labels.size(); i++) {
            g.setColor(Color.BLUE);
            g.fillRect(newX + 20, (int) (lineY - ((data.get(i) / grow) * 40)), width / 20, (int) ((data.get(i) / grow) * 40));
            g.setColor(Color.BLACK);
            g.setFont(new java.awt.Font("Ariel", 0, 7));
            g.drawString(labels.get(i), newX + 20, y + height - 40);
            newX += width / 12.5;
        }
    }

    private double maxValue() {
        double max = 0;
        for (int i = 0; i < data.size(); i++) {
            max = Math.max(max, data.get(i));
        }
        return max;
    }
}
