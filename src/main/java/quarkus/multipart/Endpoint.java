package quarkus.multipart;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.MultipartForm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("multipart")
public class Endpoint {
    private static final Logger LOG = Logger.getLogger(Endpoint.class);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("form")
    public String form(@MultipartForm FormData formData) {
        LOG.info(formData.description);
        LOG.info(formData.file.size());
        LOG.info(formData.file.contentType());
        LOG.info(formData.file.fileName());
        LOG.info(formData.file.uploadedFile());
        return "something";
    }

}
