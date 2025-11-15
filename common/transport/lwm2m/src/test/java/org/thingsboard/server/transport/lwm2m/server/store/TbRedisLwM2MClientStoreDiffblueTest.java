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
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mResourceInstance;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MClientState;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.ResourceValue;

class TbRedisLwM2MClientStoreDiffblueTest {
  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(UUID.randomUUID());
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(new AtomicInteger(1));
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getRegistration()).thenReturn(null);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getLastSentRpcId();
    verify(client).getLastUplinkTime();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client).getRegistration();
    verify(client).getResources();
    verify(client).getRetryAttempts();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
    verify(client).isAsleep();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut2() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.isAsleep()).thenReturn(true);
    when(client.getRetryAttempts()).thenReturn(null);
    when(client.getLastUplinkTime()).thenReturn(1L);
    when(client.getRegistration()).thenReturn(null);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getLastUplinkTime();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client).getRegistration();
    verify(client).getResources();
    verify(client).getRetryAttempts();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
    verify(client).isAsleep();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut3() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut4() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getRegistrationDate()).thenReturn(null);
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
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
    verify(client, atLeast(1)).getDeviceId();
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut5() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(null);
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut6() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(mock(LwM2m.Version.class));
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut7() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    stringResourceValueMap.put("nodeId",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "nodeId", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "nodeId", "nodeId", "The characteristics of someone or something")));
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
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut8() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    HashMap<String, TransportProtos.TsKvProto> stringTsKvProtoMap = new HashMap<>();
    stringTsKvProtoMap.put("nodeId", TransportProtos.TsKvProto.getDefaultInstance());
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(stringTsKvProtoMap);
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut9() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.put("nodeId", new AtomicLong(1L));
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client, atLeast(1)).getDeviceId();
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut10() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.put("endpoint", new AtomicLong(1L));
    stringAtomicLongMap.put("nodeId", new AtomicLong(1L));
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(registration).getAddress();
    verify(registration).getClientTransportData();
    verify(registration).getRegistrationDate();
    verify(client).getDefaultObjectIDVer();
    verify(client, atLeast(1)).getDeviceId();
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut11() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
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
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut12() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "nodeId", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE, "nodeId",
            "nodeId", "The characteristics of someone or something"));

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("nodeId", resourceValue);
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut13() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "nodeId", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE, "nodeId",
            "nodeId", "The characteristics of someone or something"));

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("nodeId", resourceValue);
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut14() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newBooleanResource(1, true);
    stringResourceValueMap.put("nodeId",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "nodeId", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "nodeId", "nodeId", "The characteristics of someone or something")));
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut15() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newFloatResource(1, 10.0d);
    stringResourceValueMap.put("nodeId",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "nodeId", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "nodeId", "nodeId", "The characteristics of someone or something")));
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut16() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newIntegerResource(1, 42L);
    stringResourceValueMap.put("nodeId",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "nodeId", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "nodeId", "nodeId", "The characteristics of someone or something")));
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut17() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    ResourceValue resourceValue = mock(ResourceValue.class);
    when(resourceValue.getResourceModel()).thenReturn(new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true,
        true, ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something"));
    when(resourceValue.getLwM2mResource())
        .thenReturn(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("nodeId", resourceValue);
    Registration registration = mock(Registration.class);
    when(registration.getClientTransportData()).thenReturn(mock(LwM2mPeer.class));
    when(registration.getRegistrationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(registration.getAddress()).thenReturn(mock(InetAddress.class));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenReturn(registration);
    when(client.getEdrxCycle()).thenReturn(1L);
    when(client.getPagingTransmissionWindow()).thenReturn(1L);
    when(client.getPsmActivityTimer()).thenReturn(1L);
    when(client.getDeviceId()).thenReturn(UUID.randomUUID());
    when(client.getProfileId()).thenReturn(UUID.randomUUID());
    when(client.getDefaultObjectIDVer()).thenReturn(LwM2m.Version.getDefault());
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);
    when(client.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
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
    verify(client, atLeast(1)).getEdrxCycle();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client, atLeast(1)).getPagingTransmissionWindow();
    verify(client, atLeast(1)).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
    verify(client, atLeast(1)).getPsmActivityTimer();
    verify(client, atLeast(1)).getRegistration();
    verify(client).getResources();
    verify(client, atLeast(1)).getSession();
    verify(client).getSharedAttributes();
    verify(client, atLeast(1)).getState();
    verify(client, atLeast(1)).getTenantId();
    verify(resourceValue).getLwM2mResource();
    verify(resourceValue).getResourceModel();
  }

  /**
   * Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  void testPut18() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore = new TbRedisLwM2MClientStore(new JedisConnectionFactory());
    ResourceValue resourceValue = mock(ResourceValue.class);
    when(resourceValue.getResourceModel()).thenReturn(new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true,
        true, ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something"));
    when(resourceValue.getLwM2mResource())
        .thenReturn(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    stringResourceValueMap.put("lwM2mResource",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "nodeId", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "nodeId", "nodeId", "The characteristics of someone or something")));
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
    verify(resourceValue).getLwM2mResource();
    verify(resourceValue).getResourceModel();
  }
}
