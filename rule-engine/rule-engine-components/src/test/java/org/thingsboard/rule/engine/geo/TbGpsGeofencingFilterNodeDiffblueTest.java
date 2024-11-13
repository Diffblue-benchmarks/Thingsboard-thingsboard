package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbGpsGeofencingFilterNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGpsGeofencingFilterNode}
   *   <li>{@link TbGpsGeofencingFilterNode#getConfigClazz()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    Class<TbGpsGeofencingFilterNodeConfiguration> actualConfigClazz = (new TbGpsGeofencingFilterNode())
        .getConfigClazz();

    // Assert
    Class<TbGpsGeofencingFilterNodeConfiguration> expectedConfigClazz = TbGpsGeofencingFilterNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }
}
