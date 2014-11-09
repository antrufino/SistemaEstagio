package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.EmpresaDAO;
import br.edu.ifce.entity.Empresa;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class EmpresaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Empresa empresa;
	private List<Empresa> empresas;
	
	private boolean form = false;
	
	private EmpresaDAO empresaDAO = new EmpresaDAO();
	
	public void grid(){
		empresa = null;
		empresas = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<Empresa> getEmpresas() {
		if(empresas == null){
			try {
				empresas = empresaDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return empresas;
	}
	
	public void salvar(){
		if(empresa.getId() == null){
			try {
				empresaDAO.add(empresa);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Empresa", "Adicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				empresaDAO.update(empresa);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Empresa", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(empresa != null){
			try {
				empresaDAO.remove(empresa);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Empresa", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}
	
	public Empresa getEmpresa() {
		if(empresa == null){
			empresa = new Empresa();
		}
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isForm() {
		return form;
	}

}
