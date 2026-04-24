package com.spaceship.spaceship.Services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import com.spaceship.spaceship.Models.World;

public interface WorldRepository extends MongoRepository<World, String> {
    World findByWorldNameLikeAllIgnoreCase(String worldName);

    @Update("{'$set' : { 'worldName' :?1}}")
    public void findAndSetNameById(String id, String newName);
}
