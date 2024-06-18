package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

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
