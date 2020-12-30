package Dao;

import entities.Team;

import javax.persistence.EntityManager;

public class TeamDao extends AbstractJpaDao<Team,Integer> {
    public TeamDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Team> getEntityClass() {
        return Team.class;
    }
}
