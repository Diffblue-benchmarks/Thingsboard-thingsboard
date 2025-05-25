package org.thingsboard.monitoring.client;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.monitoring.util.TbStopWatch;

@ExtendWith(MockitoExtension.class)
class WsClientFactoryDiffblueTest {
  @Mock
  private TbStopWatch tbStopWatch;

  @InjectMocks
  private WsClientFactory wsClientFactory;

  /**
   * Test {@link WsClientFactory#createClient(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WsClientFactory#createClient(String)}
   */
  @Test
  @DisplayName("Test createClient(String); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.monitoring.client.WsClient WsClientFactory.createClient(String)"})
  void testCreateClient_thenThrowIllegalStateException() throws Exception {
    // Arrange
    doThrow(new IllegalStateException("wss")).when(tbStopWatch).start();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> wsClientFactory.createClient("ABC123"));
    verify(tbStopWatch).start();
  }
}
