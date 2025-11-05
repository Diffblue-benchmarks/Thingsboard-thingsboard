package org.thingsboard.server.service.component;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnnotationComponentDiscoveryServiceDiffblueTest {
  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponent(String)}.
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getComponent(String)}
   */
  @Test
  @DisplayName("Test getComponent(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional AnnotationComponentDiscoveryService.getComponent(String)"})
  void testGetComponent() {
    // Arrange, Act and Assert
    assertFalse(new AnnotationComponentDiscoveryService().getComponent("Clazz").isPresent());
  }
}
