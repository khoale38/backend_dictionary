package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.backenddictionnary.backend_dictionary.models.Unit;
import com.example.backenddictionnary.backend_dictionary.repository.UnitRepository;

public class UnitService {

    @Autowired
    private UnitRepository UnitRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Unit> getAllUnit() {
        return UnitRepository.findAll();
    }

    public Unit getUnitByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Unit> result = mongoTemplate.find(query, Unit.class);
        if (result.size() == 0)
            return null;
        else
            return result.get(0);

    }

    public Unit addUnit(Unit Unit) {
        Unit findUnit = getUnitByName(Unit.getName());
        if (findUnit != null)
            return findUnit;
        else
            return UnitRepository.save(Unit);
    }

    public void deleteUnit(String name) {
        Unit existingUnit = getUnitByName(name);
        if (existingUnit == null) {
        } else
            UnitRepository.deleteById(existingUnit.getId());
    }
}
