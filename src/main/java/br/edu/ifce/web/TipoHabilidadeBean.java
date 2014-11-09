package br.edu.ifce.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.edu.ifce.dao.TipoHabilidadeDAO;
import br.edu.ifce.entity.TipoHabilidade;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class TipoHabilidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private TipoHabilidade tipoHabilidade;
	private List<TipoHabilidade> tipoHabilidades;

	private boolean form = false;

	private TipoHabilidadeDAO tipoHabilidadeDAO = new TipoHabilidadeDAO();

	public void grid() {
		tipoHabilidade = null;
		tipoHabilidades = null;
		form = false;
	}

	public void form() {
		form = true;
	}

	public List<TipoHabilidade> gettipoHabilidades() {
		if (tipoHabilidades == null) {
			try {
				tipoHabilidades = tipoHabilidadeDAO.list();
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null,
						(new FacesMessage("Erro ao obter a lista")));
			}
		}
		return tipoHabilidades;
	}

	public void salvar() {
		if (tipoHabilidade.getId() == null) {
			try {
				tipoHabilidadeDAO.add(tipoHabilidade);
				FacesContext.getCurrentInstance().addMessage(
						null,
						(new FacesMessage("Nova habilidade",
								"Adcicionada com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null,
						(new FacesMessage("Erro ao atualizar")));
			}
		} else {
			try {
				tipoHabilidadeDAO.update(tipoHabilidade);
				FacesContext.getCurrentInstance().addMessage(
						null,
						(new FacesMessage("Nova habilidade",
								"Atualizada com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null,
						(new FacesMessage("Erro ao atualizar")));
			}
		}
		grid();
	}

	public void excluir() {
		if (tipoHabilidade != null) {
			try {
				tipoHabilidadeDAO.remove(tipoHabilidade);
				FacesContext.getCurrentInstance()
						.addMessage(
								null,
								(new FacesMessage("Habilidade",
										"Excluída com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null,
						(new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}

	public TipoHabilidade getTipoHabilidade() {
		if (tipoHabilidade == null) {
			tipoHabilidade = new TipoHabilidade();
		}
		return tipoHabilidade;
	}

	public void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
		this.tipoHabilidade = tipoHabilidade;
	}

	public boolean isForm() {
		return form;
	}
	
}
