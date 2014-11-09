package br.edu.ifce.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.dao.HabilidadeDAO;
import br.edu.ifce.dao.TipoHabilidadeDAO;
import br.edu.ifce.entity.Habilidade;
import br.edu.ifce.entity.TipoHabilidade;
import br.edu.ifce.exception.DAOException;

public class Main {

	public static void main(String[] args) throws DAOException {

		TipoHabilidadeDAO t = new TipoHabilidadeDAO();
		HabilidadeDAO h = new HabilidadeDAO();

		TipoHabilidade tipo = new TipoHabilidade();
		tipo.setDsTipoHabilidade("Desenvolvimento");
		tipo.setId(6);
		// System.out.println("Teste: "+
		// t.getTipoHabilidadeByName("Desenvolvimento").getId());

		// System.out.println(Integer.parseInt(t.getQtdTipoHabilidade().toString()));
		// System.out.println(t.getQtdTipoHabilidade());
		// System.out.println(h.getHabilidadeByName("Java"));
		System.out.println(h.consultaHabilidade(tipo).size());

	}

}
