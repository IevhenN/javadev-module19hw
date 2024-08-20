package home.hw.module19hw.mapper;

import home.hw.module19hw.model.Note;
import home.hw.module19hw.model.request.NoteRequest;
import home.hw.module19hw.model.response.NoteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NoteMapper {

    NoteResponse noteToNoteResponse(Note note);

    List<NoteResponse> notesToNoteResponses(List<Note> note);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Note noteRequestToNote(NoteRequest noteRequest);
}
