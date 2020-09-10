package it.fiat.manual.jse.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import it.fiat.manual.jse.model.FiatDocMake;

@Repository
public interface FiatMakeDao {


    List<FiatDocMake> getAll();
}
