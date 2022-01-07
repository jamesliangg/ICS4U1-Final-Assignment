public class Article{
  public String title;
  public String articleUrl;
  public String author;
  public String pubDate;
  
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

  public String toString(){
    return title + "\n" + articleUrl + "\n" + author + "\n" + pubDate;
  }
}