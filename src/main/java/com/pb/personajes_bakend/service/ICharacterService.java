package com.pb.personajes_bakend.service;

import com.pb.personajes_bakend.dto.CharacterDto;

import java.util.List;

public interface ICharacterService {
    CharacterDto saveCharacter(CharacterDto characterDto);

    CharacterDto getCharacterById(Long id);

    List<CharacterDto> getAllCharacters(String sortBy);

    CharacterDto updateCharacter(Long id, CharacterDto characterDetails);

    void deleteCharacter(Long id);
}
