package at.refugeescode.bioapp.repository;

import at.refugeescode.bioapp.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {


}
