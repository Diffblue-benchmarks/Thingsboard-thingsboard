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
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.dao.cache.CacheExecutorService;

class TbGetCustomerAttributeNodeDiffblueTest {
  /**
   * Test {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Given {@link CacheExecutorService} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId); given CacheExecutorService (default constructor)")
  void testFindEntityAsync_givenCacheExecutorService() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new CacheExecutorService());

    // Act
    tbGetCustomerAttributeNode.findEntityAsync(ctx, new CustomerId(UUID.randomUUID()));

    // Assert
    verify(ctx).getDbCallbackExecutor();
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).</li>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId); given TestDbCallbackExecutor (default constructor); then return Done")
  void testFindEntityAsync_givenTestDbCallbackExecutor_thenReturnDone() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());

    // Act
    ListenableFuture<CustomerId> actualFindEntityAsyncResult = tbGetCustomerAttributeNode.findEntityAsync(ctx,
        new AlarmId(UUID.randomUUID()));

    // Assert
    verify(ctx).getDbCallbackExecutor();
    assertTrue(actualFindEntityAsyncResult.isDone());
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Then return {@link Future#get()} is {@link CustomerId#CustomerId(UUID)}
   * with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId); then return get() is CustomerId(UUID) with id is randomUUID")
  void testFindEntityAsync_thenReturnGetIsCustomerIdWithIdIsRandomUUID()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    ListenableFuture<CustomerId> actualFindEntityAsyncResult = tbGetCustomerAttributeNode.findEntityAsync(ctx,
        originator);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    assertSame(originator, actualFindEntityAsyncResult.get());
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetCustomerAttributeNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetCustomerAttributeNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test new {@link TbGetCustomerAttributeNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbGetCustomerAttributeNode}
   */
  @Test
  @DisplayName("Test new TbGetCustomerAttributeNode (default constructor)")
  void testNewTbGetCustomerAttributeNode() {
    // Arrange and Act
    TbGetCustomerAttributeNode actualTbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    // Assert
    assertNull(actualTbGetCustomerAttributeNode.config);
    assertNull(actualTbGetCustomerAttributeNode.fetchTo);
  }
}
