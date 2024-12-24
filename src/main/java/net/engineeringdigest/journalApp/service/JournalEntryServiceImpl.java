package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repo.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;


    @Override
    public List<JournalEntry> getAll() {

        return this.journalEntryRepository.findAll();
    }

    @Override
    public JournalEntry createEntry(JournalEntry myEntry) {
        JournalEntry entry = this.journalEntryRepository.save(myEntry);
        return entry;
    }


    @Override
    public Optional<JournalEntry> getJournalEntryById(Long myId) {

        return this.journalEntryRepository.findById(myId);
    }

    @Override
    public Optional<JournalEntry> deleteJournalEntryById(Long myId) {
        Optional<JournalEntry> entry = getJournalEntryById(myId);
        this.journalEntryRepository.deleteById(myId);
        return entry;
    }

    @Override
    public JournalEntry updateJournalEntryById(Long myId, JournalEntry myEntry) {
        JournalEntry entry = this.journalEntryRepository.findById(myId).orElse(null);
        if (entry != null){
            entry.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals("") ? myEntry.getTitle() : entry.getTitle());
            entry.setContent(myEntry.getContent() != null && !myEntry.getContent().equals("") ? myEntry.getContent() : entry.getContent());
        }

        assert entry != null;
        return this.journalEntryRepository.save(entry);
    }

    @Override
    public JournalEntry addJournal(JournalEntry entry) {

        return this.journalEntryRepository.save(entry);
    }

    @Override
    public List<JournalEntry> getAllJournals() {
        return this.journalEntryRepository.findAll();
    }
}
