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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.profile.DeviceProfileAlarm;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileProvisionConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.transport.TransportContext;
import org.thingsboard.server.common.transport.TransportDeviceProfileCache;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigServiceImpl;
import org.thingsboard.server.transport.lwm2m.server.rpc.LwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.session.DefaultLwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.store.TbDummyLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemorySecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbRedisLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class LwM2mClientContextImplDiffblueTest {
  /**
   * Test {@link LwM2mClientContextImpl#init()}.
   * <ul>
   *   <li>Then calls {@link TransportContext#getNodeId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#init()}
   */
  @Test
  @DisplayName("Test init(); then calls getNodeId()")
  void testInit_thenCallsGetNodeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();

    // Act
    (new LwM2mClientContextImpl(context, config, securityStore2, clientStore, sessionManager, deviceProfileCache,
        new LwM2MModelConfigServiceImpl())).init();

    // Assert that nothing has changed
    verify(context).getNodeId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByEndpoint(String)}.
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#getClientByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getClientByEndpoint(String)")
  void testGetClientByEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    TbLwM2MClientStore clientStore = mock(TbLwM2MClientStore.class);
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    when(clientStore.get(Mockito.<String>any())).thenReturn(lwM2mClient);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act
    LwM2mClient actualClientByEndpoint = lwM2mClientContextImpl
        .getClientByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(context).getNodeId();
    verify(clientStore).get(eq("https://config.us-east-2.amazonaws.com"));
    assertEquals(1, lwM2mClientContextImpl.getLwM2mClients().size());
    assertSame(lwM2mClient, actualClientByEndpoint);
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getNodeId()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link LwM2mClient#getKeyTsLatestMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given '42'; when LwM2mClient getNodeId() return '42'; then calls getKeyTsLatestMap()")
  void testAsleep_given42_whenLwM2mClientGetNodeIdReturn42_thenCallsGetKeyTsLatestMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenThrow(new RuntimeException("[{}] Switch sleeping from: {} to: {}"));
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPowerMode();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code CREATED}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return
   * {@code CREATED}.</li>
   *   <li>Then calls {@link LwM2mClient#getSession()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given 'CREATED'; when LwM2mClient getState() return 'CREATED'; then calls getSession()")
  void testAsleep_givenCreated_whenLwM2mClientGetStateReturnCreated_thenCallsGetSession() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException("[{}] Switch sleeping from: {} to: {}"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code DRX}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return
   * {@code DRX}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given 'DRX'; when LwM2mClient getPowerMode() return 'DRX'; then return 'false'")
  void testAsleep_givenDrx_whenLwM2mClientGetPowerModeReturnDrx_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    boolean actualAsleepResult = lwM2mClientContextImpl.asleep(client);

    // Assert
    verify(client).getPowerMode();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).unlock();
    assertFalse(actualAsleepResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code E_DRX}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return
   * {@code E_DRX}.</li>
   *   <li>Then calls {@link LwM2mClient#getSession()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given 'E_DRX'; when LwM2mClient getPowerMode() return 'E_DRX'; then calls getSession()")
  void testAsleep_givenEDrx_whenLwM2mClientGetPowerModeReturnEDrx_thenCallsGetSession() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException("[{}] Switch sleeping from: {} to: {}"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code REGISTERED}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return
   * {@code REGISTERED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given 'REGISTERED'; when LwM2mClient getState() return 'REGISTERED'")
  void testAsleep_givenRegistered_whenLwM2mClientGetStateReturnRegistered() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException("[{}] Switch sleeping from: {} to: {}"));
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getPowerMode();
    verify(client).getSession();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#asleep(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code [{}]
   * Client is already at sleeping: {}, ignoring event: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given RuntimeException(String) with '[{}] Client is already at sleeping: {}, ignoring event: {}'")
  void testAsleep_givenRuntimeExceptionWithClientIsAlreadyAtSleepingIgnoringEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
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
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#isAsleep()} return
   * {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); given 'true'; when LwM2mClient isAsleep() return 'true'; then return 'false'")
  void testAsleep_givenTrue_whenLwM2mClientIsAsleepReturnTrue_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
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
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getNodeId()} return
   * {@code null}.</li>
   *   <li>Then calls {@link LwM2mClient#getKeyTsLatestMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#asleep(LwM2mClient)}
   */
  @Test
  @DisplayName("Test asleep(LwM2mClient); when LwM2mClient getNodeId() return 'null'; then calls getKeyTsLatestMap()")
  void testAsleep_whenLwM2mClientGetNodeIdReturnNull_thenCallsGetKeyTsLatestMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getNodeId()).thenReturn(null);
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenThrow(new RuntimeException("[{}] Switch sleeping from: {} to: {}"));
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).setAsleep(anyBoolean());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.isAsleep()).thenReturn(false);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.asleep(client));
    verify(client, atLeast(1)).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPowerMode();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setAsleep(eq(true));
    verify(client, atLeast(1)).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient)")
  void testAwake() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertFalse(lwM2mClientContextImpl.awake(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code DRX}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return
   * {@code DRX}.</li>
   *   <li>Then calls {@link LwM2mClient#isAsleep()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient); given 'DRX'; when LwM2mClient getPowerMode() return 'DRX'; then calls isAsleep()")
  void testAwake_givenDrx_whenLwM2mClientGetPowerModeReturnDrx_thenCallsIsAsleep() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.isAsleep()).thenReturn(true);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);

    // Act
    boolean actualAwakeResult = lwM2mClientContextImpl.awake(client);

    // Assert
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).isAsleep();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
    assertFalse(actualAwakeResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient); given IllegalArgumentException(String) with 'foo'; then throw IllegalArgumentException")
  void testAwake_givenIllegalArgumentExceptionWithFoo_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new IllegalArgumentException("foo")).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#awake(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#awake(LwM2mClient)}
   */
  @Test
  @DisplayName("Test awake(LwM2mClient); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testAwake_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenThrow(new RuntimeException("foo"));
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.awake(client));
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration)")
  void testUpdateRegistration() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertThrows(LwM2MClientStateException.class, () -> lwM2mClientContextImpl
        .updateRegistration(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
  }

  /**
   * Test
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   * <ul>
   *   <li>Given {@code CREATED}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return
   * {@code CREATED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  void testUpdateRegistration_givenCreated_whenLwM2mClientGetStateReturnCreated() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(LwM2MClientStateException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   * <ul>
   *   <li>Given {@code DRX}.</li>
   *   <li>Then calls {@link LwM2mClient#isAsleep()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration); given 'DRX'; then calls isAsleep()")
  void testUpdateRegistration_givenDrx_thenCallsIsAsleep() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(true);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.updateRegistration(client, null);

    // Assert that nothing has changed
    verify(client, atLeast(1)).getPowerMode();
    verify(client).getState();
    verify(client, atLeast(1)).isAsleep();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testUpdateRegistration_givenRuntimeExceptionWithFoo_thenThrowRuntimeException()
      throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenThrow(new RuntimeException("foo"));
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#updateRegistration(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test updateRegistration(LwM2mClient, Registration); then throw IllegalArgumentException")
  void testUpdateRegistration_thenThrowIllegalArgumentException() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPsmActivityTimer()).thenThrow(new IllegalArgumentException("foo"));
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    doNothing().when(client).setRegistration(Mockito.<Registration>any());
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClientContextImpl.updateRegistration(client, null));
    verify(client).getPowerMode();
    verify(client).getPsmActivityTimer();
    verify(client).getState();
    verify(client, atLeast(1)).lock();
    verify(client).setRegistration(isNull());
    verify(client, atLeast(1)).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}.
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test unregister(LwM2mClient, Registration)")
  void testUnregister() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertThrows(LwM2MClientStateException.class,
        () -> lwM2mClientContextImpl.unregister(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null));
  }

  /**
   * Test {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}.
   * <ul>
   *   <li>Given {@code CREATED}.</li>
   *   <li>Then calls {@link LwM2mClient#getState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#unregister(LwM2mClient, Registration)}
   */
  @Test
  @DisplayName("Test unregister(LwM2mClient, Registration); given 'CREATED'; then calls getState()")
  void testUnregister_givenCreated_thenCallsGetState() throws LwM2MClientStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act and Assert
    assertThrows(LwM2MClientStateException.class, () -> lwM2mClientContextImpl.unregister(client, null));
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientBySessionInfo(SessionInfoProto)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#getClientBySessionInfo(TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test getClientBySessionInfo(SessionInfoProto); when DefaultInstance; then return 'null'")
  void testGetClientBySessionInfo_whenDefaultInstance_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertNull(lwM2mClientContextImpl.getClientBySessionInfo(TransportProtos.SessionInfoProto.getDefaultInstance()));
  }

  /**
   * Test
   * {@link LwM2mClientContextImpl#getObjectIdByKeyNameFromProfile(LwM2mClient, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#getObjectIdByKeyNameFromProfile(LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test getObjectIdByKeyNameFromProfile(LwM2mClient, String); then throw RuntimeException")
  void testGetObjectIdByKeyNameFromProfile_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> lwM2mClientContextImpl.getObjectIdByKeyNameFromProfile(client, "Key Name"));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient)")
  void testUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert that nothing has changed
    verify(client).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient)")
  void testUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    stringResourceValueMap.put("endpoint",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@code endpoint} is
   * {@link AtomicLong#AtomicLong(long)} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient); given ConcurrentHashMap() 'endpoint' is AtomicLong(long) with one")
  void testUpdate_givenConcurrentHashMapEndpointIsAtomicLongWithOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.put("endpoint", new AtomicLong(1L));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new IllegalArgumentException("nodeId"));
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()}.</li>
   *   <li>Then calls {@link LwM2mClient#getKeyTsLatestMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient); given ConcurrentHashMap(); then calls getKeyTsLatestMap()")
  void testUpdate_givenConcurrentHashMap_thenCallsGetKeyTsLatestMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new IllegalArgumentException("nodeId"));
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code CREATED}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return
   * {@code CREATED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  void testUpdate_givenCreated_whenLwM2mClientGetStateReturnCreated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert that nothing has changed
    verify(client).getEndpoint();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code endpoint} is DefaultInstance.</li>
   *   <li>Then calls {@link LwM2mClient#getKeyTsLatestMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient); given HashMap() 'endpoint' is DefaultInstance; then calls getKeyTsLatestMap()")
  void testUpdate_givenHashMapEndpointIsDefaultInstance_thenCallsGetKeyTsLatestMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbRedisLwM2MClientStore clientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    HashMap<String, TransportProtos.TsKvProto> stringTsKvProtoMap = new HashMap<>();
    stringTsKvProtoMap.put("endpoint", TransportProtos.TsKvProto.getDefaultInstance());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new IllegalArgumentException("nodeId"));
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(stringTsKvProtoMap);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.REGISTERED);
    doNothing().when(client).lock();
    doNothing().when(client).unlock();

    // Act
    lwM2mClientContextImpl.update(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).lock();
    verify(client).unlock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#update(LwM2mClient)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#update(LwM2mClient)}
   */
  @Test
  @DisplayName("Test update(LwM2mClient); then throw RuntimeException")
  void testUpdate_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenThrow(new RuntimeException("[{}] Client is in invalid state: {}!"));
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
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code CREATED}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return
   * {@code CREATED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName("Test sendMsgsAfterSleeping(LwM2mClient); given 'CREATED'; when LwM2mClient getState() return 'CREATED'")
  void testSendMsgsAfterSleeping_givenCreated_whenLwM2mClientGetStateReturnCreated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient);

    // Assert that nothing has changed
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code DRX}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return
   * {@code DRX}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName("Test sendMsgsAfterSleeping(LwM2mClient); given 'DRX'; when LwM2mClient getPowerMode() return 'DRX'")
  void testSendMsgsAfterSleeping_givenDrx_whenLwM2mClientGetPowerModeReturnDrx() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, new DefaultTransportDeviceProfileCache(), mock(LwM2MModelConfigServiceImpl.class));
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenReturn(PowerMode.DRX);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act
    lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient);

    // Assert that nothing has changed
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getState();
  }

  /**
   * Test {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#sendMsgsAfterSleeping(LwM2mClient)}
   */
  @Test
  @DisplayName("Test sendMsgsAfterSleeping(LwM2mClient); then throw RuntimeException")
  void testSendMsgsAfterSleeping_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MModelConfigServiceImpl modelConfigService = mock(LwM2MModelConfigServiceImpl.class);
    doThrow(new RuntimeException("foo")).when(modelConfigService).sendUpdates(Mockito.<LwM2mClient>any());
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, new DefaultTransportDeviceProfileCache(), modelConfigService);
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getPowerMode()).thenReturn(PowerMode.E_DRX);
    when(lwM2MClient.getState()).thenReturn(LwM2MClientState.REGISTERED);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.sendMsgsAfterSleeping(lwM2MClient));
    verify(lwM2MClient).getPowerMode();
    verify(lwM2MClient).getState();
    verify(modelConfigService).sendUpdates(isA(LwM2mClient.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#getLwM2mClients()}.
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#getLwM2mClients()}
   */
  @Test
  @DisplayName("Test getLwM2mClients()")
  void testGetLwM2mClients() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();

    // Act and Assert
    assertTrue((new LwM2mClientContextImpl(context, config, securityStore2, clientStore, sessionManager,
        deviceProfileCache, new LwM2MModelConfigServiceImpl())).getLwM2mClients().isEmpty());
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(UUID)} with {@code profileId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#getProfile(UUID)}
   */
  @Test
  @DisplayName("Test getProfile(UUID) with 'profileId'; then return 'null'")
  void testGetProfileWithProfileId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(null);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act
    Lwm2mDeviceProfileTransportConfiguration actualProfile = lwM2mClientContextImpl.getProfile(UUID.randomUUID());

    // Assert
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    assertNull(actualProfile);
  }

  /**
   * Test {@link LwM2mClientContextImpl#getProfile(UUID)} with {@code profileId}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#getProfile(UUID)}
   */
  @Test
  @DisplayName("Test getProfile(UUID) with 'profileId'; then throw RuntimeException")
  void testGetProfileWithProfileId_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getProfile(UUID.randomUUID()));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
  }

  /**
   * Test {@link LwM2mClientContextImpl#profileUpdate(DeviceProfile)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#profileUpdate(DeviceProfile)}
   */
  @Test
  @DisplayName("Test profileUpdate(DeviceProfile); then throw RuntimeException")
  void testProfileUpdate_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenThrow(new RuntimeException("[{}] Received profile with invalid transport configuration: {}"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.profileUpdate(deviceProfile));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}.
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#getClientByDeviceId(UUID)}
   */
  @Test
  @DisplayName("Test getClientByDeviceId(UUID)")
  void testGetClientByDeviceId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertNull(lwM2mClientContextImpl.getClientByDeviceId(UUID.randomUUID()));
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isDownlinkAllowed(LwM2mClient)")
  void testIsDownlinkAllowed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());

    // Act and Assert
    assertTrue(
        lwM2mClientContextImpl.isDownlinkAllowed(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code DRX}.</li>
   *   <li>Then calls {@link DeviceProfileData#setAlarms(List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isDownlinkAllowed(LwM2mClient); given 'DRX'; then calls setAlarms(List)")
  void testIsDownlinkAllowed_givenDrx_thenCallsSetAlarms() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);

    // Act
    boolean actualIsDownlinkAllowedResult = lwM2mClientContextImpl.isDownlinkAllowed(client);

    // Assert
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(client).getPowerMode();
    assertTrue(actualIsDownlinkAllowedResult);
  }

  /**
   * Test {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#isDownlinkAllowed(LwM2mClient)}
   */
  @Test
  @DisplayName("Test isDownlinkAllowed(LwM2mClient); then throw RuntimeException")
  void testIsDownlinkAllowed_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.isDownlinkAllowed(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code DRX}.</li>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return
   * {@code DRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName("Test onUplink(LwM2mClient); given 'DRX'; when LwM2mClient getPowerMode() return 'DRX'")
  void testOnUplink_givenDrx_whenLwM2mClientGetPowerModeReturnDrx() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.DRX);

    // Act
    lwM2mClientContextImpl.onUplink(client);

    // Assert that nothing has changed
    verify(client).getPowerMode();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName("Test onUplink(LwM2mClient); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testOnUplink_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getPagingTransmissionWindow()).thenThrow(new RuntimeException("foo"));
    doNothing().when(client).lock();
    doNothing().when(client).unlock();
    when(client.updateLastUplinkTime()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).lock();
    verify(client).unlock();
    verify(client).updateLastUplinkTime();
  }

  /**
   * Test {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClientContextImpl#onUplink(LwM2mClient)}
   */
  @Test
  @DisplayName("Test onUplink(LwM2mClient); then throw IllegalArgumentException")
  void testOnUplink_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    doThrow(new IllegalArgumentException("foo")).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClientContextImpl.onUplink(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link DeviceProfileData} (default constructor) Alarms is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link DeviceProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName("Test getRequestTimeout(LwM2mClient); given DeviceProfileData (default constructor) Alarms is ArrayList(); then calls getId()")
  void testGetRequestTimeout_givenDeviceProfileDataAlarmsIsArrayList_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link DeviceProfileData#getTransportConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName("Test getRequestTimeout(LwM2mClient); given 'null'; then calls getTransportConfiguration()")
  void testGetRequestTimeout_givenNull_thenCallsGetTransportConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceProfileTransportConfiguration deviceProfileTransportConfiguration = mock(
        DeviceProfileTransportConfiguration.class);
    when(deviceProfileTransportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getTransportConfiguration()).thenReturn(deviceProfileTransportConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new RuntimeException("Fetching profile [{}]"));
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    when(deviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(deviceProfile).getId();
    verify(deviceProfile).getProfileData();
    verify(deviceProfileData).getTransportConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileTransportConfiguration).getType();
    verify(deviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getEdrxCycle();
    verify(client).getPowerMode();
    verify(client).getProfileId();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName("Test getRequestTimeout(LwM2mClient); given one; then return longValue is one")
  void testGetRequestTimeout_givenOne_thenReturnLongValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act
    Long actualRequestTimeout = lwM2mClientContextImpl.getRequestTimeout(client);

    // Assert
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getPowerMode();
    assertEquals(1L, actualRequestTimeout.longValue());
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName("Test getRequestTimeout(LwM2mClient); given RuntimeException(String) with 'foo'")
  void testGetRequestTimeout_givenRuntimeExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenThrow(new RuntimeException("foo"));
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2mClientContextImpl.getRequestTimeout(client));
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(client).getEdrxCycle();
    verify(client).getPowerMode();
  }

  /**
   * Test {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClientContextImpl#getRequestTimeout(LwM2mClient)}
   */
  @Test
  @DisplayName("Test getRequestTimeout(LwM2mClient); given zero; then return 'null'")
  void testGetRequestTimeout_givenZero_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(mock(TransportService.class),
        mock(LwM2MAttributesService.class), mock(LwM2MRpcRequestHandler.class), mock(LwM2mUplinkMsgHandler.class));

    TransportDeviceProfileCache deviceProfileCache = mock(TransportDeviceProfileCache.class);
    LwM2mClientContextImpl lwM2mClientContextImpl = new LwM2mClientContextImpl(context, config, securityStore2,
        clientStore, sessionManager, deviceProfileCache, new LwM2MModelConfigServiceImpl());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(0L);
    when(client.getPowerMode()).thenReturn(PowerMode.E_DRX);

    // Act
    Long actualRequestTimeout = lwM2mClientContextImpl.getRequestTimeout(client);

    // Assert
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getPowerMode();
    assertNull(actualRequestTimeout);
  }
}
