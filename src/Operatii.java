import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Operatii {
    public Operatii()
    {
    }
    public Polinom suma(Polinom a,Polinom b)
    {

        Polinom rezultat = new Polinom();
        for(Map.Entry<Integer,Integer> pol1:a.polinom.entrySet())
        {
            int coef1=pol1.getValue();
            int coef2=b.polinom.getOrDefault(pol1.getKey(),0);
            int suma=coef1+coef2;
            rezultat.polinom.put(pol1.getKey(),suma);
        }
        for(Map.Entry<Integer,Integer> pol2:b.polinom.entrySet())
        {
            if(!(a.polinom.containsKey(pol2.getKey())))
                rezultat.polinom.put(pol2.getKey(),pol2.getValue());
        }
        return rezultat;
    }
    public Polinom diferenta(Polinom a,Polinom b)
    {
        Polinom rezultat = new Polinom();
        for(Map.Entry<Integer,Integer> pol1:a.polinom.entrySet())
        {
            int coef1=pol1.getValue();
            int coef2=b.polinom.getOrDefault(pol1.getKey(),0);
            int diferenta=coef1-coef2;
            rezultat.polinom.put(pol1.getKey(),diferenta);
        }
        for(Map.Entry<Integer,Integer> pol2:b.polinom.entrySet())
        {
            if(!(a.polinom.containsKey(pol2.getKey())))
                rezultat.polinom.put(pol2.getKey(),-pol2.getValue());
        }
        return rezultat;
    }
    public Polinom inmultire(Polinom a,Polinom b)
    {
        Operatii op=new Operatii();
        Polinom rezultat=new Polinom();
        rezultat.polinom.put(0,0);
        for(Map.Entry<Integer,Integer> pol1:a.polinom.entrySet())
        {
            Polinom rezultat1=new Polinom();
            for(Map.Entry<Integer,Integer> pol2:b.polinom.entrySet()) {
                int exp = 0, coef = 0;
                exp = pol1.getKey() + pol2.getKey();
                coef = pol1.getValue() * pol2.getValue();
                rezultat1.polinom.put(exp, coef);
            }
            rezultat=op.suma(rezultat,rezultat1);
        }
        return rezultat;
    }
    public Polinom derivare(Polinom b)
    {
        Polinom rezultat=new Polinom();
        for(Map.Entry<Integer,Integer> mp:b.polinom.entrySet())
        {
            int coef=0,exp=0;
            coef=mp.getValue();
            exp=mp.getKey();
            if(exp>1)
            {
                coef=coef*exp;
                exp=exp-1;
                rezultat.polinom.put(exp,coef);
            }
            else if(exp==1)
            {
                exp=0;
                rezultat.polinom.put(exp,coef);
            }
            else if(exp==0)
            {
                exp=0;
                coef=0;
                rezultat.polinom.put(exp,coef);
            }
        }
        return rezultat;
    }
}