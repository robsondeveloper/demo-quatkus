package quarkus.pagination;

import org.jboss.logging.Logger;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("games")
public class GameResource {

    private static final Logger LOG = Logger.getLogger(GameResource.class);

    private final List<Game> games = Arrays.asList(
            new Game("Demon’s Souls", 349.90),
            new Game("Spider-Man: Miles Morales", 249.50),
            new Game("Ratchet & Clank: Em Uma Outra Dimensão", 349.90),
            new Game("Sackboy: A Big Adventure", 206.00),
            new Game("Ghost of Tsushima Versão do Diretor", 199.90),
            new Game("Nioh Collection", 165.00));

    @GET
    public Response all(@Valid @BeanParam PageRequest pageRequest) {
        LOG.info("pagination...");
        var page = new Page<Game>();
        page.setPage(pageRequest.getIndex());
        page.setSize(pageRequest.getSize());

        var totalPages = games.size() / page.getSize();
        if (games.size() % page.getSize() > 0)
            totalPages++;
        page.setTotalPages(totalPages);

        int startOfPage = pageRequest.getIndex() * pageRequest.getSize();
        if (startOfPage > games.size()) {
            page.setContent(new ArrayList<>());
            page.setTotalElements(0);
            return Response.ok(page).build();
        }
        int endOfPage = Math.min(startOfPage + pageRequest.getSize(), games.size());
        page.setContent(games.subList(startOfPage, endOfPage));
        page.setTotalElements(games.size());
        return Response.ok(page).build();
    }

}
