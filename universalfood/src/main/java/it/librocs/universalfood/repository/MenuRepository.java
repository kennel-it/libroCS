package it.librocs.universalfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.librocs.universalfood.oggetti.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
