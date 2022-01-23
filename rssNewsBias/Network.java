package rssNewsBias;
//is-a relationship
//has-a relationship
/**
 * The Network program contains the network information of the article
 * 
 * @author James Liang
 * @version 1.0
 * @since 2022-01-06
 */
public class Network extends Country{
  //declaring variables
  public String newsNetwork;
  public Article articleInfo;
  public static int numOfArticles = 0;
  public String DEFAULT_NEWSNETWORK = "CBC";
  /**
   * This constructor sets the news network to the default value. It also
   * calls the parent constructor and article constructor with no values.
   */
  public Network(){
    super();
    this.newsNetwork = DEFAULT_NEWSNETWORK;
    articleInfo = new Article();
    numOfArticles++;
  }
  /**
   * This constructor sets the news network to the parameter values. It calls
   * the parent constructor and article constructor with parameter values.
   * 
   * @param newsNetwork This is the news network of the article
   * @param title       This is the title of the article
   * @param articleUrl  This is the Url of the article
   * @param author      This is the author of the article
   * @param pubDate     This is the publication date of the article
   * @param country     This is the country of the news network
   */
  public Network(String newsNetwork, String title, String articleUrl, String author, String pubDate, String country){
    super(country);
    this.newsNetwork = newsNetwork;
    articleInfo = new Article(title, articleUrl, author, pubDate);
    numOfArticles++;
  }
  /**
   * This accessor retrieves the news network
   * 
   * @return String This is the news network of the article
   */
  public String getNewsNetwork(){
    return newsNetwork;
  }
  /**
   * This accessor retrieves the article information
   * 
   * @return Article  This is the article information of the article
   */
  public Article getArticleInfo(){
    return articleInfo;
  }
  /**
   * This accessor retrieves the number of total articles
   * 
   * @return int  This is the total amount of articles
   */
  public static int getNumOfArticles(){
    return numOfArticles;
  }
  /**
   * This mutator changes the news network
   * 
   * @param newsNetwork This is the new news network
   */
  public void setNewsNetwork(String newsNetwork){
    this.newsNetwork = newsNetwork;
  }
  @Override
  /**
   * This method returns the parent toString along with the news network
   * 
   * @return String This is the combination of the parent and news network Strings
   */
  public String toString(){
    String newVal = super.toString();
    return newsNetwork + " News Network " + newVal;
  }
}