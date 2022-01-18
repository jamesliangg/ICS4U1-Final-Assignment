package rssNewsBias;
//is-a relationship
//has-a relationship
public class Network extends Country{
  public String newsNetwork;
  public Article articleInfo;
  public static int numOfArticles = 0;
  public String DEFAULT_NEWSNETWORK = "CBC";

  public Network(){
    super();
    this.newsNetwork = DEFAULT_NEWSNETWORK;
    articleInfo = new Article();
    numOfArticles++;
  }
  public Network(String newsNetwork, String title, String articleUrl, String author, String pubDate, String country){
    super(country);
    this.newsNetwork = newsNetwork;
    articleInfo = new Article(title, articleUrl, author, pubDate);
    numOfArticles++;
  }
  public String getNewsNetwork(){
    return newsNetwork;
  }
  public Article getArticleInfo(){
    return articleInfo;
  }
  public static int getNumOfArticles(){
    return numOfArticles;
  }
  public void setNewsNetwork(String newsNetwork){
    this.newsNetwork = newsNetwork;
  }
  @Override
  public String toString(){
    String newVal = super.toString();
    return newsNetwork + " News Network " + newVal;
  }
}