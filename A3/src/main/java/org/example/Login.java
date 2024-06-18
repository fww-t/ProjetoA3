package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Clinica";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "passwd";

    public Login() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Nome:"));
        userTextField = new JTextField();
        panel.add(userTextField);

        panel.add(new JLabel("Senha:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        panel.add(loginButton);
        panel.add(new JLabel(""));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void handleLogin() {
        String username = userTextField.getText();
        char[] password = passwordField.getPassword();

        if (validateCredentials(username, new String(password))) {
            JOptionPane.showMessageDialog(this, "Login bem sucedido.");
            new MainMenu();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateCredentials(String username, String password) {
        boolean isValid = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM usuario WHERE nome_usuario = ? AND senha_usuario = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isValid;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}

