package com.example.demo.l12_Library;

public class LibraryMapper {

    public static LibraryDTO toDto(LibraryEntity entity) {
        if (entity == null)  return null;

        LibraryDTO dto = new LibraryDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAuthor(entity.getAuthor());
        dto.setGenre(entity.getGenre());
        dto.setStatus(entity.isStatus());
        dto.setPages(entity.getPages());
        return dto;
    }

    public static LibraryEntity toEntity(LibraryDTO dto) {
        if (dto == null) return null;

        LibraryEntity entity = new LibraryEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setGenre(dto.getGenre());
        entity.setStatus(dto.isStatus());
        entity.setPages(dto.getPages());
        return entity;
    }
}
