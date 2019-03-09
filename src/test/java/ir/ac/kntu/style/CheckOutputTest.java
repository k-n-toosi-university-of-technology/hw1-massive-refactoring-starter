package ir.ac.kntu.style;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

import ir.ac.kntu.MassiveRefactoring;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 100 points
 * @author mhrimaz, sfathi
 */
public class CheckOutputTest {
    private final static int TIME_LIMIT = 100_000;

    static {
        System.err.println("$$$GRADER$$$ | { type:\"MSG\" , key:\"TOTAL\" , value:120, priority:1  }  | $$$GRADER$$$");
    }


    private final static String SEPARATOR = "\n";


    private static boolean checkRefactoring(String[] initials, String[] targets,
                                            String expected) {
        InputStream inputStream = null;
        PrintStream printStream = null;
        try {
            File input = new File("input.txt");
            input.createNewFile();
            File output = new File("output.txt");
            output.createNewFile();
            inputStream = new FileInputStream(input);
            printStream = new PrintStream(output);
            try (PrintWriter w = new PrintWriter(input)) {
                w.println(initials.length);
                Arrays.stream(initials).forEach(initial -> w.println(initial));
                Arrays.stream(targets).forEach(target -> w.println(target));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(output))) {
                System.setIn(inputStream);
                System.setOut(printStream);
                MassiveRefactoring.main(new String[]{});
                String found = reader.lines().collect(Collectors.joining(SEPARATOR));
                if(found == null){
                    found = "";
                }
                return found.equals(expected);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
                printStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }



    @Test(timeout = TIME_LIMIT)
    public void tesCase1(){
        assertTrue(checkRefactoring(new String[]{"topforces"}, new String[]{"codecoder"},
                "YES" + SEPARATOR + "topforces" + SEPARATOR + "codecoder"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:1 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase2(){
        assertTrue(checkRefactoring(new String[]{"bab", "cac", "cdc"}, new String[]{"bdb", "cdc", "cdc"},
                "YES" + SEPARATOR + "a" + SEPARATOR + "d"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase3(){
        assertTrue(checkRefactoring(new String[]{"you", "shall"}, new String[]{"not", "cheat"},
                "NO"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase4(){
        assertTrue(checkRefactoring(new String[]{"salam"}, new String[]{"merci"},
                "YES" + SEPARATOR + "salam" + SEPARATOR + "merci"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase5(){
        assertTrue(checkRefactoring(
                new String[]{"somethingp", "abcdefp", "asdfgp", "p"},
                new String[]{"somethingq", "abcdefq", "asdfgq", "q"},
                "YES" + SEPARATOR + "p" + SEPARATOR + "q"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase6(){
        assertTrue(checkRefactoring(
                new String[]{"somethingp", "abcdefp", "asdfgp"},
                new String[]{"somethingq", "abcdefq", "asdfgq"},
                "YES" + SEPARATOR + "p" + SEPARATOR + "q"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase7(){
        assertTrue(checkRefactoring(
                new String[]{"psomething", "pabcdefg", "pbcacb", "p"},
                new String[]{"qsomething", "qabcdefg", "qbcacb", "q"},
                "YES" + SEPARATOR + "p" + SEPARATOR + "q"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase8(){
        assertTrue(checkRefactoring(
                new String[]{"psomething", "pabcdefg", "pbcacb"},
                new String[]{"qsomething", "qabcdefg", "qbcacb"},
                "YES" + SEPARATOR + "p" + SEPARATOR + "q"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase9(){
        assertTrue(checkRefactoring(
                new String[]{"somepthing", "abcpdefg", "bcacpb", "p"},
                new String[]{"someqthing", "abcqdefg", "bcacqb", "q"},
                "YES" + SEPARATOR + "p" + SEPARATOR + "q"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase10(){
        assertTrue(checkRefactoring(
                new String[]{"somepthing", "abcpdefg", "bcacpb"},
                new String[]{"someqthing", "abcqdefg", "bcacqb"},
                "YES" + SEPARATOR + "p" + SEPARATOR + "q"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase11(){
        assertTrue(checkRefactoring(
                new String[]{"somethinga", "abcdefg", "bcacb", "a"},
                new String[]{"somethingb", "bbcdefg", "bcbcb", "b"},
                "YES" + SEPARATOR + "a" + SEPARATOR + "b"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase12(){
        assertTrue(checkRefactoring(
                new String[]{"somethinga", "abcdefg", "bcacb"},
                new String[]{"somethingb", "bbcdefg", "bcbcb"},
                "YES" + SEPARATOR + "a" + SEPARATOR + "b"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase13(){
        assertTrue(checkRefactoring(
                new String[]{"somethinga", "abcdefg", "bcacb", "variable"},
                new String[]{"somethingb", "bbcdefg", "bcbcb", "variable"},
                "NO"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase14(){
        assertTrue(checkRefactoring(
                new String[]{"somethinga", "abcdefg", "bcacb", "variable"},
                new String[]{"somethingb", "bbcdefg", "bcbcb", "vbriable"},
                "YES" + SEPARATOR + "a" + SEPARATOR + "b"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase15(){
        assertTrue(checkRefactoring(
                new String[]{"somethinga", "abcdefg", "bcacb", "variable"},
                new String[]{"somethingb", "bbcdefg", "bcbcb", "varibble"},
                "NO"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase16(){
        assertTrue(checkRefactoring(
                new String[]{"somethinga", "abcdefg", "bcacb"},
                new String[]{"somethingb", "abdefgh", "bcbcb"},
                "NO"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }


    @Test(timeout = TIME_LIMIT)
    public void testCase18(){
        boolean result1 = checkRefactoring(
                new String[]{"something", "variabled", "qwerty"},
                new String[]{"something", "variables", "qwerty"},
                "YES" + SEPARATOR + "variabled" + SEPARATOR + "variables");
        boolean result2 = checkRefactoring(
                new String[]{"something", "variabled", "qwerty"},
                new String[]{"something", "variables", "qwerty"},
                "YES" + SEPARATOR + "d" + SEPARATOR + "s");

        assertTrue(result1 || result2);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase19(){
        assertTrue(checkRefactoring(
                new String[]{"i"},
                new String[]{"q"},
                "YES" + SEPARATOR + "i" + SEPARATOR + "q"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase20(){
        assertTrue(checkRefactoring(
                new String[]{"zzzzzzzz", "yyyyyyyy"},
                new String[]{"yyyyyyyy", "zzzzzzzz"},
                "NO"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase21(){
        assertTrue(checkRefactoring(
                new String[]{"abbaba", "aaa"},
                new String[]{"abbaba", "bbb"},
                "YES" + SEPARATOR + "aaa" + SEPARATOR + "bbb"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:2 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase22(){
        final String[] initials = {"quuwueiwoeuwiiiwoeooowiiieie",
                "ajjdksjdksnckdllskdlsoodhfjdksjd",
                "qowiqjjwhqjjzbbxnnnzmmzmmxbxnznnnzbx",
                "eoowjhsalskj",
                "oodkfodookokokokdokofkdkkko",
                "llqkwlllqkdjsksbbdnsoidhsjjskdhg",
                "sjjaksldhsjjaksbbdjskalskdjjshsjjjshhhdjsooshd",
                "hdjfbbdnfbdkspsnapppshajakkajahshhha",
                "oowkeoowkeowkowkoekowkojjqkwl",
                "koskdooskaosmzzxpaffqkyertsuwqzhklt"};
        final String[] tagets = {"quuwueiwoeuwiiiwoeooowiiieie",
                "ajjdksjdksnckdllskdlsoodhfjdksjd",
                "qowiqjjwhqjjzbbxnnnzmmzmmxbxnznnnzbx",
                "eqssthjhyioj",
                "oodkfodookokokokdokofkdkkko",
                "llqkwlllqkdjsksbbdnsoidhsjjskdhg",
                "sjjaksldhsjjaksbbdjskalskdjjshsjjjshhhdjsooshd",
                "hdjfbbdnfbdkspsnapppshajakkajahshhha",
                "oowkeoowkeowkowkoekowkojjqkwl",
                "koskdooskaosmzzxpaffqkyertsuwqzhklt"};
        final String yes = "YES";
        boolean answerFound = checkRefactoring(initials, tagets,
                yes + SEPARATOR + "eoowjhsalskj" + SEPARATOR + "eqssthjhyioj");
        if (!answerFound){
            answerFound =checkRefactoring(initials, tagets,
                    yes + SEPARATOR + "oowjhsalskj" + SEPARATOR + "qssthjhyioj");
        }
        if (!answerFound){
            answerFound =checkRefactoring(initials, tagets,
                    yes + SEPARATOR + "eoowjhsalsk" + SEPARATOR + "eqssthjhyio");
        }
        if (!answerFound){
            answerFound =checkRefactoring(initials, tagets,
                    yes + SEPARATOR + "oowjhsalsk" + SEPARATOR + "qssthjhyio");
        }


        assertTrue(answerFound);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:8 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase23(){
        final String[] initials = {"ilonmaskmeforhelpkekcheburek",
                "ceilonmaskmeforhelpkekshrek",
                "iloveyousoiloveyousoaskmeforhel",
                "dontforgetifskmeforhelp",
                "trololokekcheburek",
                "askmeforhelpaskmeforhelp",
                "askaskaskaskmeforhelp",
                "kudahtahtahaskmeforhelpkekcheburek",
                "sosososososososososososososososo",
                "youshallnotpassifyoudontaskmeforhelp"};
        final String[] targets = {"ilonmaskmyselfoupkekcheburek",
                "ceilonmaskmyselfoupkekshrek",
                "iloveyousoiloveyousoaskmeforhel",
                "dontforgetifskmeforhelp",
                "trololokekcheburek",
                "askmyselfoupaskmeforhelp",
                "askaskaskaskmyselfoup",
                "kudahtahtahaskmyselfoupkekcheburek",
                "sosososososososososososososososo",
                "youshallnotpassifyoudontaskmyselfoup"};
        final String yes = "YES";
        boolean answerFound = checkRefactoring(initials, targets,
                yes + SEPARATOR + "askmeforhelp" + SEPARATOR + "askmyselfoup");


        assertTrue(answerFound);
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:6 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase24(){
        assertTrue(checkRefactoring(
                new String[]{"xax", "yay"},
                new String[]{"xbx", "ycy"},
                "NO"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:6 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    //NEW TESTS

    @Test(timeout = TIME_LIMIT)
    public void testCase25(){
        assertTrue(checkRefactoring(
                new String[]{"abccbxcbd", "dbdfdcbd"},
                new String[]{"abccbxcbf", "dbffdcbd"},
                "YES"+ SEPARATOR + "bd" + SEPARATOR + "bf"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:6 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }



    @Test(timeout = TIME_LIMIT)
    public void testCase26(){
        assertTrue(checkRefactoring(
                new String[]{"abccbfcbd", "fd"},
                new String[]{"abccbfcbf", "ff"},
                "YES"+ SEPARATOR + "d" + SEPARATOR + "f"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:6 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

    @Test(timeout = TIME_LIMIT)
    public void testCase27(){
        assertTrue(checkRefactoring(
                new String[]{"dabccbfcbd", "fd"},
                new String[]{"fabccbfcbf", "ff"},
                "NO"));

        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:3 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }



    @Test(timeout = TIME_LIMIT)
    public void testCase28(){
        assertTrue(checkRefactoring(
                new String[]{"cdetgkef", "efkefg"},
                new String[]{"cdetgktf", "tfkefg"},
                "YES"+ SEPARATOR + "ef" + SEPARATOR + "tf"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:14 , reason:\"Your Output is correct.\" } | $$$GRADER$$$" );
    }

}
