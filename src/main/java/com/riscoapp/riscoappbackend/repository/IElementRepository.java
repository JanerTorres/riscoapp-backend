package com.riscoapp.riscoappbackend.repository;

import com.riscoapp.riscoappbackend.datamodel.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IElementRepository extends JpaRepository<Element, Integer> {
}
