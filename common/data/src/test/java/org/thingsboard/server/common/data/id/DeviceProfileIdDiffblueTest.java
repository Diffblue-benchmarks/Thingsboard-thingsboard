package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class DeviceProfileIdDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileId#DeviceProfileId(UUID)}
   *   <li>{@link DeviceProfileId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileId.<init>(UUID)",
    "EntityType DeviceProfileId.getEntityType()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceProfileId actualDeviceProfileId = new DeviceProfileId(id);
    EntityType actualEntityType = actualDeviceProfileId.getEntityType();

    // Assert
    UUID id2 = actualDeviceProfileId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualEntityType);
    assertSame(id, id2);
  }
}
