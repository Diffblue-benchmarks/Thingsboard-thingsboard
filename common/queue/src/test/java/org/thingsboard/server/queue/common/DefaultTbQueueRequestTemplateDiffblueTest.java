package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.common.DefaultTbQueueRequestTemplate.ResponseMetaData;

class DefaultTbQueueRequestTemplateDiffblueTest {
  /**
   * Test ResponseMetaData getters and setters.
   * <p>
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
  @DisplayName("Test ResponseMetaData getters and setters")
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
   * Test ResponseMetaData
   * {@link ResponseMetaData#ResponseMetaData(long, SettableFuture, long, long)}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueRequestTemplate.ResponseMetaData#ResponseMetaData(long, SettableFuture, long, long)}
   */
  @Test
  @DisplayName("Test ResponseMetaData new ResponseMetaData(long, SettableFuture, long, long)")
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
