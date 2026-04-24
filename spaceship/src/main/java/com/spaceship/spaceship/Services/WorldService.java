package com.spaceship.spaceship.Services;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.spaceship.spaceship.Models.World;

@Service
public class WorldService {
    private WorldRepository worldRepository;

    public WorldService(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }
public World addWorld(World world) {
    return worldRepository.insert(world);
}
    public World getWorldByName(String worldName) {
        return worldRepository.findByWorldNameLikeAllIgnoreCase(worldName);
    }

public World getWorldById(String id){

Optional<World> world = worldRepository.findById(id);

if (world.isPresent()) {
    return world.get();
} else {
    return null; 
}
}

public World editWorld(String id, World world) {
    worldRepository.findAndSetNameById(id, world.getWorldName());
    Optional<World> newworld = worldRepository.findById(id);
    return newworld.get();
}

public void deleteWorld(String id) {
    worldRepository.deleteById(id);
}
}

