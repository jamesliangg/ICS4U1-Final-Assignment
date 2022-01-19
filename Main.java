import java.io.IOException;
import java.util.ArrayList;

import rssNewsBias.CSV;
import rssNewsBias.GUI;
import rssNewsBias.Network;
import rssNewsBias.RSS;

public class Main{
  public static void main(String[] args) throws IOException{
    GUI.musicPrompt();
    int csvSize = CSV.csvSize("bias.csv");
    System.out.println(csvSize);
    String csvArray[] = new String[csvSize];
    csvArray = CSV.csvToArray("bias.csv", csvArray);
    ArrayList<Network> articleArray = new ArrayList<Network>();
    ArrayList<Network> articleArrayCBCTop = new ArrayList<Network>();
    articleArrayCBCTop = RSS.readRSS("CBC", "https://rss.cbc.ca/lineup/topstories.xml", "Canada");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayCBCTop.get(0).getNewsNetwork());
    System.out.println(articleArrayCBCTop.get(0).getArticleInfo());

    ArrayList<Network> articleArrayCTVTop = new ArrayList<Network>();
    articleArrayCTVTop = RSS.readRSS("CTV", "https://www.ctvnews.ca/rss/ctvnews-ca-top-stories-public-rss-1.822009", "Canada");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayCTVTop.get(0).getNewsNetwork());
    System.out.println(articleArrayCTVTop.get(1).getArticleInfo());

    ArrayList<Network> articleArrayNYTWorld = new ArrayList<Network>();
    articleArrayNYTWorld = RSS.readRSS("NYT", "https://rss.nytimes.com/services/xml/rss/nyt/World.xml", "United States");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayNYTWorld.get(0).getNewsNetwork());
    System.out.println(articleArrayNYTWorld.get(1).getArticleInfo());

    ArrayList<Network> articleArrayCNBCTop = new ArrayList<Network>();
    articleArrayCNBCTop = RSS.readRSS("CNBC", "https://www.cnbc.com/id/100003114/device/rss/rss.html", "United States");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayCNBCTop.get(0).getNewsNetwork());
    System.out.println(articleArrayCNBCTop.get(1).getArticleInfo());

    ArrayList<Network> articleArrayBBCTop = new ArrayList<Network>();
    articleArrayBBCTop = RSS.readRSS("BBC", "http://feeds.bbci.co.uk/news/rss.xml#", "United Kingdom");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayBBCTop.get(0).getNewsNetwork());
    System.out.println(articleArrayBBCTop.get(0).getArticleInfo());

    ArrayList<Network> articleArrayHKFP = new ArrayList<Network>();
    articleArrayHKFP = RSS.readRSS("HKFP", "https://hongkongfp.com/feed/", "China");
    System.out.println(Network.getNumOfArticles());
    System.out.println(articleArrayHKFP.get(0).getNewsNetwork());
    System.out.println(articleArrayHKFP.get(0).getArticleInfo());

    String network = GUI.networkChoice();
    //https://www.w3schools.com/java/java_switch.asp
    switch (network){
      case "CBC":
        articleArray = articleArrayCBCTop;
        break;
      case "CTV":
        articleArray = articleArrayCTVTop;
        break;
      case "NYT":
        articleArray = articleArrayNYTWorld;
        break;
      case "CNBC":
        articleArray = articleArrayCNBCTop;
        break;
      case "BBC":
        articleArray = articleArrayBBCTop;
        break;
      case "HKFP":
        articleArray = articleArrayHKFP;
        break;
    }
    int articleNum = GUI.articleChoice(articleArray, network);
    System.out.println(articleNum);
    int numBiasedWords = GUI.checkBias(articleArray, articleNum, csvArray);
    GUI.articleSplashScreen(articleArray, articleNum, numBiasedWords);
    // GUI.openArticle(articleArray, articleNum);
  }
}