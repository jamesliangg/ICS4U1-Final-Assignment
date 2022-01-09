//has-a relationship
public class Article{
  public String title;
  public String articleUrl;
  public String author;
  public String pubDate;
  public String DEFAULT_TITLE = "When life gives you lemons: How a N.S. bakery got — and got rid of — a heap of sour fruit";
  public String DEFAULT_ARTICLEURL = "https://outline.com/https://www.cbc.ca/news/canada/nova-scotia/lemons-bakery-thousands-nova-scotia-1.6303984?cmp=rss";
  public String DEFAULT_AUTHOR = "Cassidy Chisholm";
  public String DEFAULT_PUBDATE = "Tue, 4 Jan 2022 16:29:40 EST";
  
  public Article(){
    this.title = DEFAULT_TITLE;
    this.articleUrl = DEFAULT_ARTICLEURL;
    this.author = DEFAULT_AUTHOR;
    this.pubDate = DEFAULT_PUBDATE;
  }
  public Article(String title, String articleUrl, String author, String pubDate){
    this.title = title;
    this.articleUrl = articleUrl;
    this.author = author;
    this.pubDate = pubDate;
  }  
  public String getTitle(){
    return title;
  }
  public String getUrl(){
    return articleUrl;
  }
  public String getAuthor(){
    return author;
  }
  public String getPubDate(){
    return pubDate;
  }
  public void setTitle(String title){
    this.title = title;
  }
  public void setArticleUrl(String articleUrl){
    this.articleUrl = articleUrl;
  }
  public void setAuthor(String author){
    this.author = author;
  }
  public void setPubDate(String pubDate){
    this.pubDate = pubDate;
  }
  public String toString(){
    return title + "\n" + articleUrl + "\n" + author + "\n" + pubDate;
  }
}