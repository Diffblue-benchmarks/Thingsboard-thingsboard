package org.thingsboard.server.transport.lwm2m.server.store;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.Version;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MClientState;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;

class TbRedisLwM2MClientStoreDiffblueTest {
  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger(1));
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getLastSentRpcId();
    verify(client).getLastUplinkTime();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client).getRegistration();
    verify(client).getResources();
    verify(client).getRetryAttempts();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
    verify(client).isAsleep();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut2() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client, atLeast(1)).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut3() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getEdrxCycle()} return one.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); given one; when LwM2mClient getEdrxCycle() return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenOne_whenLwM2mClientGetEdrxCycleReturnOne() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPagingTransmissionWindow()} return one.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given one; when LwM2mClient getPagingTransmissionWindow() return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenOne_whenLwM2mClientGetPagingTransmissionWindowReturnOne() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPsmActivityTimer()} return one.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given one; when LwM2mClient getPsmActivityTimer() return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenOne_whenLwM2mClientGetPsmActivityTimerReturnOne() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code PSM}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return {@code PSM}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); given 'PSM'; when LwM2mClient getPowerMode() return 'PSM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenPsm_whenLwM2mClientGetPowerModeReturnPsm() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link Registration} {@link Registration#getRegistrationDate()} return {@code
   *       null}.
   *   <li>Then calls {@link Registration#getAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given Registration getRegistrationDate() return 'null'; then calls getAddress()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRegistrationGetRegistrationDateReturnNull_thenCallsGetAddress() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getRegistrationDate()).thenReturn(null);
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given TenantId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenTenantIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Then calls {@link Registration#getClientTransportData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); then calls getClientTransportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_thenCallsGetClientTransportData() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getLastSentRpcId()} return {@code null}.
   *   <li>Then calls {@link LwM2mClient#getLastSentRpcId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); when LwM2mClient getLastSentRpcId() return 'null'; then calls getLastSentRpcId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetLastSentRpcIdReturnNull_thenCallsGetLastSentRpcId() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger(1));
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(Version.getDefault());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getLastSentRpcId();
    verify(client).getLastUplinkTime();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client).getRegistration();
    verify(client).getResources();
    verify(client).getRetryAttempts();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
    verify(client).isAsleep();
  }
}
