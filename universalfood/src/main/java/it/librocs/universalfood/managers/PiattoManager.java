package it.librocs.universalfood.managers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import it.librocs.universalfood.oggetti.Piatto;
import it.librocs.universalfood.repository.PiattoRepository;

@Tag(name = "endpoint per la gestione dei piatti")
@RestController
@CrossOrigin
@RequestMapping(path="/universalfood")
public class PiattoManager {
    @Autowired
    PiattoRepository repoPiatti;

    @Operation(summary = "Ricerca dei piatti")
    @GetMapping("/piatto")
    public List<Piatto> elencoPanini(
        @Parameter(description = "Nome (per intero) del piatto cercato")
        @RequestParam(required = false) String nome
    ) {
        Piatto p = new Piatto();
        p.setNome(nome);
        Example<Piatto> example = Example.of(p);
        List<Piatto> k = repoPiatti.findAll(example);
        // tolgo alcune informazioni dai panini in modo che il servizio
        // per id risulti utile
        for(Piatto piatto : k){
            piatto.setDescrizione(null);
        }
        return k;
    }

    @Operation(summary = "Informazioni su uno specifico piatto")
    @ApiResponses({
    @ApiResponse(responseCode = "200",
        content = @Content),
    @ApiResponse(responseCode = "404", description = "Il Piatto richiesto non esiste",
        content = @Content)
    })
    @GetMapping("/piatto/{id}")
    public Optional<Piatto> prendiPerChiave( @PathVariable int id ) {
        Optional<Piatto> c = repoPiatti.findById(id);
        if(c.isPresent()){
            return c;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Inserisce un Piatto", description = """
        Inserisce un Piatto nel database.
        Nel body devono essere presenti i dati di un Piatto (JSON) (compreso il menu con il solo id)""")
    @ApiResponses({
        @ApiResponse(responseCode = "200",
            content = @Content),
        @ApiResponse(responseCode = "422", description = "mancano dati minimi (nome e prezzo) per registare il Piatto",
            content = @Content)
    })
    @PostMapping("/piatto")
    public void inserisci(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Piatto da aggiungere.", required = true,
            content = @Content(
                schema=@Schema(implementation = Piatto.class),
                examples = @ExampleObject(value = """
                {
                    "nome": "nomePiatto",
                    "costo": 10,
                    "descrizione": "descrizionePiatto",
                    "disponibile": true
                }
                """)
            )
        )
        @RequestBody Piatto p
    ) {
        if(p.getNome()==null || p.getCosto()==null){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            repoPiatti.save( p );
        }
    }

    @Operation(summary = "Modifica uno specifico piatto")
    @PutMapping("/piatto/{id}")
    @ApiResponses({
        @ApiResponse(responseCode = "200",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Il Piatto richiesto non esiste",
            content = @Content)
    })
    public ResponseEntity<Piatto> aggiornaPiatto(
            @PathVariable Integer id,
            @RequestBody Piatto nuovoPiatto) {
        Optional<Piatto> piattoEsistente = repoPiatti.findById(id);

        if (piattoEsistente.isPresent()) {
            Piatto piatto = piattoEsistente.get();
            piatto.setNome(nuovoPiatto.getNome());
            piatto.setCosto(nuovoPiatto.getCosto());
            piatto.setDescrizione(nuovoPiatto.getDescrizione());
            piatto.setDisponibile(nuovoPiatto.getDisponibile());
            Piatto aggiornata = repoPiatti.save(piatto);
            return ResponseEntity.ok(aggiornata);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Rimuove un piatto")
    @ApiResponses({
        @ApiResponse(responseCode = "200",
            content = @Content)
    })
    @DeleteMapping("/piatto/{id}")
    public void cancellaPerChiave( @PathVariable int id ) {
        try {
            repoPiatti.deleteById(id);
        }catch(DataIntegrityViolationException x){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
