//is-a relationship
public class Country {
    public String country;
    public String DEFAULT_COUNTRY = "Canada";
    public Country(){
        this.country = DEFAULT_COUNTRY;
    }
    public Country(String country){
        this.country = country;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String toString(){
        return "is from " + country + ".";
    }
}
