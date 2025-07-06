package org.thingsboard.monitoring.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.leshan.client.californium.LeshanClient;
import org.eclipse.leshan.client.resource.ResourceChangedListener;
import org.eclipse.leshan.client.servers.ServerIdentity;
import org.eclipse.leshan.core.ResponseCode;
import org.eclipse.leshan.core.model.ObjectModel;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.node.LwM2mNode;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.request.Identity;
import org.eclipse.leshan.core.response.ReadResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Lwm2mClientDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Lwm2mClient#Lwm2mClient()}
   *   <li>{@link Lwm2mClient#getLeshanClient()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Lwm2mClient.<init>()",
    "void Lwm2mClient.<init>(String, String)",
    "LeshanClient Lwm2mClient.getLeshanClient()",
    "void Lwm2mClient.setLeshanClient(LeshanClient)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Lwm2mClient actualLwm2mClient = new Lwm2mClient();
    LeshanClient actualLeshanClient = actualLwm2mClient.getLeshanClient();

    // Assert
    assertNull(actualLwm2mClient.getId());
    assertNull(actualLwm2mClient.getLwM2mClient());
    assertNull(actualLeshanClient);
    assertNull(actualLwm2mClient.getModel());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Server Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Lwm2mClient#Lwm2mClient(String, String)}
   *   <li>{@link Lwm2mClient#getLeshanClient()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Server Uri'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Lwm2mClient.<init>()",
    "void Lwm2mClient.<init>(String, String)",
    "LeshanClient Lwm2mClient.getLeshanClient()",
    "void Lwm2mClient.setLeshanClient(LeshanClient)"
  })
  void testGettersAndSetters_whenServerUri() {
    // Arrange and Act
    Lwm2mClient actualLwm2mClient =
        new Lwm2mClient("Server Uri", "https://config.us-east-2.amazonaws.com");
    LeshanClient actualLeshanClient = actualLwm2mClient.getLeshanClient();

    // Assert
    assertNull(actualLwm2mClient.getId());
    assertNull(actualLwm2mClient.getLwM2mClient());
    assertNull(actualLeshanClient);
    assertNull(actualLwm2mClient.getModel());
  }

  /**
   * Test {@link Lwm2mClient#getAvailableResourceIds(ObjectModel)}.
   *
   * <p>Method under test: {@link Lwm2mClient#getAvailableResourceIds(ObjectModel)}
   */
  @Test
  @DisplayName("Test getAvailableResourceIds(ObjectModel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Lwm2mClient.getAvailableResourceIds(ObjectModel)"})
  void testGetAvailableResourceIds() {
    // Arrange
    Lwm2mClient lwm2mClient =
        new Lwm2mClient("Server Uri", "https://config.us-east-2.amazonaws.com");

    // Act
    List<Integer> actualAvailableResourceIds =
        lwm2mClient.getAvailableResourceIds(
            new ObjectModel(
                1,
                "Name",
                "The characteristics of someone or something",
                "1.0.2",
                true,
                true,
                new ArrayList<>()));

    // Assert
    assertEquals(1, actualAvailableResourceIds.size());
    assertEquals(0, actualAvailableResourceIds.get(0).intValue());
  }

  /**
   * Test {@link Lwm2mClient#read(ServerIdentity, int)} with {@code identity}, {@code resourceId}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Code Name is {@code NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mClient#read(ServerIdentity, int)}
   */
  @Test
  @DisplayName(
      "Test read(ServerIdentity, int) with 'identity', 'resourceId'; when one; then return Code Name is 'NOT_FOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReadResponse Lwm2mClient.read(ServerIdentity, int)"})
  void testReadWithIdentityResourceId_whenOne_thenReturnCodeNameIsNotFound() {
    // Arrange
    Lwm2mClient lwm2mClient =
        new Lwm2mClient("Server Uri", "https://config.us-east-2.amazonaws.com");

    // Act
    ReadResponse actualReadResult =
        lwm2mClient.read(new ServerIdentity(mock(Identity.class), 1L), 1);

    // Assert
    ResponseCode code = actualReadResult.getCode();
    assertEquals("NOT_FOUND", code.getName());
    assertNull(actualReadResult.getContent());
    assertEquals(404, code.getCode());
    assertFalse(code.isSuccess());
    assertFalse(actualReadResult.isSuccess());
    assertTrue(code.isClientError());
    assertTrue(code.isError());
    assertTrue(actualReadResult.isFailure());
  }

  /**
   * Test {@link Lwm2mClient#read(ServerIdentity, int)} with {@code identity}, {@code resourceId}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then Content return {@link LwM2mSingleResource}.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mClient#read(ServerIdentity, int)}
   */
  @Test
  @DisplayName(
      "Test read(ServerIdentity, int) with 'identity', 'resourceId'; when zero; then Content return LwM2mSingleResource")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReadResponse Lwm2mClient.read(ServerIdentity, int)"})
  void testReadWithIdentityResourceId_whenZero_thenContentReturnLwM2mSingleResource() {
    // Arrange
    Lwm2mClient lwm2mClient =
        new Lwm2mClient("Server Uri", "https://config.us-east-2.amazonaws.com");

    // Act
    ReadResponse actualReadResult =
        lwm2mClient.read(new ServerIdentity(mock(Identity.class), 1L), 0);

    // Assert
    LwM2mNode content = actualReadResult.getContent();
    assertTrue(content instanceof LwM2mSingleResource);
    assertEquals("", ((LwM2mSingleResource) content).getValue());
    ResponseCode code = actualReadResult.getCode();
    assertEquals("CONTENT", code.getName());
    assertEquals(0, content.getId());
    assertEquals(205, code.getCode());
    assertEquals(Type.STRING, ((LwM2mSingleResource) content).getType());
    assertFalse(code.isClientError());
    assertFalse(code.isError());
    assertFalse(((LwM2mSingleResource) content).isMultiInstances());
    assertFalse(actualReadResult.isFailure());
    assertTrue(code.isSuccess());
    assertTrue(actualReadResult.isSuccess());
  }

  /**
   * Test {@link Lwm2mClient#send(String, int)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceChangedListener#resourcesChanged(int[])}.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mClient#send(String, int)}
   */
  @Test
  @DisplayName("Test send(String, int); then calls resourcesChanged(int[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Lwm2mClient.send(String, int)"})
  void testSend_thenCallsResourcesChanged() {
    // Arrange
    ResourceChangedListener listener = mock(ResourceChangedListener.class);
    doNothing().when(listener).resourcesChanged(isA(int[].class));

    Lwm2mClient lwm2mClient =
        new Lwm2mClient("Server Uri", "https://config.us-east-2.amazonaws.com");
    lwm2mClient.addResourceChangedListener(listener);

    // Act
    lwm2mClient.send("Data", 1);

    // Assert
    verify(listener).resourcesChanged(isA(int[].class));
  }

  /**
   * Test {@link Lwm2mClient#destroy()}.
   *
   * <ul>
   *   <li>Given {@link LeshanClient} {@link LeshanClient#destroy(boolean)} does nothing.
   *   <li>Then calls {@link LeshanClient#destroy(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mClient#destroy()}
   */
  @Test
  @DisplayName(
      "Test destroy(); given LeshanClient destroy(boolean) does nothing; then calls destroy(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Lwm2mClient.destroy()"})
  void testDestroy_givenLeshanClientDestroyDoesNothing_thenCallsDestroy() {
    // Arrange
    LeshanClient leshanClient = mock(LeshanClient.class);
    doNothing().when(leshanClient).destroy(anyBoolean());

    Lwm2mClient lwm2mClient =
        new Lwm2mClient("Server Uri", "https://config.us-east-2.amazonaws.com");
    lwm2mClient.setLeshanClient(leshanClient);

    // Act
    lwm2mClient.destroy();

    // Assert
    verify(leshanClient).destroy(eq(true));
  }
}
