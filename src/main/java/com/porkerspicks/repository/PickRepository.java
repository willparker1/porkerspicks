package com.porkerspicks.repository;

import com.porkerspicks.domain.Pick;
import com.porkerspicks.domain.types.CompetitionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PickRepository extends JpaRepository<Pick, Integer> {

	List<Pick> findByPost_Id( Integer id );

	List<Pick> findByCompetition( CompetitionType competition );
}
