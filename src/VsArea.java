import javax.swing.*;

public class VsArea extends JFrame {
    private JPanel myPanel;
    private JTextField firstUser;
    private JTextField secondUser;
    private JButton battleButton;
    private JButton VSButton;
    private static boolean isStart;


    public VsArea() {
        add(myPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Battle Arena");
        setSize(500,500);
        setResizable(false);


        battleButton.addActionListener(e -> {
            if (firstUser.getText().isEmpty()) {
             getMessage("Enter First User, name");
            } else if (secondUser.getText().isEmpty()) {
               getMessage("Enter Second User, name");
            }
            else {
                Connector.userOne= firstUser.getText();
                Connector.userTwo = secondUser.getText();
                isStart = true;
                setVisible(false);
                if (isStart){
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    TicTacToe ticTacToe = new TicTacToe();
                }

            }

        });
    }

    private  void getMessage(String message){
        JOptionPane.showMessageDialog(this, message);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        VsArea game = new VsArea();


    }

}
