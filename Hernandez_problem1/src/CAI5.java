import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Scanner;
import java.lang.Double;


public class CAI5 {
    private static String[] correctResponses = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};
    private static String[] incorrectResponses = {"No. Not this time.", "Wrong. Sorry.", "Don’t give up!", "No. Keep trying!"};
    private static String[] problemTypes = {"plus", "times", "minus", "divided by"};
    private static SecureRandom randGen;
    private static Scanner sc;

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        quiz();
    }
    
    public static void quiz() throws NoSuchAlgorithmException, NoSuchProviderException {
        randGen = SecureRandom.getInstance("SHA1PRNG", "SUN");
        sc = new Scanner(System.in);
        int correctResponses;
        double answer, userAnswer;
        boolean isCorrect;
        while (true) {
            System.out.println("Welcome, new student!");
            int diff = readDifficulty();
            int problemType = readProblemType();
            correctResponses = 0;
            for (int i = 0; i < 10; i++) {
                answer = askQuestion(diff, problemType);
                userAnswer = readResponse();
                isCorrect = isAnswerCorrect(userAnswer, answer);
                if (isCorrect) {
                    displayCorrectResponse();
                    correctResponses++;
                }
                else
                    displayIncorrectResponse();
            }
            displayCompletionMessage(correctResponses);
            // The directions contradicted each other so I went with requirements
            System.out.println("Would you like to solve another problem set? (y/n) ");
            String reply = sc.next();
            if (!reply.equals("y"))
                return;
        }
    }

    public static double askQuestion(int diff, int problemType) {
        int n1 = generateQuestionArgument(diff);
        int n2 = generateQuestionArgument(diff);
        double n1D = (double) n1;
        if (problemType == 5)
            problemType = randint(1, 5);
        if (n2 == 0 && problemType == 4)
            return askQuestion(diff, problemType);
        String operationString = problemTypes[problemType-1];
        System.out.println("How much is " + n1 + " "+operationString+" " + n2 + "?");
        switch (problemType) {
            case (1):
                return n1D + n2;
            case (2):
                return n1D * n2;
            case (3):
                return n1D - n2;
            default:
                return n1D / n2;
        }
    }

    public static int readDifficulty() {
        int diff;
        do {
            System.out.println("Please, choose difficulty. (1-4)");
            diff = sc.nextInt();
        } while (diff < 1 || diff > 4);
        return diff;
    }

    public static int readProblemType() {
        int type;
        do {
            System.out.println("Please, choose the type of the problem. [1) addition, 2) multiplication, 3) subtraction, 4) division, 5) Mix]");
            type = sc.nextInt();
        } while (type < 1 || type > 5);
        return type;
    }

    public static int generateQuestionArgument(int diff) {
        return randint(0, (int) Math.pow(10, diff));
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

    public static void displayCompletionMessage(int correctResponses) {
        double percentage = correctResponses / 10.0;
        System.out.println("You got " + correctResponses + "/10 questions right which is " + percentage *100 + "% correct");
        if (percentage < 0.75)
            System.out.println("Please ask your teacher for extra help.");
        else
            System.out.println("Congratulations, you are ready to go to the next level!");
    }

    public static int randint(int start, int end) {
        return randGen.nextInt(end - start) + start;
    }

}