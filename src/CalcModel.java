
import java.math.BigInteger;

public class CalcModel {
    static final String INITIAL_VALUE = "0";
    private Polinom m_total;
    CalcModel() {
        reset();
    }
    public void reset() {
        m_total = new Polinom();
    }
    public void addBy(String operand1,String operand2) {
        Operatii op=new Operatii();
        Polinom p=new Polinom();
        Polinom p1=new Polinom();
        Polinom rez=new Polinom();
        Rejex rej=new Rejex();
        Rejex rej1=new Rejex();
        try {
            p = rej.pol(operand1);
        }
        catch(Invalid_Input e)
        {
            p.polinom.put(0,0);
        }
        try {
            p1 = rej1.pol(operand2);
        }
        catch(Invalid_Input e)
        {
            p1.polinom.put(0,0);
        }
        rez=op.suma(p,p1);
        m_total =rez;
    }
    public void diffBy(String operand1,String operand2) {
        Operatii op=new Operatii();
        Polinom pol1=new Polinom();
        pol1.polinom.put(0,0);
        Polinom p=new Polinom();
        Polinom p1=new Polinom();
        Polinom rez=new Polinom();
        Rejex rej=new Rejex();
        Rejex rej1=new Rejex();
        try {
            p = rej.pol(operand1);
        }
        catch(Invalid_Input e)
        {
            p.polinom.put(0,0);
        }
        try {
            p1 = rej1.pol(operand2);
        }
        catch(Invalid_Input e)
        {
            p1.polinom.put(0,0);
        }
        rez=op.diferenta(p,p1);
        m_total =rez;
    }
    public void inmultireBy(String operand1,String operand2) {
        Operatii op=new Operatii();
        Polinom p=new Polinom();
        Polinom p1=new Polinom();
        Polinom rez=new Polinom();
        Rejex rej=new Rejex();
        Rejex rej1=new Rejex();
        try {
            p = rej.pol(operand1);
        }
        catch(Invalid_Input e)
        {
            p.polinom.put(1,0);
        }
        try {
            p1 = rej1.pol(operand2);
        }
        catch(Invalid_Input e)
        {
            p1.polinom.put(1,0);
        }
        rez=op.inmultire(p,p1);
        m_total =rez;
    }
    public void setValue(String value) {
        Polinom p=new Polinom();
        Rejex rej=new Rejex();
        try {
            p = rej.pol(value);
        }
        catch(Invalid_Input e) {
            p.polinom.put(0, 0);
        }
        m_total=p;
    }
    public void derivareBy(String value)
    {
        Operatii op=new Operatii();
        Polinom p=new Polinom();
        Rejex rej=new Rejex();
        try {
            p = rej.pol(value);
        }
        catch(Invalid_Input e) {
            p.polinom.put(0, 0);
        }
        p=op.derivare(p);
        m_total=p;
    }
    public String getValue() {
        return m_total.toString();
    }
}
