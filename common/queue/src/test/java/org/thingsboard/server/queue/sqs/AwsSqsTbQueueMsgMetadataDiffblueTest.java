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
import org.junit.jupiter.api.Test;

class AwsSqsTbQueueMsgMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata2 = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertEquals(awsSqsTbQueueMsgMetadata, awsSqsTbQueueMsgMetadata2);
    int expectedHashCodeResult = awsSqsTbQueueMsgMetadata.hashCode();
    assertEquals(expectedHashCodeResult, awsSqsTbQueueMsgMetadata2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertEquals(awsSqsTbQueueMsgMetadata, awsSqsTbQueueMsgMetadata);
    int expectedHashCodeResult = awsSqsTbQueueMsgMetadata.hashCode();
    assertEquals(expectedHashCodeResult, awsSqsTbQueueMsgMetadata.hashCode());
  }

  /**
   * Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(mock(SdkHttpMetadata.class));

    // Act and Assert
    assertNotEquals(awsSqsTbQueueMsgMetadata, new AwsSqsTbQueueMsgMetadata(null));
  }

  /**
   * Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AwsSqsTbQueueMsgMetadata awsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);

    // Act and Assert
    assertNotEquals(awsSqsTbQueueMsgMetadata, new AwsSqsTbQueueMsgMetadata(mock(SdkHttpMetadata.class)));
  }

  /**
   * Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AwsSqsTbQueueMsgMetadata(null), null);
  }

  /**
   * Method under test: {@link AwsSqsTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AwsSqsTbQueueMsgMetadata(null), "Different type to AwsSqsTbQueueMsgMetadata");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AwsSqsTbQueueMsgMetadata#AwsSqsTbQueueMsgMetadata(SdkHttpMetadata)}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#toString()}
   *   <li>{@link AwsSqsTbQueueMsgMetadata#getMetadata()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AwsSqsTbQueueMsgMetadata actualAwsSqsTbQueueMsgMetadata = new AwsSqsTbQueueMsgMetadata(null);
    String actualToStringResult = actualAwsSqsTbQueueMsgMetadata.toString();

    // Assert
    assertEquals("AwsSqsTbQueueMsgMetadata(metadata=null)", actualToStringResult);
    assertNull(actualAwsSqsTbQueueMsgMetadata.getMetadata());
  }
}
