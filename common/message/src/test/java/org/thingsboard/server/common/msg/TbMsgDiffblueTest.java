package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgDiffblueTest {
  /**
   * Test {@link TbMsg#getAndIncrementRuleNodeCounter()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#getAndIncrementRuleNodeCounter()}
   */
  @Test
  @DisplayName("Test getAndIncrementRuleNodeCounter(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbMsg.getAndIncrementRuleNodeCounter()"})
  void testGetAndIncrementRuleNodeCounter_thenReturnZero() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(0, buildResult.getAndIncrementRuleNodeCounter());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code
   * String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg("Type", (EntityId) null, customerId, TbMsgMetaData.EMPTY, "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code
   * String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code
   * String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "org.thingsboard.server.common.msg.TbMsg",
            originator,
            null,
            TbMsgMetaData.EMPTY,
            "Data");

    // Assert
    assertEquals("org.thingsboard.server.common.msg.TbMsg", actualNewMsgResult.getType());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code
   * TbMsgDataType}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData,
   * TbMsgDataType, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg("Type", null, customerId, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code
   * TbMsgDataType}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData,
   * TbMsgDataType, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code
   * TbMsgDataType}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData,
   * TbMsgDataType, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "org.thingsboard.server.common.msg.TbMsg",
            originator,
            null,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data");

    // Assert
    assertEquals("org.thingsboard.server.common.msg.TbMsg", actualNewMsgResult.getType());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)} with {@code String}, {@code
   * EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, String) with 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator, TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)} with {@code String}, {@code
   * EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, String) with 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)} with {@code
   * String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code TbMsgCallback}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String,
   * TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY)
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)} with {@code
   * String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code TbMsgCallback}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String,
   * TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY);

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)} with {@code
   * String}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)} with {@code
   * String}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId,
   * RuleNodeId)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code
   * TbMsgDataType}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType,
   * String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                "Type",
                originator,
                TbMsgMetaData.EMPTY,
                TbMsgDataType.JSON,
                "Data",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId,
   * RuleNodeId)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code
   * TbMsgDataType}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType,
   * String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Type",
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)} with
   * {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData},
   * {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg("Queue Name", "Type", null, customerId, TbMsgMetaData.EMPTY, "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)} with
   * {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData},
   * {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)} with
   * {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData},
   * {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(null, "Type", originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertNull(actualNewMsgResult.getQueueName());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code
   * CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg(
                "Queue Name",
                "Type",
                null,
                customerId,
                TbMsgMetaData.EMPTY,
                "Data",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code
   * CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                "Queue Name",
                "Type",
                originator,
                null,
                TbMsgMetaData.EMPTY,
                "Data",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code
   * CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            null,
            "Type",
            originator,
            null,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertNull(actualNewMsgResult.getQueueName());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)} with {@code String},
   * {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)} with {@code String},
   * {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId,
   * RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                "Queue Name",
                "Type",
                originator,
                TbMsgMetaData.EMPTY,
                "Data",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId,
   * RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with
   * {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData},
   * {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg(
                "Queue Name",
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                null,
                customerId,
                TbMsgMetaData.EMPTY,
                "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with
   * {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData},
   * {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                "Queue Name",
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                originator,
                null,
                TbMsgMetaData.EMPTY,
                "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code
   * CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId,
   * TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg(
                "Queue Name",
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                null,
                customerId,
                TbMsgMetaData.EMPTY,
                "Data",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code
   * CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId,
   * TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                "Queue Name",
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                originator,
                null,
                TbMsgMetaData.EMPTY,
                "Data",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with {@code
   * String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                "Queue Name",
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                originator,
                TbMsgMetaData.EMPTY,
                "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with {@code
   * String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId,
   * RuleNodeId)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                "Queue Name",
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                originator,
                TbMsgMetaData.EMPTY,
                "Data",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId,
   * RuleNodeId)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String,
   * RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code
   * String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg(
                tbMsg,
                "Queue Name",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code
   * String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg(
                tbMsg,
                "Queue Name",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code
   * String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId2 =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg(
                tbMsg,
                "Queue Name",
                ruleChainId2,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code
   * String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                tbMsg,
                "Queue Name",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code
   * String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'; then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            tbMsg,
            "Queue Name",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertEquals(1L, actualNewMsgResult.getMetaDataTs());
    assertEquals(1L, actualNewMsgResult.getTs());
    assertEquals(TbMsgType.POST_ATTRIBUTES_REQUEST, actualNewMsgResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code
   * String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'; then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            tbMsg,
            "Queue Name",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(TbMsgType.NA, actualNewMsgResult.getInternalType());
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code
   * TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange and Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals("POST_ATTRIBUTES_REQUEST", actualNewMsgResult.getType());
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertEquals(TbMsgType.POST_ATTRIBUTES_REQUEST, actualNewMsgResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code
   * TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg(
                TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, TbMsgMetaData.EMPTY, "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code
   * TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code
   * TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString4() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_TELEMETRY_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals("POST_TELEMETRY_REQUEST", actualNewMsgResult.getType());
    assertEquals(TbMsgType.POST_TELEMETRY_REQUEST, actualNewMsgResult.getInternalType());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType,
   * String)} with {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * TbMsgDataType, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.newMsg(
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                null,
                customerId,
                TbMsgMetaData.EMPTY,
                TbMsgDataType.JSON,
                "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType,
   * String)} with {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * TbMsgDataType, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                originator,
                null,
                TbMsgMetaData.EMPTY,
                TbMsgDataType.JSON,
                "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with {@code TbMsgType},
   * {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with {@code TbMsgType},
   * {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code
   * TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong() {
    // Arrange and Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", 0L);

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code
   * TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", 1L)
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code
   * TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", 1L);

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code
   * TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Then return MetaDataTs is one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'; then return MetaDataTs is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong_thenReturnMetaDataTsIsOne() {
    // Arrange and Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", 1L);

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertEquals(1L, actualNewMsgResult.getMetaDataTs());
    assertEquals(1L, actualNewMsgResult.getTs());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)} with
   * {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code
   * TbMsgCallback}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String,
   * TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                originator,
                TbMsgMetaData.EMPTY,
                "Data",
                TbMsgCallback.EMPTY)
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)} with
   * {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code
   * TbMsgCallback}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String,
   * TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            TbMsgCallback.EMPTY);

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)} with
   * {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code
   * String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                originator,
                TbMsgMetaData.EMPTY,
                TbMsgDataType.JSON,
                "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)} with
   * {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code
   * String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String,
   * RuleChainId, RuleNodeId)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType,
   * String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        TbMsg.newMsg(
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                originator,
                TbMsgMetaData.EMPTY,
                TbMsgDataType.JSON,
                "Data",
                ruleChainId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String,
   * RuleChainId, RuleNodeId)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType,
   * String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code
   * RuleChainId}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsg(
                tbMsg,
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Queue Name")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code
   * RuleChainId}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsg(
                tbMsg,
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Queue Name")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code
   * RuleChainId}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsg(
                tbMsg,
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Queue Name")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code
   * RuleChainId}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        originator,
        TbMsg.transformMsg(
                tbMsg,
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Queue Name")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code
   * RuleChainId}, {@code String}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'; then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(
            tbMsg,
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "Queue Name");

    // Assert
    assertNull(actualTransformMsgResult.getCustomerId());
    assertNull(actualTransformMsgResult.getOriginator());
    assertEquals(1L, actualTransformMsgResult.getMetaDataTs());
    assertEquals(1L, actualTransformMsgResult.getTs());
    assertEquals(TbMsgType.POST_ATTRIBUTES_REQUEST, actualTransformMsgResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code
   * RuleChainId}, {@code String}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'; then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(
            tbMsg,
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "Queue Name");

    // Assert
    assertEquals(TbMsgType.NA, actualTransformMsgResult.getInternalType());
    assertSame(customerId, actualTransformMsgResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsg(tbMsg, TbMsgMetaData.EMPTY, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsg(tbMsg, TbMsgMetaData.EMPTY, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, ruleNodeId);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgResult = TbMsg.transformMsg(tbMsg, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(ruleChainId, actualTransformMsgResult.getRuleChainId());
    assertEquals(ruleNodeId, actualTransformMsgResult.getRuleNodeId());
    assertSame(customerId, actualTransformMsgResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(originator, TbMsg.transformMsg(tbMsg, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'; then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgResult = TbMsg.transformMsg(tbMsg, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertNull(actualTransformMsgResult.getCustomerId());
    assertNull(actualTransformMsgResult.getOriginator());
    assertEquals(1L, actualTransformMsgResult.getMetaDataTs());
    assertEquals(1L, actualTransformMsgResult.getTs());
    assertEquals(TbMsgType.POST_ATTRIBUTES_REQUEST, actualTransformMsgResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'; then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgResult = TbMsg.transformMsg(tbMsg, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(TbMsgType.NA, actualTransformMsgResult.getInternalType());
    assertSame(customerId, actualTransformMsgResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgData(tbMsg, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgData(tbMsg, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, ruleNodeId);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgDataResult = TbMsg.transformMsgData(tbMsg, "Data");

    // Assert
    assertEquals(ruleChainId, actualTransformMsgDataResult.getRuleChainId());
    assertEquals(ruleNodeId, actualTransformMsgDataResult.getRuleNodeId());
    assertSame(customerId, actualTransformMsgDataResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(originator, TbMsg.transformMsgData(tbMsg, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String); then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgDataResult = TbMsg.transformMsgData(tbMsg, "Data");

    // Assert
    assertNull(actualTransformMsgDataResult.getCustomerId());
    assertNull(actualTransformMsgDataResult.getOriginator());
    assertEquals(1L, actualTransformMsgDataResult.getMetaDataTs());
    assertEquals(1L, actualTransformMsgDataResult.getTs());
    assertEquals(TbMsgType.POST_ATTRIBUTES_REQUEST, actualTransformMsgDataResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String); then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgDataResult = TbMsg.transformMsgData(tbMsg, "Data");

    // Assert
    assertEquals(TbMsgType.NA, actualTransformMsgDataResult.getInternalType());
    assertSame(customerId, actualTransformMsgDataResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgMetadata(tbMsg, TbMsgMetaData.EMPTY).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgMetadata(tbMsg, TbMsgMetaData.EMPTY).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, ruleNodeId);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgMetadataResult = TbMsg.transformMsgMetadata(tbMsg, TbMsgMetaData.EMPTY);

    // Assert
    assertEquals(ruleChainId, actualTransformMsgMetadataResult.getRuleChainId());
    assertEquals(ruleNodeId, actualTransformMsgMetadataResult.getRuleNodeId());
    assertSame(customerId, actualTransformMsgMetadataResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(originator, TbMsg.transformMsgMetadata(tbMsg, TbMsgMetaData.EMPTY).getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData); then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgMetadataResult = TbMsg.transformMsgMetadata(tbMsg, TbMsgMetaData.EMPTY);

    // Assert
    assertNull(actualTransformMsgMetadataResult.getCustomerId());
    assertNull(actualTransformMsgMetadataResult.getOriginator());
    assertEquals(1L, actualTransformMsgMetadataResult.getMetaDataTs());
    assertEquals(1L, actualTransformMsgMetadataResult.getTs());
    assertEquals(
        TbMsgType.POST_ATTRIBUTES_REQUEST, actualTransformMsgMetadataResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData); then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgMetadataResult = TbMsg.transformMsgMetadata(tbMsg, TbMsgMetaData.EMPTY);

    // Assert
    assertEquals(TbMsgType.NA, actualTransformMsgMetadataResult.getInternalType());
    assertSame(customerId, actualTransformMsgMetadataResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg, customerId).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg, customerId).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, ruleNodeId);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualTransformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Assert
    assertEquals(ruleChainId, actualTransformMsgCustomerIdResult.getRuleChainId());
    assertEquals(ruleNodeId, actualTransformMsgCustomerIdResult.getRuleNodeId());
    assertSame(customerId, actualTransformMsgCustomerIdResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(originator, TbMsg.transformMsgCustomerId(tbMsg, null).getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId); then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Assert
    assertNull(actualTransformMsgCustomerIdResult.getCustomerId());
    assertNull(actualTransformMsgCustomerIdResult.getOriginator());
    assertEquals(1L, actualTransformMsgCustomerIdResult.getMetaDataTs());
    assertEquals(1L, actualTransformMsgCustomerIdResult.getTs());
    assertEquals(
        TbMsgType.POST_ATTRIBUTES_REQUEST, actualTransformMsgCustomerIdResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId); then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualTransformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Assert
    assertEquals(TbMsgType.NA, actualTransformMsgCustomerIdResult.getInternalType());
    assertSame(customerId, actualTransformMsgCustomerIdResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgRuleChainId(
                tbMsg, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgRuleChainId(
                tbMsg, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgRuleChainId(
                tbMsg, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        originator,
        TbMsg.transformMsgRuleChainId(
                tbMsg, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId); then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgRuleChainIdResult =
        TbMsg.transformMsgRuleChainId(
            tbMsg, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertNull(actualTransformMsgRuleChainIdResult.getCustomerId());
    assertNull(actualTransformMsgRuleChainIdResult.getOriginator());
    assertEquals(1L, actualTransformMsgRuleChainIdResult.getMetaDataTs());
    assertEquals(1L, actualTransformMsgRuleChainIdResult.getTs());
    assertEquals(
        TbMsgType.POST_ATTRIBUTES_REQUEST, actualTransformMsgRuleChainIdResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId); then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgRuleChainIdResult =
        TbMsg.transformMsgRuleChainId(
            tbMsg, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(TbMsgType.NA, actualTransformMsgRuleChainIdResult.getInternalType());
    assertSame(customerId, actualTransformMsgRuleChainIdResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgQueueName(tbMsg, "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgQueueName(tbMsg, "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgQueueNameResult = TbMsg.transformMsgQueueName(tbMsg, "Queue Name");

    // Assert
    assertEquals(ruleChainId, actualTransformMsgQueueNameResult.getRuleChainId());
    assertSame(customerId, actualTransformMsgQueueNameResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(originator, TbMsg.transformMsgQueueName(tbMsg, "Queue Name").getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String); then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgQueueNameResult = TbMsg.transformMsgQueueName(tbMsg, "Queue Name");

    // Assert
    assertNull(actualTransformMsgQueueNameResult.getCustomerId());
    assertNull(actualTransformMsgQueueNameResult.getOriginator());
    assertEquals(1L, actualTransformMsgQueueNameResult.getMetaDataTs());
    assertEquals(1L, actualTransformMsgQueueNameResult.getTs());
    assertEquals(
        TbMsgType.POST_ATTRIBUTES_REQUEST, actualTransformMsgQueueNameResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String); then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualTransformMsgQueueNameResult = TbMsg.transformMsgQueueName(tbMsg, "Queue Name");

    // Assert
    assertEquals(TbMsgType.NA, actualTransformMsgQueueNameResult.getInternalType());
    assertSame(customerId, actualTransformMsgQueueNameResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[173]);
    assertEquals((byte) -107, actualToByteArrayResult[157]);
    assertEquals((byte) -119, actualToByteArrayResult[166]);
    assertEquals((byte) -122, actualToByteArrayResult[155]);
    assertEquals((byte) -17, actualToByteArrayResult[169]);
    assertEquals((byte) -38, actualToByteArrayResult[154]);
    assertEquals((byte) -39, actualToByteArrayResult[156]);
    assertEquals((byte) -50, actualToByteArrayResult[160]);
    assertEquals((byte) -60, actualToByteArrayResult[158]);
    assertEquals((byte) -7, actualToByteArrayResult[165]);
    assertEquals((byte) -7, actualToByteArrayResult[168]);
    assertEquals((byte) -80, actualToByteArrayResult[175]);
    assertEquals((byte) -83, actualToByteArrayResult[171]);
    assertEquals((byte) -87, actualToByteArrayResult[159]);
    assertEquals((byte) -88, actualToByteArrayResult[163]);
    assertEquals((byte) -89, actualToByteArrayResult[161]);
    assertEquals((byte) -98, actualToByteArrayResult[167]);
    assertEquals((byte) -98, actualToByteArrayResult[172]);
    assertEquals((byte) -9, actualToByteArrayResult[170]);
    assertEquals(178, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[164]);
    assertEquals((byte) 1, actualToByteArrayResult[177]);
    assertEquals('x', actualToByteArrayResult[162]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data(TbMsg.EMPTY_STRING)
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[165]);
    assertEquals((byte) -107, actualToByteArrayResult[149]);
    assertEquals((byte) -119, actualToByteArrayResult[158]);
    assertEquals((byte) -122, actualToByteArrayResult[147]);
    assertEquals((byte) -17, actualToByteArrayResult[161]);
    assertEquals((byte) -38, actualToByteArrayResult[146]);
    assertEquals((byte) -39, actualToByteArrayResult[148]);
    assertEquals((byte) -50, actualToByteArrayResult[152]);
    assertEquals((byte) -60, actualToByteArrayResult[150]);
    assertEquals((byte) -7, actualToByteArrayResult[157]);
    assertEquals((byte) -7, actualToByteArrayResult[160]);
    assertEquals((byte) -80, actualToByteArrayResult[167]);
    assertEquals((byte) -83, actualToByteArrayResult[163]);
    assertEquals((byte) -87, actualToByteArrayResult[151]);
    assertEquals((byte) -88, actualToByteArrayResult[155]);
    assertEquals((byte) -89, actualToByteArrayResult[153]);
    assertEquals((byte) -98, actualToByteArrayResult[159]);
    assertEquals((byte) -98, actualToByteArrayResult[164]);
    assertEquals((byte) -9, actualToByteArrayResult[162]);
    assertEquals(170, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[145]);
    assertEquals((byte) 1, actualToByteArrayResult[156]);
    assertEquals((byte) 1, actualToByteArrayResult[166]);
    assertEquals((byte) 1, actualToByteArrayResult[168]);
    assertEquals((byte) 1, actualToByteArrayResult[169]);
    assertEquals('x', actualToByteArrayResult[154]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray3() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.TEXT);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[173]);
    assertEquals((byte) -107, actualToByteArrayResult[157]);
    assertEquals((byte) -119, actualToByteArrayResult[166]);
    assertEquals((byte) -122, actualToByteArrayResult[155]);
    assertEquals((byte) -17, actualToByteArrayResult[169]);
    assertEquals((byte) -38, actualToByteArrayResult[154]);
    assertEquals((byte) -39, actualToByteArrayResult[156]);
    assertEquals((byte) -50, actualToByteArrayResult[160]);
    assertEquals((byte) -60, actualToByteArrayResult[158]);
    assertEquals((byte) -7, actualToByteArrayResult[165]);
    assertEquals((byte) -7, actualToByteArrayResult[168]);
    assertEquals((byte) -80, actualToByteArrayResult[175]);
    assertEquals((byte) -83, actualToByteArrayResult[171]);
    assertEquals((byte) -87, actualToByteArrayResult[159]);
    assertEquals((byte) -88, actualToByteArrayResult[163]);
    assertEquals((byte) -89, actualToByteArrayResult[161]);
    assertEquals((byte) -98, actualToByteArrayResult[167]);
    assertEquals((byte) -98, actualToByteArrayResult[172]);
    assertEquals((byte) -9, actualToByteArrayResult[170]);
    assertEquals(178, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[164]);
    assertEquals((byte) 1, actualToByteArrayResult[177]);
    assertEquals('x', actualToByteArrayResult[162]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(null);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[169]);
    assertEquals((byte) -107, actualToByteArrayResult[153]);
    assertEquals((byte) -119, actualToByteArrayResult[162]);
    assertEquals((byte) -122, actualToByteArrayResult[151]);
    assertEquals((byte) -17, actualToByteArrayResult[165]);
    assertEquals((byte) -38, actualToByteArrayResult[150]);
    assertEquals((byte) -39, actualToByteArrayResult[152]);
    assertEquals((byte) -50, actualToByteArrayResult[156]);
    assertEquals((byte) -60, actualToByteArrayResult[154]);
    assertEquals((byte) -7, actualToByteArrayResult[161]);
    assertEquals((byte) -80, actualToByteArrayResult[171]);
    assertEquals((byte) -83, actualToByteArrayResult[167]);
    assertEquals((byte) -87, actualToByteArrayResult[155]);
    assertEquals((byte) -88, actualToByteArrayResult[159]);
    assertEquals((byte) -89, actualToByteArrayResult[157]);
    assertEquals((byte) -98, actualToByteArrayResult[163]);
    assertEquals((byte) -98, actualToByteArrayResult[168]);
    assertEquals((byte) -9, actualToByteArrayResult[166]);
    assertEquals(174, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[160]);
    assertEquals((byte) 1, actualToByteArrayResult[170]);
    assertEquals('x', actualToByteArrayResult[158]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray5() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(0)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -96, actualToByteArrayResult[150]);
    assertEquals((byte) 0, actualToByteArrayResult[149]);
    assertEquals(173, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[148]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray6() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(null)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -96, actualToByteArrayResult[150]);
    assertEquals((byte) 0, actualToByteArrayResult[149]);
    assertEquals(173, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[148]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray7() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder ruleChainIdResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name")
            .ruleChainId(null);
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[150]);
    assertEquals((byte) -107, actualToByteArrayResult[134]);
    assertEquals((byte) -119, actualToByteArrayResult[143]);
    assertEquals((byte) -122, actualToByteArrayResult[132]);
    assertEquals((byte) -17, actualToByteArrayResult[146]);
    assertEquals((byte) -38, actualToByteArrayResult[131]);
    assertEquals((byte) -39, actualToByteArrayResult[133]);
    assertEquals((byte) -50, actualToByteArrayResult[137]);
    assertEquals((byte) -60, actualToByteArrayResult[135]);
    assertEquals((byte) -7, actualToByteArrayResult[142]);
    assertEquals((byte) -7, actualToByteArrayResult[145]);
    assertEquals((byte) -80, actualToByteArrayResult[152]);
    assertEquals((byte) -83, actualToByteArrayResult[148]);
    assertEquals((byte) -87, actualToByteArrayResult[136]);
    assertEquals((byte) -88, actualToByteArrayResult[140]);
    assertEquals((byte) -89, actualToByteArrayResult[138]);
    assertEquals((byte) -98, actualToByteArrayResult[149]);
    assertEquals((byte) -9, actualToByteArrayResult[147]);
    assertEquals(155, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[130]);
    assertEquals((byte) 1, actualToByteArrayResult[141]);
    assertEquals((byte) 1, actualToByteArrayResult[154]);
    assertEquals('x', actualToByteArrayResult[139]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray8() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsg msg =
        queueNameResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleNodeId(null)
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[150]);
    assertEquals((byte) -107, actualToByteArrayResult[134]);
    assertEquals((byte) -119, actualToByteArrayResult[143]);
    assertEquals((byte) -122, actualToByteArrayResult[132]);
    assertEquals((byte) -17, actualToByteArrayResult[146]);
    assertEquals((byte) -38, actualToByteArrayResult[131]);
    assertEquals((byte) -39, actualToByteArrayResult[133]);
    assertEquals((byte) -50, actualToByteArrayResult[137]);
    assertEquals((byte) -60, actualToByteArrayResult[135]);
    assertEquals((byte) -7, actualToByteArrayResult[142]);
    assertEquals((byte) -7, actualToByteArrayResult[145]);
    assertEquals((byte) -80, actualToByteArrayResult[152]);
    assertEquals((byte) -83, actualToByteArrayResult[148]);
    assertEquals((byte) -87, actualToByteArrayResult[136]);
    assertEquals((byte) -88, actualToByteArrayResult[140]);
    assertEquals((byte) -89, actualToByteArrayResult[138]);
    assertEquals((byte) -98, actualToByteArrayResult[149]);
    assertEquals((byte) -9, actualToByteArrayResult[147]);
    assertEquals(155, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[130]);
    assertEquals((byte) 1, actualToByteArrayResult[141]);
    assertEquals((byte) 1, actualToByteArrayResult[154]);
    assertEquals('x', actualToByteArrayResult[139]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray9() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[169]);
    assertEquals((byte) -107, actualToByteArrayResult[153]);
    assertEquals((byte) -119, actualToByteArrayResult[162]);
    assertEquals((byte) -122, actualToByteArrayResult[151]);
    assertEquals((byte) -17, actualToByteArrayResult[165]);
    assertEquals((byte) -38, actualToByteArrayResult[150]);
    assertEquals((byte) -39, actualToByteArrayResult[152]);
    assertEquals((byte) -50, actualToByteArrayResult[156]);
    assertEquals((byte) -60, actualToByteArrayResult[154]);
    assertEquals((byte) -7, actualToByteArrayResult[161]);
    assertEquals((byte) -80, actualToByteArrayResult[171]);
    assertEquals((byte) -83, actualToByteArrayResult[167]);
    assertEquals((byte) -87, actualToByteArrayResult[155]);
    assertEquals((byte) -88, actualToByteArrayResult[159]);
    assertEquals((byte) -89, actualToByteArrayResult[157]);
    assertEquals((byte) -98, actualToByteArrayResult[163]);
    assertEquals((byte) -98, actualToByteArrayResult[168]);
    assertEquals((byte) -9, actualToByteArrayResult[166]);
    assertEquals(174, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[160]);
    assertEquals((byte) 1, actualToByteArrayResult[170]);
    assertEquals('x', actualToByteArrayResult[158]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray10() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type(TbMsg.EMPTY_STRING)
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[165]);
    assertEquals((byte) -107, actualToByteArrayResult[149]);
    assertEquals((byte) -119, actualToByteArrayResult[158]);
    assertEquals((byte) -122, actualToByteArrayResult[147]);
    assertEquals((byte) -17, actualToByteArrayResult[161]);
    assertEquals((byte) -38, actualToByteArrayResult[146]);
    assertEquals((byte) -39, actualToByteArrayResult[148]);
    assertEquals((byte) -50, actualToByteArrayResult[152]);
    assertEquals((byte) -60, actualToByteArrayResult[150]);
    assertEquals((byte) -7, actualToByteArrayResult[157]);
    assertEquals((byte) -7, actualToByteArrayResult[160]);
    assertEquals((byte) -80, actualToByteArrayResult[167]);
    assertEquals((byte) -83, actualToByteArrayResult[163]);
    assertEquals((byte) -87, actualToByteArrayResult[151]);
    assertEquals((byte) -88, actualToByteArrayResult[155]);
    assertEquals((byte) -89, actualToByteArrayResult[153]);
    assertEquals((byte) -98, actualToByteArrayResult[159]);
    assertEquals((byte) -98, actualToByteArrayResult[164]);
    assertEquals((byte) -9, actualToByteArrayResult[162]);
    assertEquals(170, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[145]);
    assertEquals((byte) 1, actualToByteArrayResult[156]);
    assertEquals((byte) 1, actualToByteArrayResult[166]);
    assertEquals((byte) 1, actualToByteArrayResult[168]);
    assertEquals((byte) 1, actualToByteArrayResult[169]);
    assertEquals('x', actualToByteArrayResult[154]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred eighty-second element is minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred eighty-second element is minus one hundred four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredEightySecondElementIsMinusOneHundredFour() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(
                new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[181]);
    assertEquals((byte) -107, actualToByteArrayResult[165]);
    assertEquals((byte) -119, actualToByteArrayResult[174]);
    assertEquals((byte) -122, actualToByteArrayResult[163]);
    assertEquals((byte) -17, actualToByteArrayResult[177]);
    assertEquals((byte) -38, actualToByteArrayResult[162]);
    assertEquals((byte) -39, actualToByteArrayResult[164]);
    assertEquals((byte) -50, actualToByteArrayResult[168]);
    assertEquals((byte) -60, actualToByteArrayResult[166]);
    assertEquals((byte) -7, actualToByteArrayResult[173]);
    assertEquals((byte) -7, actualToByteArrayResult[176]);
    assertEquals((byte) -80, actualToByteArrayResult[183]);
    assertEquals((byte) -83, actualToByteArrayResult[179]);
    assertEquals((byte) -87, actualToByteArrayResult[167]);
    assertEquals((byte) -88, actualToByteArrayResult[171]);
    assertEquals((byte) -89, actualToByteArrayResult[169]);
    assertEquals((byte) -98, actualToByteArrayResult[175]);
    assertEquals((byte) -98, actualToByteArrayResult[180]);
    assertEquals((byte) -9, actualToByteArrayResult[178]);
    assertEquals(186, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[161]);
    assertEquals((byte) 1, actualToByteArrayResult[182]);
    assertEquals('x', actualToByteArrayResult[170]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred eighty-third element is minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred eighty-third element is minus one hundred four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredEightyThirdElementIsMinusOneHundredFour() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(-1));
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[182]);
    assertEquals((byte) -107, actualToByteArrayResult[166]);
    assertEquals((byte) -119, actualToByteArrayResult[175]);
    assertEquals((byte) -122, actualToByteArrayResult[164]);
    assertEquals((byte) -17, actualToByteArrayResult[178]);
    assertEquals((byte) -38, actualToByteArrayResult[163]);
    assertEquals((byte) -39, actualToByteArrayResult[165]);
    assertEquals((byte) -50, actualToByteArrayResult[169]);
    assertEquals((byte) -60, actualToByteArrayResult[167]);
    assertEquals((byte) -7, actualToByteArrayResult[174]);
    assertEquals((byte) -7, actualToByteArrayResult[177]);
    assertEquals((byte) -80, actualToByteArrayResult[184]);
    assertEquals((byte) -83, actualToByteArrayResult[180]);
    assertEquals((byte) -87, actualToByteArrayResult[168]);
    assertEquals((byte) -88, actualToByteArrayResult[172]);
    assertEquals((byte) -89, actualToByteArrayResult[170]);
    assertEquals((byte) -98, actualToByteArrayResult[176]);
    assertEquals((byte) -98, actualToByteArrayResult[181]);
    assertEquals((byte) -9, actualToByteArrayResult[179]);
    assertEquals(187, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[183]);
    assertEquals((byte) 1, actualToByteArrayResult[186]);
    assertEquals('x', actualToByteArrayResult[171]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred fifty-third element is minus thirty-eight.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred fifty-third element is minus thirty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredFiftyThirdElementIsMinusThirtyEight() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -38, actualToByteArrayResult[152]);
    assertEquals((byte) -80, actualToByteArrayResult[173]);
    assertEquals(176, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[175]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred forty-eighth element is minus one hundred two.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred forty-eighth element is minus one hundred two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredFortyEighthElementIsMinusOneHundredTwo() {
    // Arrange
    TbMsgBuilder correlationIdResult =
        TbMsg.builder().callback(TbMsgCallback.EMPTY).correlationId(null);
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -102, actualToByteArrayResult[147]);
    assertEquals((byte) -104, actualToByteArrayResult[145]);
    assertEquals((byte) -107, actualToByteArrayResult[129]);
    assertEquals((byte) -112, actualToByteArrayResult[135]);
    assertEquals((byte) -119, actualToByteArrayResult[138]);
    assertEquals((byte) -17, actualToByteArrayResult[141]);
    assertEquals((byte) -39, actualToByteArrayResult[128]);
    assertEquals((byte) -50, actualToByteArrayResult[132]);
    assertEquals((byte) -60, actualToByteArrayResult[130]);
    assertEquals((byte) -7, actualToByteArrayResult[137]);
    assertEquals((byte) -83, actualToByteArrayResult[143]);
    assertEquals((byte) -87, actualToByteArrayResult[131]);
    assertEquals((byte) -89, actualToByteArrayResult[133]);
    assertEquals((byte) -98, actualToByteArrayResult[139]);
    assertEquals((byte) -9, actualToByteArrayResult[142]);
    assertEquals(153, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[136]);
    assertEquals((byte) 1, actualToByteArrayResult[146]);
    assertEquals('x', actualToByteArrayResult[134]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred forty-ninth element is minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred forty-ninth element is minus one hundred four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredFortyNinthElementIsMinusOneHundredFour() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[148]);
    assertEquals((byte) -107, actualToByteArrayResult[132]);
    assertEquals((byte) -119, actualToByteArrayResult[141]);
    assertEquals((byte) -122, actualToByteArrayResult[130]);
    assertEquals((byte) -17, actualToByteArrayResult[144]);
    assertEquals((byte) -38, actualToByteArrayResult[129]);
    assertEquals((byte) -39, actualToByteArrayResult[131]);
    assertEquals((byte) -50, actualToByteArrayResult[135]);
    assertEquals((byte) -60, actualToByteArrayResult[133]);
    assertEquals((byte) -7, actualToByteArrayResult[143]);
    assertEquals((byte) -83, actualToByteArrayResult[146]);
    assertEquals((byte) -87, actualToByteArrayResult[134]);
    assertEquals((byte) -88, actualToByteArrayResult[138]);
    assertEquals((byte) -89, actualToByteArrayResult[136]);
    assertEquals((byte) -98, actualToByteArrayResult[142]);
    assertEquals((byte) -98, actualToByteArrayResult[147]);
    assertEquals((byte) -9, actualToByteArrayResult[145]);
    assertEquals(153, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[128]);
    assertEquals((byte) 1, actualToByteArrayResult[139]);
    assertEquals('x', actualToByteArrayResult[137]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred seventy-eighth element is two.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg); then return one hundred seventy-eighth element is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredSeventyEighthElementIsTwo() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(32768)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -80, actualToByteArrayResult[173]);
    assertEquals(178, actualToByteArrayResult.length);
    assertEquals((byte) 2, actualToByteArrayResult[177]);
    assertEquals(Byte.MIN_VALUE, actualToByteArrayResult[175]);
    assertEquals(Byte.MIN_VALUE, actualToByteArrayResult[176]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred seventy-sixth element is minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred seventy-sixth element is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredSeventySixthElementIsMinusOne() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(-1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -1, actualToByteArrayResult[175]);
    assertEquals((byte) -1, actualToByteArrayResult[176]);
    assertEquals((byte) -1, actualToByteArrayResult[177]);
    assertEquals((byte) -1, actualToByteArrayResult[178]);
    assertEquals((byte) -1, actualToByteArrayResult[179]);
    assertEquals((byte) -1, actualToByteArrayResult[180]);
    assertEquals((byte) -1, actualToByteArrayResult[181]);
    assertEquals((byte) -1, actualToByteArrayResult[182]);
    assertEquals((byte) -1, actualToByteArrayResult[183]);
    assertEquals(185, actualToByteArrayResult.length);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred seventy-third element is minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred seventy-third element is minus one hundred four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredSeventyThirdElementIsMinusOneHundredFour() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(8192L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[172]);
    assertEquals((byte) -107, actualToByteArrayResult[156]);
    assertEquals((byte) -119, actualToByteArrayResult[165]);
    assertEquals((byte) -122, actualToByteArrayResult[154]);
    assertEquals((byte) -17, actualToByteArrayResult[168]);
    assertEquals((byte) -38, actualToByteArrayResult[153]);
    assertEquals((byte) -39, actualToByteArrayResult[155]);
    assertEquals((byte) -50, actualToByteArrayResult[159]);
    assertEquals((byte) -60, actualToByteArrayResult[157]);
    assertEquals((byte) -7, actualToByteArrayResult[167]);
    assertEquals((byte) -80, actualToByteArrayResult[174]);
    assertEquals((byte) -83, actualToByteArrayResult[170]);
    assertEquals((byte) -87, actualToByteArrayResult[158]);
    assertEquals((byte) -88, actualToByteArrayResult[162]);
    assertEquals((byte) -89, actualToByteArrayResult[160]);
    assertEquals((byte) -98, actualToByteArrayResult[166]);
    assertEquals((byte) -98, actualToByteArrayResult[171]);
    assertEquals((byte) -9, actualToByteArrayResult[169]);
    assertEquals(177, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[163]);
    assertEquals('x', actualToByteArrayResult[161]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return two hundred sixteenth element is minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return two hundred sixteenth element is minus one hundred four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnTwoHundredSixteenthElementIsMinusOneHundredFour() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[215]);
    assertEquals((byte) -107, actualToByteArrayResult[199]);
    assertEquals((byte) -119, actualToByteArrayResult[208]);
    assertEquals((byte) -122, actualToByteArrayResult[197]);
    assertEquals((byte) -17, actualToByteArrayResult[211]);
    assertEquals((byte) -38, actualToByteArrayResult[196]);
    assertEquals((byte) -39, actualToByteArrayResult[198]);
    assertEquals((byte) -50, actualToByteArrayResult[202]);
    assertEquals((byte) -60, actualToByteArrayResult[200]);
    assertEquals((byte) -7, actualToByteArrayResult[207]);
    assertEquals((byte) -7, actualToByteArrayResult[210]);
    assertEquals((byte) -80, actualToByteArrayResult[217]);
    assertEquals((byte) -83, actualToByteArrayResult[213]);
    assertEquals((byte) -87, actualToByteArrayResult[201]);
    assertEquals((byte) -88, actualToByteArrayResult[205]);
    assertEquals((byte) -89, actualToByteArrayResult[203]);
    assertEquals((byte) -98, actualToByteArrayResult[209]);
    assertEquals((byte) -98, actualToByteArrayResult[214]);
    assertEquals((byte) -9, actualToByteArrayResult[212]);
    assertEquals((byte) 1, actualToByteArrayResult[195]);
    assertEquals((byte) 1, actualToByteArrayResult[206]);
    assertEquals((byte) 1, actualToByteArrayResult[216]);
    assertEquals((byte) 1, actualToByteArrayResult[218]);
    assertEquals((byte) 1, actualToByteArrayResult[219]);
    assertEquals(220, actualToByteArrayResult.length);
    assertEquals('x', actualToByteArrayResult[204]);
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when '0XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_when0xaxaxaxBytesIsUtf8_thenThrowIllegalStateException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "0XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when '8XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_when8xaxaxaxBytesIsUtf8_thenThrowIllegalStateException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "8XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with eighteen and two; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithEighteenAndTwo_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {18, 2, 'A', 'X', 'A', 'X', 'A', 'X'},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with eighteen and 'X'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithEighteenAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and two.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with lf and two; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithLfAndTwo_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with minus one and 'X'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithMinusOneAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with twenty-six and two; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithTwentySixAndTwo_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {26, 2, 'A', 'X', 'A', 'X', 'A', 'X'},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with twenty-six and 'X'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithTwentySixAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with two and 'X'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithTwoAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalStateException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "AXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when 'XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "\nXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when 'XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", " XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when '(XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "(XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When {@code @XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when '@XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException4()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "@XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when 'XXAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXxaxaxaxBytesIsUtf8_thenThrowIllegalStateException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "XXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId)} with {@code ruleChainId}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId) with 'ruleChainId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId)"})
  void testCopyWithRuleChainIdWithRuleChainId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        customerId,
        buildResult
            .copyWithRuleChainId(
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId)} with {@code ruleChainId}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId) with 'ruleChainId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId)"})
  void testCopyWithRuleChainIdWithRuleChainId2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        customerId,
        buildResult
            .copyWithRuleChainId(
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId)} with {@code ruleChainId}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId) with 'ruleChainId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId)"})
  void testCopyWithRuleChainIdWithRuleChainId3() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(
        originator,
        buildResult
            .copyWithRuleChainId(
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)} with {@code ruleChainId}, {@code
   * msgId}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId, UUID) with 'ruleChainId', 'msgId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId, UUID)"})
  void testCopyWithRuleChainIdWithRuleChainIdMsgId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        buildResult
            .copyWithRuleChainId(
                ruleChainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)} with {@code ruleChainId}, {@code
   * msgId}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId, UUID) with 'ruleChainId', 'msgId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId, UUID)"})
  void testCopyWithRuleChainIdWithRuleChainIdMsgId2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        buildResult
            .copyWithRuleChainId(
                ruleChainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)} with {@code ruleChainId}, {@code
   * msgId}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId, UUID) with 'ruleChainId', 'msgId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId, UUID)"})
  void testCopyWithRuleChainIdWithRuleChainIdMsgId3() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        buildResult
            .copyWithRuleChainId(
                ruleChainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)} with {@code ruleChainId}, {@code
   * msgId}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)}
   */
  @Test
  @DisplayName(
      "Test copyWithRuleChainId(RuleChainId, UUID) with 'ruleChainId', 'msgId'; then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId, UUID)"})
  void testCopyWithRuleChainIdWithRuleChainIdMsgId_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualCopyWithRuleChainIdResult =
        buildResult.copyWithRuleChainId(
            ruleChainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertEquals(TbMsgType.NA, actualCopyWithRuleChainIdResult.getInternalType());
    assertSame(customerId, actualCopyWithRuleChainIdResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId)} with {@code ruleChainId}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId)}
   */
  @Test
  @DisplayName(
      "Test copyWithRuleChainId(RuleChainId) with 'ruleChainId'; then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId)"})
  void testCopyWithRuleChainIdWithRuleChainId_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualCopyWithRuleChainIdResult =
        buildResult.copyWithRuleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(TbMsgType.NA, actualCopyWithRuleChainIdResult.getInternalType());
    assertSame(customerId, actualCopyWithRuleChainIdResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(
        buildResult,
        buildResult.copyWithRuleNodeId(
            ruleChainId, ruleNodeId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(
        buildResult,
        buildResult.copyWithRuleNodeId(
            ruleChainId, ruleNodeId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId3() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(
        buildResult,
        buildResult.copyWithRuleNodeId(
            ruleChainId, ruleNodeId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName(
      "Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID); then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualCopyWithRuleNodeIdResult =
        buildResult.copyWithRuleNodeId(
            ruleChainId, ruleNodeId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertEquals(TbMsgType.NA, actualCopyWithRuleNodeIdResult.getInternalType());
    assertSame(customerId, actualCopyWithRuleNodeIdResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, buildResult.copyWithNewCtx().getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(0L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(customerId, buildResult.copyWithNewCtx().getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx3() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, ruleNodeId);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualCopyWithNewCtxResult = buildResult.copyWithNewCtx();

    // Assert
    assertEquals(ruleChainId, actualCopyWithNewCtxResult.getRuleChainId());
    assertEquals(ruleNodeId, actualCopyWithNewCtxResult.getRuleNodeId());
    assertSame(customerId, actualCopyWithNewCtxResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertSame(originator, buildResult.copyWithNewCtx().getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx(); then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx_thenReturnCustomerIdIsNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        correlationIdResult
            .ctx(new TbMsgProcessingCtx())
            .customerId(null)
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualCopyWithNewCtxResult = buildResult.copyWithNewCtx();

    // Assert
    assertNull(actualCopyWithNewCtxResult.getCustomerId());
    assertNull(actualCopyWithNewCtxResult.getOriginator());
    assertEquals(1L, actualCopyWithNewCtxResult.getMetaDataTs());
    assertEquals(1L, actualCopyWithNewCtxResult.getTs());
    assertEquals(TbMsgType.POST_ATTRIBUTES_REQUEST, actualCopyWithNewCtxResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <ul>
   *   <li>Then return InternalType is {@code NA}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx(); then return InternalType is 'NA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx_thenReturnInternalTypeIsNa() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder dataTypeResult =
        ctxResult.customerId(customerId).data("Data").dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(null)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsg actualCopyWithNewCtxResult = buildResult.copyWithNewCtx();

    // Assert
    assertEquals(TbMsgType.NA, actualCopyWithNewCtxResult.getInternalType());
    assertSame(customerId, actualCopyWithNewCtxResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#getCallback()}.
   *
   * <ul>
   *   <li>Then return MsgValid.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#getCallback()}
   */
  @Test
  @DisplayName("Test getCallback(); then return MsgValid")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgCallback TbMsg.getCallback()"})
  void testGetCallback_thenReturnMsgValid() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertTrue(buildResult.getCallback().isMsgValid());
  }

  /**
   * Test {@link TbMsg#popFormStack()}.
   *
   * <p>Method under test: {@link TbMsg#popFormStack()}
   */
  @Test
  @DisplayName("Test popFormStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsg.popFormStack()"})
  void testPopFormStack() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, ruleNodeId);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsgProcessingStackItem actualPopFormStackResult = buildResult.popFormStack();

    // Assert
    assertSame(ruleChainId, actualPopFormStackResult.getRuleChainId());
    assertSame(ruleNodeId, actualPopFormStackResult.getRuleNodeId());
  }

  /**
   * Test {@link TbMsg#popFormStack()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#popFormStack()}
   */
  @Test
  @DisplayName("Test popFormStack(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsg.popFormStack()"})
  void testPopFormStack_thenReturnNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertNull(buildResult.popFormStack());
  }

  /**
   * Test {@link TbMsg#isValid()}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#isMsgValid()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#isValid()}
   */
  @Test
  @DisplayName(
      "Test isValid(); given TbMsgCallback isMsgValid() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isValid()"})
  void testIsValid_givenTbMsgCallbackIsMsgValidReturnFalse_thenReturnFalse() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenReturn(false);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    boolean actualIsValidResult = buildResult.isValid();

    // Assert
    verify(callback).isMsgValid();
    assertFalse(actualIsValidResult);
  }

  /**
   * Test {@link TbMsg#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isValid()"})
  void testIsValid_thenReturnTrue() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertTrue(buildResult.isValid());
  }

  /**
   * Test {@link TbMsg#isValid()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isValid()"})
  void testIsValid_thenThrowIllegalStateException() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenThrow(new IllegalStateException("foo"));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> buildResult.isValid());
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link TbMsg#getMetaDataTs()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#getMetaDataTs()}
   */
  @Test
  @DisplayName("Test getMetaDataTs(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbMsg.getMetaDataTs()"})
  void testGetMetaDataTs_thenReturnOne() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(1L, buildResult.getMetaDataTs());
  }

  /**
   * Test {@link TbMsg#isTypeOf(TbMsgType)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#isTypeOf(TbMsgType)}
   */
  @Test
  @DisplayName("Test isTypeOf(TbMsgType); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isTypeOf(TbMsgType)"})
  void testIsTypeOf_thenReturnFalse() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_TELEMETRY_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertFalse(buildResult.isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Test {@link TbMsg#isTypeOf(TbMsgType)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#isTypeOf(TbMsgType)}
   */
  @Test
  @DisplayName("Test isTypeOf(TbMsgType); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isTypeOf(TbMsgType)"})
  void testIsTypeOf_thenReturnTrue() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertTrue(buildResult.isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Test {@link TbMsg#isTypeOneOf(TbMsgType[])}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#isTypeOneOf(TbMsgType[])}
   */
  @Test
  @DisplayName("Test isTypeOneOf(TbMsgType[]); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isTypeOneOf(TbMsgType[])"})
  void testIsTypeOneOf_thenReturnFalse() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_TELEMETRY_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertFalse(buildResult.isTypeOneOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Test {@link TbMsg#isTypeOneOf(TbMsgType[])}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#isTypeOneOf(TbMsgType[])}
   */
  @Test
  @DisplayName("Test isTypeOneOf(TbMsgType[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isTypeOneOf(TbMsgType[])"})
  void testIsTypeOneOf_thenReturnTrue() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg buildResult =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertTrue(buildResult.isTypeOneOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }
}
