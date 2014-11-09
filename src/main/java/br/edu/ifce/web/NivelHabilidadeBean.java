package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.NivelHabilidadeDAO;
import br.edu.ifce.entity.NivelHabilidade;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class NivelHabilidadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private NivelHabilidade nivelHabilidade;
	private List<NivelHabilidade> nivelHabilidades;
	
	private boolean form = false;
	
	private NivelHabilidadeDAO nivelHabilidadeDAO = new NivelHabilidadeDAO();
	
	public void grid(){
		nivelHabilidade = null;
		nivelHabilidades = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}

	public List<NivelHabilidade> getNivelHabilidades() {
		if( nivelHabilidades == null){
			try {
				nivelHabilidades = nivelHabilidadeDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return nivelHabilidades;
	}
	
	public void salvar(){
		if(nivelHabilidade.getId() == null){
			try {
				nivelHabilidadeDAO.add(nivelHabilidade);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Nível de Habilidade", "Adcicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				nivelHabilidadeDAO.update(nivelHabilidade);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Nível de Habilidade", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(nivelHabilidade != null){
			try {
				nivelHabilidadeDAO.remove(nivelHabilidade);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Nível de Habilidade", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}

	
	public NivelHabilidade getNivelHabilidade() {
		if( nivelHabilidade == null){
			nivelHabilidade = new NivelHabilidade();
		}
		return nivelHabilidade;
	}

	public void setNivelHabilidade(NivelHabilidade nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}
	
	public boolean isForm() {
		return form;
	}
}
