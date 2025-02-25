import java.util.Scanner;
import java.util.EnumSet;

public class ErrorsEnum
{
    enum Error { FP_ROUNDING, FP_OVERFLOW, FP_UNDERFLOW, INT_OVERFLOW }

    enum Result { A_BIT_DIFFERENT, INFINITY, ZERO, VERY_DIFFERENT }
    
    private static <E extends Enum<E>> E getEnumElement(String elementTypeName, Class<E> elementType)
    {
        boolean haveResult = false;
        E result = null;
        Scanner stdin = new Scanner(System.in);
        
        while ( ! haveResult )
        {
            System.out.print("Input " + elementTypeName + ": ");
            try
            {
                result = Enum.valueOf(elementType, stdin.next().toUpperCase());
                haveResult = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Not a valid " + elementTypeName + ".");
                stdin.nextLine(); // skip the invalid input
            }
        }
        
        stdin.close();
        return result;
    }
  
    private static Result error2Result(Error e)
    {
        Result result = null;
        
        switch (e) {
        case FP_ROUNDING:
            result = Result.A_BIT_DIFFERENT;
            break;
        case FP_OVERFLOW:
            result = Result.INFINITY;
            break;
        case FP_UNDERFLOW:
            result = Result.ZERO;
            break;
        case INT_OVERFLOW:
            result = Result.VERY_DIFFERENT;
            break;
        }
        
        return result;
    }

    public static void main(String[] args)
    {
        System.out.print("Known errors = ");
        for (Error e : EnumSet.allOf(Error.class)) 
        {
            System.out.print(e + " "); //convert enumerated value (symbol) to string
        }
        System.out.println();
        
        Error e = getEnumElement("error", Error.class);
        System.out.println(e + " results in: " + error2Result(e)); //convert enumerated value (symbol) to string
    }
}



public class ErrorsEnumSolution {
    private static Error result2Error(Result e) {
        Error error = null;

        case A_BIT_DIFFERENT:
            error = Error.FP_ROUNDING;
        case INFINITY:
            error = Error.FP_OVERFLOW;
        case ZERO:
            error = Error.FP_UNDERFLOW;
        case VERY_DIFFERENT:
            error = Error.INT_OVERFLOW;
        return error;

        System.out.print("Known results = ");
        for (Result r : EnumSet.allOf(Result.class))

        System.out.print(r + " ");

        Result r = getEnumElement("result", Result.class);
        System.out.println(r + " results from: " + result2Error(r))
    }
}



