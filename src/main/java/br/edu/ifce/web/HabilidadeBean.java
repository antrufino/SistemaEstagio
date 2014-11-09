package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.HabilidadeDAO;
import br.edu.ifce.entity.Habilidade;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class HabilidadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Habilidade habilidade;
	private List<Habilidade> habilidades;
	
	private boolean form = false;
	
	private HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
	
	public void grid(){
		habilidade = null;
		habilidades = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<Habilidade> getHabilidades() {
		if( habilidades == null){
			try {
				habilidades = habilidadeDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return habilidades;
	}
	
	public void salvar(){
		if(habilidade.getId() == null){
			try {
				habilidadeDAO.add(habilidade);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Habilidade", "Adicicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				habilidadeDAO.update(habilidade);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Habilidade", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(habilidade != null){
			try {
				habilidadeDAO.remove(habilidade);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("hHabilidade", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}

	
	public Habilidade getHabilidade() {
		if( habilidade == null){
			habilidade = new Habilidade();
		}
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}
	
	public boolean isForm() {
		return form;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	
}
