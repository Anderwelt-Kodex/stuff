import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.math.BigDecimal;
import java.math.RoundingMode;
//The customer gets a discount on his purchase for sets of different items. Each item can be part of only one set.

class ItemStore {
    //Counts how many different Items are left
    static int countingDifferentItems (ArrayList<Integer>howManyOfEachItem){
        int differentItemsCount = 0;
        for(Integer countedCopies : howManyOfEachItem){
            if (countedCopies > 0){
            differentItemsCount = differentItemsCount + 1;
            }
        }
        return differentItemsCount;
    }
 //Calculates the price with the discount for a item package, than rounds up
static double priceCalcWithDisc (int e, double newPriceResult, double price, double [] discount) {
       
        newPriceResult = newPriceResult + (price*e*discount[e]);
        return new BigDecimal(newPriceResult).setScale(2, RoundingMode.HALF_UP).doubleValue();

    }
    //Creates a new ArrayList for the quantity left for each item
static ArrayList<Integer> newQuantityOfItems (int e, ArrayList<Integer>howManyOfEachItem) {
    
    ArrayList<Integer> temp = new ArrayList<>(howManyOfEachItem);
    ArrayList<Integer> newHowManyOfEachItem = new ArrayList<>(howManyOfEachItem);
    ArrayList<Integer> indices = new ArrayList<>();
    
    //Find max value, add the first of max value to index, set used value to 0
    
    for (int i = 0; i < e ; i++) {
        // Find the maximum value
        int maxValue = Collections.max(temp);

        // Find first index of that value
        int index = temp.indexOf(maxValue);
        
        //Add index number to indices
        indices.add(index);
        
        //Set used index value to 0
        temp.set(index, 0);
        
        
    }
    // Deduct 1 item from the stack for every value in indices
    for (int index : indices) {
        int sourceValue = newHowManyOfEachItem.get(index);

        // Set value to value -1
        newHowManyOfEachItem.set(index, sourceValue - 1);
    }

    return  newHowManyOfEachItem;
}
    public static final List<Integer> example = Collections.unmodifiableList(
    new ArrayList<Integer>() {{
        example.add(1);
        example.add(1);
        example.add(1);
        example.add(2);
        example.add(2);
        example.add(2);
        example.add(3);
        example.add(3);
        example.add(3);
        example.add(4);
        example.add(4);
        example.add(4);
        example.add(5);
        example.add(5);
        example.add(5);
         // trough comment and adding get different baskets
    }});
    
    public double calculateBasketCost(final List<Integer> example) {
       //for running change 
       // public static void main(String[] args) {
      //List <Integer> example = new ArrayList<>();
	

		// Create List for the differnt results
	    ArrayList<Double> resultOptions  = new ArrayList<>();
	    
	    //variables for calculating the prices
		double price = 5.00;
		double priceResult = 0.00;
		double [] discount = {0.00, 1.00, 0.95, 0.90, 0.85, 0.80};
		
        // Create ArrayList with correlating index to items
		ArrayList<Integer> howManyOfEachItem  = new ArrayList<>();
		for(int i = 0; i < 6; i++ ){
		    howManyOfEachItem.add(i, 0);
		}
		
		// Count the quantity of each Item 
		Iterator<Integer> itItems = example.iterator(); //beispiel original Arraylist
		while(itItems.hasNext()) {
        Integer x = itItems.next();
        int inputValue = howManyOfEachItem.get(x) + 1;
	  	        howManyOfEachItem.set(x, inputValue);
		}

    if(Collections.max(howManyOfEachItem) == 0) {
        //no Items
        priceResult = 0.0;
        
    }   else if (countingDifferentItems(howManyOfEachItem) == 1){
        //one kind of Item
        
		int oneItemQuantity = (int)Collections.max(howManyOfEachItem);
		priceResult = priceResult + (price*oneItemQuantity);
		
		
    
        } else {
        //Loop as long there are something to count
        for (int z = countingDifferentItems(howManyOfEachItem); z > 0; z--) { //5,4,3,2,1
        
         ArrayList<Integer> howManyOfEachItemCopy = new ArrayList<>(howManyOfEachItem);
         double priceResultTemp = 0.0;
         int differentItemsCount = countingDifferentItems(howManyOfEachItemCopy);
        //Loop as long there are Items not acounted for in the stack 
         while((int)Collections.max(howManyOfEachItemCopy) > 0){
         //Loop for different discounts
            while(differentItemsCount > z){
                differentItemsCount = countingDifferentItems(howManyOfEachItemCopy);
                priceResultTemp = priceCalcWithDisc(z, priceResultTemp, price, discount);
                howManyOfEachItemCopy = newQuantityOfItems(z, howManyOfEachItemCopy);
            }
            differentItemsCount = countingDifferentItems(howManyOfEachItemCopy);
            priceResultTemp = priceCalcWithDisc(differentItemsCount, priceResultTemp, price, discount);
            howManyOfEachItemCopy = newQuantityOfItems(differentItemsCount, howManyOfEachItemCopy);
               
        }
        //add every option for discunted price to list
        resultOptions.add(priceResultTemp);
             }
             //best discounted price will be set as result
        priceResult = Collections.min(resultOptions);
        }
        //System.out.println(priceResult);
        return priceResult;
 

    }
}