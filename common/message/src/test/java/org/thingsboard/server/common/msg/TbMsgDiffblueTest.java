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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetProfileId;
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertEquals(
        0,
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
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
    CustomerId customerId = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertNull(actualNewMsgResult.getCustomerId());
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId customerId = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertNull(actualNewMsgResult.getCustomerId());
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, metaData, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY);

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, metaData, "Data", TbMsgCallback.EMPTY);

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, metaData, "Data", TbMsgCallback.EMPTY);

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, metaData, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Type",
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Type",
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Type",
            originator,
            metaData,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Type",
            originator,
            metaData,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Type", originator, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId customerId = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertNull(actualNewMsgResult.getCustomerId());
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

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
            new RuleNodeId(UUID.randomUUID()));

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
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

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
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertNull(actualNewMsgResult.getCustomerId());
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

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
            new RuleNodeId(UUID.randomUUID()));

    // Assert
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId4() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            null,
            metaData,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

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
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId5() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            null,
            metaData,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", originator, metaData, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            metaData,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            "Type",
            originator,
            metaData,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", originator, metaData, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId customerId = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

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
            new RuleNodeId(UUID.randomUUID()));

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
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

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
            new RuleNodeId(UUID.randomUUID()));

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
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

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
            new RuleNodeId(UUID.randomUUID()));

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
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            metaData,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId4() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            metaData,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(tbMsg2, "Queue Name", ruleChainId, new RuleNodeId(UUID.randomUUID()));

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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(tbMsg2, "Queue Name", ruleChainId, new RuleNodeId(UUID.randomUUID()));

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
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId2 = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(tbMsg2, "Queue Name", ruleChainId2, new RuleNodeId(UUID.randomUUID()));

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
    CustomerId customerId = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId customerId = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong4() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data", 1L);

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data", 1L);

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)} with {@code
   * TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Then return MetaData is {@link TbMsgMetaData#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName(
      "Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'; then return MetaData is EMPTY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)"})
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong_thenReturnMetaDataIsEmpty() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", 1L);

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
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            "Data",
            TbMsgCallback.EMPTY);

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data", TbMsgCallback.EMPTY);

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data", TbMsgCallback.EMPTY);

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());

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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(TbMsgMetaData.EMPTY, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            TbMsgMetaData.EMPTY,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg TbMsg.newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)"
  })
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            metaData,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId4() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            metaData,
            TbMsgDataType.JSON,
            "Data",
            ruleChainId,
            new RuleNodeId(UUID.randomUUID()));

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult =
        TbMsg.newMsg(
            TbMsgType.POST_ATTRIBUTES_REQUEST, originator, metaData, TbMsgDataType.JSON, "Data");

    // Assert
    EntityId originator2 = actualNewMsgResult.getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertEquals(metaData, actualNewMsgResult.getMetaData());
    assertSame(originator, originator2);
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(tbMsg2, new RuleChainId(UUID.randomUUID()), "Queue Name");

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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(tbMsg2, new RuleChainId(UUID.randomUUID()), "Queue Name");

    // Assert
    assertSame(originator, actualTransformMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)} with {@code TbMsg}, {@code
   * RuleChainId}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, RuleChainId, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, RuleChainId, String) with 'TbMsg', 'RuleChainId', 'String'; given RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, RuleChainId, String)"})
  void testTransformMsgWithTbMsgRuleChainIdString_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgResult =
        TbMsg.transformMsg(tbMsg2, new RuleChainId(UUID.randomUUID()), "Queue Name");

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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

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
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsg(TbMsg, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsg(TbMsg, TbMsgMetaData, String) with 'TbMsg', 'TbMsgMetaData', 'String'; given RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsg(TbMsg, TbMsgMetaData, String)"})
  void testTransformMsgWithTbMsgTbMsgMetaDataString_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act
    TbMsg actualTransformMsgResult = TbMsg.transformMsg(tbMsg2, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertSame(customerId, actualTransformMsgResult.getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsgData(TbMsg, String); given RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgData(tbMsg2, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsgData(TbMsg, String); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgData(tbMsg2, "Data").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgData(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgData(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsgData(TbMsg, String); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgData(TbMsg, String)"})
  void testTransformMsgData_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(
        originator,
        TbMsg.transformMsgData(TbMsg.transformMsgCustomerId(tbMsg, null), "Data").getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test transformMsgMetadata(TbMsg, TbMsgMetaData); given RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgMetadata(tbMsg2, TbMsgMetaData.EMPTY).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test transformMsgMetadata(TbMsg, TbMsgMetaData); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgMetadata(tbMsg2, TbMsgMetaData.EMPTY).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}.
   *
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgMetadata(TbMsg, TbMsgMetaData)}
   */
  @Test
  @DisplayName(
      "Test transformMsgMetadata(TbMsg, TbMsgMetaData); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgMetadata(TbMsg, TbMsgMetaData)"})
  void testTransformMsgMetadata_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(
        originator,
        TbMsg.transformMsgMetadata(TbMsg.transformMsgCustomerId(tbMsg, null), TbMsgMetaData.EMPTY)
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test transformMsgCustomerId(TbMsg, CustomerId); given RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgData(tbMsg, "Data");
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg2, customerId).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test transformMsgCustomerId(TbMsg, CustomerId); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgData(tbMsg, "Data");
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgCustomerId(tbMsg2, customerId).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}.
   *
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgCustomerId(TbMsg, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test transformMsgCustomerId(TbMsg, CustomerId); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgCustomerId(TbMsg, CustomerId)"})
  void testTransformMsgCustomerId_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(
        originator,
        TbMsg.transformMsgCustomerId(TbMsg.transformMsgData(tbMsg, "Data"), null).getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName(
      "Test transformMsgRuleChainId(TbMsg, RuleChainId); given RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgRuleChainId(tbMsg2, new RuleChainId(UUID.randomUUID())).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName(
      "Test transformMsgRuleChainId(TbMsg, RuleChainId); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgRuleChainId(tbMsg2, new RuleChainId(UUID.randomUUID())).getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgRuleChainId(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName(
      "Test transformMsgRuleChainId(TbMsg, RuleChainId); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgRuleChainId(TbMsg, RuleChainId)"})
  void testTransformMsgRuleChainId_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act and Assert
    assertSame(
        originator,
        TbMsg.transformMsgRuleChainId(tbMsg2, new RuleChainId(UUID.randomUUID())).getOriginator());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsgQueueName(TbMsg, String); given RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgQueueName(tbMsg2, "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsgQueueName(TbMsg, String); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg tbMsg2 = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(customerId, TbMsg.transformMsgQueueName(tbMsg2, "Queue Name").getCustomerId());
  }

  /**
   * Test {@link TbMsg#transformMsgQueueName(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#transformMsgQueueName(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test transformMsgQueueName(TbMsg, String); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.transformMsgQueueName(TbMsg, String)"})
  void testTransformMsgQueueName_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(
        originator,
        TbMsg.transformMsgQueueName(TbMsg.transformMsgCustomerId(tbMsg, null), "Queue Name")
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString2() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(null);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString3() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder ruleChainIdResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name")
            .ruleChainId(null);
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString4() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");
    TbMsg tbMsg =
        queueNameResult
            .ruleChainId(new RuleChainId(UUID.randomUUID()))
            .ruleNodeId(null)
            .ts(1L)
            .type("Type")
            .build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString5() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    ByteString actualToByteStringResult =
        TbMsg.toByteString(TbMsg.transformMsgCustomerId(tbMsg, null));

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString6() {
    // Arrange
    TbMsgBuilder correlationIdResult =
        TbMsg.builder().callback(TbMsgCallback.EMPTY).correlationId(null);

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString7() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString8() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AssetProfileId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString9() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data(TbMsg.EMPTY_STRING)
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link TbMsg#toByteString(TbMsg)}.
   *
   * <p>Method under test: {@link TbMsg#toByteString(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteString(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString TbMsg.toByteString(TbMsg)"})
  void testToByteString10() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.TEXT);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);

    TbMsgBuilder queueNameResult =
        metaDataResult
            .originator(new AlarmId(UUID.randomUUID()))
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    ByteString actualToByteStringResult = TbMsg.toByteString(msg);

    // Assert
    assertFalse(actualToByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualToByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\n', iteratorResult.next().byteValue());
    assertEquals('$', iteratorResult.next().byteValue());
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
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(null)
            .originator(originator)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    TbMsg.toByteArray(msg);

    // Assert
    verify(originator).getEntityType();
    verify(originator, atLeast(1)).getId();
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
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(originator)
            .partition(1)
            .queueName("Queue Name");
    TbMsg tbMsg =
        queueNameResult
            .ruleChainId(new RuleChainId(UUID.randomUUID()))
            .ruleNodeId(null)
            .ts(1L)
            .type("Type")
            .build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    TbMsg.toByteArray(msg);

    // Assert
    verify(originator).getEntityType();
    verify(originator, atLeast(1)).getId();
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
  void testToByteArray3() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(originator)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    TbMsg.toByteArray(TbMsg.transformMsgCustomerId(tbMsg, null));

    // Assert
    verify(originator, atLeast(1)).getEntityType();
    verify(originator, atLeast(1)).getId();
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   *   <li>Then calls {@link TbMsgMetaData#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg); given HashMap() 'foo' is 'foo'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_givenHashMapFooIsFoo_thenCallsGetData() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    TbMsgMetaData metaData = mock(TbMsgMetaData.class);
    when(metaData.getData()).thenReturn(stringStringMap);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(metaData);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    TbMsg.toByteArray(msg);

    // Assert
    verify(originator).getEntityType();
    verify(originator, atLeast(1)).getId();
    verify(metaData).getData();
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbMsgMetaData#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg); then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenCallsGetData() {
    // Arrange
    TbMsgMetaData metaData = mock(TbMsgMetaData.class);
    when(metaData.getData()).thenReturn(new HashMap<>());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(metaData);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act
    TbMsg.toByteArray(msg);

    // Assert
    verify(originator).getEntityType();
    verify(originator, atLeast(1)).getId();
    verify(metaData).getData();
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChainId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_thenCallsGetId() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(mock(TbMsgMetaData.class))
            .originator(originator)
            .partition(1)
            .queueName("Queue Name");

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenThrow(new IllegalStateException());

    TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(ruleChainId);
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.toByteArray(msg));
    verify(originator).getEntityType();
    verify(ruleChainId).getId();
    verify(originator, atLeast(1)).getId();
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName("Test toByteArray(TbMsg); when AlarmId getId() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_whenAlarmIdGetIdThrowIllegalStateException() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenThrow(new IllegalStateException());
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(originator)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.toByteArray(msg));
    verify(originator).getEntityType();
    verify(originator).getId();
  }

  /**
   * Test {@link TbMsg#toByteArray(TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsgMetaData} {@link TbMsgMetaData#getData()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#toByteArray(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(TbMsg); when TbMsgMetaData getData() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbMsg.toByteArray(TbMsg)"})
  void testToByteArray_whenTbMsgMetaDataGetDataThrowIllegalStateException() {
    // Arrange
    TbMsgMetaData metaData = mock(TbMsgMetaData.class);
    when(metaData.getData()).thenThrow(new IllegalStateException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(metaData);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg msg = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.toByteArray(msg));
    verify(originator).getEntityType();
    verify(originator, atLeast(1)).getId();
    verify(metaData).getData();
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);

    // Act and Assert
    assertSame(
        customerId,
        transformMsgCustomerIdResult
            .copyWithRuleChainId(new RuleChainId(UUID.randomUUID()))
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);

    // Act and Assert
    assertSame(
        originator,
        transformMsgCustomerIdResult
            .copyWithRuleChainId(new RuleChainId(UUID.randomUUID()))
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(
        customerId,
        transformMsgCustomerIdResult
            .copyWithRuleChainId(ruleChainId, UUID.randomUUID())
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertSame(
        originator,
        transformMsgCustomerIdResult
            .copyWithRuleChainId(ruleChainId, UUID.randomUUID())
            .getOriginator());
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName(
      "Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, customerId);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertSame(
        customerId,
        transformMsgCustomerIdResult
            .copyWithRuleNodeId(ruleChainId, ruleNodeId, UUID.randomUUID())
            .getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}.
   *
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)}
   */
  @Test
  @DisplayName(
      "Test copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithRuleNodeId(RuleChainId, RuleNodeId, UUID)"})
  void testCopyWithRuleNodeId_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbMsg transformMsgCustomerIdResult = TbMsg.transformMsgCustomerId(tbMsg, null);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertSame(
        originator,
        transformMsgCustomerIdResult
            .copyWithRuleNodeId(ruleChainId, ruleNodeId, UUID.randomUUID())
            .getOriginator());
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
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgCustomerId(tbMsg, customerId).copyWithNewCtx().getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName(
      "Test copyWithNewCtx(); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(
        customerId,
        TbMsg.transformMsgCustomerId(tbMsg, customerId).copyWithNewCtx().getCustomerId());
  }

  /**
   * Test {@link TbMsg#copyWithNewCtx()}.
   *
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#copyWithNewCtx()}
   */
  @Test
  @DisplayName(
      "Test copyWithNewCtx(); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbMsg.copyWithNewCtx()"})
  void testCopyWithNewCtx_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder metaDataResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY);
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(
        originator, TbMsg.transformMsgCustomerId(tbMsg, null).copyWithNewCtx().getOriginator());
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
            .getCallback()
            .isMsgValid());
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertNull(
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).popFormStack());
  }

  /**
   * Test {@link TbMsg#popFormStack()}.
   *
   * <ul>
   *   <li>Then return RuleChainId is {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbMsg#popFormStack()}
   */
  @Test
  @DisplayName(
      "Test popFormStack(); then return RuleChainId is RuleChainId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsgProcessingStackItem TbMsg.popFormStack()"})
  void testPopFormStack_thenReturnRuleChainIdIsRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    ctx.push(ruleChainId, ruleNodeId);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx);

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    TbMsgProcessingStackItem actualPopFormStackResult =
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).popFormStack();

    // Assert
    assertSame(ruleChainId, actualPopFormStackResult.getRuleChainId());
    assertSame(ruleNodeId, actualPopFormStackResult.getRuleNodeId());
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    boolean actualIsValidResult =
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid();

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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid());
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid());
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertEquals(
        1L, TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).getMetaDataTs());
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_TELEMETRY_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertFalse(
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_TELEMETRY_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertFalse(
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertFalse(
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isTypeOneOf());
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
            .isTypeOneOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }
}
