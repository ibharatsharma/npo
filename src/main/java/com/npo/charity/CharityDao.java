package com.npo.charity;

import com.npo.domain.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharityDao extends JpaRepository<Charity, Long> {

    Optional<Charity> findByName(String name);
}
