package org.example;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class Usuario {
    private String nome;
    private String ra;
    private String email;
    private String idade;
    private String telefone;
    private String rg;
    private String endereco;
    private String plano_saude;
    private String senha;

    public void inserirUsuario() throws SQLException {

        String sql = "INSERT INTO usuario(nome_usuario, idade_usuario, ra_usuario, rg_usuario, email_usuario, telefone_usuario, endereco_usuario, plano_saude_usuario, senha_usuario)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.connect()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, getNome());
            ps.setString(2, getIdade());
            ps.setString(3, getRa());
            ps.setString(4, getRg());
            ps.setString(5, getEmail());
            ps.setString(6, getTelefone());
            ps.setString(7, getEndereco());
            ps.setString(8, getPlano_saude());
            ps.setString(9, getSenha());
            ps.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void atualizarUsuario(long RG) throws SQLException {

        String sql = "UPDATE usuario SET nome_usuario = CASE WHEN ? IS NULL THEN nome_usuario ELSE ? END, idade_usuario = CASE WHEN ? IS NULL THEN idade_usuario ELSE ? END, ra_usuario = CASE WHEN ? IS NULL THEN ra_usuario ELSE ? END, rg_usuario = CASE WHEN ? IS NULL THEN rg_usuario ELSE ? END, email_usuario = CASE WHEN ? IS NULL THEN email_usuario ELSE ? END, telefone_usuario = CASE WHEN ? IS NULL THEN telefone_usuario ELSE ? END, endereco_usuario = CASE WHEN ? IS NULL THEN endereco_usuario ELSE ? END, plano_saude_usuario = CASE WHEN ? IS NULL THEN plano_saude_usuario ELSE ? END, senha_usuario = CASE WHEN ? IS NULL THEN senha_usuario ELSE ? END WHERE rg_usuario = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.connect()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, getNome());
            ps.setString(2, getNome());
            try { ps.setString(3, getIdade());
            } catch (Exception e) { ps.setNull(3, Types.INTEGER); }
            try { ps.setString(4, getIdade());
            } catch (Exception e) { ps.setNull(4, Types.INTEGER); }
            ps.setString(5, getRa());
            ps.setString(6, getRa());
            ps.setString(7, getRg());
            ps.setString(8, getRg());
            ps.setString(9, getEmail());
            ps.setString(10, getEmail());
            ps.setString(11, getTelefone());
            ps.setString(12, getTelefone());
            ps.setString(13, getEndereco());
            ps.setString(14, getEndereco());
            ps.setString(15, getPlano_saude());
            ps.setString(16, getPlano_saude());
            ps.setString(17, getSenha());
            ps.setString(18, getSenha());
            ps.setLong(19, RG);
            ps.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Usuario vizualizarUsuario(Long rgUsuario) {
        String login = "root";
        String senha = "passwd";
        String host = "localhost";
        String porta = "3306";
        String timezone = "America/Sao_Paulo";
        String bd = "Clinica";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;

        String sql = "SELECT nome_usuario, idade_usuario, ra_usuario, rg_usuario, email_usuario, telefone_usuario, endereco_usuario FROM usuario WHERE rg_usuario = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.connect()) {

            String url = "jdbc:mysql://" + host + ":" + porta + "/" + bd + "?serverTimezone=" + timezone;
            connection = DriverManager.getConnection(url, login, senha);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, rgUsuario);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome_usuario = resultSet.getString("nome_usuario");
                int idade_usuario = resultSet.getInt("idade_usuario");
                String ra_usuario = resultSet.getString("ra_usuario");
                long rg_usuario = resultSet.getLong("rg_usuario");
                String email_usuario = resultSet.getString("email_usuario");
                String telefone_usuario = resultSet.getString("telefone_usuario");
                String endereco_usuario = resultSet.getString("endereco_usuario");
                System.out.println(nome_usuario);

                usuario = new Usuario();
                usuario.setNome(nome_usuario);
                usuario.setIdade(idade_usuario);
                usuario.setRa(ra_usuario);
                usuario.setRg(rg_usuario);
                usuario.setEmail(email_usuario);
                usuario.setTelefone(telefone_usuario);
                usuario.setEndereco(endereco_usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = String.valueOf(idade);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setRg(Long rg) {
        this.rg = String.valueOf(rg);
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPlano_saude() {
        return plano_saude;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPlano_saude(String plano_saude) {
        this.plano_saude = plano_saude;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
