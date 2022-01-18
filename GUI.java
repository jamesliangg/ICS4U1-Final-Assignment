import javax.swing.*;
import java.awt.BorderLayout;
import java.io.*; 
import java.net.URISyntaxException;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Desktop;
import java.net.URI;
import java.awt.event.*;

public class GUI{
  public static int articleChoice(ArrayList<Network> articleArray, String network){
    String articleChoices[] = new String[articleArray.size()];
    for (int temp = 0; temp < articleArray.size(); temp++){
      articleChoices[temp] = articleArray.get(temp).getArticleInfo().getTitle();
    }
    String article = (String) JOptionPane.showInputDialog(null, "Pick an article.", network + " Article Options", JOptionPane.QUESTION_MESSAGE, null, articleChoices, articleChoices[0]);
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
  public static void articleSplashScreen(ArrayList<Network> articleArray, int articleNum){
    //https://www.javatpoint.com/java-jbutton
    JFrame f = new JFrame("Article Information");
    //https://coderedirect.com/questions/118691/jlabel-show-longer-text-as-multiple-lines
    StringBuilder sb = new StringBuilder(128);
    sb.append("<html>").append(articleArray.get(articleNum).getArticleInfo().getTitle()+"</html>");
    JLabel l1 = new JLabel(sb.toString());
    l1.setBounds(25,0,475,150);
    //https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
    l1.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
    JLabel l2;
    l2 = new JLabel(articleArray.get(articleNum).getArticleInfo().getPubDate());
    l2.setFont(new Font("Serif", Font.PLAIN, 16));
    l2.setBounds(25,125,475,30);
    f.add(l2);
    JLabel l3;
    l3 = new JLabel(articleArray.get(articleNum).getArticleInfo().getAuthor());
    l3.setFont(new Font("Serif", Font.PLAIN, 16));
    l3.setBounds(25,145,475,30);
    f.add(l3);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new BorderLayout());
    f.add(l1);
    JLabel l4;
    l4 = new JLabel(articleArray.get(articleNum).toString());
    l4.setFont(new Font("Serif", Font.PLAIN, 16));
    l4.setBounds(25,165,475,30);
    f.add(l4);
    JButton l5 = new JButton("Read Article");
    l5.setBounds(25,400,150,30);
    l5.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        openArticle(articleArray, articleNum);
      }
    });
    f.add(l5);
    //https://stackoverflow.com/questions/2352727/closing-jframe-with-button-click
    JButton l6 = new JButton("Close");
    l6.setBounds(325,400,150,30);
    l6.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        f.dispose();
        System.exit(0);
      }
    });
    f.add(l6);
    f.setSize(500,500);
    // f.setLocationRelativeTo(null);
    f.setLayout(null);
    f.setVisible(true);
  }
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
  public static void openArticle(ArrayList<Network> articleArray, int articleNum){
    //https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
    try{
      if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
        Desktop.getDesktop().browse(new URI(articleArray.get(articleNum).getArticleInfo().getUrl()));
      }
    }catch (IOException ioe){
      System.out.println("IOException");
    }catch (URISyntaxException sej){
      System.out.println("URISyntaxExceptionJava");
    }
  }
}