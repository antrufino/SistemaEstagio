package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.RedeSocialDAO;
import br.edu.ifce.entity.RedeSocial;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class RedeSocialBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private RedeSocial redeSocial;
	private List<RedeSocial> redesSociais;
	
	private boolean form = false;
	
	private RedeSocialDAO redeSocialDAO = new RedeSocialDAO();
	
	public void grid(){
		redeSocial = null;
		redesSociais = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<RedeSocial> getRedesSociais() {
		if(redesSociais == null){
			try {
				redesSociais = redeSocialDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return redesSociais;
	}
	
	public void salvar(){
		if(redeSocial.getId() == null){
			try {
				redeSocialDAO.add(redeSocial);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Rede Social", "Adcicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				redeSocialDAO.update(redeSocial);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Rede Social", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(redeSocial != null){
			try {
				redeSocialDAO.remove(redeSocial);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Rede Social", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}
	
	
	public RedeSocial getRedeSocial() {
		if(redeSocial == null){
			redeSocial = new RedeSocial();
		}
		return redeSocial;
	}

	public void setRedeSocial(RedeSocial RedeSocial) {
		this.redeSocial = RedeSocial;
	}
	
	public boolean isForm() {
		return form;
	}
}
