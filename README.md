# Number Range Summarizer

This project implements a Java solution for summarizing a list of numbers into ranges.  

Example:
Input: 1, 2, 3,4, 7, 8, 12, 13, 14, 15,16, 20
Output: 1-4, 7-8, 12-16, 20

## Features
- Collect numbers from a comma-separated string
- Remove duplicates and sort numbers
- Summarize sequences into ranges (e.g., `1,2,3,5` → `1-3, 5`)
- Handles negative numbers and invalid input

## Testing
JUnit tests are included in `NumberRangeSummarizerTest.java` covering:
- Standard inputs
- Empty inputs
- Duplicates
- Negative numbers
- Invalid/non-integer inputs


## Usage
- Open the project in any Java IDE (e.g., VS Code, IntelliJ, Eclipse)  
- Run `NumberRangeSummarizerClass` from `src/main/java/numberrangesummarizer` to see how provided interface was implemented
- Run tests in `NumberRangeSummarizerTest` from `src/test/java/numberrangesummarizer` to verify correctness  

---

## Notes
- Project requires **Java 8 or higher**  
- Unit tests demonstrate **correct handling of edge cases** and **good software design practices**


