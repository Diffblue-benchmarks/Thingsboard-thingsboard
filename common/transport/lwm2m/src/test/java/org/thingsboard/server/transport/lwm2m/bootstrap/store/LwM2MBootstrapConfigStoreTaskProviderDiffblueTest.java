package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.eclipse.leshan.core.link.Link;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mObject;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.response.BootstrapReadResponse;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.BootstrapConfigStore;
import org.eclipse.leshan.server.bootstrap.InvalidConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MBootstrapConfigStoreTaskProviderDiffblueTest {
  /**
   * Test {@link
   * LwM2MBootstrapConfigStoreTaskProvider#LwM2MBootstrapConfigStoreTaskProvider(BootstrapConfigStore)}.
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#LwM2MBootstrapConfigStoreTaskProvider(BootstrapConfigStore)}
   */
  @Test
  @DisplayName("Test new LwM2MBootstrapConfigStoreTaskProvider(BootstrapConfigStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MBootstrapConfigStoreTaskProvider.<init>(BootstrapConfigStore)"})
  void testNewLwM2MBootstrapConfigStoreTaskProvider() {
    // Arrange
    BootstrapConfigStore store = mock(BootstrapConfigStore.class);

    // Act
    LwM2MBootstrapConfigStoreTaskProvider actualLwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(store);

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
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}
   */
  @Test
  @DisplayName("Test shouldStartWithDiscover(BootstrapConfig); given 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(BootstrapConfig)"
  })
  void testShouldStartWithDiscover_givenTrue_thenReturnTrue() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));
    BootstrapConfig config = new BootstrapConfig();
    config.autoIdForSecurityObject = true;

    // Act and Assert
    assertTrue(lwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(config));
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}.
   *
   * <ul>
   *   <li>When {@link BootstrapConfig} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#shouldStartWithDiscover(BootstrapConfig)}
   */
  @Test
  @DisplayName(
      "Test shouldStartWithDiscover(BootstrapConfig); when BootstrapConfig (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(BootstrapConfig)"
  })
  void testShouldStartWithDiscover_whenBootstrapConfig_thenReturnFalse() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    // Act and Assert
    assertFalse(
        lwM2MBootstrapConfigStoreTaskProvider.shouldStartWithDiscover(new BootstrapConfig()));
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findSecurityInstanceId(Link[], String)}.
   *
   * <ul>
   *   <li>Then calls {@link Link#getUriReference()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findSecurityInstanceId(Link[], String)}
   */
  @Test
  @DisplayName("Test findSecurityInstanceId(Link[], String); then calls getUriReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findSecurityInstanceId(Link[], String)"
  })
  void testFindSecurityInstanceId_thenCallsGetUriReference() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    Link link = mock(Link.class);
    when(link.getUriReference()).thenReturn("/0/");

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findSecurityInstanceId(
        new Link[] {link}, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(link, atLeast(1)).getUriReference();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName("Test findServerInstanceId(BootstrapReadResponse, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    LwM2mObject lwM2mObject = new LwM2mObject(1, new LwM2mObjectInstance(new ArrayList<>()));
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName("Test findServerInstanceId(BootstrapReadResponse, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId2() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    LwM2mMultipleResource lwM2mMultipleResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    when(lwM2mObjectInstance.getResource(anyInt())).thenReturn(lwM2mMultipleResource);
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName("Test findServerInstanceId(BootstrapReadResponse, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId3() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    when(lwM2mObjectInstance.getResource(anyInt()))
        .thenReturn(LwM2mSingleResource.newBooleanResource(1, true));
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName("Test findServerInstanceId(BootstrapReadResponse, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId4() throws InvalidConfigurationException {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));
    lwM2MBootstrapConfigStoreTaskProvider.put("https://config.us-east-2.amazonaws.com");

    LwM2mResource lwM2mResource = mock(LwM2mResource.class);
    when(lwM2mResource.getValue()).thenReturn(1);
    when(lwM2mResource.getType()).thenReturn(Type.NONE);

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    when(lwM2mObjectInstance.getResource(anyInt())).thenReturn(lwM2mResource);
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance, atLeast(1)).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(lwM2mResource).getType();
    verify(lwM2mResource).getValue();
    verify(readResponse).getContent();
    Map<String, LwM2MBootstrapClientInstanceIds> stringLwM2MBootstrapClientInstanceIdsMap =
        lwM2MBootstrapConfigStoreTaskProvider.lwM2MBootstrapSessionClients;
    assertEquals(1, stringLwM2MBootstrapClientInstanceIdsMap.size());
    Map<Integer, Integer> serverInstances =
        stringLwM2MBootstrapClientInstanceIdsMap
            .get("https://config.us-east-2.amazonaws.com")
            .getServerInstances();
    assertEquals(1, serverInstances.size());
    assertEquals(1, serverInstances.get(1).intValue());
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mObjectInstance#LwM2mObjectInstance(Collection)} with resources is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName(
      "Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mObjectInstance(Collection) with resources is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenLwM2mObjectInstanceWithResourcesIsArrayList() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mObject#LwM2mObject(int, Collection)} with id is one and instances is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName(
      "Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mObject(int, Collection) with id is one and instances is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenLwM2mObjectWithIdIsOneAndInstancesIsArrayList() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    LwM2mObject lwM2mObject = new LwM2mObject(1, new ArrayList<>());
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mResource} {@link LwM2mResource#getValue()} return {@code null}.
   *   <li>Then calls {@link LwM2mResource#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName(
      "Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mResource getValue() return 'null'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenLwM2mResourceGetValueReturnNull_thenCallsGetType() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    LwM2mResource lwM2mResource = mock(LwM2mResource.class);
    when(lwM2mResource.getValue()).thenReturn(null);
    when(lwM2mResource.getType()).thenReturn(Type.NONE);

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    when(lwM2mObjectInstance.getResource(anyInt())).thenReturn(lwM2mResource);
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(lwM2mResource).getType();
    verify(lwM2mResource).getValue();
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mResource} {@link LwM2mResource#getValue()} return {@code null}.
   *   <li>Then calls {@link LwM2mResource#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName(
      "Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mResource getValue() return 'null'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenLwM2mResourceGetValueReturnNull_thenCallsGetType2() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    LwM2mResource lwM2mResource = mock(LwM2mResource.class);
    when(lwM2mResource.getValue()).thenReturn(null);
    when(lwM2mResource.getType()).thenReturn(Type.OPAQUE);

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    when(lwM2mObjectInstance.getResource(anyInt())).thenReturn(lwM2mResource);
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(lwM2mResource).getType();
    verify(lwM2mResource).getValue();
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mResource} {@link LwM2mResource#getValue()} return one.
   *   <li>Then calls {@link LwM2mResource#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName(
      "Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mResource getValue() return one; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenLwM2mResourceGetValueReturnOne_thenCallsGetType() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    LwM2mResource lwM2mResource = mock(LwM2mResource.class);
    when(lwM2mResource.getValue()).thenReturn(1L);
    when(lwM2mResource.getType()).thenReturn(Type.NONE);

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    when(lwM2mObjectInstance.getResource(anyInt())).thenReturn(lwM2mResource);
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(lwM2mResource).getType();
    verify(lwM2mResource).getValue();
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mResource} {@link LwM2mResource#getValue()} return one.
   *   <li>Then calls {@link LwM2mResource#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName(
      "Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mResource getValue() return one; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenLwM2mResourceGetValueReturnOne_thenCallsGetType2() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    LwM2mResource lwM2mResource = mock(LwM2mResource.class);
    when(lwM2mResource.getValue()).thenReturn(1);
    when(lwM2mResource.getType()).thenReturn(Type.NONE);

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    when(lwM2mObjectInstance.getResource(anyInt())).thenReturn(lwM2mResource);
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(lwM2mResource).getType();
    verify(lwM2mResource).getValue();
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mResource} {@link LwM2mResource#getValue()} return {@code Value}.
   *   <li>Then calls {@link LwM2mResource#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName(
      "Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mResource getValue() return 'Value'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenLwM2mResourceGetValueReturnValue_thenCallsGetType() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    LwM2mResource lwM2mResource = mock(LwM2mResource.class);
    when(lwM2mResource.getValue()).thenReturn("Value");
    when(lwM2mResource.getType()).thenReturn(Type.NONE);

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    when(lwM2mObjectInstance.getResource(anyInt())).thenReturn(lwM2mResource);
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(lwM2mResource).getType();
    verify(lwM2mResource).getValue();
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link LwM2mResource} {@link LwM2mResource#getValue()} return {@code Value}.
   *   <li>Then calls {@link LwM2mResource#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName(
      "Test findServerInstanceId(BootstrapReadResponse, String); given LwM2mResource getValue() return 'Value'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenLwM2mResourceGetValueReturnValue_thenCallsGetType2() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    LwM2mResource lwM2mResource = mock(LwM2mResource.class);
    when(lwM2mResource.getValue()).thenReturn("Value");
    when(lwM2mResource.getType()).thenReturn(Type.OPAQUE);

    LwM2mObjectInstance lwM2mObjectInstance = mock(LwM2mObjectInstance.class);
    when(lwM2mObjectInstance.getId()).thenReturn(1);
    when(lwM2mObjectInstance.getResource(anyInt())).thenReturn(lwM2mResource);
    LwM2mObject lwM2mObject = new LwM2mObject(1, lwM2mObjectInstance);

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenReturn(lwM2mObject);

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(lwM2mObjectInstance).getId();
    verify(lwM2mObjectInstance, atLeast(1)).getResource(0);
    verify(lwM2mResource).getType();
    verify(lwM2mResource).getValue();
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findServerInstanceId(BootstrapReadResponse, String)}
   */
  @Test
  @DisplayName("Test findServerInstanceId(BootstrapReadResponse, String); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(BootstrapReadResponse, String)"
  })
  void testFindServerInstanceId_givenRuntimeException() {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    BootstrapReadResponse readResponse = mock(BootstrapReadResponse.class);
    when(readResponse.getContent()).thenThrow(new RuntimeException());

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.findServerInstanceId(
        readResponse, "https://config.us-east-2.amazonaws.com");

    // Assert
    verify(readResponse).getContent();
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#findBootstrapServerId(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2MBootstrapConfigStoreTaskProvider#findBootstrapServerId(String)}
   */
  @Test
  @DisplayName("Test findBootstrapServerId(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer LwM2MBootstrapConfigStoreTaskProvider.findBootstrapServerId(String)"})
  void testFindBootstrapServerId_thenReturnNull() throws InvalidConfigurationException {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));
    lwM2MBootstrapConfigStoreTaskProvider.put("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertNull(
        lwM2MBootstrapConfigStoreTaskProvider.findBootstrapServerId(
            "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapConfigStoreTaskProvider#put(String)}.
   *
   * <p>Method under test: {@link LwM2MBootstrapConfigStoreTaskProvider#put(String)}
   */
  @Test
  @DisplayName("Test put(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MBootstrapConfigStoreTaskProvider.put(String)"})
  void testPut() throws InvalidConfigurationException {
    // Arrange
    LwM2MBootstrapConfigStoreTaskProvider lwM2MBootstrapConfigStoreTaskProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    // Act
    lwM2MBootstrapConfigStoreTaskProvider.put("https://config.us-east-2.amazonaws.com");

    // Assert
    Map<String, LwM2MBootstrapClientInstanceIds> stringLwM2MBootstrapClientInstanceIdsMap =
        lwM2MBootstrapConfigStoreTaskProvider.lwM2MBootstrapSessionClients;
    assertEquals(1, stringLwM2MBootstrapClientInstanceIdsMap.size());
    LwM2MBootstrapClientInstanceIds getResult =
        stringLwM2MBootstrapClientInstanceIdsMap.get("https://config.us-east-2.amazonaws.com");
    assertTrue(getResult.getSecurityInstances().isEmpty());
    assertTrue(getResult.getServerInstances().isEmpty());
  }
}
