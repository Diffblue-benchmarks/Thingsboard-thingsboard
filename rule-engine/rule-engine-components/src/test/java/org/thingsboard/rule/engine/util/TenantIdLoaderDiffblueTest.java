package org.thingsboard.rule.engine.util;

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
import org.thingsboard.rule.engine.api.RuleEngineAlarmService;
import org.thingsboard.rule.engine.api.RuleEngineApiUsageStateService;
import org.thingsboard.rule.engine.api.RuleEngineAssetProfileCache;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class TenantIdLoaderDiffblueTest {
  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleEngineApiUsageStateService()).thenThrow(new RuntimeException());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ctx).getRuleEngineApiUsageStateService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId2() {
    // Arrange
    RuleEngineApiUsageStateService ruleEngineApiUsageStateService =
        mock(RuleEngineApiUsageStateService.class);
    when(ruleEngineApiUsageStateService.findApiUsageStateById(
            Mockito.<TenantId>any(), Mockito.<ApiUsageStateId>any()))
        .thenReturn(new ApiUsageState());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleEngineApiUsageStateService()).thenReturn(ruleEngineApiUsageStateService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantId actualFindTenantIdResult =
        TenantIdLoader.findTenantId(
            ctx, new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ruleEngineApiUsageStateService)
        .findApiUsageStateById(isA(TenantId.class), isA(ApiUsageStateId.class));
    verify(ctx).getRuleEngineApiUsageStateService();
    verify(ctx).getTenantId();
    assertNull(actualFindTenantIdResult);
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId3() {
    // Arrange
    RuleEngineApiUsageStateService ruleEngineApiUsageStateService =
        mock(RuleEngineApiUsageStateService.class);
    when(ruleEngineApiUsageStateService.findApiUsageStateById(
            Mockito.<TenantId>any(), Mockito.<ApiUsageStateId>any()))
        .thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleEngineApiUsageStateService()).thenReturn(ruleEngineApiUsageStateService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleEngineApiUsageStateService)
        .findApiUsageStateById(isA(TenantId.class), isA(ApiUsageStateId.class));
    verify(ctx).getRuleEngineApiUsageStateService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId4() {
    // Arrange
    RuleEngineApiUsageStateService ruleEngineApiUsageStateService =
        mock(RuleEngineApiUsageStateService.class);
    when(ruleEngineApiUsageStateService.findApiUsageStateById(
            Mockito.<TenantId>any(), Mockito.<ApiUsageStateId>any()))
        .thenReturn(null);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleEngineApiUsageStateService()).thenReturn(ruleEngineApiUsageStateService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantId actualFindTenantIdResult =
        TenantIdLoader.findTenantId(
            ctx, new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ruleEngineApiUsageStateService)
        .findApiUsageStateById(isA(TenantId.class), isA(ApiUsageStateId.class));
    verify(ctx).getRuleEngineApiUsageStateService();
    verify(ctx).getTenantId();
    assertNull(actualFindTenantIdResult);
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleEngineAssetProfileCache} {@link
   *       RuleEngineAssetProfileCache#get(TenantId, AssetProfileId)} return {@link
   *       AssetProfile#AssetProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findTenantId(TbContext, EntityId); given RuleEngineAssetProfileCache get(TenantId, AssetProfileId) return AssetProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_givenRuleEngineAssetProfileCacheGetReturnAssetProfile() {
    // Arrange
    RuleEngineAssetProfileCache ruleEngineAssetProfileCache =
        mock(RuleEngineAssetProfileCache.class);
    when(ruleEngineAssetProfileCache.get(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(new AssetProfile());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetProfileCache()).thenReturn(ruleEngineAssetProfileCache);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantId actualFindTenantIdResult =
        TenantIdLoader.findTenantId(
            ctx, new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ruleEngineAssetProfileCache).get(isA(TenantId.class), isA(AssetProfileId.class));
    verify(ctx).getAssetProfileCache();
    verify(ctx).getTenantId();
    assertNull(actualFindTenantIdResult);
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleEngineAssetProfileCache} {@link
   *       RuleEngineAssetProfileCache#get(TenantId, AssetProfileId)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findTenantId(TbContext, EntityId); given RuleEngineAssetProfileCache get(TenantId, AssetProfileId) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_givenRuleEngineAssetProfileCacheGetThrowRuntimeException() {
    // Arrange
    RuleEngineAssetProfileCache ruleEngineAssetProfileCache =
        mock(RuleEngineAssetProfileCache.class);
    when(ruleEngineAssetProfileCache.get(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetProfileCache()).thenReturn(ruleEngineAssetProfileCache);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleEngineAssetProfileCache).get(isA(TenantId.class), isA(AssetProfileId.class));
    verify(ctx).getAssetProfileCache();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleEngineAlarmService#findAlarmById(TenantId, AlarmId)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findTenantId(TbContext, EntityId); then calls findAlarmById(TenantId, AlarmId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_thenCallsFindAlarmById() {
    // Arrange
    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmById(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleEngineAlarmService).findAlarmById(isA(TenantId.class), isA(AlarmId.class));
    verify(ctx).getAlarmService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getAssetService()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId); then calls getAssetService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_thenCallsGetAssetService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetService()).thenThrow(new RuntimeException());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ctx).getAssetService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getCustomerService()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId); then calls getCustomerService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_thenCallsGetCustomerService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getCustomerService()).thenThrow(new RuntimeException());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ctx).getCustomerService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getAssetProfileCache()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findTenantId(TbContext, EntityId); when TbContext getAssetProfileCache() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_whenTbContextGetAssetProfileCacheThrowRuntimeException() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetProfileCache()).thenThrow(new RuntimeException());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ctx).getAssetProfileCache();
    verify(ctx).getTenantId();
  }
}
