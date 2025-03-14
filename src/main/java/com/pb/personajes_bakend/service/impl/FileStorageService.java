package com.pb.personajes_bakend.service.impl;

import com.pb.personajes_bakend.service.IFileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FileStorageService implements IFileStorageService {
    @Value("${file.upload-dir:uploads/images}")
    private String uploadDir;

    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;

    private static final List<String> ALLOWED_TYPES = Arrays.asList("image/png", "image/jpeg", "image/jpg", "image/gif");

    @Override
    public String storeFile(MultipartFile file) throws IOException {
        validateFile(file);

        // Crear directorio si no existe
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(uploadPath);

        // Generar nombre único para evitar colisiones
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path targetLocation = uploadPath.resolve(fileName);

        // Guardar archivo en el directorio
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    @Override
    public void deleteFile(String fileName) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
            Path targetLocation = filePath.toAbsolutePath();
            Files.deleteIfExists(targetLocation);
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar el archivo: " + fileName, e);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío.");
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("El archivo es demasiado grande. Tamaño máximo: 5MB.");
        }
        if (!ALLOWED_TYPES.contains(file.getContentType())) {
            throw new IllegalArgumentException("Formato no permitido. Solo se aceptan PNG, JPG, JPEG y GIF.");
        }
    }
}
