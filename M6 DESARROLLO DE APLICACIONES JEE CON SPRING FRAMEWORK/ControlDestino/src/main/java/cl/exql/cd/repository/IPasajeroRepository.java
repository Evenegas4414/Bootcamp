package cl.exql.cd.repository;

import org.springframework.data.repository.CrudRepository;

import cl.exql.cd.model.Pasajero;

public interface IPasajeroRepository extends CrudRepository<Pasajero, Integer> {

}
