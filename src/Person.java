import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Person
{
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;
    static private int age = 1;


    /**
     * constructor
     *
     * @param firstName
     * @param lastName
     * @param ID
     * @param title
     * @param YOB
     */
    public Person(String firstName, String lastName, String ID,String title, int YOB )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }
    public String fullName()
    {
        return firstName + " " + lastName;
    }
    public String formalName()
    {
        return title + " " + firstName + " " + lastName;
    }
    public String getAge()
    {
        int age = 2024 - YOB;
        String value = Integer.toString(age);

        return value;
    }

    public String getAge(int year)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);

        int specificYear = cal.get(Calendar.YEAR);

        int age = specificYear - this.YOB;

        if (age <0)
        {
            return "Not born yet";
        }
        else
        {
            return String.valueOf(age);
        }

    }
    public String toCSVDataRecord()
    {
        String personRecord = "";

        personRecord = ID + "," + fullName() + "," + formalName() + "," + getAge();
        return personRecord;

    }
    public String toJSON()
    {
        return String.format("{\"ID\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                ID, firstName, lastName, title, YOB);
    }

    public String toXML()
    {
        return String.format("<person><ID>%s</ID><firstName>%s</firstName><lastName>%s</lastName><title>%s</title><YOB>%d</YOB></person>",
                ID, firstName, lastName, title, YOB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return YOB == person.YOB && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(ID, person.ID) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ID, title, YOB);
    }

    @Override
    public String toString() {
        return String.format("Person{ID='%s', firstName='%s', lastName='%s', title='%s', YOB=%d}",
                ID, firstName, lastName, title, YOB);
    }
}

