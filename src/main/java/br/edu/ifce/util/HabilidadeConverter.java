package br.edu.ifce.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifce.dao.HabilidadeDAO;
import br.edu.ifce.entity.Habilidade;

@FacesConverter(value = "habilidadeConverter")
public class HabilidadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		HabilidadeDAO dao = new HabilidadeDAO();
		if (value != null &&  value.trim().length() > 0 && !value.equals("Select One")) {
			Habilidade habilidade = dao.getHabilidadeByName(value);
			return habilidade;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		if(object instanceof Habilidade) {
			Habilidade obj = (Habilidade)object;
			return obj.toString();
		}
        else {
            return null;
        }
	}

}
