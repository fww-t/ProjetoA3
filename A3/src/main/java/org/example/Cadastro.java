package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Cadastro extends JFrame {
    private JTextField userTextField;
    private JTextField raTextField;
    private JTextField rgTextField;
    private JTextField emailTextField;
    private JTextField idadeTextField;
    private JTextField telefoneTextField;
    private JTextField enderecoTextField;
    private JTextField planoSaudeTextField;
    private JPasswordField passwordField;
    private JButton cadastroButton;

    public Cadastro(String acao) {
        setTitle(acao);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        panel.add(new JLabel("Nome:"));
        userTextField = new JTextField();
        panel.add(userTextField);

        panel.add(new JLabel("RA:"));
        raTextField = new JTextField();
        panel.add(raTextField);

        panel.add(new JLabel("RG:"));
        rgTextField = new JTextField();
        panel.add(rgTextField);

        panel.add(new JLabel("E-mail:"));
        emailTextField = new JTextField();
        panel.add(emailTextField);

        panel.add(new JLabel("Idade:"));
        idadeTextField = new JTextField();
        panel.add(idadeTextField);

        panel.add(new JLabel("Telefone:"));
        telefoneTextField = new JTextField();
        panel.add(telefoneTextField);

        panel.add(new JLabel("Endereço:"));
        enderecoTextField = new JTextField();
        panel.add(enderecoTextField);

        panel.add(new JLabel("Plano de saúde:"));
        planoSaudeTextField = new JTextField();
        panel.add(planoSaudeTextField);

        panel.add(new JLabel("Senha:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        cadastroButton = new JButton(acao);
        panel.add(cadastroButton);
        panel.add(new JLabel(""));

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    switch(acao) {
                        case "Cadastrar":
                            cadastrar();
                            break;
                        case "Atualizar":
                            atualizar();
                            break;
                        default:
                            JOptionPane.showInputDialog("Opção inválida!");
                            break;

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    private void cadastrar() throws SQLException {
        Usuario usuario = getUsuario();
        usuario.inserirUsuario();
        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso.");
        new MainMenu();
        dispose();
    }

    private void atualizar() throws SQLException {
        Usuario usuario = getUsuario();
        long RG = Long.parseLong(JOptionPane.showInputDialog("Digite o RG do usuário que será atualizado:"));
        usuario.atualizarUsuario(RG);
    }

    private Usuario getUsuario() {
        Usuario usuario = new Usuario();
        String nome = userTextField.getText();
        String email = emailTextField.getText();
        String telefone = telefoneTextField.getText();
        String endereco = enderecoTextField.getText();
        String plano_saude = planoSaudeTextField.getText();

        try { int idade = Integer.parseInt(idadeTextField.getText());
            usuario.setIdade(idade);
        } catch (Exception e) {}
        try { String ra = raTextField.getText();
            usuario.setRa(ra);
        } catch (Exception e) {}
        try { Long rg = Long.parseLong(rgTextField.getText());
            usuario.setRg(rg);
        } catch  (Exception e) {}

        char[] senha = passwordField.getPassword();

        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setEndereco(endereco);
        usuario.setPlano_saude(plano_saude);
        usuario.setSenha(new String(senha));
        return usuario;
    }
}
