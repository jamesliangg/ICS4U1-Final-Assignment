//has-a relationship
public class Network{
  public String newsNetwork;
  public Article articleInfo;
  public static int numOfArticles = 0;

  public Network(String newsNetwork, String title, String articleUrl, String author, String pubDate){
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
}