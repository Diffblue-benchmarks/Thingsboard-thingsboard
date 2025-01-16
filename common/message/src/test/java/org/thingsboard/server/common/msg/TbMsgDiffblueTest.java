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
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgDiffblueTest {
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
  void testFromBytes_when8xaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "8XAXAXAX".getBytes("UTF-8"), mock(TbMsgCallback.class)));
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
  void testFromBytes_whenArrayOfByteWithEighteenAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
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
  void testFromBytes_whenArrayOfByteWithMinusOneAndX_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, TbMsgCallback.EMPTY));
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
  void testFromBytes_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "AXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

  /**
   * Test {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}.
   * <ul>
   *   <li>When {@code Could not parse protobuf for TbMsg}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#fromBytes(String, byte[], TbMsgCallback)}
   */
  @Test
  @DisplayName("Test fromBytes(String, byte[], TbMsgCallback); when 'Could not parse protobuf for TbMsg'; then throw IllegalStateException")
  void testFromBytes_whenCouldNotParseProtobufForTbMsg_thenThrowIllegalStateException()
      throws UnsupportedEncodingException {
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
  void testFromBytes_whenXaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "\nXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", " XAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
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
  void testFromBytes_whenXxaxaxaxBytesIsUtf8_thenThrowIllegalStateException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> TbMsg.fromBytes("Queue Name", "XXAXAXAX".getBytes("UTF-8"), TbMsgCallback.EMPTY));
  }

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
  void testGetAndIncrementRuleNodeCounter_thenReturnZero() {
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
   * Test {@link TbMsg#getMetaDataTs()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#getMetaDataTs()}
   */
  @Test
  @DisplayName("Test getMetaDataTs(); then return one")
  void testGetMetaDataTs_thenReturnOne() {
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
   * Test {@link TbMsg#isTypeOf(TbMsgType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isTypeOf(TbMsgType)}
   */
  @Test
  @DisplayName("Test isTypeOf(TbMsgType); then return 'true'")
  void testIsTypeOf_thenReturnTrue() {
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
   * Test {@link TbMsg#isTypeOneOf(TbMsgType[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isTypeOneOf(TbMsgType[])}
   */
  @Test
  @DisplayName("Test isTypeOneOf(TbMsgType[]); then return 'true'")
  void testIsTypeOneOf_thenReturnTrue() {
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
   * Test {@link TbMsg#isValid()}.
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#isMsgValid()} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given TbMsgCallback isMsgValid() return 'false'; then return 'false'")
  void testIsValid_givenTbMsgCallbackIsMsgValidReturnFalse_thenReturnFalse() {
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
   * Test {@link TbMsg#isValid()}.
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#isMsgValid()} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given TbMsgCallback isMsgValid() return 'true'; then return 'true'")
  void testIsValid_givenTbMsgCallbackIsMsgValidReturnTrue_thenReturnTrue() {
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
   * Test {@link TbMsg#isValid()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then throw IllegalStateException")
  void testIsValid_thenThrowIllegalStateException() {
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
   * Test
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", (EntityId) null, customerId, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, "Data").getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <ul>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'; then return 'Type'")
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataString_thenReturnType() {
    // Arrange and Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", (EntityId) null, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals("Type", actualNewMsgResult.getType());
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange and Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", null, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    assertEquals("Type", actualNewMsgResult.getType());
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString2() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", null, customerId, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data");

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg("Type", originator, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data")
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  void testNewMsgWithStringEntityIdCustomerIdTbMsgMetaDataTbMsgDataTypeString4() {
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
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)} with
   * {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String) with 'String', 'EntityId', 'TbMsgMetaData', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String},
   * {@code TbMsgCallback}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    TbMsgCallback callback = TbMsgCallback.EMPTY;

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", null, TbMsgMetaData.EMPTY, "Data", callback);

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertTrue(actualNewMsgResult.isValid());
    assertSame(callback, actualNewMsgResult.getCallback());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String},
   * {@code TbMsgCallback}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY)
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String},
   * {@code TbMsgCallback}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback3() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY);

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String},
   * {@code TbMsgCallback}.
   * <ul>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'String', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'; then return not Valid")
  void testNewMsgWithStringEntityIdTbMsgMetaDataStringTbMsgCallback_thenReturnNotValid() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Type", null, TbMsgMetaData.EMPTY, "Data", callback);

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertFalse(actualNewMsgResult.isValid());
    assertSame(callback, actualNewMsgResult.getCallback());
  }

  /**
   * Test {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)} with
   * {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <ul>
   *   <li>Then Originator return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, String) with 'String', 'EntityId', 'TbMsgMetaData', 'String'; then Originator return AlarmId")
  void testNewMsgWithStringEntityIdTbMsgMetaDataString_thenOriginatorReturnAlarmId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, "Data").getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data")
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertNull(
        TbMsg
            .newMsg("Type", null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data", ruleChainId,
                new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg("Type", originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data", ruleChainId,
            new RuleNodeId(UUID.randomUUID()))
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'String', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId3() {
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
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange and Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", null, null, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals("Queue Name", actualNewMsgResult.getQueueName());
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", null, customerId, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data")
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString4() {
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
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", "Type", null, null, TbMsgMetaData.EMPTY, "Data", ruleChainId,
        new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
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
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg("Queue Name", "Type", originator, null, TbMsgMetaData.EMPTY, "Data", ruleChainId,
            new RuleNodeId(UUID.randomUUID()))
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId4() {
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
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data").getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertNull(TbMsg
        .newMsg("Queue Name", "Type", null, TbMsgMetaData.EMPTY, "Data", ruleChainId, new RuleNodeId(UUID.randomUUID()))
        .getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg("Queue Name", "Type", originator, TbMsgMetaData.EMPTY, "Data", ruleChainId,
            new RuleNodeId(UUID.randomUUID()))
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code RuleChainId}, {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
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
   * Test
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act and Assert
    assertSame(customerId,
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, TbMsgMetaData.EMPTY, "Data")
            .getCustomerId());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data")
            .getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, null, null,
        TbMsgMetaData.EMPTY, "Data", ruleChainId, new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
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
   * Test
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
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
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data")
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertNull(
        TbMsg
            .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", ruleChainId,
                new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", ruleChainId,
            new RuleNodeId(UUID.randomUUID()))
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String, RuleChainId, RuleNodeId) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataStringRuleChainIdRuleNodeId3() {
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
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, TbMsgMetaData.EMPTY,
        "Data");

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, null, TbMsgMetaData.EMPTY, "Data")
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, CustomerId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
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
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with
   * {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data");

    // Assert
    assertEquals(originator, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code long}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong() {
    // Arrange, Act and Assert
    assertNull(TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", 0L).getOriginator());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code long}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong2() {
    // Arrange and Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data", 1L);

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertEquals(1L, actualNewMsgResult.getMetaDataTs());
    assertEquals(1L, actualNewMsgResult.getTs());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code long}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong3() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", 1L)
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code long}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, long) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'long'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringLong4() {
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
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code TbMsgCallback}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback() {
    // Arrange
    TbMsgCallback callback = TbMsgCallback.EMPTY;

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data",
        callback);

    // Assert
    assertNull(actualNewMsgResult.getCustomerId());
    assertNull(actualNewMsgResult.getOriginator());
    assertTrue(actualNewMsgResult.isValid());
    assertSame(callback, actualNewMsgResult.getCallback());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code TbMsgCallback}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data", TbMsgCallback.EMPTY)
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code TbMsgCallback}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback3() {
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
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}, {@code TbMsgCallback}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String, TbMsgCallback) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String', 'TbMsgCallback'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataStringTbMsgCallback4() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);

    // Act
    TbMsg actualNewMsgResult = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, "Data",
        callback);

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertFalse(actualNewMsgResult.isValid());
    assertSame(callback, actualNewMsgResult.getCallback());
  }

  /**
   * Test {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)} with
   * {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   * <ul>
   *   <li>Then Originator return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'; then Originator return AlarmId")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataString_thenOriginatorReturnAlarmId() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg.newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, "Data")
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data")
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String'")
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
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId() {
    // Arrange
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertNull(
        TbMsg
            .newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, null, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data",
                ruleChainId, new RuleNodeId(UUID.randomUUID()))
            .getOriginator());
  }

  /**
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId2() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    EntityId originator2 = TbMsg
        .newMsg(TbMsgType.POST_ATTRIBUTES_REQUEST, originator, TbMsgMetaData.EMPTY, TbMsgDataType.JSON, "Data",
            ruleChainId, new RuleNodeId(UUID.randomUUID()))
        .getOriginator();
    assertTrue(originator2 instanceof AlarmId);
    assertEquals(EntityType.ALARM, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   * with {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code TbMsgDataType}, {@code String}, {@code RuleChainId},
   * {@code RuleNodeId}.
   * <p>
   * Method under test:
   * {@link TbMsg#newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId)}
   */
  @Test
  @DisplayName("Test newMsg(TbMsgType, EntityId, TbMsgMetaData, TbMsgDataType, String, RuleChainId, RuleNodeId) with 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'TbMsgDataType', 'String', 'RuleChainId', 'RuleNodeId'")
  void testNewMsgWithTbMsgTypeEntityIdTbMsgMetaDataTbMsgDataTypeStringRuleChainIdRuleNodeId3() {
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
   * Test {@link TbMsg#popFormStack()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsg#popFormStack()}
   */
  @Test
  @DisplayName("Test popFormStack(); then return 'null'")
  void testPopFormStack_thenReturnNull() {
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
