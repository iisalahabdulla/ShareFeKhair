package com.example.sharefekhair.repository;

import com.example.sharefekhair.model.Comment;
import com.example.sharefekhair.model.MyUser;
import com.example.sharefekhair.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    Optional<List<Comment>> findCommentsByNote_Id(UUID note_id);
    Optional<List<Comment>> findCommentsByUser(MyUser user);
}
