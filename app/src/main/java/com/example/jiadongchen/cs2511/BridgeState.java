package com.example.jiadongchen.cs2511;

/**
 * Created by Jiadong Chen on 7/8/2015.
 */

import java.lang.StringBuilder;

public class BridgeState {
    private Position p1,p2,p5,p10,f;
    private int time;
    /**
     * Creates a new bridge state.
     * Besides storing the positions of the persons and flashlight, a
     * bridge state should also store the time taken so far to cross in
     * integer minutes.
     * @param p1Position position of the person who can cross in 1 minute
     * @param p2Position position of the person who can cross in 2 minutes
     * @param flashlightPosition position of the flashlight
     * @param p5Position position of the person who can cross in 5 minutes
     * @param p10Position  position of the person who can cross in 10 minutes
     * @param timeSoFar time taken so far
     */
    public BridgeState(Position p1Position,
                       Position p2Position,
                       Position flashlightPosition,
                       Position p5Position,
                       Position p10Position,
                       int timeSoFar)
    {
        p1=p1Position;
        p2=p2Position;
        p5=p5Position;
        p10=p10Position;
        f=flashlightPosition;
        time=timeSoFar;
    }

    /**
     * Tests this bridge state with another for equality.
     * Two bridge states are equal if the positions of the persons and
     * flashlight in one state are matched by their positions in the other.
     * Note that the time taken to cross so far is not taken into account
     * when considering equality.
     * @param other the other bridge state to be tested against this one.
     * @return true if this state is equal to the other state, false otherwise
     */
    public boolean equals(BridgeState other)
    {
        if(other.getFlashlightPosition()==f&&other.getP1Position()==p1
                &&other.getP2Position()==p2&&other.getP5Position()==p5
                &&other.getP10Position()==p10)
            return true;
        else
            return false;
    }

    /**
     * Creates a string representation of this state for display to the user
     * trying to solve the problem.
     * Note that the time so far to cross is part of the string representation.
     * @return the string representation of this state
     */
    @Override
    public String toString()
    {
        StringBuilder astring = new StringBuilder();
        if(p1==Position.WEST)
            astring.append (" P1 |   |\n");
        else
            astring.append ("    |   | P1\n");
        if(p2==Position.WEST)
            astring.append (" P2 |   |\n");
        else
            astring.append ("    |   | P2\n");
        if(f ==Position.WEST)
            astring.append ("  f |===|\n");
        else
            astring.append ("    |===| f\n");
        if(p5==Position.WEST)
            astring.append (" P5 |   |\n");
        else
            astring.append ("    |   | P5\n");
        if(p10==Position.WEST)
            astring.append ("P10 |   |\n");
        else
            astring.append ("    |   | P10\n");
        astring.append("Time elapsed so far: ");
        astring.append(time);
        astring.append(" minutes.\n");
        return astring.toString();
    }
    /**
     *
     * @return The position of flash light.
     */
    public Position getFlashlightPosition()
    {
        return f;
    }
    /**
     *
     * @return The position of P10.
     */
    public Position getP10Position()
    {
        return p10;
    }
    /**
     *
     * @return The position of P1.
     */
    public Position getP1Position()
    {
        return p1;
    }
    /**
     *
     * @return The position of P2.
     */
    public Position getP2Position()
    {
        return p2;
    }
    /**
     *
     * @return The position of P5.
     */
    public Position getP5Position()
    {
        return p5;
    }
    /**
     *
     * @return The time elapsed so far.
     */
    public int getTimeSoFar()
    {
        return time;
    }

}
