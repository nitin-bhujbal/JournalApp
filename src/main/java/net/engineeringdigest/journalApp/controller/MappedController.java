package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapped")
public class MappedController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/getAllJournals")
    public ResponseEntity<?> getAllJournals(){
        List<JournalEntry> list = this.journalEntryService.getAllJournals();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/addJournal")
    public ResponseEntity<?> addJournal(@RequestBody JournalEntry entry){
        JournalEntry journalEntry = this.journalEntryService.addJournal(entry);
        return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
    }


}
