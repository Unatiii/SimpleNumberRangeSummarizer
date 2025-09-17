package numberrangesummarizer;

public class Main{
    public static void main (String[] args){
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerClass();

        //Some inputs for quick manual testing
        String input = "1,2,3,6,7,8,13,14,15,21,22,23,24,31,32, 33, 38";

        //Step 1: Collecting the numbers
        System.out.println("Collecting numbers...");
        System.out.println(summarizer.collect(input));

        //Step 2: Grouping or summarizing sequential numbers into a range
        System.out.println("Summarizing into range...");
        System.out.println(summarizer.summarizeCollection(summarizer.collect(input)));
    }
}