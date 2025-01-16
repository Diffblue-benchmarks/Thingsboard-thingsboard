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
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.link.Link;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.node.codec.LwM2mValueConverter;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.gen.transport.TransportProtos;

class LwM2mClientDiffblueTest {
  /**
   * Test {@link LwM2mClient#init(ValidateDeviceCredentialsResponse, UUID)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#init(ValidateDeviceCredentialsResponse, UUID)}
   */
  @Test
  @DisplayName("Test init(ValidateDeviceCredentialsResponse, UUID); when randomUUID; then throw IllegalArgumentException")
  void testInit_whenRandomUUID_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    ValidateDeviceCredentialsResponse credentials = mock(ValidateDeviceCredentialsResponse.class);
    when(credentials.getDeviceInfo()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.init(credentials, UUID.randomUUID()));
    verify(credentials).getDeviceInfo();
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   * <p>
   * Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  void testSetRegistration() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks()).thenReturn(new Link[]{new Link("/", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2m.LwM2mVersion.getDefault());
    when(registration.getObjectLinks()).thenReturn(new Link[]{new Link("Uri Reference", new ArrayList<>())});

    // Act
    lwM2mClient.setRegistration(registration);

    // Assert
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
    ContentFormat defaultContentFormat = lwM2mClient.getDefaultContentFormat();
    assertEquals("TLV", defaultContentFormat.getName());
    assertEquals("application/vnd.oma.lwm2m+tlv", defaultContentFormat.getMediaType());
    assertEquals(1, lwM2mClient.getClientSupportContentFormats().size());
    assertEquals(11542, defaultContentFormat.getCode());
    assertTrue(lwM2mClient.getSupportedClientObjects().isEmpty());
    assertSame(registration, lwM2mClient.getRegistration());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   * <p>
   * Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration)")
  void testSetRegistration2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks()).thenReturn(new Link[]{new Link("42", new ArrayList<>())});
    when(registration.getLwM2mVersion()).thenReturn(LwM2m.LwM2mVersion.getDefault());
    when(registration.getObjectLinks()).thenReturn(new Link[]{new Link("Uri Reference", new ArrayList<>())});

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
    assertEquals(1, lwM2mClient.getClientSupportContentFormats().size());
    assertEquals(11542, defaultContentFormat.getCode());
    assertSame(registration, lwM2mClient.getRegistration());
  }

  /**
   * Test {@link LwM2mClient#setRegistration(Registration)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#setRegistration(Registration)}
   */
  @Test
  @DisplayName("Test setRegistration(Registration); then throw IllegalArgumentException")
  void testSetRegistration_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    Registration registration = mock(Registration.class);
    when(registration.getSortedObjectLinks()).thenThrow(new IllegalArgumentException("/"));
    when(registration.getLwM2mVersion()).thenReturn(LwM2m.LwM2mVersion.getDefault());
    when(registration.getObjectLinks()).thenReturn(new Link[]{new Link("Uri Reference", new ArrayList<>())});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> lwM2mClient.setRegistration(registration));
    verify(registration).getLwM2mVersion();
    verify(registration).getObjectLinks();
    verify(registration).getSortedObjectLinks();
  }

  /**
   * Test
   * {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode); when '42'; then throw IllegalArgumentException")
  void testSaveResourceValue_when42_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mMultipleResource resource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("42", resource, modelProvider, WriteRequest.Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test
   * {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#saveResourceValue(String, LwM2mResource, LwM2mModelProvider, WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test saveResourceValue(String, LwM2mResource, LwM2mModelProvider, Mode); when '/'; then throw IllegalArgumentException")
  void testSaveResourceValue_whenSlash_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mMultipleResource resource = new LwM2mMultipleResource(1, ResourceModel.Type.NONE, new ArrayList<>());

    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.saveResourceValue("/", resource, modelProvider, WriteRequest.Mode.REPLACE));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getResourceModel(String, LwM2mModelProvider); when '42'; then return 'null'")
  void testGetResourceModel_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getResourceModel("42",
        mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getResourceModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getResourceModel(String, LwM2mModelProvider); when '/'; then return 'null'")
  void testGetResourceModel_whenSlash_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getResourceModel("/",
        mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when '42'")
  void testGetObjectModel_when42() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getObjectModel("42",
        mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when 'null'")
  void testGetObjectModel_whenNull() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getObjectModel(null,
        mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   * <ul>
   *   <li>When {@code Path Id Ver}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when 'Path Id Ver'")
  void testGetObjectModel_whenPathIdVer() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getObjectModel("Path Id Ver",
        mock(LwM2mModelProvider.class)));
  }

  /**
   * Test {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getObjectModel(String, LwM2mModelProvider)}
   */
  @Test
  @DisplayName("Test getObjectModel(String, LwM2mModelProvider); when '/'")
  void testGetObjectModel_whenSlash() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getObjectModel("/",
        mock(LwM2mModelProvider.class)));
  }

  /**
   * Test
   * {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName("Test getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  void testGetNewResourceForInstance_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.getNewResourceForInstance("/", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test
   * {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName("Test getNewResourceForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  void testGetNewResourceForInstance_thenThrowIllegalArgumentException2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.getNewResourceForInstance("42", "Params", modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test
   * {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName("Test getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  void testGetNewResourcesForInstance_thenThrowIllegalArgumentException() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.getNewResourcesForInstance("/", null, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test
   * {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mClient#getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter)}
   */
  @Test
  @DisplayName("Test getNewResourcesForInstance(String, Object, LwM2mModelProvider, LwM2mValueConverter); then throw IllegalArgumentException")
  void testGetNewResourcesForInstance_thenThrowIllegalArgumentException2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    LwM2mModelProvider modelProvider = mock(LwM2mModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<Registration>any())).thenThrow(new IllegalArgumentException("/"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> lwM2mClient.getNewResourcesForInstance("42", null, modelProvider, mock(LwM2mValueConverter.class)));
    verify(modelProvider).getObjectModel(isNull());
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   * <p>
   * Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String)")
  void testIsValidObjectVersion() {
    // Arrange, Act and Assert
    assertEquals("Specified object id 42 absent in the list supported objects of the client or is security object!",
        (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).isValidObjectVersion("42"));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '/'")
  void testIsValidObjectVersion_whenSlash() {
    // Arrange, Act and Assert
    assertEquals("Specified object id null absent in the list supported objects of the client or is security object!",
        (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).isValidObjectVersion("/"));
  }

  /**
   * Test {@link LwM2mClient#isValidObjectVersion(String)}.
   * <ul>
   *   <li>When {@code //}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#isValidObjectVersion(String)}
   */
  @Test
  @DisplayName("Test isValidObjectVersion(String); when '//'")
  void testIsValidObjectVersion_whenSlashSlash() {
    // Arrange, Act and Assert
    assertEquals("Specified object id null absent in the list supported objects of the client or is security object!",
        (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).isValidObjectVersion("//"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}, and {@link LwM2mClient#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#equals(Object)}
   *   <li>{@link LwM2mClient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "Endpoint");

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", null);

    // Act and Assert
    assertNotEquals(lwM2mClient, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null);
  }

  /**
   * Test {@link LwM2mClient#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "Different type to LwM2mClient");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mClient#setAsleep(boolean)}
   *   <li>{@link LwM2mClient#setDefaultObjectIDVer(LwM2m.Version)}
   *   <li>{@link LwM2mClient#setLastSentRpcId(UUID)}
   *   <li>{@link LwM2mClient#setSleepTask(Future)}
   *   <li>{@link LwM2mClient#setState(LwM2MClientState)}
   *   <li>{@link LwM2mClient#checkFirstDownlink()}
   *   <li>{@link LwM2mClient#toString()}
   *   <li>{@link LwM2mClient#getClientSupportContentFormats()}
   *   <li>{@link LwM2mClient#getDefaultContentFormat()}
   *   <li>{@link LwM2mClient#getDeviceId()}
   *   <li>{@link LwM2mClient#getEdrxCycle()}
   *   <li>{@link LwM2mClient#getEndpoint()}
   *   <li>{@link LwM2mClient#getLastSentRpcId()}
   *   <li>{@link LwM2mClient#getLastUplinkTime()}
   *   <li>{@link LwM2mClient#getNodeId()}
   *   <li>{@link LwM2mClient#getPagingTransmissionWindow()}
   *   <li>{@link LwM2mClient#getPowerMode()}
   *   <li>{@link LwM2mClient#getProfileId()}
   *   <li>{@link LwM2mClient#getPsmActivityTimer()}
   *   <li>{@link LwM2mClient#getRegistration()}
   *   <li>{@link LwM2mClient#getResources()}
   *   <li>{@link LwM2mClient#getRetryAttempts()}
   *   <li>{@link LwM2mClient#getSession()}
   *   <li>{@link LwM2mClient#getSharedAttributes()}
   *   <li>{@link LwM2mClient#getSleepTask()}
   *   <li>{@link LwM2mClient#getState()}
   *   <li>{@link LwM2mClient#getSupportedClientObjects()}
   *   <li>{@link LwM2mClient#getTenantId()}
   *   <li>{@link LwM2mClient#isAsleep()}
   *   <li>{@link LwM2mClient#getKeyTsLatestMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    lwM2mClient.setAsleep(true);
    lwM2mClient.setDefaultObjectIDVer(LwM2m.Version.getDefault());
    UUID lastSentRpcId = UUID.randomUUID();
    lwM2mClient.setLastSentRpcId(lastSentRpcId);
    CompletableFuture<Void> sleepTask = new CompletableFuture<>();
    lwM2mClient.setSleepTask(sleepTask);
    lwM2mClient.setState(LwM2MClientState.CREATED);
    boolean actualCheckFirstDownlinkResult = lwM2mClient.checkFirstDownlink();
    String actualToStringResult = lwM2mClient.toString();
    lwM2mClient.getClientSupportContentFormats();
    lwM2mClient.getDefaultContentFormat();
    lwM2mClient.getDeviceId();
    lwM2mClient.getEdrxCycle();
    String actualEndpoint = lwM2mClient.getEndpoint();
    UUID actualLastSentRpcId = lwM2mClient.getLastSentRpcId();
    long actualLastUplinkTime = lwM2mClient.getLastUplinkTime();
    String actualNodeId = lwM2mClient.getNodeId();
    lwM2mClient.getPagingTransmissionWindow();
    lwM2mClient.getPowerMode();
    lwM2mClient.getProfileId();
    lwM2mClient.getPsmActivityTimer();
    lwM2mClient.getRegistration();
    Map<String, ResourceValue> actualResources = lwM2mClient.getResources();
    AtomicInteger actualRetryAttempts = lwM2mClient.getRetryAttempts();
    lwM2mClient.getSession();
    Map<String, TransportProtos.TsKvProto> actualSharedAttributes = lwM2mClient.getSharedAttributes();
    Future<Void> actualSleepTask = lwM2mClient.getSleepTask();
    LwM2MClientState actualState = lwM2mClient.getState();
    lwM2mClient.getSupportedClientObjects();
    lwM2mClient.getTenantId();
    boolean actualIsAsleepResult = lwM2mClient.isAsleep();

    // Assert that nothing has changed
    boolean actualIsEmptyResult = lwM2mClient.getKeyTsLatestMap().isEmpty();
    boolean actualIsEmptyResult2 = actualResources.isEmpty();
    int actualGetResult = actualRetryAttempts.get();
    int actualAndDecrement = actualRetryAttempts.getAndDecrement();
    int actualAndIncrement = actualRetryAttempts.getAndIncrement();
    assertTrue(actualSleepTask instanceof CompletableFuture);
    assertEquals("42", actualNodeId);
    assertEquals("LwM2mClient(endpoint=https://config.us-east-2.amazonaws.com)", actualToStringResult);
    assertEquals("https://config.us-east-2.amazonaws.com", actualEndpoint);
    assertEquals(-1, actualAndIncrement);
    assertEquals(0, actualGetResult);
    assertEquals(0, actualAndDecrement);
    assertEquals(0L, actualLastUplinkTime);
    assertEquals(LwM2MClientState.CREATED, actualState);
    assertTrue(actualIsEmptyResult);
    assertTrue(actualIsEmptyResult2);
    assertTrue(actualSharedAttributes.isEmpty());
    assertTrue(actualCheckFirstDownlinkResult);
    assertTrue(actualIsAsleepResult);
    assertSame(sleepTask, actualSleepTask);
    assertSame(lastSentRpcId, actualLastSentRpcId);
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   * <ul>
   *   <li>Then return toMaxDescendant ObjectId intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); then return toMaxDescendant ObjectId intValue is forty-two")
  void testGetLwM2mPathFromString_thenReturnToMaxDescendantObjectIdIntValueIsFortyTwo() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString = (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))
        .getLwM2mPathFromString("42");

    // Assert
    LwM2mPath toMaxDescendantResult = actualLwM2mPathFromString.toMaxDescendant();
    assertEquals(42, toMaxDescendantResult.getObjectId().intValue());
    LwM2mPath toParenPathResult = toMaxDescendantResult.toParenPath();
    assertEquals(42, toParenPathResult.getObjectId().intValue());
    LwM2mPath toParenPathResult2 = toParenPathResult.toParenPath();
    assertEquals(42, toParenPathResult2.getObjectId().intValue());
    assertEquals(42, actualLwM2mPathFromString.getObjectId().intValue());
    assertFalse(actualLwM2mPathFromString.isRoot());
    assertTrue(actualLwM2mPathFromString.isObject());
    LwM2mPath toMaxDescendantResult2 = toMaxDescendantResult.toMaxDescendant();
    assertEquals(toMaxDescendantResult2, toParenPathResult.toMaxDescendant());
    assertEquals(toMaxDescendantResult2, toParenPathResult2.toMaxDescendant());
    assertEquals(actualLwM2mPathFromString, toParenPathResult2.toParenPath());
    assertSame(toMaxDescendantResult2, toMaxDescendantResult2);
    LwM2mPath expectedToParenPathResult = actualLwM2mPathFromString.ROOTPATH;
    assertSame(expectedToParenPathResult, actualLwM2mPathFromString.toParenPath());
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   * <ul>
   *   <li>When {@code //}.</li>
   *   <li>Then return {@link LwM2mPath#ROOTPATH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '//'; then return ROOTPATH")
  void testGetLwM2mPathFromString_whenSlashSlash_thenReturnRootpath() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString = (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))
        .getLwM2mPathFromString("//");

    // Assert
    assertEquals(actualLwM2mPathFromString.ROOTPATH, actualLwM2mPathFromString);
  }

  /**
   * Test {@link LwM2mClient#getLwM2mPathFromString(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@link LwM2mPath#ROOTPATH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mClient#getLwM2mPathFromString(String)}
   */
  @Test
  @DisplayName("Test getLwM2mPathFromString(String); when '/'; then return ROOTPATH")
  void testGetLwM2mPathFromString_whenSlash_thenReturnRootpath() {
    // Arrange and Act
    LwM2mPath actualLwM2mPathFromString = (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))
        .getLwM2mPathFromString("/");

    // Assert
    assertEquals(actualLwM2mPathFromString.ROOTPATH, actualLwM2mPathFromString);
  }

  /**
   * Test {@link LwM2mClient#getDefaultObjectIDVer()}.
   * <p>
   * Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  @DisplayName("Test getDefaultObjectIDVer()")
  void testGetDefaultObjectIDVer() {
    // Arrange and Act
    LwM2m.Version actualDefaultObjectIDVer = (new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))
        .getDefaultObjectIDVer();

    // Assert
    assertEquals(actualDefaultObjectIDVer.V1_0, actualDefaultObjectIDVer);
  }

  /**
   * Test {@link LwM2mClient#getDefaultObjectIDVer()}.
   * <p>
   * Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  @DisplayName("Test getDefaultObjectIDVer()")
  void testGetDefaultObjectIDVer2() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    lwM2mClient.setDefaultObjectIDVer(LwM2m.Version.getDefault());

    // Act
    LwM2m.Version actualDefaultObjectIDVer = lwM2mClient.getDefaultObjectIDVer();

    // Assert
    assertSame(actualDefaultObjectIDVer.V1_0, actualDefaultObjectIDVer);
  }

  /**
   * Test {@link LwM2mClient#getDefaultObjectIDVer()}.
   * <p>
   * Method under test: {@link LwM2mClient#getDefaultObjectIDVer()}
   */
  @Test
  @DisplayName("Test getDefaultObjectIDVer()")
  void testGetDefaultObjectIDVer3() {
    // Arrange
    LwM2mClient lwM2mClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");
    lwM2mClient.setSleepTask(new FutureTask<>(mock(Callable.class)));

    // Act
    LwM2m.Version actualDefaultObjectIDVer = lwM2mClient.getDefaultObjectIDVer();

    // Assert
    assertEquals(actualDefaultObjectIDVer.V1_0, actualDefaultObjectIDVer);
  }

  /**
   * Test {@link LwM2mClient#getSupportedObjectVersion(Integer)}.
   * <p>
   * Method under test: {@link LwM2mClient#getSupportedObjectVersion(Integer)}
   */
  @Test
  @DisplayName("Test getSupportedObjectVersion(Integer)")
  void testGetSupportedObjectVersion() {
    // Arrange, Act and Assert
    assertNull((new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")).getSupportedObjectVersion(1));
  }
}
