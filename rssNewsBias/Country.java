package rssNewsBias;
//is-a relationship
/**
 * The Country program creates an object with the country of
 * the news network
 * 
 * @author James Liang
 * @version 1.0
 * @since 2022-01-06
 */
public class Country {
    public String country;
    public String DEFAULT_COUNTRY = "Canada";
    /**
     * This constructor creates an object with the default values
     */
    public Country(){
        this.country = DEFAULT_COUNTRY;
    }
    /**
     * This constructor creates an object with the parameter set
     * as the variable value
     * 
     * @param country   This is the country of the news network
     */
    public Country(String country){
        this.country = country;
    }
    /**
     * This accessor retrieves the country of the news network
     * 
     * @return String   This is the country of the news network
     */
    public String getCountry(){
        return country;
    }
    /**
     * This mutator changes the country of the news network
     * 
     * @param country   This is the new country of the news network
     */
    public void setCountry(String country){
        this.country = country;
    }
    /**
     * This method returns a String of the country
     * 
     * @return String   This is the returned country text
     */
    public String toString(){
        return "is from " + country + ".";
    }
}
