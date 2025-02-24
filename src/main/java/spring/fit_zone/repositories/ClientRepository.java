package spring.fit_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.fit_zone.models.Client;

public interface ClientRepository  extends JpaRepository<Client, Integer> {
}
