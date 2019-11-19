package co.edu.uniquindio.converter;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.edu.uniquindio.uniMarket.entidades.TypeProduct;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@FacesConverter("typeProductConverter")
@ApplicationScoped
public class TypeProductConverter implements Converter<Object> {

	@EJB
	private NegocioEJB negocioEJB;

	@Override
	public TypeProduct getAsObject(FacesContext context, UIComponent component, String value) {

		if (value != null && !value.equals("")) {
			try {
				int code = Integer.parseInt(value);
				TypeProduct tp = negocioEJB.findTypeProduct(code);
				return tp;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value instanceof TypeProduct) {
			return ((TypeProduct) value).getName();
		} else {
			return null;
		}

	}

}
