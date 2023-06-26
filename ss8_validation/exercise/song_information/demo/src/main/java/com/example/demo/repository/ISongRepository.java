package com.example.demo.repository;

import com.example.demo.dto.SongCreateDto;
import com.example.demo.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> findAllByCheckStatusIsFalse(Pageable pageable);
}
