package Dao;

import entities.Match;

import javax.persistence.EntityManager;

public class MatchDao extends AbstractJpaDao<Match,Integer> {
    public MatchDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Match> getEntityClass() {
        return Match.class;
    }
}
