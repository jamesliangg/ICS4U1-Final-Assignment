package rssNewsBias;
//has-a relationship
/**
 * The Article program contains constructors, mutators, and accesors for article objects.
 * 
 * @author James Liang
 * @version 1.0
 * @since 2022-01-06
 */
public class Article{
  public String title;
  public String articleUrl;
  public String author;
  public String pubDate;
  public String DEFAULT_TITLE = "When life gives you lemons: How a N.S. bakery got — and got rid of — a heap of sour fruit";
  public String DEFAULT_ARTICLEURL = "https://outline.com/qAWvLV";
  public String DEFAULT_AUTHOR = "Cassidy Chisholm";
  public String DEFAULT_PUBDATE = "Tue, 4 Jan 2022 16:29:40 EST";
  
  /**
   * This constructor creates an object with all the variables at their default values.
   */
  public Article(){
    this.title = DEFAULT_TITLE;
    this.articleUrl = DEFAULT_ARTICLEURL;
    this.author = DEFAULT_AUTHOR;
    this.pubDate = DEFAULT_PUBDATE;
  }

  /**
   * This constructor creates an object and sets the variables to the values given by
   * the parameters.

   * @param title       This is the title of the article
   * @param articleUrl  This is the Url of the article
   * @param author      This is the author of the article
   * @param pubDate     This is the publication date of the article
   */
  public Article(String title, String articleUrl, String author, String pubDate){
    this.title = title;
    this.articleUrl = articleUrl;
    this.author = author;
    this.pubDate = pubDate;
  }
  /**
   * This accessor retrieves the title
   * 
   * @return String This returns the title of the article
   */  
  public String getTitle(){
    return title;
  }
  /**
   * This accessor retrieves the Url
   * 
   * @return String This returns the Url of the article
   */
  public String getUrl(){
    return articleUrl;
  }
  /**
   * This accessor retrieves the author
   * 
   * @return String This returns the author of the article
   */
  public String getAuthor(){
    return author;
  }
  /**
   * This accessor retrieves the publication date
   * 
   * @return String This returns the publication date of the article
   */
  public String getPubDate(){
    return pubDate;
  }
  /**
   * This mutator changes the title value
   * 
   * @param title
   */
  public void setTitle(String title){
    this.title = title;
  }
  /**
   * This mutator changes the article Url
   * 
   * @param articleUrl
   */
  public void setArticleUrl(String articleUrl){
    this.articleUrl = articleUrl;
  }
  /**
   * This mutator changes the author
   * 
   * @param author
   */
  public void setAuthor(String author){
    this.author = author;
  }
  /**
   * This mutator changes the publication date
   * 
   * @param pubDate
   */
  public void setPubDate(String pubDate){
    this.pubDate = pubDate;
  }
  /**
   * This method returns all the article's values as a String
   * 
   * @return String This is the combination of all the variables
   */
  public String toString(){
    return title + "\n" + articleUrl + "\n" + author + "\n" + pubDate;
  }
}