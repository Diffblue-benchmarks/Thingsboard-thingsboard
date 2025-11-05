package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
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
   *
   * <p>Method under test: {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDeviceTypeSwitchNode.getRelationType(TbContext, EntityId)"})
  void testGetRelationType() throws TbNodeException {
    // Arrange
    TbDeviceTypeSwitchNode tbDeviceTypeSwitchNode = new TbDeviceTypeSwitchNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbDeviceTypeSwitchNode.getRelationType(
                ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleEngineDeviceProfileCache} {@link
   *       RuleEngineDeviceProfileCache#get(TenantId, DeviceId)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test getRelationType(TbContext, EntityId); given RuleEngineDeviceProfileCache get(TenantId, DeviceId) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDeviceTypeSwitchNode.getRelationType(TbContext, EntityId)"})
  void testGetRelationType_givenRuleEngineDeviceProfileCacheGetReturnNull() throws TbNodeException {
    // Arrange
    TbDeviceTypeSwitchNode tbDeviceTypeSwitchNode = new TbDeviceTypeSwitchNode();

    RuleEngineDeviceProfileCache ruleEngineDeviceProfileCache =
        mock(RuleEngineDeviceProfileCache.class);
    when(ruleEngineDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenReturn(ruleEngineDeviceProfileCache);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbDeviceTypeSwitchNode.getRelationType(
                ctx, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleEngineDeviceProfileCache).get(isA(TenantId.class), isA(DeviceId.class));
    verify(ctx).getDeviceProfileCache();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbDeviceTypeSwitchNode.getRelationType(TbContext, EntityId)"})
  void testGetRelationType_thenReturnNull() throws TbNodeException {
    // Arrange
    TbDeviceTypeSwitchNode tbDeviceTypeSwitchNode = new TbDeviceTypeSwitchNode();

    RuleEngineDeviceProfileCache ruleEngineDeviceProfileCache =
        mock(RuleEngineDeviceProfileCache.class);
    when(ruleEngineDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceProfile());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenReturn(ruleEngineDeviceProfileCache);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    String actualRelationType =
        tbDeviceTypeSwitchNode.getRelationType(
            ctx, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ruleEngineDeviceProfileCache).get(isA(TenantId.class), isA(DeviceId.class));
    verify(ctx).getDeviceProfileCache();
    verify(ctx).getTenantId();
    assertNull(actualRelationType);
  }
}
