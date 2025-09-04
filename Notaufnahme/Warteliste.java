
public class Warteliste
{
    private Patient[] liste;
    private int maxAnzahl = 5;
    private int anzahl = 0;

    public Warteliste()
    {
        liste = new Patient[maxAnzahl];
    }

    public void einfuegen(Patient pat)
    {
        if (!istVoll())
        {
            liste[anzahl] = pat;
            anzahl++;
        }
        else
        {
            System.out.println("Fehler!");
        }
    }

    public Patient entfernen()
    {
        if (anzahl > 0)
        {
            Patient pat = liste[0];
            for (int i = 0; i < anzahl-1; i++)
            {
                liste[i] = liste[i+1];
            }
            liste[anzahl-1] = null;
            anzahl--;
            return pat;
        }
        else 
        {
            return null;
        }
    }

    public int getAnzahl()
    {
        return anzahl;
    }

    public boolean istVoll()
    {
        if (anzahl == maxAnzahl)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean istLeer()
    {
        if (anzahl == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
