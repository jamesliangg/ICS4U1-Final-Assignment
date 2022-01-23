import java.io.IOException;
import java.util.ArrayList;

import rssNewsBias.CSV;
import rssNewsBias.GUI;
import rssNewsBias.Network;
import rssNewsBias.RSS;

/**
 * The Main program calls methods from different classes.
 * 
 * @author James Liang
 * @version 1.0
 * @since 2022-01-06
 */
public class Main{
  public static void main(String[] args) throws IOException{
    //call to see if user wants music
    GUI.musicPrompt();
    //find amount of biased words located in .csv file
    int csvSize = CSV.csvSize("bias.csv");
    System.out.println(csvSize);
    //create 1D array for biased words
    String csvArray[] = new String[csvSize];
    csvArray = CSV.csvToArray("bias.csv", csvArray);
    //create new Array List for news networks
    ArrayList<Network> articleArray = new ArrayList<Network>();
    ArrayList<Network> articleArrayCBCTop = new ArrayList<Network>();
    //get required information from RSS feeds
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

    //ask user which news network they'd like to read
    String network = GUI.networkChoice();
    //https://www.w3schools.com/java/java_switch.asp
    //change article array based on network selection
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
    //ask user to pick an article
    int articleNum = GUI.articleChoice(articleArray, network);
    System.out.println(articleNum);
    //check for biased words based on headline of chosen article
    int numBiasedWords = GUI.checkBias(articleArray, articleNum, csvArray);
    //display information on article
    GUI.articleSplashScreen(articleArray, articleNum, numBiasedWords);
  }
}