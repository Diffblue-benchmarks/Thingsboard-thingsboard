package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;
import org.eclipse.leshan.server.registration.Registration;
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
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbMainSecurityStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class LwM2mClientContextImplDiffblueTest {
  @InjectMocks private LwM2mClientContextImpl lwM2mClientContextImpl;

  @Mock private LwM2mTransportContext lwM2mTransportContext;

  @Mock private TbLwM2MClientStore tbLwM2MClientStore;

  @Mock private TbMainSecurityStore tbMainSecurityStore;

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    when(tbLwM2MClientStore.getAll())
        .thenThrow(new RuntimeException("Fetched clients from store: {}"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.init());
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).getAll();
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doThrow(new RuntimeException("Fetched clients from store: {}")).when(lwM2mClient).lock();
    doThrow(new RuntimeException("Fetched clients from store: {}")).when(lwM2mClient).unlock();
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<LwM2mClient> lwM2mClientSet = new HashSet<>();
    lwM2mClientSet.add(lwM2mClient);
    when(tbLwM2MClientStore.getAll()).thenReturn(lwM2mClientSet);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.init());
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClient).lock();
    verify(lwM2mClient).unlock();
    verify(tbLwM2MClientStore).getAll();
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_thenCallsGetEndpoint2() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    doThrow(new RuntimeException("Fetched clients from store: {}")).when(lwM2mClient).lock();
    doThrow(new RuntimeException("Fetched clients from store: {}")).when(lwM2mClient).unlock();
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<LwM2mClient> lwM2mClientSet = new HashSet<>();
    lwM2mClientSet.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    lwM2mClientSet.add(lwM2mClient);
    when(tbLwM2MClientStore.getAll()).thenReturn(lwM2mClientSet);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.init());
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClient).lock();
    verify(lwM2mClient).unlock();
    verify(tbLwM2MClientStore).getAll();
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link LwM2mClientContextImpl} LwM2mClients Empty.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); then LwM2mClientContextImpl LwM2mClients Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_thenLwM2mClientContextImplLwM2mClientsEmpty() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    when(tbLwM2MClientStore.getAll()).thenReturn(new HashSet<>());

    // Act
    lwM2mClientContextImpl.init();

    // Assert that nothing has changed
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).getAll();
    assertTrue(lwM2mClientContextImpl.getLwM2mClients().isEmpty());
  }

  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link LwM2mClientContextImpl} LwM2mClients size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); then LwM2mClientContextImpl LwM2mClients size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.init()"})
  void testInit_thenLwM2mClientContextImplLwM2mClientsSizeIsOne() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");

    HashSet<LwM2mClient> lwM2mClientSet = new HashSet<>();
    lwM2mClientSet.add(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    when(tbLwM2MClientStore.getAll()).thenReturn(lwM2mClientSet);

    // Act
    lwM2mClientContextImpl.init();

    // Assert
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).getAll();
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
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
    LwM2mClient actualClientByEndpoint =
        lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
    assertSame(lwM2mClient, actualClientByEndpoint);
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint2() {
    // Arrange
    when(tbLwM2MClientStore.get(Mockito.<String>any()))
        .thenThrow(new RuntimeException("[{}] initialized new client."));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MClientStore).get(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getRegistration()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String); then calls getRegistration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint_thenCallsGetRegistration() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getRegistration())
        .thenThrow(new RuntimeException("[{}] fetched client from store: {}"));
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getRegistration();
    verify(tbLwM2MClientStore).get(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   *
   * <ul>
   *   <li>Then return NodeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String); then return NodeId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByEndpoint(String)"})
  void testGetClientByEndpoint_thenReturnNodeIdIs42() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(null);

    // Act
    LwM2mClient actualClientByEndpoint =
        lwM2mClientContextImpl.getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mTransportContext).getNodeId();
    verify(tbLwM2MClientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    assertEquals("42", actualClientByEndpoint.getNodeId());
    assertEquals("https://config.us-east-2.amazonaws.com", actualClientByEndpoint.getEndpoint());
    assertNull(actualClientByEndpoint.getEdrxCycle());
    assertNull(actualClientByEndpoint.getPagingTransmissionWindow());
    assertNull(actualClientByEndpoint.getPsmActivityTimer());
    assertNull(actualClientByEndpoint.getSupportedClientObjects());
    assertNull(actualClientByEndpoint.getClientSupportContentFormats());
    assertNull(actualClientByEndpoint.getDeviceId());
    assertNull(actualClientByEndpoint.getLastSentRpcId());
    assertNull(actualClientByEndpoint.getProfileId());
    assertNull(actualClientByEndpoint.getSleepTask());
    assertNull(actualClientByEndpoint.getDefaultContentFormat());
    assertNull(actualClientByEndpoint.getRegistration());
    assertNull(actualClientByEndpoint.getPowerMode());
    assertNull(actualClientByEndpoint.getTenantId());
    assertNull(actualClientByEndpoint.getSession());
    assertEquals(0L, actualClientByEndpoint.getLastUplinkTime());
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
    assertEquals(LwM2MClientState.CREATED, actualClientByEndpoint.getState());
    assertFalse(actualClientByEndpoint.isAsleep());
    assertTrue(actualClientByEndpoint.getKeyTsLatestMap().isEmpty());
    assertTrue(actualClientByEndpoint.getResources().isEmpty());
    assertTrue(actualClientByEndpoint.getSharedAttributes().isEmpty());
  }

  /**
   * Test {@link LwM2mClientContextImpl#register(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#register(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test register(LwM2mClient, Registration); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional LwM2mClientContextImpl.register(LwM2mClient, Registration)"
  })
  void testRegister_thenThrowRuntimeException() throws LwM2MClientStateException {
    // Arrange
    when(tbMainSecurityStore.getTbLwM2MSecurityInfoByEndpoint(Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            lwM2mClientContextImpl.register(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
    verify(tbMainSecurityStore)
        .getTbLwM2MSecurityInfoByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code [{}] Client is
   *       already at sleeping: {}, ignoring event: {}}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given RuntimeException(String) with '[{}] Client is already at sleeping: {}, ignoring event: {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_givenRuntimeExceptionWithClientIsAlreadyAtSleepingIgnoringEvent() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint())
        .thenThrow(
            new RuntimeException("[{}] Client is already at sleeping: {}, ignoring event: {}"));
    when(client.isAsleep()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client).getEndpoint();
    verify(client).isAsleep();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#isAsleep()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); given 'true'; when LwM2mClient isAsleep() return 'true'; then return 'false'")
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
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#setAsleep(boolean)} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code [{}] Switch sleeping from: {} to:
   *       {}}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test asleep(LwM2mClient); when LwM2mClient setAsleep(boolean) throw RuntimeException(String) with '[{}] Switch sleeping from: {} to: {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.asleep(LwM2mClient)"})
  void testAsleep_whenLwM2mClientSetAsleepThrowRuntimeExceptionWithSwitchSleepingFromTo() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException("[{}] Switch sleeping from: {} to: {}"))
        .when(client)
        .setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client).getEndpoint();
    verify(client).getPowerMode();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).setAsleep(eq(true));
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake() {
    // Arrange, Act and Assert
    assertFalse(
        lwM2mClientContextImpl.awake(
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#isAsleep()} return {@code false}.
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); given 'false'; when LwM2mClient isAsleep() return 'false'; then calls getProfileId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_givenFalse_whenLwM2mClientIsAsleepReturnFalse_thenCallsGetProfileId() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(false);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.updateLastUplinkTime()).thenReturn(1L);

    // Act
    boolean actualAwakeResult = lwM2mClientContextImpl.awake(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client, atLeast(1)).isAsleep();
    verify(client).updateLastUplinkTime();
    assertFalse(actualAwakeResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getSleepTask()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); when LwM2mClient getSleepTask() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_whenLwM2mClientGetSleepTaskThrowRuntimeExceptionWithFoo() {
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
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#lock()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test awake(LwM2mClient); when LwM2mClient lock() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.awake(LwM2mClient)"})
  void testAwake_whenLwM2mClientLockThrowRuntimeExceptionWithFoo() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException("foo")).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration() throws LwM2MClientStateException {
    // Arrange, Act and Assert
    assertThrows(
        LwM2MClientStateException.class,
        () ->
            lwM2mClientContextImpl.updateRegistration(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration2() throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException("[{}] Client is already at sleeping: {}, ignoring event: {}"))
        .when(client)
        .setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getState();
    verify(client).lock();
    verify(client).setRegistration(isNull());
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration3() throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPsmActivityTimer()).thenThrow(new RuntimeException("foo"));
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@code CREATED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code CREATED}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_givenCreated_whenLwM2mClientGetStateReturnCreated()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        LwM2MClientStateException.class,
        () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); given 'false'; then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_givenFalse_thenCallsGetEndpoint() throws LwM2MClientStateException {
    // Arrange
    doNothing().when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(false);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.updateLastUplinkTime()).thenReturn(1L);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.updateRegistration(client, null);

    // Assert
    verify(client).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).setRegistration(isNull());
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getSleepTask()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient,
   * Registration)}
   */
  @Test
  @DisplayName(
      "Test updateRegistration(LwM2mClient, Registration); when LwM2mClient getSleepTask() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.updateRegistration(LwM2mClient, Registration)"})
  void testUpdateRegistration_whenLwM2mClientGetSleepTaskThrowRuntimeExceptionWithFoo()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSleepTask()).thenThrow(new RuntimeException("foo"));
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test unregister(LwM2mClient, Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.unregister(LwM2mClient, Registration)"})
  void testUnregister() throws LwM2MClientStateException {
    // Arrange, Act and Assert
    assertThrows(
        LwM2MClientStateException.class,
        () ->
            lwM2mClientContextImpl.unregister(
                new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
  }

  /**
   * Test {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@code CREATED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code CREATED}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName(
      "Test unregister(LwM2mClient, Registration); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.unregister(LwM2mClient, Registration)"})
  void testUnregister_givenCreated_whenLwM2mClientGetStateReturnCreated()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(
        LwM2MClientStateException.class, () -> lwM2mClientContextImpl.unregister(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName(
      "Test unregister(LwM2mClient, Registration); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.unregister(LwM2mClient, Registration)"})
  void testUnregister_givenRuntimeExceptionWithFoo_thenThrowRuntimeException()
      throws LwM2MClientStateException {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new RuntimeException("foo"));
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    Registration registration = mock(Registration.class);
    when(registration.getId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.unregister(client, registration));
    verify(registration).getId();
    verify(client).getRegistration();
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient); given 'https://config.us-east-2.amazonaws.com'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.update(LwM2mClient)"})
  void testUpdate_givenHttpsConfigUsEast2AmazonawsCom() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getEndpoint();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code [{}] Client is in
   *       invalid state: {}!}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test update(LwM2mClient); given RuntimeException(String) with '[{}] Client is in invalid state: {}!'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.update(LwM2mClient)"})
  void testUpdate_givenRuntimeExceptionWithClientIsInInvalidState() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint())
        .thenThrow(new RuntimeException("[{}] Client is in invalid state: {}!"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.update(client));
    verify(client).getEndpoint();
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#put(LwM2mClient)} does
   *       nothing.
   *   <li>Then calls {@link TbLwM2MClientStore#put(LwM2mClient)}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test update(LwM2mClient); given TbLwM2MClientStore put(LwM2mClient) does nothing; then calls put(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.update(LwM2mClient)"})
  void testUpdate_givenTbLwM2MClientStorePutDoesNothing_thenCallsPut() {
    // Arrange
    doNothing().when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TbLwM2MClientStore} {@link TbLwM2MClientStore#put(LwM2mClient)} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test update(LwM2mClient); given TbLwM2MClientStore put(LwM2mClient) throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.update(LwM2mClient)"})
  void testUpdate_givenTbLwM2MClientStorePutThrowRuntimeExceptionWithFoo() {
    // Arrange
    doThrow(new RuntimeException("foo")).when(tbLwM2MClientStore).put(Mockito.<LwM2mClient>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.update(client));
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
    verify(tbLwM2MClientStore).put(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code CREATED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code CREATED}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test sendMsgsAfterSleeping(LwM2mClient); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.sendMsgsAfterSleeping(LwM2mClient)"})
  void testSendMsgsAfterSleeping_givenCreated_whenLwM2mClientGetStateReturnCreated() {
    // Arrange
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient);

    // Assert
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName("Test sendMsgsAfterSleeping(LwM2mClient); given RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.sendMsgsAfterSleeping(LwM2mClient)"})
  void testSendMsgsAfterSleeping_givenRuntimeExceptionWithFoo() {
    // Arrange
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenThrow(new RuntimeException("foo"));
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient));
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getLwM2mClients()}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getLwM2mClients()}
   */
  @Test
  @DisplayName("Test getLwM2mClients()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Collection LwM2mClientContextImpl.getLwM2mClients()"})
  void testGetLwM2mClients() {
    // Arrange, Act and Assert
    assertTrue(lwM2mClientContextImpl.getLwM2mClients().isEmpty());
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(Registration)} with {@code registration}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getProfile(Registration)}
   */
  @Test
  @DisplayName("Test getProfile(Registration) with 'registration'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.getProfile(Registration)"
  })
  void testGetProfileWithRegistration() {
    // Arrange
    when(tbLwM2MClientStore.get(Mockito.<String>any()))
        .thenThrow(new RuntimeException("[{}] initialized new client."));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(registration));
    verify(registration).getEndpoint();
    verify(tbLwM2MClientStore).get(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(Registration)} with {@code registration}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2mTransportContext#getNodeId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getProfile(Registration)}
   */
  @Test
  @DisplayName("Test getProfile(Registration) with 'registration'; then calls getNodeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.getProfile(Registration)"
  })
  void testGetProfileWithRegistration_thenCallsGetNodeId() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenReturn("42");
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getRegistration())
        .thenThrow(new RuntimeException("[{}] fetched client from store: {}"));
    when(tbLwM2MClientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(registration));
    verify(registration).getEndpoint();
    verify(lwM2mTransportContext).getNodeId();
    verify(lwM2mClient).getRegistration();
    verify(tbLwM2MClientStore).get(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClientContextImpl#profileUpdate(DeviceProfile)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#profileUpdate(DeviceProfile)}
   */
  @Test
  @DisplayName("Test profileUpdate(DeviceProfile); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration LwM2mClientContextImpl.profileUpdate(DeviceProfile)"
  })
  void testProfileUpdate_thenThrowRuntimeException() {
    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenThrow(
            new RuntimeException("[{}] Received profile with invalid transport configuration: {}"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.profileUpdate(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}
   */
  @Test
  @DisplayName("Test getClientByDeviceId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mClient LwM2mClientContextImpl.getClientByDeviceId(UUID)"})
  void testGetClientByDeviceId() {
    // Arrange, Act and Assert
    assertNull(
        lwM2mClientContextImpl.getClientByDeviceId(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isDownlinkAllowed(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.isDownlinkAllowed(LwM2mClient)"})
  void testIsDownlinkAllowed() {
    // Arrange, Act and Assert
    assertTrue(
        lwM2mClientContextImpl.isDownlinkAllowed(
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getProfileId()} return {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test isDownlinkAllowed(LwM2mClient); when LwM2mClient getProfileId() return 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClientContextImpl.isDownlinkAllowed(LwM2mClient)"})
  void testIsDownlinkAllowed_whenLwM2mClientGetProfileIdReturnNull_thenReturnTrue() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);

    // Act
    boolean actualIsDownlinkAllowedResult = lwM2mClientContextImpl.isDownlinkAllowed(client);

    // Assert
    verify(client).getPowerMode();
    verify(client).getProfileId();
    assertTrue(actualIsDownlinkAllowedResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getProfileId()} return {@code null}.
   *   <li>Then calls {@link LwM2mClient#getProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); when LwM2mClient getProfileId() return 'null'; then calls getProfileId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_whenLwM2mClientGetProfileIdReturnNull_thenCallsGetProfileId() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.updateLastUplinkTime()).thenReturn(1L);

    // Act
    lwM2mClientContextImpl.onUplink(client);

    // Assert
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getSleepTask()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); when LwM2mClient getSleepTask() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_whenLwM2mClientGetSleepTaskThrowRuntimeExceptionWithFoo() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSleepTask()).thenThrow(new RuntimeException("foo"));
    when(client.getPsmActivityTimer()).thenReturn(1L);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getSleepTask();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#lock()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test onUplink(LwM2mClient); when LwM2mClient lock() throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClientContextImpl.onUplink(LwM2mClient)"})
  void testOnUplink_whenLwM2mClientLockThrowRuntimeExceptionWithFoo() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new RuntimeException("foo")).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }
}
