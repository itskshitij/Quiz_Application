import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.red;
import static java.awt.Color.white;

public class Quizz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswer[][] = new String[10][1];
    JLabel qno, question;
    JButton next, submit;
    JRadioButton op1, op2, op3, op4;
    ButtonGroup groupButton;
    public static int timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;

    Quizz(String name){
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 400);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN,24));
        add(qno);

        question = new JLabel();
        question.setBounds(150,450,900,30);
        question.setFont(new Font("Tahoma", Font.PLAIN,24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        op1 = new JRadioButton();
        op1.setBounds(170,500,700,30);
        op1.setBackground(white);
        op1.setFont(new Font("Dialog", Font.PLAIN,20));
        add(op1);

        op2 = new JRadioButton();
        op2.setBounds(170,540,700,30);
        op2.setBackground(white);
        op2.setFont(new Font("Dialog", Font.PLAIN,20));
        add(op2);

        op3 = new JRadioButton();
        op3.setBounds(170,580,700,30);
        op3.setBackground(white);
        op3.setFont(new Font("Dialog", Font.PLAIN,20));
        add(op3);

        op4 = new JRadioButton();
        op4.setBounds(170,620,700,30);
        op4.setBackground(white);
        op4.setFont(new Font("Dialog", Font.PLAIN,20));
        add(op4);

        groupButton = new ButtonGroup();
        groupButton.add(op1);
        groupButton.add(op2);
        groupButton.add(op3);
        groupButton.add(op4);

        next = new JButton("Next");
        next.setBounds(1100, 550,200,40);
        next.setFont(new Font("Tahoma", Font.PLAIN,22));
        next.setBackground(new Color(30, 144, 255));
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 650 ,200,40);
        submit.setFont(new Font("Tahoma", Font.PLAIN,22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == next){
            repaint();
            if (groupButton.getSelection()== null){
                useranswer[count][0] ="";
            }else{
                useranswer[count][0] = groupButton.getSelection().getActionCommand();
            }
            if (count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);

        }else if (ae.getSource() == submit){
            ans_given =1;
            if (groupButton.getSelection() == null) {
                useranswer[count][0] = "";
            } else {
                useranswer[count][0] = groupButton.getSelection().getActionCommand();
            }
            for (int i = 0;i<useranswer.length;i++){
                if (useranswer[i][0].equals(answers[i][1])){
                    score += 10;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void start(int count){
        qno.setText(""+(count+1)+". ");
        question.setText(questions[count][0]);
        op1.setText(questions[count][1]);
        op1.setActionCommand(questions[count][1]);

        op2.setText(questions[count][2]);
        op2.setActionCommand(questions[count][2]);

        op3.setText(questions[count][3]);
        op3.setActionCommand(questions[count][3]);

        op4.setText(questions[count][4]);
        op4.setActionCommand(questions[count][4]);

        groupButton.clearSelection();
    }
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time left- "+timer+ " seconds";
        g.setColor(red);
        g.setFont(new Font("tahoma", Font.PLAIN, 25));

        if (timer>0){
            g.drawString(time, 1100, 500);

        }else {
            g.drawString("Times Up!!", 1100, 500);
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (ans_given== 1){
            ans_given = 0;
            timer = 15;
        }else if(timer<0){
            timer =15;
            if (count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }if (count ==9){
                if (groupButton.getSelection() == null) {
                    useranswer[count][0] = "";
                } else {
                    useranswer[count][0] = groupButton.getSelection().getActionCommand();
                }
                for (int i = 0;i<useranswer.length;i++){
                    if (useranswer[i][0].equals(answers[i][1])){
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name, score);

            }else {
                if (groupButton.getSelection() == null) {
                    useranswer[count][0] = "";
                } else {
                    useranswer[count][0] = groupButton.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }

        }

    }

    public static void main(String[] args) {
        new Quizz("user");
    }
}
