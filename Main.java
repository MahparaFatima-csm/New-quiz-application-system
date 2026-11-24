
import java.util.Scanner;

// Parent class
class Question {

    // Encapsulation
    private String question;
    private String answer;

    // Constructor
    Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Getter methods
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    // Display question method
    void displayQuestion() {
        System.out.println(question);
    }
}

// Child class (Inheritance)
class MCQQuestion extends Question {

    private String[] options;

    // Constructor
    MCQQuestion(String question, String[] options,
                String answer) {

        super(question, answer);
        this.options = options;
    }

    // Method Overriding
    @Override
    void displayQuestion() {

        System.out.println(getQuestion());

        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
    }
}

// Main class
public class Main {

    // Method Overloading - Method 1
    static void displayWelcome() {
        System.out.println("WELCOME TO QUIZ APPLICATION");
    }

    // Method Overloading - Method 2
    static void displayWelcome(String name) {
        System.out.println("\nWelcome " + name);
        System.out.println("Let's start the quiz!\n");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Creating question objects
        Question[] questions = new Question[5];

        questions[0] = new MCQQuestion(
            "1. Which language is used for OOP?",
            new String[]{"A. HTML", "B. Java",
                         "C. CSS", "D. SQL"},
            "B"
        );

        questions[1] = new MCQQuestion(
            "2. Which keyword is used for inheritance?",
            new String[]{"A. this", "B. static",
                         "C. extends", "D. void"},
            "C"
        );

        questions[2] = new MCQQuestion(
            "3. Which keyword creates an object?",
            new String[]{"A. new", "B. class",
                         "C. return", "D. int"},
            "A"
        );

        questions[3] = new MCQQuestion(
            "4. Which concept protects data?",
            new String[]{"A. Loop", "B. Encapsulation",
                         "C. Array", "D. Method"},
            "B"
        );

        questions[4] = new MCQQuestion(
            "5. Which method is the starting point of Java?",
            new String[]{"A. start()", "B. run()",
                         "C. main()", "D. print()"},
            "C"
        );

        // Calling first overloaded method
        displayWelcome();

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        // Calling second overloaded method
        displayWelcome(name);

        int score = 0;

        // Display questions
        for (int i = 0; i < questions.length; i++) {

            System.out.println("\nQuestion " + (i + 1));

            // Polymorphism
            Question q = questions[i];

            q.displayQuestion();

            System.out.print("Enter your answer: ");
            String userAnswer = input.nextLine();

            // Check answer
            if (userAnswer.equalsIgnoreCase(q.getAnswer())) {

                System.out.println("Correct Answer!");
                score++;

            } else {

                System.out.println("Wrong Answer!");
                System.out.println(
                    "Correct answer: " + q.getAnswer()
                );
            }
        }

        // Final result
        System.out.println("\n===== QUIZ RESULT =====");

        System.out.println("Student Name: " + name);
        System.out.println("Total Questions: 5");
        System.out.println("Your Score: " + score + "/5");

        double percentage = (score / 5.0) * 100;

        System.out.println("Percentage: " + percentage + "%");

        System.out.println("Thank you for playing!");

        input.close();
    }
}