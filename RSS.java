/*
You scrape RSS feeds from different news providers. With the data, you use either tags or keywords to find articles that might relate to racism. You then provide the reader those articles and have them analyze it. They will have a checklist so they can think critically on what the article is trying to make them feel (angry/sad).

Hopefully with enough practice, a user would be able to apply this not only to articles on racism, but to think critically on all news articles they read.
*/

//https://youtu.be/xiK-DH74oJg
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class RSS{
  public static ArrayList<Network> readRSS(String newsNetwork, String urlAddress, String country){
    try{
      URL rssUrl = new URL(urlAddress);
      BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
      String line;
      String articleUrl = "";
      String title = "";
      String author = "";
      String pubDate = "";
      //https://www.geeksforgeeks.org/how-to-create-array-of-objects-in-java/
      ArrayList<Network> articleArray = new ArrayList<Network>();
      
      while((line=in.readLine())!=null){
        //grab title
        if (line.contains("<title>")){
          int firstPos = line.indexOf("<title>");
          String temp = line.substring(firstPos);
          temp = temp.replace("<title>","");
          //fixing formatting
          temp = temp.replace("&apos;","\'");
          temp = temp.replace("&quot;","\"");
          temp = temp.replace("&#39;","\'");
          temp = temp.replace("&#8211;","-");
          temp = temp.replace("&#8217;","\'");
          temp = temp.replace("&#8216;","\'");
          temp = temp.replace("&#038;","&");
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