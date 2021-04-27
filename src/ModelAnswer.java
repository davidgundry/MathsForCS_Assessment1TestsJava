class ModelAnswer
{

    /**
     * This runs a series of unit tests to help you check your code.
     */
    public static void main(String[] args)
    {
        System.out.println(removeLeadingZeroes(binaryAddition("001","101")).equals("110"));
        System.out.println(removeLeadingZeroes(binaryAddition("0","1")).equals("1"));
        System.out.println(removeLeadingZeroes(binaryAddition("001","0001")).equals("10"));
        System.out.println(removeLeadingZeroes(binaryMultiplication("001","101")).equals("101"));
        System.out.println(removeLeadingZeroes(binaryMultiplication("10","101")).equals("1010"));
        System.out.println(removeLeadingZeroes(binaryMultiplication("1101","10")).equals("11010"));

        System.out.println(filePermissionsToNumber("rwxrwxrwx") == 777);
        System.out.println(filePermissionsToNumber("r-x-w---x") == 521);
        System.out.println(filePermissionsToNumber("rw-r-x-w-") == 652);
        System.out.println(filePermissionsToNumber("---------") == 0);
        System.out.println(numberToFilePermissions(777).equals("rwxrwxrwx"));
        System.out.println(numberToFilePermissions(123).equals("--x-w--wx"));
        System.out.println(numberToFilePermissions(523).equals("r-x-w--wx"));
        System.out.println(numberToFilePermissions(0).equals("---------"));
        System.out.println(numberToFilePermissions(10).equals("-----x---"));
    }

    /**
     * This function is used by the unit tests
     */
    public static String removeLeadingZeroes(String str) 
    { 
        int i = 0; 
        while (i < str.length() && str.charAt(i) == '0') 
            i++; 
        return str.substring(i, str.length());
    } 
  

    /**
    * This function accepts two binary strings (Strings containing only the
    * characters '0' and '1') and returns the result of binary addition.
    * @param a - The first binary number
    * @param b - The second binary number
    * @return A String representing the binary sum of the two arguments.
    **/
    static String binaryAddition(String a, String b)
    {
        String out = "";
        int len = Math.max(a.length(), b.length());
        boolean carry = false;
        for (int i = 1; i <= len; i++)
        {
            boolean aVal = ((i <= a.length()) && (a.charAt(a.length()-i) == '1'));
            boolean bVal = ((i <= b.length()) && (b.charAt(b.length()-i) == '1'));

            if (aVal && bVal)
            {
                out = (carry ? "1" : "0") + out;
                carry = true;   
            }
            else if (!aVal && !bVal)
            {
                out = (carry ? "1" : "0") + out;
                carry = false;
            }
            else
                out = (carry ? "0" : "1") + out;
        }
        return out;
    }


    /**
    * This function accepts two binary strings (Strings containing only the
    * characters '0' and '1') and returns the result of binary multiplication
    * of the binary numbers.
    * @param a - The first binary number
    * @param b - The second binary number
    * @return A String representing the binary sum of the two arguments.
    **/
    static String binaryMultiplication(String a, String b)
    {
        String bin = "0";  
        for (int i = b.length()-1; i >= 0; i--)
        {
            if (b.charAt(i) == '1')
                bin = binaryAddition(bin, a);
            a = a + "0";
        }
        return bin;
    }

    /** 
    * Convert number into a unix file permissions string
    * @param num - number to convert, such as 664
    * @return Unix file permissions string such as `rw-rw-r--`
    **/ 
    static String numberToFilePermissions(int num)
    {
        int d3 = num % 10;
        int d2 = (num/10) % 10;
        int d1 = (num/100) % 10;

        return toFileBinary(d1) + toFileBinary(d2) + toFileBinary(d3);
    }

    static String toFileBinary(int number)
    {
        String c = "rwx";
        String output = "";
        int i = 2;
        do {
            if (number % 2 == 1)
                output = c.charAt(i) + output;
            else
                output = "-" + output;
            i--;
            number /= 2;
        } while (output.length() < 3);

        return output;
    }

    /** 
    * Convert unix file permissions string to number
    * @param permissions - unix file permissions string such as `rw-rw-r--`
    * @return A string containing the number expressed in octal
    **/ 
    static int filePermissionsToNumber(String permissions)
    {
        int out = 0;  
        for (int i = 0; i < 3; i++)
        {
            int num = 1;  
            for (int j = 2; j >= 0; j--)
            {
                if (permissions.charAt((i*3)+j) != '-')
                    out += num * Math.pow(10,2-i);
                num *= 2;
            }
        }
        return out;
    }

    static int A(int n)
    {
        int num = 0;
        for (int i=1;i<=n;i++)
            for (int j=1;j<=n;j++)
                num++;
        return num;
    }

}
