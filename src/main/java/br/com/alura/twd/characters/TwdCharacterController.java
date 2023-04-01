package br.com.alura.twd.characters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TwdCharacterController {

  @Autowired
  private TwdCharacterRepository repository;

  @GetMapping("/characters")
  public List<TwdCharacter> getCharacters(){
    List<TwdCharacter> characters = repository.findAll();
    return characters;
  }

  @PostMapping("/characters")
  public TwdCharacter createCharacter(@RequestBody TwdCharacter character){
     TwdCharacter savedCharacter = repository.save(character);
     return savedCharacter;
  }

  
  @GetMapping("/characters/{id}")
  public TwdCharacter getCharacterById(@PathVariable String id){
    return repository.findById(id)
    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @PutMapping("/characters/{id}")
  public TwdCharacter updateCharacter(@PathVariable String id, @RequestBody TwdCharacter character){
    if(!repository.existsById(id)){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    character.setId(id);
    return repository.save(character);
  }

  @DeleteMapping("/characters/{id}")
  public void deleteCharacter(@PathVariable String id){
    repository.deleteById(id);
  }

}
