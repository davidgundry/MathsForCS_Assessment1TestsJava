// This file was lost after marking (stupid mistake on my part). This is a reconstruction from Python version.
import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ExtendedTests {  
  
    @Test  
    public void testAMulti()
    {  
        for (int i=0;i<100;i++)
            assert i*i == Main.A(i);
    }

    @Test  
    public void additionMulti()
    {
        for (int i=0;i<6;i++)
            for (int j=0;j<6;j++)
            {
                String target = removeLeadingZeroes(Integer.toString(i+j,2));
                assertEquals(target, removeLeadingZeroes(Main.binaryAddition(Integer.toString(i,2),Integer.toBinaryString(j))));  
            }
    }

    @Test  
    public void multiplicationMulti()
    {
        for (int i=0;i<6;i++)
            for (int j=0;j<6;j++)
            {
                String target = removeLeadingZeroes(Integer.toString(i*j,2));
                assertEquals(target, removeLeadingZeroes(Main.binaryMultiplication(Integer.toString(i,2),Integer.toString(j,2))));
            }
    }

    @Test  
    public void permissionsToNumberMulti()
    {
        for (int u=0;u<7;u++)
            for (int g=0;g<7;g++)
                for (int o=0;o<7;o++)
                {
                    int val = u * 100 + g*10 + o;
                    String target = numberToFilePermissionsModel(val);
                    assertEquals(val,Main.filePermissionsToNumber(target));
                }
    }
            

    @Test  
    public void numberToPermissionsMulti()
    {
        for (int u=0;u<7;u++)
            for (int g=0;g<7;g++)
                for (int o=0;o<7;o++)
                {
                    int val = u * 100 + g*10 + o;
                    String target = numberToFilePermissionsModel(val);
                    assertEquals(target, Main.numberToFilePermissions(val));          
                }
    }


    public static String removeLeadingZeroes(String str) 
    { 
        int i = 0; 
        while (i < str.length() && str.charAt(i) == '0') 
            i++; 
        return str.substring(i, str.length());
    } 
    
    public static String numberToFilePermissionsModel(int num)
    {
        int d3 = num % 10;
        int d2 = (num/10) % 10;
        int d1 = (num/100) % 10;
        return toFileBinary(d1) + toFileBinary(d2) + toFileBinary(d3);
    }

    public static String toFileBinary(int number)
    {
        String c = "rwx";
        String output = "";
        int i = 2;
        do
        {
            if (number % 2 == 1)
                output = c.charAt(i) + output;
            else
                output = "-" + output;
            i = i - 1;
            number /= 2;
        }
        while (output.length() < 3);
        return output;
    }
}
