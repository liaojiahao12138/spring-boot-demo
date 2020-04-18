package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    private static String UPLOADED_FOLDER = "/Users/anker/Desktop";

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload()throws Exception{
        return "upload";
    }

    @PostMapping("/upload")
    public String singFileUpload(@RequestParam("file")MultipartFile file,
                                 RedirectAttributes redirectAttributes){
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message","please select a file upload");
            return "redirect:uploadStatus";
        }
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path,bytes);
            redirectAttributes.addFlashAttribute("message","You successfully upload");
        }catch (IOException e){
            e.printStackTrace();
        }
           return "redirect:uploadStatus";
    }

    @GetMapping("/more")
    public String uploadMore(){
        return "uploadMore";
    }

    @PostMapping("/uploadMore")
    public String moreFileUpload(@RequestParam("file")MultipartFile[] files,
                                 RedirectAttributes redirectAttributes){
        if(files.length == 0){
            redirectAttributes.addFlashAttribute("message","please select a file to upload");
            return "redirect:uploadStatus";
        }
        for(MultipartFile file:files){
            try{
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path,bytes);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message","You successfully uploaded all ");
        return "redirect:uploadStatus";

    }

    @GetMapping("uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }
}
