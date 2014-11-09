package br.edu.ifce.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.ifce.dao.UsuarioDAO;
import br.edu.ifce.entity.TipoUsuario;
import br.edu.ifce.entity.Usuario;
import br.edu.ifce.util.MD5;

/**
 * 
 * 
 * 
 * @author Edivando Alves
 *
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void login(){
		try {
			List<Usuario> usuarios = usuarioDAO.ListByCdEmailAndSenha(usuario.getCdEmail(), MD5.md5(usuario.getCdSenha()));
			if(usuarios != null && usuarios.size() > 0 ){
				usuario = usuarios.get(0);
				FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
			}else{
				usuario = new Usuario();
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage(FacesMessage.SEVERITY_WARN, "Desculpe!", "Mas o email ou a senha informada não confere. Tente novamente!")));
			}
		} catch (Exception e) {
		
		}
	}
	
	public void logoff(){
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			
		}
	}
	
	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isPagePermission(String paginaDestino) {
		for (String page : usuario.getTipoUsuario().getCdPaginaAcesso().split(",")) {
			if(page.equals(paginaDestino)) return true;
		}
		return false;
	}
	
}
