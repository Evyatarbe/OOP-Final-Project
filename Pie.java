import java.awt.*;
import java.util.ArrayList;

public class Pie extends Chart {

    public Pie(ArrayList<Double> data, ArrayList<String> labels) {
        super(data, labels);
    }


    public void draw(Graphics g, int x, int y, int width, int height) {
        int sum = (int) sum(data);
        int startAngle = 0;
        int labelX = x + 50;
        int labelY = height + 180;
        for (int i = 0; i < data.size(); i++) {
            g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
            g.fillArc(x, y, width, height, startAngle, (int) (Math.round(data.get(i) / sum * 360)));
            g.drawString(labels.get(i), labelX, labelY);
            startAngle = startAngle + (int) Math.round(data.get(i) / sum * 360);
            labelX += 90;
        }

    }

    private double sum(ArrayList<Double> data) {
        double sum = 0;
        for (int i = 0; i < data.size(); i++)
            sum = sum + data.get(i);
        return sum;
    }


}
