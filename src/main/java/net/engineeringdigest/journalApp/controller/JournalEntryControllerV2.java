package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntry>>  getAll(){
        List<JournalEntry> list = this.journalEntryService.getAll();
        if (list != null && !list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createEntry")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
        JournalEntry entry = this.journalEntryService.createEntry(myEntry);
        return new ResponseEntity<>(entry,HttpStatus.CREATED);
    }


    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getJournalEntryById(@PathVariable Long myId){
        Optional<JournalEntry> entry = this.journalEntryService.getJournalEntryById(myId);
        if (entry.isPresent()) {
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable Long myId){
        Optional<JournalEntry> entry = this.journalEntryService.deleteJournalEntryById(myId);
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<?> updateJournalEntryById(@PathVariable Long myId, @RequestBody JournalEntry myEntry){
        JournalEntry entry = this.journalEntryService.updateJournalEntryById(myId, myEntry);
        if (entry != null){
            return new ResponseEntity<>(entry,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
