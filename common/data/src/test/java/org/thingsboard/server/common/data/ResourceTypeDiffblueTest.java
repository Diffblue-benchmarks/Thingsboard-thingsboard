package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceType#getMediaType()}
   *   <li>{@link ResourceType#isCustomerAccess()}
   *   <li>{@link ResourceType#isUpdatable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceType.getMediaType()",
    "boolean ResourceType.isCustomerAccess()",
    "boolean ResourceType.isUpdatable()"
  })
  void testGettersAndSetters() {
    // Arrange
    ResourceType valueOfResult = ResourceType.valueOf("LWM2M_MODEL");

    // Act
    String actualMediaType = valueOfResult.getMediaType();
    boolean actualIsCustomerAccessResult = valueOfResult.isCustomerAccess();

    // Assert
    assertEquals("application/xml", actualMediaType);
    assertFalse(actualIsCustomerAccessResult);
    assertFalse(valueOfResult.isUpdatable());
  }
}
