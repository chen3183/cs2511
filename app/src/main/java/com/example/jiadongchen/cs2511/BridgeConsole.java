package com.example.jiadongchen.cs2511;

import java.util.Scanner;

/**
 * Created by Jiadong Chen on 7/8/2015.
 */
public class BridgeConsole {
    private String Option=
            "Options:\n"
                    +" 1. P1 corcesses alone\n"
                    +" 2. P2 crocesses alone\n"
                    +" 3. P5 crocesses alone\n"
                    +" 4. P10 crocesses alone\n"
                    +" 5. P1 crocesses with P2\n"
                    +" 6. P1 crocesses with P5\n"
                    +" 7. P1 crocesses with P10\n"
                    +" 8. P2 crocesses with P5\n"
                    +" 9. P2 crocesses with P10\n"
                    +" 10. P5 crocesses with P10\n";
    private int MoveCount=0;
    private int NewOption;
    private BridgeState NewState=null;

    /**
     Creates a bridge problem console user interface.  An introduction
     is displayed, the move count is initialized, the initial state is
     displayed, the first move is solicited, and problem solution proceeds.
     @param problem the problem
     */
    public BridgeConsole(BridgeProblem problem)
    {
        System.out.println(problem.getIntroduction()+"Here is your initial state");
        do
        {
            System.out.println(problem.getCurrentState().toString());
            System.out.println(Option);
            do
            {
                NewOption=GetOption();
                if(NewOption==0)
                {
                    System.out.println("Quit successfully. You tried "+MoveCount + " moves");
                    System.exit(0);
                }
                if(NewOption>10 || NewOption <0)
                    System.out.println("Option out of range. Try again.");
                else
                    NewState=problem.getMoves().get(NewOption-1).doMove(problem.getCurrentState());
                if(NewState==null)
                    System.out.println("That move is not possible. Try again!");
            }while (NewState==null || NewOption>10 || NewOption <0);
            MoveCount++;
            problem.setCurrentState(NewState);
        }while(!problem.success());
        System.out.println("Congratulation! Yout slove it in "+MoveCount+" move.");
        System.exit(0);
    }

    /**
     * This method launches the console
     * @param args ignored
     */
    /**
     * This class will prompt users a option of operations and avoid some error inputs.
     * @return The option of operation.
     */
    private static int GetOption()
    {
        Scanner input= new Scanner(System.in);
        System.out.println("Choose 1-10 (zero to quit):");
        String in=input.nextLine();
        try
        {
            int age = Integer.parseInt(in);
            return age;
        }
        catch (NumberFormatException e)
        {
            System.out.println("OPtion not an integer. Try again.");
            return GetOption();
        }
    }
}
