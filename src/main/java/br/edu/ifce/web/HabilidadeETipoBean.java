package br.edu.ifce.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.edu.ifce.dao.AlunoDao;
import br.edu.ifce.dao.HabilidadeDAO;
import br.edu.ifce.dao.TipoHabilidadeDAO;
import br.edu.ifce.dao.UsuarioDAO;
import br.edu.ifce.entity.Aluno;
import br.edu.ifce.entity.Habilidade;
import br.edu.ifce.entity.TipoHabilidade;
import br.edu.ifce.entity.Usuario;
import br.edu.ifce.exception.DAOException;

@ManagedBean
@ViewScoped
public class HabilidadeETipoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Habilidade> habilidades;
	private List<TipoHabilidade> tipoHabilidades;
	private Habilidade habilidade;
	private TipoHabilidade tipoHabilidade;
	private TipoHabilidadeDAO tipoHabilidadeDAO = new TipoHabilidadeDAO();
	private HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario;
	private Aluno aluno;
	private AlunoDao alunoDao = new AlunoDao();
	private boolean form = false;
	
	public HabilidadeETipoBean() {
	}
	
	public void grid(){
		habilidade = null;
		habilidades = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}

	@PostConstruct
	public void init(){
		try {
			tipoHabilidades = tipoHabilidadeDAO.list();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public Aluno getAluno(){
		if(aluno == null)
			aluno = new Aluno();
		return aluno;
	}
	
	public void setAluno(Aluno novo_aluno){
		this.aluno = novo_aluno;
	}
	
	public void listaHabilidades(AjaxBehaviorEvent event) throws DAOException {
		//habilidades = habilidadeDAO.consultaHabilidade(tipoHabilidade);
		if(tipoHabilidade!=null && !tipoHabilidade.equals("")){
			habilidades = habilidadeDAO.consultaHabilidadeByTipo(tipoHabilidade);
			System.out.println("Entrou!");
		}else{ 
			habilidades = new ArrayList<Habilidade>();
		}
	}
	
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	
	public void salvar(){
		  try {
				//usuarioDAO.update(getUsuario());
				alunoDao.update(getAluno());
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao atualizar")));
			}
		grid();
	}
		
	public void excluir(){
		if(habilidade != null){
			try {
				habilidadeDAO.remove(habilidade);
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Habilidade", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}
	
	public void displayLocation() {
        FacesMessage msg;
        if(habilidade != null && tipoHabilidade != null){
            //msg = new FacesMessage("Você selecionou:", tipoHabilidade + " e " + habilidade);
        }else{
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Tipo Habilidade is not selected."); 
        }
        //FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
	
	public List<Habilidade> getHabilidadesByAluno(){
		aluno = alunoDao.getAlunoByIdPessoa(getUsuario().getPessoa().getId());
		return aluno.getHabilidades();
	}

	public Usuario getUsuario(){
		return getLoginBean().getUsuario();
	}
	
	public void setUsuario(Usuario novo_usuario){
		getLoginBean().setUsuario(novo_usuario);
	}
	
	public LoginBean getLoginBean(){
    	ELContext contexto = FacesContext.getCurrentInstance().getELContext();
    	return (LoginBean) contexto.getELResolver().getValue(contexto, null, "loginBean");
    }
	
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	public List<TipoHabilidade> getTipoHabilidades() {
		return tipoHabilidades;
	}

	public void setTipoHabilidades(List<TipoHabilidade> tipoHabilidades) {
		this.tipoHabilidades = tipoHabilidades;
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	public TipoHabilidade getTipoHabilidade() {
		return tipoHabilidade;
	}

	public void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
		this.tipoHabilidade = tipoHabilidade;
	}
	
	public boolean isForm() {
		return form;
	}
}
