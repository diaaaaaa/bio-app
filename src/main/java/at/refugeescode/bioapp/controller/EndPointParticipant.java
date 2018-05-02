package at.refugeescode.bioapp.controller;

import at.refugeescode.bioapp.model.Participant;
import at.refugeescode.bioapp.repository.ParticipantRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Scope("session")
public class EndPointParticipant {
    private Participant participant;
    private ParticipantRepository participantRepository;
   // private boolean login;

    public EndPointParticipant(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @GetMapping("/")
    String mainPage(){

        return "home";
    }
    @ModelAttribute("participants")
    List<Participant> getParticipants() {
        return participantRepository.findAll();
    }
    @ModelAttribute("participant")
    Participant addParticipant(){
        return new Participant();
    }
    @PostMapping("/addParticipant")
    String addPatient(Participant participant){
        this.participant=participant;
        participantRepository.save(this.participant);

        return "redirect:/";
    }


}
