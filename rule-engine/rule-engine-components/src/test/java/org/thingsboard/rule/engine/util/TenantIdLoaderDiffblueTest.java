/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import org.thingsboard.server.common.data.id.DashboardId;
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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new ApiUsageStateId(UUID.randomUUID())));
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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    TenantId actualFindTenantIdResult =
        TenantIdLoader.findTenantId(ctx, new ApiUsageStateId(UUID.randomUUID()));

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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new ApiUsageStateId(UUID.randomUUID())));
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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    TenantId actualFindTenantIdResult =
        TenantIdLoader.findTenantId(ctx, new ApiUsageStateId(UUID.randomUUID()));

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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    TenantId actualFindTenantIdResult =
        TenantIdLoader.findTenantId(ctx, new AssetProfileId(UUID.randomUUID()));

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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new AssetProfileId(UUID.randomUUID())));
    verify(ruleEngineAssetProfileCache).get(isA(TenantId.class), isA(AssetProfileId.class));
    verify(ctx).getAssetProfileCache();
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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new AssetId(UUID.randomUUID())));
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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new CustomerId(UUID.randomUUID())));
    verify(ctx).getCustomerService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getDashboardService()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId); then calls getDashboardService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_thenCallsGetDashboardService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDashboardService()).thenThrow(new RuntimeException());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new DashboardId(UUID.randomUUID())));
    verify(ctx).getDashboardService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then calls {@link RuleEngineAlarmService#findAlarmById(TenantId, AlarmId)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findTenantId(TbContext, EntityId); when AlarmId(UUID) with id is randomUUID; then calls findAlarmById(TenantId, AlarmId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_whenAlarmIdWithIdIsRandomUUID_thenCallsFindAlarmById() {
    // Arrange
    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmById(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new AlarmId(UUID.randomUUID())));
    verify(ruleEngineAlarmService).findAlarmById(isA(TenantId.class), isA(AlarmId.class));
    verify(ctx).getAlarmService();
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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new AssetProfileId(UUID.randomUUID())));
    verify(ctx).getAssetProfileCache();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findTenantId(TbContext, EntityId); when TbContext getTenantId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_whenTbContextGetTenantIdThrowRuntimeException() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> TenantIdLoader.findTenantId(ctx, new AlarmId(UUID.randomUUID())));
    verify(ctx).getTenantId();
  }
}
