package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import java.util.concurrent.Semaphore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbHttpClientDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbHttpClient#setEventLoopGroup(EventLoopGroup)}
   *   <li>{@link TbHttpClient#setSemaphore(Semaphore)}
   *   <li>{@link TbHttpClient#setWebClient(WebClient)}
   *   <li>{@link TbHttpClient#toString()}
   *   <li>{@link TbHttpClient#getConfig()}
   *   <li>{@link TbHttpClient#getEventLoopGroup()}
   *   <li>{@link TbHttpClient#getSemaphore()}
   *   <li>{@link TbHttpClient#getWebClient()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws TbNodeException {
    // Arrange
    TbRestApiCallNodeConfiguration config = new TbRestApiCallNodeConfiguration();
    TbHttpClient tbHttpClient = new TbHttpClient(config, new DefaultEventLoop());
    DefaultEventLoop eventLoopGroup = new DefaultEventLoop();

    // Act
    tbHttpClient.setEventLoopGroup(eventLoopGroup);
    Semaphore semaphore = new Semaphore(1);
    tbHttpClient.setSemaphore(semaphore);
    WebClient webClient = mock(WebClient.class);
    tbHttpClient.setWebClient(webClient);
    tbHttpClient.toString();
    TbRestApiCallNodeConfiguration actualConfig = tbHttpClient.getConfig();
    EventLoopGroup actualEventLoopGroup = tbHttpClient.getEventLoopGroup();
    Semaphore actualSemaphore = tbHttpClient.getSemaphore();

    // Assert that nothing has changed
    assertSame(eventLoopGroup, actualEventLoopGroup);
    assertSame(semaphore, actualSemaphore);
    assertSame(config, actualConfig);
    assertSame(webClient, tbHttpClient.getWebClient());
  }
}
