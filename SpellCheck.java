import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class SpellCheck{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    Set<String> dictionaryWords;
    Set<String> wonderWords;
    Set<String> warPeace;

    public static void main(String[] args) throws FileNotFoundException
    {
        SpellCheck object = new SpellCheck();

        object.dictionaryWords = readWordsHashSet("resources/words");
        object.wonderWords = readWordsHashSet("resources/alice30.txt");
        object.warPeace = readWordsHashSet("resources/war-and-peace.txt");
        System.out.println(ANSI_WHITE_BACKGROUND+"******************************************"+ ANSI_RESET);
        System.out.println("Enhancement");
        object.enhance();
        System.out.println(ANSI_WHITE_BACKGROUND+"******************************************"+ ANSI_RESET);
        System.out.println("Performance");
        object.perform();
        System.out.println(ANSI_WHITE_BACKGROUND+"******************************************"+ ANSI_RESET);
    }
    public static ArrayList<String> readWordsArrayList(String filename) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext())
        {
            words.add(in.next().toLowerCase());
        }
        return words;
    }
    public static Set<String> readWordsHashSet(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext())
        {
            words.add(in.next().toLowerCase());
        }
        return words;
    }
    public static TreeSet<String> readWordsTreeSet(String filename) throws FileNotFoundException {
        TreeSet<String> words = new TreeSet<>();
        Scanner in = new Scanner(new File(filename));
        // Use any characters other than a-z or A-Z as delimiters
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext())
        {
            words.add(in.next().toLowerCase());
        }
        return words;
    }
    void spellCheck(Set<String> set) {
        for (String word : set)
        {
            if (!dictionaryWords.contains(word))
            {
                System.out.println(word);
            }
        }
    }
    void testCaseArrayList() throws FileNotFoundException {
        System.out.println("Starting Read ArrayList Test");
        long arrayListTime;
        StopWatch timer = new StopWatch();
        timer.start();
        ArrayList<String>  words = readWordsArrayList("resources/alice30.txt");
        timer.stop();
        arrayListTime = timer.getElapsedTime();
        timer.reset();
        System.out.println("Elapsed time for arraylist "+ANSI_RED+ arrayListTime + ANSI_RESET+ " milliseconds.  Number of words: "+ANSI_YELLOW+ words.size()+ANSI_RESET);
    }
    void testCaseHashSet() throws FileNotFoundException {
        System.out.println("Starting Read HashSet Test");
        long hashSetTime;
        StopWatch timer = new StopWatch();
        timer.start();
        Set<String>  words = readWordsHashSet("resources/alice30.txt");
        timer.stop();
        hashSetTime = timer.getElapsedTime();
        timer.reset();
        System.out.println("Elapsed time for hashset "+ANSI_RED+ hashSetTime + ANSI_RESET+" milliseconds.  Number of words: " +ANSI_YELLOW+ words.size()+ANSI_RESET);
    }
    void testCaseTreeSet() throws FileNotFoundException {
        System.out.println("Starting Read TreeSet Test");
        long treeSetTime;
        StopWatch timer = new StopWatch();
        timer.start();
        TreeSet<String>  words = readWordsTreeSet("resources/alice30.txt");
        timer.stop();
        treeSetTime = timer.getElapsedTime();
        timer.reset();
        System.out.println("Elapsed time for treeset "+ANSI_RED+ treeSetTime + ANSI_RESET+ " milliseconds.  Number of words: " +ANSI_YELLOW+ words.size()+ANSI_RESET);
    }
    void enhance() {
        System.out.println(ANSI_WHITE_BACKGROUND+"******************************************"+ ANSI_RESET);
        System.out.println(ANSI_RED+"Alice in wonderland words: "+ ANSI_RESET);
        spellCheck(wonderWords);
        System.out.println(ANSI_WHITE_BACKGROUND+"******************************************"+ ANSI_RESET);
        System.out.println(ANSI_BLUE+"War and Peace: "+ ANSI_RESET);
        spellCheck(warPeace);
        System.out.println(ANSI_WHITE_BACKGROUND+"******************************************"+ ANSI_RESET);
    }
    void perform() throws FileNotFoundException {
        testCaseArrayList();
        testCaseHashSet();
        testCaseTreeSet();
    }
}