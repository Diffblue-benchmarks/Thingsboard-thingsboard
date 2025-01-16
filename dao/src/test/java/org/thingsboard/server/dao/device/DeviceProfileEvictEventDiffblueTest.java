package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceProfileEvictEventDiffblueTest {
  /**
   * Test {@link DeviceProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceProfileEvictEvent deviceProfileEvictEvent = new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT,
        "New Name", "Old Name", mock(DeviceProfileId.class), true, "Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfileEvictEvent, new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "Old Name", null, true, "Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name",
        mock(DeviceProfileId.class), true, "Provision Device Key"), "42");
  }

  /**
   * Test {@link DeviceProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfileEvictEvent deviceProfileEvictEvent = new DeviceProfileEvictEvent(null, "New Name", "Old Name",
        mock(DeviceProfileId.class), true, "Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfileEvictEvent, new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "Old Name", null, true, "Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfileEvictEvent deviceProfileEvictEvent = new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT,
        "org.thingsboard.server.dao.device.DeviceProfileEvictEvent", "Old Name", mock(DeviceProfileId.class), true,
        "Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfileEvictEvent, new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "Old Name", null, true, "Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfileEvictEvent deviceProfileEvictEvent = new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT,
        "New Name", "org.thingsboard.server.dao.device.DeviceProfileEvictEvent", mock(DeviceProfileId.class), true,
        "Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfileEvictEvent, new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "Old Name", null, true, "Provision Device Key"));
  }

  /**
   * Test {@link DeviceProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfileEvictEvent deviceProfileEvictEvent = new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT,
        "New Name", "Old Name", mock(DeviceProfileId.class), false, "Provision Device Key");

    // Act and Assert
    assertNotEquals(deviceProfileEvictEvent, new DeviceProfileEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name",
        "Old Name", null, true, "Provision Device Key"));
  }
}
