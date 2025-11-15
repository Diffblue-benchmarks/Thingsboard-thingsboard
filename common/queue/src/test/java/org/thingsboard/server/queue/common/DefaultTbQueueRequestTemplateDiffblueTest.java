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
package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.Test;

class DefaultTbQueueRequestTemplateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#toString()}
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#getExpTime()}
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#getFuture()}
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#getSubmitTime()}
   *   <li>{@link DefaultTbQueueRequestTemplate.ResponseMetaData#getTimeout()}
   * </ul>
   */
  @Test
  void testResponseMetaDataGettersAndSetters() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();
    DefaultTbQueueRequestTemplate.ResponseMetaData<Object> responseMetaData = new DefaultTbQueueRequestTemplate.ResponseMetaData<>(
        1L, future, 1L, 10L);

    // Act
    responseMetaData.toString();
    long actualExpTime = responseMetaData.getExpTime();
    SettableFuture<Object> actualFuture = responseMetaData.getFuture();
    long actualSubmitTime = responseMetaData.getSubmitTime();

    // Assert
    assertEquals(10L, responseMetaData.getTimeout());
    assertEquals(1L, actualExpTime);
    assertEquals(1L, actualSubmitTime);
    assertSame(future, actualFuture);
  }

  /**
   * Method under test:
   * {@link DefaultTbQueueRequestTemplate.ResponseMetaData#ResponseMetaData(long, SettableFuture, long, long)}
   */
  @Test
  void testResponseMetaDataNewResponseMetaData() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();

    // Act
    DefaultTbQueueRequestTemplate.ResponseMetaData<Object> actualResponseMetaData = new DefaultTbQueueRequestTemplate.ResponseMetaData<>(
        1L, future, 1L, 10L);

    // Assert
    assertEquals(10L, actualResponseMetaData.getTimeout());
    assertEquals(1L, actualResponseMetaData.getExpTime());
    assertEquals(1L, actualResponseMetaData.getSubmitTime());
    assertSame(future, actualResponseMetaData.getFuture());
  }
}
