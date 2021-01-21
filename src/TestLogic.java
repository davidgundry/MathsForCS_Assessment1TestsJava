import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class TestLogic {  
  
    @Test  
    public void addition1(){  
        assertEquals("110",removeLeadingZeroes(Main.binaryAddition("001","101")));  
    }  

    @Test  
    public void addition2(){  
        assertEquals("1",removeLeadingZeroes(Main.binaryAddition("0","1")));  
    }  

      @Test  
    public void addition3(){  
        assertEquals("10",removeLeadingZeroes(Main.binaryAddition("001","0001")));  
    }  

    @Test  
    public void multiplication1(){  
        assertEquals("101",removeLeadingZeroes(Main.binaryMultiplication("001","101")));  
    }  

    @Test  
    public void multiplication2(){  
        assertEquals("1010",removeLeadingZeroes(Main.binaryMultiplication("10","101")));  
    }  

    @Test  
    public void multiplication3(){  
        assertEquals("11010",removeLeadingZeroes(Main.binaryMultiplication("1101","10")));  
    }  

    @Test  
    public void permissionsToNumber1(){  
        assertEquals(777,Main.filePermissionsToNumber("rwxrwxrwx"));  
    }  

    @Test  
    public void permissionsToNumber2(){  
        assertEquals(521,Main.filePermissionsToNumber("r-x-w---x"));  
    }  

    @Test  
    public void permissionsToNumber3(){  
        assertEquals(652,Main.filePermissionsToNumber("rw-r-x-w-"));  
    }  

    @Test  
    public void permissionsToNumber4(){  
        assertEquals(0,Main.filePermissionsToNumber("---------"));  
    }  

    @Test  
    public void numberToPermissions1(){  
        assertEquals("rwxrwxrwx", Main.numberToFilePermissions(777));  
    }  

    @Test  
    public void numberToPermissions2(){  
        assertEquals("--x-w--wx", Main.numberToFilePermissions(123));  
    }  

    @Test  
    public void numberToPermissions3(){  
        assertEquals("r-x-w--wx", Main.numberToFilePermissions(523));  
    }  

    @Test  
    public void numberToPermissions4(){  
        assertEquals("---------", Main.numberToFilePermissions(0));  
    }  

    @Test  
    public void numberToPermissions5(){  
        assertEquals("-----x---", Main.numberToFilePermissions(10));  
    }  

    public static String removeLeadingZeroes(String str) 
    { 
        int i = 0; 
        while (i < str.length() && str.charAt(i) == '0') 
            i++; 
        return str.substring(i, str.length());
    } 
}  
