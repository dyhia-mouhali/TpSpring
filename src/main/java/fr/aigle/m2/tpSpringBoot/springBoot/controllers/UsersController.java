package fr.aigle.m2.tpSpringBoot.springBoot.controllers;

import fr.aigle.m2.tpSpringBoot.springBoot.models.User;
import fr.aigle.m2.tpSpringBoot.springBoot.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public User get(@PathVariable Long id) {
        if(!userRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID "+id+" not found");
        }
        return userRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user) {
        return  userRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Toujours verifier s'il faut supprimer aussi
        // les enregistrements enfants
        userRepository.deleteById(id);
    }
    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) {
        // TODO: Ajouter ici une validation si tous
        // les champs ont ete passes
        // Sinon, retourner une erreur 400 (Bad Payload)
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user,existingUser,"user_id");
        return userRepository.saveAndFlush(existingUser);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam(value="prenom",defaultValue="Elon") String prenom,
                        @RequestParam(value="nom",defaultValue="Musk") String nom,
                        @RequestParam(value="email",defaultValue="Elon.Musk@tesla.com") String email,
                        @RequestParam(value="phone_number",defaultValue="+55598760") String phone_number,
                        @RequestParam(value="password",defaultValue="ILoveMe") String password){

        int user_id;
        Random r = new Random();
        user_id = r.nextInt((1 - 100) + 1) + 1;

        User user = new User(user_id, prenom, nom, email, phone_number, password);

        return user;
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        System.out.println("Prenom : "+user.getFirst_name());
        return user;
    }
}
