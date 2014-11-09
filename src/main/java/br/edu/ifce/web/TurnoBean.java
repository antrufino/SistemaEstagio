package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.TurnoDAO;
import br.edu.ifce.entity.Turno;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class TurnoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Turno turno;
	private List<Turno> turnos;
	
	private boolean form = false;
	
	private TurnoDAO turnoDAO = new TurnoDAO();
	
	public void grid(){
		turno = null;
		turno = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<Turno> getTurnos() {
		if(turnos == null){
			try {
				turnos = turnoDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return turnos;
	}
	
	public void salvar(){
		if(turno.getId() == null){
			try {
				turnoDAO.add(turno);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Turno", "Adicicionada com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				turnoDAO.update(turno);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Turno", "Atualizada com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(turno != null){
			try {
				turnoDAO.remove(turno);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Turno", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}
	
	
	public Turno getTurno() {
		if(turno == null){
			turno = new Turno();
		}
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public boolean isForm() {
		return form;
	}
}
