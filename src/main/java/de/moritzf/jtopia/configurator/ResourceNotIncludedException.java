package de.moritzf.jtopia.configurator;

/**
 * The type Resource not included exception.
 */
public class ResourceNotIncludedException extends RuntimeException {
    /**
     * Instantiates a new Resource not included exception.
     *
     * @param model the model
     */
    public ResourceNotIncludedException(String model){
        super("The configuration could not be set to " + model + " because the resource is not included in jtopia. \n" +
                "For your own resources use Configuration directly instead of Configurator.");
    }
}
