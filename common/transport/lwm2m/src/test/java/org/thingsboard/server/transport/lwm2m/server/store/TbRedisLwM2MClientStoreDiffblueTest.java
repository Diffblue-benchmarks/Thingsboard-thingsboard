/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.lwm2m.server.store;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.Version;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Operations;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MClientState;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.ResourceValue;

class TbRedisLwM2MClientStoreDiffblueTest {
  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "nodeId",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "nodeId",
            "nodeId",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    stringResourceValueMap.put("nodeId", resourceValue);

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getState();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@code endpoint} is {@link
   *       AtomicLong#AtomicLong()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); given ConcurrentHashMap() 'endpoint' is AtomicLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenConcurrentHashMapEndpointIsAtomicLong() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.put("endpoint", new AtomicLong());
    stringAtomicLongMap.put("nodeId", new AtomicLong());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
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
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);
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

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@code nodeId} is {@link
   *       AtomicLong#AtomicLong()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); given ConcurrentHashMap() 'nodeId' is AtomicLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenConcurrentHashMapNodeIdIsAtomicLong() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.put("nodeId", new AtomicLong());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
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
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);
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

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getLastSentRpcId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given DefaultInstance; when LwM2mClient getLastSentRpcId() return randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenDefaultInstance_whenLwM2mClientGetLastSentRpcIdReturnRandomUUID() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(UUID.randomUUID());
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(SessionInfoProto.getDefaultInstance());
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
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
    verify(client).isAsleep();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code PSM}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPowerMode()} return {@code PSM}.
   *   <li>Then calls {@link LwM2mClient#getLastSentRpcId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given 'PSM'; when LwM2mClient getPowerMode() return 'PSM'; then calls getLastSentRpcId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenPsm_whenLwM2mClientGetPowerModeReturnPsm_thenCallsGetLastSentRpcId() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
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
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getLastSentRpcId();
    verify(client).getLastUplinkTime();
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
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
   * <ul>
   *   <li>Given randomUUID.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getDeviceId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given randomUUID; when LwM2mClient getDeviceId() return randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRandomUUID_whenLwM2mClientGetDeviceIdReturnRandomUUID() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
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
    verify(client, atLeast(1)).getDeviceId();
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

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given randomUUID.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getLastSentRpcId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given randomUUID; when LwM2mClient getLastSentRpcId() return randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRandomUUID_whenLwM2mClientGetLastSentRpcIdReturnRandomUUID() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(UUID.randomUUID());
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
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
   * <ul>
   *   <li>Given randomUUID.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getProfileId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given randomUUID; when LwM2mClient getProfileId() return randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRandomUUID_whenLwM2mClientGetProfileIdReturnRandomUUID() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
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
    verify(client, atLeast(1)).getProfileId();
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
   * <ul>
   *   <li>Given {@link Registration} {@link Registration#getAddress()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link Registration#getAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given Registration getAddress() throw RuntimeException(); then calls getAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRegistrationGetAddressThrowRuntimeException_thenCallsGetAddress() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    Registration registration = mock(Registration.class);
    when(registration.getAddress()).thenThrow(new RuntimeException());

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
   *   <li>Given {@link Registration} {@link Registration#getClientTransportData()} return {@link
   *       LwM2mPeer}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given Registration getClientTransportData() return LwM2mPeer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRegistrationGetClientTransportDataReturnLwM2mPeer() {
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
   *   <li>Given {@link Registration} {@link Registration#getClientTransportData()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given Registration getClientTransportData() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRegistrationGetClientTransportDataThrowRuntimeException() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenThrow(new RuntimeException());
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
   *   <li>Given {@link Registration} {@link Registration#getRegistrationDate()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given Registration getRegistrationDate() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRegistrationGetRegistrationDateThrowRuntimeException() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    Registration registration = mock(Registration.class);
    when(registration.getRegistrationDate()).thenThrow(new RuntimeException());
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
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getNodeId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given RuntimeException(); when LwM2mClient getNodeId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRuntimeException_whenLwM2mClientGetNodeIdThrowRuntimeException() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getNodeId()).thenThrow(new RuntimeException());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(client).getNodeId();
    verify(client).getState();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getSession()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given RuntimeException(); when LwM2mClient getSession() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRuntimeException_whenLwM2mClientGetSessionThrowRuntimeException() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new RuntimeException());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TransportProtos.SessionInfoProto} {@link
   *       TransportProtos.SessionInfoProto#getAllFields()} return {@link HashMap#HashMap()}.
   *   <li>Then calls {@link TransportProtos.SessionInfoProto#getAllFields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given SessionInfoProto getAllFields() return HashMap(); then calls getAllFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenSessionInfoProtoGetAllFieldsReturnHashMap_thenCallsGetAllFields() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    SessionInfoProto sessionInfoProto = mock(SessionInfoProto.class);
    when(sessionInfoProto.getAllFields()).thenReturn(new HashMap<>());
    when(sessionInfoProto.getDescriptorForType()).thenReturn(KeyValueProto.getDescriptor());

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
    when(client.getSession()).thenReturn(sessionInfoProto);
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
    verify(sessionInfoProto).getAllFields();
    verify(sessionInfoProto).getDescriptorForType();
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
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client).getTenantId();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TransportProtos.SessionInfoProto} {@link
   *       TransportProtos.SessionInfoProto#getDescriptorForType()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given SessionInfoProto getDescriptorForType() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenSessionInfoProtoGetDescriptorForTypeThrowRuntimeException() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    SessionInfoProto sessionInfoProto = mock(SessionInfoProto.class);
    when(sessionInfoProto.getDescriptorForType()).thenThrow(new RuntimeException());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(sessionInfoProto);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(sessionInfoProto).getDescriptorForType();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); given TenantId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenTenantIdWithIdIsRandomUUID() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
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
    verify(client, atLeast(1)).getTenantId();
    verify(client).isAsleep();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@code UNREGISTERED}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getState()} return {@code UNREGISTERED}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given 'UNREGISTERED'; when LwM2mClient getState() return 'UNREGISTERED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenUnregistered_whenLwM2mClientGetStateReturnUnregistered() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getState()).thenReturn(LwM2MClientState.UNREGISTERED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(client).getEndpoint();
    verify(client, atLeast(1)).getState();
  }

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link Version}.
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getDefaultObjectIDVer()} return {@link
   *       Version}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); given Version; when LwM2mClient getDefaultObjectIDVer() return Version")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenVersion_whenLwM2mClientGetDefaultObjectIDVerReturnVersion() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(mock(Version.class));
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

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getDefaultObjectIDVer()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); when LwM2mClient getDefaultObjectIDVer() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetDefaultObjectIDVerReturnNull() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(null);
    when(client.getPagingTransmissionWindow()).thenReturn(null);
    when(client.getPsmActivityTimer()).thenReturn(null);
    when(client.getDeviceId()).thenReturn(null);
    when(client.getProfileId()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getTenantId()).thenReturn(null);
    when(client.getSession()).thenReturn(null);
    when(client.getDefaultObjectIDVer()).thenReturn(null);
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
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
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
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getEdrxCycle()} return one.
   *   <li>Then calls {@link LwM2mClient#getLastSentRpcId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); when LwM2mClient getEdrxCycle() return one; then calls getLastSentRpcId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetEdrxCycleReturnOne_thenCallsGetLastSentRpcId() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
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
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client, atLeast(1)).getEdrxCycle();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetLastSentRpcIdReturnNull_thenCallsGetLastSentRpcId() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
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

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getLastSentRpcId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); when LwM2mClient getLastSentRpcId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetLastSentRpcIdThrowRuntimeException() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenThrow(new RuntimeException());
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
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

  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPagingTransmissionWindow()} return one.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); when LwM2mClient getPagingTransmissionWindow() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetPagingTransmissionWindowReturnOne() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
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
    verify(client).getDefaultObjectIDVer();
    verify(client).getDeviceId();
    verify(client).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getLastSentRpcId();
    verify(client).getLastUplinkTime();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
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
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getPsmActivityTimer()} return one.
   *   <li>Then calls {@link LwM2mClient#getLastSentRpcId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); when LwM2mClient getPsmActivityTimer() return one; then calls getLastSentRpcId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetPsmActivityTimerReturnOne_thenCallsGetLastSentRpcId() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(null);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger());
    when(client.getLastUplinkTime()).thenReturn(1L);
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
    verify(client, atLeast(1)).getPsmActivityTimer();
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
   * <ul>
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getRegistration()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); when LwM2mClient getRegistration() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetRegistrationThrowRuntimeException() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new RuntimeException());
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
    verify(client).getNodeId();
    verify(client).getPagingTransmissionWindow();
    verify(client).getPowerMode();
    verify(client).getProfileId();
    verify(client).getPsmActivityTimer();
    verify(client).getRegistration();
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
   *   <li>When {@link LwM2mClient} {@link LwM2mClient#getRetryAttempts()} return {@code null}.
   *   <li>Then calls {@link LwM2mClient#getLastUplinkTime()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName(
      "Test put(LwM2mClient); when LwM2mClient getRetryAttempts() return 'null'; then calls getLastUplinkTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_whenLwM2mClientGetRetryAttemptsReturnNull_thenCallsGetLastUplinkTime() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(null);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(null);
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
