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
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#getAndIncrementRuleNodeCounter()}
   */
  @Test
  @DisplayName("Test getAndIncrementRuleNodeCounter(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbMsg.getAndIncrementRuleNodeCounter()"})
  void testGetAndIncrementRuleNodeCounter_thenReturnZero() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertEquals(0,
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).getAndIncrementRuleNodeCounter());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.newMsg("Type", (EntityId) null, customerId, TbMsgMetaData.EMPTY, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator, TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("org.thingsboard.server.common.msg.TbMsg", originator, null,
        TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals("org.thingsboard.server.common.msg.TbMsg", actualNewMsgResult.getType());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)} with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.newMsg("Type", null, customerId, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)} with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)} with {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("org.thingsboard.server.common.msg.TbMsg", originator, null,
        TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals("org.thingsboard.server.common.msg.TbMsg", actualNewMsgResult.getType());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String) with 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator, TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String) with 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code TbMsgCallback}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY).getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code TbMsgCallback}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY);

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg
            .newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data", ruleChainId,
                new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)} with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data",
        ruleChainId, new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.newMsg("Queue Name", "Type", null, customerId, TbMsgMetaData.EMPTY, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(null, "Type", originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertNull(actualNewMsgResult.getQueueName());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg
            .newMsg("Queue Name", "Type", null, customerId, TbMsgMetaData.EMPTY, "Data", ruleChainId,
                new RuleNodeId(UUID.randomUUID()))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg
            .newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data", ruleChainId,
                new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(null, "Type", originator, null, TbMsgMetaData.EMPTY, "Data", ruleChainId,
        new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertNull(actualNewMsgResult.getQueueName());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)} with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator, TbMsg.newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)} with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg
            .newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data", ruleChainId,
                new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data", ruleChainId,
        new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, TbMsgMetaData.EMPTY, "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg
            .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, TbMsgMetaData.EMPTY, "Data",
                ruleChainId, new RuleNodeId(UUID.randomUUID()))
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg
            .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data",
                ruleChainId, new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg
            .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data",
                ruleChainId, new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        TbMsgMetaData.EMPTY, "Data", ruleChainId, new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.newMsg(tbMsg2, "Queue Name", ruleChainId, new RuleNodeId(UUID.randomUUID())).getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId2() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId2 = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.newMsg(tbMsg2, "Queue Name", ruleChainId2, new RuleNodeId(UUID.randomUUID())).getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)} with {@code TbMsg}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsg, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsg, String, RuleChainId, RuleNodeId) with 'TbMsg', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsg, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgStringRuleChainIdRuleNodeId3() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg(tbMsg2, "Queue Name", ruleChainId, new RuleNodeId(UUID.randomUUID())).getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange and Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals("POST_ATTRIBUTES_REQUEST", actualNewMsgResult.getType());
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertEquals(TbMsgType.POST_ATTRIBUTES_REQUEST, actualNewMsgResult.getInternalType());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, TbMsgMetaData.EMPTY, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)} with {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString4() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_TELEMETRY_REQUEST, originator, null, TbMsgMetaData.EMPTY,
        "Data");

    // Assert
    assertEquals("POST_TELEMETRY_REQUEST", actualNewMsgResult.getType());
    assertEquals(TbMsgType.POST_TELEMETRY_REQUEST, actualNewMsgResult.getInternalType());
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)} with {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg
            .newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, TbMsgMetaData.EMPTY, TbMsgDataType.JSON,
                "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)} with {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg
            .newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON,
                "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong() {
    // Arrange and Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", 0L);

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", 1L).getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data",
        1L);

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   * <ul>
   *   <li>Then return MetaDataTs is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'; then return MetaDataTs is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong_thenReturnMetaDataTsIsOne() {
    // Arrange and Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", 1L);

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertEquals(1L, actualNewMsgResult.getMetaDataTs());
    assertEquals(1L, actualNewMsgResult.getTs());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code TbMsgCallback}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY)
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code TbMsgCallback}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data",
        TbMsgCallback.EMPTY);

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY,
        TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg
            .newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data",
                ruleChainId, new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)} with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId2() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY,
        TbMsgDataType.JSON, "Data", ruleChainId, new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code RuleChainId}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName("Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsg(tbMsg2, new RuleChainId(UUID.randomUUID()), "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code RuleChainId}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName("Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act and Assert
    assertSame(originator,
        TbMsg.transformMsg(tbMsg2, new RuleChainId(UUID.randomUUID()), "Queue Name").getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code RuleChainId}, {@code String}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName("Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'; given RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsg(tbMsg2, new RuleChainId(UUID.randomUUID()), "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsg(TbMsg.transformMsgCustomerId(tbMsg, customerId), TbMsgMetaData.EMPTY, "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(originator,
        TbMsg.transformMsg(TbMsg.transformMsgCustomerId(tbMsg, null), TbMsgMetaData.EMPTY, "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)} with {@code TbMsg}, {@code TbMsgMetaData}, {@code String}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'; given RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsg(TbMsg.transformMsgCustomerId(tbMsg, customerId), TbMsgMetaData.EMPTY, "Data")
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String); given RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsgData(TbMsg.transformMsgCustomerId(tbMsg, customerId), "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsgData(TbMsg.transformMsgCustomerId(tbMsg, customerId), "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgData(TbMsg, String); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(originator, TbMsg.transformMsgData(TbMsg.transformMsgCustomerId(tbMsg, null), "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData); given RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsgMetadata(TbMsg.transformMsgCustomerId(tbMsg, customerId), TbMsgMetaData.EMPTY)
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsgMetadata(TbMsg.transformMsgCustomerId(tbMsg, customerId), TbMsgMetaData.EMPTY)
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName("Test transformMsgMetadata(TbMsg, TbMsgMetaData); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(originator,
        TbMsg.transformMsgMetadata(TbMsg.transformMsgCustomerId(tbMsg, null), TbMsgMetaData.EMPTY).getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId); given RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgData(tbMsg, "Data");
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg2, customerId).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgData(tbMsg, "Data");
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg2, customerId).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName("Test transformMsgCustomerId(TbMsg, CustomerId); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(originator, TbMsg.transformMsgCustomerId(TbMsg.transformMsgData(tbMsg, "Data"), null).getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId); given RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgRuleChainId(tbMsg2, new RuleChainId(UUID.randomUUID())).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgRuleChainId(tbMsg2, new RuleChainId(UUID.randomUUID())).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test transformMsgRuleChainId(TbMsg, RuleChainId); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act and Assert
    assertSame(originator, TbMsg.transformMsgRuleChainId(tbMsg2, new RuleChainId(UUID.randomUUID())).getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String); given RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsgQueueName(TbMsg.transformMsgCustomerId(tbMsg, customerId), "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.transformMsgQueueName(TbMsg.transformMsgCustomerId(tbMsg, customerId), "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName("Test transformMsgQueueName(TbMsg, String); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(originator,
        TbMsg.transformMsgQueueName(TbMsg.transformMsgCustomerId(tbMsg, null), "Queue Name").getOriginator());
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when '0XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_when0xaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "0XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when '8XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_when8xaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Could not parse protobuf for TbMsg", "8XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when array of byte with eighteen and two; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithEighteenAndTwo_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{18, 2, 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when array of byte with eighteen and 'X'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithEighteenAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when array of byte with lf and two; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithLfAndTwo_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when array of byte with minus one and 'X'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithMinusOneAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when array of byte with twenty-six and two; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithTwentySixAndTwo_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when array of byte with twenty-six and 'X'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithTwentySixAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when array of byte with two and 'X'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenArrayOfByteWithTwoAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "AXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalStateException2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Could not parse protobuf for TbMsg", "AXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when 'XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "\nXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when 'XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", " XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when '(XAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "(XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when 'XXAXAXAX' Bytes is 'UTF-8'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.fromBytes(String, byte[], TbMsgCallback)"})
  void testFromBytes_whenXxaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "XXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId)} with {@code ruleChainId}.
   * <p>
   * Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId) with 'ruleChainId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId)"})
  void testCopyWithRuleChainIdWithRuleChainId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId,
        transformMsgCustomerIdResult.copyWithRuleChainId(new RuleChainId(UUID.randomUUID())).getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId)} with {@code ruleChainId}.
   * <p>
   * Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId) with 'ruleChainId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId)"})
  void testCopyWithRuleChainIdWithRuleChainId2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act and Assert
    assertSame(originator,
        transformMsgCustomerIdResult.copyWithRuleChainId(new RuleChainId(UUID.randomUUID())).getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)} with {@code ruleChainId}, {@code msgId}.
   * <p>
   * Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId, UUID) with 'ruleChainId', 'msgId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId, UUID)"})
  void testCopyWithRuleChainIdWithRuleChainIdMsgId() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        transformMsgCustomerIdResult.copyWithRuleChainId(ruleChainId, UUID.randomUUID()).getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)} with {@code ruleChainId}, {@code msgId}.
   * <p>
   * Method under test: {@link TbMsg#copyWithRuleChainId(RuleChainId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleChainId(RuleChainId, UUID) with 'ruleChainId', 'msgId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleChainId(RuleChainId, UUID)"})
  void testCopyWithRuleChainIdWithRuleChainIdMsgId2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        transformMsgCustomerIdResult.copyWithRuleChainId(ruleChainId, UUID.randomUUID()).getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        transformMsgCustomerIdResult.copyWithRuleNodeId(ruleChainId, ruleNodeId, UUID.randomUUID()).getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName("Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        transformMsgCustomerIdResult.copyWithRuleNodeId(ruleChainId, ruleNodeId, UUID.randomUUID()).getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   * <p>
   * Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg, customerId).copyWithNewCtx().getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx(); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg, customerId).copyWithNewCtx().getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName("Test copyWithNewCtx(); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder metaDataResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(originator, TbMsg.transformMsgCustomerId(tbMsg, null).copyWithNewCtx().getOriginator());
  }

  /**
   * Test {@link TbMsg#getCallback()}.
   * <ul>
   *   <li>Then return MsgValid.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#getCallback()}
   */
  @Test
  @DisplayName("Test getCallback(); then return MsgValid")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgCallback TbMsg.getCallback()"})
  void testGetCallback_thenReturnMsgValid() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).getCallback().isMsgValid());
  }

  /**
   * Test {@link TbMsg#popFormStack()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#popFormStack()}
   */
  @Test
  @DisplayName("Test popFormStack(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsg.popFormStack()"})
  void testPopFormStack_thenReturnNull() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertNull(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).popFormStack());
  }

  /**
   * Test {@link TbMsg#popFormStack()}.
   * <ul>
   *   <li>Then return RuleChainId is {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#popFormStack()}
   */
  @Test
  @DisplayName("Test popFormStack(); then return RuleChainId is RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsg.popFormStack()"})
  void testPopFormStack_thenReturnRuleChainIdIsRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    ctx.push(ruleChainId, ruleNodeId);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    TbMsgProcessingStackItem actualPopFormStackResult = TbMsg
        .transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
        .popFormStack();

    // Assert
    assertSame(ruleChainId, actualPopFormStackResult.getRuleChainId());
    assertSame(ruleNodeId, actualPopFormStackResult.getRuleNodeId());
  }

  /**
   * Test {@link TbMsg#isValid()}.
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#isMsgValid()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given TbMsgCallback isMsgValid() return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isValid()"})
  void testIsValid_givenTbMsgCallbackIsMsgValidReturnFalse_thenReturnFalse() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenReturn(false);
    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    boolean actualIsValidResult = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid();

    // Assert
    verify(callback).isMsgValid();
    assertFalse(actualIsValidResult);
  }

  /**
   * Test {@link TbMsg#isValid()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isValid()"})
  void testIsValid_thenReturnTrue() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid());
  }

  /**
   * Test {@link TbMsg#isValid()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isValid()}
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
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid());
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link TbMsg#getMetaDataTs()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#getMetaDataTs()}
   */
  @Test
  @DisplayName("Test getMetaDataTs(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbMsg.getMetaDataTs()"})
  void testGetMetaDataTs_thenReturnOne() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertEquals(1L, TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).getMetaDataTs());
  }

  /**
   * Test {@link TbMsg#isTypeOf(TbMsgType)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isTypeOf(TbMsgType)}
   */
  @Test
  @DisplayName("Test isTypeOf(TbMsgType); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isTypeOf(TbMsgType)"})
  void testIsTypeOf_thenReturnFalse() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_TELEMETRY_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertFalse(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
        .isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Test {@link TbMsg#isTypeOf(TbMsgType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isTypeOf(TbMsgType)}
   */
  @Test
  @DisplayName("Test isTypeOf(TbMsgType); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isTypeOf(TbMsgType)"})
  void testIsTypeOf_thenReturnTrue() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
        .isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Test {@link TbMsg#isTypeOneOf(TbMsgType[])}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isTypeOneOf(TbMsgType[])}
   */
  @Test
  @DisplayName("Test isTypeOneOf(TbMsgType[]); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isTypeOneOf(TbMsgType[])"})
  void testIsTypeOneOf_thenReturnFalse() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_TELEMETRY_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertFalse(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
        .isTypeOneOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Test {@link TbMsg#isTypeOneOf(TbMsgType[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isTypeOneOf(TbMsgType[])}
   */
  @Test
  @DisplayName("Test isTypeOneOf(TbMsgType[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsg.isTypeOneOf(TbMsgType[])"})
  void testIsTypeOneOf_thenReturnTrue() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
        .isTypeOneOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }
}
