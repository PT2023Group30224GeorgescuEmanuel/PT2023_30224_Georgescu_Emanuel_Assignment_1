import javax.swing.*;
import java.awt.*;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class CalcView extends JFrame {
    private JTextField textfiled1 = new JTextField(17);
    private JTextField textfield2 = new JTextField(17);
    private JTextField textfiled3 = new JTextField(50);
    private JButton button1 = new JButton("+");
    private JButton button2 = new JButton("-");
    private JButton button3 = new JButton("*");
    private JButton button4=new JButton("Clear");
    private JButton button5=new JButton("Derivat");
    private JLabel l2 = new JLabel("Rezultat");
    private JLabel l1 = new JLabel("Polinom2");
    private JLabel l = new JLabel("Polinom1");
    private CalcModel m_model;
    CalcView(CalcModel model)
    {
        m_model=model;
        m_model.setValue(CalcModel.INITIAL_VALUE);
        textfiled3.setText(m_model.getValue());
        textfiled3.setEditable(false);
        JPanel content=new JPanel();
        content.setLayout(new FlowLayout());
        content.add(l);
        content.add(textfiled1);
        content.add(l1);
        content.add(textfield2);
        content.add(button1);
        content.add(button2);
        content.add(button3);
        content.add(button5);
        content.add(l2);
        content.add(textfiled3);
        content.add(button4);
        this.setContentPane(content);
        this.pack();
        this.setTitle("Calculator Polinomial");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public CalcView() {
    }
    void reset() {
        textfiled3.setText(CalcModel.INITIAL_VALUE);
    }
    String getUserInput1() {
        return textfiled1.getText();
    }
    String getUserInput2() {
        return textfield2.getText();
    }
    void setTotal(String newTotal) {
        textfiled3.setText(newTotal);
    }
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    void addAddListener(ActionListener mal) {
        button1.addActionListener(mal);
    }
    void addDiffListener(ActionListener mal)
    {
        button2.addActionListener(mal);
    }
    void addInmultireListener(ActionListener mal)
    {
        button3.addActionListener(mal);
    }
    void addDerivareListener(ActionListener mal)
    {
        button5.addActionListener(mal);
    }
    void addClearListener(ActionListener mal)
    {
        button4.addActionListener(mal);
    }
}


