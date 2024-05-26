import java.sql.Connection;
import java.util.List;

import br.ufac.sgcm.dao.ConexaoDB;
import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.dao.UnidadeDao;
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
        u1.setId(13L);
        u1.setNome("UTI");
        u1.setEndereco("Av. Rocha Viana- 204");

        Especialidade e1 = new Especialidade();
        e1.setId(8L);
        e1.setNome("Oncologia Alterado");

        p1.setUnidade(u1);
        p1.setEspecialidade(e1);

        //System.out.println(p1.getNome());
        //System.out.println(p1.getUnidade().getNome());
        //System.out.println(p1.getEspecialidade().getNome());

        ConexaoDB conexao = new ConexaoDB();
        conexao.getConexao();
        Connection instancia = conexao.getConexao();
        if(instancia != null) {
            System.out.println("conectou");
        }else {
            System.out.println("falhou");
        }
        
        UnidadeDao uDao = new UnidadeDao();

        /*List<Unidade> listaUnidades = uDao.get();
        System.out.println("\nLista de Unidades");
        for(Unidade item : listaUnidades) {
            System.out.println(item.getId() + " | " + item.getNome() + " | " + item.getEndereco());
        }

        System.out.println("\nUma Unidade pelo id");
        Unidade uni = uDao.get(2L);
        System.out.println(uni.getId() + " | " + uni.getNome() + " | " + uni.getEndereco());
        

        System.out.println("\nInserir Unidade");
        if (uDao.insert(u1) == 1) {
            System.out.println("Unidade inserida com sucesso");
        }else {
            System.out.println("Falha ao inserir uma Unidade");
        }

        /**/
        System.out.println("\nAtualizar Unidade");
        if (uDao.update(u1) == 1) {
            System.out.println("Unidade inserida com sucesso");
        }else {
            System.out.println("Falha ao inserir uma Unidade");
        }/**/

        //System.out.println("\nDelete uma unidade");
        //uDao.delete(u1);

        List<Unidade> listaUnidades = uDao.get();
        System.out.println("\nLista de Unidades");
        for(Unidade item : listaUnidades) {
            System.out.println(item.getId() + " | " + item.getNome() + " | " + item.getEndereco());
        }

        /* 
        EspecialidadeDao eDao = new EspecialidadeDao();
        List<Especialidade> listaEspecialidades = eDao.get();
        System.out.println("\nLista de especialidades \n");
        for (Especialidade item : listaEspecialidades) {
            System.out.println(item.getId() + " | " + item.getNome());
        }

        System.out.println("\nUma Especialidade por id");
        Especialidade esp = eDao.get(2L);
        System.out.println(esp.getId() + " | " + esp.getNome());

        System.out.println("\nLista de Especialidades por termo busca");
        List<Especialidade> listaBusca = eDao.get("tria");
        for (Especialidade item : listaBusca) {
            System.out.println(item.getId() + " | " + item.getNome());
        }

        System.out.println("\nInserir Especialidade");
        if(eDao.insert(e1) == 1) {
            System.out.println("Especialidade inserida com sucesso");
        }else {
            System.out.println("Erro ao inserir especialidade");
        }

        eDao.update(e1);
        System.out.println("Especialidade alterada: " + eDao.get(8L).getNome());
        */

        /*

        eDao.delete(e1);

        List<Especialidade> listaEspecialidades = eDao.get();
        System.out.println("\nLista de especialidades \n");
        for (Especialidade item : listaEspecialidades) {
            System.out.println(item.getId() + " | " + item.getNome());
        }
        */

    }
}
