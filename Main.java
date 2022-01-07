public class Main{
  public static void main(String[] args){
    Network[] articleArray;
    articleArray = RSS.readRSS("CBC", "https://www.cbc.ca/cmlink/rss-Indigenous");
    System.out.println(articleArray[0].getNewsNetwork());
    System.out.println(articleArray[19].getArticleInfo().getTitle());
    System.out.println(Network.getNumOfArticles());
    int articleNum = GUI.articleChoice(articleArray);
    System.out.println(articleNum);
    System.out.println(articleArray[articleNum].getArticleInfo());
    System.exit(0);
  }
}