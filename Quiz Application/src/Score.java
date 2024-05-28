import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import static java.awt.Color.white;

public class Score extends JFrame implements ActionListener {
    Score(String name, int score){
        setBounds(400, 150, 700, 550);
        getContentPane().setBackground(white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        JLabel heading = new JLabel("Thanks for playing "+ name+ " with us!");
        heading.setBounds(140, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN,26));
        add(heading);

        JLabel totalscore = new JLabel("Your score is "+score );
        totalscore.setBounds(350, 200, 250, 30);
        totalscore.setFont(new Font("Tahoma", Font.PLAIN,26));
        add(totalscore);

        JButton submit = new JButton("Play Again!");
        submit.setBounds(380, 270 ,120,30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(white);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();

    }
    public static void main(String[] args) {
        new Score("user",0);
    }
}
