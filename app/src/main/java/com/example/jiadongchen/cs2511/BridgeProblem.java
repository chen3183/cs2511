package com.example.jiadongchen.cs2511;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiadong Chen on 7/8/2015.
 */


public class BridgeProblem {


    private BridgeState CState;
    private List<BridgeMove> aBridgeMoveList = new ArrayList<BridgeMove>();
    private final BridgeState finalBridgeState = new BridgeState(Position.EAST,Position.EAST,Position.EAST,Position.EAST,Position.EAST,0);
    String introduction=
            "Welcome to the Bridge Crossing Problem.\n\n" +
                    "Person Pn can cross the bridge in n minutes.\n" +
                    "Only one or two persons can cross at a time because it is dark,\n" +
                    "and the flashlight must be taken on every crossing.\n" +
                    "When two people cross, they travel at the speed of the slowest person.\n" +
                    "Devise a sequence of crossings so that all four people get across\n" +
                    "the bridge in no more than 17 minutes.\n\n";
    /**
     * The bridge problem constructor should create the initial bridge state
     * object and store it as the problem's current state.
     * It should also create the 10 valid bridge move objects and store them
     * on an accessible list.
     */
    public BridgeProblem()
    {
        CState=new BridgeState(Position.WEST,Position.WEST,Position.WEST,Position.WEST,Position.WEST,0);
        aBridgeMoveList.add(new BridgeMove("P1 crosses alone"));
        aBridgeMoveList.add(new BridgeMove("P2 crosses alone"));
        aBridgeMoveList.add(new BridgeMove("P5 crosses alone"));
        aBridgeMoveList.add(new BridgeMove("P10 crosses alone"));
        aBridgeMoveList.add(new BridgeMove("P1 crosses with P2"));
        aBridgeMoveList.add(new BridgeMove("P1 crosses with P5"));
        aBridgeMoveList.add(new BridgeMove("P1 crosses with P10"));
        aBridgeMoveList.add(new BridgeMove("P2 crosses with P5"));
        aBridgeMoveList.add(new BridgeMove("P2 crosses with P10"));
        aBridgeMoveList.add(new BridgeMove("P5 crosses with P10"));
    }

    /**
     * Getter (accessor) for this problem's introduction string.
     * @return the introduction string
     */
    public String getIntroduction()
    {
        return introduction;
    }

    /**
     * Getter (accessor) for this problem's list of valid bridge move objects.
     * @return the list of bridge moves
     */
    public List<BridgeMove> getMoves()
    {
        return aBridgeMoveList;
    }

    /**
     * Tests for whether the current state of this problem indicates that the
     * problem has been successfully solved.
     * @return true if the problem has been solved, false otherwise
     */
    public boolean success()
    {
        if(CState.equals(finalBridgeState)&&CState.getTimeSoFar()<=17)
            return true;
        else
        {
            return false;
        }
    }

    /**
     * Getter (accessor) for this problem's current bridge state.
     * @return the current state
     */
    public BridgeState getCurrentState()
    {
        return CState;
    }

    /**
     * Setter (mutator) for this problem's current bridge state.
     * @param currentState the state to be made this problem's current state
     */
    public void setCurrentState(BridgeState currentState)
    {
        CState=currentState;
    }

}
