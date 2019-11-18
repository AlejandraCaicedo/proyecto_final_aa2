package co.edu.uniquindio.converter;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import co.edu.uniquindio.uniMarket.entidades.TypeProduct;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

@Named("typeProductConverter")
@ApplicationScoped
public class TypeProductConverter implements Converter<TypeProduct> {

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
	public String getAsString(FacesContext context, UIComponent component, TypeProduct value) {

		if (value != null) {
			return value.getCode() + "";
		}
		return null;
	}

}
