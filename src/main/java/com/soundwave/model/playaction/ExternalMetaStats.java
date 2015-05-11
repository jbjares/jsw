package com.soundwave.model.playaction;

public class ExternalMetaStats
{
    private String lastEchonestPoll;

    public String getLastEchonestPoll ()
    {
        return lastEchonestPoll;
    }

    public void setLastEchonestPoll (String lastEchonestPoll)
    {
        this.lastEchonestPoll = lastEchonestPoll;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lastEchonestPoll = "+lastEchonestPoll+"]";
    }
}