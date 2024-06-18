package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JButton signUpButton;
    private JButton updateUserInfoButton;
    private JButton createAppointmentButton;
    private JButton logoutButton;

    public MainMenu() {
        setTitle("Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        signUpButton = new JButton("Cadastrar usuário");
        updateUserInfoButton = new JButton("Atualizar informações de usuário");
        createAppointmentButton = new JButton("Marcar consulta");
        logoutButton = new JButton("Logout");

        panel.add(signUpButton);
        panel.add(updateUserInfoButton);
        panel.add(createAppointmentButton);
        panel.add(logoutButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSignUp();
            }
        });

        updateUserInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUpdateUserInfo();
            }
        });

        createAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCreateAppointment();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogout();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void handleSignUp() {
        new Cadastro("Cadastrar");
        dispose();
    }

    private void handleUpdateUserInfo() {
        new Cadastro("Atualizar");
    }

    private void handleCreateAppointment() {
        JOptionPane.showMessageDialog(this, "Implementar consulta");
    }

    private void handleLogout() {
        JOptionPane.showMessageDialog(this, "Saindo...");
        new Login();
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu();
            }
        });
    }
}
