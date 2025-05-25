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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.eclipse.leshan.core.node.LwM2mObject;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.core.request.BootstrapRequest;
import org.eclipse.leshan.core.request.exception.InvalidRequestException;
import org.eclipse.leshan.core.response.BootstrapReadResponse;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.BootstrapConfigStore;
import org.eclipse.leshan.server.bootstrap.BootstrapSession;
import org.eclipse.leshan.server.bootstrap.BootstrapTaskProvider;
import org.eclipse.leshan.server.bootstrap.BootstrapTaskProvider.Tasks;
import org.eclipse.leshan.server.bootstrap.DefaultBootstrapSession;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LwM2MBootstrapConfigStoreTaskProviderDiffblueTest {
  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#LwM2MBootstrapConfigStoreTaskProvider(BootstrapConfigStore)}.
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#LwM2MBootstrapConfigStoreTaskProvider(BootstrapConfigStore)}
   */
  @Test
  @DisplayName("Test new LwM2MBootstrapConfigStoreTaskProvider(BootstrapConfigStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MBootstrapConfigStoreTaskProvider.<init>(BootstrapConfigStore)"})
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
    assertTrue(lock instanceof WriteLock);
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getQueueLength());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getReadHoldCount());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getReadLockCount());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getWriteHoldCount());
    assertEquals(0, ((WriteLock) lock).getHoldCount());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).hasQueuedThreads());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isFair());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isWriteLocked());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isWriteLockedByCurrentThread());
    assertFalse(((WriteLock) lock).isHeldByCurrentThread());
    assertTrue(actualLwM2MBootstrapConfigStoreTaskProvider.lwM2MBootstrapSessionClients.isEmpty());
    assertSame(store, actualLwM2MBootstrapConfigStoreTaskProvider.getStore());
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#getTasks(BootstrapSession, List)}.
   * <ul>
   *   <li>Given {@link BootstrapConfigStore} {@link BootstrapConfigStore#get(BootstrapSession)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#getTasks(BootstrapSession, List)}
   */
  @Test
  @DisplayName("Test getTasks(BootstrapSession, List); given BootstrapConfigStore get(BootstrapSession) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BootstrapTaskProvider.Tasks LwM2MBootstrapConfigStoreTaskProvider.getTasks(BootstrapSession, List)"})
  void testGetTasks_givenBootstrapConfigStoreGetReturnNull_thenReturnNull() throws InvalidRequestException {
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
    Tasks actualTasks = lwM2MBootstrapConfigStoreTaskProvider.getTasks(session, new ArrayList<>());

    // Assert
    verify(store).get(isA(BootstrapSession.class));
    assertNull(actualTasks);
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}
   */
  @Test
  @DisplayName("Test shouldStartWithDiscover(BootstrapConfig); given 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(BootstrapConfig)"})
  void testShouldStartWithDiscover_givenTrue_thenReturnTrue() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    BootstrapConfig config = new BootstrapConfig();
    config.autoIdForSecurityObject = true;

    // Act and Assert
    assertTrue(lwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(config));
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}.
   * <ul>
   *   <li>When {@link BootstrapConfig} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}
   */
  @Test
  @DisplayName("Test shouldStartWithDiscover(BootstrapConfig); when BootstrapConfig (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(BootstrapConfig)"})
  void testShouldStartWithDiscover_whenBootstrapConfig_thenReturnFalse() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));

    // Act and Assert
    assertFalse(lwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(new BootstrapConfig()));
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}.
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName("Test findServerInstanceId(BootstrapReadResponse, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"})
  void testFindServerInstanceId() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(new LwM2mObject(1, new LwM2mObjectInstance(new ArrayList<>())));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}.
   * <ul>
   *   <li>Given {@link LwM2mObjectInstance#LwM2mObjectInstance(Collection)} with resources is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName("Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mObjectInstance(Collection) with resources is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"})
  void testFindServerInstanceId_givenLwM2mObjectInstanceWithResourcesIsArrayList() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}.
   * <ul>
   *   <li>Given {@link LwM2mObject#LwM2mObject(int, Collection)} with id is one and instances is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName("Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mObject(int, Collection) with id is one and instances is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"})
  void testFindServerInstanceId_givenLwM2mObjectWithIdIsOneAndInstancesIsArrayList() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(new LwM2mObject(1, new ArrayList<>()));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findBootstrapServerId(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#findBootstrapServerId(String)}
   */
  @Test
  @DisplayName("Test findBootstrapServerId(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer LwM2MBootstrapConfigStoreTaskProvider.findBootstrapServerId(String)"})
  void testFindBootstrapServerId_thenReturnNull() throws InvalidConfigurationException {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider = new LwM2MBootstrapConfigStoreTaskProvider(
        mock(BootstrapConfigStore.class));
    lwM2MBootstrapConfigStoreTaskProvider.put("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNull(lwM2MBootstrapConfigStoreTaskProvider.findBootstrapServerId("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#put(String)}.
   * <p>
   * Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#put(String)}
   */
  @Test
  @DisplayName("Test put(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MBootstrapConfigStoreTaskProvider.put(String)"})
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
}
