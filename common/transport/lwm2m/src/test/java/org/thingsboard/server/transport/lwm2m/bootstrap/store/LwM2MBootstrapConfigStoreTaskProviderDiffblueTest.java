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
package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.eclipse.leshan.core.node.LwM2mObject;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.core.request.BootstrapRequest;
import org.eclipse.leshan.core.request.exception.InvalidRequestException;
import org.eclipse.leshan.core.response.BootstrapDeleteResponse;
import org.eclipse.leshan.core.response.BootstrapReadResponse;
import org.eclipse.leshan.core.response.LwM2mResponse;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.BootstrapConfigStore;
import org.eclipse.leshan.server.bootstrap.BootstrapSession;
import org.eclipse.leshan.server.bootstrap.BootstrapTaskProvider;
import org.eclipse.leshan.server.bootstrap.DefaultBootstrapSession;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LwM2MBootstrapConfigStoreTaskProviderDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#getTasks(BootstrapSession, List)}
   */
  @Test
  void testGetTasks() throws InvalidRequestException {
    // Arrange
    BootstrapConfigStore store = mock(BootstrapConfigStore.class);
    when(store.get(Mockito.<BootstrapSession>any())).thenReturn(null);
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        store);
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession session = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act
    BootstrapTaskProvider.Tasks actualTasks = lwM2MBootstrapConfigStoreTaskProvider.getTasks(session,
        new ArrayList<>());

    // Assert
    verify(store).get(isA(BootstrapSession.class));
    assertNull(actualTasks);
  }

  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#getTasks(BootstrapSession, List)}
   */
  @Test
  void testGetTasks2() throws InvalidRequestException {
    // Arrange
    BootstrapConfigStore store = mock(BootstrapConfigStore.class);
    when(store.get(Mockito.<BootstrapSession>any())).thenReturn(null);
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        store);
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession session = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    ArrayList<LwM2mResponse> previousResponse = new ArrayList<>();
    previousResponse.add(BootstrapDeleteResponse.success());

    // Act
    BootstrapTaskProvider.Tasks actualTasks = lwM2MBootstrapConfigStoreTaskProvider.getTasks(session, previousResponse);

    // Assert
    verify(store).get(isA(BootstrapSession.class));
    assertNull(actualTasks);
  }

  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}
   */
  @Test
  void testShouldStartWithDiscover() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));

    // Act and Assert
    assertFalse(lwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(new BootstrapConfig()));
  }

  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}
   */
  @Test
  void testShouldStartWithDiscover2() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    BootstrapConfig config = new BootstrapConfig();
    config.autoIdForSecurityObject = true;

    // Act and Assert
    assertTrue(lwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(config));
  }

  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  void testFindServerInstanceId() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert that nothing has changed
    verify(readResponse).getContent();
  }

  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  void testFindServerInstanceId2() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(new LwM2mObject(1, new ArrayList<>()));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert that nothing has changed
    verify(readResponse).getContent();
  }

  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  void testFindServerInstanceId3() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(new LwM2mObject(1, new LwM2mObjectInstance(new ArrayList<>())));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert that nothing has changed
    verify(readResponse).getContent();
  }

  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#findBootstrapServerId(String)}
   */
  @Test
  void testFindBootstrapServerId() throws InvalidConfigurationException {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    lwM2MBootstrapConfigStoreTaskProvider.put("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNull(lwM2MBootstrapConfigStoreTaskProvider.findBootstrapServerId("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#put(String)}
   */
  @Test
  void testPut() throws InvalidConfigurationException {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.put("https://config.us-east-2.amazonaws.com");

    // Assert
    Map<String, LwM2MBootstrapClientInstanceIds> stringLwM2MBootstrapClientInstanceIdsMap = lwM2MBootstrapConfigStoreTaskProvider.lwM2MBootstrapSessionClients;
    assertEquals(1, stringLwM2MBootstrapClientInstanceIdsMap.size());
    LwM2MBootstrapClientInstanceIds getResult = stringLwM2MBootstrapClientInstanceIdsMap
        .get("https://config.us-east-2.amazonaws.com");
    assertTrue(getResult.getSecurityInstances().isEmpty());
    assertTrue(getResult.getServerInstances().isEmpty());
  }

  /**
   * Method under test:
   * {@link LwM2MBootstrapConfigStoreTaskProvider#LwM2MBootstrapConfigStoreTaskProvider(BootstrapConfigStore)}
   */
  @Test
  void testNewLwM2MBootstrapConfigStoreTaskProvider() {
    // Arrange
    BootstrapConfigStore store = mock(BootstrapConfigStore.class);

    // Act
    LwM2MBootstrapConfigStoreTaskProvider actualLwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        store);

    // Assert
    ReadWriteLock readWriteLock = actualLwM2MBootstrapConfigStoreTaskProvider.readWriteLock;
    assertTrue(readWriteLock instanceof ReentrantReadWriteLock);
    Lock lock = actualLwM2MBootstrapConfigStoreTaskProvider.writeLock;
    assertTrue(lock instanceof ReentrantReadWriteLock.WriteLock);
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getQueueLength());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getReadHoldCount());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getReadLockCount());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getWriteHoldCount());
    assertEquals(0, ((ReentrantReadWriteLock.WriteLock) lock).getHoldCount());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).hasQueuedThreads());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isFair());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isWriteLocked());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isWriteLockedByCurrentThread());
    assertFalse(((ReentrantReadWriteLock.WriteLock) lock).isHeldByCurrentThread());
    assertTrue(actualLwM2MBootstrapConfigStoreTaskProvider.lwM2MBootstrapSessionClients.isEmpty());
    assertSame(store, actualLwM2MBootstrapConfigStoreTaskProvider.getStore());
  }
}
