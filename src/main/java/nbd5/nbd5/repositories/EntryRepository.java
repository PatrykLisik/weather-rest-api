package nbd5.nbd5.repositories;

import nbd5.nbd5.domain.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EntryRepository extends CrudRepository<Entry, UUID> {
}
