package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.lwm2m.ObjectAttributes;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder;

class TbLwM2MWriteAttributesRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2MWriteAttributesRequest#getAttributes()}
   *   <li>{@link TbLwM2MWriteAttributesRequest#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");
    TbLwM2MWriteAttributesRequest buildResult = TbLwM2MWriteAttributesRequest.builder()
        .attributes(attributes)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Act
    ObjectAttributes actualAttributes = buildResult.getAttributes();

    // Assert
    assertEquals(LwM2MOperationType.WRITE_ATTRIBUTES, buildResult.getType());
    assertSame(attributes, actualAttributes);
  }

  /**
   * Test TbLwM2MWriteAttributesRequestBuilder
   * {@link TbLwM2MWriteAttributesRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder#build()}
   *   <li>
   * {@link TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder#attributes(ObjectAttributes)}
   *   <li>
   * {@link TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder#timeout(long)}
   *   <li>
   * {@link TbLwM2MWriteAttributesRequest.TbLwM2MWriteAttributesRequestBuilder#versionedId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbLwM2MWriteAttributesRequestBuilder build()")
  void testTbLwM2MWriteAttributesRequestBuilderBuild() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");

    // Act
    TbLwM2MWriteAttributesRequest actualBuildResult = TbLwM2MWriteAttributesRequest.builder()
        .attributes(attributes)
        .timeout(10L)
        .versionedId("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getVersionedId());
    assertEquals("42", actualBuildResult.getObjectId());
    assertEquals(10L, actualBuildResult.getTimeout());
    assertEquals(LwM2MOperationType.WRITE_ATTRIBUTES, actualBuildResult.getType());
    assertSame(attributes, actualBuildResult.getAttributes());
  }
}
