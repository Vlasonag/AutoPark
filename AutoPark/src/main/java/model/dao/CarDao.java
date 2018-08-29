package model.dao;

import java.util.List;

import model.entity.Car;

public interface CarDao extends GenericDao<Car> {
	void deleteByNumber(String id);
	List<Car> findAllFreeCars();
	String getModelByNumber(String number);
	void setCarBusy(String number);
}
