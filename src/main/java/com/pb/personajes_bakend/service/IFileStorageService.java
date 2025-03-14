package com.pb.personajes_bakend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileStorageService {
    String storeFile(MultipartFile file) throws IOException;

    void deleteFile(String fileName);
}
