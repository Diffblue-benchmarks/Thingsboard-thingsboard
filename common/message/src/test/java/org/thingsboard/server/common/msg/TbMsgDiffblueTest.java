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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgDiffblueTest {
  /**
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  void testFromBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "AXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Could not parse protobuf for TbMsg", "AXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "\nXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "XXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", " XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "(XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "0XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "8XAXAXAX".getBytes("UTF-8"), mock(TbMsgCallback.class)));
  }

  /**
   * Method under test: {@link TbMsg#getAndIncrementRuleNodeCounter()}
   */
  @Test
  void testGetAndIncrementRuleNodeCounter() {
    // Arrange
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertEquals(0,
        TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).getAndIncrementRuleNodeCounter());
  }

  /**
   * Method under test: {@link TbMsg#getMetaDataTs()}
   */
  @Test
  void testGetMetaDataTs() {
    // Arrange
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertEquals(1L, TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).getMetaDataTs());
  }

  /**
   * Method under test: {@link TbMsg#isTypeOf(TbMsgType)}
   */
  @Test
  void testIsTypeOf() {
    // Arrange
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
        .isTypeOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Method under test: {@link TbMsg#isTypeOneOf(TbMsgType[])}
   */
  @Test
  void testIsTypeOneOf() {
    // Arrange
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID()))
        .isTypeOneOf(TbMsgType.POST_ATTRIBUTES_REQUEST));
  }

  /**
   * Method under test: {@link TbMsg#isValid()}
   */
  @Test
  void testIsValid() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenReturn(true);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    boolean actualIsValidResult = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid();

    // Assert
    verify(callback).isMsgValid();
    assertTrue(actualIsValidResult);
  }

  /**
   * Method under test: {@link TbMsg#isValid()}
   */
  @Test
  void testIsValid2() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenReturn(false);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    boolean actualIsValidResult = TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid();

    // Assert
    verify(callback).isMsgValid();
    assertFalse(actualIsValidResult);
  }

  /**
   * Method under test: {@link TbMsg#isValid()}
   */
  @Test
  void testIsValid3() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenThrow(new IllegalStateException("foo"));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).isValid());
    verify(callback).isMsgValid();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  void testNewMsg() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  void testNewMsg2() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.newMsg("Queue Name", "Type", originator, null,
        TbMsgMetaData.EMPTY, "Data", ruleChainId, new RuleNodeId(UUID.randomUUID())));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  void testNewMsg3() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  void testNewMsg4() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  void testNewMsg5() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST,
        originator, null, TbMsgMetaData.EMPTY, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  void testNewMsg6() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST,
        originator, null, TbMsgMetaData.EMPTY, "Data", ruleChainId, new RuleNodeId(UUID.randomUUID())));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  void testNewMsg7() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  void testNewMsg8() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST,
        originator, TbMsgMetaData.EMPTY, "Data", ruleChainId, new RuleNodeId(UUID.randomUUID())));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  void testNewMsg9() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  void testNewMsg10() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null,
        TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  void testNewMsg11() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  void testNewMsg12() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", 0L));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  void testNewMsg13() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  void testNewMsg14() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data"));
    verify(originator).getEntityType();
  }

  /**
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  void testNewMsg15() {
    // Arrange
    EntityId originator = mock(EntityId.class);
    when(originator.getEntityType()).thenThrow(new IllegalStateException("foo"));
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data", ruleChainId, new RuleNodeId(UUID.randomUUID())));
    verify(originator).getEntityType();
  }

  /**
   * Method under test: {@link TbMsg#popFormStack()}
   */
  @Test
  void testPopFormStack() {
    // Arrange
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertNull(TbMsg.transformMsgCustomerId(tbMsg, new CustomerId(UUID.randomUUID())).popFormStack());
  }
}
