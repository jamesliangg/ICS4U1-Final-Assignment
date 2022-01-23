package rssNewsBias;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * The RSS program reads RSS files from different news networks and prepares it for
 * use in the rest of the program.
 *
 * @author James Liang
 * @version 1.0
 * @since 2022-01-06
 */
public class RSS{
  /**
   * This method takes in the RSS feed and turns it into an Array List
   * 
   * @param newsNetwork         This is the name of the news network
   * @param urlAddress          This is the Url link of the RSS feed for the news network
   * @param country             This is the country of the news network
   * @return ArrayList<Network> This is the Array List of articles from the RSS feed
   */
  //https://youtu.be/xiK-DH74oJg
  public static ArrayList<Network> readRSS(String newsNetwork, String urlAddress, String country){
    try{
      URL rssUrl = new URL(urlAddress);
      BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
      //declaring variables
      String line;
      String articleUrl = "";
      String title = "";
      String author = "";
      String pubDate = "";
      //https://www.geeksforgeeks.org/how-to-create-array-of-objects-in-java/
      ArrayList<Network> articleArray = new ArrayList<Network>();
      //keep reading as long as there is content
      while((line=in.readLine())!=null){
        //grab title
        if (line.contains("<title>")){
          int firstPos = line.indexOf("<title>");
          String temp = line.substring(firstPos);
          temp = temp.replace("<title>","");
          //fixing formatting of headlines
          temp = temp.replace("&apos;","\'");
          temp = temp.replace("&quot;","\"");
          temp = temp.replace("&#39;","\'");
          temp = temp.replace("&#8211;","-");
          temp = temp.replace("&#8217;","\'");
          temp = temp.replace("&#8216;","\'");
          temp = temp.replace("&#038;","&");
          //special formating for specific news netowrks
          if (newsNetwork == "CBC" || newsNetwork == "CTV" || newsNetwork == "BBC"){
            temp = temp.replace("<![CDATA[","");
            temp = temp.replace("]]>","");
          }
          int lastPos = temp.indexOf("</title>");
          temp = temp.substring(0,lastPos);
          title = temp;
        }
        //adding article links
        if (line.contains("<link>")){
          int firstPos = line.indexOf("<link>");
          String temp = line.substring(firstPos);
          temp = temp.replace("<link>","");
          int lastPos = temp.indexOf("</link>");
          temp = temp.substring(0,lastPos);
          //add Outline.com to remove potential paywalls
          articleUrl = "https://outline.com/"+temp;
        }
        //author for CTV and NYT
        if (line.contains("<dc:creator>")){
          int firstPos = line.indexOf("<dc:creator>");
          String temp = line.substring(firstPos);
          temp = temp.replace("<dc:creator>","");
          temp = temp.replace("<![CDATA[","");
          temp = temp.replace("]]>","");
          int lastPos = temp.indexOf("</dc:creator>");
          temp = temp.substring(0,lastPos);
          author = temp;
        }
        //publication date
        if (line.contains("<pubDate>")){
          int firstPos = line.indexOf("<pubDate>");
          String temp = line.substring(firstPos);
          temp = temp.replace("<pubDate>","");
          int lastPos = temp.indexOf("</pubDate>");
          temp = temp.substring(0,lastPos);
          pubDate = temp;
          //special order for specific news networks
          if (newsNetwork == "CTV" || newsNetwork == "NYT" || newsNetwork == "CNBC" || newsNetwork == "BBC" || newsNetwork == "HKFP"){
            articleArray.add(new Network(newsNetwork, title, articleUrl, author, pubDate, country));
          }
        }
        //adding author
        if (line.contains("<author>")){
          int firstPos = line.indexOf("<author>");
          String temp = line.substring(firstPos);
          temp = temp.replace("<author>","");
          int lastPos = temp.indexOf("</author>");
          temp = temp.substring(0,lastPos);
          author = temp;
          //special order for specific news network
          if (newsNetwork == "CBC"){
            articleArray.add(new Network(newsNetwork, title, articleUrl, author, pubDate, country));
          }
        }
      }
      in.close();
      //removed first index as it wasn't an article
      if (newsNetwork == "NYT" || newsNetwork == "CNBC"){
        articleArray.remove(0);
      }
      return articleArray;
    }catch (MalformedURLException ue){
      System.out.println("Malformed URL");
    }catch (IOException ioe){
      System.out.println("Something went wrong reading the contents");
    }
    return null;
  }
}