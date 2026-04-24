package com.spaceship.spaceship.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.spaceship.spaceship.Models.World;
import com.spaceship.spaceship.Services.WorldService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class WorldController {

    private WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping("/worlds")
    public List<World> getWorlds() {
        return worldService.getWorlds();
    }

    @PostMapping("/world")
    public World addworld(@RequestBody World world) {
        return worldService.addWorld(world);
    }
    @GetMapping("/world/name/{name}") 
        public World getWorldByName(@PathVariable String name) {
            return worldService.getWorldByName(name);
        }

    @GetMapping("/world/id/{id}")
    public World getWorldById(@PathVariable String id) {
        return worldService.getWorldById(id);
    }
    @PatchMapping("/world/{id}")
    public World editWorld(@PathVariable String id, @RequestBody World world) {

        return worldService.editWorld(id, world);
    }

    @DeleteMapping("/world/{id}")
    public String deletWorld(@PathVariable String id) {
        worldService.deleteWorld(id);
        return "{}";
    }

    
    
            
        
    
}

   
    
    
    
    
    
    

