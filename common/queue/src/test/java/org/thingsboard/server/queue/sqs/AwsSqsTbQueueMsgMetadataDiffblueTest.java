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
package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.amazonaws.http.SdkHttpMetadata;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AwsSqsTbQueueMsgMetadataDiffblueTest {
  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}, and {@link
   * AwsSqsTbQueueMsgMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSqsTbQueueMsgMetadata.equals(Object)",
    "int AwsSqsTbQueueMsgMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata2 = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertEquals(awsSqsTbQueueMsgMetadata, awsSqsTbQueueMsgMetadata2);
    assertEquals(awsSqsTbQueueMsgMetadata.hashCode(), awsSqsTbQueueMsgMetadata2.hashCode());
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}, and {@link
   * AwsSqsTbQueueMsgMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSqsTbQueueMsgMetadata.equals(Object)",
    "int AwsSqsTbQueueMsgMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertEquals(awsSqsTbQueueMsgMetadata, awsSqsTbQueueMsgMetadata);
    int expectedHashCodeResult = awsSqsTbQueueMsgMetadata.hashCode();
    assertEquals(expectedHashCodeResult, awsSqsTbQueueMsgMetadata.hashCode());
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSqsTbQueueMsgMetadata.equals(Object)",
    "int AwsSqsTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AwsSqsTbQueueMsgMetadata(null), 1);
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSqsTbQueueMsgMetadata.equals(Object)",
    "int AwsSqsTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata =
        new AwsSqsTbQueueMsgMetadata(mock(SdkHttpMetadata.class));

    // Act and Assert
    assertNotEquals(awsSqsTbQueueMsgMetadata, new AwsSqsTbQueueMsgMetadata(null));
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSqsTbQueueMsgMetadata.equals(Object)",
    "int AwsSqsTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertNotEquals(
        awsSqsTbQueueMsgMetadata, new AwsSqsTbQueueMsgMetadata(mock(SdkHttpMetadata.class)));
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSqsTbQueueMsgMetadata.equals(Object)",
    "int AwsSqsTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AwsSqsTbQueueMsgMetadata(null), null);
  }

  /**
   * Test {@link AwsSqsTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSqsTbQueueMsgMetadata.equals(Object)",
    "int AwsSqsTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AwsSqsTbQueueMsgMetadata(null), "Different type to AwsSqsTbQueueMsgMetadata");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AwsSqsTbQueueMsgMetadata#AwsSqsTbQueueMsgMetadata(SdkHttpMetadata)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#toString()}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#getMetadata()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AwsSqsTbQueueMsgMetadata.<init>(SdkHttpMetadata)",
    "SdkHttpMetadata AwsSqsTbQueueMsgMetadata.getMetadata()",
    "String AwsSqsTbQueueMsgMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AwsSqsTbQueueMsgMetadata actualAwsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);
    String actualToStringResult = actualAwsSqsTbQueueMsgMetadata.toString();

    // Assert
    assertEquals("AwsSqsTbQueueMsgMetadata(metadata=null)", actualToStringResult);
    assertNull(actualAwsSqsTbQueueMsgMetadata.getMetadata());
  }
}
