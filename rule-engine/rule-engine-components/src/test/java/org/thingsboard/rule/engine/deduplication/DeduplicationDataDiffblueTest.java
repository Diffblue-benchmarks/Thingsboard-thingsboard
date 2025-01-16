package org.thingsboard.rule.engine.deduplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class DeduplicationDataDiffblueTest {
  /**
   * Test {@link DeduplicationData#equals(Object)}, and
   * {@link DeduplicationData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeduplicationData#equals(Object)}
   *   <li>{@link DeduplicationData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    DeduplicationData deduplicationData2 = new DeduplicationData();

    // Act and Assert
    assertEquals(deduplicationData, deduplicationData2);
    int expectedHashCodeResult = deduplicationData.hashCode();
    assertEquals(expectedHashCodeResult, deduplicationData2.hashCode());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}, and
   * {@link DeduplicationData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeduplicationData#equals(Object)}
   *   <li>{@link DeduplicationData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9.callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    DeduplicationData deduplicationData = new DeduplicationData();
    deduplicationData.add(msg);

    // Act and Assert
    assertNotEquals(deduplicationData, new DeduplicationData());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), null);
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), "Different type to DeduplicationData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    DeduplicationData actualDeduplicationData = new DeduplicationData();
    actualDeduplicationData.setTickScheduled(true);
    String actualToStringResult = actualDeduplicationData.toString();
    List<TbMsg> actualMsgList = actualDeduplicationData.getMsgList();
    boolean actualIsTickScheduledResult = actualDeduplicationData.isTickScheduled();

    // Assert that nothing has changed
    assertEquals("DeduplicationData(msgList=[], tickScheduled=true)", actualToStringResult);
    assertTrue(actualMsgList.isEmpty());
    assertTrue(actualIsTickScheduledResult);
  }

  /**
   * Test {@link DeduplicationData#size()}.
   * <p>
   * Method under test: {@link DeduplicationData#size()}
   */
  @Test
  @DisplayName("Test size()")
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new DeduplicationData()).size());
  }

  /**
   * Test {@link DeduplicationData#add(TbMsg)}.
   * <p>
   * Method under test: {@link DeduplicationData#add(TbMsg)}
   */
  @Test
  @DisplayName("Test add(TbMsg)")
  void testAdd() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();

    // Act
    deduplicationData.add(null);

    // Assert
    List<TbMsg> msgList = deduplicationData.getMsgList();
    assertEquals(1, msgList.size());
    assertNull(msgList.get(0));
    assertEquals(1, deduplicationData.size());
    assertFalse(deduplicationData.isEmpty());
  }

  /**
   * Test {@link DeduplicationData#isEmpty()}.
   * <p>
   * Method under test: {@link DeduplicationData#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new DeduplicationData()).isEmpty());
  }
}
