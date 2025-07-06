package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.LwM2mVersion;
import org.eclipse.leshan.core.LwM2m.Version;
import org.eclipse.leshan.core.link.Link;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.node.codec.LwM2mValueConverter;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.core.request.WriteRequest.Mode;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LwM2mClientDiffblueTest {
  /**
   * Test {@link LwM2mClient#LwM2mClient(String, String)}.
   *
   * <p>Method under test: {@link LwM2mClient#LwM2mClient(String, String)}
   */
  @Test
  @DisplayName("Test new LwM2mClient(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.<init>(String, String)"})
  void testNewLwM2mClient() {
    // Arrange and Act
    LwM2mClient actualLwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Assert
    assertEquals("42", actualLwM2mClient.getNodeId());
    assertEquals("https://config.us-east-2.amazonaws.com", actualLwM2mClient.getEndpoint());
    assertNull(actualLwM2mClient.getEdrxCycle());
    assertNull(actualLwM2mClient.getPagingTransmissionWindow());
    assertNull(actualLwM2mClient.getPsmActivityTimer());
    assertNull(actualLwM2mClient.getSupportedClientObjects());
    assertNull(actualLwM2mClient.getClientSupportContentFormats());
    assertNull(actualLwM2mClient.getDeviceId());
    assertNull(actualLwM2mClient.getLastSentRpcId());
    assertNull(actualLwM2mClient.getProfileId());
    assertNull(actualLwM2mClient.getSleepTask());
    assertNull(actualLwM2mClient.getDefaultContentFormat());
    assertNull(actualLwM2mClient.getRegistration());
    assertNull(actualLwM2mClient.getPowerMode());
    assertNull(actualLwM2mClient.getTenantId());
    assertNull(actualLwM2mClient.getSession());
    assertEquals(0L, actualLwM2mClient.getLastUplinkTime());
    assertEquals(LwM2MClientState.CREATED, actualLwM2mClient.getState());
    assertFalse(actualLwM2mClient.isAsleep());
    assertTrue(actualLwM2mClient.getKeyTsLatestMap().isEmpty());
    assertTrue(actualLwM2mClient.getResources().isEmpty());
    assertTrue(actualLwM2mClient.getSharedAttributes().isEmpty());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getLwM2mVersion()).thenThrow(new IllegalArgumentException("/"));
    when(registration.getObjectLinks())
        .thenReturn(new Link[] {new Link("Uri Reference", new ArrayList<>())});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks()).thenThrow(new IllegalArgumentException("/"));
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    when(registration.getObjectLinks())
        .thenReturn(new Link[] {new Link("Uri Reference", new ArrayList<>())});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration3() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks())
        .thenReturn(new Link[] {new Link("/", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    when(registration.getObjectLinks())
        .thenReturn(new Link[] {new Link("Uri Reference", new ArrayList<>())});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TLV", defaultContentFormat.getName());
    assertEquals("application/vnd.oma.lwm2m+tlv", defaultContentFormat.getMediaType());
    assertEquals(11542, defaultContentFormat.getCode());
    assertTrue(lwM2mClient.getSupportedClientObjects().isEmpty());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration4() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks())
        .thenReturn(new Link[] {new Link("42", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    when(registration.getObjectLinks())
        .thenReturn(new Link[] {new Link("Uri Reference", new ArrayList<>())});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TLV", defaultContentFormat.getName());
    assertEquals("application/vnd.oma.lwm2m+tlv", defaultContentFormat.getMediaType());
    assertEquals(1, lwM2mClient.getSupportedClientObjects().size());
    assertEquals(11542, defaultContentFormat.getCode());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration5() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks())
        .thenReturn(new Link[] {new Link("/", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.lastSupported());
    when(registration.getObjectLinks())
        .thenReturn(new Link[] {new Link("Uri Reference", new ArrayList<>())});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TEXT", defaultContentFormat.getName());
    assertEquals("text/plain", defaultContentFormat.getMediaType());
    assertEquals(0, defaultContentFormat.getCode());
    assertTrue(lwM2mClient.getSupportedClientObjects().isEmpty());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration6() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks())
        .thenReturn(new Link[] {new Link("/", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    when(registration.getObjectLinks()).thenReturn(new Link[] {new Link("/", new ArrayList<>())});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TLV", defaultContentFormat.getName());
    assertEquals("application/vnd.oma.lwm2m+tlv", defaultContentFormat.getMediaType());
    assertEquals(11542, defaultContentFormat.getCode());
    assertTrue(lwM2mClient.getSupportedClientObjects().isEmpty());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Link}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration); given empty array of Link")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration_givenEmptyArrayOfLink() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks())
        .thenReturn(new Link[] {new Link("/", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2mVersion.getDefault());
    when(registration.getObjectLinks()).thenReturn(new Link[] {});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TLV", defaultContentFormat.getName());
    assertEquals("application/vnd.oma.lwm2m+tlv", defaultContentFormat.getMediaType());
    assertEquals(11542, defaultContentFormat.getCode());
    assertTrue(lwM2mClient.getSupportedClientObjects().isEmpty());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName(
      "Test setRegistration(Registration); given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2mClient.setRegistration(Registration)"})
  void testSetRegistration_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getObjectLinks()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getObjectLinks();
  }

  /**
   * Test {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#saveResourceValue(String, LwM2mResource,
   * LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  @DisplayName(
      "Test saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2mClient.saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)"
  })
  void testSaveResourceValue_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mSingleResource resource = LwM2mSingleResource.newBooleanResource(1, true);
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("/", resource, modelProvider, Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#saveResourceValue(String, LwM2mResource,
   * LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  @DisplayName(
      "Test saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean LwM2mClient.saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)"
  })
  void testSaveResourceValue_thenThrowIllegalArgumentException2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mSingleResource resource = LwM2mSingleResource.newBooleanResource(1, true);
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("42", resource, modelProvider, Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getResourceModel(String, LwM2mModelProvider); when '42'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ResourceModel LwM2mClient.getResourceModel(String, LwM2mModelProvider)"
  })
  void testGetResourceModel_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getResourceModel("42", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getResourceModel(String, LwM2mModelProvider); when '/'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ResourceModel LwM2mClient.getResourceModel(String, LwM2mModelProvider)"
  })
  void testGetResourceModel_whenSlash_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getResourceModel("/", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_when42() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel("42", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_whenNull() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel(null, mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code Path Id Ver}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when 'Path Id Ver'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_whenPathIdVer() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel("Path Id Ver", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mClient.getObjectModel(String, LwM2mModelProvider)"
  })
  void testGetObjectModel_whenSlash() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getObjectModel("/", mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourceForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourceForInstance_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourceForInstance(
                "/", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourceForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourceForInstance_thenThrowIllegalArgumentException2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourceForInstance(
                "42", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourcesForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourcesForInstance_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourcesForInstance(
                "/", null, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider,
   * LwM2mValueConverter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getNewResourcesForInstance(String, Object,
   * LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName(
      "Test getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection LwM2mClient.getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)"
  })
  void testGetNewResourcesForInstance_thenThrowIllegalArgumentException2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any()))
        .thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            lwM2mClient.getNewResourcesForInstance(
                "42", null, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_when42() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id 42 absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").isValidObjectVersion("42"));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When {@code /42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_when422() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id 42 absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .isValidObjectVersion("/42"));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_whenSlash() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id null absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").isValidObjectVersion("/"));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '//'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LwM2mClient.isValidObjectVersion(String)"})
  void testIsValidObjectVersion_whenSlashSlash() {
    // Arrange, Act and Assert
    assertEquals(
        "Specified object id null absent in the list supported objects of the client or is security object!",
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").isValidObjectVersion("//"));
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_when42() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getLwM2mPathFromString("42");

    // Assert
    LwM2mPath toMaxDescendantResult = actualLwM2mPathFromString.toMaxDescendant();
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
    LwM2mPath lwM2mPath = actualLwM2mPathFromString.ROOTPATH;
    assertSame(lwM2mPath, toParenPathResult.toParenPath().toParenPath().toParenPath());
    assertSame(lwM2mPath, actualLwM2mPathFromString.toParenPath());
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When {@code /42}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_when422() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getLwM2mPathFromString("/42");

    // Assert
    LwM2mPath toMaxDescendantResult = actualLwM2mPathFromString.toMaxDescendant();
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
    LwM2mPath lwM2mPath = actualLwM2mPathFromString.ROOTPATH;
    assertSame(lwM2mPath, toParenPathResult.toParenPath().toParenPath().toParenPath());
    assertSame(lwM2mPath, actualLwM2mPathFromString.toParenPath());
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   *   <li>Then return {@link LwM2mPath#ROOTPATH}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '//'; then return ROOTPATH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_whenSlashSlash_thenReturnRootpath() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getLwM2mPathFromString("//");

    // Assert
    assertEquals(actualLwM2mPathFromString.ROOTPATH, actualLwM2mPathFromString);
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@link LwM2mPath#ROOTPATH}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '/'; then return ROOTPATH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mPath LwM2mClient.getLwM2mPathFromString(String)"})
  void testGetLwM2mPathFromString_whenSlash_thenReturnRootpath() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").getLwM2mPathFromString("/");

    // Assert
    assertEquals(actualLwM2mPathFromString.ROOTPATH, actualLwM2mPathFromString);
  }

  /**
   * Test {@link LwM2mClient#getDefaultObjectIDVer()}.
   *
   * <p>Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  @DisplayName("Test getDefaultObjectIDVer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Version LwM2mClient.getDefaultObjectIDVer()"})
  void testGetDefaultObjectIDVer() {
    // Arrange and Act
    Version actualDefaultObjectIDVer =
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com").getDefaultObjectIDVer();

    // Assert
    assertEquals(actualDefaultObjectIDVer.V1_0, actualDefaultObjectIDVer);
  }

  /**
   * Test {@link LwM2mClient#getDefaultObjectIDVer()}.
   *
   * <p>Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  @DisplayName("Test getDefaultObjectIDVer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Version LwM2mClient.getDefaultObjectIDVer()"})
  void testGetDefaultObjectIDVer2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    lwM2mClient.setDefaultObjectIDVer(Version.getDefault());

    // Act
    Version actualDefaultObjectIDVer = lwM2mClient.getDefaultObjectIDVer();

    // Assert
    assertSame(actualDefaultObjectIDVer.V1_0, actualDefaultObjectIDVer);
  }

  /**
   * Test {@link LwM2mClient#getSupportedObjectVersion(Integer)}.
   *
   * <p>Method under test: {@link LwM2mClient#getSupportedObjectVersion(Integer)}
   */
  @Test
  @DisplayName("Test getSupportedObjectVersion(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Version LwM2mClient.getSupportedObjectVersion(Integer)"})
  void testGetSupportedObjectVersion() {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")
            .getSupportedObjectVersion(1));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mClient lwM2mClient2 = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient2);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient2.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);
    LwM2mClient lwM2mClient2 = new LwM2mClient("42", null);

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient2);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient2.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2mClient, lwM2mClient);
    int expectedHashCodeResult = lwM2mClient.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mClient.hashCode());
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "Endpoint");

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null);
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2mClient.equals(Object)", "int LwM2mClient.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
        "Different type to LwM2mClient");
  }
}
