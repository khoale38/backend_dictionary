package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.FavoriteUnit;
import com.example.backenddictionnary.backend_dictionary.repository.FavoriteUnitRepository;

@Service
public class FavoriteUnitService {
    @Autowired
    private FavoriteUnitRepository favoriteUnitRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<FavoriteUnit> getAllFavoriteUnit() {
        return favoriteUnitRepository.findAll();
    }

    public FavoriteUnit addFavoriteUnitToUser(FavoriteUnit test) {
        return favoriteUnitRepository.save(test);
    }

    public List<FavoriteUnit> getFavoriteUnitByUser(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<FavoriteUnit> result = mongoTemplate.find(query, FavoriteUnit.class);
        return result;
    }

    public void deleteFavoriteUnit(String id) {
        favoriteUnitRepository.deleteById(id);
    }

    public FavoriteUnit getFavoriteUnitById(String unitid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("unitId").is(unitid));
        FavoriteUnit result = mongoTemplate.findOne(query, FavoriteUnit.class);
        return result;
    }

    public void deleteFavoriteUnitByUnitId(String unitid, String userid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("unitId").is(unitid).and("userId").is(userid));
        FavoriteUnit result = mongoTemplate.findOne(query, FavoriteUnit.class);
        if (result == null)
            return;
        favoriteUnitRepository.deleteById(result.getId());
    }
}
