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
package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbCoapDtlsSessionInMemoryStorageDiffblueTest {
  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#TbCoapDtlsSessionInMemoryStorage(long, long)}.
   *
   * <p>Method under test: {@link
   * TbCoapDtlsSessionInMemoryStorage#TbCoapDtlsSessionInMemoryStorage(long, long)}
   */
  @Test
  @DisplayName("Test new TbCoapDtlsSessionInMemoryStorage(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCoapDtlsSessionInMemoryStorage.<init>(long, long)"})
  void testNewTbCoapDtlsSessionInMemoryStorage() {
    // Arrange and Act
    TbCoapDtlsSessionInMemoryStorage actualTbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(1L, 1L);

    // Assert
    assertEquals(1L, actualTbCoapDtlsSessionInMemoryStorage.getDtlsSessionInactivityTimeout());
    assertEquals(1L, actualTbCoapDtlsSessionInMemoryStorage.getDtlsSessionReportTimeout());
    assertTrue(actualTbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap().isEmpty());
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#put(InetSocketAddress, TbCoapDtlsSessionInfo)}.
   *
   * <p>Method under test: {@link TbCoapDtlsSessionInMemoryStorage#put(InetSocketAddress,
   * TbCoapDtlsSessionInfo)}
   */
  @Test
  @DisplayName("Test put(InetSocketAddress, TbCoapDtlsSessionInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCoapDtlsSessionInMemoryStorage.put(InetSocketAddress, TbCoapDtlsSessionInfo)"
  })
  void testPut() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(1L, 1L);
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("localhost", 8080);

    TbCoapDtlsSessionInfo dtlsSessionInfo = mock(TbCoapDtlsSessionInfo.class);
    when(dtlsSessionInfo.getLastActivityTime()).thenReturn(1L);

    // Act
    tbCoapDtlsSessionInMemoryStorage.put(remotePeer, dtlsSessionInfo);

    // Assert
    verify(dtlsSessionInfo).getLastActivityTime();
    assertEquals(1, tbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap().size());
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#evictTimeoutSessions()}.
   *
   * <p>Method under test: {@link TbCoapDtlsSessionInMemoryStorage#evictTimeoutSessions()}
   */
  @Test
  @DisplayName("Test evictTimeoutSessions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCoapDtlsSessionInMemoryStorage.evictTimeoutSessions()"})
  void testEvictTimeoutSessions() {
    // Arrange
    TbCoapDtlsSessionInfo dtlsSessionInfo = mock(TbCoapDtlsSessionInfo.class);
    when(dtlsSessionInfo.getLastActivityTime()).thenReturn(1L);

    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(1L, 1L);
    tbCoapDtlsSessionInMemoryStorage.put(
        InetSocketAddress.createUnresolved("localhost", 8080), dtlsSessionInfo);

    // Act
    tbCoapDtlsSessionInMemoryStorage.evictTimeoutSessions();

    // Assert
    verify(dtlsSessionInfo, atLeast(1)).getLastActivityTime();
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#evictTimeoutSessions()}.
   *
   * <p>Method under test: {@link TbCoapDtlsSessionInMemoryStorage#evictTimeoutSessions()}
   */
  @Test
  @DisplayName("Test evictTimeoutSessions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCoapDtlsSessionInMemoryStorage.evictTimeoutSessions()"})
  void testEvictTimeoutSessions2() {
    // Arrange
    TbCoapDtlsSessionInfo dtlsSessionInfo = mock(TbCoapDtlsSessionInfo.class);
    when(dtlsSessionInfo.getLastActivityTime()).thenReturn(1L);

    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(Long.MAX_VALUE, 1L);
    tbCoapDtlsSessionInMemoryStorage.put(
        InetSocketAddress.createUnresolved("localhost", 8080), dtlsSessionInfo);

    // Act
    tbCoapDtlsSessionInMemoryStorage.evictTimeoutSessions();

    // Assert
    verify(dtlsSessionInfo, atLeast(1)).getLastActivityTime();
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}, and {@link
   * TbCoapDtlsSessionInMemoryStorage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapDtlsSessionInMemoryStorage.equals(Object)",
    "int TbCoapDtlsSessionInMemoryStorage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(1L, 1L);
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage2 =
        new TbCoapDtlsSessionInMemoryStorage(1L, 1L);

    // Act and Assert
    assertEquals(tbCoapDtlsSessionInMemoryStorage, tbCoapDtlsSessionInMemoryStorage2);
    assertEquals(
        tbCoapDtlsSessionInMemoryStorage.hashCode(), tbCoapDtlsSessionInMemoryStorage2.hashCode());
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}, and {@link
   * TbCoapDtlsSessionInMemoryStorage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapDtlsSessionInMemoryStorage.equals(Object)",
    "int TbCoapDtlsSessionInMemoryStorage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(1L, 1L);

    // Act and Assert
    assertEquals(tbCoapDtlsSessionInMemoryStorage, tbCoapDtlsSessionInMemoryStorage);
    int expectedHashCodeResult = tbCoapDtlsSessionInMemoryStorage.hashCode();
    assertEquals(expectedHashCodeResult, tbCoapDtlsSessionInMemoryStorage.hashCode());
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapDtlsSessionInMemoryStorage.equals(Object)",
    "int TbCoapDtlsSessionInMemoryStorage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(3L, 1L);

    // Act and Assert
    assertNotEquals(tbCoapDtlsSessionInMemoryStorage, new TbCoapDtlsSessionInMemoryStorage(1L, 1L));
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapDtlsSessionInMemoryStorage.equals(Object)",
    "int TbCoapDtlsSessionInMemoryStorage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(1L, 3L);

    // Act and Assert
    assertNotEquals(tbCoapDtlsSessionInMemoryStorage, new TbCoapDtlsSessionInMemoryStorage(1L, 1L));
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapDtlsSessionInMemoryStorage.equals(Object)",
    "int TbCoapDtlsSessionInMemoryStorage.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCoapDtlsSessionInMemoryStorage(1L, 1L), null);
  }

  /**
   * Test {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbCoapDtlsSessionInMemoryStorage.equals(Object)",
    "int TbCoapDtlsSessionInMemoryStorage.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbCoapDtlsSessionInMemoryStorage(1L, 1L),
        "Different type to TbCoapDtlsSessionInMemoryStorage");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#setDtlsSessionInactivityTimeout(long)}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#setDtlsSessionReportTimeout(long)}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#toString()}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#getDtlsSessionInactivityTimeout()}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#getDtlsSessionReportTimeout()}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#getDtlsSessionsMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long TbCoapDtlsSessionInMemoryStorage.getDtlsSessionInactivityTimeout()",
    "long TbCoapDtlsSessionInMemoryStorage.getDtlsSessionReportTimeout()",
    "java.util.concurrent.ConcurrentMap TbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap()",
    "void TbCoapDtlsSessionInMemoryStorage.setDtlsSessionInactivityTimeout(long)",
    "void TbCoapDtlsSessionInMemoryStorage.setDtlsSessionReportTimeout(long)",
    "String TbCoapDtlsSessionInMemoryStorage.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage =
        new TbCoapDtlsSessionInMemoryStorage(1L, 1L);

    // Act
    tbCoapDtlsSessionInMemoryStorage.setDtlsSessionInactivityTimeout(1L);
    tbCoapDtlsSessionInMemoryStorage.setDtlsSessionReportTimeout(1L);
    String actualToStringResult = tbCoapDtlsSessionInMemoryStorage.toString();
    long actualDtlsSessionInactivityTimeout =
        tbCoapDtlsSessionInMemoryStorage.getDtlsSessionInactivityTimeout();
    long actualDtlsSessionReportTimeout =
        tbCoapDtlsSessionInMemoryStorage.getDtlsSessionReportTimeout();

    // Assert
    assertEquals(
        "TbCoapDtlsSessionInMemoryStorage(dtlsSessionsMap={}, dtlsSessionInactivityTimeout=1, dtlsSessionReportTimeout"
            + "=1)",
        actualToStringResult);
    assertEquals(1L, actualDtlsSessionInactivityTimeout);
    assertEquals(1L, actualDtlsSessionReportTimeout);
    assertTrue(tbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap().isEmpty());
  }
}
