package com.soundwave.model.playaction;

public class Source
{
    private String platform;

    private String name;

    private String device;

    private Boolean autoPlay;

    private Boolean backgrounded;

    public String getPlatform ()
    {
        return platform;
    }

    public void setPlatform (String platform)
    {
        this.platform = platform;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDevice ()
    {
        return device;
    }

    public void setDevice (String device)
    {
        this.device = device;
    }

    public Boolean getAutoPlay() {
		return autoPlay;
	}

	public void setAutoPlay(Boolean autoPlay) {
		this.autoPlay = autoPlay;
	}

	
    public Boolean getBackgrounded() {
		return backgrounded;
	}

	public void setBackgrounded(Boolean backgrounded) {
		this.backgrounded = backgrounded;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [platform = "+platform+", name = "+name+", device = "+device+", autoPlay = "+autoPlay+", backgrounded = "+backgrounded+"]";
    }
}