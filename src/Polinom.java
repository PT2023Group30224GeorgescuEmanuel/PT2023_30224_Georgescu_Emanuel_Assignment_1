import java.util.*;
public class Polinom {
    Map<Integer, Integer> polinom = new HashMap<>();
    public Polinom() {
    }
    public String toString()
    {
        String rezultat="";
        TreeMap<Integer,Integer> pol1=new TreeMap<Integer,Integer>(this.polinom);
        Set<Map.Entry<Integer,Integer>> entrySet=pol1.entrySet();
        Map.Entry<Integer,Integer>[] entryArray=entrySet.toArray(new Map.Entry[entrySet.size()]);
        int n=this.polinom.size();
        int i=n-1;
        Polinom p=new Polinom();
        p.polinom.put(0,0);


            while (i >= 0) {
                int coef = entryArray[i].getValue();
                int exp = entryArray[i].getKey();
                Monom m = new Monom(coef, exp);

                if (i == n - 1) {
                    if (coef != 0)
                        rezultat = m.toString();
                } else {
                    if (coef > 0) {
                        rezultat = rezultat + "+" + m.toString();
                    } else if (coef < 0) {
                        coef = coef * (-1);
                        m.setCoeficient(coef);
                        rezultat = rezultat + "-" + m.toString();
                    }
                }
                i--;
            }
        if(rezultat.equals(""))
            rezultat="0";
        return rezultat;
    }
}
