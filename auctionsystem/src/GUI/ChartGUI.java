package GUI;

import Users.Seller;
import Users.User;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Dalia
 */
public class ChartGUI extends JFrame {

    JButton c = new JButton("Show Chart");

    public ChartGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 700);
        setTitle("Chart");
        Container cp = getContentPane();
        cp.setLayout(null);
        cp.add(c);
        c.setBounds(150, 200, 300, 30);
        c.addActionListener(new act());
    }

    private class act implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent o) {
            Object buttonpressed = o.getSource();
            if (buttonpressed.equals(c)) {

                DefaultPieDataset pds = new DefaultPieDataset();
                pds.setValue("Number Of Items", new Integer(Seller.itemlist.size()));
                
                             
                JFreeChart ch = ChartFactory.createPieChart("Pie chart", pds, true, true, true);
                PiePlot p = (PiePlot) ch.getPlot();
                
                ChartFrame frame = new ChartFrame("pie chart", ch);
                frame.setVisible(true);
                frame.setSize(600, 700);

            }
        }
    }
    
}