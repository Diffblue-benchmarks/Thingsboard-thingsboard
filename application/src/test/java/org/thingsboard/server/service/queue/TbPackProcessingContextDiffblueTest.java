package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbPackProcessingContextDiffblueTest {
  /**
   * Test {@link TbPackProcessingContext#TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap)}.
   * <p>
   * Method under test: {@link TbPackProcessingContext#TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap)}
   */
  @Test
  @DisplayName("Test new TbPackProcessingContext(CountDownLatch, ConcurrentMap, ConcurrentMap)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackProcessingContext.<init>(CountDownLatch, ConcurrentMap, ConcurrentMap)"})
  void testNewTbPackProcessingContext() {
    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();

    // Act
    TbPackProcessingContext<Object> actualTbPackProcessingContext = new TbPackProcessingContext<>(
        processingTimeoutLatch, ackMap, failedMap);

    // Assert
    ConcurrentMap<UUID, Object> ackMap2 = actualTbPackProcessingContext.getAckMap();
    assertTrue(ackMap2.isEmpty());
    assertSame(ackMap, ackMap2);
    assertSame(failedMap, actualTbPackProcessingContext.getFailedMap());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPackProcessingContext.await(long, TimeUnit)"})
  void testAwait_givenCountDownLatchWithOne_thenReturnFalse() throws InterruptedException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPackProcessingContext.await(long, TimeUnit)"})
  void testAwait_givenCountDownLatchWithZero_thenReturnTrue() throws InterruptedException {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackProcessingContext.onSuccess(UUID)"})
  void testOnSuccess() {
    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, failedMap);

    // Act
    tbPackProcessingContext.onSuccess(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert that nothing has changed
    ConcurrentMap<UUID, Object> ackMap2 = tbPackProcessingContext.getAckMap();
    assertTrue(ackMap2.isEmpty());
    assertSame(ackMap, ackMap2);
    assertSame(failedMap, tbPackProcessingContext.getFailedMap());
  }

  /**
   * Test {@link TbPackProcessingContext#onSuccess(UUID)}.
   * <p>
   * Method under test: {@link TbPackProcessingContext#onSuccess(UUID)}
   */
  @Test
  @DisplayName("Test onSuccess(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackProcessingContext.onSuccess(UUID)"})
  void testOnSuccess2() {
    // Arrange
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.put(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "42");
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, failedMap);

    // Act
    tbPackProcessingContext.onSuccess(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertTrue(tbPackProcessingContext.getAckMap().isEmpty());
    assertSame(failedMap, tbPackProcessingContext.getFailedMap());
  }

  /**
   * Test {@link TbPackProcessingContext#onSuccess(UUID)}.
   * <p>
   * Method under test: {@link TbPackProcessingContext#onSuccess(UUID)}
   */
  @Test
  @DisplayName("Test onSuccess(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackProcessingContext.onSuccess(UUID)"})
  void testOnSuccess3() {
    // Arrange
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.put(UUID.randomUUID(), "42");
    ackMap.put(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "42");
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, failedMap);

    // Act
    tbPackProcessingContext.onSuccess(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    ConcurrentMap<UUID, Object> ackMap2 = tbPackProcessingContext.getAckMap();
    assertEquals(1, ackMap2.size());
    ConcurrentMap<UUID, Object> failedMap2 = tbPackProcessingContext.getFailedMap();
    assertTrue(failedMap2.isEmpty());
    assertSame(ackMap, ackMap2);
    assertSame(failedMap, failedMap2);
  }

  /**
   * Test {@link TbPackProcessingContext#onFailure(UUID, Throwable)}.
   * <p>
   * Method under test: {@link TbPackProcessingContext#onFailure(UUID, Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(UUID, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackProcessingContext.onFailure(UUID, Throwable)"})
  void testOnFailure() {
    // Arrange
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, failedMap);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    tbPackProcessingContext.onFailure(id, new Throwable());

    // Assert that nothing has changed
    ConcurrentMap<UUID, Object> ackMap2 = tbPackProcessingContext.getAckMap();
    assertTrue(ackMap2.isEmpty());
    assertSame(ackMap, ackMap2);
    assertSame(failedMap, tbPackProcessingContext.getFailedMap());
  }

  /**
   * Test {@link TbPackProcessingContext#onFailure(UUID, Throwable)}.
   * <p>
   * Method under test: {@link TbPackProcessingContext#onFailure(UUID, Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(UUID, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackProcessingContext.onFailure(UUID, Throwable)"})
  void testOnFailure2() {
    // Arrange
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.put(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "42");
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, failedMap);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    tbPackProcessingContext.onFailure(id, new Throwable());

    // Assert
    ConcurrentMap<UUID, Object> failedMap2 = tbPackProcessingContext.getFailedMap();
    assertEquals(1, failedMap2.size());
    ConcurrentMap<UUID, Object> ackMap2 = tbPackProcessingContext.getAckMap();
    assertTrue(ackMap2.isEmpty());
    assertSame(ackMap, ackMap2);
    assertSame(failedMap, failedMap2);
  }

  /**
   * Test {@link TbPackProcessingContext#onFailure(UUID, Throwable)}.
   * <p>
   * Method under test: {@link TbPackProcessingContext#onFailure(UUID, Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(UUID, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackProcessingContext.onFailure(UUID, Throwable)"})
  void testOnFailure3() {
    // Arrange
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();
    ackMap.put(UUID.randomUUID(), "42");
    ackMap.put(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "42");
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> failedMap = new ConcurrentHashMap<>();
    TbPackProcessingContext<Object> tbPackProcessingContext = new TbPackProcessingContext<>(processingTimeoutLatch,
        ackMap, failedMap);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    tbPackProcessingContext.onFailure(id, new Throwable());

    // Assert
    ConcurrentMap<UUID, Object> ackMap2 = tbPackProcessingContext.getAckMap();
    assertEquals(1, ackMap2.size());
    ConcurrentMap<UUID, Object> failedMap2 = tbPackProcessingContext.getFailedMap();
    assertEquals(1, failedMap2.size());
    assertSame(ackMap, ackMap2);
    assertSame(failedMap, failedMap2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConcurrentMap TbPackProcessingContext.getAckMap()",
      "ConcurrentMap TbPackProcessingContext.getFailedMap()"})
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
