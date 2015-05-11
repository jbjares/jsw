package com.soundwave.model.playaction;

public class AudioSummary
{
    private String instrumentalness;

    private String duration;

    private String speechiness;

    private String valence;

    private String tempo;

    private String danceability;

    private String acousticness;

    private String loudness;

    private String timeSignature;

    private String key;

    private String energy;

    private String mode;

    private String liveness;

    public String getInstrumentalness ()
    {
        return instrumentalness;
    }

    public void setInstrumentalness (String instrumentalness)
    {
        this.instrumentalness = instrumentalness;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getSpeechiness ()
    {
        return speechiness;
    }

    public void setSpeechiness (String speechiness)
    {
        this.speechiness = speechiness;
    }

    public String getValence ()
    {
        return valence;
    }

    public void setValence (String valence)
    {
        this.valence = valence;
    }

    public String getTempo ()
    {
        return tempo;
    }

    public void setTempo (String tempo)
    {
        this.tempo = tempo;
    }

    public String getDanceability ()
    {
        return danceability;
    }

    public void setDanceability (String danceability)
    {
        this.danceability = danceability;
    }

    public String getAcousticness ()
    {
        return acousticness;
    }

    public void setAcousticness (String acousticness)
    {
        this.acousticness = acousticness;
    }

    public String getLoudness ()
    {
        return loudness;
    }

    public void setLoudness (String loudness)
    {
        this.loudness = loudness;
    }

    public String getTimeSignature ()
    {
        return timeSignature;
    }

    public void setTimeSignature (String timeSignature)
    {
        this.timeSignature = timeSignature;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public String getEnergy ()
    {
        return energy;
    }

    public void setEnergy (String energy)
    {
        this.energy = energy;
    }

    public String getMode ()
    {
        return mode;
    }

    public void setMode (String mode)
    {
        this.mode = mode;
    }

    public String getLiveness ()
    {
        return liveness;
    }

    public void setLiveness (String liveness)
    {
        this.liveness = liveness;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [instrumentalness = "+instrumentalness+", duration = "+duration+", speechiness = "+speechiness+", valence = "+valence+", tempo = "+tempo+", danceability = "+danceability+", acousticness = "+acousticness+", loudness = "+loudness+", timeSignature = "+timeSignature+", key = "+key+", energy = "+energy+", mode = "+mode+", liveness = "+liveness+"]";
    }
}