public class Monom {
    private int coeficient;
    private int exponent;
    public Monom(int coeficient,int exponent)
    {
        this.coeficient=coeficient;
        this.exponent=exponent;
    }
    public void setCoeficient(int coeficient)
    {
        this.coeficient=coeficient;
    }
    public int getCoeficient()
    {
        return this.coeficient;
    }
    public void setExponent(int exponent)
    {
        this.exponent=exponent;
    }
    public int getExponent()
    {
        return this.exponent;
    }
    public String toString()
    {
        String s;
        if(this.exponent==0)
        {
            s=String.valueOf(this.coeficient);
            return s;
        }
        else if(this.exponent==1)
        {
            if(this.coeficient==1)
            {
                s="x";
                return s;
            }
            else if(this.coeficient==-1)
            {
                s="-x";
                return s;
            }
            else
            {
                s=this.coeficient+"x";
                return s;
            }
        }
        else
        {
            if(this.coeficient==1)
            {
                s="x^"+String.valueOf(this.exponent);
                return s;
            }
            else if(this.coeficient==-1)
            {
                s="-x^"+String.valueOf(this.exponent);
                return s;
            }
            else
            {
                s=this.coeficient+"x^"+this.exponent;
                return s;
            }
        }
    }
    public Monom inmultire(Monom m1,Monom m2)
    {
        int exp=0,coef=0;
        exp=m1.getExponent()*m2.getExponent();
        coef=m1.getCoeficient()*m2.getCoeficient();
        Monom res=new Monom(coef,exp);
        return res;
    }
    public double valoareMonom(double x)
    {
        double res=0.0;
        res=Double.valueOf((double)this.coeficient)*Math.pow(x,(double)this.exponent);
        return res;
    }

}
