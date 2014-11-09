/* Copyright 2013-2014 J7 Soluções Inteligentes.
 *
 * by Edivando Alves 
 * Contact: edivando@j7.eti.br
 * 
 */

package br.edu.ifce.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

/**
 * 
 * 
 * @author Edivando Alves
 * 
 */
@Entity
@Table(name = "tipo_rede_social")
@NamedQueries({
		@NamedQuery(name = "TipoRedeSocial", query = "from TipoRedeSocial rs")
})
public class TipoRedeSocial implements IGenericEntity<TipoRedeSocial> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_rede_social")
	private Integer id;

	@Column(name = "ds_tipo_rede_social", length = 80, nullable = false)
	private String dsTipoRedeSocial;
	
	//@OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
	//private List<Usuario> usuarios;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsTipoRedeSocial() {
		return dsTipoRedeSocial;
	}

	public void setDsTipoRedeSocial(String dsTipoRedeSocial) {
		this.dsTipoRedeSocial = dsTipoRedeSocial;
	}

	@Override
	public String toString() {
		return dsTipoRedeSocial;
	}

	
}
