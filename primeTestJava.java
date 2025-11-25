public class PrimeTestJava {
    
    public static boolean testLastDigit(int number){
        int lastDigit = number % 10;
        int[] noPrimeEnding = {0, 2, 4, 5, 6, 8};
        boolean notFound = true;
        
        for (int num : noPrimeEnding)
{
            if (num == lastDigit){
            notFound = false;
            break;
        }  
}
      
        return notFound;
    
}
 public static boolean testModulo(int number, boolean testResult) {
      
      for(int i = 2; i < number; i++){
            int moduloResult = number % i;
           
            
            if(moduloResult == 0) {
                testResult = false;
                break;
            } else {
                testResult = true;
               continue; 
            }
        }
    
        return testResult;
  }
    
    public static boolean testPrimeNumber(int number) {
        
        boolean testResult = true;
        if(number == 1){
            testResult = false;
        }else if(number == 5 || number == 2){
            
        }else if (testLastDigit(number) == true){ 
            
            if(testModulo(number, testResult) == false){
            testResult = false;
            }
        } else {testResult = false;}

        return testResult;
        
    }
    
}