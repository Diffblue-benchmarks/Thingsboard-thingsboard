package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class LwM2mClientContextImplDiffblueTest {
  @InjectMocks
  private LwM2mClientContextImpl lwM2mClientContextImpl;

  @Mock
  private LwM2mTransportContext lwM2mTransportContext;

  @Mock
  private TbLwM2MClientStore tbLwM2MClientStore;

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);

    // Act
    LwM2mClient actualClientByEndpoint = lwM2mClientContextImpl
        .getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
    assertSame(lwM2mClient, actualClientByEndpoint);
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint_thenThrowRuntimeException() {
    // Arrange
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenThrow(new RuntimeException("[{}] initialized new client."));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientStore).get(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code [{}] Client is already at sleeping: {}, ignoring event: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given RuntimeException(String) with '[{}] Client is already at sleeping: {}, ignoring event: {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenRuntimeExceptionWithClientIsAlreadyAtSleepingIgnoringEvent() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint())
        .thenThrow(new RuntimeException("[{}] Client is already at sleeping: {}, ignoring event: {}"));
    when(client.isAsleep()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client).getEndpoint();
    verify(client).isAsleep();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#isAsleep()} return {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given 'true'; when LwM2mClient isAsleep() return 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenTrue_whenLwM2mClientIsAsleepReturnTrue_thenReturnFalse() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(true);

    // Act
    boolean actualAsleepResult = lwM2mClientContextImpl.asleep(client);

    // Assert
    verify(client).getEndpoint();
    verify(client, atLeast(1)).isAsleep();
    assertFalse(actualAsleepResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient); given RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_givenRuntimeExceptionWithFoo() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSleepTask()).thenThrow(new RuntimeException("foo"));
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(lwM2mClientContextImpl.awake(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}.
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}
   */
  @Test
  @DisplayName("Test getClientByDeviceId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByDeviceId(UUID)"})
  void testGetClientByDeviceId() {
    // Arrange, Act and Assert
    assertNull(lwM2mClientContextImpl.getClientByDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }
}
