package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;

public class ProfissionalDao {
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    public ProfissionalDao() {
        conexao = new ConexaoDB().getConexao();
    }

    // Retorna todos os profissionais
    public List<Profissional> get() {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EspecialidadeDao eDao = new EspecialidadeDao();
                UnidadeDao uDao = new UnidadeDao();
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setEmial(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                registro.setUnidade(uDao.get(rs.getLong("unidade_id")));
                registros.add(registro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Retorna um Profissional pelo id
    public Profissional get(Long id) {
        Profissional registro = new Profissional();
        String sql = "SELECT * FROM profissional WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                EspecialidadeDao eDao = new EspecialidadeDao();
                UnidadeDao uDao = new UnidadeDao();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setEmial(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                registro.setUnidade(uDao.get(rs.getLong("unidade_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    // Retorna conforme termo de busca
    public List<Profissional> get(String termoDeBusca) {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional WHERE nome LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoDeBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                EspecialidadeDao eDao = new EspecialidadeDao();
                UnidadeDao uDao = new UnidadeDao();
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setEmial(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                registro.setUnidade(uDao.get(rs.getLong("unidade_id")));
                registros.add(registro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Insere um novo profissional
    public int insert(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO profissional (email, nome, registro_conselho, telefone, especialidade_id, unidade_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEmial());
            ps.setString(2, objeto.getNome());
            ps.setString(3, objeto.getRegistro());
            ps.setString(4, objeto.getTelefone());
            ps.setLong(5, objeto.getEspecialidade().getId());
            ps.setLong(6, objeto.getUnidade().getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Atualiza Profissional
    public int update(Profissional objeto) {
        String sql = "UPDATE profissional SET email = ?, nome = ?, registro_conselho = ?, telefone = ?, especialidade_id = ?, unidade_id = ? WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEmial());
            ps.setString(2, objeto.getNome());
            ps.setString(3, objeto.getRegistro());
            ps.setString(4, objeto.getTelefone());
            ps.setLong(5, objeto.getEspecialidade().getId());
            ps.setLong(6, objeto.getUnidade().getId());
            ps.setLong(7, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    public int delete(Profissional obejeto) {
        String sql = "DELETE FROM profissional WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, obejeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}
