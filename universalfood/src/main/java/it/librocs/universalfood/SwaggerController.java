package it.librocs.universalfood;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

/************************************************************************************************
 * Questa classe è del tutto inutile.
 *
 * Sta qui per nascondere alcuni campi dell'interfaccia Swagger-UI che pottrrebbero
 * generare confusione agli studenti.
 *
 * ATTENZIONE: recupera un css ma il path diopende dalla versione di swagger-ui usata
 * per trovare la versione che usi: "mvn dependency:tree | grep swagger-ui"
 ***********************************************************************************************/
@RestController
@RequestMapping(path="/swagger-ui")
@Hidden // non voglio che swagger mostri gli endpoint di questa classe
public class SwaggerController {

    @GetMapping(path="/swagger-ui.css", produces = "text/css")
    public String getCss() {
        String orig = toText(getClass().getResourceAsStream(
            "/META-INF/resources/webjars/swagger-ui/5.20.1/swagger-ui.css"));
        String custom = """
                .scheme-container {display:none}
                .info__contact {display:none}
                .topbar {display:none}
                hgroup a.link {display:none}
                .response-col_links {display:none}
                .swagger-ui textarea { min-height: 8rem }
                        """;
        return orig + custom;
    }

    static String toText(InputStream in) {
        return new BufferedReader( new InputStreamReader(in, StandardCharsets.UTF_8))
            .lines().collect(Collectors.joining("\n"));
    }
}