package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class SimpleListenableFutureDiffblueTest {
  /**
   * Test {@link SimpleListenableFuture#set(Object)}.
   * <ul>
   *   <li>Given {@link Executor} {@link Executor#execute(Runnable)} does nothing.</li>
   *   <li>When {@code Value}.</li>
   *   <li>Then calls {@link Executor#execute(Runnable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleListenableFuture#set(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SimpleListenableFuture.set(Object)"})
  public void testSet_givenExecutorExecuteDoesNothing_whenValue_thenCallsExecute()
      throws InterruptedException, ExecutionException {
    // Arrange
    Executor executor = mock(Executor.class);
    doNothing().when(executor).execute(Mockito.<Runnable>any());

    SimpleListenableFuture<Object> simpleListenableFuture = new SimpleListenableFuture<>();
    simpleListenableFuture.addListener(mock(Runnable.class), executor);

    // Act
    boolean actualSetResult = simpleListenableFuture.set("Value");

    // Assert
    verify(executor).execute(isA(Runnable.class));
    assertEquals("Value", simpleListenableFuture.get());
    assertTrue(simpleListenableFuture.isDone());
    assertTrue(actualSetResult);
  }

  /**
   * Test {@link SimpleListenableFuture#set(Object)}.
   * <ul>
   *   <li>Given {@link SimpleListenableFuture} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SimpleListenableFuture} (default constructor) is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleListenableFuture#set(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SimpleListenableFuture.set(Object)"})
  public void testSet_givenSimpleListenableFuture_whenNull_thenSimpleListenableFutureIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    SimpleListenableFuture<Object> simpleListenableFuture = new SimpleListenableFuture<>();

    // Act
    boolean actualSetResult = simpleListenableFuture.set(null);

    // Assert
    assertNull(simpleListenableFuture.get());
    assertTrue(simpleListenableFuture.isDone());
    assertTrue(actualSetResult);
  }

  /**
   * Test {@link SimpleListenableFuture#set(Object)}.
   * <ul>
   *   <li>Given {@link SimpleListenableFuture} (default constructor).</li>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link SimpleListenableFuture} (default constructor) is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleListenableFuture#set(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SimpleListenableFuture.set(Object)"})
  public void testSet_givenSimpleListenableFuture_whenValue_thenSimpleListenableFutureIsValue()
      throws InterruptedException, ExecutionException {
    // Arrange
    SimpleListenableFuture<Object> simpleListenableFuture = new SimpleListenableFuture<>();

    // Act
    boolean actualSetResult = simpleListenableFuture.set("Value");

    // Assert
    assertEquals("Value", simpleListenableFuture.get());
    assertTrue(simpleListenableFuture.isDone());
    assertTrue(actualSetResult);
  }
}
