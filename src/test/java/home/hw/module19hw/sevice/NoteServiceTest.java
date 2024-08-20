package home.hw.module19hw.sevice;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import home.hw.module19hw.mapper.NoteMapper;
import home.hw.module19hw.model.Note;
import home.hw.module19hw.model.User;
import home.hw.module19hw.model.request.NoteRequest;
import home.hw.module19hw.model.response.NoteResponse;
import home.hw.module19hw.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @Mock
    private UserService userService;

    @Mock
    private NoteMapper noteMapper;

    @InjectMocks
    private NoteService noteService;

    @Test
    public void testSaveNote() {
        //given
        User mockUser = new User();
        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setTitle("Title");
        noteRequest.setContent("Content");

        Note note = new Note();
        note.setTitle("Title");
        note.setContent("Content");
        note.setUser(mockUser);

        NoteResponse expectedResponse = new NoteResponse();
        expectedResponse.setTitle("Title");
        expectedResponse.setContent("Content");
        expectedResponse.setId(1L);

        when(userService.getCurrentUser()).thenReturn(mockUser);
        when(noteMapper.noteRequestToNote(noteRequest)).thenReturn(note);
        when(noteRepository.save(any(Note.class))).thenReturn(note);
        when(noteMapper.noteToNoteResponse(note)).thenReturn(expectedResponse);

        //when
        NoteResponse actualResponse = noteService.save(noteRequest);

        // then
        assertEquals(expectedResponse, actualResponse);
        verify(userService, times(1)).getCurrentUser();
        verify(noteMapper, times(1)).noteRequestToNote(noteRequest);
        verify(noteRepository, times(1)).save(note);
        verify(noteMapper, times(1)).noteToNoteResponse(note);
    }
}

















