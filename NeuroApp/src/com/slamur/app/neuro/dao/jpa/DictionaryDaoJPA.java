package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.DictionaryDao;
import com.slamur.app.neuro.domain.dictionary.DictionaryEntity;
import com.slamur.lib.dao.jpa.DomainDictionaryDaoJPA;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class DictionaryDaoJPA
        extends DomainDictionaryDaoJPA<DictionaryEntity>
        implements DictionaryDao {

    public DictionaryDaoJPA() {
        super(DictionaryEntity.class);
    }

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<DictionaryEntity> getAllByType(Integer typeId) {
        Query query = getEntityManager().createQuery(
                String.format("SELECT e FROM %s e where e.type.id = %d ORDER BY e.id ASC", entityClassName, typeId)
        );
        return (List<DictionaryEntity>)query.getResultList();
    }
}
