package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.CursoDAO;
import br.edu.ifce.entity.Curso;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class CursoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Curso curso;
	private List<Curso> cursos;
	
	private boolean form = false;
	
	private CursoDAO cursoDAO = new CursoDAO();
	
	public void grid(){
		curso = null;
		cursos = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<Curso> getCursos() {
		if(cursos == null){
			try {
				cursos = cursoDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao obter a lista")));
			}
		}
		return cursos;
	}
	
	public void salvar(){
		if(curso.getId() == null){
			try {
				cursoDAO.add(curso);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Curso", "Adcicionado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}else{
			try {
				cursoDAO.update(curso);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Curso", "Atualizado com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}
	
	public void excluir(){
		if(curso != null){
			try {
				cursoDAO.remove(curso);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Curso", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}

	
	public Curso getCurso() {
		if(curso == null){
			curso = new Curso();
		}
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public boolean isForm() {
		return form;
	}
}
