package org.thingsboard.server.service.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.DeviceIdInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.common.data.query.TsValue;

@ExtendWith(MockitoExtension.class)
class DefaultDeviceStateServiceDiffblueTest {
  @InjectMocks
  private DefaultDeviceStateService defaultDeviceStateService;

  /**
   * Test {@link DefaultDeviceStateService#isActive(long, DeviceState)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link DeviceState#getInactivityTimeout()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceStateService#isActive(long, DeviceState)}
   */
  @Test
  @DisplayName("Test isActive(long, DeviceState); given one; then calls getInactivityTimeout()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceStateService.isActive(long, DeviceState)"})
  void testIsActive_givenOne_thenCallsGetInactivityTimeout() {
    // Arrange
    DeviceState state = mock(DeviceState.class);
    when(state.getInactivityTimeout()).thenReturn(1L);
    when(state.getLastActivityTime()).thenReturn(1L);

    // Act
    boolean actualIsActiveResult = defaultDeviceStateService.isActive(1L, state);

    // Assert
    verify(state).getInactivityTimeout();
    verify(state).getLastActivityTime();
    assertTrue(actualIsActiveResult);
  }

  /**
   * Test {@link DefaultDeviceStateService#isActive(long, DeviceState)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceStateService#isActive(long, DeviceState)}
   */
  @Test
  @DisplayName("Test isActive(long, DeviceState); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceStateService.isActive(long, DeviceState)"})
  void testIsActive_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultDeviceStateService.isActive(1L, new DeviceState(true, 1L, 1L, 1L, 1L, 1L)));
  }

  /**
   * Test {@link DefaultDeviceStateService#isActive(long, DeviceState)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceStateService#isActive(long, DeviceState)}
   */
  @Test
  @DisplayName("Test isActive(long, DeviceState); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceStateService.isActive(long, DeviceState)"})
  void testIsActive_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultDeviceStateService.isActive(2L, new DeviceState(true, 1L, 1L, 1L, 1L, 1L)));
  }

  /**
   * Test {@link DefaultDeviceStateService#toDeviceStateData(EntityData, DeviceIdInfo)}.
   * <p>
   * Method under test: {@link DefaultDeviceStateService#toDeviceStateData(EntityData, DeviceIdInfo)}
   */
  @Test
  @DisplayName("Test toDeviceStateData(EntityData, DeviceIdInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceStateData DefaultDeviceStateService.toDeviceStateData(EntityData, DeviceIdInfo)"})
  void testToDeviceStateData() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData ed = new EntityData(null, latest, new HashMap<>());

    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceStateData actualToDeviceStateDataResult = defaultDeviceStateService.toDeviceStateData(ed,
        new DeviceIdInfo(tenantId, customerId, deviceId));

    // Assert
    DeviceState state = actualToDeviceStateDataResult.getState();
    assertEquals(0L, state.getInactivityTimeout());
    assertEquals(0L, state.getLastActivityTime());
    assertEquals(0L, state.getLastConnectTime());
    assertEquals(0L, state.getLastDisconnectTime());
    assertEquals(0L, state.getLastInactivityAlarmTime());
    assertEquals(0L, actualToDeviceStateDataResult.getDeviceCreationTime());
    Map<String, String> data = actualToDeviceStateDataResult.getMetaData().getData();
    assertEquals(3, data.size());
    CustomerId customerId2 = actualToDeviceStateDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId deviceId2 = actualToDeviceStateDataResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    TenantId tenantId2 = actualToDeviceStateDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertFalse(deviceId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertFalse(state.isActive());
    assertTrue(data.containsKey("deviceLabel"));
    assertTrue(data.containsKey("deviceName"));
    assertTrue(data.containsKey("deviceType"));
    assertSame(customerId, customerId2.getId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DefaultDeviceStateService#toDeviceStateData(EntityData, DeviceIdInfo)}.
   * <p>
   * Method under test: {@link DefaultDeviceStateService#toDeviceStateData(EntityData, DeviceIdInfo)}
   */
  @Test
  @DisplayName("Test toDeviceStateData(EntityData, DeviceIdInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceStateData DefaultDeviceStateService.toDeviceStateData(EntityData, DeviceIdInfo)"})
  void testToDeviceStateData2() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    EntityData ed = new EntityData(entityId, latest, new HashMap<>());

    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceStateData actualToDeviceStateDataResult = defaultDeviceStateService.toDeviceStateData(ed,
        new DeviceIdInfo(tenantId, customerId, deviceId));

    // Assert
    DeviceState state = actualToDeviceStateDataResult.getState();
    assertEquals(0L, state.getInactivityTimeout());
    assertEquals(0L, state.getLastActivityTime());
    assertEquals(0L, state.getLastConnectTime());
    assertEquals(0L, state.getLastDisconnectTime());
    assertEquals(0L, state.getLastInactivityAlarmTime());
    assertEquals(0L, actualToDeviceStateDataResult.getDeviceCreationTime());
    Map<String, String> data = actualToDeviceStateDataResult.getMetaData().getData();
    assertEquals(3, data.size());
    CustomerId customerId2 = actualToDeviceStateDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId deviceId2 = actualToDeviceStateDataResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    TenantId tenantId2 = actualToDeviceStateDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertFalse(deviceId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertFalse(state.isActive());
    assertTrue(data.containsKey("deviceLabel"));
    assertTrue(data.containsKey("deviceName"));
    assertTrue(data.containsKey("deviceType"));
    assertSame(customerId, customerId2.getId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DefaultDeviceStateService#toDeviceStateData(EntityData, DeviceIdInfo)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceStateService#toDeviceStateData(EntityData, DeviceIdInfo)}
   */
  @Test
  @DisplayName("Test toDeviceStateData(EntityData, DeviceIdInfo); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceStateData DefaultDeviceStateService.toDeviceStateData(EntityData, DeviceIdInfo)"})
  void testToDeviceStateData_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    EntityData ed = mock(EntityData.class);
    when(ed.getLatest()).thenThrow(new RuntimeException("foo"));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultDeviceStateService.toDeviceStateData(ed,
        new DeviceIdInfo(tenantId, customerId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ed).getLatest();
  }

  /**
   * Test {@link DefaultDeviceStateService#toDeviceStateData(EntityData, DeviceIdInfo)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return State InactivityTimeout is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceStateService#toDeviceStateData(EntityData, DeviceIdInfo)}
   */
  @Test
  @DisplayName("Test toDeviceStateData(EntityData, DeviceIdInfo); when 'null'; then return State InactivityTimeout is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceStateData DefaultDeviceStateService.toDeviceStateData(EntityData, DeviceIdInfo)"})
  void testToDeviceStateData_whenNull_thenReturnStateInactivityTimeoutIsZero() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceStateData actualToDeviceStateDataResult = defaultDeviceStateService.toDeviceStateData(null,
        new DeviceIdInfo(tenantId, customerId, deviceId));

    // Assert
    DeviceState state = actualToDeviceStateDataResult.getState();
    assertEquals(0L, state.getInactivityTimeout());
    assertEquals(0L, state.getLastActivityTime());
    assertEquals(0L, state.getLastConnectTime());
    assertEquals(0L, state.getLastDisconnectTime());
    assertEquals(0L, state.getLastInactivityAlarmTime());
    assertEquals(0L, actualToDeviceStateDataResult.getDeviceCreationTime());
    Map<String, String> data = actualToDeviceStateDataResult.getMetaData().getData();
    assertEquals(3, data.size());
    CustomerId customerId2 = actualToDeviceStateDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId deviceId2 = actualToDeviceStateDataResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    TenantId tenantId2 = actualToDeviceStateDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertFalse(deviceId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertFalse(state.isActive());
    assertTrue(data.containsKey("deviceLabel"));
    assertTrue(data.containsKey("deviceName"));
    assertTrue(data.containsKey("deviceType"));
    assertSame(customerId, customerId2.getId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(tenantId, tenantId2.getId());
  }
}
