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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbAssetTypeSwitchNode.getRelationType(ctx, new AssetId(UUID.randomUUID())));
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
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    String actualRelationType =
        tbAssetTypeSwitchNode.getRelationType(ctx, new AssetId(UUID.randomUUID()));

    // Assert
    verify(ruleEngineAssetProfileCache).get(isA(TenantId.class), isA(AssetId.class));
    verify(ctx).getAssetProfileCache();
    verify(ctx).getTenantId();
    assertNull(actualRelationType);
  }

  /**
   * Test {@link TbAssetTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAssetTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test getRelationType(TbContext, EntityId); when AlarmId(UUID) with id is randomUUID; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAssetTypeSwitchNode.getRelationType(TbContext, EntityId)"})
  void testGetRelationType_whenAlarmIdWithIdIsRandomUUID_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbAssetTypeSwitchNode tbAssetTypeSwitchNode = new TbAssetTypeSwitchNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbAssetTypeSwitchNode.getRelationType(ctx, new AlarmId(UUID.randomUUID())));
  }
}
