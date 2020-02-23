import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Scanner;
import java.lang.Double;


public class CAI2 {
    private static String[] correctResponses = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};
    private static String[] incorrectResponses = {"No. Not this time.", "Wrong. Sorry.", "Don’t give up!", "No. Keep trying!"};
    private static SecureRandom randGen;
    private static Scanner sc;

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        quiz();
    }
    
    public static void quiz() throws NoSuchAlgorithmException, NoSuchProviderException {
        randGen = SecureRandom.getInstance("SHA1PRNG", "SUN");
        sc = new Scanner(System.in);
        double answer, userAnswer;
        boolean isCorrect;
        
        double n1 = (double) randint(0, 10);
        double n2 = (double) randint(0, 10);
        answer = n1 * n2;
        do {
            askQuestion(n1, n2);
            userAnswer = readResponse();
            isCorrect = isAnswerCorrect(userAnswer, answer);
            if (isCorrect)
                displayCorrectResponse();
            else
                displayIncorrectResponse();
            } while (!isCorrect);
    }

    public static double askQuestion(double n1, double n2) {
        System.out.println("How much is " + (int)n1 + " times " + (int)n2 + "?");
        return n1 * n2;
    }

    public static double readResponse() {
        return sc.nextDouble();
    }

    public static boolean isAnswerCorrect(double studentAnswer, double realAnswer) {
        return Double.compare(studentAnswer, realAnswer) == 0;
    }

    public static void displayCorrectResponse() {
        int rand = randint(0, 4);
        System.out.println(correctResponses[rand]);
    }
    public static void displayIncorrectResponse() {
        int rand = randint(0, 4);
        System.out.println(incorrectResponses[rand]);
    }

    public static int randint(int start, int end) {
        return randGen.nextInt(end - start) + start;
    }

}