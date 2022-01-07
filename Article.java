public class Article{
  public String title;
  public String articleUrl;
  public String guid;
  public String author;
  public String pubDate;
  
  public Article(String title, String articleUrl, String guid, String author, String pubDate){
    this.title = title;
    this.articleUrl = articleUrl;
    this.guid = guid;
    this.author = author;
    this.pubDate = pubDate;
  }
  
  public String getTitle(){
    return title;
  }
  public String getUrl(){
    return articleUrl;
  }
  public String getGUID(){
    return guid;
  }
  public String getAuthor(){
    return author;
  }
  public String getPubDate(){
    return pubDate;
  }

  public String toString(){
    return title + "\n" + articleUrl + "\n" + guid + "\n" + author + "\n" + pubDate;
  }
}