package com.spaceship.spaceship.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.spaceship.spaceship.Models.SpaceShip;
import com.spaceship.spaceship.Services.SpaceshipService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "https://clownfish-app-62pl3.ondigitalocean.app")
@RestController
       
public class SpaceshipController {

    private SpaceshipService spaceshipService;
    

    public SpaceshipController(SpaceshipService spaceshipService) {
        this.spaceshipService = spaceshipService;
    }
    @GetMapping
    public String getRoot() {
        return "{'Hello': 'World!'}";
    }

    @GetMapping("/spaceships")
    public List<SpaceShip> getSpaceships() {
        return spaceshipService.getSpaceships();
    }

    @GetMapping("/spaceship/{world}")
    public List<SpaceShip> getSpaceShip(@PathVariable String world) {
    return spaceshipService.getSpaceShip(world);
    }
    
    
    
     @PostMapping("/spaceships")
     public SpaceShip addSpaceship(@RequestBody SpaceShip spaceship){
     return spaceshipService.addSpaceship(spaceship);
     }

     @DeleteMapping("/spaceships/{id}") 
     public String deleteSpaceShip(@PathVariable String id) {
            spaceshipService.deleteSaceShip(id);
        return "{ message: Spaceship with id " + id + " has been deleted.)";
     }

   
     
     
   
    
}
