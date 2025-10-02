package it.librocs.universalfood.managers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.librocs.universalfood.oggetti.Menu;
import it.librocs.universalfood.oggetti.Piatto;
import it.librocs.universalfood.repository.MenuRepository;
import it.librocs.universalfood.repository.PiattoRepository;

@Tag(name = "endpoint per la gestione dei piatti")
@RestController
@CrossOrigin
@RequestMapping(path="/universalfood")
public class MenuManager {
    @Autowired
    MenuRepository repoMenu;

    @Operation(summary = "Elenco di tutti i menu disponibili")
    @GetMapping("/menu")
    public List<Menu> menu() {
        List<Menu> k = repoMenu.findAll();
        // tolgo alcune informazioni dai panini in modo che il servizio
        // per id risulti utile
        for(Menu menu : k){
            menu.setDescrizione(null);
            // volontariamente non metto i piatti
            menu.setPiatti(null);
        }
        return k;
    }

    @Operation(summary = "Informazioni su uno specifico menù")
    @ApiResponses({
    @ApiResponse(responseCode = "200",
        content = @Content),
    @ApiResponse(responseCode = "404", description = "Il Menu richiesto non esiste",
        content = @Content)
    })
    @GetMapping("/menu/{id}")
    public Optional<Menu> prendiPerChiave( @PathVariable int id ) {
        Optional<Menu> c = repoMenu.findById(id);
        if(c.isPresent()){
            return c;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
