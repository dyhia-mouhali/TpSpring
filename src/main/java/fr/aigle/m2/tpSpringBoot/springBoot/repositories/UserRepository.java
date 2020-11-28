package fr.aigle.m2.tpSpringBoot.springBoot.repositories;

import fr.aigle.m2.tpSpringBoot.springBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
