package sh.platform.examples.deployfriday;

import jakarta.nosql.document.DocumentCollectionManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
class DocumentManager {


    @Inject
    @ConfigProperty(name = "document")
    private DocumentCollectionManager manager;

    @Produces
    @ApplicationScoped
    public DocumentCollectionManager getManager() {
        return manager;
    }


    void close(@Disposes DocumentCollectionManager close) {
        close.close();
    }
}
