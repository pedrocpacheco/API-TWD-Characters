package br.com.alura.twd.characters;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TwdCharacterRepository extends MongoRepository<TwdCharacter, String>{
  
}
