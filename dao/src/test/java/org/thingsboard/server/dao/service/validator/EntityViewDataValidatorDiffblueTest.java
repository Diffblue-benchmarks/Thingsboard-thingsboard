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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
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
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {EntityViewDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityViewDataValidatorDiffblueTest {
  @MockBean private CustomerDao customerDao;

  @MockBean private EntityViewDao entityViewDao;

  @Autowired private EntityViewDataValidator entityViewDataValidator;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateCreate(TenantId, EntityView)"})
  public void testValidateCreateWithTenantIdEntityView() {
    // Arrange
    Optional<EntityView> ofResult = Optional.of(new EntityView());
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(ofResult);

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateCreate(TenantId, EntityView)"})
  public void testValidateCreateWithTenantIdEntityView2() {
    // Arrange
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewDataValidator.validateUpdate(TenantId, EntityView)"})
  public void testValidateUpdateWithTenantIdEntityView() {
    // Arrange
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewDataValidator.validateUpdate(TenantId, EntityView)"})
  public void testValidateUpdateWithTenantIdEntityView2() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenThrow(new DataValidationException("An error occurred"));
    Optional<EntityView> ofResult = Optional.of(entityView);
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(ofResult);

    EntityView entityView2 = new EntityView();
    entityView2.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, entityView2));
    verify(entityView).getUuidId();
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <ul>
   *   <li>Given {@link EntityView} {@link EntityView#getUuidId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewDataValidator.validateUpdate(TenantId, EntityView)"})
  public void testValidateUpdateWithTenantIdEntityView_givenEntityViewGetUuidIdReturnNull_uuid() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenReturn(ModelConstants.NULL_UUID);
    Optional<EntityView> ofResult = Optional.of(entityView);
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(ofResult);

    EntityView entityView2 = new EntityView();
    entityView2.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, entityView2));
    verify(entityView).getUuidId();
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewDataValidator.validateUpdate(TenantId, EntityView)"})
  public void testValidateUpdateWithTenantIdEntityView_thenReturnNull() {
    // Arrange
    Optional<EntityView> emptyResult = Optional.empty();
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(emptyResult);

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityView actualValidateUpdateResult =
        entityViewDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, entityView);

    // Assert
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
    assertNull(actualValidateUpdateResult);
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateDataImpl(TenantId, EntityView)"})
  public void testValidateDataImplWithTenantIdEntityView() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);
    entityView.setType("Entity view name");
    entityView.setName("Entity view name");

    // Act
    entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
    CustomerId customerId = entityView.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateDataImpl(TenantId, EntityView)"})
  public void testValidateDataImplWithTenantIdEntityView2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);
    entityView.setType("Entity view name");
    entityView.setName("Entity view name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateDataImpl(TenantId, EntityView)"})
  public void testValidateDataImplWithTenantIdEntityView3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);
    entityView.setType("Entity view name");
    entityView.setName("Entity view name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateDataImpl(TenantId, EntityView)"})
  public void testValidateDataImplWithTenantIdEntityView_givenNull_customer_id() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    EntityView entityView = new EntityView();
    entityView.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);
    entityView.setType("Entity view name");
    entityView.setName("Entity view name");

    // Act
    entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView);

    // Assert that nothing has changed
    verify(tenantService).tenantExists(isA(TenantId.class));
    CustomerId customerId = entityView.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateDataImpl(TenantId, EntityView)"})
  public void testValidateDataImplWithTenantIdEntityView_givenTenantService() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setName("Entity view name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateDataImpl(TenantId, EntityView)"})
  public void testValidateDataImplWithTenantIdEntityView_givenTenantService2() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setType("Entity view name");
    entityView.setName("Entity view name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   *   <li>When {@link EntityView#EntityView()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateDataImpl(TenantId, EntityView)"})
  public void testValidateDataImplWithTenantIdEntityView_givenTenantService_whenEntityView() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            entityViewDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new EntityView()));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)} with {@code
   * TenantId}, {@code EntityView}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewDataValidator.validateDataImpl(TenantId, EntityView)"})
  public void testValidateDataImplWithTenantIdEntityView_thenCallsGetId() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenThrow(new DataValidationException("An error occurred"));

    EntityView entityView = new EntityView();
    entityView.setCustomerId(customerId);
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);
    entityView.setType("Entity view name");
    entityView.setName("Entity view name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
    verify(customerId).getId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
