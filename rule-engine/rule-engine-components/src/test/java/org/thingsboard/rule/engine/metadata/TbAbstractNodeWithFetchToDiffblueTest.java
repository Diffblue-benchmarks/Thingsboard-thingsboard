package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.util.TbPair;

class TbAbstractNodeWithFetchToDiffblueTest {
  /**
   * Test {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAbstractNodeWithFetchTo.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbFetchDeviceCredentialsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"
  })
  void testCheckIfEntityIsPresentOrThrow() throws Exception {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    AsyncFunction<EntityId, EntityId> actualCheckIfEntityIsPresentOrThrowResult =
        tbFetchDeviceCredentialsNode.checkIfEntityIsPresentOrThrow("Not all who wander are lost");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmId alarmId = new AlarmId(id);
    ListenableFuture<EntityId> actualApplyResult =
        actualCheckIfEntityIsPresentOrThrowResult.apply(alarmId);

    // Assert
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertFalse(alarmId.isNullUid());
    assertTrue(actualApplyResult.isDone());
    assertSame(alarmId, actualApplyResult.get());
    assertSame(id, alarmId.getId());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   *
   * <ul>
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String); then 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"
  })
  void testCheckIfEntityIsPresentOrThrow_thenNull() throws Exception {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act and Assert
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
    assertNull(null);
    assertTrue(
        tbFetchDeviceCredentialsNode
            .checkIfEntityIsPresentOrThrow("Not all who wander are lost")
            .apply(null)
            .isDone());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   *
   * <ul>
   *   <li>Then {@link TbFetchDeviceCredentialsNode} (default constructor) {@link
   *       TbAbstractNodeWithFetchTo#config} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName(
      "Test checkIfEntityIsPresentOrThrow(String); then TbFetchDeviceCredentialsNode (default constructor) config is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"
  })
  void testCheckIfEntityIsPresentOrThrow_thenTbFetchDeviceCredentialsNodeConfigIsNull() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    tbFetchDeviceCredentialsNode.checkIfEntityIsPresentOrThrow("Not all who wander are lost");

    // Assert that nothing has changed
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); given Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_givenInstance() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeConfigurationToUseFetchTo(
                "Old Property", "If True", "If False", newConfig));
    verify(newConfig).get(eq("Old Property"));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>Then return First.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then return First")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_thenReturnFirst() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.remove(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));
    when(newConfig.put(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(newConfig.get(Mockito.<String>any())).thenReturn(BooleanNode.getFalse());

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeConfigurationToUseFetchToResult =
        tbFetchDeviceCredentialsNode.upgradeConfigurationToUseFetchTo(
            "Old Property", "If True", "If False", newConfig);

    // Assert
    verify(newConfig).get(eq("Old Property"));
    verify(newConfig).put(eq("fetchTo"), eq("If False"));
    verify(newConfig).remove(eq("Old Property"));
    assertTrue(actualUpgradeConfigurationToUseFetchToResult.getFirst());
    assertSame(newConfig, actualUpgradeConfigurationToUseFetchToResult.getSecond());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>Then return First.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then return First")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_thenReturnFirst2() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.remove(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));
    when(newConfig.put(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(newConfig.get(Mockito.<String>any())).thenReturn(BooleanNode.getTrue());

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeConfigurationToUseFetchToResult =
        tbFetchDeviceCredentialsNode.upgradeConfigurationToUseFetchTo(
            "Old Property", "If True", "If False", newConfig);

    // Assert
    verify(newConfig).get(eq("Old Property"));
    verify(newConfig).put(eq("fetchTo"), eq("If True"));
    verify(newConfig).remove(eq("Old Property"));
    assertTrue(actualUpgradeConfigurationToUseFetchToResult.getFirst());
    assertSame(newConfig, actualUpgradeConfigurationToUseFetchToResult.getSecond());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_thenThrowIllegalArgumentException()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.remove(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException(Boolean.TRUE.toString()));
    when(newConfig.get(Mockito.<String>any())).thenReturn(BooleanNode.getFalse());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeConfigurationToUseFetchTo(
                "Old Property", "If True", "If False", newConfig));
    verify(newConfig).get(eq("Old Property"));
    verify(newConfig).remove(eq("Old Property"));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_thenThrowIllegalArgumentException2()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.remove(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException(Boolean.TRUE.toString()));
    when(newConfig.get(Mockito.<String>any())).thenReturn(BooleanNode.getTrue());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeConfigurationToUseFetchTo(
                "Old Property", "If True", "If False", newConfig));
    verify(newConfig).get(eq("Old Property"));
    verify(newConfig).remove(eq("Old Property"));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>When {@link ObjectNode} {@link ObjectNode#get(String)} return valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); when ObjectNode get(String) return valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_whenObjectNodeGetReturnValueOfTen()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    ObjectNode newConfig = mock(ObjectNode.class);
    when(newConfig.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeConfigurationToUseFetchTo(
                "Old Property", "If True", "If False", newConfig));
    verify(newConfig).get(eq("Old Property"));
  }
}
