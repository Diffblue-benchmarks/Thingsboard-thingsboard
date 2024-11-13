package org.thingsboard.server.service.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbMsgMetaData;

class DeviceStateDataDiffblueTest {
  /**
   * Test
   * {@link DeviceStateData#DeviceStateData(TenantId, CustomerId, DeviceId, long, TbMsgMetaData, DeviceState)}.
   * <ul>
   *   <li>When {@link DeviceId}.</li>
   *   <li>Then return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceStateData#DeviceStateData(TenantId, CustomerId, DeviceId, long, TbMsgMetaData, DeviceState)}
   */
  @Test
  @DisplayName("Test new DeviceStateData(TenantId, CustomerId, DeviceId, long, TbMsgMetaData, DeviceState); when DeviceId; then return DeviceId")
  void testNewDeviceStateData_whenDeviceId_thenReturnDeviceId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    DeviceId deviceId = mock(DeviceId.class);
    TbMsgMetaData metaData = new TbMsgMetaData();
    DeviceState state = new DeviceState(true, 1L, 1L, 1L, 1L, 1L);

    // Act
    DeviceStateData actualDeviceStateData = new DeviceStateData(tenantId, customerId, deviceId, 1L, metaData, state);

    // Assert
    assertEquals(1L, actualDeviceStateData.getDeviceCreationTime());
    TbMsgMetaData metaData2 = actualDeviceStateData.getMetaData();
    assertTrue(metaData2.getData().isEmpty());
    assertSame(customerId, actualDeviceStateData.getCustomerId());
    assertSame(tenantId, actualDeviceStateData.getTenantId());
    assertSame(metaData, metaData2);
    assertSame(state, actualDeviceStateData.getState());
    assertSame(deviceId, actualDeviceStateData.getDeviceId());
  }

  /**
   * Test
   * {@link DeviceStateData#DeviceStateData(TenantId, CustomerId, DeviceId, long, TbMsgMetaData, DeviceState)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return DeviceId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceStateData#DeviceStateData(TenantId, CustomerId, DeviceId, long, TbMsgMetaData, DeviceState)}
   */
  @Test
  @DisplayName("Test new DeviceStateData(TenantId, CustomerId, DeviceId, long, TbMsgMetaData, DeviceState); when 'null'; then return DeviceId is 'null'")
  void testNewDeviceStateData_whenNull_thenReturnDeviceIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsgMetaData metaData = new TbMsgMetaData();
    DeviceState state = new DeviceState(true, 1L, 1L, 1L, 1L, 1L);

    // Act
    DeviceStateData actualDeviceStateData = new DeviceStateData(tenantId, customerId, null, 1L, metaData, state);

    // Assert
    assertNull(actualDeviceStateData.getDeviceId());
    assertEquals(1L, actualDeviceStateData.getDeviceCreationTime());
    TbMsgMetaData metaData2 = actualDeviceStateData.getMetaData();
    assertTrue(metaData2.getData().isEmpty());
    assertSame(customerId, actualDeviceStateData.getCustomerId());
    assertSame(tenantId, actualDeviceStateData.getTenantId());
    assertSame(metaData, metaData2);
    assertSame(state, actualDeviceStateData.getState());
  }
}
