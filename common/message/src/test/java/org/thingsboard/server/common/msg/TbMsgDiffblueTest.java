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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(
        0,
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getAndIncrementRuleNodeCounter());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", (EntityId) null, customerId, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString4() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, null, metaData, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code
   * String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString_givenValue() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, null, metaData, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", null, customerId, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString4() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, null, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString5() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, null, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataString() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, metaData, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY);

    // Assert
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)} with {@code
   * String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code TbMsgCallback}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String,
   * TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, metaData, "Data", TbMsgCallback.EMPTY);

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)} with {@code
   * String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code TbMsgCallback}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String,
   * TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, metaData, "Data", TbMsgCallback.EMPTY);

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)} with {@code String}, {@code
   * EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, String) with 'String', 'EntityId', 'TbMsgMetaData', 'String'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataString_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, metaData, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)} with {@code String}, {@code
   * EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Then return MetaData is {@link TbMsgMetaData#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, String) with 'String', 'EntityId', 'TbMsgMetaData', 'String'; then return MetaData is EMPTY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataString_thenReturnMetaDataIsEmpty() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)} with {@code
   * String}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeString3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Type",
            originator,
            metaData,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId4() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Type",
            originator,
            metaData,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)} with {@code
   * String}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeString_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", null, customerId, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString4() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", originator, null, metaData, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            null,
            customerId,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            null,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
            "Queue Name",
            "Type",
            originator,
            null,
            TbMsgMetaData.EMPTY,
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
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString_givenValue() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", originator, null, metaData, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString() {
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
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)} with {@code String},
   * {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", originator, metaData, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            metaData,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId4() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            metaData,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)} with {@code String},
   * {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", originator, metaData, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)} with {@code String},
   * {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Then return MetaData is {@link TbMsgMetaData#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'; then return MetaData is EMPTY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString_thenReturnMetaDataIsEmpty() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            null,
            customerId,
            TbMsgMetaData.EMPTY,
            "Data");

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            null,
            TbMsgMetaData.EMPTY,
            "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            null,
            TbMsgMetaData.EMPTY,
            "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            null,
            customerId,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            null,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            null,
            TbMsgType.POST_ATTRIBUTES_REQUEST,
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
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with {@code
   * String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data");

    // Assert
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with {@code
   * String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with {@code
   * String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId() {
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            tbMsg2,
            "Queue Name",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId2() {
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
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            tbMsg2,
            "Queue Name",
            ruleChainId,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId2 =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            tbMsg2,
            "Queue Name",
            ruleChainId2,
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, TbMsgMetaData.EMPTY, "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            null,
            customerId,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data");

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            null,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            null,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString() {
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
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with {@code TbMsgType},
   * {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong() {
    // Arrange and Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", 0L);

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong2() {
    // Arrange and Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", 1L);

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertEquals(1L, actualNewMsgResult.getMetaDataTs());
    assertEquals(1L, actualNewMsgResult.getTs());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", 1L);

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong4() {
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
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong5() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data", 1L);

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code
   * TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data", 1L);

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            TbMsgCallback.EMPTY);

    // Assert
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data", TbMsgCallback.EMPTY);

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)} with
   * {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code
   * TbMsgCallback}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String,
   * TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data", TbMsgCallback.EMPTY);

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with {@code TbMsgType},
   * {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with {@code TbMsgType},
   * {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <ul>
   *   <li>Then return MetaData is {@link TbMsgMetaData#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'; then return MetaData is EMPTY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString_thenReturnMetaDataIsEmpty() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data");

    // Assert
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeString3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)} with
   * {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code
   * String}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'; given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeString_givenValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString() {
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(
            tbMsg2,
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "Queue Name");

    // Assert
    assertSame(customerId, actualTransformMsgResult.getCustomerId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString2() {
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
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(
            tbMsg2,
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "Queue Name");

    // Assert
    assertSame(originator, actualTransformMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(
            tbMsg2,
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "Queue Name");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString() {
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgResult = TbMsg.transformMsg(tbMsg2, TbMsgMetaData.EMPTY, "Data");

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString2() {
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

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(TbMsg.transformMsgCustomerId(tbMsg, null), TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertSame(originator, actualTransformMsgResult.getOriginator());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgResult = TbMsg.transformMsg(tbMsg2, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(ruleChainId, actualTransformMsgResult.getRuleChainId());
    assertEquals(ruleNodeId, actualTransformMsgResult.getRuleNodeId());
    assertSame(customerId, actualTransformMsgResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData() {
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgData(tbMsg2, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData2() {
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
    assertSame(
        originator,
        TbMsg.transformMsgData(TbMsg.transformMsgCustomerId(tbMsg, null), "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgDataResult = TbMsg.transformMsgData(tbMsg2, "Data");

    // Assert
    assertEquals(ruleChainId, actualTransformMsgDataResult.getRuleChainId());
    assertEquals(ruleNodeId, actualTransformMsgDataResult.getRuleNodeId());
    assertSame(customerId, actualTransformMsgDataResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata() {
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgMetadata(tbMsg2, TbMsgMetaData.EMPTY).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata2() {
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
    assertSame(
        originator,
        TbMsg.transformMsgMetadata(TbMsg.transformMsgCustomerId(tbMsg, null), TbMsgMetaData.EMPTY)
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgMetadataResult =
        TbMsg.transformMsgMetadata(tbMsg2, TbMsgMetaData.EMPTY);

    // Assert
    assertEquals(ruleChainId, actualTransformMsgMetadataResult.getRuleChainId());
    assertEquals(ruleNodeId, actualTransformMsgMetadataResult.getRuleNodeId());
    assertSame(customerId, actualTransformMsgMetadataResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg2 = TbMsg.transformMsgData(tbMsg, "Data");
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg2, customerId).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        TbMsg.transformMsgCustomerId(TbMsg.transformMsgData(tbMsg, "Data"), null).getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg2 = TbMsg.transformMsgData(tbMsg, "Data");
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualTransformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg2, customerId);

    // Assert
    assertEquals(ruleChainId, actualTransformMsgCustomerIdResult.getRuleChainId());
    assertEquals(ruleNodeId, actualTransformMsgCustomerIdResult.getRuleNodeId());
    assertSame(customerId, actualTransformMsgCustomerIdResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId() {
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgRuleChainId(
                tbMsg2, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId2() {
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
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act and Assert
    assertSame(
        originator,
        TbMsg.transformMsgRuleChainId(
                tbMsg2, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgRuleChainId(
                tbMsg2, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName() {
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgQueueName(tbMsg2, "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName2() {
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
    assertSame(
        originator,
        TbMsg.transformMsgQueueName(TbMsg.transformMsgCustomerId(tbMsg, null), "Queue Name")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgQueueNameResult = TbMsg.transformMsgQueueName(tbMsg2, "Queue Name");

    // Assert
    assertEquals(ruleChainId, actualTransformMsgQueueNameResult.getRuleChainId());
    assertSame(customerId, actualTransformMsgQueueNameResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray() {
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    TbMsg msg =
        TbMsg.transformMsgCustomerId(
            tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
    assertEquals((byte) -98, actualToByteArrayResult[144]);
    assertEquals((byte) -98, actualToByteArrayResult[149]);
    assertEquals((byte) -9, actualToByteArrayResult[147]);
    assertEquals(155, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[130]);
    assertEquals((byte) 1, actualToByteArrayResult[141]);
    assertEquals((byte) 1, actualToByteArrayResult[153]);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        queueNameResult
            .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ruleNodeId(null)
            .ts(1L)
            .type("Type")
            .build();
    TbMsg msg =
        TbMsg.transformMsgCustomerId(
            tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
    assertEquals((byte) -98, actualToByteArrayResult[144]);
    assertEquals((byte) -98, actualToByteArrayResult[149]);
    assertEquals((byte) -9, actualToByteArrayResult[147]);
    assertEquals(155, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[130]);
    assertEquals((byte) 1, actualToByteArrayResult[141]);
    assertEquals((byte) 1, actualToByteArrayResult[153]);
    assertEquals((byte) 1, actualToByteArrayResult[154]);
    assertEquals('x', actualToByteArrayResult[139]);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    TbMsg msg =
        TbMsg.transformMsgCustomerId(
            tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
    assertEquals((byte) 1, actualToByteArrayResult[184]);
    assertEquals((byte) 1, actualToByteArrayResult[185]);
    assertEquals('x', actualToByteArrayResult[170]);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredFortyNinthElementIsMinusOneHundredFour() {
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(TbMsg.transformMsgCustomerId(tbMsg, null));

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
    assertEquals((byte) -7, actualToByteArrayResult[140]);
    assertEquals((byte) -7, actualToByteArrayResult[143]);
    assertEquals((byte) -80, actualToByteArrayResult[150]);
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
    assertEquals((byte) 1, actualToByteArrayResult[152]);
    assertEquals('x', actualToByteArrayResult[137]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred seventieth element is minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred seventieth element is minus one hundred four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredSeventiethElementIsMinusOneHundredFour() {
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    TbMsg msg =
        TbMsg.transformMsgCustomerId(
            tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
    assertEquals((byte) -7, actualToByteArrayResult[164]);
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
    assertEquals((byte) 1, actualToByteArrayResult[173]);
    assertEquals('x', actualToByteArrayResult[158]);
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then return one hundred seventy-second element is minus one hundred four.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); then return one hundred seventy-second element is minus one hundred four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenReturnOneHundredSeventySecondElementIsMinusOneHundredFour() {
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    TbMsg msg =
        TbMsg.transformMsgCustomerId(
            tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    byte[] actualToByteArrayResult = TbMsg.toByteArray(msg);

    // Assert
    assertEquals((byte) -104, actualToByteArrayResult[171]);
    assertEquals((byte) -107, actualToByteArrayResult[155]);
    assertEquals((byte) -119, actualToByteArrayResult[164]);
    assertEquals((byte) -122, actualToByteArrayResult[153]);
    assertEquals((byte) -17, actualToByteArrayResult[167]);
    assertEquals((byte) -38, actualToByteArrayResult[152]);
    assertEquals((byte) -39, actualToByteArrayResult[154]);
    assertEquals((byte) -50, actualToByteArrayResult[158]);
    assertEquals((byte) -60, actualToByteArrayResult[156]);
    assertEquals((byte) -7, actualToByteArrayResult[163]);
    assertEquals((byte) -7, actualToByteArrayResult[166]);
    assertEquals((byte) -80, actualToByteArrayResult[173]);
    assertEquals((byte) -83, actualToByteArrayResult[169]);
    assertEquals((byte) -87, actualToByteArrayResult[157]);
    assertEquals((byte) -88, actualToByteArrayResult[161]);
    assertEquals((byte) -89, actualToByteArrayResult[159]);
    assertEquals((byte) -98, actualToByteArrayResult[165]);
    assertEquals((byte) -98, actualToByteArrayResult[170]);
    assertEquals((byte) -9, actualToByteArrayResult[168]);
    assertEquals(176, actualToByteArrayResult.length);
    assertEquals((byte) 1, actualToByteArrayResult[162]);
    assertEquals((byte) 1, actualToByteArrayResult[174]);
    assertEquals((byte) 1, actualToByteArrayResult[175]);
    assertEquals('x', actualToByteArrayResult[160]);
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 0} and minus one.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with '0' and minus one; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWith0AndMinusOne_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {'0', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 8} and minus one.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with '8' and minus one; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWith8AndMinusOne_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {'8', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1},
                TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(String, byte[], TbMsgCallback); when array of byte with 'A' and minus one; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithAAndMinusOne_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.fromBytes(
                "Queue Name",
                new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1},
                TbMsgCallback.EMPTY));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "(XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId)} with {@code ruleChainId}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId) with 'ruleChainId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId)"})
  void testCopyWithRuleChainIdWithRuleChainId() {
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

    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(
        customerId,
        transformMsgCustomerIdResult
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId)"})
  void testCopyWithRuleChainIdWithRuleChainId2() {
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
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act and Assert
    assertSame(
        originator,
        transformMsgCustomerIdResult
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId, UUID)"})
  void testCopyWithRuleChainIdWithRuleChainIdMsgId() {
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

    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        customerId,
        transformMsgCustomerIdResult
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId, UUID)"})
  void testCopyWithRuleChainIdWithRuleChainIdMsgId2() {
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
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        originator,
        transformMsgCustomerIdResult
            .copyWithRuleChainId(
                ruleChainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    TbMsg transformMsgCustomerIdResult =
        TbMsg.transformMsgCustomerId(
            tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualCopyWithRuleNodeIdResult =
        transformMsgCustomerIdResult.copyWithRuleNodeId(
            ruleChainId, ruleNodeId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertEquals(transformMsgCustomerIdResult, actualCopyWithRuleNodeIdResult);
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId2() {
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
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualCopyWithRuleNodeIdResult =
        transformMsgCustomerIdResult.copyWithRuleNodeId(
            ruleChainId, ruleNodeId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertEquals(transformMsgCustomerIdResult, actualCopyWithRuleNodeIdResult);
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId3() {
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualCopyWithRuleNodeIdResult =
        transformMsgCustomerIdResult.copyWithRuleNodeId(
            ruleChainId, ruleNodeId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertEquals(transformMsgCustomerIdResult, actualCopyWithRuleNodeIdResult);
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx() {
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
    assertSame(
        customerId,
        TbMsg.transformMsgCustomerId(tbMsg, customerId).copyWithNewCtx().getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx2() {
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
    assertSame(
        originator, TbMsg.transformMsgCustomerId(tbMsg, null).copyWithNewCtx().getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg actualCopyWithNewCtxResult =
        TbMsg.transformMsgCustomerId(tbMsg, customerId).copyWithNewCtx();

    // Assert
    assertEquals(ruleChainId, actualCopyWithNewCtxResult.getRuleChainId());
    assertEquals(ruleNodeId, actualCopyWithNewCtxResult.getRuleNodeId());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertTrue(
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getCallback()
            .isMsgValid());
  }

  /**
   * Test {@link TbMsg#popFormStack()}.
   *
   * <p>Method under test: {@link TbMsg#popFormStack()}
   */
  @Test
  @DisplayName("Test popFormStack()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    TbMsgProcessingStackItem actualPopFormStackResult =
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .popFormStack();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertNull(
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .popFormStack());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act
    boolean actualIsValidResult =
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isValid();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertTrue(
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isValid());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbMsg.isValid()"})
  void testIsValid_thenThrowIllegalStateException() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenThrow(new IllegalStateException());

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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            TbMsg.transformMsgCustomerId(
                    tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .isValid());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(
        1L,
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .getMetaDataTs());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertFalse(
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertTrue(
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Test {@link TbMsg#isTypeOneOf(TbMsgType[])}.
   *
   * <p>Method under test: {@link TbMsg#isTypeOneOf(TbMsgType[])}
   */
  @Test
  @DisplayName("Test isTypeOneOf(TbMsgType[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbMsg.isTypeOneOf(TbMsgType[])"})
  void testIsTypeOneOf() {
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertFalse(
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isTypeOneOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertFalse(
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isTypeOneOf());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    // Act and Assert
    assertTrue(
        TbMsg.transformMsgCustomerId(
                tbMsg, new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isTypeOneOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }
}
