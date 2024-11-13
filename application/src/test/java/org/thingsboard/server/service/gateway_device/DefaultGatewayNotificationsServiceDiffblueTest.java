package org.thingsboard.server.service.gateway_device;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.service.rpc.TbCoreDeviceRpcService;

@ContextConfiguration(classes = {DefaultGatewayNotificationsService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultGatewayNotificationsServiceDiffblueTest {
  @Autowired
  private DefaultGatewayNotificationsService defaultGatewayNotificationsService;

  @MockBean
  private TbCoreDeviceRpcService tbCoreDeviceRpcService;

  /**
   * Test
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}.
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}
   */
  @Test
  @DisplayName("Test onDeviceUpdated(Device, Device)")
  void testOnDeviceUpdated() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(device.getAdditionalInfo()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGatewayNotificationsService.onDeviceUpdated(device, new Device()));
    verify(arrayNode).has(eq("lastConnectedGateway"));
    verify(arrayNode).get(eq("lastConnectedGateway"));
    verify(device).getAdditionalInfo();
    verify(device).getId();
  }

  /**
   * Test
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}.
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}
   */
  @Test
  @DisplayName("Test onDeviceUpdated(Device, Device)")
  void testOnDeviceUpdated2() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(device.getAdditionalInfo()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGatewayNotificationsService.onDeviceUpdated(device, new Device()));
    verify(arrayNode).has(eq("lastConnectedGateway"));
    verify(arrayNode).get(eq("lastConnectedGateway"));
    verify(device).getAdditionalInfo();
    verify(device).getId();
  }

  /**
   * Test
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * Instance.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}
   */
  @Test
  @DisplayName("Test onDeviceUpdated(Device, Device); given ArrayNode get(String) return Instance; then throw RuntimeException")
  void testOnDeviceUpdated_givenArrayNodeGetReturnInstance_thenThrowRuntimeException() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(device.getAdditionalInfo()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGatewayNotificationsService.onDeviceUpdated(device, new Device()));
    verify(arrayNode).has(eq("lastConnectedGateway"));
    verify(arrayNode).get(eq("lastConnectedGateway"));
    verify(device).getAdditionalInfo();
    verify(device).getId();
  }

  /**
   * Test
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}
   */
  @Test
  @DisplayName("Test onDeviceUpdated(Device, Device); given ArrayNode get(String) return 'null'; then throw RuntimeException")
  void testOnDeviceUpdated_givenArrayNodeGetReturnNull_thenThrowRuntimeException() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(null);
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(device.getAdditionalInfo()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGatewayNotificationsService.onDeviceUpdated(device, new Device()));
    verify(arrayNode).has(eq("lastConnectedGateway"));
    verify(arrayNode).get(eq("lastConnectedGateway"));
    verify(device).getAdditionalInfo();
    verify(device).getId();
  }

  /**
   * Test
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}
   */
  @Test
  @DisplayName("Test onDeviceUpdated(Device, Device); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testOnDeviceUpdated_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    defaultGatewayNotificationsService.onDeviceUpdated(device, new Device());

    // Assert that nothing has changed
    verify(device).getAdditionalInfo();
  }

  /**
   * Test
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link Device} {@link Device#getAdditionalInfo()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceUpdated(Device, Device)}
   */
  @Test
  @DisplayName("Test onDeviceUpdated(Device, Device); given Instance; when Device getAdditionalInfo() return Instance")
  void testOnDeviceUpdated_givenInstance_whenDeviceGetAdditionalInfoReturnInstance() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getAdditionalInfo()).thenReturn(MissingNode.getInstance());

    // Act
    defaultGatewayNotificationsService.onDeviceUpdated(device, new Device());

    // Assert that nothing has changed
    verify(device).getAdditionalInfo();
  }

  /**
   * Test {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}.
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(Device)")
  void testOnDeviceDeleted() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(device.getAdditionalInfo()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGatewayNotificationsService.onDeviceDeleted(device));
    verify(arrayNode).has(eq("lastConnectedGateway"));
    verify(arrayNode).get(eq("lastConnectedGateway"));
    verify(device).getAdditionalInfo();
    verify(device).getId();
  }

  /**
   * Test {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}.
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(Device)")
  void testOnDeviceDeleted2() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(device.getAdditionalInfo()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGatewayNotificationsService.onDeviceDeleted(device));
    verify(arrayNode).has(eq("lastConnectedGateway"));
    verify(arrayNode).get(eq("lastConnectedGateway"));
    verify(device).getAdditionalInfo();
    verify(device).getId();
  }

  /**
   * Test {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * Instance.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(Device); given ArrayNode get(String) return Instance; then throw RuntimeException")
  void testOnDeviceDeleted_givenArrayNodeGetReturnInstance_thenThrowRuntimeException() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(device.getAdditionalInfo()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGatewayNotificationsService.onDeviceDeleted(device));
    verify(arrayNode).has(eq("lastConnectedGateway"));
    verify(arrayNode).get(eq("lastConnectedGateway"));
    verify(device).getAdditionalInfo();
    verify(device).getId();
  }

  /**
   * Test {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(Device); given ArrayNode get(String) return 'null'; then throw RuntimeException")
  void testOnDeviceDeleted_givenArrayNodeGetReturnNull_thenThrowRuntimeException() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(null);
    when(arrayNode.has(Mockito.<String>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("lastConnectedGateway"));
    when(device.getAdditionalInfo()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGatewayNotificationsService.onDeviceDeleted(device));
    verify(arrayNode).has(eq("lastConnectedGateway"));
    verify(arrayNode).get(eq("lastConnectedGateway"));
    verify(device).getAdditionalInfo();
    verify(device).getId();
  }

  /**
   * Test {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(Device); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testOnDeviceDeleted_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    defaultGatewayNotificationsService.onDeviceDeleted(device);

    // Assert that nothing has changed
    verify(device).getAdditionalInfo();
  }

  /**
   * Test {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link Device} {@link Device#getAdditionalInfo()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGatewayNotificationsService#onDeviceDeleted(Device)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(Device); given Instance; when Device getAdditionalInfo() return Instance")
  void testOnDeviceDeleted_givenInstance_whenDeviceGetAdditionalInfoReturnInstance() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getAdditionalInfo()).thenReturn(MissingNode.getInstance());

    // Act
    defaultGatewayNotificationsService.onDeviceDeleted(device);

    // Assert that nothing has changed
    verify(device).getAdditionalInfo();
  }
}
