package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;

import java.util.List;
import java.util.Optional;

public interface JournalEntryService {


    JournalEntry createEntry(JournalEntry myEntry);

    List<JournalEntry> getAll();

    Optional<JournalEntry> getJournalEntryById(Long myId);

    Optional<JournalEntry> deleteJournalEntryById(Long myId);

    JournalEntry updateJournalEntryById(Long myId, JournalEntry myEntry);

    JournalEntry addJournal(JournalEntry entry);

    List<JournalEntry> getAllJournals();
}
