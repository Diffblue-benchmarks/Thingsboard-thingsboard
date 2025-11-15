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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RpcRequestMetadataDiffblueTest {
  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and {@link RpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequestMetadata.equals(Object)", "int RpcRequestMetadata.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(null, 1);
    RpcRequestMetadata rpcRequestMetadata2 = new RpcRequestMetadata(null, 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata2);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and {@link RpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequestMetadata.equals(Object)", "int RpcRequestMetadata.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(new UUID(1L, 1L), 1);
    RpcRequestMetadata rpcRequestMetadata2 = new RpcRequestMetadata(new UUID(1L, 1L), 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata2);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and {@link RpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequestMetadata.equals(Object)", "int RpcRequestMetadata.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequestMetadata.equals(Object)", "int RpcRequestMetadata.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 1);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequestMetadata.equals(Object)", "int RpcRequestMetadata.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(null, 1);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequestMetadata.equals(Object)", "int RpcRequestMetadata.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 2);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequestMetadata.equals(Object)", "int RpcRequestMetadata.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcRequestMetadata(UUID.randomUUID(), 1), null);
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequestMetadata.equals(Object)", "int RpcRequestMetadata.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcRequestMetadata(UUID.randomUUID(), 1), "Different type to RpcRequestMetadata");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#RpcRequestMetadata(UUID, int)}
   *   <li>{@link RpcRequestMetadata#toString()}
   *   <li>{@link RpcRequestMetadata#getRequestId()}
   *   <li>{@link RpcRequestMetadata#getSessionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RpcRequestMetadata.<init>(UUID, int)", "int RpcRequestMetadata.getRequestId()",
      "UUID RpcRequestMetadata.getSessionId()", "java.lang.String RpcRequestMetadata.toString()"})
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    RpcRequestMetadata actualRpcRequestMetadata = new RpcRequestMetadata(sessionId, 1);
    actualRpcRequestMetadata.toString();
    int actualRequestId = actualRpcRequestMetadata.getRequestId();

    // Assert
    assertEquals(1, actualRequestId);
    assertSame(sessionId, actualRpcRequestMetadata.getSessionId());
  }
}
