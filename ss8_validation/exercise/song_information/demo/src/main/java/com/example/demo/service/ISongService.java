package com.example.demo.service;

import com.example.demo.dto.SongCreateDto;
import com.example.demo.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISongService {

    Page<Song> displaySong(Pageable pageable);

    void createSong (Song song);

    void deleteSong(int id);
    void updateSong(Song song);

    Song getSongByID(int id);
}