package com.example.demo.controller;

import com.example.demo.dto.SongCreateDto;
import com.example.demo.model.Song;
import com.example.demo.repository.ISongRepository;
import com.example.demo.service.impl.SongService;
import jdk.internal.icu.text.NormalizerBase;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/list-song")
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    private ISongRepository songRepository;

    @GetMapping()
    public String showListSongs(@PageableDefault(size = 2) Pageable pageable, Model model) {
        model.addAttribute("songs", songRepository.findAllByCheckStatusIsFalse(pageable));
        return "/list-song";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("songCreateDto", new SongCreateDto());
        return "/create-song";
    }

    @PostMapping("/create")
    public String createSong(@Valid @ModelAttribute SongCreateDto songCreateDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create-song";
        }
        Song songEntity = new Song();
        BeanUtils.copyProperties(songCreateDto, songEntity);

        songService.createSong(songEntity);
        redirectAttributes.addFlashAttribute("message", "Create Song Success");
        return "redirect:/list-song";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (songService.getSongByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found id");
            return "redirect:/list-song";
        }else{
            Song song = songService.getSongByID(id);
          model.addAttribute("song",song);
          return "/delete-song";
        }
    }
    @PostMapping("/delete/{id}")
    public String deleteSong(@RequestParam("id") int id, RedirectAttributes redirectAttributes){
        if (songService.getSongByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found id");
            return "redirect:/list-song";
        }else {
            songService.deleteSong(id);
            redirectAttributes.addFlashAttribute("message", "Delete Song Success");
            return "redirect:/list-song";
        }
    }
    @GetMapping("/edit/{id}")
    public String showFormEidt(@PathVariable int id, Model model,RedirectAttributes redirectAttributes){
        if (songService.getSongByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found id");
            return "redirect:/list-song";
        }else{
            SongCreateDto songCreateDto = new SongCreateDto();
            Song song = songService.getSongByID(id);
            BeanUtils.copyProperties(song,songCreateDto);
            model.addAttribute("songCreateDto",songCreateDto);
            return "/edit-song";
        }
    }
    @PostMapping("/edit/{id}")
    public String editSong(@Valid @ModelAttribute SongCreateDto songCreateDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "/edit-song";
        }
        Song songEntity = new Song();
        BeanUtils.copyProperties(songCreateDto, songEntity);

        songService.updateSong(songEntity);
        redirectAttributes.addFlashAttribute("message", "Edit Song Success");
        return "redirect:/list-song";
    }
}
