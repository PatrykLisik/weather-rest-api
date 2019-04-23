package nbd5.nbd5.services;

import nbd5.nbd5.domain.Entry;

import java.util.List;
import java.util.UUID;


public interface EntryService {

    List<Entry> listAll();

    Entry getById(UUID id);

    Entry saveOrUpdate(Entry entry);

    void delete(UUID id);
}
