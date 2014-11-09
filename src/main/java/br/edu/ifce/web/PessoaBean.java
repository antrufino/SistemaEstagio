package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.PessoaDAO;
import br.edu.ifce.entity.Pessoa;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	private boolean form = false;
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	public void grid(){
		pessoa = null;
		pessoas = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<Pessoa> getPessoas() {
		if( pessoas == null){
			try {
				pessoas = pessoaDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return pessoas;
	}
	
	public void salvar(){
		if( pessoa.getId() == null){
			try {
				pessoaDAO.add(pessoa);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Pessoa", "Adcicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				pessoaDAO.update(pessoa);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Pessoa", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if( pessoa != null){
			try {
				pessoaDAO.remove(pessoa);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Pessoa", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}
	
	
	public Pessoa getPessoa() {
		if( pessoa == null){
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public boolean isForm() {
		return form;
	}
}
