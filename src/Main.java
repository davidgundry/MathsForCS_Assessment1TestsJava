import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class Main
{
  /**
   * This runs the unit tests to help you check your code
   */
  public static void main(String[] args)
  {
      Result result = JUnitCore.runClasses(TestLogic.class);
      for (Failure failure : result.getFailures())
         System.out.println(failure.toString());
      System.out.println(result.wasSuccessful());
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
        return null;
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
        return null;
    }

    /** 
    * Convert number into a unix file permissions string
    * @param num - number to convert, such as 664
    * @return Unix file permissions string such as `rw-rw-r--`
    **/ 
    static String numberToFilePermissions(int num)
    {
        return null;
    }

    /** 
    * Convert unix file permissions string to number
    * @param permissions - unix file permissions string such as `rw-rw-r--`
    * @return An integer expressing the equivalent octal value
    **/ 
    static int filePermissionsToNumber(String permissions)
    {
        return 0;
    }

    /**
    * This function implements the following pseudo-code:
    * Function A(n)
    *     num := 0
    *     for (i = 1 to n)
    *         for (j = 1 to n)
    *             num := num + 1
    *         endfor
    *     endfor
    * return num 
    * @param n - an integer
    * @return the result of the pseudo-code function above
    */
    static int A(int n)
    {
        return 0;
    }

}
