package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeviceEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceEntity#DeviceEntity()}
   *   <li>{@link DeviceEntity#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceEntity.<init>()", "java.lang.String DeviceEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceEntity actualDeviceEntity = new DeviceEntity();

    // Assert
    assertEquals("DeviceEntity()", actualDeviceEntity.toString());
    assertNull(actualDeviceEntity.getAdditionalInfo());
    assertNull(actualDeviceEntity.getDeviceData());
    assertNull(actualDeviceEntity.getVersion());
    assertNull(actualDeviceEntity.getLabel());
    assertNull(actualDeviceEntity.getName());
    assertNull(actualDeviceEntity.getType());
    assertNull(actualDeviceEntity.getId());
    assertNull(actualDeviceEntity.getUuid());
    assertNull(actualDeviceEntity.getCustomerId());
    assertNull(actualDeviceEntity.getDeviceProfileId());
    assertNull(actualDeviceEntity.getExternalId());
    assertNull(actualDeviceEntity.getFirmwareId());
    assertNull(actualDeviceEntity.getSoftwareId());
    assertNull(actualDeviceEntity.getTenantId());
    assertEquals(0L, actualDeviceEntity.getCreatedTime());
  }
}
