package home.hw.module19hw.repository;

import home.hw.module19hw.model.Note;
import home.hw.module19hw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByIdAndUser(Long id, User user);

    List<Note> findAllByUser(User user);

    @Modifying
    @Transactional
    @Query("DELETE FROM Note n WHERE n.id = :id AND n.user = :user")
    void deleteByIdAndUser(Long id, User user);
}
