package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.web.cors.CorsConfiguration;

class MvcCorsPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MvcCorsProperties#setMappings(Map)}
   *   <li>{@link MvcCorsProperties#getMappings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map MvcCorsProperties.getMappings()",
    "void MvcCorsProperties.setMappings(Map)"
  })
  void testGettersAndSetters() {
    // Arrange
    MvcCorsProperties mvcCorsProperties = new MvcCorsProperties();
    HashMap<String, CorsConfiguration> mappings = new HashMap<>();

    // Act
    mvcCorsProperties.setMappings(mappings);
    Map<String, CorsConfiguration> actualMappings = mvcCorsProperties.getMappings();

    // Assert
    assertTrue(actualMappings.isEmpty());
    assertSame(mappings, actualMappings);
  }
}
