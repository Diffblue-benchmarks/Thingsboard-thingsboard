package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CaffeineTbCacheTransactionDiffblueTest {
  /**
   * Test {@link CaffeineTbCacheTransaction#commit()}.
   * <ul>
   *   <li>Given {@link CaffeineTbTransactionalCache}
   * {@link CaffeineTbTransactionalCache#commit(UUID, Map)} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CaffeineTbCacheTransaction#commit()}
   */
  @Test
  @DisplayName("Test commit(); given CaffeineTbTransactionalCache commit(UUID, Map) return 'false'; then return 'false'")
  void testCommit_givenCaffeineTbTransactionalCacheCommitReturnFalse_thenReturnFalse() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);
    when(cache.commit(Mockito.<UUID>any(), Mockito.<Map<Serializable, Serializable>>any())).thenReturn(false);
    CaffeineTbCacheTransaction<Serializable, Serializable> caffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, new ArrayList<>());

    // Act
    boolean actualCommitResult = caffeineTbCacheTransaction.commit();

    // Assert
    verify(cache).commit(isA(UUID.class), isA(Map.class));
    assertFalse(actualCommitResult);
  }

  /**
   * Test {@link CaffeineTbCacheTransaction#commit()}.
   * <ul>
   *   <li>Given {@link CaffeineTbTransactionalCache}
   * {@link CaffeineTbTransactionalCache#commit(UUID, Map)} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CaffeineTbCacheTransaction#commit()}
   */
  @Test
  @DisplayName("Test commit(); given CaffeineTbTransactionalCache commit(UUID, Map) return 'true'; then return 'true'")
  void testCommit_givenCaffeineTbTransactionalCacheCommitReturnTrue_thenReturnTrue() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);
    when(cache.commit(Mockito.<UUID>any(), Mockito.<Map<Serializable, Serializable>>any())).thenReturn(true);
    CaffeineTbCacheTransaction<Serializable, Serializable> caffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, new ArrayList<>());

    // Act
    boolean actualCommitResult = caffeineTbCacheTransaction.commit();

    // Assert
    verify(cache).commit(isA(UUID.class), isA(Map.class));
    assertTrue(actualCommitResult);
  }

  /**
   * Test {@link CaffeineTbCacheTransaction#rollback()}.
   * <p>
   * Method under test: {@link CaffeineTbCacheTransaction#rollback()}
   */
  @Test
  @DisplayName("Test rollback()")
  void testRollback() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);
    doNothing().when(cache).rollback(Mockito.<UUID>any());
    CaffeineTbCacheTransaction<Serializable, Serializable> caffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, new ArrayList<>());

    // Act
    caffeineTbCacheTransaction.rollback();

    // Assert that nothing has changed
    verify(cache).rollback(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CaffeineTbCacheTransaction#setFailed(boolean)}
   *   <li>{@link CaffeineTbCacheTransaction#getId()}
   *   <li>{@link CaffeineTbCacheTransaction#getKeys()}
   *   <li>{@link CaffeineTbCacheTransaction#isFailed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ArrayList<Serializable> keys = new ArrayList<>();
    CaffeineTbCacheTransaction<Serializable, Serializable> caffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        null, keys);

    // Act
    caffeineTbCacheTransaction.setFailed(true);
    caffeineTbCacheTransaction.getId();
    List<Serializable> actualKeys = caffeineTbCacheTransaction.getKeys();
    boolean actualIsFailedResult = caffeineTbCacheTransaction.isFailed();

    // Assert that nothing has changed
    assertTrue(actualKeys.isEmpty());
    assertTrue(actualIsFailedResult);
    assertSame(keys, actualKeys);
  }

  /**
   * Test
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}.
   * <ul>
   *   <li>Then return Keys size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  @DisplayName("Test new CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List); then return Keys size is one")
  void testNewCaffeineTbCacheTransaction_thenReturnKeysSizeIsOne() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);

    ArrayList<Serializable> keys = new ArrayList<>();
    keys.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, keys);

    // Assert
    assertEquals(1, actualCaffeineTbCacheTransaction.getKeys().size());
  }

  /**
   * Test
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}.
   * <ul>
   *   <li>Then return Keys size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  @DisplayName("Test new CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List); then return Keys size is two")
  void testNewCaffeineTbCacheTransaction_thenReturnKeysSizeIsTwo() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);

    ArrayList<Serializable> keys = new ArrayList<>();
    keys.add(new SimpleDateFormat("yyyy/mm/dd"));
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    keys.add(simpleDateFormat);

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, keys);

    // Assert
    List<Serializable> keys2 = actualCaffeineTbCacheTransaction.getKeys();
    assertEquals(2, keys2.size());
    assertSame(simpleDateFormat, keys2.get(1));
  }

  /**
   * Test
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Failed.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  @DisplayName("Test new CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List); when ArrayList(); then return not Failed")
  void testNewCaffeineTbCacheTransaction_whenArrayList_thenReturnNotFailed() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, new ArrayList<>());

    // Assert
    assertFalse(actualCaffeineTbCacheTransaction.isFailed());
    assertTrue(actualCaffeineTbCacheTransaction.getKeys().isEmpty());
  }
}
