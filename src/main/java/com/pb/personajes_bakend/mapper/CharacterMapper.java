package com.pb.personajes_bakend.mapper;

import com.pb.personajes_bakend.dto.CharacterDto;
import com.pb.personajes_bakend.model.Character;

public class CharacterMapper {

    public static CharacterDto mapToCharacterDto(Character character) {
        return new CharacterDto(
                character.getId(),
                character.getName(),
                character.getImageUrl(),
                character.getRole(),
                character.getDescription(),
                character.getCreatedDate()
        );
    }

    public static Character mapToCharacter(CharacterDto characterDto) {
        return new Character(
                characterDto.getId(),
                characterDto.getName(),
                characterDto.getImageUrl(),
                characterDto.getRole(),
                characterDto.getDescription(),
                characterDto.getCreatedDate()
        );
    }
}
