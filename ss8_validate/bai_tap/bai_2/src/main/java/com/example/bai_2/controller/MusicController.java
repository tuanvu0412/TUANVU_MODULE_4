package com.example.bai_2.controller;

import com.example.bai_2.dto.MusicDto;
import com.example.bai_2.model.Music;
import com.example.bai_2.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping()
    public String getListMusic(Model model) {
        model.addAttribute("music", this.musicService.getMusicList());
        return "/list";
    }

    @GetMapping("/form-add")
    public String getFormAdd(Model model) {
        model.addAttribute("add", new Music());
        return "/form-add";
    }

    @PostMapping("/add")
    public String addMusic(@Valid @ModelAttribute(name = "add") MusicDto musicDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/form-add";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        this.musicService.add(music);
        redirectAttributes.addFlashAttribute("msg", "thêm mới thành công");
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String getFormEdit(@PathVariable(name = "id") int id, Model model, RedirectAttributes redirectAttributes) {
        if (musicService.findId(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "Không tim thấy id");
            return "redirect:/music";
        } else {
            model.addAttribute("music", musicService.findId(id));
            return "/edit";
        }
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute(name="music") MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/edit";
        } else if (musicService.findId(musicDto.getId()) == null) {
            redirectAttributes.addFlashAttribute("msg", "sửa không thành công");
            return "redirect:/music";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            this.musicService.edit(music);
            redirectAttributes.addFlashAttribute("msg", "sửa thành công");
            return "redirect:/music";
        }
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(name="id") int id,RedirectAttributes redirectAttributes){
        if (musicService.findId(id)==null){
            redirectAttributes.addFlashAttribute("msg","không tìm thấy"+musicService.getMusicList()+"để xóa");
            return "redirect:/music";
        }else {
            musicService.delete(id);
            redirectAttributes.addFlashAttribute("msg","xóa thành công");
            return "redirect:/music";
        }
    }
}
