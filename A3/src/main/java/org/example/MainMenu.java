package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JButton cadastroButton;
    private JButton atualizarUsuarioButton;
    private JButton criarConsultaButton;
    private JButton logoutButton;
    private JButton exibirInfoUsuarioButton;

    public MainMenu() {
        setTitle("Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        cadastroButton = new JButton("Cadastrar usuário");
        atualizarUsuarioButton = new JButton("Atualizar informações de usuário");
        criarConsultaButton = new JButton("Marcar consulta");
        exibirInfoUsuarioButton = new JButton("Acessar dados do usuário");
        logoutButton = new JButton("Logout");

        panel.add(cadastroButton);
        panel.add(atualizarUsuarioButton);
        panel.add(criarConsultaButton);
        panel.add(exibirInfoUsuarioButton);
        panel.add(logoutButton);

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });

        atualizarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarUsuario();
            }
        });

        criarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarConsulta();
            }
        });

        exibirInfoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirInfoUsuario();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void cadastrar() {
        new Cadastro("Cadastrar");
        dispose();
    }

    private void atualizarUsuario() {
        new Cadastro("Atualizar");
    }

    private void criarConsulta() {
        JOptionPane.showMessageDialog(this, "Implementar consulta");
    }

    private void exibirInfoUsuario() {
        String rgStr = JOptionPane.showInputDialog(this, "Digite o RG do usuário:");
        long rg_usuario = Long.parseLong(rgStr);

        Usuario dados = new Usuario();
        dados = dados.vizualizarUsuario(rg_usuario);
        if (dados != null) {
            String message = "Nome: " + dados.getNome() + "\nRG: " + dados.getRg() + "\nIdade: " + dados.getIdade() + "\nRA: " + dados.getRa() + "\nE-mail: " + dados.getEmail() + "\nTelefone: " + dados.getTelefone() + "\nEndereço: " + dados.getEndereco();
            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(this, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void logout() {
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
