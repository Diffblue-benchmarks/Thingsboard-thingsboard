package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.device.data.PowerMode;

@ExtendWith(MockitoExtension.class)
class DefaultCoapClientContextDiffblueTest {
  @InjectMocks
  private DefaultCoapClientContext defaultCoapClientContext;

  /**
   * Test {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}.
   * <ul>
   *   <li>When {@code ABC123}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}
   */
  @Test
  @DisplayName("Test getNotificationCounterByToken(String); when 'ABC123'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.atomic.AtomicInteger DefaultCoapClientContext.getNotificationCounterByToken(String)"})
  void testGetNotificationCounterByToken_whenAbc123_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(defaultCoapClientContext.getNotificationCounterByToken("ABC123"));
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName("Test awake(TbCoapClientState) with 'client'; given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
    TbCoapClientState client = mock(TbCoapClientState.class);
    doThrow(new IllegalArgumentException("foo")).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.awake(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName("Test awake(TbCoapClientState) with 'client'; when TbCoapClientState(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_whenTbCoapClientStateWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultCoapClientContext.awake(new TbCoapClientState(null)));
  }
}
