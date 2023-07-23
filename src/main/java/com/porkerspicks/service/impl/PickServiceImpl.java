package com.porkerspicks.service.impl;

import com.porkerspicks.domain.Pick;
import com.porkerspicks.domain.Post;
import com.porkerspicks.domain.types.PostStatusType;
import com.porkerspicks.repository.PickRepository;
import com.porkerspicks.repository.PostRepository;
import com.porkerspicks.service.PickService;
import com.porkerspicks.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PickServiceImpl implements PickService {

    private final PickRepository pickRepository;

    public PickServiceImpl(PickRepository pickRepository) {
        this.pickRepository = pickRepository;
    }

    public List<Pick> getAllPicksForPost( Integer id ) {
        return pickRepository.findByPost_Id( id );
    }

    public List<Pick> getAllPicks() {
        return pickRepository.findAll();
    }

    public Pick savePick( Pick pick ) {
        pick.setTimestamp( new Date() );
        return pickRepository.save(pick);
    }

    public Pick findPick( Integer id ) {
        return pickRepository.findById(id).get();
    }

    public void deletePick( Integer id ) {
        pickRepository.deleteById(id);
    }
}
