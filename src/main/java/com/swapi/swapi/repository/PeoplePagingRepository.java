package com.swapi.swapi.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.swapi.swapi.model.People;

@Repository
public interface PeoplePagingRepository extends PagingAndSortingRepository<People, Long> {



    @Override
    Page<People> findAll(Pageable pageable);

}
