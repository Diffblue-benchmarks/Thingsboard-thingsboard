package org.thingsboard.server.transport.lwm2m.server.uplink;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import org.eclipse.leshan.core.ResponseCode;
import org.eclipse.leshan.core.node.InvalidLwM2mPathException;
import org.eclipse.leshan.core.node.LwM2mNode;
import org.eclipse.leshan.core.node.LwM2mObjectInstance;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.TimestampedLwM2mNodes;
import org.eclipse.leshan.core.request.CreateRequest;
import org.eclipse.leshan.core.response.AbstractLwM2mResponse;
import org.eclipse.leshan.core.response.CancelCompositeObservationResponse;
import org.eclipse.leshan.core.response.CancelObservationResponse;
import org.eclipse.leshan.core.response.ReadCompositeResponse;
import org.eclipse.leshan.core.response.ReadResponse;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.device.profile.Lwm2mDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.TelemetryMappingConfiguration;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

@ExtendWith(MockitoExtension.class)
class DefaultLwM2mUplinkMsgHandlerDiffblueTest {
  @InjectMocks
  private DefaultLwM2mUplinkMsgHandler defaultLwM2mUplinkMsgHandler;

  @Mock
  private LwM2MTelemetryLogService lwM2MTelemetryLogService;

  @Mock
  private LwM2mClientContext lwM2mClientContext;

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onSleepingDev(Registration)}.
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link LwM2mClientContext#asleep(LwM2mClient)} return {@code true}.</li>
   *   <li>Then calls {@link Registration#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onSleepingDev(Registration)}
   */
  @Test
  @DisplayName("Test onSleepingDev(Registration); given LwM2mClientContext asleep(LwM2mClient) return 'true'; then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onSleepingDev(Registration)"})
  void testOnSleepingDev_givenLwM2mClientContextAsleepReturnTrue_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mClientContext.asleep(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(registration.getId()).thenReturn("42");

    // Act
    defaultLwM2mUplinkMsgHandler.onSleepingDev(registration);

    // Assert
    verify(registration, atLeast(1)).getEndpoint();
    verify(registration).getId();
    verify(lwM2mClientContext).asleep(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}.
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadResponse(Registration, String, ReadResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(Registration, String, ReadResponse)"})
  void testOnUpdateValueAfterReadResponse() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelObservationResponse response = mock(CancelObservationResponse.class);
    when(response.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(registration, "Path", response);

    // Assert
    verify(response).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#update(LwM2mClient)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadResponse(Registration, String, ReadResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadResponse(Registration, String, ReadResponse); then calls update(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(Registration, String, ReadResponse)"})
  void testOnUpdateValueAfterReadResponse_thenCallsUpdate() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(false);
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelObservationResponse response = mock(CancelObservationResponse.class);
    when(response.getContent()).thenReturn(new LwM2mObjectInstance(new ArrayList<>()));

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadResponse(registration, "Path", response);

    // Assert
    verify(response).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}.
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)"})
  void testOnUpdateValueAfterReadCompositeResponse() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getContent()).thenReturn(new HashMap<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}.
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)"})
  void testOnUpdateValueAfterReadCompositeResponse2() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(false);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getContent()).thenReturn(new HashMap<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mClientContext, atLeast(1)).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}.
   * <ul>
   *   <li>Given fromCode one.</li>
   *   <li>Then calls {@link AbstractLwM2mResponse#getCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse); given fromCode one; then calls getCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)"})
  void testOnUpdateValueAfterReadCompositeResponse_givenFromCodeOne_thenCallsGetCode()
      throws InvalidLwM2mPathException {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath(1), mock(LwM2mNode.class));
    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getCode()).thenReturn(ResponseCode.fromCode(1));
    when(response.getContent()).thenReturn(lwM2mPathLwM2mNodeMap);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response).getCode();
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClient#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)}
   */
  @Test
  @DisplayName("Test onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(Registration, ReadCompositeResponse)"})
  void testOnUpdateValueAfterReadCompositeResponse_thenCallsGetEndpoint() {
    // Arrange
    LwM2mClient lwM2mClient = mock(LwM2mClient.class);
    when(lwM2mClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(lwM2mClient);
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    CancelCompositeObservationResponse response = mock(CancelCompositeObservationResponse.class);
    when(response.getContent()).thenReturn(new HashMap<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueAfterReadCompositeResponse(registration, response);

    // Assert
    verify(response, atLeast(1)).getContent();
    verify(registration).getEndpoint();
    verify(lwM2mClient).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onErrorObservation(Registration, String)}.
   * <ul>
   *   <li>Then calls {@link Registration#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onErrorObservation(Registration, String)}
   */
  @Test
  @DisplayName("Test onErrorObservation(Registration, String); then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onErrorObservation(Registration, String)"})
  void testOnErrorObservation_thenCallsGetEndpoint() {
    // Arrange
    doNothing().when(lwM2MTelemetryLogService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.onErrorObservation(registration, "An error occurred");

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(lwM2MTelemetryLogService).log(isA(LwM2mClient.class), eq("error: An error occurred"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}.
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"})
  void testOnUpdateValueWithSendRequest() throws InvalidLwM2mPathException {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath(1), mock(LwM2mNode.class));
    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(lwM2mPathLwM2mNodeMap);
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(registration, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link TimestampedLwM2mNodes#getNodesAt(Instant)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); given HashMap(); when 'null'; then calls getNodesAt(Instant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"})
  void testOnUpdateValueWithSendRequest_givenHashMap_whenNull_thenCallsGetNodesAt() {
    // Arrange
    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(new HashMap<>());
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(null, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link TimestampedLwM2mNodes#getTimestamps()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); given HashSet(); when 'null'; then calls getTimestamps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"})
  void testOnUpdateValueWithSendRequest_givenHashSet_whenNull_thenCallsGetTimestamps() {
    // Arrange
    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getTimestamps()).thenReturn(new HashSet<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(null, data);

    // Assert
    verify(data).getTimestamps();
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#update(LwM2mClient)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)}
   */
  @Test
  @DisplayName("Test onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes); then calls update(LwM2mClient)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(Registration, TimestampedLwM2mNodes)"})
  void testOnUpdateValueWithSendRequest_thenCallsUpdate() throws InvalidLwM2mPathException {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(false);
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    HashSet<Instant> instantSet = new HashSet<>();
    instantSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    HashMap<LwM2mPath, LwM2mNode> lwM2mPathLwM2mNodeMap = new HashMap<>();
    lwM2mPathLwM2mNodeMap.put(new LwM2mPath(1), mock(LwM2mNode.class));
    TimestampedLwM2mNodes data = mock(TimestampedLwM2mNodes.class);
    when(data.getNodesAt(Mockito.<Instant>any())).thenReturn(lwM2mPathLwM2mNodeMap);
    when(data.getTimestamps()).thenReturn(instantSet);

    // Act
    defaultLwM2mUplinkMsgHandler.onUpdateValueWithSendRequest(registration, data);

    // Assert
    verify(data).getNodesAt(isA(Instant.class));
    verify(data).getTimestamps();
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onAwakeDev(Registration)}.
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link LwM2mClientContext#awake(LwM2mClient)} return {@code true}.</li>
   *   <li>Then calls {@link Registration#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onAwakeDev(Registration)}
   */
  @Test
  @DisplayName("Test onAwakeDev(Registration); given LwM2mClientContext awake(LwM2mClient) return 'true'; then calls getEndpoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onAwakeDev(Registration)"})
  void testOnAwakeDev_givenLwM2mClientContextAwakeReturnTrue_thenCallsGetEndpoint() {
    // Arrange
    when(lwM2mClientContext.awake(Mockito.<LwM2mClient>any())).thenReturn(true);
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(registration.getId()).thenReturn("42");

    // Act
    defaultLwM2mUplinkMsgHandler.onAwakeDev(registration);

    // Assert
    verify(registration, atLeast(1)).getEndpoint();
    verify(registration).getId();
    verify(lwM2mClientContext).awake(isA(LwM2mClient.class));
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(new TelemetryMappingConfiguration());
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry2() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    lwm2mDeviceProfileTransportConfiguration
        .setObserveAttr(new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>()));
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry3() {
    // Arrange
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(registration, "", null);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} addAll {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code Path}.</li>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() addAll ArrayList(); when 'Path'; then calls getProfile(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry_givenHashSetAddAllArrayList_whenPath_thenCallsGetProfile() {
    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("");
    attribute.addAll(new ArrayList<>());
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add empty string.</li>
   *   <li>When {@code Path}.</li>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add empty string; when 'Path'; then calls getProfile(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry_givenHashSetAddEmptyString_whenPath_thenCallsGetProfile() {
    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("UpdateAttrTelemetry paths [{}]");

    HashSet<String> telemetry = new HashSet<>();
    telemetry.add("");
    telemetry.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Path}.</li>
   *   <li>When {@code Path}.</li>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'Path'; when 'Path'; then calls getProfile(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry_givenHashSetAddPath_whenPath_thenCallsGetProfile() {
    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("Path");
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code UpdateAttrTelemetry paths [{}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'UpdateAttrTelemetry paths [{}]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry_givenHashSetAddUpdateAttrTelemetryPaths() {
    // Arrange
    HashSet<String> attribute = new HashSet<>();
    attribute.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code UpdateAttrTelemetry}.</li>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given HashSet() add 'UpdateAttrTelemetry'; then calls getProfile(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry_givenHashSetAddUpdateAttrTelemetry_thenCallsGetProfile() {
    // Arrange
    HashSet<String> telemetry = new HashSet<>();
    telemetry.add("UpdateAttrTelemetry");
    telemetry.add("UpdateAttrTelemetry paths [{}]");
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration(keyName, observe, attribute,
        telemetry, new HashMap<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link LwM2mClientContext} {@link LwM2mClientContext#getClientByEndpoint(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given LwM2mClientContext getClientByEndpoint(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry_givenLwM2mClientContextGetClientByEndpointReturnNull() {
    // Arrange
    when(lwM2mClientContext.getClientByEndpoint(Mockito.<String>any())).thenReturn(null);
    Registration registration = mock(Registration.class);
    when(registration.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(registration, "", null);

    // Assert
    verify(registration).getEndpoint();
    verify(lwM2mClientContext).getClientByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Given {@link TelemetryMappingConfiguration#TelemetryMappingConfiguration()} Attribute is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); given TelemetryMappingConfiguration() Attribute is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry_givenTelemetryMappingConfigurationAttributeIsHashSet() {
    // Arrange
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration();
    observeAttr.setAttribute(new HashSet<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(Registration)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#updateAttrTelemetry(Registration, String, Instant)}
   */
  @Test
  @DisplayName("Test updateAttrTelemetry(Registration, String, Instant); then calls getProfile(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.updateAttrTelemetry(Registration, String, Instant)"})
  void testUpdateAttrTelemetry_thenCallsGetProfile() {
    // Arrange
    when(lwM2mClientContext.getProfile(Mockito.<Registration>any()))
        .thenReturn(new Lwm2mDeviceProfileTransportConfiguration());

    // Act
    defaultLwM2mUplinkMsgHandler.updateAttrTelemetry(null, "Path",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(lwM2mClientContext).getProfile((Registration) isNull());
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String, CreateRequest)}.
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String, CreateRequest)}
   */
  @Test
  @DisplayName("Test onCreateResponseOk(LwM2mClient, String, CreateRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"})
  void testOnCreateResponseOk() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    LwM2mObjectInstance lwM2mObjectInstance = new LwM2mObjectInstance(new ArrayList<>());

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path",
        new CreateRequest(1, lwM2mObjectInstance, new LwM2mObjectInstance(new ArrayList<>())));

    // Assert
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String, CreateRequest)}.
   * <ul>
   *   <li>When {@link LwM2mObjectInstance#LwM2mObjectInstance(Collection)} with resources is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#onCreateResponseOk(LwM2mClient, String, CreateRequest)}
   */
  @Test
  @DisplayName("Test onCreateResponseOk(LwM2mClient, String, CreateRequest); when LwM2mObjectInstance(Collection) with resources is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.onCreateResponseOk(LwM2mClient, String, CreateRequest)"})
  void testOnCreateResponseOk_whenLwM2mObjectInstanceWithResourcesIsArrayList() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2mUplinkMsgHandler.onCreateResponseOk(client, "Path",
        new CreateRequest(1, new LwM2mObjectInstance(new ArrayList<>())));

    // Assert
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}.
   * <ul>
   *   <li>Then calls {@link LwM2mClientContext#getProfile(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mUplinkMsgHandler#initAttributes(LwM2mClient, boolean)}
   */
  @Test
  @DisplayName("Test initAttributes(LwM2mClient, boolean); then calls getProfile(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultLwM2mUplinkMsgHandler.initAttributes(LwM2mClient, boolean)"})
  void testInitAttributes_thenCallsGetProfile() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    lwm2mDeviceProfileTransportConfiguration
        .setObserveAttr(new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>()));
    when(lwM2mClientContext.getProfile(Mockito.<UUID>any())).thenReturn(lwm2mDeviceProfileTransportConfiguration);

    // Act
    defaultLwM2mUplinkMsgHandler.initAttributes(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), true);

    // Assert
    verify(lwM2mClientContext).getProfile((UUID) isNull());
  }
}
