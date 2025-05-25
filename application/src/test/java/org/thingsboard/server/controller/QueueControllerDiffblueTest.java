package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class QueueControllerDiffblueTest {
  @InjectMocks
  private QueueController queueController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link QueueController#getTenantQueuesByServiceType(String, int, int, String, String, String)}.
   * <p>
   * Method under test: {@link QueueController#getTenantQueuesByServiceType(String, int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantQueuesByServiceType(String, int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData QueueController.getTenantQueuesByServiceType(String, int, int, String, String, String)"})
  void testGetTenantQueuesByServiceType() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/queues")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
        .param("serviceType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(queueController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link QueueController#saveQueue(Queue, String)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then status four hundred fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueController#saveQueue(Queue, String)}
   */
  @Test
  @DisplayName("Test saveQueue(Queue, String); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Queue QueueController.saveQueue(Queue, String)"})
  void testSaveQueue_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/queues");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder paramResult = postResult.param("serviceType", "foo");

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    Queue queue = new Queue();
    queue.setConsumerPerPartition(true);
    queue.setCreatedTime(1L);
    queue.setId(null);
    queue.setName("Name");
    queue.setPackProcessingTimeout(1L);
    queue.setPartitions(1);
    queue.setPollInterval(42);
    queue.setProcessingStrategy(processingStrategy);
    queue.setSubmitStrategy(submitStrategy);
    queue.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    queue.setTopic("Topic");
    String content = (new ObjectMapper()).writeValueAsString(queue);
    MockHttpServletRequestBuilder requestBuilder = paramResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(queueController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }
}
