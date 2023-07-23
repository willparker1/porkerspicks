package com.porkerspicks.service;

import com.porkerspicks.domain.Pick;
import com.porkerspicks.domain.Post;

import java.util.List;

public interface PickService {

    public List<Pick> getAllPicksForPost( Integer id );

    public List<Pick> getAllPicks();

    public Pick savePick( Pick pick );

    public Pick findPick( Integer id );

    public void deletePick( Integer id );
}
