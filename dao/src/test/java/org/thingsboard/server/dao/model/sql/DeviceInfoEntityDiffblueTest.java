package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeviceInfoEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceInfoEntity}
   *   <li>{@link DeviceInfoEntity#setActive(boolean)}
   *   <li>{@link DeviceInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link DeviceInfoEntity#setCustomerTitle(String)}
   *   <li>{@link DeviceInfoEntity#setDeviceProfileName(String)}
   *   <li>{@link DeviceInfoEntity#toString()}
   *   <li>{@link DeviceInfoEntity#getCustomerTitle()}
   *   <li>{@link DeviceInfoEntity#getDeviceProfileName()}
   *   <li>{@link DeviceInfoEntity#isActive()}
   *   <li>{@link DeviceInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceInfoEntity.<init>()", "String DeviceInfoEntity.getCustomerTitle()",
      "String DeviceInfoEntity.getDeviceProfileName()", "boolean DeviceInfoEntity.isActive()",
      "boolean DeviceInfoEntity.isCustomerIsPublic()", "void DeviceInfoEntity.setActive(boolean)",
      "void DeviceInfoEntity.setCustomerIsPublic(boolean)", "void DeviceInfoEntity.setCustomerTitle(String)",
      "void DeviceInfoEntity.setDeviceProfileName(String)", "String DeviceInfoEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceInfoEntity actualDeviceInfoEntity = new DeviceInfoEntity();
    actualDeviceInfoEntity.setActive(true);
    actualDeviceInfoEntity.setCustomerIsPublic(true);
    actualDeviceInfoEntity.setCustomerTitle("Dr");
    actualDeviceInfoEntity.setDeviceProfileName("foo.txt");
    String actualToStringResult = actualDeviceInfoEntity.toString();
    String actualCustomerTitle = actualDeviceInfoEntity.getCustomerTitle();
    String actualDeviceProfileName = actualDeviceInfoEntity.getDeviceProfileName();
    boolean actualIsActiveResult = actualDeviceInfoEntity.isActive();
    boolean actualIsCustomerIsPublicResult = actualDeviceInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals("DeviceInfoEntity(customerTitle=Dr, customerIsPublic=true, deviceProfileName=foo.txt, active=true)",
        actualToStringResult);
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("foo.txt", actualDeviceProfileName);
    assertNull(actualDeviceInfoEntity.getAdditionalInfo());
    assertNull(actualDeviceInfoEntity.getDeviceData());
    assertNull(actualDeviceInfoEntity.getVersion());
    assertNull(actualDeviceInfoEntity.getLabel());
    assertNull(actualDeviceInfoEntity.getName());
    assertNull(actualDeviceInfoEntity.getType());
    assertNull(actualDeviceInfoEntity.getId());
    assertNull(actualDeviceInfoEntity.getUuid());
    assertNull(actualDeviceInfoEntity.getCustomerId());
    assertNull(actualDeviceInfoEntity.getDeviceProfileId());
    assertNull(actualDeviceInfoEntity.getExternalId());
    assertNull(actualDeviceInfoEntity.getFirmwareId());
    assertNull(actualDeviceInfoEntity.getSoftwareId());
    assertNull(actualDeviceInfoEntity.getTenantId());
    assertEquals(0L, actualDeviceInfoEntity.getCreatedTime());
    assertTrue(actualIsActiveResult);
    assertTrue(actualIsCustomerIsPublicResult);
  }
}
