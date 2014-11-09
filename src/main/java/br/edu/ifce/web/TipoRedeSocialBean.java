package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.TipoRedeSocialDAO;
import br.edu.ifce.entity.TipoRedeSocial;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class TipoRedeSocialBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private TipoRedeSocial tipoRedeSocial;
	private List<TipoRedeSocial> tipoRedeSociais;
	
	private boolean form = false;
	
	private TipoRedeSocialDAO tipoRedeSocialDAO = new TipoRedeSocialDAO();
	
	public void grid(){
		tipoRedeSocial = null;
		tipoRedeSociais = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<TipoRedeSocial> getTipoRedeSociais() {
		if(tipoRedeSociais == null){
			try {
				tipoRedeSociais = tipoRedeSocialDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return tipoRedeSociais;
	}
	
	public void salvar(){
		if(tipoRedeSocial.getId() == null){
			try {
				tipoRedeSocialDAO.add(tipoRedeSocial);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Rede Social", "Adcicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				tipoRedeSocialDAO.update(tipoRedeSocial);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Rede Social", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(tipoRedeSocial != null){
			try {
				tipoRedeSocialDAO.remove(tipoRedeSocial);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Tipo de Rede Social", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}
	
	
	public TipoRedeSocial getTipoRedeSocial() {
		if(tipoRedeSocial == null){
			tipoRedeSocial = new TipoRedeSocial();
		}
		return tipoRedeSocial;
	}

	public void setTipoRedeSocial(TipoRedeSocial tipoRedeSocial) {
		this.tipoRedeSocial = tipoRedeSocial;
	}
	
	public boolean isForm() {
		return form;
	}
}
