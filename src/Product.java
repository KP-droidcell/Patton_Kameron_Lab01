import java.util.Objects;

public class Product
{
    private String Name;
    private String Description;
    private String ID;
    static private double Cost = 1;

    /**
     * constructor
     *
     * @param Name
     * @param Description
     * @param ID
     * @param Cost
     */

    public Product(String Name, String Description, String ID, double Cost)
    {
        this.Name = Name;
        this.Description = Description;
        this.ID = ID;
        this.Cost = Cost;
    }

    public String fullProduct()
    {
        return Name + " " + Description + " " + Cost;
    }

    public String toCSVDataRecord() {
        String productRecord = "";

        productRecord = Name + "," + Description + "," + Cost;
        return productRecord;

    }

    public String toJSON() {
        return String.format("{\"Name\":\"%s\",\"Description\":\"%s\",\"ID\":\"%s\",\"Cost\":%d}",
                Name, Description, ID, Cost);
    }

    public String toXML() {
        return String.format("<Product><Name>%s</Name><Description>%s</Description><ID>%s</ID><Cost>%d</Cost></Product>",
                Name, Description, ID, Cost);

    }
}