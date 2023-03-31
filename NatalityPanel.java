import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class NatalityPanel extends JPanel {
    private JButton cmdClear;
    private JButton cmdShowChart;
    private JComboBox<String> box;
    private Pie p;
    private Column c;
    private int flag;

    public NatalityPanel() {
        String[] boxString = {"By Gender", "By Month"};
        this.cmdClear = new JButton("Clear");
        this.cmdShowChart = new JButton("Show Chart");
        this.box = new JComboBox<String>(boxString);
        add(cmdClear);
        add(cmdShowChart);
        add(box);

        File f = new File("NatalityMini.csv");

        //"data" and "labels" for pie chart
        ArrayList<String> genders = new ArrayList<>();
        ArrayList<Double> genderCount = new ArrayList<>();

        //"data" and "labels" for column chart
        ArrayList<String> months = new ArrayList<>();
        ArrayList<Double> births = new ArrayList<>();

        //pie "data" counter
        int mCounter = 0;
        int fCounter = 0;

        int fileSize = (int) f.length();

        //column "data" counter
        int[] monthsCounter = new int[12];

        //pie "labels"
        genders.add("Male");
        genders.add("Female");

        //column "labels"
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < fileSize; i++) {
                String r = br.readLine();
                if (r != null){
                    if (r.charAt(r.length() - 1) == 'M')
                        mCounter++;
                    else
                        fCounter++;
                    r = r.substring(5, 7);
                    if (r.equals("01"))
                        monthsCounter[0]++;
                    if (r.equals("02"))
                        monthsCounter[1]++;
                    if (r.equals("03"))
                        monthsCounter[2]++;
                    if (r.equals("04"))
                        monthsCounter[3]++;
                    if (r.equals("05"))
                        monthsCounter[4]++;
                    if (r.equals("06"))
                        monthsCounter[5]++;
                    if (r.equals("07"))
                        monthsCounter[6]++;
                    if (r.equals("08"))
                        monthsCounter[7]++;
                    if (r.equals("09"))
                        monthsCounter[8]++;
                    if (r.equals("10"))
                        monthsCounter[9]++;
                    if (r.equals("11"))
                        monthsCounter[10]++;
                    if (r.equals("12"))
                        monthsCounter[11]++;
                }
            }
        } catch (IOException e) {
        }


        genderCount.add((double) mCounter);
        genderCount.add((double) fCounter);
        this.p = new Pie(genderCount, genders);


        for (int i = 0; i < monthsCounter.length; i++) {
            births.add((double) monthsCounter[i]);
        }
        this.c = new Column(births, months);

        //listener
        Listener lis = new Listener();
        cmdShowChart.addActionListener(lis);
        cmdClear.addActionListener(lis);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (flag == 0)
            repaint();
        if (flag == 1)
            this.p.draw(g, 125, 125, getWidth() / 2, getHeight() / 2);
        if (flag == 2)
            this.c.draw(g, 30, 30, getWidth() - 30, getHeight() - 30);
    }


    private  class Listener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cmdClear) {
                flag = 0;
                repaint();
            }
            if (e.getSource() == cmdShowChart && box.getSelectedItem() == "By Gender") {
                flag = 1;
                repaint();
            }
            if (e.getSource() == cmdShowChart && box.getSelectedItem() == "By Month") {
                flag = 2;
                repaint();
            }
        }
    }
}
