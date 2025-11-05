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
import org.thingsboard.rule.engine.api.RuleEngineAssetProfileCache;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class TbAssetTypeSwitchNodeDiffblueTest {
  /**
   * Test {@link TbAssetTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   *
   * <p>Method under test: {@link TbAssetTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAssetTypeSwitchNode.getRelationType(TbContext, EntityId)"})
  void testGetRelationType() throws TbNodeException {
    // Arrange
    TbAssetTypeSwitchNode tbAssetTypeSwitchNode = new TbAssetTypeSwitchNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbAssetTypeSwitchNode.getRelationType(
                ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link TbAssetTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleEngineAssetProfileCache} {@link
   *       RuleEngineAssetProfileCache#get(TenantId, AssetId)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAssetTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test getRelationType(TbContext, EntityId); given RuleEngineAssetProfileCache get(TenantId, AssetId) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAssetTypeSwitchNode.getRelationType(TbContext, EntityId)"})
  void testGetRelationType_givenRuleEngineAssetProfileCacheGetReturnNull() throws TbNodeException {
    // Arrange
    TbAssetTypeSwitchNode tbAssetTypeSwitchNode = new TbAssetTypeSwitchNode();

    RuleEngineAssetProfileCache ruleEngineAssetProfileCache =
        mock(RuleEngineAssetProfileCache.class);
    when(ruleEngineAssetProfileCache.get(Mockito.<TenantId>any(), Mockito.<AssetId>any()))
        .thenReturn(null);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetProfileCache()).thenReturn(ruleEngineAssetProfileCache);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbAssetTypeSwitchNode.getRelationType(
                ctx, new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleEngineAssetProfileCache).get(isA(TenantId.class), isA(AssetId.class));
    verify(ctx).getAssetProfileCache();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbAssetTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAssetTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAssetTypeSwitchNode.getRelationType(TbContext, EntityId)"})
  void testGetRelationType_thenReturnNull() throws TbNodeException {
    // Arrange
    TbAssetTypeSwitchNode tbAssetTypeSwitchNode = new TbAssetTypeSwitchNode();

    RuleEngineAssetProfileCache ruleEngineAssetProfileCache =
        mock(RuleEngineAssetProfileCache.class);
    when(ruleEngineAssetProfileCache.get(Mockito.<TenantId>any(), Mockito.<AssetId>any()))
        .thenReturn(new AssetProfile());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetProfileCache()).thenReturn(ruleEngineAssetProfileCache);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    String actualRelationType =
        tbAssetTypeSwitchNode.getRelationType(
            ctx, new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ruleEngineAssetProfileCache).get(isA(TenantId.class), isA(AssetId.class));
    verify(ctx).getAssetProfileCache();
    verify(ctx).getTenantId();
    assertNull(actualRelationType);
  }
}
