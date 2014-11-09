package br.edu.ifce.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.EstagioDAO;
import br.edu.ifce.entity.Estagio;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class EstagioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Estagio estagio;
	private List<Estagio> estagioList;
	private String pesquisa = null;
	//recebem valores de datas da página ofertas.xhtml
	private Date dtInicial = null;
	private Date dtFim = null;
	private boolean form = false;
	
	private EstagioDAO estagioDAO = new EstagioDAO();
	
	public void grid(){
		estagio = null;
		estagioList = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public List<Estagio> getEstagioList() {
		if(estagioList == null){
			try {
				estagioList = estagioDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return estagioList;
	}
	
	public void salvar(){
		if(estagio.getId() == null){
			try {
				estagioDAO.add(estagio);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Estagio", "Adicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				estagioDAO.update(estagio);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Estagio", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(estagio != null){
			try {
				estagioDAO.remove(estagio);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Estagio", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}
	
	public void pesquisarEstagios(){
		List<Estagio> lista = estagioList;

		if (dtInicial == null && dtFim == null) {
			try {
				lista = estagioDAO.listByPesquisa(pesquisa);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				lista = estagioDAO.listByPesquisa2(pesquisa, dtInicial, dtFim);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * pesquisa = null; dtInicial = null; dtFim = null;
		 */
		estagioList = lista;	
	}
	
	public void mostrarTodos(){
		
		List<Estagio> lista = estagioList;
		
		try {
			lista = estagioDAO.listByPesquisa(null);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		estagioList = lista;
	}
	
	public Estagio getEstagio() {
		if(estagio == null){
			estagio = new Estagio();
		}
		return estagio;
	}

	public void setEstagio(Estagio estagio) {
		this.estagio = estagio;
	}

	public boolean isForm() {
		return form;
	}
}
