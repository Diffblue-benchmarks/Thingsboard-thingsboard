package org.thingsboard.server.service.edge.rpc.constructor.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.EdgeConfiguration;

class EdgeMsgConstructorDiffblueTest {
  /**
   * Test {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}.
   *
   * <ul>
   *   <li>Then return CustomerIdLSB is {@code -7476899250389416711}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}
   */
  @Test
  @DisplayName(
      "Test constructEdgeConfiguration(Edge); then return CustomerIdLSB is '-7476899250389416711'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeConfiguration EdgeMsgConstructor.constructEdgeConfiguration(Edge)"})
  void testConstructEdgeConfiguration_thenReturnCustomerIdLSBIs7476899250389416711() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeMsgConstructor edgeMsgConstructor = new EdgeMsgConstructor();

    Edge edge = new Edge(new Edge());
    edge.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    edge.setSecret("");
    edge.setRoutingKey("Routing Key");
    edge.setType("");
    edge.setName("Name");
    edge.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    edge.setId(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    EdgeConfiguration actualConstructEdgeConfigurationResult =
        edgeMsgConstructor.constructEdgeConfiguration(edge);

    // Assert
    assertEquals(-7476899250389416711L, actualConstructEdgeConfigurationResult.getCustomerIdLSB());
    assertEquals(10, actualConstructEdgeConfigurationResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructEdgeConfigurationResult.getCustomerIdMSB());
    assertEquals(92, actualConstructEdgeConfigurationResult.getSerializedSize());
  }

  /**
   * Test {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}.
   *
   * <ul>
   *   <li>Then return CustomerIdLSB is zero.
   * </ul>
   *
   * <p>Method under test: {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}
   */
  @Test
  @DisplayName("Test constructEdgeConfiguration(Edge); then return CustomerIdLSB is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeConfiguration EdgeMsgConstructor.constructEdgeConfiguration(Edge)"})
  void testConstructEdgeConfiguration_thenReturnCustomerIdLSBIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeMsgConstructor edgeMsgConstructor = new EdgeMsgConstructor();

    Edge edge = new Edge(new Edge());
    edge.setSecret("");
    edge.setRoutingKey("Routing Key");
    edge.setType("");
    edge.setName("Name");
    edge.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    edge.setId(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    EdgeConfiguration actualConstructEdgeConfigurationResult =
        edgeMsgConstructor.constructEdgeConfiguration(edge);

    // Assert
    assertEquals(0L, actualConstructEdgeConfigurationResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructEdgeConfigurationResult.getCustomerIdMSB());
    assertEquals(71, actualConstructEdgeConfigurationResult.getSerializedSize());
    assertEquals(8, actualConstructEdgeConfigurationResult.getAllFields().size());
    UnknownFieldSet unknownFields = actualConstructEdgeConfigurationResult.getUnknownFields();
    EdgeConfiguration defaultInstanceForType =
        actualConstructEdgeConfigurationResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(Edge)} with edge is {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}
   */
  @Test
  @DisplayName("Test constructEdgeConfiguration(Edge); when Edge(Edge) with edge is Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeConfiguration EdgeMsgConstructor.constructEdgeConfiguration(Edge)"})
  void testConstructEdgeConfiguration_whenEdgeWithEdgeIsEdge() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EdgeMsgConstructor edgeMsgConstructor = new EdgeMsgConstructor();

    Edge edge = new Edge(new Edge(new Edge()));
    edge.setSecret("");
    edge.setRoutingKey("Routing Key");
    edge.setType("");
    edge.setName("Name");
    edge.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    edge.setId(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    EdgeConfiguration actualConstructEdgeConfigurationResult =
        edgeMsgConstructor.constructEdgeConfiguration(edge);

    // Assert
    UnknownFieldSet unknownFields = actualConstructEdgeConfigurationResult.getUnknownFields();
    EdgeConfiguration defaultInstanceForType =
        actualConstructEdgeConfigurationResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
