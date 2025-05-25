package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class WidgetsBundleIdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleId#WidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetsBundleId.<init>(UUID)", "EntityType WidgetsBundleId.getEntityType()"})
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    WidgetsBundleId actualWidgetsBundleId = new WidgetsBundleId(id);
    EntityType actualEntityType = actualWidgetsBundleId.getEntityType();

    // Assert
    UUID id2 = actualWidgetsBundleId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualEntityType);
    assertSame(id, id2);
  }
}
