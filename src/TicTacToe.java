import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame  =new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerOneTurn;
    boolean playerTwoTurn;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(208, 122, 122));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,650,100);
        titlePanel.add(textField);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(234, 185, 185));

        for (int i = 0; i <9 ; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            firstTurn();
        }

        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i <9 ; i++) {
            if (e.getSource()==buttons[i]) {
                if (playerOneTurn){
                    if (buttons[i].getText()=="") {
                         buttons[i].setForeground(new Color(255,0,0));
                         buttons[i].setText("X");
                         playerOneTurn=false;
                         textField.setText(Connector.userTwo+", O Turn");
                         check();
                    }
                }
                else {
                    if (buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(0, 94, 255));
                        buttons[i].setText("O");
                        playerOneTurn=true;
                        textField.setText(Connector.userOne+", X Turn");
                        check();
                    }
                }
            }
        }

    }
    public void firstTurn(){

        if (random.nextInt(2)==0) {
            playerOneTurn = true;
            textField.setText(Connector.userOne+", X Turn");
        }
        else {
            playerOneTurn=false;
            textField.setText(Connector.userTwo+ ", O Turn");

        }
    }
    public void check(){
        if ((buttons[0].getText()=="X") && (buttons[1].getText()=="X")
                && (buttons[2].getText()=="X")){

                xWins(0,2,3);
        }
        if ((buttons[3].getText()=="X") && (buttons[4].getText()=="X")
                && (buttons[5].getText()=="X")){

            xWins(3,4,5);
        }
        if ((buttons[6].getText()=="X") && (buttons[7].getText()=="X")
                && (buttons[8].getText()=="X")){

            xWins(6,7,8);
        }
        if ((buttons[0].getText()=="X") && (buttons[3].getText()=="X")
                && (buttons[6].getText()=="X")){

            xWins(0,3,6);
        }

        if ((buttons[1].getText()=="X") && (buttons[4].getText()=="X")
                && (buttons[7].getText()=="X")){

            xWins(1,4,7);
        }

        if ((buttons[2].getText()=="X") && (buttons[5].getText()=="X")
                && (buttons[8].getText()=="X")){

            xWins(2,5,8);
        }
        if ((buttons[0].getText()=="X") && (buttons[4].getText()=="X")
                && (buttons[8].getText()=="X")){

            xWins(0,4,8);
        }
        if ((buttons[2].getText()=="X") && (buttons[4].getText()=="X")
                && (buttons[6].getText()=="X")){

            xWins(2,4,6);
        }
        //-------------------------------------------------------
        if ((buttons[0].getText()=="O") && (buttons[1].getText()=="O")
                && (buttons[2].getText()=="O")){

            oWins(1,2,3);
        }
        if ((buttons[3].getText()=="O") && (buttons[4].getText()=="O")
                && (buttons[5].getText()=="O")){

            oWins(3,4,5);
        }
        if ((buttons[6].getText()=="O") && (buttons[7].getText()=="O")
                && (buttons[8].getText()=="O")){

            oWins(6,7,8);
        }
        if ((buttons[0].getText()=="O") && (buttons[3].getText()=="O")
                && (buttons[6].getText()=="O")){

            oWins(0,3,6);
        }

        if ((buttons[1].getText()=="O") && (buttons[4].getText()=="O")
                && (buttons[7].getText()=="O")){

            oWins(1,4,7);
        }

        if ((buttons[2].getText()=="O") && (buttons[5].getText()=="O")
                && (buttons[8].getText()=="O")){

            oWins(2,5,8);
        }
        if ((buttons[0].getText()=="O") && (buttons[4].getText()=="O")
                && (buttons[8].getText()=="O")){

            oWins(0,4,8);
        }
        if ((buttons[2].getText()=="O") && (buttons[4].getText()=="O")
                && (buttons[6].getText()=="O")){

            oWins(2,4,6);
        }
    }
    public void xWins(int a,int b,int c){
        buttons[a].setBackground(Color.ORANGE);
        buttons[b].setBackground(Color.ORANGE);
        buttons[c].setBackground(Color.ORANGE);
        for (int i = 0; i <9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText(Connector.userOne +", X Wins");

    }

    public void oWins(int a,int b,int c){
        buttons[a].setBackground(Color.ORANGE);
        buttons[b].setBackground(Color.ORANGE);
        buttons[c].setBackground(Color.ORANGE);
        for (int i = 0; i <9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText(Connector.userTwo+ ", O Wins");

    }

}
