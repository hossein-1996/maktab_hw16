package Dao;

import entities.City;

import javax.persistence.EntityManager;

public class CityDao extends AbstractJpaDao<City,Integer> {
    public CityDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
