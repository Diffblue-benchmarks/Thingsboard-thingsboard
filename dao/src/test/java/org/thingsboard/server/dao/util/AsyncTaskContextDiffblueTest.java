package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class AsyncTaskContextDiffblueTest {
  /**
   * Test {@link AsyncTaskContext#equals(Object)}, and
   * {@link AsyncTaskContext#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AsyncTaskContext#equals(Object)}
   *   <li>{@link AsyncTaskContext#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, null, null,
        1L);
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext2 = new AsyncTaskContext<>(ModelConstants.NULL_UUID, null, null,
        1L);

    // Act and Assert
    assertEquals(asyncTaskContext, asyncTaskContext2);
    int expectedHashCodeResult = asyncTaskContext.hashCode();
    assertEquals(expectedHashCodeResult, asyncTaskContext2.hashCode());
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}, and
   * {@link AsyncTaskContext#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AsyncTaskContext#equals(Object)}
   *   <li>{@link AsyncTaskContext#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask,
        future, 1L);

    // Act and Assert
    assertEquals(asyncTaskContext, asyncTaskContext);
    int expectedHashCodeResult = asyncTaskContext.hashCode();
    assertEquals(expectedHashCodeResult, asyncTaskContext.hashCode());
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask,
        future, 1L);
    AsyncTask asyncTask2 = mock(AsyncTask.class);
    SettableFuture<Object> future2 = SettableFuture.create();

    // Act and Assert
    assertNotEquals(asyncTaskContext, new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask2, future2, 1L));
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID id = UUID.randomUUID();
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(id, asyncTask, future, 1L);
    AsyncTask asyncTask2 = mock(AsyncTask.class);
    SettableFuture<Object> future2 = SettableFuture.create();

    // Act and Assert
    assertNotEquals(asyncTaskContext, new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask2, future2, 1L));
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(null, asyncTask, future, 1L);
    AsyncTask asyncTask2 = mock(AsyncTask.class);
    SettableFuture<Object> future2 = SettableFuture.create();

    // Act and Assert
    assertNotEquals(asyncTaskContext, new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask2, future2, 1L));
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, null,
        future, 1L);
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future2 = SettableFuture.create();

    // Act and Assert
    assertNotEquals(asyncTaskContext, new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask, future2, 1L));
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask,
        future, 3L);
    AsyncTask asyncTask2 = mock(AsyncTask.class);
    SettableFuture<Object> future2 = SettableFuture.create();

    // Act and Assert
    assertNotEquals(asyncTaskContext, new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask2, future2, 1L));
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(null, asyncTask, future, 1L);
    AsyncTask asyncTask2 = mock(AsyncTask.class);
    SettableFuture<Object> future2 = SettableFuture.create();

    // Act and Assert
    assertNotEquals(asyncTaskContext, new AsyncTaskContext<>(null, asyncTask2, future2, 1L));
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, null,
        future, 1L);
    SettableFuture<Object> future2 = SettableFuture.create();

    // Act and Assert
    assertNotEquals(asyncTaskContext, new AsyncTaskContext<>(ModelConstants.NULL_UUID, null, future2, 1L));
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, null, null,
        1L);
    SettableFuture<Object> future = SettableFuture.create();

    // Act and Assert
    assertNotEquals(asyncTaskContext, new AsyncTaskContext<>(ModelConstants.NULL_UUID, null, future, 1L));
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask,
        future, 1L);

    // Act and Assert
    assertNotEquals(asyncTaskContext, null);
  }

  /**
   * Test {@link AsyncTaskContext#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AsyncTaskContext#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();
    AsyncTaskContext<AsyncTask, Object> asyncTaskContext = new AsyncTaskContext<>(ModelConstants.NULL_UUID, asyncTask,
        future, 1L);

    // Act and Assert
    assertNotEquals(asyncTaskContext, "Different type to AsyncTaskContext");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AsyncTaskContext#AsyncTaskContext(UUID, AsyncTask, SettableFuture, long)}
   *   <li>{@link AsyncTaskContext#toString()}
   *   <li>{@link AsyncTaskContext#getCreateTime()}
   *   <li>{@link AsyncTaskContext#getFuture()}
   *   <li>{@link AsyncTaskContext#getId()}
   *   <li>{@link AsyncTaskContext#getTask()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    UUID id = ModelConstants.NULL_UUID;
    AsyncTask asyncTask = mock(AsyncTask.class);
    SettableFuture<Object> future = SettableFuture.create();

    // Act
    AsyncTaskContext<AsyncTask, Object> actualAsyncTaskContext = new AsyncTaskContext<>(id, asyncTask, future, 1L);
    actualAsyncTaskContext.toString();
    long actualCreateTime = actualAsyncTaskContext.getCreateTime();
    SettableFuture<Object> actualFuture = actualAsyncTaskContext.getFuture();
    UUID actualId = actualAsyncTaskContext.getId();
    AsyncTask actualTask = actualAsyncTaskContext.getTask();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualId.toString());
    assertEquals(1L, actualCreateTime);
    assertSame(future, actualFuture);
    assertSame(id, actualId);
    assertSame(asyncTask, actualTask);
  }
}
