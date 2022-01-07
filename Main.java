import java.util.ArrayList;

public class Main{
  public static void main(String[] args){
    // ArrayList<Network> articleArray = new ArrayList<Network>();
    // articleArray = RSS.readRSS("CBC", "https://www.cbc.ca/cmlink/rss-Indigenous");
    // System.out.println(articleArray.get(0).getNewsNetwork());
    // System.out.println(articleArray.get(19).getArticleInfo());
    // System.out.println(Network.getNumOfArticles());
    // int articleNum = GUI.articleChoice(articleArray);
    // System.out.println(articleNum);
    // System.out.println(articleArray.get(articleNum).getArticleInfo());
    // GUI.articleSplashScreen(articleArray, articleNum);
    // System.exit(0);
    ArrayList<Network> articleArrayCBCTop = new ArrayList<Network>();
    articleArrayCBCTop = RSS.readRSS("CBC", "https://rss.cbc.ca/lineup/topstories.xml");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayCBCTop.get(0).getNewsNetwork());
    System.out.println(articleArrayCBCTop.get(19).getArticleInfo());

    ArrayList<Network> articleArrayCTVTop = new ArrayList<Network>();
    articleArrayCTVTop = RSS.readRSS("CTV", "https://www.ctvnews.ca/rss/ctvnews-ca-top-stories-public-rss-1.822009");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayCTVTop.get(0).getNewsNetwork());
    System.out.println(articleArrayCTVTop.get(19).getArticleInfo());

    ArrayList<Network> articleArrayNYTWorld = new ArrayList<Network>();
    articleArrayNYTWorld = RSS.readRSS("NYT", "https://rss.nytimes.com/services/xml/rss/nyt/World.xml");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayNYTWorld.get(0).getNewsNetwork());
    System.out.println(articleArrayNYTWorld.get(19).getArticleInfo());

    // ArrayList<Network> articleArraySCMPNews = new ArrayList<Network>();
    // articleArraySCMPNews = RSS.readRSS("SCMP", "https://www.scmp.com/rss/91/feed");
    // System.out.println(Network.getNumOfArticles());
    // // System.out.println(articleArraySCMPNews.get(0).getNewsNetwork());
    // System.out.println(articleArraySCMPNews.get(1).getArticleInfo());
  }
}