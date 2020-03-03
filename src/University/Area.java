package University;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/** @see https://stackoverflow.com/a/19215436/230513 */
public class Area extends JFrame {
JTextArea ta;
    public Area() {
        super("Search Result");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        	
        ta = new JTextArea(24, 12);
        ta.setEnabled(false);
        JScrollPane jp = new JScrollPane(ta);
        add(jp, BorderLayout.CENTER);
        pack();
        // arbitrary size to make vertical scrollbar appear
        setSize(480, 240);
        setLocationByPlatform(true);
        setVisible(true);
    }
    
    public void setText(String str) {ta.setText(str);}
        public static void main(String[] args) {
    	   EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                   new Area();
               }
           });
    
    
    }
}