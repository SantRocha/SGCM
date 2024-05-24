import java.sql.Connection;

import br.ufac.sgcm.dao.ConexaoDB;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class App {
    public static void main(String[] args) {
        Profissional p1 = new Profissional();
        p1.setId(1L);
        p1.setNome("Santiago");
        p1.setEmial("santiagomelo121@gmail.com");
        p1.setTelefone("(68) 99225-2856");
        p1.setRegistro("CRM/AC-007");

        Unidade u1 = new Unidade();
        u1.setId(1L);
        u1.setNome("Pronto Atendimento");
        u1.setEndereco("Av. Rocha Viana - 204");

        Especialidade e1 = new Especialidade();
        e1.setId(1L);
        e1.setNome("Pediatria");

        p1.setUnidade(u1);
        p1.setEspecialidade(e1);

        System.out.println(p1.getNome());
        System.out.println(p1.getUnidade().getNome());
        System.out.println(p1.getEspecialidade().getNome());

        ConexaoDB conexao = new ConexaoDB();
        conexao.getConexao();
        Connection instancia = conexao.getConexao();
        if(instancia != null) {
            System.out.println("conectou");
        }else {
            System.out.println("falhou");
        }

    }
}
