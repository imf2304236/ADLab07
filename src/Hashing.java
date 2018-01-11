/**
 * ADL-Lab07
 * Created by IF on 11.01.18.
 */
public class Hashing {
    private int alphSize;
    private int memSize;
    private static final Integer R = 13;

    public Hashing(int alphSize, int memSize)
    {
        this.alphSize = alphSize;
        this.memSize = memSize;
    }

    public int hash(String s) throws IllegalArgumentException
    {
        int hash = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (!Character.isLetter(c) && !Character.isWhitespace(c))
            {
                throw new IllegalArgumentException();
            }

            hash = c + (alphSize * hash);
        }

        hash = R * hash % memSize;

        return hash;
    }

    public static void main(String[] args)
    {
        Hashing hashing = new Hashing(53, 31);
        System.out.println("'he'    : " + hashing.hash("he"));
        System.out.println("'is'    : " + hashing.hash("is"));
        System.out.println("'Art'   : " + hashing.hash("Art"));
        System.out.println("'has'   : " + hashing.hash("has"));
        System.out.println("'Hat'   : " + hashing.hash("hat"));
        System.out.println("'this'  : " + hashing.hash("this"));
        System.out.println("'A Long Hashing Example' : " + hashing.hash("A Long Hashing Example"));
//        System.out.println("'te$t' : " + hashing.hash("te$t"));
    }
}
