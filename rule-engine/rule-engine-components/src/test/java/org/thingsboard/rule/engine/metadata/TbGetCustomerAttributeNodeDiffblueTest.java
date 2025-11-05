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
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.dao.cache.CacheExecutorService;

class TbGetCustomerAttributeNodeDiffblueTest {
  /**
   * Test {@link TbGetCustomerAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetCustomerAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); given HashMap() 'Key' is '42'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetEntityDataNodeConfiguration TbGetCustomerAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_givenHashMapKeyIs42_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("Key", "42");

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataMapping(dataMapping);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGetCustomerAttributeNode.loadNodeConfiguration(
                new TbNodeConfiguration(new POJONode(tbGetEntityDataNodeConfiguration))));
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbGetEntityDataNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetCustomerAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetEntityDataNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetEntityDataNodeConfiguration TbGetCustomerAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetEntityDataNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("Key", "42");

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration =
        new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataToFetch(DataToFetch.ATTRIBUTES);
    tbGetEntityDataNodeConfiguration.setDataMapping(dataMapping);

    // Act
    TbGetEntityDataNodeConfiguration actualLoadNodeConfigurationResult =
        tbGetCustomerAttributeNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetEntityDataNodeConfiguration)));

    // Assert
    assertSame(tbGetEntityDataNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetCustomerAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetEntityDataNodeConfiguration TbGetCustomerAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGetCustomerAttributeNode.loadNodeConfiguration(
                new TbNodeConfiguration(new POJONode(new TbGetEntityDataNodeConfiguration()))));
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}.
   *
   * <p>Method under test: {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbGetCustomerAttributeNode.findEntityAsync(TbContext, EntityId)"
  })
  void testFindEntityAsync() throws InterruptedException, ExecutionException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<CustomerId> actualFindEntityAsyncResult =
        tbGetCustomerAttributeNode.findEntityAsync(ctx, originator);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    assertSame(originator, actualFindEntityAsyncResult.get());
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link CacheExecutorService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityAsync(TbContext, EntityId); given CacheExecutorService (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbGetCustomerAttributeNode.findEntityAsync(TbContext, EntityId)"
  })
  void testFindEntityAsync_givenCacheExecutorService() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new CacheExecutorService());

    // Act
    tbGetCustomerAttributeNode.findEntityAsync(
        ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ctx).getDbCallbackExecutor();
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityAsync(TbContext, EntityId); given TestDbCallbackExecutor (default constructor); then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbGetCustomerAttributeNode.findEntityAsync(TbContext, EntityId)"
  })
  void testFindEntityAsync_givenTestDbCallbackExecutor_thenReturnDone() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());

    // Act
    ListenableFuture<CustomerId> actualFindEntityAsyncResult =
        tbGetCustomerAttributeNode.findEntityAsync(
            ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ctx).getDbCallbackExecutor();
    assertTrue(actualFindEntityAsyncResult.isDone());
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerAttributeNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetCustomerAttributeNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbGetCustomerAttributeNode().upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetCustomerAttributeNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbGetCustomerAttributeNode}
   */
  @Test
  @DisplayName("Test new TbGetCustomerAttributeNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetCustomerAttributeNode.<init>()"})
  void testNewTbGetCustomerAttributeNode() {
    // Arrange and Act
    TbGetCustomerAttributeNode actualTbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    // Assert
    assertNull(actualTbGetCustomerAttributeNode.config);
    assertNull(actualTbGetCustomerAttributeNode.fetchTo);
  }
}
