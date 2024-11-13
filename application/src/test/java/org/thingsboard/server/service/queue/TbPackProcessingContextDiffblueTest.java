package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbPackProcessingContextDiffblueTest {
  /**
   * Test
   * {@link TbPackProcessingContext#TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap)}.
   * <ul>
   *   <li>Then return FailedMap Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbPackProcessingContext#TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap)}
   */
  @Test
  @DisplayName("Test new TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap); then return FailedMap Empty")
  void testNewTbPackProcessingContext_thenReturnFailedMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    Function<UUID, Object> function = mock(Function.class);
    when(function.apply(Mockito.<UUID>any())).thenReturn("Apply");

    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.computeIfAbsent(UUID.randomUUID(), function);
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();

    // Act
    TbPackProcessingContext<Object> actualTbPackProcessingContext = new TbPackProcessingContext<>(
        processingTimeoutLatch, ackMap, failedMap);

    // Assert
    verify(function).apply(isA(UUID.class));
    ConcurrentMap<UUID, Object> failedMap2 = actualTbPackProcessingContext.getFailedMap();
    assertTrue(failedMap2.isEmpty());
    assertSame(ackMap, actualTbPackProcessingContext.getAckMap());
    assertSame(failedMap, failedMap2);
  }

  /**
   * Test
   * {@link TbPackProcessingContext#TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap)}.
   * <ul>
   *   <li>When {@link CountDownLatch#CountDownLatch(int)} with one.</li>
   *   <li>Then return AckMap Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbPackProcessingContext#TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap)}
   */
  @Test
  @DisplayName("Test new TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap); when CountDownLatch(int) with one; then return AckMap Empty")
  void testNewTbPackProcessingContext_whenCountDownLatchWithOne_thenReturnAckMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    TbPackProcessingContext<Object> actualTbPackProcessingContext = new TbPackProcessingContext<>(
        processingTimeoutLatch, ackMap, new ConcurrentHashMap<>());

    // Assert
    assertTrue(actualTbPackProcessingContext.getAckMap().isEmpty());
  }

  /**
   * Test {@link TbPackProcessingContext#await(long, TimeUnit)}.
   * <ul>
   *   <li>Given {@link CountDownLatch#CountDownLatch(int)} with one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbPackProcessingContext#await(long, TimeUnit)}
   */
  @Test
  @DisplayName("Test await(long, TimeUnit); given CountDownLatch(int) with one; then return 'false'")
  void testAwait_givenCountDownLatchWithOne_thenReturnFalse() throws InterruptedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, new ConcurrentHashMap<>());

    // Act and Assert
    assertFalse(tbPackProcessingContext.await(1L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TbPackProcessingContext#await(long, TimeUnit)}.
   * <ul>
   *   <li>Given {@link CountDownLatch#CountDownLatch(int)} with zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbPackProcessingContext#await(long, TimeUnit)}
   */
  @Test
  @DisplayName("Test await(long, TimeUnit); given CountDownLatch(int) with zero; then return 'true'")
  void testAwait_givenCountDownLatchWithZero_thenReturnTrue() throws InterruptedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(0);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, new ConcurrentHashMap<>());

    // Act and Assert
    assertTrue(tbPackProcessingContext.await(1L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TbPackProcessingContext#onSuccess(UUID)}.
   * <p>
   * Method under test: {@link TbPackProcessingContext#onSuccess(UUID)}
   */
  @Test
  @DisplayName("Test onSuccess(UUID)")
  void testOnSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, new ConcurrentHashMap<>());

    // Act
    tbPackProcessingContext.onSuccess(UUID.randomUUID());

    // Assert
    ConcurrentMap<UUID, Object> ackMap2 = tbPackProcessingContext.getAckMap();
    assertTrue(ackMap2.isEmpty());
    assertSame(ackMap, ackMap2);
  }

  /**
   * Test {@link TbPackProcessingContext#onSuccess(UUID)}.
   * <p>
   * Method under test: {@link TbPackProcessingContext#onSuccess(UUID)}
   */
  @Test
  @DisplayName("Test onSuccess(UUID)")
  void testOnSuccess2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Function<UUID, Object> function = mock(Function.class);
    when(function.apply(Mockito.<UUID>any())).thenReturn("Apply");

    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.computeIfAbsent(new UUID(1L, 1L), function);
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, failedMap);

    // Act
    tbPackProcessingContext.onSuccess(new UUID(1L, 1L));

    // Assert
    verify(function).apply(isA(UUID.class));
    assertTrue(tbPackProcessingContext.getAckMap().isEmpty());
    assertSame(failedMap, tbPackProcessingContext.getFailedMap());
  }

  /**
   * Test {@link TbPackProcessingContext#onSuccess(UUID)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} computeIfAbsent
   * randomUUID and {@link Function}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbPackProcessingContext#onSuccess(UUID)}
   */
  @Test
  @DisplayName("Test onSuccess(UUID); given ConcurrentHashMap() computeIfAbsent randomUUID and Function")
  void testOnSuccess_givenConcurrentHashMapComputeIfAbsentRandomUUIDAndFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Function<UUID, Object> function = mock(Function.class);
    when(function.apply(Mockito.<UUID>any())).thenReturn("Apply");

    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.computeIfAbsent(UUID.randomUUID(), function);
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, new ConcurrentHashMap<>());

    // Act
    tbPackProcessingContext.onSuccess(UUID.randomUUID());

    // Assert
    verify(function).apply(isA(UUID.class));
    ConcurrentMap<UUID, Object> ackMap2 = tbPackProcessingContext.getAckMap();
    assertEquals(1, ackMap2.size());
    assertSame(ackMap, ackMap2);
  }

  /**
   * Test {@link TbPackProcessingContext#onSuccess(UUID)}.
   * <ul>
   *   <li>Then {@link UUID#UUID(long, long)} with one and one toString is
   * {@code 00000000-0000-0001-0000-000000000001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbPackProcessingContext#onSuccess(UUID)}
   */
  @Test
  @DisplayName("Test onSuccess(UUID); then UUID(long, long) with one and one toString is '00000000-0000-0001-0000-000000000001'")
  void testOnSuccess_thenUuidWithOneAndOneToStringIs00000000000000010000000000000001() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Function<UUID, Object> function = mock(Function.class);
    when(function.apply(Mockito.<UUID>any())).thenReturn("Apply");

    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.put(UUID.randomUUID(), "42");
    ackMap.computeIfAbsent(new UUID(1L, 1L), function);
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, new ConcurrentHashMap<>());
    UUID id = new UUID(1L, 1L);

    // Act
    tbPackProcessingContext.onSuccess(id);

    // Assert
    verify(function).apply(isA(UUID.class));
    assertEquals("00000000-0000-0001-0000-000000000001", id.toString());
    ConcurrentMap<UUID, Object> ackMap2 = tbPackProcessingContext.getAckMap();
    assertEquals(1, ackMap2.size());
    assertSame(ackMap, ackMap2);
  }

  /**
   * Test {@link TbPackProcessingContext#onFailure(UUID, Throwable)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>When randomUUID.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbPackProcessingContext#onFailure(UUID, Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(UUID, Throwable); given Function apply(Object) return 'Apply'; when randomUUID; then calls apply(Object)")
  void testOnFailure_givenFunctionApplyReturnApply_whenRandomUUID_thenCallsApply() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Function<UUID, Object> function = mock(Function.class);
    when(function.apply(Mockito.<UUID>any())).thenReturn("Apply");

    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.computeIfAbsent(UUID.randomUUID(), function);
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, new ConcurrentHashMap<>());
    UUID id = UUID.randomUUID();

    // Act
    tbPackProcessingContext.onFailure(id, new Throwable());

    // Assert
    verify(function).apply(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbPackProcessingContext#getAckMap()}
   *   <li>{@link TbPackProcessingContext#getFailedMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, failedMap);

    // Act
    ConcurrentMap<UUID, Object> actualAckMap = tbPackProcessingContext.getAckMap();

    // Assert
    assertSame(ackMap, actualAckMap);
    assertSame(failedMap, tbPackProcessingContext.getFailedMap());
  }
}
