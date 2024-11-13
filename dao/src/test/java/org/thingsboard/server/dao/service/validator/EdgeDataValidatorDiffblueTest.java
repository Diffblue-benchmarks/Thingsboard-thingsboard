package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.edge.EdgeDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {EdgeDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class EdgeDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private CustomerDao customerDao;

  @MockBean
  private EdgeDao edgeDao;

  @Autowired
  private EdgeDataValidator edgeDataValidator;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link EdgeDataValidator#validateUpdate(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Given {@link EdgeDao} {@link Dao#findById(TenantId, UUID)} return
   * {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateUpdate(TenantId, Edge)}
   */
  @Test
  public void testValidateUpdateWithTenantIdEdge_givenEdgeDaoFindByIdReturnEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    Edge edge2 = mock(Edge.class);
    when(edge2.getId()).thenReturn(new EdgeId(ModelConstants.NULL_UUID));
    when(edge2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    Edge actualValidateUpdateResult = edgeDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, edge2);

    // Assert
    verify(edge2).getId();
    verify(edge2).getTenantId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(edge, actualValidateUpdateResult);
  }

  /**
   * Test {@link EdgeDataValidator#validateUpdate(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateUpdate(TenantId, Edge)}
   */
  @Test
  public void testValidateUpdateWithTenantIdEdge_thenThrowDataValidationException() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(new EdgeId(ModelConstants.NULL_UUID));
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, edge));
    verify(edge).getId();
    verify(edge).getTenantId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <p>
   * Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdge() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Edge edge = mock(Edge.class);
    when(edge.getCustomerId()).thenThrow(new DataValidationException("An error occurred"));
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edge.getRoutingKey()).thenReturn("Routing Key");
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
    verify(edge).getCustomerId();
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge, atLeast(1)).getTenantId();
    verify(edge).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdge_givenEmptyString() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getRoutingKey()).thenReturn("");
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge).getType();
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdge_givenNull_customer_id() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Edge edge = mock(Edge.class);
    when(edge.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edge.getRoutingKey()).thenReturn("Routing Key");
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");

    // Act
    edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge);

    // Assert that nothing has changed
    verify(edge, atLeast(1)).getCustomerId();
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge, atLeast(1)).getTenantId();
    verify(edge).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Edge} {@link Edge#getRoutingKey()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdge_givenNull_whenEdgeGetRoutingKeyReturnNull() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getRoutingKey()).thenReturn(null);
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge).getType();
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Edge} {@link Edge#getSecret()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdge_givenNull_whenEdgeGetSecretReturnNull() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getSecret()).thenReturn(null);
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
    verify(edge).getName();
    verify(edge).getSecret();
    verify(edge).getType();
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Edge} {@link Edge#getTenantId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdge_givenNull_whenEdgeGetTenantIdReturnNull() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(null);
    when(edge.getRoutingKey()).thenReturn("Routing Key");
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge).getTenantId();
    verify(edge).getType();
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdge_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edge.getRoutingKey()).thenReturn("Routing Key");
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge, atLeast(1)).getTenantId();
    verify(edge).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with
   * {@code TenantId}, {@code Edge}.
   * <ul>
   *   <li>Then calls {@link Edge#setCustomerId(CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdge_thenCallsSetCustomerId() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Edge edge = mock(Edge.class);
    when(edge.getCustomerId()).thenReturn(null);
    doNothing().when(edge).setCustomerId(Mockito.<CustomerId>any());
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edge.getRoutingKey()).thenReturn("Routing Key");
    when(edge.getSecret()).thenReturn("Secret");
    when(edge.getType()).thenReturn("Type");
    when(edge.getName()).thenReturn("Name");

    // Act
    edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge);

    // Assert
    verify(edge).getCustomerId();
    verify(edge).getName();
    verify(edge).getRoutingKey();
    verify(edge).getSecret();
    verify(edge, atLeast(1)).getTenantId();
    verify(edge).getType();
    verify(edge).setCustomerId(isA(CustomerId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
