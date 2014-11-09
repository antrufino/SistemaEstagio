package br.edu.ifce.web;

import java.io.Serializable;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import br.edu.ifce.entity.ContatoTelefone;
import br.edu.ifce.entity.Pessoa;
import br.edu.ifce.entity.Usuario;

@ManagedBean
@ViewScoped
public class WizardBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	private Usuario usuario;
	private ContatoTelefone contato;
	private boolean skip;
	
	public Pessoa getPessoa(){
		if(pessoa == null)
			pessoa = new Pessoa();
		return pessoa;
	}
	
	public Usuario getUsuario(){
		return getLoginBean().getUsuario();
	}
	
	public ContatoTelefone getContato(){
		if(contato == null)
			contato = new ContatoTelefone();
		return contato;
	}
	
	public void setPessoa(Pessoa nova_pessoa){
		this.pessoa = nova_pessoa;
	}
	
	public void setUsuario(Usuario novo_usuario){
		getLoginBean().setUsuario(novo_usuario);
	}
	
	public void setContato(ContatoTelefone novo_contato){
		this.contato = novo_contato;
	}
	
	public boolean getSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    public void save() {        
        FacesMessage msg = new FacesMessage("Cadastro feito com sucesso", "Bem vindo :" + pessoa.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public LoginBean getLoginBean(){
    	ELContext contexto = FacesContext.getCurrentInstance().getELContext();
    	return (LoginBean) contexto.getELResolver().getValue(contexto, null, "loginBean");
    }

}
