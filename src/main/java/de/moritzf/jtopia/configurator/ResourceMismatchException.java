package de.moritzf.jtopia.configurator;

/**
 * The type Resource mismatch exception.
 */
public class ResourceMismatchException extends RuntimeException {
    /**
     * Instantiates a new Resource mismatch exception.
     *
     * @param config the config
     */
    public ResourceMismatchException(String config) {
        super("The configuration " + config + " is not suited for the context you are trying to use it in. \n" +
                "You can use Configurator.STANFORD*, Configurator.DEFAULT* or Configurator.OPENNLP* as tagging-models" +
                " while you have to use Configurator.STOPWORD* for stopwords." );
    }
}
