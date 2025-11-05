package org.thingsboard.monitoring.client;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private TbStopWatch tbStopWatch;

  @InjectMocks private WsClientFactory wsClientFactory;

  /**
   * Test {@link WsClientFactory#createClient(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link WsClientFactory#createClient(String)}
   */
  @Test
  @DisplayName("Test createClient(String); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.monitoring.client.WsClient WsClientFactory.createClient(String)"
  })
  void testCreateClient_thenThrowIllegalStateException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    doThrow(new IllegalStateException()).when(tbStopWatch).start();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> wsClientFactory.createClient("ABC123"));
    verify(tbStopWatch).start();
  }
}
