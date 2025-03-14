package com.pb.personajes_bakend.controller;

import com.pb.personajes_bakend.dto.CharacterDto;
import com.pb.personajes_bakend.service.ICharacterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "*")
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@Valid @RequestBody CharacterDto characterDto) {
        CharacterDto savedCharacter = characterService.saveCharacter(characterDto);
        return new ResponseEntity<>(savedCharacter, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> getCharacterById(@PathVariable Long id) {
        CharacterDto characterDto = characterService.getCharacterById(id);
        return ResponseEntity.ok(characterDto);
    }

    @GetMapping
    public ResponseEntity<List<CharacterDto>> getAllCharacters(
            @RequestParam(required = false, defaultValue = "date") String sortBy) {
        List<CharacterDto> characters = characterService.getAllCharacters(sortBy);
        return ResponseEntity.ok(characters);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDto> updateCharacter(
            @PathVariable Long id,
            @Valid @RequestBody CharacterDto updatedCharacter) {
        CharacterDto characterDto = characterService.updateCharacter(id, updatedCharacter);
        return ResponseEntity.ok(characterDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.ok("Character deleted successfully");
    }
}
