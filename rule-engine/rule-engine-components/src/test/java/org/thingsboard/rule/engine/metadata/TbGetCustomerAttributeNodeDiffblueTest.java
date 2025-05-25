package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.UUID;
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
   * <ul>
   *   <li>Then return {@link TbGetEntityDataNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetCustomerAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetEntityDataNodeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbGetEntityDataNodeConfiguration TbGetCustomerAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"})
  void testLoadNodeConfiguration_thenReturnTbGetEntityDataNodeConfiguration() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("foo", "foo");

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataToFetch(DataToFetch.ATTRIBUTES);
    tbGetEntityDataNodeConfiguration.setDataMapping(dataMapping);

    // Act and Assert
    assertSame(tbGetEntityDataNodeConfiguration, tbGetCustomerAttributeNode
        .loadNodeConfiguration(new TbNodeConfiguration(new POJONode(tbGetEntityDataNodeConfiguration))));
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Given {@link CacheExecutorService} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId); given CacheExecutorService (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture TbGetCustomerAttributeNode.findEntityAsync(TbContext, EntityId)"})
  void testFindEntityAsync_givenCacheExecutorService() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new CacheExecutorService());

    // Act
    tbGetCustomerAttributeNode.findEntityAsync(ctx,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
   * Method under test: {@link TbGetCustomerAttributeNode#findEntityAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId); given TestDbCallbackExecutor (default constructor); then return Done")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture TbGetCustomerAttributeNode.findEntityAsync(TbContext, EntityId)"})
  void testFindEntityAsync_givenTestDbCallbackExecutor_thenReturnDone() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());

    // Act
    ListenableFuture<CustomerId> actualFindEntityAsyncResult = tbGetCustomerAttributeNode.findEntityAsync(ctx,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ctx).getDbCallbackExecutor();
    assertTrue(actualFindEntityAsyncResult.isDone());
  }

  /**
   * Test {@link TbGetCustomerAttributeNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetCustomerAttributeNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbGetCustomerAttributeNode.upgrade(int, JsonNode)"})
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetCustomerAttributeNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof MissingNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetCustomerAttributeNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbGetCustomerAttributeNode}
   */
  @Test
  @DisplayName("Test new TbGetCustomerAttributeNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetCustomerAttributeNode.<init>()"})
  void testNewTbGetCustomerAttributeNode() {
    // Arrange and Act
    TbGetCustomerAttributeNode actualTbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    // Assert
    assertNull(actualTbGetCustomerAttributeNode.config);
    assertNull(actualTbGetCustomerAttributeNode.fetchTo);
  }
}
