package fr.aigle.m2.tpSpringBoot.springBoot.repositories;

import fr.aigle.m2.tpSpringBoot.springBoot.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
