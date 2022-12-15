package Client;

import java.awt.*;
import javax.swing.*;

public class Window {

    int size = 64;
    JFrame frame;

    public Window() {
        this.setupBase();
    }

    public void setupLogin() {

        frame.getContentPane().removeAll();

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(size / 3, size, size, 30);
        frame.add(loginLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(size / 3, size * 2, size, 30);
        frame.add(passwordLabel);

        JTextField userName = new JTextField();
        userName.setBounds(size * 2, size, size * 3, 30);
        frame.add(userName);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(size * 2, size * 2, size * 3, 30);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(size * 2, size * 3, 100, size / 2);
        frame.add(loginButton);

        JButton cancelButton = new JButton("Avbryt");
        cancelButton.setBounds(size * 4, size * 3, 100, size / 2);
        frame.add(cancelButton);

        JButton createButton = new JButton("Skapa ny Användare");
        createButton.setBounds(size * 2,size * 4, size * 3, size / 2);
        frame.add(createButton);

        JButton faqButton = new JButton("FAQ");
        faqButton.setBounds(size * 2, size * 6, size * 3, size / 2);
        frame.add(faqButton);

        frame.revalidate();
        frame.repaint();
    }

    public void setupLoginPage(){

        frame.getContentPane().removeAll();

        JLabel transferLabel = new JLabel("Belopp");
        transferLabel.setBounds(size, size, size*2, 30);
        frame.add(transferLabel);

        JLabel transferKonto = new JLabel("Konto nr:");
        transferKonto.setBounds(size, size/2, size*2, 30);
        frame.add(transferKonto);

        JTextField transferAccount = new JTextField();
        transferAccount.setBounds(size*2, size/2, size*3, 30);
        frame.add(transferAccount);

        JTextField transferText = new JTextField();
        transferText.setBounds(size*2, size, size*3, 30);
        frame.add(transferText);

        JButton transferButton = new JButton("Skicka Överföring");
        transferButton.setBounds(size*6, (int) (size/1.5), (int) (size*2.3), 30);
        frame.add(transferButton);


        frame.revalidate();
        frame.repaint();

    }

    private void setupBase() {
        frame = new JFrame("Bank System");
        frame.setLayout(null);
        frame.setSize(size * 9, size * 8);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}