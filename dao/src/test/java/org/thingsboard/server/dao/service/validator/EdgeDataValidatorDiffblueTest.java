/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.edge.EdgeDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {EdgeDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class EdgeDataValidatorDiffblueTest {
  @MockBean private CustomerDao customerDao;

  @MockBean private EdgeDao edgeDao;

  @Autowired private EdgeDataValidator edgeDataValidator;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link EdgeDataValidator#validateUpdate(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findById(TenantId, UUID)} return {@link
   *       Edge#Edge()}.
   *   <li>Then return {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDataValidator#validateUpdate(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeDataValidator.validateUpdate(TenantId, Edge)"})
  public void testValidateUpdateWithTenantIdEdge_givenEdgeDaoFindByIdReturnEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    Edge edge2 = new Edge();
    edge2.setId(new EdgeId(ModelConstants.NULL_UUID));

    // Act
    Edge actualValidateUpdateResult =
        edgeDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, edge2);

    // Assert
    verify(edgeDao).findById(isNull(), isA(UUID.class));
    assertSame(edge, actualValidateUpdateResult);
  }

  /**
   * Test {@link EdgeDataValidator#validateUpdate(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDataValidator#validateUpdate(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeDataValidator.validateUpdate(TenantId, Edge)"})
  public void testValidateUpdateWithTenantIdEdge_thenThrowDataValidationException() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Edge edge = new Edge();
    edge.setId(new EdgeId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, edge));
    verify(edgeDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <p>Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeDataValidator.validateDataImpl(TenantId, Edge)"})
  public void testValidateDataImplWithTenantIdEdge() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Edge edge = new Edge();
    edge.setTenantId(ModelConstants.SYSTEM_TENANT);
    edge.setRoutingKey("Edge name");
    edge.setSecret("Edge name");
    edge.setType("Edge name");
    edge.setName("Edge name");

    // Act
    edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
    CustomerId customerId = edge.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <p>Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeDataValidator.validateDataImpl(TenantId, Edge)"})
  public void testValidateDataImplWithTenantIdEdge2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Edge edge = new Edge();
    edge.setTenantId(ModelConstants.SYSTEM_TENANT);
    edge.setRoutingKey("Edge name");
    edge.setSecret("Edge name");
    edge.setType("Edge name");
    edge.setName("Edge name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <ul>
   *   <li>Given {@code Edge name}.
   *   <li>When {@link Edge#Edge()} Name is {@code Edge name}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeDataValidator.validateDataImpl(TenantId, Edge)"})
  public void testValidateDataImplWithTenantIdEdge_givenEdgeName_whenEdgeNameIsEdgeName() {
    // Arrange
    Edge edge = new Edge();
    edge.setName("Edge name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <ul>
   *   <li>Given {@code Edge name}.
   *   <li>When {@link Edge#Edge()} RoutingKey is {@code Edge name}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeDataValidator.validateDataImpl(TenantId, Edge)"})
  public void testValidateDataImplWithTenantIdEdge_givenEdgeName_whenEdgeRoutingKeyIsEdgeName() {
    // Arrange
    Edge edge = new Edge();
    edge.setRoutingKey("Edge name");
    edge.setSecret("Edge name");
    edge.setType("Edge name");
    edge.setName("Edge name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <ul>
   *   <li>Given {@code Edge name}.
   *   <li>When {@link Edge#Edge()} Secret is {@code Edge name}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeDataValidator.validateDataImpl(TenantId, Edge)"})
  public void testValidateDataImplWithTenantIdEdge_givenEdgeName_whenEdgeSecretIsEdgeName() {
    // Arrange
    Edge edge = new Edge();
    edge.setSecret("Edge name");
    edge.setType("Edge name");
    edge.setName("Edge name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <ul>
   *   <li>Given {@code Edge name}.
   *   <li>When {@link Edge#Edge()} Type is {@code Edge name}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeDataValidator.validateDataImpl(TenantId, Edge)"})
  public void testValidateDataImplWithTenantIdEdge_givenEdgeName_whenEdgeTypeIsEdgeName() {
    // Arrange
    Edge edge = new Edge();
    edge.setType("Edge name");
    edge.setName("Edge name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link Edge#Edge()} Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeDataValidator.validateDataImpl(TenantId, Edge)"})
  public void testValidateDataImplWithTenantIdEdge_givenEmptyString_whenEdgeNameIsEmptyString() {
    // Arrange
    Edge edge = new Edge();
    edge.setName("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edge));
  }

  /**
   * Test {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)} with {@code TenantId}, {@code
   * Edge}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge()}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDataValidator#validateDataImpl(TenantId, Edge)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeDataValidator.validateDataImpl(TenantId, Edge)"})
  public void testValidateDataImplWithTenantIdEdge_whenEdge_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Edge()));
  }
}
