package rssNewsBias;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.*; 
import java.net.URISyntaxException;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Desktop;
import java.net.URI;
import java.awt.event.*;

/**
 * The GUI program provides most of the user interfaces.
 * 
 * @author James Liang
 * @version 1.0
 * @since 2022-01-06
 */
public class GUI{
  /**
   * This method presents the user with articles based on the selected news network
   * 
   * @param articleArray  These are the articles from the news network
   * @param network       This is the chosen news network
   * @return int          This is the index value of the chosen article
   */
  public static int articleChoice(ArrayList<Network> articleArray, String network){
    //new 1D array with all article titles of specified network
    String articleChoices[] = new String[articleArray.size()];
    for (int temp = 0; temp < articleArray.size(); temp++){
      articleChoices[temp] = articleArray.get(temp).getArticleInfo().getTitle();
    }
    //asks user for article choice
    String article = (String) JOptionPane.showInputDialog(null, "Pick an article.", network + " Article Options", JOptionPane.QUESTION_MESSAGE, null, articleChoices, articleChoices[0]);
    //find index of selected article
    for (int temp = 0; temp < articleArray.size(); temp++){
      if (article == articleArray.get(temp).getArticleInfo().getTitle())
      return temp;
    }
    //cancel button or close window button action
    //https://stackoverflow.com/questions/11494222/how-to-handle-cancel-button-in-joptionpane
    if (article == null){
      System.exit(0);
    }
    return 0;
  }
  /**
   * This method displays all the article information along with buttons to do
   * more actions
   * 
   * @param articleArray    These are the articles from the news network 
   * @param articleNum      This is the index value of the chosen article
   * @param numBiasedWords  This is the number of detected biased words
   */
  public static void articleSplashScreen(ArrayList<Network> articleArray, int articleNum, int numBiasedWords){
    //https://www.javatpoint.com/java-jbutton
    JFrame f = new JFrame("Article Information");
    //https://coderedirect.com/questions/118691/jlabel-show-longer-text-as-multiple-lines
    StringBuilder sb = new StringBuilder(128);
    //displaying article title over multiple lines
    sb.append("<html>").append(articleArray.get(articleNum).getArticleInfo().getTitle()+"</html>");
    JLabel l1 = new JLabel(sb.toString());
    l1.setBounds(25,0,475,150);
    //https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
    //changing font size
    l1.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
    //publication date
    JLabel l2 = new JLabel(articleArray.get(articleNum).getArticleInfo().getPubDate());
    l2.setFont(new Font("Serif", Font.PLAIN, 16));
    l2.setBounds(25,125,475,30);
    //author
    JLabel l3 = new JLabel(articleArray.get(articleNum).getArticleInfo().getAuthor());
    l3.setFont(new Font("Serif", Font.PLAIN, 16));
    l3.setBounds(25,145,475,30);
    //country of origin
    JLabel l4 = new JLabel(articleArray.get(articleNum).toString());
    l4.setFont(new Font("Serif", Font.PLAIN, 16));
    l4.setBounds(25,165,475,30);
    //read article button
    JButton l5 = new JButton("Read Article");
    l5.setBounds(25,225,150,30);
    l5.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        //opens article in default browser
        openArticle(articleArray, articleNum);
      }
    });
    //https://stackoverflow.com/questions/2352727/closing-jframe-with-button-click
    //close button
    JButton l6 = new JButton("Close");
    l6.setBounds(325,225,150,30);
    l6.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        //disposes Jframe and closes program
        f.dispose();
        System.exit(0);
      }
    });
    //biased words
    JLabel l7;
    if (numBiasedWords == 0){
      l7 = new JLabel("No biased words were detected.");
    }
    else{
      l7 = new JLabel("There were " + numBiasedWords + " biased words detected.");
    }
    l7.setFont(new Font("Serif", Font.PLAIN, 16));
    l7.setBounds(25,185,475,30);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new BorderLayout());
    f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);
    f.setSize(500,300);
    f.setLayout(null);
    f.setVisible(true);
  }
  /**
   * This method asks the user to pick a news network
   * 
   * @return String This is the chosen news network
   */
  public static String networkChoice(){
    String networkChoices[] = {"CBC", "CTV", "NYT", "CNBC", "BBC", "HKFP"};
    String network = (String) JOptionPane.showInputDialog(null, "Pick a network.", "Network Options", JOptionPane.QUESTION_MESSAGE, null, networkChoices, networkChoices[0]);
    //cancel button or close window button action
    //https://stackoverflow.com/questions/11494222/how-to-handle-cancel-button-in-joptionpane
    if (network == null){
      System.exit(0);
    }
    return network;
  }
  /**
   * This method opens the chosen article in the default browser if supported
   * 
   * @param articleArray  These are the articles from the news network
   * @param articleNum    This is the index value of the chosen article
   */
  public static void openArticle(ArrayList<Network> articleArray, int articleNum){
    //https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
    try{
      //trys to open the article's Url
      if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
        Desktop.getDesktop().browse(new URI(articleArray.get(articleNum).getArticleInfo().getUrl()));
      }
    }catch (IOException ioe){
      System.out.println("IOException");
    }catch (URISyntaxException sej){
      System.out.println("URISyntaxExceptionJava");
    }
  }
  /**
   * This method checks the article headline for biased words
   * 
   * @param articleArray  These are the articles from the news network
   * @param articleNum    This is the index value of the chosen article
   * @param biasedWords   This is the array of words from the bias.csv file
   * @return int          This is the amount of detected biased words
   */
  public static int checkBias(ArrayList<Network> articleArray, int articleNum, String[] biasedWords){
    int numBiasedWords = 0;
    //checks if headline contains any of the words in the .csv file
    for (int i = 0; i < biasedWords.length; i++){
      if (articleArray.get(articleNum).getArticleInfo().getTitle().toLowerCase().contains(biasedWords[i].toLowerCase())){
        numBiasedWords++;
      }
    }
    return numBiasedWords;
  }
  /**
   * This method asks the user if they'd like music and if so which song
   * 
   * @throws IOException
   */
  public static void musicPrompt() throws IOException{
    //asks user if want background music
    int play = JOptionPane.showConfirmDialog(null, "Would you like to have background music?", "BGM", JOptionPane.YES_NO_OPTION);
    //yes button would be 0
    if (play == 0){
      //find how many songs are available
      int csvSize = CSV.csvSize("music.csv");
      System.out.println(csvSize);
      //new 2D array for music and Url
      String musicArray[][] = new String[csvSize][2];
      int musicIndex = 0;
      //convert .csv to 2D array
      CSV.csvToArray("music.csv", musicArray);
      //create 1D array for titles of music
      String musicTitles[] = new String[csvSize];
      //set titles to 1D array
      for (int i = 0; i < musicArray.length; i++){
        musicTitles[i] = musicArray[i][0];
      }
      //ask user to pick a song
      String bgm = (String) JOptionPane.showInputDialog(null, "Pick a Song.", "BGM Options", JOptionPane.QUESTION_MESSAGE, null, musicTitles, musicTitles[0]);
      //find index of song chosen
      for (int i = 0; i < musicArray.length; i++){
        if (bgm == musicTitles[i]){
          musicIndex = i;
        }
      }
      //create new music object
      Audio musicObject = new Audio();
      //create variable with chosen music Url
      String musicURL = musicArray[musicIndex][1];
      //call method to play music
      musicObject.playMusic(musicURL);
    }
  }
}