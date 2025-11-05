package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.relation.BaseRelationService;

@ExtendWith(MockitoExtension.class)
class TbCheckRelationNodeDiffblueTest {
  @Mock private EntityId entityId;

  @InjectMocks private TbCheckRelationNode tbCheckRelationNode;

  @Mock private TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration;

  /**
   * Test {@link TbCheckRelationNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link TbCheckRelationNodeConfiguration#getEntityId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then calls getEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckRelationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenCallsGetEntityId() throws TbNodeException {
    // Arrange
    TbCheckRelationNode tbCheckRelationNode = new TbCheckRelationNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        mock(TbCheckRelationNodeConfiguration.class);
    when(tbCheckRelationNodeConfiguration.getEntityId()).thenReturn("");
    when(tbCheckRelationNodeConfiguration.getEntityType()).thenReturn("Entity Type");
    when(tbCheckRelationNodeConfiguration.isCheckForSingleEntity()).thenReturn(true);
    POJONode data = new POJONode(tbCheckRelationNodeConfiguration);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbCheckRelationNode.init(ctx, new TbNodeConfiguration(data)));
    verify(tbCheckRelationNodeConfiguration).getEntityId();
    verify(tbCheckRelationNodeConfiguration).getEntityType();
    verify(tbCheckRelationNodeConfiguration).isCheckForSingleEntity();
  }

  /**
   * Test {@link TbCheckRelationNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link TbCheckRelationNodeConfiguration}
   *       (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is TbCheckRelationNodeConfiguration (default constructor); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckRelationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsTbCheckRelationNodeConfiguration_thenDoesNotThrow()
      throws TbNodeException {
    // Arrange
    TbCheckRelationNode tbCheckRelationNode = new TbCheckRelationNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertDoesNotThrow(
        () ->
            tbCheckRelationNode.init(
                ctx,
                new TbNodeConfiguration(new POJONode(new TbCheckRelationNodeConfiguration()))));
  }

  /**
   * Test {@link TbCheckRelationNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbCheckRelationNodeConfiguration} {@link
   *       TbCheckRelationNodeConfiguration#getEntityType()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when TbCheckRelationNodeConfiguration getEntityType() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckRelationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbCheckRelationNodeConfigurationGetEntityTypeReturnEmptyString()
      throws TbNodeException {
    // Arrange
    TbCheckRelationNode tbCheckRelationNode = new TbCheckRelationNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbCheckRelationNodeConfiguration tbCheckRelationNodeConfiguration =
        mock(TbCheckRelationNodeConfiguration.class);
    when(tbCheckRelationNodeConfiguration.getEntityType()).thenReturn("");
    when(tbCheckRelationNodeConfiguration.isCheckForSingleEntity()).thenReturn(true);
    POJONode data = new POJONode(tbCheckRelationNodeConfiguration);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbCheckRelationNode.init(ctx, new TbNodeConfiguration(data)));
    verify(tbCheckRelationNodeConfiguration).getEntityType();
    verify(tbCheckRelationNodeConfiguration).isCheckForSingleEntity();
  }

  /**
   * Test {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ListenableFutureTask addListener(Runnable, Executor) does nothing; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckRelationNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListenableFutureTaskAddListenerDoesNothing_thenCallsAddListener()
      throws TbNodeException {
    // Arrange
    when(tbCheckRelationNodeConfiguration.getRelationType()).thenReturn("Relation Type");
    when(tbCheckRelationNodeConfiguration.isCheckForSingleEntity()).thenReturn(true);
    when(tbCheckRelationNodeConfiguration.getDirection()).thenReturn("Direction");
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ListenableFutureTask<Boolean> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Boolean> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Boolean> apiFuture = new ForwardingApiFuture<>(delegate2);

    BaseRelationService baseRelationService = mock(BaseRelationService.class);
    when(baseRelationService.checkRelationAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getRelationService()).thenReturn(baseRelationService);

    // Act
    tbCheckRelationNode.onMsg(
        ctx,
        TbTelemetryMsgFactory.telemetryMsg(
            entityId, "Key", TbContextMinimalFactory.minimalForOnMsg()));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getRelationService();
    verify(ctx).getTenantId();
    verify(tbCheckRelationNodeConfiguration).getDirection();
    verify(tbCheckRelationNodeConfiguration).getRelationType();
    verify(tbCheckRelationNodeConfiguration).isCheckForSingleEntity();
    verify(entityId).getEntityType();
    verify(baseRelationService)
        .checkRelationAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckRelationNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsAddListener() throws TbNodeException {
    // Arrange
    when(tbCheckRelationNodeConfiguration.getRelationType()).thenReturn("Relation Type");
    when(tbCheckRelationNodeConfiguration.isCheckForSingleEntity()).thenReturn(false);
    when(tbCheckRelationNodeConfiguration.getDirection()).thenReturn("Direction");
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ListenableFutureTask<List<EntityRelation>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<List<EntityRelation>> delegate2 =
        new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<List<EntityRelation>> apiFuture = new ForwardingApiFuture<>(delegate2);

    BaseRelationService baseRelationService = mock(BaseRelationService.class);
    when(baseRelationService.findByToAndTypeAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getRelationService()).thenReturn(baseRelationService);

    // Act
    tbCheckRelationNode.onMsg(
        ctx,
        TbTelemetryMsgFactory.telemetryMsg(
            entityId, "Key", TbContextMinimalFactory.minimalForOnMsg()));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(ctx, atLeast(1)).getDbCallbackExecutor();
    verify(ctx).getRelationService();
    verify(ctx).getTenantId();
    verify(tbCheckRelationNodeConfiguration).getDirection();
    verify(tbCheckRelationNodeConfiguration).getRelationType();
    verify(tbCheckRelationNodeConfiguration).isCheckForSingleEntity();
    verify(entityId).getEntityType();
    verify(baseRelationService)
        .findByToAndTypeAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId,
   *       String, RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); then calls checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckRelationNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsCheckRelationAsync() throws TbNodeException {
    // Arrange
    when(tbCheckRelationNodeConfiguration.getRelationType()).thenReturn("Relation Type");
    when(tbCheckRelationNodeConfiguration.isCheckForSingleEntity()).thenReturn(true);
    when(tbCheckRelationNodeConfiguration.getDirection()).thenReturn("Direction");
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    BaseRelationService baseRelationService = mock(BaseRelationService.class);
    SettableFuture<Boolean> delegate = SettableFuture.create();
    ForwardingApiFuture<Boolean> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(baseRelationService.checkRelationAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getRelationService()).thenReturn(baseRelationService);

    // Act
    tbCheckRelationNode.onMsg(
        ctx,
        TbTelemetryMsgFactory.telemetryMsg(
            entityId, "Key", TbContextMinimalFactory.minimalForOnMsg()));

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getRelationService();
    verify(ctx).getTenantId();
    verify(tbCheckRelationNodeConfiguration).getDirection();
    verify(tbCheckRelationNodeConfiguration).getRelationType();
    verify(tbCheckRelationNodeConfiguration).isCheckForSingleEntity();
    verify(entityId).getEntityType();
    verify(baseRelationService)
        .checkRelationAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String,
   *       RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); then calls findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckRelationNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsFindByFromAndTypeAsync() throws TbNodeException {
    // Arrange
    when(tbCheckRelationNodeConfiguration.getRelationType()).thenReturn("Relation Type");
    when(tbCheckRelationNodeConfiguration.isCheckForSingleEntity()).thenReturn(false);
    when(tbCheckRelationNodeConfiguration.getDirection()).thenReturn("FROM");
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    BaseRelationService baseRelationService = mock(BaseRelationService.class);
    SettableFuture<List<EntityRelation>> delegate = SettableFuture.create();
    ForwardingApiFuture<List<EntityRelation>> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(baseRelationService.findByFromAndTypeAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getRelationService()).thenReturn(baseRelationService);

    // Act
    tbCheckRelationNode.onMsg(
        ctx,
        TbTelemetryMsgFactory.telemetryMsg(
            entityId, "Key", TbContextMinimalFactory.minimalForOnMsg()));

    // Assert
    verify(ctx, atLeast(1)).getDbCallbackExecutor();
    verify(ctx).getRelationService();
    verify(ctx).getTenantId();
    verify(tbCheckRelationNodeConfiguration).getDirection();
    verify(tbCheckRelationNodeConfiguration).getRelationType();
    verify(tbCheckRelationNodeConfiguration).isCheckForSingleEntity();
    verify(entityId).getEntityType();
    verify(baseRelationService)
        .findByFromAndTypeAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String,
   *       RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); then calls findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckRelationNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsFindByToAndTypeAsync() throws TbNodeException {
    // Arrange
    when(tbCheckRelationNodeConfiguration.getRelationType()).thenReturn("Relation Type");
    when(tbCheckRelationNodeConfiguration.isCheckForSingleEntity()).thenReturn(false);
    when(tbCheckRelationNodeConfiguration.getDirection()).thenReturn("Direction");
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    BaseRelationService baseRelationService = mock(BaseRelationService.class);
    SettableFuture<List<EntityRelation>> delegate = SettableFuture.create();
    ForwardingApiFuture<List<EntityRelation>> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(baseRelationService.findByToAndTypeAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getRelationService()).thenReturn(baseRelationService);

    // Act
    tbCheckRelationNode.onMsg(
        ctx,
        TbTelemetryMsgFactory.telemetryMsg(
            entityId, "Key", TbContextMinimalFactory.minimalForOnMsg()));

    // Assert
    verify(ctx, atLeast(1)).getDbCallbackExecutor();
    verify(ctx).getRelationService();
    verify(ctx).getTenantId();
    verify(tbCheckRelationNodeConfiguration).getDirection();
    verify(tbCheckRelationNodeConfiguration).getRelationType();
    verify(tbCheckRelationNodeConfiguration).isCheckForSingleEntity();
    verify(entityId).getEntityType();
    verify(baseRelationService)
        .findByToAndTypeAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link TbCheckRelationNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbCheckRelationNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenInstance() throws TbNodeException {
    // Arrange
    TbCheckRelationNode tbCheckRelationNode = new TbCheckRelationNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("direction", MissingNode.getInstance());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckRelationNode.upgrade(0, oldConfiguration));
  }

  /**
   * Test {@link TbCheckRelationNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbCheckRelationNode} (default constructor).
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given TbCheckRelationNode (default constructor); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbCheckRelationNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenTbCheckRelationNode_whenOne_thenSecondReturnDoubleNode()
      throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbCheckRelationNode().upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test {@link TbCheckRelationNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code TO}.
   *   <li>When {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true} {@code TO} is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given 'TO'; when ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true' 'TO' is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbCheckRelationNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenTo_whenObjectNodeWithNcIsWithExactBigDecimalsTrueToIsValueOfTen()
      throws TbNodeException {
    // Arrange
    TbCheckRelationNode tbCheckRelationNode = new TbCheckRelationNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("TO", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckRelationNode.upgrade(0, oldConfiguration));
  }

  /**
   * Test {@link TbCheckRelationNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true} {@code direction} is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckRelationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true' 'direction' is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbCheckRelationNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenObjectNodeWithNcIsWithExactBigDecimalsTrueDirectionIsValueOfTen()
      throws TbNodeException {
    // Arrange
    TbCheckRelationNode tbCheckRelationNode = new TbCheckRelationNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("direction", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckRelationNode.upgrade(0, oldConfiguration));
  }
}
