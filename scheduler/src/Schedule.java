public class Schedule {
    private String subject;
    private String type;
    private int dday;

    public Schedule(String subject, String type, int dday)
    {
        this.subject = subject;
        this.type = type;
        this.dday = dday;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getType()
    {
        return type;
    }

    public int getDday()
    {
        return dday;
    }

    public String toString()
    {
        return subject + " " + type + "은(는) " + dday +"일 남았습니다.";
    }
}
