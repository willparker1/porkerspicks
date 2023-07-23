package com.porkerspicks.rest;

import com.porkerspicks.domain.Pick;
import com.porkerspicks.service.PickService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "picks/v1", produces = "application/json")
public class PickRestController {

    private final PickService pickService;

    public PickRestController(PickService pickService) {
        this.pickService = pickService;
    }

    @GetMapping
    public List<Pick> getAllPicks() {
        return pickService.getAllPicks();
    }

    @GetMapping("/post/{id}")
    public List<Pick> getAllPicksForPost( @PathVariable Integer id ) {
        return pickService.getAllPicksForPost( id );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pick> getPick(@PathVariable Integer id  ) {
        Pick savedPick = pickService.findPick(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if ( savedPick == null ) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>( savedPick, httpStatus);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pick addPick( @RequestBody Pick pick ) {
        return pickService.savePick(pick);
    }

    @PatchMapping(path="/{id}", consumes = "application/json")
    public Pick patchPick( @PathVariable Integer id, @RequestBody Pick pick ) {
        Pick existingPick = pickService.findPick(id);
        existingPick.setResult(pick.getResult());
        existingPick.setBetType(pick.getBetType());
        existingPick.setForecast(pick.getForecast());
        existingPick.setCompetitionTYpe(pick.getCompetitionTYpe());
        existingPick.setOpposition(pick.getOpposition());
        existingPick.setPrice(pick.getPrice());
        existingPick.setStake(pick.getStake());
        existingPick.setTeam(pick.getTeam());
        existingPick.setVenue(pick.getVenue());
        return pickService.savePick( existingPick );
    }

    @PutMapping(path="/{id}", consumes = "application/json")
    public Pick updatePick( @PathVariable Integer id, @RequestBody Pick pick ) {
        pick.setId(id);
        return pickService.savePick( pick );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deletePick( @PathVariable Integer id ) {
        pickService.deletePick( id );
    }
}