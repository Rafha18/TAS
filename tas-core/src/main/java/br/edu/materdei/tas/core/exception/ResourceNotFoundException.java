package br.edu.materdei.tas.core.exception;

/**
 *
 * @author Rafael Quadra
 */
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(Integer resourceId) {
        super(resourceId != null ? resourceId.toString(): null);
    }
    
    
    
}
