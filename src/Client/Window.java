package Client;

import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Window {

    int size = 64;
    JFrame frame;

    public Window() {
        this.setupBase();
    }

    public void setupLogin() {
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(this.size / 3, this.size, this.size, 30);
        this.frame.add(loginLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(this.size / 3, this.size * 2, this.size, 30);
        this.frame.add(passwordLabel);

        JTextField userName = new JTextField();
        userName.setBounds(this.size * 2, this.size, this.size * 3, 30);
        this.frame.add(userName);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(this.size * 2, this.size * 2, this.size * 3, 30);
        this.frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(this.size * 2, this.size * 3, 100, this.size / 2);
        this.frame.add(loginButton);

        JButton cancelButton = new JButton("Avbryt");
        cancelButton.setBounds(this.size * 4, this.size * 3, 100, this.size / 2);
        this.frame.add(cancelButton);

        JButton createButton = new JButton("Skapa ny Användare");
        createButton.setBounds(this.size * 2, this.size * 4, this.size * 3, this.size / 2);
        this.frame.add(createButton);

        JButton faqButton = new JButton("FAQ");
        faqButton.setBounds(this.size * 2, this.size * 6, this.size * 3, this.size / 2);
        this.frame.add(faqButton);

        this.frame.revalidate();
        this.frame.repaint();
    }

    private void setupBase() {
        this.frame = new JFrame("BankSystem");
        this.frame.setLayout((LayoutManager)null);
        this.frame.setSize(this.size * 8, this.size * 8);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo((Component)null);
    }
}