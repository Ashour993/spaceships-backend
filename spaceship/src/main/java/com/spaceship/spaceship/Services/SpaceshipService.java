package com.spaceship.spaceship.Services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.spaceship.spaceship.Models.SpaceShip;

@Service
public class SpaceshipService {
    private final MongoOperations mongoOperations;

    public SpaceshipService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
    
    public SpaceShip addSpaceship(SpaceShip spaceship){
        return mongoOperations.insert(spaceship);
    }

    public List<SpaceShip> getSpaceships() {
        return mongoOperations. findAll(SpaceShip.class);
    }

    public List<SpaceShip> getSpaceShip (String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("world").is(id));
        return mongoOperations.find(query, SpaceShip.class);
    }

    public void deleteSaceShip(String id) {
        Query query = Query.query(Criteria.where("id").is(id));
        mongoOperations.remove(query, SpaceShip.class);
    }
}
