import javax.swing.*;
import java.awt.BorderLayout; 

import java.awt.Font;
import java.util.ArrayList;

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
    return 0;
  }
  public static void articleSplashScreen(ArrayList<Network> articleArray, int articleNum){
    JFrame f = new JFrame("Article Information");

    StringBuilder sb = new StringBuilder(128);
    sb.append("<html>").append(articleArray.get(articleNum).getArticleInfo().getTitle()+"</html>");
    JLabel l1 = new JLabel(sb.toString());
    l1.setBounds(25,0,475,150);
    l1.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
    JLabel l2;
    l2 = new JLabel(articleArray.get(articleNum).getArticleInfo().getPubDate());
    l2.setFont(new Font("Serif", Font.PLAIN, 16));
    l2.setBounds(25,125,500,30);
    f.add(l2);
    JLabel l3;
    l3 = new JLabel(articleArray.get(articleNum).getArticleInfo().getAuthor());
    l3.setFont(new Font("Serif", Font.PLAIN, 16));
    l3.setBounds(25,145,500,30);
    f.add(l3);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new BorderLayout());
    f.add(l1);
    f.setSize(500,500);
    // f.setLocationRelativeTo(null);
    f.setLayout(null);
    f.setVisible(true);
  }
  public static String networkChoice(){
    String networkChoices[] = {"CBC", "CTV", "NYT", "CNBC", "BBC", "HKFP"};
    String network = (String) JOptionPane.showInputDialog(null, "Pick a network.", "Network Options", JOptionPane.QUESTION_MESSAGE, null, networkChoices, networkChoices[0]);
    return network;
  }
}