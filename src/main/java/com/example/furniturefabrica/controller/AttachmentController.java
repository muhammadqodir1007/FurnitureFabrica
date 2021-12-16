package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.Attachment;
import com.example.furniturefabrica.entity.AttachmentContent;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.repositories.AttachmentContentRepository;
import com.example.furniturefabrica.repositories.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @PostMapping("/upload")
    public ApiResponse saveDb(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        if (file != null) {
            Attachment attachment = new Attachment();
            attachment.setOriginalName(file.getOriginalFilename());
            attachment.setSize(file.getSize());
            attachment.setType(file.getContentType());
            attachment.setSize(file.getSize());
            Attachment save = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setBytes(file.getBytes());
            attachmentContent.setAttachment(save);
            attachmentContentRepository.save(attachmentContent);
            return new ApiResponse("success", true);


        }
        return new ApiResponse("not saved", false);


    }

    @GetMapping("/info")
    public List<Attachment> getAll() {
        return attachmentRepository.findAll();
    }

    @GetMapping("/info/{id}")

    public ApiResponse getOne(@PathVariable Integer id) {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        Attachment attachment = byId.get();

        return new ApiResponse("success", true, attachment);


    }

    @DeleteMapping("delete/{id}")
    public ApiResponse delete(@PathVariable Integer id) {

        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        Attachment attachment = byId.get();
        attachmentRepository.deleteById(id);

        return new ApiResponse("success", true);


    }

    @GetMapping("/download/{id}")

    public void getFromDb(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isPresent()) {
            Attachment attachment = byId.get();

            Optional<AttachmentContent> contentRepositoryById = attachmentContentRepository.findById(id);
            if (contentRepositoryById.isPresent()) {
                AttachmentContent attachmentContent = contentRepositoryById.get();

                response.setHeader("Content-Disposition", attachment.getOriginalName() + "/:" + attachment.getSize());

                response.setContentType(attachment.getType());
                FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());


            }
        }
    }

}
