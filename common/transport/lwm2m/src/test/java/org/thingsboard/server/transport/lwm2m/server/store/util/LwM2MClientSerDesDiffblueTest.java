package org.thingsboard.server.transport.lwm2m.server.store.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mNodeException;
import org.eclipse.leshan.core.node.LwM2mResourceInstance;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MClientState;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.ResourceValue;

class LwM2MClientSerDesDiffblueTest {
  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'")
  void testSerializeWithClient() {
    // Arrange
    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newBooleanResource(1, true);
    stringResourceValueMap.put("endpoint",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'")
  void testSerializeWithClient2() {
    // Arrange
    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newFloatResource(1, 10.0d);
    stringResourceValueMap.put("endpoint",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'")
  void testSerializeWithClient3() {
    // Arrange
    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newIntegerResource(1, 42L);
    stringResourceValueMap.put("endpoint",
        new ResourceValue(lwM2mResource, new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true,
            ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something")));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'")
  void testSerializeWithClient4() {
    // Arrange
    ResourceValue resourceValue = mock(ResourceValue.class);
    when(resourceValue.getResourceModel()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(resourceValue.getLwM2mResource())
        .thenReturn(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("endpoint", resourceValue);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(resourceValue).getLwM2mResource();
    verify(resourceValue).getResourceModel();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'")
  void testSerializeWithClient5() {
    // Arrange
    LwM2mMultipleResource lwM2mMultipleResource = mock(LwM2mMultipleResource.class);
    when(lwM2mMultipleResource.getInstances()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(lwM2mMultipleResource.isMultiInstances()).thenReturn(true);
    when(lwM2mMultipleResource.getId()).thenReturn(1);
    when(lwM2mMultipleResource.getType()).thenReturn(ResourceModel.Type.NONE);
    ResourceValue resourceValue = mock(ResourceValue.class);
    when(resourceValue.getLwM2mResource()).thenReturn(lwM2mMultipleResource);

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("endpoint", resourceValue);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(lwM2mMultipleResource).getId();
    verify(lwM2mMultipleResource).getInstances();
    verify(lwM2mMultipleResource).getType();
    verify(lwM2mMultipleResource).isMultiInstances();
    verify(client).getEndpoint();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(resourceValue).getLwM2mResource();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add newBooleanInstance one and
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given ArrayList() add newBooleanInstance one and 'true'")
  void testSerializeWithClient_givenArrayListAddNewBooleanInstanceOneAndTrue() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("endpoint", resourceValue);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add newBooleanInstance one and
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given ArrayList() add newBooleanInstance one and 'true'")
  void testSerializeWithClient_givenArrayListAddNewBooleanInstanceOneAndTrue2() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, instances);

    ResourceValue resourceValue = new ResourceValue(lwM2mResource,
        new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true, true, ResourceModel.Type.NONE,
            "Range Enumeration", "Units", "The characteristics of someone or something"));

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("endpoint", resourceValue);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} All is
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given ConcurrentHashMap() All is HashMap()")
  void testSerializeWithClient_givenConcurrentHashMapAllIsHashMap() {
    // Arrange
    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.putAll(new HashMap<>());
    stringAtomicLongMap.put("nodeId", new AtomicLong(1L));
    stringAtomicLongMap.put("resources", new AtomicLong(1L));
    stringAtomicLongMap.put("endpoint", new AtomicLong(1L));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@code endpoint} is
   * {@link AtomicLong#AtomicLong(long)} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given ConcurrentHashMap() 'endpoint' is AtomicLong(long) with one")
  void testSerializeWithClient_givenConcurrentHashMapEndpointIsAtomicLongWithOne() {
    // Arrange
    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.put("endpoint", new AtomicLong(1L));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@code nodeId} is
   * {@link AtomicLong#AtomicLong(long)} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given ConcurrentHashMap() 'nodeId' is AtomicLong(long) with one")
  void testSerializeWithClient_givenConcurrentHashMapNodeIdIsAtomicLongWithOne() {
    // Arrange
    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.put("nodeId", new AtomicLong(1L));
    stringAtomicLongMap.put("resources", new AtomicLong(1L));
    stringAtomicLongMap.put("endpoint", new AtomicLong(1L));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@code resources} is
   * {@link AtomicLong#AtomicLong(long)} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given ConcurrentHashMap() 'resources' is AtomicLong(long) with one")
  void testSerializeWithClient_givenConcurrentHashMapResourcesIsAtomicLongWithOne() {
    // Arrange
    ConcurrentHashMap<String, AtomicLong> stringAtomicLongMap = new ConcurrentHashMap<>();
    stringAtomicLongMap.put("resources", new AtomicLong(1L));
    stringAtomicLongMap.put("endpoint", new AtomicLong(1L));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(stringAtomicLongMap);

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()}.</li>
   *   <li>Then calls {@link LwM2mClient#getKeyTsLatestMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given ConcurrentHashMap(); then calls getKeyTsLatestMap()")
  void testSerializeWithClient_givenConcurrentHashMap_thenCallsGetKeyTsLatestMap() {
    // Arrange
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code endpoint} is DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given HashMap() 'endpoint' is DefaultInstance")
  void testSerializeWithClient_givenHashMapEndpointIsDefaultInstance() {
    // Arrange
    HashMap<String, TransportProtos.TsKvProto> stringTsKvProtoMap = new HashMap<>();
    stringTsKvProtoMap.put("endpoint", TransportProtos.TsKvProto.getDefaultInstance());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(stringTsKvProtoMap);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} IfAbsent {@code endpoint} is
   * DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given HashMap() IfAbsent 'endpoint' is DefaultInstance")
  void testSerializeWithClient_givenHashMapIfAbsentEndpointIsDefaultInstance() {
    // Arrange
    HashMap<String, TransportProtos.TsKvProto> stringTsKvProtoMap = new HashMap<>();
    stringTsKvProtoMap.putIfAbsent("endpoint", TransportProtos.TsKvProto.getDefaultInstance());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(new HashMap<>());
    when(client.getSharedAttributes()).thenReturn(stringTsKvProtoMap);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Given {@link LwM2mMultipleResource}
   * {@link LwM2mMultipleResource#getInstances()} return
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; given LwM2mMultipleResource getInstances() return HashMap()")
  void testSerializeWithClient_givenLwM2mMultipleResourceGetInstancesReturnHashMap() {
    // Arrange
    LwM2mMultipleResource lwM2mMultipleResource = mock(LwM2mMultipleResource.class);
    when(lwM2mMultipleResource.getInstances()).thenReturn(new HashMap<>());
    when(lwM2mMultipleResource.isMultiInstances()).thenReturn(true);
    when(lwM2mMultipleResource.getId()).thenReturn(1);
    when(lwM2mMultipleResource.getType()).thenReturn(ResourceModel.Type.NONE);
    ResourceValue resourceValue = mock(ResourceValue.class);
    when(resourceValue.getResourceModel()).thenReturn(new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true,
        true, ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something"));
    when(resourceValue.getLwM2mResource()).thenReturn(lwM2mMultipleResource);

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("endpoint", resourceValue);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(lwM2mMultipleResource).getId();
    verify(lwM2mMultipleResource).getInstances();
    verify(lwM2mMultipleResource).getType();
    verify(lwM2mMultipleResource).isMultiInstances();
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
    verify(resourceValue).getLwM2mResource();
    verify(resourceValue).getResourceModel();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Then calls {@link ResourceValue#getResourceModel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; then calls getResourceModel()")
  void testSerializeWithClient_thenCallsGetResourceModel() {
    // Arrange
    ResourceValue resourceValue = mock(ResourceValue.class);
    when(resourceValue.getResourceModel()).thenReturn(new ResourceModel(1, "Name", ResourceModel.Operations.NONE, true,
        true, ResourceModel.Type.NONE, "Range Enumeration", "Units", "The characteristics of someone or something"));
    when(resourceValue.getLwM2mResource())
        .thenReturn(new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>()));

    HashMap<String, ResourceValue> stringResourceValueMap = new HashMap<>();
    stringResourceValueMap.put("endpoint", resourceValue);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenThrow(new LwM2mNodeException("An error occurred"));
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);
    when(client.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(client.getNodeId()).thenReturn("42");
    when(client.getResources()).thenReturn(stringResourceValueMap);
    when(client.getSharedAttributes()).thenReturn(new HashMap<>());
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());

    // Act and Assert
    assertThrows(LwM2mNodeException.class, () -> LwM2MClientSerDes.serialize(client));
    verify(client).getEndpoint();
    verify(client).getKeyTsLatestMap();
    verify(client).getNodeId();
    verify(client).getResources();
    verify(client).getSession();
    verify(client).getSharedAttributes();
    verify(client).getState();
    verify(resourceValue).getLwM2mResource();
    verify(resourceValue).getResourceModel();
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Then return thirteenth element is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; then return thirteenth element is '2'")
  void testSerializeWithClient_thenReturnThirteenthElementIs2() {
    // Arrange and Act
    byte[] actualSerializeResult = LwM2MClientSerDes
        .serialize(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Assert
    assertEquals(246, actualSerializeResult.length);
    assertEquals('2', actualSerializeResult[12]);
    assertEquals('4', actualSerializeResult[11]);
    assertEquals('"', actualSerializeResult[10]);
    assertEquals('"', actualSerializeResult[13]);
  }

  /**
   * Test {@link LwM2MClientSerDes#serialize(LwM2mClient)} with {@code client}.
   * <ul>
   *   <li>Then return thirteenth element is {@code l}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientSerDes#serialize(LwM2mClient)}
   */
  @Test
  @DisplayName("Test serialize(LwM2mClient) with 'client'; then return thirteenth element is 'l'")
  void testSerializeWithClient_thenReturnThirteenthElementIsL() {
    // Arrange and Act
    byte[] actualSerializeResult = LwM2MClientSerDes
        .serialize(new LwM2mClient(null, "https://config.us-east-2.amazonaws.com"));

    // Assert
    assertEquals(246, actualSerializeResult.length);
    assertEquals('l', actualSerializeResult[12]);
    assertEquals('l', actualSerializeResult[13]);
    assertEquals('n', actualSerializeResult[10]);
    assertEquals('u', actualSerializeResult[11]);
  }
}
