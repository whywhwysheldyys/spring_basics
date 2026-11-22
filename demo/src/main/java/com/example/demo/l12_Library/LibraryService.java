package com.example.demo.l12_Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<LibraryDTO> getAllBooks() {
        List<LibraryEntity> entities = libraryRepository.findAll();
        return entities.stream()
                .map(LibraryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public LibraryDTO addBook(LibraryDTO libraryDTO) {
        LibraryEntity entity = LibraryMapper.toEntity(libraryDTO);
        LibraryEntity savedEntity = libraryRepository.save(entity);
        return LibraryMapper.toDto(savedEntity);
    }
}
