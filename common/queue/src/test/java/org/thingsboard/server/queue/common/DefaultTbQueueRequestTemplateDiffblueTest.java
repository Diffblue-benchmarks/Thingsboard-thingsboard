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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.common.DefaultTbQueueRequestTemplate.ResponseMetaData;

class DefaultTbQueueRequestTemplateDiffblueTest {
  /**
   * Test ResponseMetaData getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResponseMetaData#toString()}
   *   <li>{@link ResponseMetaData#getExpTime()}
   *   <li>{@link ResponseMetaData#getFuture()}
   *   <li>{@link ResponseMetaData#getSubmitTime()}
   *   <li>{@link ResponseMetaData#getTimeout()}
   * </ul>
   */
  @Test
  @DisplayName("Test ResponseMetaData getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long ResponseMetaData.getExpTime()", "SettableFuture ResponseMetaData.getFuture()",
      "long ResponseMetaData.getSubmitTime()", "long ResponseMetaData.getTimeout()",
      "java.lang.String ResponseMetaData.toString()"})
  void testResponseMetaDataGettersAndSetters() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();
    ResponseMetaData<Object> responseMetaData = new ResponseMetaData<>(1L, future, 1L, 10L);

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
   * Test ResponseMetaData {@link ResponseMetaData#ResponseMetaData(long, SettableFuture, long, long)}.
   * <p>
   * Method under test: {@link ResponseMetaData#ResponseMetaData(long, SettableFuture, long, long)}
   */
  @Test
  @DisplayName("Test ResponseMetaData new ResponseMetaData(long, SettableFuture, long, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResponseMetaData.<init>(long, SettableFuture, long, long)"})
  void testResponseMetaDataNewResponseMetaData() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();

    // Act
    ResponseMetaData<Object> actualResponseMetaData = new ResponseMetaData<>(1L, future, 1L, 10L);

    // Assert
    assertEquals(10L, actualResponseMetaData.getTimeout());
    assertEquals(1L, actualResponseMetaData.getExpTime());
    assertEquals(1L, actualResponseMetaData.getSubmitTime());
    assertSame(future, actualResponseMetaData.getFuture());
  }
}
