package co.edu.uniquindio.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("ejemploBean")
@ApplicationScoped
public class EjemploBean {

	private String atributo1;
	private String atributo2;

	public void cambiar() {
		String aux = atributo1;
		atributo1 = atributo2;
		atributo2 = aux;
	}

	public String getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	public String getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}

}

//@Named
//@ViewScoped
//public class DataGridView implements Serializable {
//
//	private List<Car> cars;
//
//	private Car selectedCar;
//
//	@Inject
//	private CarService service;
//
//	@PostConstruct
//	public void init() {
//		cars = service.createCars(48);
//	}
//
//	public List<Car> getCars() {
//		return cars;
//	}
//
//	public void setService(CarService service) {
//		this.service = service;
//	}
//
//	public Car getSelectedCar() {
//		return selectedCar;
//	}
//
//	public void setSelectedCar(Car selectedCar) {
//		this.selectedCar = selectedCar;
//	}
//}
