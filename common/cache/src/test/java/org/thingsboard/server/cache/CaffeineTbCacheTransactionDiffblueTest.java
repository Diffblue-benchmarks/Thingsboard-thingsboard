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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CaffeineTbCacheTransactionDiffblueTest {
  /**
   * Test {@link CaffeineTbCacheTransaction#commit()}.
   *
   * <ul>
   *   <li>Given {@link CaffeineTbTransactionalCache} {@link
   *       CaffeineTbTransactionalCache#commit(UUID, Map)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineTbCacheTransaction#commit()}
   */
  @Test
  @DisplayName(
      "Test commit(); given CaffeineTbTransactionalCache commit(UUID, Map) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CaffeineTbCacheTransaction.commit()"})
  void testCommit_givenCaffeineTbTransactionalCacheCommitReturnFalse_thenReturnFalse() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache =
        mock(CaffeineTbTransactionalCache.class);
    when(cache.commit(Mockito.<UUID>any(), Mockito.<Map<Serializable, Serializable>>any()))
        .thenReturn(false);
    CaffeineTbCacheTransaction<Serializable, Serializable> caffeineTbCacheTransaction =
        new CaffeineTbCacheTransaction<>(cache, new ArrayList<>());

    // Act
    boolean actualCommitResult = caffeineTbCacheTransaction.commit();

    // Assert
    verify(cache).commit(isA(UUID.class), isA(Map.class));
    assertFalse(actualCommitResult);
  }

  /**
   * Test {@link CaffeineTbCacheTransaction#commit()}.
   *
   * <ul>
   *   <li>Given {@link CaffeineTbTransactionalCache} {@link
   *       CaffeineTbTransactionalCache#commit(UUID, Map)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineTbCacheTransaction#commit()}
   */
  @Test
  @DisplayName(
      "Test commit(); given CaffeineTbTransactionalCache commit(UUID, Map) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CaffeineTbCacheTransaction.commit()"})
  void testCommit_givenCaffeineTbTransactionalCacheCommitReturnTrue_thenReturnTrue() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache =
        mock(CaffeineTbTransactionalCache.class);
    when(cache.commit(Mockito.<UUID>any(), Mockito.<Map<Serializable, Serializable>>any()))
        .thenReturn(true);
    CaffeineTbCacheTransaction<Serializable, Serializable> caffeineTbCacheTransaction =
        new CaffeineTbCacheTransaction<>(cache, new ArrayList<>());

    // Act
    boolean actualCommitResult = caffeineTbCacheTransaction.commit();

    // Assert
    verify(cache).commit(isA(UUID.class), isA(Map.class));
    assertTrue(actualCommitResult);
  }

  /**
   * Test {@link CaffeineTbCacheTransaction#rollback()}.
   *
   * <p>Method under test: {@link CaffeineTbCacheTransaction#rollback()}
   */
  @Test
  @DisplayName("Test rollback()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CaffeineTbCacheTransaction.rollback()"})
  void testRollback() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache =
        mock(CaffeineTbTransactionalCache.class);
    doNothing().when(cache).rollback(Mockito.<UUID>any());
    CaffeineTbCacheTransaction<Serializable, Serializable> caffeineTbCacheTransaction =
        new CaffeineTbCacheTransaction<>(cache, new ArrayList<>());

    // Act
    caffeineTbCacheTransaction.rollback();

    // Assert
    verify(cache).rollback(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CaffeineTbCacheTransaction#setFailed(boolean)}
   *   <li>{@link CaffeineTbCacheTransaction#getId()}
   *   <li>{@link CaffeineTbCacheTransaction#getKeys()}
   *   <li>{@link CaffeineTbCacheTransaction#isFailed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UUID CaffeineTbCacheTransaction.getId()",
    "List CaffeineTbCacheTransaction.getKeys()",
    "boolean CaffeineTbCacheTransaction.isFailed()",
    "void CaffeineTbCacheTransaction.setFailed(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<Serializable> keys = new ArrayList<>();
    CaffeineTbCacheTransaction<Serializable, Serializable> caffeineTbCacheTransaction =
        new CaffeineTbCacheTransaction<>(null, keys);

    // Act
    caffeineTbCacheTransaction.setFailed(true);
    caffeineTbCacheTransaction.getId();
    List<Serializable> actualKeys = caffeineTbCacheTransaction.getKeys();
    boolean actualIsFailedResult = caffeineTbCacheTransaction.isFailed();

    // Assert
    assertTrue(actualKeys.isEmpty());
    assertTrue(actualIsFailedResult);
    assertSame(keys, actualKeys);
  }

  /**
   * Test {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache,
   * List)}.
   *
   * <ul>
   *   <li>Then return Keys is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  @DisplayName(
      "Test new CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List); then return Keys is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CaffeineTbCacheTransaction.<init>(CaffeineTbTransactionalCache, List)"})
  void testNewCaffeineTbCacheTransaction_thenReturnKeysIsArrayList() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache =
        mock(CaffeineTbTransactionalCache.class);

    ArrayList<Serializable> keys = new ArrayList<>();
    keys.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction =
        new CaffeineTbCacheTransaction<>(cache, keys);

    // Assert
    assertSame(keys, actualCaffeineTbCacheTransaction.getKeys());
  }

  /**
   * Test {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache,
   * List)}.
   *
   * <ul>
   *   <li>Then return Keys size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  @DisplayName(
      "Test new CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List); then return Keys size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CaffeineTbCacheTransaction.<init>(CaffeineTbTransactionalCache, List)"})
  void testNewCaffeineTbCacheTransaction_thenReturnKeysSizeIsTwo() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache =
        mock(CaffeineTbTransactionalCache.class);

    ArrayList<Serializable> keys = new ArrayList<>();
    keys.add(new SimpleDateFormat("yyyy/mm/dd"));
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    keys.add(simpleDateFormat);

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction =
        new CaffeineTbCacheTransaction<>(cache, keys);

    // Assert
    List<Serializable> keys2 = actualCaffeineTbCacheTransaction.getKeys();
    assertEquals(2, keys2.size());
    assertSame(simpleDateFormat, keys2.get(1));
  }

  /**
   * Test {@link CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Failed.
   * </ul>
   *
   * <p>Method under test: {@link
   * CaffeineTbCacheTransaction#CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List)}
   */
  @Test
  @DisplayName(
      "Test new CaffeineTbCacheTransaction(CaffeineTbTransactionalCache, List); when ArrayList(); then return not Failed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CaffeineTbCacheTransaction.<init>(CaffeineTbTransactionalCache, List)"})
  void testNewCaffeineTbCacheTransaction_whenArrayList_thenReturnNotFailed() {
    // Arrange
    CaffeineTbTransactionalCache<Serializable, Serializable> cache =
        mock(CaffeineTbTransactionalCache.class);

    // Act
    CaffeineTbCacheTransaction<Serializable, Serializable> actualCaffeineTbCacheTransaction =
        new CaffeineTbCacheTransaction<>(cache, new ArrayList<>());

    // Assert
    assertFalse(actualCaffeineTbCacheTransaction.isFailed());
    assertTrue(actualCaffeineTbCacheTransaction.getKeys().isEmpty());
  }
}
