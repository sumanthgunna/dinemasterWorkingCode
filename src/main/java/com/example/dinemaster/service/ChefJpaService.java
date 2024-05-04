/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.dinemaster.service;

import java.util.*;
import com.example.dinemaster.repository.ChefRepository;
import com.example.dinemaster.repository.ChefJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.dinemaster.model.*;

@Service
public class ChefJpaService implements ChefRepository {

    @Autowired
    private ChefJpaRepository chefJpaRepository;

    @Autowired
    private RestaurantJpaService restaurantJpaService;

    @Override
    public ArrayList<Chef> getChefs() {
        List<Chef> chefsList = chefJpaRepository.findAll();
        ArrayList<Chef> chefs = new ArrayList<>(chefsList);
        return chefs;
    }

    @Override
    public Chef getChefById(int chefId) {
        try {
            Chef chef = chefJpaRepository.findById(chefId).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef addChef(Chef chef) {
        Restaurant restaurant = chef.getRestaurant();
        int restaurantId = restaurant.getId();

        try {
            Restaurant completeRestaurant = restaurantJpaService.getRestaurantById(restaurantId);
            chef.setRestaurant(completeRestaurant);
            chefJpaRepository.save(chef);
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef updateChef(int chefId, Chef chef) {
        try {
            Chef newChef = chefJpaRepository.findById(chefId).get();
            if (chef.getFirstName() != null) {
                newChef.setFirstName(chef.getFirstName());
            }
            if (chef.getLastName() != null) {
                newChef.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != null) {
                newChef.setExpertise(chef.getExpertise());
            }
            if (chef.getExperienceYears() != 0) {
                newChef.setExperienceYears(chef.getExperienceYears());
            }
            if (chef.getRestaurant() != null) {
                int restaurantId = chef.getRestaurant().getId();
                Restaurant restaurant = restaurantJpaService.getRestaurantById(restaurantId);
                newChef.setRestaurant(restaurant);
            }
            chefJpaRepository.save(newChef);
            return newChef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteChef(int chefId) {
        try {
            chefJpaRepository.deleteById(chefId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Restaurant getChefRestaurant(int chefId) {
        try {
            Chef chef = chefJpaRepository.findById(chefId).get();
            Restaurant restaurant = chef.getRestaurant();
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}