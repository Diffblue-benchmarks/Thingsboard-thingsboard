package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetTenantAttributeNodeDiffblueTest {
  /**
   * Test {@link TbGetTenantAttributeNode#findEntityAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetTenantAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId); given 'null'; then return get() is 'null'")
  void testFindEntityAsync_givenNull_thenReturnGetIsNull() throws InterruptedException, ExecutionException {
    // Arrange
    TbGetTenantAttributeNode tbGetTenantAttributeNode = new TbGetTenantAttributeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);

    // Act
    ListenableFuture<TenantId> actualFindEntityAsyncResult = tbGetTenantAttributeNode.findEntityAsync(ctx, null);

    // Assert
    verify(ctx).getTenantId();
    assertNull(actualFindEntityAsyncResult.get());
    assertTrue(actualFindEntityAsyncResult.isDone());
  }

  /**
   * Test {@link TbGetTenantAttributeNode#findEntityAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Then return {@link Future#get()} is {@link TenantId#TenantId(UUID)} with
   * id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetTenantAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId); then return get() is TenantId(UUID) with id is randomUUID")
  void testFindEntityAsync_thenReturnGetIsTenantIdWithIdIsRandomUUID() throws InterruptedException, ExecutionException {
    // Arrange
    TbGetTenantAttributeNode tbGetTenantAttributeNode = new TbGetTenantAttributeNode();
    TbContext ctx = mock(TbContext.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(ctx.getTenantId()).thenReturn(tenantId);

    // Act
    ListenableFuture<TenantId> actualFindEntityAsyncResult = tbGetTenantAttributeNode.findEntityAsync(ctx, null);

    // Assert
    verify(ctx).getTenantId();
    assertSame(tenantId, actualFindEntityAsyncResult.get());
  }

  /**
   * Test {@link TbGetTenantAttributeNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetTenantAttributeNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetTenantAttributeNode tbGetTenantAttributeNode = new TbGetTenantAttributeNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetTenantAttributeNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test new {@link TbGetTenantAttributeNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbGetTenantAttributeNode}
   */
  @Test
  @DisplayName("Test new TbGetTenantAttributeNode (default constructor)")
  void testNewTbGetTenantAttributeNode() {
    // Arrange and Act
    TbGetTenantAttributeNode actualTbGetTenantAttributeNode = new TbGetTenantAttributeNode();

    // Assert
    assertNull(actualTbGetTenantAttributeNode.config);
    assertNull(actualTbGetTenantAttributeNode.fetchTo);
  }
}
