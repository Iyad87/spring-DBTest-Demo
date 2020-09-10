package it.fiat.manual.jse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.fiat.manual.jse.model.FiatDocMake;

@Repository
public interface FiatMakeRepository  extends JpaRepository<FiatDocMake,Long> {


}
