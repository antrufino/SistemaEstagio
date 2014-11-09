package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.TipoUsuarioDAO;
import br.edu.ifce.entity.TipoUsuario;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class TipoUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private TipoUsuario tipoUsuario;
	private List<TipoUsuario> tipoUsuarios;
	
	private boolean form = false;
	
	private TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
	
	public void grid(){
		tipoUsuario = null;
		tipoUsuarios = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<TipoUsuario> getTipoUsuarios() {
		if(tipoUsuarios == null){
			try {
				tipoUsuarios = tipoUsuarioDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return tipoUsuarios;
	}
	
	public void salvar(){
		if(tipoUsuario.getId() == null){
			try {
				tipoUsuarioDAO.add(tipoUsuario);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Usuário", "Adcicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				tipoUsuarioDAO.update(tipoUsuario);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Usuário", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(tipoUsuario != null){
			try {
				tipoUsuarioDAO.remove(tipoUsuario);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Usuário", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}

	
	public TipoUsuario getTipoUsuario() {
		if(tipoUsuario == null){
			tipoUsuario = new TipoUsuario();
		}
		return tipoUsuario;
	}
	
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public boolean isForm() {
		return form;
	}
}
