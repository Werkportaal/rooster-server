package Werkportaal.roosterserver.repository;


import Werkportaal.roosterserver.model.Rooster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoosterRepository extends JpaRepository<Rooster, String>{
}
