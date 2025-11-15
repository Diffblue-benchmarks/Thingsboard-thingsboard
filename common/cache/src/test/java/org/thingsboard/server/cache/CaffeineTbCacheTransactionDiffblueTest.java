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
package org.thingsboard.server.cache;

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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CaffeineTbCacheTransactionDiffblueTest {
  /**
   * Method under test: {@link CaffeineTbCacheTransaction#commit()}
   */
  @Test
  void testCommit() {
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
   * Method under test: {@link CaffeineTbCacheTransaction#commit()}
   */
  @Test
  void testCommit2() {
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
   * Method under test: {@link CaffeineTbCacheTransaction#rollback()}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link CaffeineTbCacheTransaction#setFailed(boolean)}
   *   <li>{@link CaffeineTbCacheTransaction#getId()}
   *   <li>{@link CaffeineTbCacheTransaction#getKeys()}
   *   <li>{@link CaffeineTbCacheTransaction#isFailed()}
   * </ul>
   */
  @Test
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
   * Method under test:
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  void testNewCaffeineTbCacheTransaction() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);
    ArrayList<Serializable> keys = new ArrayList<>();

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, keys);

    // Assert
    assertFalse(actualCaffeineTbCacheTransaction.isFailed());
    List<Serializable> keys2 = actualCaffeineTbCacheTransaction.getKeys();
    assertTrue(keys2.isEmpty());
    assertSame(keys, keys2);
  }

  /**
   * Method under test:
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  void testNewCaffeineTbCacheTransaction2() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);

    ArrayList<Serializable> keys = new ArrayList<>();
    keys.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, keys);

    // Assert
    assertFalse(actualCaffeineTbCacheTransaction.isFailed());
    assertSame(keys, actualCaffeineTbCacheTransaction.getKeys());
  }

  /**
   * Method under test:
   * {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  void testNewCaffeineTbCacheTransaction3() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache = mock(CaffeineTbTransactionalCache.class);

    ArrayList<Serializable> keys = new ArrayList<>();
    keys.add(new SimpleDateFormat("yyyy/mm/dd"));
    keys.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction = new CaffeineTbCacheTransaction<>(
        cache, keys);

    // Assert
    assertFalse(actualCaffeineTbCacheTransaction.isFailed());
    assertSame(keys, actualCaffeineTbCacheTransaction.getKeys());
  }
}
