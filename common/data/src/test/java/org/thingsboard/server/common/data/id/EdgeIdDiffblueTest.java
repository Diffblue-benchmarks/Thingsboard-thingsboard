package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EdgeIdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeId#EdgeId(UUID)}
   *   <li>{@link EdgeId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeId.<init>(UUID)", "EntityType EdgeId.getEntityType()"})
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    EdgeId actualEdgeId = new EdgeId(id);
    EntityType actualEntityType = actualEdgeId.getEntityType();

    // Assert
    UUID id2 = actualEdgeId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(EntityType.EDGE, actualEntityType);
    assertSame(id, id2);
  }

  /**
   * Test {@link EdgeId#fromUUID(UUID)}.
   * <p>
   * Method under test: {@link EdgeId#fromUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromUUID(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeId EdgeId.fromUUID(UUID)"})
  void testFromUUID() {
    // Arrange and Act
    EdgeId actualFromUUIDResult = EdgeId.fromUUID(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualFromUUIDResult.getId().toString());
    assertEquals(EntityType.EDGE, actualFromUUIDResult.getEntityType());
    assertFalse(actualFromUUIDResult.isNullUid());
  }
}
