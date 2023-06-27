package com.example.demo.service.impl;

import com.example.demo.dto.SongCreateDto;
import com.example.demo.model.Song;
import com.example.demo.repository.ISongRepository;
import com.example.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;


    @Override
    public Page<Song> displaySong(Pageable pageable) {
        return iSongRepository.findAllByCheckStatusIsFalse(pageable);
    }

    @Override
    public void createSong(Song song) {
          iSongRepository.save(song);
    }

    @Override
    public void deleteSong(int id) {
       Song song = getSongByID(id);
       song.setCheckStatus(true);
       iSongRepository.save(song);
    }

    @Override
    public void updateSong(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song getSongByID(int id) {
        return iSongRepository.findById(id).orElse(null);
    }
}
