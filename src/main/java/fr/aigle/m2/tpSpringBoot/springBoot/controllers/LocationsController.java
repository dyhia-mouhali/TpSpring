package fr.aigle.m2.tpSpringBoot.springBoot.controllers;

import fr.aigle.m2.tpSpringBoot.springBoot.models.Location;
import fr.aigle.m2.tpSpringBoot.springBoot.models.User;
import fr.aigle.m2.tpSpringBoot.springBoot.repositories.LocationRepository;
import fr.aigle.m2.tpSpringBoot.springBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationsController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/location")
    public Location getLocation(@RequestParam(value="latitude",defaultValue="43.63746472422702") double latitude,
                        @RequestParam(value="longitude",defaultValue="3.8409670228559136") double longitude,
                        @RequestParam(value="location_date",defaultValue="Elon.Musk@tesla.com") LocalDateTime location_date){

        int location_id;
        Random r = new Random();
        location_id = r.nextInt((1 - 100) + 1) + 1;

        //DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        //String date = location_date.format(dt);

        Location location = new Location(location_id, latitude, longitude, location_date);

        return location;
    }

    @PostMapping("/location")
    public Location postLocation(@RequestBody Location location) {
        System.out.println("Latitude : "+location.getLatitude());
        return location;
    }
}
