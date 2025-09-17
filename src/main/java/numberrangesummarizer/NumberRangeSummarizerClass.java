package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberRangeSummarizerClass implements NumberRangeSummarizer{

   @Override
   @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
  
   /*Collect method
    *Takes each number from the input string, ignoring non-integer values.
    *Trims/removes whitespaces around each number.
    *Removes duplicates automaically by using HashSet.
    *Returns a desired collection of integers
    */
   public Collection<Integer> collect(String input){
    Set<Integer> numberSet = new HashSet<>();

        if (input != null && !input.isEmpty()) {
        String[] parts = input.split(",");
        for (String part : parts) {
            part = part.trim();
            if (!part.isEmpty()) {
                try {
                    numberSet.add(Integer.parseInt(part));
                } catch (NumberFormatException e) {
                    // Ignore invalid numbers
                }
            }
        }
    }

    List<Integer> sortedNumbers = new ArrayList<>(numberSet);
    Collections.sort(sortedNumbers);
    return sortedNumbers;
   }


   /*summarizeCollection method
    *Summarizes the collection of integers into sequential ranges.
    *Sorts the input collection.
    *Combines consecutive/sequential numbers into range using the format startNumber - endNumber.
    *Single numbers remamin as-is in correct sequence.
    *Handles negative numbers correctly.
    */
   @Override
   public String summarizeCollection(Collection<Integer> input){
    if (input == null || input.isEmpty()){
        return "";
    }

    List<Integer> numbers = new ArrayList<>(input);
    Collections.sort(numbers);

    StringBuilder result = new StringBuilder();
    int startNumber = numbers.get(0);
    int lastNumber = startNumber;

    for (int i = 1; i < numbers.size(); i++){
        int currentNumber = numbers.get(i);
         
         if(currentNumber != lastNumber + 1){
            appendRange(result, startNumber, lastNumber);
            result.append(", ");
            startNumber = currentNumber;
         }
         lastNumber = currentNumber;
    }

    appendRange(result, startNumber, lastNumber);
    return result.toString();

   }


   //Helper method that does Encapsulation
   private void appendRange(StringBuilder sb, int startNumber, int lastNumber){
    if (startNumber == lastNumber){
        sb.append(startNumber);
    }
    else{
        sb.append(startNumber).append("-").append(lastNumber);
    }
   }

}
