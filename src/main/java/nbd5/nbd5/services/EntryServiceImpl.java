package nbd5.nbd5.services;

import nbd5.nbd5.domain.Entry;
import nbd5.nbd5.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class EntryServiceImpl implements EntryService {

    private EntryRepository entryRepository;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }


    @Override
    public List<Entry> listAll() {
        List<Entry> entries = new ArrayList<>();
        entryRepository.findAll().forEach(entries::add);
        return entries;
    }

    @Override
    public Entry getById(UUID id) {
        return entryRepository.findById(id).orElse(null);
    }

    @Override
    public Entry saveOrUpdate(Entry entry) {
        entryRepository.save(entry);
        return entry;
    }

    @Override
    public void delete(UUID id) {
        entryRepository.deleteById(id);

    }
}
