
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
 * @author Rodrigo
 *
 */
@Entity
@Table(name = "rede_social")
@NamedQueries({
		@NamedQuery(name = "RedeSocial", query = "select rs from RedeSocial rs")
})
public class RedeSocial implements IGenericEntity<RedeSocial> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rede_social")
	private Integer id;

	@Column(name = "ds_rede_social", length = 80, nullable = false)
	private String dsRedeSocial;
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsRedeSocial() {
		return dsRedeSocial;
	}

	public void setDsRedeSocial(String dsRedeSocial) {
		this.dsRedeSocial = dsRedeSocial;
	}

	@Override
	public String toString() {
		return dsRedeSocial;
	}
	
}
