package com.pb.personajes_bakend.service.impl;

import com.pb.personajes_bakend.dto.CharacterDto;
import com.pb.personajes_bakend.exception.ResourceNotFoundException;
import com.pb.personajes_bakend.mapper.CharacterMapper;
import com.pb.personajes_bakend.model.Character;
import com.pb.personajes_bakend.repository.CharacterRepository;
import com.pb.personajes_bakend.service.ICharacterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private FileStorageService fileStorageService;

    @CacheEvict(value = {"characters", "character"}, allEntries = true)
    @Override
    public CharacterDto saveCharacter(CharacterDto characterDto) {
        Character character = CharacterMapper.mapToCharacter(characterDto);
        Character savedCharacter = characterRepository.save(character);
        return CharacterMapper.mapToCharacterDto(savedCharacter);
    }

    @Cacheable(value = "character", key = "#id")
    @Override
    public CharacterDto getCharacterById(Long id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character not found with given id: " + id));
        return CharacterMapper.mapToCharacterDto(character);
    }

    @Cacheable("characters")
    @Override
    public List<CharacterDto> getAllCharacters(String sortBy) {
        List<Character> characters;
        if ("name".equals(sortBy)) {
            characters = characterRepository.findAllByOrderByNameAsc();
        } else {
            characters = characterRepository.findAllByOrderByCreatedDateDesc();
        }
        return characters.stream().map(CharacterMapper::mapToCharacterDto).toList();
    }

    @CacheEvict(value = {"characters", "character"}, allEntries = true)
    @Override
    public CharacterDto updateCharacter(Long id, CharacterDto characterDetails) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character not found with given id: " + id));
        character.setName(characterDetails.getName());
        character.setImageUrl(characterDetails.getImageUrl());
        character.setRole(characterDetails.getRole());
        character.setDescription(characterDetails.getDescription());
        Character updatedCharacter = characterRepository.save(character);
        return CharacterMapper.mapToCharacterDto(updatedCharacter);
    }

    @CacheEvict(value = {"characters", "character"}, allEntries = true)
    @Override
    public void deleteCharacter(Long id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character not found with given id: " + id));
        String imageUrl = character.getImageUrl();

        if (imageUrl != null && !imageUrl.isEmpty()) {
            String fileName = imageUrl.replace("/api/files/", "");
            fileStorageService.deleteFile(fileName);
        }
        characterRepository.deleteById(id);
    }
}
