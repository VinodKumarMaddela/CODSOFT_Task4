import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask; 

public class Task4_Quiz {
    private static final int Question_Time_Limit = 10;
    private static final String[] Questions = {"what are a,e,i,o,u ?","which language does not support OOPS? "};

    private static final String [][] Options={{"A. Alphabet","B. Variable","C. Consonants","D. Vowels"},
                                                {"A.Java","B. Python","C. C","D. C++"}};


    private static final char[] Correct_Answers={'A','C'};
    private static int Score = 0;

    public static void main(String [] a)
    {
        System.out.println("Welcome to the Simple Quiz!");

        Scanner sc = new Scanner(System.in);
        for(int i =0;i < Questions.length;i++)
        {
            displayQuestion(i);

            Timer timer = new Timer();
            timer.schedule(new TimerTask()
            {
                int timeRemaining = Question_Time_Limit;

                public void run()
                {
                    if(timeRemaining == 0)
                    {
                        System.out.println("time up!");
                        timer.cancel();
                        displayResult();
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Time remaining:"+timeRemaining+"seconds");
                        timeRemaining--;
                    }
                }
            },0,1000);
            System.out.print("your answer:");
            char userAnswer = sc.next().toUpperCase().charAt(0);
            timer.cancel();

            if(userAnswer == Correct_Answers[i])
            {
                System.out.println("Correct");
                Score++;
            }
            else
            {
                System.out.println("Incorrect");
            }
        }
        displayResult();
        sc.close();
    }
    private static void displayQuestion(int index)
    {
        
        System.out.println(Questions[index]);
        for(String option : Options[index])
        {
            System.out.println(option);
        }
    }

    private static void displayResult()
    {
       
       System.out.println("Quiz completed!");
       System.out.println("our final score is:"+Score+"/"+Questions.length); 

    }
}
