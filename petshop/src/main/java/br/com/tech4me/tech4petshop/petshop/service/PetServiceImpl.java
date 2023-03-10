package br.com.tech4me.tech4petshop.petshop.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.tech4petshop.petshop.model.Pet;
import br.com.tech4me.tech4petshop.petshop.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
       private PetRepository repositorio;

       @Override
       public List<Pet> obterTodosOsPet(){
           return repositorio.findAll();
       }

    @Override
    public Optional<Pet> obterPetPorId(String id) {
        
        return repositorio.findById(id);
    }

    @Override
    public void excluirPetPorId(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Pet cadastrarPet(Pet pet) {
        
        return repositorio.save(pet);
    }

    @Override
    public Optional<Pet> atualizarPetPorId(String id, Pet pet) {
        
        Optional<Pet> retorno = repositorio.findById(id);

    if (retorno.isPresent()) {
      pet.setId(id);
      return Optional.of(repositorio.save(pet));
    } else {
      return Optional.empty();
    }
    }

   

 

}
