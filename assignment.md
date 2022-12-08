
Part 1:  Spell Checker App - Enhancement

Implement the SpellCheck app in Chapter 15.3 of your text.   To do this,  create a new project in IntelliJ called WordListReader or a name of your choice.  Add a Java class to your src directory called SpellCheck.java.   Download SpellCheck.java Download SpellCheck.javahere and replace the empty code file in IntelliJ.  
Follow the tutorial on setting up a file path in IntelliJ using a resources directory. 
Add the words Download wordsand alice30.txt Download alice30.txtfile to your new resources directory. 
Test the SpellCheck executable using the provided data files. 
Create your own data files and add them to the resources directory.  Try to find other large text files on the internet so that you will have a reasonable dataset.   Add a new method with code to test SpellCheck to test your new files in addition to the code already included.  
Submit your .java source code files,  screenshots, or text files of your test output, and all data files to Canvas.   
Part 2:   HashSets and TreeSets  - Testing Algorithm Performance

1.   Patterning your code on the SpellCheck class,  add a new class of your own.  I created a new class called SpellChecker.  

In the previous exercise, we demonstrated a static method called readWords (String fileName) which reads a file and added the words to a HashSet.   In this exercise,  we will use other data structures, and then test the performance of these alternatives.  Before you proceed too far,  make sure you read the tutorials to become familiar with HashSet and TreeSet, and how these compare to each other and to ArrayList, with which you are by now, quite familiar.

HashSet offers constant time cost while TreeSet offers log(n)
time cost for such operations.  Review the meaning of these Big O performance metrics and which is faster.  2) HashSet does not maintain any order
of elements while TreeSet elements are sorted in ascending order by default. 

Which of these two data structures is likely to be faster according to Big O Notation theory? 

Steps: 

 Create a new class called  SpellChecker and add it to your project.   Your new class should have its main method.  
 Implement a new method readWordsArrayList(String filename)  similar to the static method readWords(String filename) method from your SpellChecker class.  You can put your new method either inside SpellChecker so that this class has more reading options.  I find it more readable to add the method to SpellChecker,   but if you wish it could also be inside HashAndTreeSetTester.  The new method will load your words into an ArrayList instead of into a HashSet.   Don't use static methods in your new class.  
Implement a second new method called readWordsTreeSet(String filename) and add it to your  SpellChecker or HashAndTreeSetTester class. You will now have three reading options:    readWordsTreeSet, readWordsArrayList, and readWords from the SpellChecker.  If you wish you can change the name readWords to readWordsHashSet to better denote what data structure it uses. 
In your SpellChecker class, create a main method and test driver method named something like spellCheckerTest().  This class should also contain your three methods readWordsArrayList, readWordsHashSet, and readWordsTreeSet.  These methods should not be declared static.     
public static void main(String[] args)  throws FileNotFoundException {
    SpellChecker spellCheck = new SpellChecker();
    spellCheck.spellCheckerTest();
}
5.   Read the dictionary into your three data structures: 

Set<String> dictionaryWords = readWordsHashSet("./resources/words");
Set<String> dictionaryWords2 = readWordsTreeSet("./resources/words");
ArrayList<String> dictionaryWords3 = readWordsArrayList("./resources/words");

6.   You will need a large text file for testing your new class such as the one you used in Lab 1.  Otherwise,  you can use the text from the book War-and-Peace.txt Download War-and-Peace.txt, one of the longest novels ever written. 

Make sure your test text file (which can be War-and-Peace.txt Download War-and-Peace.txt) is installed in your resources directory as before. 

 Read in the war-and-peace.txt into a hashSet as follows:   

Set<String> documentWords = readWordsHashSet("./resources/war-and-peace.txt");

Now,  using the same pattern used in SpellCheck,  count the words in the document that do not appear in your dictionaries, timing how long it takes to look up the words for each data structure.  You will use the provided StopWatch class to time your executions.  Perform the same test with dictionaryWords2 and dictionaryWords3.  Note how you will need to reset wordCount and stopWatch after each test.   You will need to use the StopWach.java class provided in the assignment. Download StopWatch.java Download StopWatch.java.  Add a new class to your project.  Name the ass StopWatch.  Replace the code in your new class with the code in StopWatch.java.  

stopWatch.start();
System.out.println("Words not found in dictionary...");
for (String word : documentWords)
{
    if (!dictionaryWords.contains(word))
    {
        wordCount++;
    }
}
stopWatch.stop();
System.out.println("Word not found count:  " + wordCount + ", words in dictionary " + dictionaryWords.size());
wordCount = 0;
System.out.println("Elapsed Time HashSet " + stopWatch.getElapsedTime() + " ms\n");
stopWatch.reset();
7.  Comparing these data structures,  can you explain the differences in these results?  Why does ArrayList have so many more words than the others? What is the biggest difference between ArrayList and the other two Data Structures?  Why would you not use ArrayList for a large dictionary project?  Which Big-O notation time costs of TreeSet versus HashSet are greater?   Why would you choose TreeSet over HashSet?   Is the data the same between the two structures?  Run your test several times.   Do the elapsed times vary significantly between test runs?   What does this tell you if anything about best practices for profiling and measuring the comparative efficiency of algorithms?  
