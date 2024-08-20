package home.hw.module19hw.controller;

import home.hw.module19hw.model.request.NoteRequest;
import home.hw.module19hw.model.response.NoteResponse;
import home.hw.module19hw.sevice.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/notes")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/{id}")
    public NoteResponse getNote(@PathVariable Long id) {

        return noteService.getById(id);
    }

    @PostMapping()
    public NoteResponse postNote(@Valid @RequestBody NoteRequest noteRequest) {
        return noteService.save(noteRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
    }

    @PutMapping("/{id}")
    public NoteResponse putNote(@PathVariable Long id, @Valid @RequestBody NoteRequest noteRequest) {
        noteRequest.setId(id);
        return noteService.save(noteRequest);
    }

    @GetMapping("/all")
    public List<NoteResponse> getNoteList() {
        return noteService.findAll();
    }

}
