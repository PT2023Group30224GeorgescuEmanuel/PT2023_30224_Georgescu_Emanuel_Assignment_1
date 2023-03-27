import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class CalcController {
    private CalcModel m_model;
    private CalcView m_view;
    CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view = view;
        view.addAddListener(new AddListener());
        view.addDiffListener(new DiffListener());
        view.addInmultireListener(new InmultireListener());
        view.addDerivareListener(new DerivareListener());
        view.addClearListener(new ClearListener());
    }
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                String userInput1 = "";
                String userInput2 = "";
                userInput1 = m_view.getUserInput1();
                userInput2 = m_view.getUserInput2();
                Rejex rej1 = new Rejex();
                Rejex rej2 = new Rejex();
                Polinom p = new Polinom();
                Polinom p1 = new Polinom();
                Polinom p2 = new Polinom();
                p2.polinom.put(0, 0);
                try {
                    p = rej1.pol(userInput1);
                    p1 = rej2.pol(userInput2);
                    m_model.addBy(userInput1, userInput2);
                    m_view.setTotal(m_model.getValue());
                } catch (Invalid_Input ex) {
                    m_view.showError("Bad input:");
                }
        }
    }
    class DiffListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                String userInput1 = "";
                String userInput2 = "";
                userInput1 = m_view.getUserInput1();
                userInput2 = m_view.getUserInput2();
                Rejex rej1 = new Rejex();
                Rejex rej2 = new Rejex();
                Polinom p = new Polinom();
                Polinom p1 = new Polinom();
                Polinom p2=new Polinom();
                p2.polinom.put(0,0);
            try {
                p = rej1.pol(userInput1);
                p1 = rej2.pol(userInput2);
                m_model.diffBy(userInput1, userInput2);
                m_view.setTotal(m_model.getValue());
            } catch (Invalid_Input ex) {
                m_view.showError("Bad input:");
            }
        }
    }
    class InmultireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                String userInput1 = "";
                String userInput2 = "";
                userInput1 = m_view.getUserInput1();
                userInput2 = m_view.getUserInput2();
                Rejex rej1 = new Rejex();
                Rejex rej2 = new Rejex();
                Polinom p = new Polinom();
                Polinom p1 = new Polinom();
            try {
                p = rej1.pol(userInput1);
                p1 = rej2.pol(userInput2);
                m_model.inmultireBy(userInput1, userInput2);
                m_view.setTotal(m_model.getValue());
            } catch (Invalid_Input ex) {
                m_view.showError("Bad input:");
            }
        }
    }
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
    class DerivareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                String userInput1 = "";
                userInput1 = m_view.getUserInput1();
                Rejex rej1 = new Rejex();
                Polinom p = new Polinom();
                Polinom p2=new Polinom();
                p2.polinom.put(0,0);
                try {
                    p = rej1.pol(userInput1);
                    m_model.derivareBy(userInput1);
                    m_view.setTotal(m_model.getValue());
                }
                catch(Invalid_Input ex)
                {
                    m_view.showError("Bad input:");
                }
        }
    }
}
