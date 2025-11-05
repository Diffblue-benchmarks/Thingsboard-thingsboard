package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.thingsboard.common.util.ThingsBoardForkJoinWorkerThreadFactory;

class TbAwsSqsAdminDiffblueTest {
  /**
   * Test {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code \.}.
   *   <li>Then calls {@link ListQueuesResult#getQueueUrls()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}
   */
  @Test
  @DisplayName(
      "Test new TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS); given ArrayList() add '\\.'; then calls getQueueUrls()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsSqsAdmin.<init>(TbAwsSqsSettings, Map, AmazonSQS)"})
  void testNewTbAwsSqsAdmin_givenArrayListAddBackslashDot_thenCallsGetQueueUrls()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[] {mock(InetAddress.class)});

      TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
      when(sqsSettings.getThreadPoolSize()).thenReturn(3);
      HashMap<String, String> attributes = new HashMap<>();

      ArrayList<String> stringList = new ArrayList<>();
      stringList.add("\\.");

      ListQueuesResult listQueuesResult = mock(ListQueuesResult.class);
      when(listQueuesResult.getQueueUrls()).thenReturn(stringList);

      AmazonSQSAsyncClient sqsClient = mock(AmazonSQSAsyncClient.class);
      when(sqsClient.listQueues()).thenReturn(listQueuesResult);

      // Act
      TbAwsSqsAdmin actualTbAwsSqsAdmin = new TbAwsSqsAdmin(sqsSettings, attributes, sqsClient);

      // Assert
      verify(sqsClient).listQueues();
      verify(listQueuesResult).getQueueUrls();
      verify(sqsSettings).getThreadPoolSize();
      ExecutorService producerExecutor = actualTbAwsSqsAdmin.getProducerExecutor();
      assertTrue(producerExecutor instanceof ForkJoinPool);
      assertTrue(
          ((ForkJoinPool) producerExecutor).getFactory()
              instanceof ThingsBoardForkJoinWorkerThreadFactory);
      assertNull(((ForkJoinPool) producerExecutor).getUncaughtExceptionHandler());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getActiveThreadCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getPoolSize());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getQueuedSubmissionCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getRunningThreadCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getQueuedTaskCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getStealCount());
      assertEquals(3, ((ForkJoinPool) producerExecutor).getParallelism());
      assertFalse(((ForkJoinPool) producerExecutor).isTerminating());
      assertTrue(((ForkJoinPool) producerExecutor).getAsyncMode());
    }
  }

  /**
   * Test {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code .}.
   *   <li>Then calls {@link ListQueuesResult#getQueueUrls()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}
   */
  @Test
  @DisplayName(
      "Test new TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS); given ArrayList() add '.'; then calls getQueueUrls()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsSqsAdmin.<init>(TbAwsSqsSettings, Map, AmazonSQS)"})
  void testNewTbAwsSqsAdmin_givenArrayListAddDot_thenCallsGetQueueUrls()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[] {mock(InetAddress.class)});

      TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
      when(sqsSettings.getThreadPoolSize()).thenReturn(3);
      HashMap<String, String> attributes = new HashMap<>();

      ArrayList<String> stringList = new ArrayList<>();
      stringList.add(".");
      stringList.add("/");

      ListQueuesResult listQueuesResult = mock(ListQueuesResult.class);
      when(listQueuesResult.getQueueUrls()).thenReturn(stringList);

      AmazonSQSAsyncClient sqsClient = mock(AmazonSQSAsyncClient.class);
      when(sqsClient.listQueues()).thenReturn(listQueuesResult);

      // Act
      TbAwsSqsAdmin actualTbAwsSqsAdmin = new TbAwsSqsAdmin(sqsSettings, attributes, sqsClient);

      // Assert
      verify(sqsClient).listQueues();
      verify(listQueuesResult).getQueueUrls();
      verify(sqsSettings).getThreadPoolSize();
      ExecutorService producerExecutor = actualTbAwsSqsAdmin.getProducerExecutor();
      assertTrue(producerExecutor instanceof ForkJoinPool);
      assertTrue(
          ((ForkJoinPool) producerExecutor).getFactory()
              instanceof ThingsBoardForkJoinWorkerThreadFactory);
      assertNull(((ForkJoinPool) producerExecutor).getUncaughtExceptionHandler());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getActiveThreadCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getPoolSize());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getQueuedSubmissionCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getRunningThreadCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getQueuedTaskCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getStealCount());
      assertEquals(3, ((ForkJoinPool) producerExecutor).getParallelism());
      assertFalse(((ForkJoinPool) producerExecutor).isTerminating());
      assertTrue(((ForkJoinPool) producerExecutor).getAsyncMode());
    }
  }

  /**
   * Test {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code /}.
   *   <li>Then calls {@link ListQueuesResult#getQueueUrls()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}
   */
  @Test
  @DisplayName(
      "Test new TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS); given ArrayList() add '/'; then calls getQueueUrls()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsSqsAdmin.<init>(TbAwsSqsSettings, Map, AmazonSQS)"})
  void testNewTbAwsSqsAdmin_givenArrayListAddSlash_thenCallsGetQueueUrls()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[] {mock(InetAddress.class)});

      TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
      when(sqsSettings.getThreadPoolSize()).thenReturn(3);
      HashMap<String, String> attributes = new HashMap<>();

      ArrayList<String> stringList = new ArrayList<>();
      stringList.add("/");

      ListQueuesResult listQueuesResult = mock(ListQueuesResult.class);
      when(listQueuesResult.getQueueUrls()).thenReturn(stringList);

      AmazonSQSAsyncClient sqsClient = mock(AmazonSQSAsyncClient.class);
      when(sqsClient.listQueues()).thenReturn(listQueuesResult);

      // Act
      TbAwsSqsAdmin actualTbAwsSqsAdmin = new TbAwsSqsAdmin(sqsSettings, attributes, sqsClient);

      // Assert
      verify(sqsClient).listQueues();
      verify(listQueuesResult).getQueueUrls();
      verify(sqsSettings).getThreadPoolSize();
      ExecutorService producerExecutor = actualTbAwsSqsAdmin.getProducerExecutor();
      assertTrue(producerExecutor instanceof ForkJoinPool);
      assertTrue(
          ((ForkJoinPool) producerExecutor).getFactory()
              instanceof ThingsBoardForkJoinWorkerThreadFactory);
      assertNull(((ForkJoinPool) producerExecutor).getUncaughtExceptionHandler());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getActiveThreadCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getPoolSize());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getQueuedSubmissionCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getRunningThreadCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getQueuedTaskCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getStealCount());
      assertEquals(3, ((ForkJoinPool) producerExecutor).getParallelism());
      assertFalse(((ForkJoinPool) producerExecutor).isTerminating());
      assertTrue(((ForkJoinPool) producerExecutor).getAsyncMode());
    }
  }

  /**
   * Test {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}.
   *
   * <ul>
   *   <li>Given {@link ListQueuesResult} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbAwsSqsAdmin#TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS)}
   */
  @Test
  @DisplayName(
      "Test new TbAwsSqsAdmin(TbAwsSqsSettings, Map, AmazonSQS); given ListQueuesResult (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsSqsAdmin.<init>(TbAwsSqsSettings, Map, AmazonSQS)"})
  void testNewTbAwsSqsAdmin_givenListQueuesResult() throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[] {mock(InetAddress.class)});

      TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
      when(sqsSettings.getThreadPoolSize()).thenReturn(3);
      HashMap<String, String> attributes = new HashMap<>();

      AmazonSQSAsyncClient sqsClient = mock(AmazonSQSAsyncClient.class);
      when(sqsClient.listQueues()).thenReturn(new ListQueuesResult());

      // Act
      TbAwsSqsAdmin actualTbAwsSqsAdmin = new TbAwsSqsAdmin(sqsSettings, attributes, sqsClient);

      // Assert
      verify(sqsClient).listQueues();
      verify(sqsSettings).getThreadPoolSize();
      ExecutorService producerExecutor = actualTbAwsSqsAdmin.getProducerExecutor();
      assertTrue(producerExecutor instanceof ForkJoinPool);
      assertTrue(
          ((ForkJoinPool) producerExecutor).getFactory()
              instanceof ThingsBoardForkJoinWorkerThreadFactory);
      assertNull(((ForkJoinPool) producerExecutor).getUncaughtExceptionHandler());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getActiveThreadCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getPoolSize());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getQueuedSubmissionCount());
      assertEquals(0, ((ForkJoinPool) producerExecutor).getRunningThreadCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getQueuedTaskCount());
      assertEquals(0L, ((ForkJoinPool) producerExecutor).getStealCount());
      assertEquals(3, ((ForkJoinPool) producerExecutor).getParallelism());
      assertFalse(((ForkJoinPool) producerExecutor).isTerminating());
      assertTrue(((ForkJoinPool) producerExecutor).getAsyncMode());
    }
  }
}
