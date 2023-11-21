import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Gui {

    public String[] Picarray = new String[3];


    JFrame window;
    Container con;
    JPanel picturePanel;
    JLabel pictureLabel;
    JTextField inputTextField;
    JButton submitAnswer;


    ImageIcon image;
    boolean correctness = false;
   public int playernumber = 0;
   public int j = 0;
   public int scoreTrack = 0;
   public int correctAnswers = 0;

   public Gui(){
       initializeGUI();
   }
   //setting up frame only once below
private void initializeGUI(){
    window = new JFrame();
    window.setSize(1920, 1080);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setBackground(Color.BLACK);
    window.setLayout(null);
    con = window.getContentPane();

//text input field

    inputTextField = new JTextField();
    inputTextField.setBounds(580, 720, 400, 60);
    con.add(inputTextField);

    //button to submit answer

    submitAnswer = new JButton("Submit answer");
    submitAnswer.setBounds(1000, 720, 150, 60);
    submitAnswer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            processInput(inputTextField.getText());
        }
    });
    con.add(submitAnswer);


    picturePanel = new JPanel();
    picturePanel.setBounds(-222, -10, 1920, 900);
    picturePanel.setBackground(Color.BLUE);
    con.add(picturePanel);

    pictureLabel = new JLabel();
    updateImage();

    picturePanel.add(pictureLabel);

    window.setVisible(true);

}
    public void imageShower() {
        if (!correctness) {
            updateImage();
        }
    }
public void updateImage(){

 this.Picarray = new String[]{
         "Mouk",
         "Duffy",
         "Dest",
         "DeBruyne",
         "Bellingham",
         "Osimhen",
         "Neto",
         "Pickford",
         "Rodri",
         "Silva",
         "Vinicius",
 };


            if (j == 0) {
                String mashnameandnumber = (Picarray[playernumber]).concat("1.png");
                String concat = (".//results//HeavyBlur//").concat(mashnameandnumber);
                image = new ImageIcon(concat);
            }
            else if(j == 1)
            {

                String mashnameandnumber = (Picarray[playernumber]).concat("2.png");
                String concat = (".//results//MediumBlur//").concat(mashnameandnumber);
                image = new ImageIcon(concat);
            }
            else if (j == 2) {

                String mashnameandnumber = (Picarray[playernumber]).concat("3.png");
                String concat = (".//results//SoftBlur//").concat(mashnameandnumber);
                image = new ImageIcon(concat);
            }
            else if (j == 3) {
                String mashnameandnumber = (Picarray[playernumber]).concat("4.png");
                String concat = (".//results//zNoBlur//").concat(mashnameandnumber);
                image = new ImageIcon(concat);
            }
    pictureLabel.setIcon(image);
    picturePanel.revalidate();


}

       private void processInput(String inputText) {

        Scanner scanner = new Scanner(inputText);
        while (scanner.hasNext()) {
            String userAnswer = scanner.next();
            System.out.println("scanned userAnswer " + userAnswer);


            if (userAnswer.equalsIgnoreCase(Picarray[playernumber])) {
                correctness = true;
                System.out.println("right mfuka");
                inputTextField.setText("");
                scoreTrack++;


            } else {
correctness = false;

j++;
                System.out.println("after answer " + j);
                inputTextField.setText("");
                scoreTrack++;

                updateImage();

            }
    }
if(correctness) {
    System.out.println("boolean says true");
    playernumber++;
    j = 0;
    correctAnswers++;
        updateImage();
}
           System.out.println(correctAnswers + " from " + scoreTrack);


    }

}
