package br.edu.ifce.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifce.dao.TipoHabilidadeDAO;
import br.edu.ifce.entity.TipoHabilidade;

@FacesConverter(value = "tipoHabilidadeConverter")
public class TipoHabilidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		System.out.println("Value: " + value);
		TipoHabilidadeDAO dao = new TipoHabilidadeDAO();
		if (value != null &&  value.trim().length() > 0 && !value.equals("Select One")) {
			TipoHabilidade tipoHabilidade = dao.getTipoHabilidadeByName(value);
			return tipoHabilidade;
		} else {
			return new TipoHabilidade();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		if(object instanceof TipoHabilidade) {
			return ((TipoHabilidade) object).toString();
		}
        else {
            return null;
        }
	}

}
