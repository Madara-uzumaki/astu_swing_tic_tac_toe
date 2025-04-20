import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tictaktoe {

  String playerX="X";
  String playerO="O";
  String currentPlayer=playerX;
  boolean gameover=false;
  JButton[][]myButtons;
  JLabel textlabel;
  JPanel bordpanel;
  JPanel textpanel;
  JFrame frame;
    tictaktoe(){
        

    
        myButtons= new JButton[3][3];
        
        bordpanel=new JPanel();
        bordpanel.setBackground(Color.darkGray);
        bordpanel.setOpaque(true);
        bordpanel.setSize(400,400);
        bordpanel.setLocation(50,100);
        bordpanel.setLayout(new GridLayout(3,3));

        textlabel=new JLabel();
        textlabel.setText("tic tac toe");
        textlabel.setFont(new Font("arial",Font.BOLD,40));
        textlabel.setForeground(Color.orange);


         textpanel=new JPanel();
        textpanel.setBackground(Color.DARK_GRAY);
        textpanel.add(textlabel);
        textpanel.setSize(100,400);
        
        JLabel bLabel=new JLabel();
        bLabel.setText(currentPlayer);

        frame= new JFrame();
        frame.setSize(600,700);
        frame.add(textpanel,BorderLayout.NORTH);
        frame.add(bordpanel,BorderLayout.CENTER);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        
        JButton tiles;
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                tiles =new JButton();
                myButtons[i][j]=tiles;
              bordpanel.add(tiles);
              tiles.setBackground(Color.BLACK);
              tiles.setFocusable(false);
              tiles.setForeground(Color.darkGray);
              
              
              tiles.setFont(new Font("arial",Font.BOLD,40));
              
              tiles.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                  if(gameover)return;
                  JButton tiles=(JButton) e.getSource();
                  if(tiles.getText()==""){
                    tiles.setText(currentPlayer);
                    

                    
                    checkWinner();
                 
                    if (!gameover) {
                      currentPlayer = currentPlayer== playerX ? playerO : playerX;
                      textlabel.setText(currentPlayer + "'s turn");
                    }
                    
                  }
                  else{                  textlabel.setText("DRAW");
                }
             } });
                  
           
             
                    }}
                  }
                 
          


  public void checkWinner(){
 
      boolean drawChecker=false;
      
       for(int r=0;r<3;r++){

        // horzontal
        
          
        

                      if (myButtons[r][0].getText()=="") continue;
                     else if (myButtons[r][0].getText()==myButtons[r][1].getText()&&myButtons[r][1].getText()==myButtons[r][2].getText()) {
                for(int m=0;m<=2;m++){markWinner(myButtons[r][m]);}
                        gameover=true;
                        if (myButtons[r][0].getText()=="X") {
                          textlabel.setText("player X won!!");

                        }
                        else if (myButtons[r][0].getText()=="O") {
                          textlabel.setText("player O won!!");
                        }
                        return;
                      }
                  
        // vertical

                      else if (myButtons[0][r].getText()=="") continue;
                     else if (myButtons[0][r].getText()==myButtons[1][r].getText()&&myButtons[1][r].getText()==myButtons[2][r].getText()) {
                        for(int h=0;h<=2;h++){markWinner(myButtons[h][r]);}
                        gameover=true;
                        if (myButtons[0][r].getText()=="X") {
                          textlabel.setText("player X won!!");
                        }
                        else if (myButtons[0][r].getText()=="O") {
                          textlabel.setText("player O won!!");
                        }
                        return;
                      }                  
                        
                      else if (myButtons[0][0].getText()==myButtons[1][1].getText()&&
                      myButtons[2][2].getText()==myButtons[1][1].getText()&& myButtons[0][0].getText()!="") {

                      
                        for(int k=0;k<=2;k++){
                          markWinner(myButtons[k][k]);
                        }

                        if (myButtons[0][0].getText()=="X") {
                          textlabel.setText("player x won!!!");
                          
                        }
                        if (myButtons[0][0].getText()=="O") {
                          textlabel.setText("player O won!!");
                        }
                        gameover=true;
                        return;
   } 
                     else if (myButtons[0][2].getText()==myButtons[1][1].getText()&&
                      myButtons[2][0].getText()==myButtons[1][1].getText()&& myButtons[2][0].getText()!="") {
                        

                        markWinner(myButtons[2][0]);
                        markWinner(myButtons[1][1]);
                        markWinner(myButtons[0][2]);

                        if (myButtons[2][0].getText()=="X") {
                          textlabel.setText("player x won!!!");
                          
                        }
                        if (myButtons[2][0].getText()=="O") {
                          textlabel.setText("player O won!!");
                        }
                        gameover=true;
                        return;

   } 
              
     
   
  }

   
  }

  public void markWinner(JButton tile) {
    tile.setBackground(Color.GRAY);
    tile.setForeground(Color.GREEN);
  }
  
}


    
  

