package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;

@ContextConfiguration(classes = {TbRuleEngineSubmitStrategyFactory.class})
@ExtendWith(SpringExtension.class)
class TbRuleEngineSubmitStrategyFactoryDiffblueTest {
  @Autowired
  private TbRuleEngineSubmitStrategyFactory tbRuleEngineSubmitStrategyFactory;

  /**
   * Test
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, SubmitStrategy); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testNewInstance_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    when(submitStrategy.getBatchSize()).thenThrow(new RuntimeException("foo"));
    when(submitStrategy.getType()).thenReturn(SubmitStrategyType.BATCH);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbRuleEngineSubmitStrategyFactory.newInstance("Name", submitStrategy));
    verify(submitStrategy).getBatchSize();
    verify(submitStrategy).getType();
    verify(submitStrategy).setBatchSize(eq(3));
    verify(submitStrategy).setType(eq(SubmitStrategyType.BURST));
  }

  /**
   * Test
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}.
   * <ul>
   *   <li>Given {@code SEQUENTIAL}.</li>
   *   <li>Then return {@link SequentialTbRuleEngineSubmitStrategy}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, SubmitStrategy); given 'SEQUENTIAL'; then return SequentialTbRuleEngineSubmitStrategy")
  void testNewInstance_givenSequential_thenReturnSequentialTbRuleEngineSubmitStrategy() {
    // Arrange
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    when(submitStrategy.getType()).thenReturn(SubmitStrategyType.SEQUENTIAL);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act
    TbRuleEngineSubmitStrategy actualNewInstanceResult = tbRuleEngineSubmitStrategyFactory.newInstance("Name",
        submitStrategy);

    // Assert
    verify(submitStrategy).getType();
    verify(submitStrategy).setBatchSize(eq(3));
    verify(submitStrategy).setType(eq(SubmitStrategyType.BURST));
    assertTrue(actualNewInstanceResult instanceof SequentialTbRuleEngineSubmitStrategy);
    assertEquals("Name", ((SequentialTbRuleEngineSubmitStrategy) actualNewInstanceResult).queueName);
    assertNull(((SequentialTbRuleEngineSubmitStrategy) actualNewInstanceResult).orderedMsgList);
  }

  /**
   * Test
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}.
   * <ul>
   *   <li>Then return {@link BatchTbRuleEngineSubmitStrategy}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, SubmitStrategy); then return BatchTbRuleEngineSubmitStrategy")
  void testNewInstance_thenReturnBatchTbRuleEngineSubmitStrategy() {
    // Arrange
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    when(submitStrategy.getBatchSize()).thenReturn(3);
    when(submitStrategy.getType()).thenReturn(SubmitStrategyType.BATCH);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act
    TbRuleEngineSubmitStrategy actualNewInstanceResult = tbRuleEngineSubmitStrategyFactory.newInstance("Name",
        submitStrategy);

    // Assert
    verify(submitStrategy).getBatchSize();
    verify(submitStrategy).getType();
    verify(submitStrategy).setBatchSize(eq(3));
    verify(submitStrategy).setType(eq(SubmitStrategyType.BURST));
    assertTrue(actualNewInstanceResult instanceof BatchTbRuleEngineSubmitStrategy);
    assertEquals("Name", ((BatchTbRuleEngineSubmitStrategy) actualNewInstanceResult).queueName);
    assertNull(((BatchTbRuleEngineSubmitStrategy) actualNewInstanceResult).orderedMsgList);
  }

  /**
   * Test
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}.
   * <ul>
   *   <li>Then return
   * {@link SequentialByOriginatorIdTbRuleEngineSubmitStrategy}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, SubmitStrategy); then return SequentialByOriginatorIdTbRuleEngineSubmitStrategy")
  void testNewInstance_thenReturnSequentialByOriginatorIdTbRuleEngineSubmitStrategy() {
    // Arrange
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    when(submitStrategy.getType()).thenReturn(SubmitStrategyType.SEQUENTIAL_BY_ORIGINATOR);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act
    TbRuleEngineSubmitStrategy actualNewInstanceResult = tbRuleEngineSubmitStrategyFactory.newInstance("Name",
        submitStrategy);

    // Assert
    verify(submitStrategy).getType();
    verify(submitStrategy).setBatchSize(eq(3));
    verify(submitStrategy).setType(eq(SubmitStrategyType.BURST));
    assertTrue(actualNewInstanceResult instanceof SequentialByOriginatorIdTbRuleEngineSubmitStrategy);
    assertEquals("Name", ((SequentialByOriginatorIdTbRuleEngineSubmitStrategy) actualNewInstanceResult).queueName);
    assertNull(((SequentialByOriginatorIdTbRuleEngineSubmitStrategy) actualNewInstanceResult).orderedMsgList);
  }

  /**
   * Test
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}.
   * <ul>
   *   <li>Then return {@link SequentialByTenantIdTbRuleEngineSubmitStrategy}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, SubmitStrategy); then return SequentialByTenantIdTbRuleEngineSubmitStrategy")
  void testNewInstance_thenReturnSequentialByTenantIdTbRuleEngineSubmitStrategy() {
    // Arrange
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    when(submitStrategy.getType()).thenReturn(SubmitStrategyType.SEQUENTIAL_BY_TENANT);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act
    TbRuleEngineSubmitStrategy actualNewInstanceResult = tbRuleEngineSubmitStrategyFactory.newInstance("Name",
        submitStrategy);

    // Assert
    verify(submitStrategy).getType();
    verify(submitStrategy).setBatchSize(eq(3));
    verify(submitStrategy).setType(eq(SubmitStrategyType.BURST));
    assertTrue(actualNewInstanceResult instanceof SequentialByTenantIdTbRuleEngineSubmitStrategy);
    assertEquals("Name", ((SequentialByTenantIdTbRuleEngineSubmitStrategy) actualNewInstanceResult).queueName);
    assertNull(((SequentialByTenantIdTbRuleEngineSubmitStrategy) actualNewInstanceResult).orderedMsgList);
  }

  /**
   * Test
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}.
   * <ul>
   *   <li>When {@link SubmitStrategy} (default constructor) BatchSize is
   * three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, SubmitStrategy); when SubmitStrategy (default constructor) BatchSize is three")
  void testNewInstance_whenSubmitStrategyBatchSizeIsThree() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act
    TbRuleEngineSubmitStrategy actualNewInstanceResult = tbRuleEngineSubmitStrategyFactory.newInstance("Name",
        submitStrategy);

    // Assert
    assertTrue(actualNewInstanceResult instanceof BurstTbRuleEngineSubmitStrategy);
    assertEquals("Name", ((BurstTbRuleEngineSubmitStrategy) actualNewInstanceResult).queueName);
    assertNull(((BurstTbRuleEngineSubmitStrategy) actualNewInstanceResult).orderedMsgList);
  }

  /**
   * Test
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}.
   * <ul>
   *   <li>When {@link SubmitStrategy} {@link SubmitStrategy#getType()} return
   * {@code BURST}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineSubmitStrategyFactory#newInstance(String, SubmitStrategy)}
   */
  @Test
  @DisplayName("Test newInstance(String, SubmitStrategy); when SubmitStrategy getType() return 'BURST'")
  void testNewInstance_whenSubmitStrategyGetTypeReturnBurst() {
    // Arrange
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    when(submitStrategy.getType()).thenReturn(SubmitStrategyType.BURST);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act
    TbRuleEngineSubmitStrategy actualNewInstanceResult = tbRuleEngineSubmitStrategyFactory.newInstance("Name",
        submitStrategy);

    // Assert
    verify(submitStrategy).getType();
    verify(submitStrategy).setBatchSize(eq(3));
    verify(submitStrategy).setType(eq(SubmitStrategyType.BURST));
    assertTrue(actualNewInstanceResult instanceof BurstTbRuleEngineSubmitStrategy);
    assertEquals("Name", ((BurstTbRuleEngineSubmitStrategy) actualNewInstanceResult).queueName);
    assertNull(((BurstTbRuleEngineSubmitStrategy) actualNewInstanceResult).orderedMsgList);
  }
}
