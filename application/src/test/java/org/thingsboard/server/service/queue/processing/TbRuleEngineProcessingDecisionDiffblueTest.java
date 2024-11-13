package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

class TbRuleEngineProcessingDecisionDiffblueTest {
  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}, and
   * {@link TbRuleEngineProcessingDecision#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRuleEngineProcessingDecision#equals(Object)}
   *   <li>{@link TbRuleEngineProcessingDecision#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbRuleEngineProcessingDecision tbRuleEngineProcessingDecision = new TbRuleEngineProcessingDecision(true,
        new ConcurrentHashMap<>());
    TbRuleEngineProcessingDecision tbRuleEngineProcessingDecision2 = new TbRuleEngineProcessingDecision(true,
        new ConcurrentHashMap<>());

    // Act and Assert
    assertEquals(tbRuleEngineProcessingDecision, tbRuleEngineProcessingDecision2);
    int expectedHashCodeResult = tbRuleEngineProcessingDecision.hashCode();
    assertEquals(expectedHashCodeResult, tbRuleEngineProcessingDecision2.hashCode());
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}, and
   * {@link TbRuleEngineProcessingDecision#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRuleEngineProcessingDecision#equals(Object)}
   *   <li>{@link TbRuleEngineProcessingDecision#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbRuleEngineProcessingDecision tbRuleEngineProcessingDecision = new TbRuleEngineProcessingDecision(true,
        new ConcurrentHashMap<>());

    // Act and Assert
    assertEquals(tbRuleEngineProcessingDecision, tbRuleEngineProcessingDecision);
    int expectedHashCodeResult = tbRuleEngineProcessingDecision.hashCode();
    assertEquals(expectedHashCodeResult, tbRuleEngineProcessingDecision.hashCode());
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingDecision#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbRuleEngineProcessingDecision tbRuleEngineProcessingDecision = new TbRuleEngineProcessingDecision(false,
        new ConcurrentHashMap<>());

    // Act and Assert
    assertNotEquals(tbRuleEngineProcessingDecision,
        new TbRuleEngineProcessingDecision(true, new ConcurrentHashMap<>()));
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingDecision#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Function<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> function = mock(Function.class);
    when(function.apply(Mockito.<UUID>any())).thenReturn(null);

    ConcurrentHashMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> reprocessMap = new ConcurrentHashMap<>();
    reprocessMap.computeIfAbsent(UUID.randomUUID(), function);

    // Act and Assert
    assertNotEquals(new TbRuleEngineProcessingDecision(true, reprocessMap), 1);
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingDecision#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRuleEngineProcessingDecision(true, new ConcurrentHashMap<>()), null);
  }

  /**
   * Test {@link TbRuleEngineProcessingDecision#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingDecision#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRuleEngineProcessingDecision(true, new ConcurrentHashMap<>()),
        "Different type to TbRuleEngineProcessingDecision");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbRuleEngineProcessingDecision#TbRuleEngineProcessingDecision(boolean, ConcurrentMap)}
   *   <li>{@link TbRuleEngineProcessingDecision#toString()}
   *   <li>{@link TbRuleEngineProcessingDecision#getReprocessMap()}
   *   <li>{@link TbRuleEngineProcessingDecision#isCommit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ConcurrentHashMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> reprocessMap = new ConcurrentHashMap<>();

    // Act
    TbRuleEngineProcessingDecision actualTbRuleEngineProcessingDecision = new TbRuleEngineProcessingDecision(true,
        reprocessMap);
    String actualToStringResult = actualTbRuleEngineProcessingDecision.toString();
    ConcurrentMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualReprocessMap = actualTbRuleEngineProcessingDecision
        .getReprocessMap();

    // Assert
    assertEquals("TbRuleEngineProcessingDecision(commit=true, reprocessMap={})", actualToStringResult);
    assertTrue(actualTbRuleEngineProcessingDecision.isCommit());
    assertSame(reprocessMap, actualReprocessMap);
  }
}
