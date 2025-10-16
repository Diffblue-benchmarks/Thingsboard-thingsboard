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
package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetTenantAttributeNodeDiffblueTest {
  /**
   * Test {@link TbGetTenantAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetTenantAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); given HashMap() 'foo' is 'foo'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetEntityDataNodeConfiguration TbGetTenantAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_givenHashMapFooIsFoo_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGetTenantAttributeNode tbGetTenantAttributeNode = new TbGetTenantAttributeNode();

    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("foo", "foo");

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataMapping(dataMapping);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGetTenantAttributeNode.loadNodeConfiguration(
                new TbNodeConfiguration(new POJONode(tbGetEntityDataNodeConfiguration))));
  }

  /**
   * Test {@link TbGetTenantAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbGetEntityDataNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetTenantAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetEntityDataNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetEntityDataNodeConfiguration TbGetTenantAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetEntityDataNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetTenantAttributeNode tbGetTenantAttributeNode = new TbGetTenantAttributeNode();

    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("foo", "foo");

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataToFetch(DataToFetch.ATTRIBUTES);
    tbGetEntityDataNodeConfiguration.setDataMapping(dataMapping);

    // Act
    TbGetEntityDataNodeConfiguration actualLoadNodeConfigurationResult =
        tbGetTenantAttributeNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetEntityDataNodeConfiguration)));

    // Assert
    assertSame(tbGetEntityDataNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbGetTenantAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetTenantAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetEntityDataNodeConfiguration TbGetTenantAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetTenantAttributeNode tbGetTenantAttributeNode = new TbGetTenantAttributeNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGetTenantAttributeNode.loadNodeConfiguration(
                new TbNodeConfiguration(new POJONode(new TbGetEntityDataNodeConfiguration()))));
  }

  /**
   * Test {@link TbGetTenantAttributeNode#findEntityAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@link ListenableFuture#get()} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityAsync(TbContext, EntityId); given 'null'; then return get() is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbGetTenantAttributeNode.findEntityAsync(TbContext, EntityId)"
  })
  void testFindEntityAsync_givenNull_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbGetTenantAttributeNode tbGetTenantAttributeNode = new TbGetTenantAttributeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);

    // Act
    ListenableFuture<TenantId> actualFindEntityAsyncResult =
        tbGetTenantAttributeNode.findEntityAsync(ctx, null);

    // Assert
    verify(ctx).getTenantId();
    assertNull(actualFindEntityAsyncResult.get());
    assertTrue(actualFindEntityAsyncResult.isDone());
  }

  /**
   * Test {@link TbGetTenantAttributeNode#findEntityAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} is {@link TenantId#TenantId(UUID)} with id is
   *       randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityAsync(TbContext, EntityId); then return get() is TenantId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbGetTenantAttributeNode.findEntityAsync(TbContext, EntityId)"
  })
  void testFindEntityAsync_thenReturnGetIsTenantIdWithIdIsRandomUUID()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbGetTenantAttributeNode tbGetTenantAttributeNode = new TbGetTenantAttributeNode();

    TbContext ctx = mock(TbContext.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(ctx.getTenantId()).thenReturn(tenantId);

    // Act
    ListenableFuture<TenantId> actualFindEntityAsyncResult =
        tbGetTenantAttributeNode.findEntityAsync(ctx, null);

    // Assert
    verify(ctx).getTenantId();
    assertSame(tenantId, actualFindEntityAsyncResult.get());
  }

  /**
   * Test {@link TbGetTenantAttributeNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTenantAttributeNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetTenantAttributeNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbGetTenantAttributeNode().upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetTenantAttributeNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbGetTenantAttributeNode}
   */
  @Test
  @DisplayName("Test new TbGetTenantAttributeNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetTenantAttributeNode.<init>()"})
  void testNewTbGetTenantAttributeNode() {
    // Arrange and Act
    TbGetTenantAttributeNode actualTbGetTenantAttributeNode = new TbGetTenantAttributeNode();

    // Assert
    assertNull(actualTbGetTenantAttributeNode.config);
    assertNull(actualTbGetTenantAttributeNode.fetchTo);
  }
}
