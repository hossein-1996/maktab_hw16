package Dao;

import entities.Contract;

import javax.persistence.EntityManager;

public class ContractDao extends AbstractJpaDao<Contract,Integer> {
    public ContractDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Contract> getEntityClass() {
        return Contract.class;
    }
}
