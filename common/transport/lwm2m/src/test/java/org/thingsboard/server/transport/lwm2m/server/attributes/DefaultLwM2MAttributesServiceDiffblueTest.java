package org.thingsboard.server.transport.lwm2m.server.attributes;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;

@ExtendWith(MockitoExtension.class)
class DefaultLwM2MAttributesServiceDiffblueTest {
  @InjectMocks private DefaultLwM2MAttributesService defaultLwM2MAttributesService;

  @Mock private LwM2mClientContext lwM2mClientContext;

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)} with
   * {@code lwM2MClient}, {@code tsKvProtos}, {@code logFailedUpdateOfNonChangedValue}.
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient,
   * List, boolean)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(LwM2mClient, List, boolean) with 'lwM2MClient', 'tsKvProtos', 'logFailedUpdateOfNonChangedValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(LwM2mClient, List, boolean)"
  })
  void testOnAttributesUpdateWithLwM2MClientTsKvProtosLogFailedUpdateOfNonChangedValue() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient lwM2MClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, new ArrayList<>(), true);

    // Assert
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)} with
   * {@code lwM2MClient}, {@code tsKvProtos}, {@code logFailedUpdateOfNonChangedValue}.
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient,
   * List, boolean)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(LwM2mClient, List, boolean) with 'lwM2MClient', 'tsKvProtos', 'logFailedUpdateOfNonChangedValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(LwM2mClient, List, boolean)"
  })
  void testOnAttributesUpdateWithLwM2MClientTsKvProtosLogFailedUpdateOfNonChangedValue2() {
    // Arrange
    doThrow(new IllegalArgumentException("[{}] onAttributesUpdate [{}]"))
        .when(lwM2mClientContext)
        .update(Mockito.<LwM2mClient>any());
    LwM2mClient lwM2MClient = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, new ArrayList<>(), true));
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }

  /**
   * Test {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient, List, boolean)} with
   * {@code lwM2MClient}, {@code tsKvProtos}, {@code logFailedUpdateOfNonChangedValue}.
   *
   * <p>Method under test: {@link DefaultLwM2MAttributesService#onAttributesUpdate(LwM2mClient,
   * List, boolean)}
   */
  @Test
  @DisplayName(
      "Test onAttributesUpdate(LwM2mClient, List, boolean) with 'lwM2MClient', 'tsKvProtos', 'logFailedUpdateOfNonChangedValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultLwM2MAttributesService.onAttributesUpdate(LwM2mClient, List, boolean)"
  })
  void testOnAttributesUpdateWithLwM2MClientTsKvProtosLogFailedUpdateOfNonChangedValue3() {
    // Arrange
    doNothing().when(lwM2mClientContext).update(Mockito.<LwM2mClient>any());
    LwM2mClient lwM2MClient = mock(LwM2mClient.class);
    when(lwM2MClient.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act
    defaultLwM2MAttributesService.onAttributesUpdate(lwM2MClient, new ArrayList<>(), true);

    // Assert
    verify(lwM2MClient).getEndpoint();
    verify(lwM2mClientContext).update(isA(LwM2mClient.class));
  }
}
