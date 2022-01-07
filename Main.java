import java.util.ArrayList;

public class Main{
  public static void main(String[] args){
    ArrayList<Network> articleArray = new ArrayList<Network>();
    articleArray = RSS.readRSS("CBC", "https://www.cbc.ca/cmlink/rss-Indigenous");
    System.out.println(articleArray.get(0).getNewsNetwork());
    System.out.println(articleArray.get(19).getArticleInfo().getTitle());
    System.out.println(Network.getNumOfArticles());
    // int articleNum = GUI.articleChoice(articleArray);
    // System.out.println(articleNum);
    // System.out.println(articleArray[articleNum].getArticleInfo());
    GUI.articleSplashScreen();
    // System.exit(0);
  }
}