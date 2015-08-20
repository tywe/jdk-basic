package org.teng.jdk.simple.id;

import java.util.UUID;

/**
 * Contract for generating {@link UUID} identifiers.
 *
 * @author Rossen Stoyanchev
 * @since 4.0
 */
public interface IdGenerator {

    /**
     * Generate a new identifier.
     * @return the generated identifier
     */
    UUID generateId();

}
