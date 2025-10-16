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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.widget.WidgetTypeDao;
import org.thingsboard.server.dao.widget.WidgetsBundleDao;

@ContextConfiguration(classes = {WidgetTypeDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class WidgetTypeDataValidatorDiffblueTest {
  @MockBean private TenantService tenantService;

  @MockBean private WidgetTypeDao widgetTypeDao;

  @Autowired private WidgetTypeDataValidator widgetTypeDataValidator;

  @MockBean private WidgetsBundleDao widgetsBundleDao;

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor())
        .thenThrow(new DataValidationException("An error occurred"));
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails).getDescriptor();
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails2() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getTenantId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails).getTenantId();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails3() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    when(widgetTypeDetails.getDescriptor()).thenReturn(new ArrayNode(nf));
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails4() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getTenantId()).thenReturn(tenantId);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act
    widgetTypeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetTypeDetails);

    // Assert
    verify(tenantId).getId();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails5() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getTenantId()).thenReturn(tenantId);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(tenantId).getId();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails_givenSystem_tenant() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act
    widgetTypeDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetTypeDetails);

    // Assert
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@code Widgets type name}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails_givenWidgetsTypeName() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setName("Widgets type name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayNode#size()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails_thenCallsSize() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.size()).thenThrow(new DataValidationException("An error occurred"));

    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(arrayNode);
    when(widgetTypeDetails.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(arrayNode).size();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getDescriptor();
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateDataImpl(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <ul>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateDataImpl(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateDataImpl(TenantId, WidgetTypeDetails)"})
  public void testValidateDataImplWithTenantIdWidgetTypeDetails_whenWidgetTypeDetails() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new WidgetTypeDetails()));
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateCreate(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateCreate(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateCreate(TenantId, WidgetTypeDetails)"})
  public void testValidateCreateWithTenantIdWidgetTypeDetails() {
    // Arrange
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails.setName(" ");

    // Act
    widgetTypeDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetTypeDetails);

    // Assert
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("_"));
    assertEquals("_", widgetTypeDetails.getFqn());
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateCreate(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateCreate(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateCreate(TenantId, WidgetTypeDetails)"})
  public void testValidateCreateWithTenantIdWidgetTypeDetails2() {
    // Arrange
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setFqn(" ");
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails.setName(" ");

    // Act
    widgetTypeDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetTypeDetails);

    // Assert
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("_"));
    assertEquals("_", widgetTypeDetails.getFqn());
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateCreate(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateCreate(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateCreate(TenantId, WidgetTypeDetails)"})
  public void testValidateCreateWithTenantIdWidgetTypeDetails3() {
    // Arrange
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails.setName("_");

    // Act
    widgetTypeDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetTypeDetails);

    // Assert
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("_"));
    assertEquals("_", widgetTypeDetails.getFqn());
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateCreate(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateCreate(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateCreate(TenantId, WidgetTypeDetails)"})
  public void testValidateCreateWithTenantIdWidgetTypeDetails_thenThrowDataValidationException() {
    // Arrange
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails.setName(" ");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateCreate(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("_"));
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateCreate(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <ul>
   *   <li>Then {@link WidgetTypeDetails#WidgetTypeDetails()} Fqn is {@code _w_}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateCreate(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeDataValidator.validateCreate(TenantId, WidgetTypeDetails)"})
  public void testValidateCreateWithTenantIdWidgetTypeDetails_thenWidgetTypeDetailsFqnIsW() {
    // Arrange
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails.setName("\\W+");

    // Act
    widgetTypeDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetTypeDetails);

    // Assert
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("_w_"));
    assertEquals("_w_", widgetTypeDetails.getFqn());
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateUpdate(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateUpdate(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails WidgetTypeDataValidator.validateUpdate(TenantId, WidgetTypeDetails)"
  })
  public void testValidateUpdateWithTenantIdWidgetTypeDetails() {
    // Arrange
    when(widgetTypeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setId(new WidgetTypeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails));
    verify(widgetTypeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateUpdate(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateUpdate(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails WidgetTypeDataValidator.validateUpdate(TenantId, WidgetTypeDetails)"
  })
  public void testValidateUpdateWithTenantIdWidgetTypeDetails2() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTenantId(new TenantId(UUID.randomUUID()));
    when(widgetTypeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetails);

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails2.setId(new WidgetTypeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails2));
    verify(widgetTypeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetTypeDataValidator#validateUpdate(TenantId, WidgetTypeDetails)} with {@code
   * TenantId}, {@code WidgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetails#WidgetTypeDetails()} Fqn is {@code Fqn}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDataValidator#validateUpdate(TenantId,
   * WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails WidgetTypeDataValidator.validateUpdate(TenantId, WidgetTypeDetails)"
  })
  public void testValidateUpdateWithTenantIdWidgetTypeDetails_givenWidgetTypeDetailsFqnIsFqn() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setFqn("Fqn");
    widgetTypeDetails.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(widgetTypeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetails);

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetTypeDetails2.setId(new WidgetTypeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetTypeDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, widgetTypeDetails2));
    verify(widgetTypeDao).findById(isA(TenantId.class), isA(UUID.class));
  }
}
