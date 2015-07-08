package com.example.jiadongchen.cs2511;

/**
 * Created by Jiadong Chen on 7/8/2015.
 */
public class BridgeMove {

    /**
     * Constructs a new bridge move object.
     * @param moveName the name of this move.
     * It is an error if the name is not one of the following:
     * <ul>
     * <li> "P1 crosses alone" </li>
     * <li> "P2 crosses alone" </li>
     * <li> "P5 crosses alone" </li>
     * <li> "P10 crosses alone" </li>
     * <li> "P1 crosses with P2" </li>
     * <li> "P1 crosses with P5" </li>
     * <li> "P1 crosses with P10" </li>
     * <li> "P2 crosses with P5" </li>
     * <li> "P2 crosses with P10" </li>
     * <li> "P5 crosses with P10" </li>
     * </ul>
     */
    private String MName;
    public BridgeMove(String moveName)
    {
        if("P1 crosses alone"==moveName ||
                "P2 crosses alone"==moveName ||
                "P5 crosses alone"==moveName ||
                "P10 crosses alone"==moveName ||
                "P1 crosses with P2"==moveName ||
                "P1 crosses with P5"==moveName ||
                "P1 crosses with P10"==moveName ||
                "P2 crosses with P5"==moveName ||
                "P2 crosses with P10"==moveName ||
                "P5 crosses with P10"==moveName )
            MName=moveName;
        else
        {
            System.out.println("error");
            System.exit(0);
        }
    }

    /**
     * Getter (accessor) for this move object's move name.
     * @return this move object's move name
     */
    public String getMoveName()
    {
        return MName;
    }
    /**
     * Attempts to perform this move on a given bridge state.
     * The move to perform is determined by this object's move name.
     * If the move can be performed a new bridge state object is returned that
     * reflects this move.
     * A move cannot be performed if the flashlight is not on the same side
     * as the crossing person(s), or if a pair of persons who are crossing are not
     * on the same side.
     * If the move cannot be performed <b>null</b> is returned.
     * @param state the bridge state on which this move is to be performed
     * @return a new bridge state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    public BridgeState doMove(BridgeState state)
    {
        switch (MName)
        {
            case "P1 crosses alone":
                if(state.getP1Position()==state.getFlashlightPosition())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(Position.EAST,state.getP2Position(),Position.EAST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+1);
                    else
                        return new BridgeState(Position.WEST,state.getP2Position(),Position.WEST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+1);
                }
                else
                    return null;
            case "P2 crosses alone":
                if(state.getP2Position()==state.getFlashlightPosition())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),Position.EAST,Position.EAST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+2);
                    else
                        return new BridgeState(state.getP1Position(),Position.WEST,Position.WEST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+2);
                }
                else
                    return null;
            case "P5 crosses alone":
                if(state.getP5Position()==state.getFlashlightPosition())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.EAST,Position.EAST,state.getP10Position(),state.getTimeSoFar()+5);
                    else
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.WEST,Position.WEST,state.getP10Position(),state.getTimeSoFar()+5);
                }
                else
                    return null;
            case "P10 crosses alone":
                if(state.getP10Position()==state.getFlashlightPosition())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.EAST,state.getP5Position(),Position.EAST,state.getTimeSoFar()+10);
                    else
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.WEST,state.getP5Position(),Position.WEST,state.getTimeSoFar()+10);
                }
                else
                    return null;
            case "P1 crosses with P2":
                if(state.getP1Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP2Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(Position.EAST,Position.EAST,Position.EAST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+2);
                    else
                        return new BridgeState(Position.WEST,Position.WEST,Position.WEST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+2);
                }
                else
                    return null;
            case "P1 crosses with P5":
                if(state.getP1Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP5Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(Position.EAST,state.getP2Position(),Position.EAST,Position.EAST,state.getP10Position(),state.getTimeSoFar()+5);
                    else
                        return new BridgeState(Position.WEST,state.getP2Position(),Position.WEST,Position.WEST,state.getP10Position(),state.getTimeSoFar()+5);
                }
                else
                    return null;
            case "P1 crosses with P10":
                if(state.getP1Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP10Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(Position.EAST,state.getP2Position(),Position.EAST,state.getP5Position(),Position.EAST,state.getTimeSoFar()+10);
                    else
                        return new BridgeState(Position.WEST,state.getP2Position(),Position.WEST,state.getP5Position(),Position.WEST,state.getTimeSoFar()+10);
                }
                else
                    return null;
            case "P2 crosses with P5":
                if(state.getP2Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP5Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),Position.EAST,Position.EAST,Position.EAST,state.getP10Position(),state.getTimeSoFar()+5);
                    else
                        return new BridgeState(state.getP1Position(),Position.WEST,Position.WEST,Position.WEST,state.getP10Position(),state.getTimeSoFar()+5);
                }
                else
                    return null;
            case "P2 crosses with P10":
                if(state.getP2Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP10Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),Position.EAST,Position.EAST,state.getP5Position(),Position.EAST,state.getTimeSoFar()+10);
                    else
                        return new BridgeState(state.getP1Position(),Position.WEST,Position.WEST,state.getP5Position(),Position.WEST,state.getTimeSoFar()+10);
                }
                else
                    return null;
            case "P5 crosses with P10":
                if(state.getP5Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP10Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.EAST,Position.EAST,Position.EAST,state.getTimeSoFar()+10);
                    else
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.WEST,Position.WEST,Position.WEST,state.getTimeSoFar()+10);
                }
                else
                    return null;
            default:
                return null;
        }
    }
}
