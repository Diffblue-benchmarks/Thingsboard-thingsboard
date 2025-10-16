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
package org.thingsboard.rule.engine.deduplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class DeduplicationDataDiffblueTest {
  /**
   * Test {@link DeduplicationData#equals(Object)}, and {@link DeduplicationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeduplicationData#equals(Object)}
   *   <li>{@link DeduplicationData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    DeduplicationData deduplicationData2 = new DeduplicationData();

    // Act and Assert
    assertEquals(deduplicationData, deduplicationData2);
    assertEquals(deduplicationData.hashCode(), deduplicationData2.hashCode());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}, and {@link DeduplicationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeduplicationData#equals(Object)}
   *   <li>{@link DeduplicationData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();

    // Act and Assert
    assertEquals(deduplicationData, deduplicationData);
    int expectedHashCodeResult = deduplicationData.hashCode();
    assertEquals(expectedHashCodeResult, deduplicationData.hashCode());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), 1);
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    deduplicationData.setTickScheduled(true);

    // Act and Assert
    assertNotEquals(deduplicationData, new DeduplicationData());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    deduplicationData.add(
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build());

    // Act and Assert
    assertNotEquals(deduplicationData, new DeduplicationData());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), null);
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), "Different type to DeduplicationData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeduplicationData}
   *   <li>{@link DeduplicationData#setTickScheduled(boolean)}
   *   <li>{@link DeduplicationData#toString()}
   *   <li>{@link DeduplicationData#getMsgList()}
   *   <li>{@link DeduplicationData#isTickScheduled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeduplicationData.<init>()",
    "List DeduplicationData.getMsgList()",
    "boolean DeduplicationData.isTickScheduled()",
    "void DeduplicationData.setTickScheduled(boolean)",
    "String DeduplicationData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeduplicationData actualDeduplicationData = new DeduplicationData();
    actualDeduplicationData.setTickScheduled(true);
    String actualToStringResult = actualDeduplicationData.toString();
    List<TbMsg> actualMsgList = actualDeduplicationData.getMsgList();
    boolean actualIsTickScheduledResult = actualDeduplicationData.isTickScheduled();

    // Assert
    assertEquals("DeduplicationData(msgList=[], tickScheduled=true)", actualToStringResult);
    assertTrue(actualMsgList.isEmpty());
    assertTrue(actualIsTickScheduledResult);
  }

  /**
   * Test {@link DeduplicationData#size()}.
   *
   * <p>Method under test: {@link DeduplicationData#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DeduplicationData.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new DeduplicationData().size());
  }

  /**
   * Test {@link DeduplicationData#add(TbMsg)}.
   *
   * <p>Method under test: {@link DeduplicationData#add(TbMsg)}
   */
  @Test
  @DisplayName("Test add(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeduplicationData.add(TbMsg)"})
  void testAdd() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    TbMsg msg = mock(TbMsg.class);

    // Act
    deduplicationData.add(msg);

    // Assert
    List<TbMsg> msgList = deduplicationData.getMsgList();
    assertEquals(1, msgList.size());
    assertEquals(1, deduplicationData.size());
    assertFalse(deduplicationData.isEmpty());
    assertSame(msg, msgList.get(0));
  }

  /**
   * Test {@link DeduplicationData#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link DeduplicationData} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given DeduplicationData (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeduplicationData.isEmpty()"})
  void testIsEmpty_givenDeduplicationData_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new DeduplicationData().isEmpty());
  }

  /**
   * Test {@link DeduplicationData#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeduplicationData.isEmpty()"})
  void testIsEmpty_thenReturnFalse() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    deduplicationData.add(
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build());

    // Act and Assert
    assertFalse(deduplicationData.isEmpty());
  }
}
