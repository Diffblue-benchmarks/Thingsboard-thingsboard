package org.thingsboard.server.service.edge.rpc.constructor.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.BaseDataWithAdditionalInfo;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.EdgeConfiguration;

class EdgeMsgConstructorDiffblueTest {
  /**
   * Test {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then calls {@link BaseDataWithAdditionalInfo#getAdditionalInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}
   */
  @Test
  @DisplayName("Test constructEdgeConfiguration(Edge); given Instance; then calls getAdditionalInfo()")
  void testConstructEdgeConfiguration_givenInstance_thenCallsGetAdditionalInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeMsgConstructor edgeMsgConstructor = new EdgeMsgConstructor();
    Edge edge = mock(Edge.class);
    when(edge.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(edge.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getRoutingKey()).thenReturn("Routing Key");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");
    when(edge.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(edge.getId()).thenReturn(new EdgeId(UUID.randomUUID()));

    // Act
    edgeMsgConstructor.constructEdgeConfiguration(edge);

    // Assert
    verify(edge).getAdditionalInfo();
    verify(edge, atLeast(1)).getCustomerId();
    verify(edge, atLeast(1)).getId();
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge, atLeast(1)).getTenantId();
    verify(edge).getType();
  }

  /**
   * Test {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}.
   * <ul>
   *   <li>Then return CustomerIdLSB is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeMsgConstructor#constructEdgeConfiguration(Edge)}
   */
  @Test
  @DisplayName("Test constructEdgeConfiguration(Edge); then return CustomerIdLSB is zero")
  void testConstructEdgeConfiguration_thenReturnCustomerIdLSBIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeMsgConstructor edgeMsgConstructor = new EdgeMsgConstructor();
    Edge edge = mock(Edge.class);
    when(edge.getCustomerId()).thenReturn(null);
    when(edge.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getRoutingKey()).thenReturn("Routing Key");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");
    when(edge.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(edge.getId()).thenReturn(new EdgeId(UUID.randomUUID()));

    // Act
    EdgeConfiguration actualConstructEdgeConfigurationResult = edgeMsgConstructor.constructEdgeConfiguration(edge);

    // Assert
    verify(edge).getAdditionalInfo();
    verify(edge).getCustomerId();
    verify(edge, atLeast(1)).getId();
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge, atLeast(1)).getTenantId();
    verify(edge).getType();
    assertEquals(0L, actualConstructEdgeConfigurationResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructEdgeConfigurationResult.getCustomerIdMSB());
    assertEquals(10, actualConstructEdgeConfigurationResult.getAllFields().size());
  }
}
