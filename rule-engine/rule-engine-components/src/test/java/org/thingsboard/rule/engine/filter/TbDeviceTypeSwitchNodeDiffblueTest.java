package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.RuleEngineDeviceProfileCache;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class TbDeviceTypeSwitchNodeDiffblueTest {
  /**
   * Test {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   * <ul>
   *   <li>Given {@link RuleEngineDeviceProfileCache}
   * {@link RuleEngineDeviceProfileCache#get(TenantId, DeviceId)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId); given RuleEngineDeviceProfileCache get(TenantId, DeviceId) return 'null'")
  void testGetRelationType_givenRuleEngineDeviceProfileCacheGetReturnNull() throws TbNodeException {
    // Arrange
    TbDeviceTypeSwitchNode tbDeviceTypeSwitchNode = new TbDeviceTypeSwitchNode();
    RuleEngineDeviceProfileCache ruleEngineDeviceProfileCache = mock(RuleEngineDeviceProfileCache.class);
    when(ruleEngineDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(null);
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenReturn(ruleEngineDeviceProfileCache);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(TbNodeException.class,
        () -> tbDeviceTypeSwitchNode.getRelationType(ctx, new DeviceId(UUID.randomUUID())));
    verify(ruleEngineDeviceProfileCache).get(isA(TenantId.class), isA(DeviceId.class));
    verify(ctx).getDeviceProfileCache();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId); then return 'null'")
  void testGetRelationType_thenReturnNull() throws TbNodeException {
    // Arrange
    TbDeviceTypeSwitchNode tbDeviceTypeSwitchNode = new TbDeviceTypeSwitchNode();
    RuleEngineDeviceProfileCache ruleEngineDeviceProfileCache = mock(RuleEngineDeviceProfileCache.class);
    when(ruleEngineDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceProfile());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenReturn(ruleEngineDeviceProfileCache);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    String actualRelationType = tbDeviceTypeSwitchNode.getRelationType(ctx, new DeviceId(UUID.randomUUID()));

    // Assert
    verify(ruleEngineDeviceProfileCache).get(isA(TenantId.class), isA(DeviceId.class));
    verify(ctx).getDeviceProfileCache();
    verify(ctx).getTenantId();
    assertNull(actualRelationType);
  }

  /**
   * Test {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId); when AlarmId(UUID) with id is randomUUID; then throw TbNodeException")
  void testGetRelationType_whenAlarmIdWithIdIsRandomUUID_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbDeviceTypeSwitchNode tbDeviceTypeSwitchNode = new TbDeviceTypeSwitchNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertThrows(TbNodeException.class,
        () -> tbDeviceTypeSwitchNode.getRelationType(ctx, new AlarmId(UUID.randomUUID())));
  }
}
