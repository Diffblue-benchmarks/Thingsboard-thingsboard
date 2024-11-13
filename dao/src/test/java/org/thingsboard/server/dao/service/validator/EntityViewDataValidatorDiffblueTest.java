package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {EntityViewDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class EntityViewDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private CustomerDao customerDao;

  @MockBean
  private EntityViewDao entityViewDao;

  @Autowired
  private EntityViewDataValidator entityViewDataValidator;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)}
   */
  @Test
  public void testValidateCreateWithTenantIdEntityView() {
    // Arrange
    Optional<EntityView> ofResult = Optional.of(new EntityView());
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(ofResult);

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)}
   */
  @Test
  public void testValidateCreateWithTenantIdEntityView2() {
    // Arrange
    Optional<EntityView> emptyResult = Optional.empty();
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(emptyResult);

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    entityViewDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, entityView);

    // Assert that nothing has changed
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateCreate(TenantId, EntityView)}
   */
  @Test
  public void testValidateCreateWithTenantIdEntityView3() {
    // Arrange
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)}
   */
  @Test
  public void testValidateUpdateWithTenantIdEntityView_thenReturnNull() {
    // Arrange
    Optional<EntityView> emptyResult = Optional.empty();
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(emptyResult);

    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityView actualValidateUpdateResult = entityViewDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        entityView);

    // Assert
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
    assertNull(actualValidateUpdateResult);
  }

  /**
   * Test {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateUpdate(TenantId, EntityView)}
   */
  @Test
  public void testValidateUpdateWithTenantIdEntityView_thenThrowDataValidationException() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getUuidId()).thenReturn(ModelConstants.NULL_UUID);
    Optional<EntityView> ofResult = Optional.of(entityView);
    when(entityViewDao.findEntityViewByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(ofResult);

    EntityView entityView2 = new EntityView();
    entityView2.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, entityView2));
    verify(entityView).getUuidId();
    verify(entityViewDao).findEntityViewByTenantIdAndName(isA(UUID.class), isNull());
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEntityView() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenThrow(new DataValidationException("An error occurred"));
    when(entityView.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityView).getCustomerId();
    verify(entityView).getName();
    verify(entityView, atLeast(1)).getTenantId();
    verify(entityView).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEntityView2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    EntityView entityView = mock(EntityView.class);
    when(entityView.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityView).getName();
    verify(entityView, atLeast(1)).getTenantId();
    verify(entityView).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEntityView_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(entityView.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityView, atLeast(1)).getCustomerId();
    verify(entityView).getName();
    verify(entityView, atLeast(1)).getTenantId();
    verify(entityView).getType();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <ul>
   *   <li>Given {@link Customer#Customer()} TenantId is
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEntityView_givenCustomerTenantIdIsSystem_tenant() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Customer customer = new Customer();
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(entityView.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");

    // Act
    entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView);

    // Assert that nothing has changed
    verify(entityView, atLeast(1)).getCustomerId();
    verify(entityView).getName();
    verify(entityView, atLeast(1)).getTenantId();
    verify(entityView).getType();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEntityView_givenNull_customer_id() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityView.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");

    // Act
    entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView);

    // Assert that nothing has changed
    verify(entityView, atLeast(1)).getCustomerId();
    verify(entityView).getName();
    verify(entityView, atLeast(1)).getTenantId();
    verify(entityView).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <ul>
   *   <li>Then calls {@link EntityView#setCustomerId(CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEntityView_thenCallsSetCustomerId() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenReturn(null);
    doNothing().when(entityView).setCustomerId(Mockito.<CustomerId>any());
    when(entityView.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");

    // Act
    entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView);

    // Assert
    verify(entityView).getCustomerId();
    verify(entityView).getName();
    verify(entityView, atLeast(1)).getTenantId();
    verify(entityView).getType();
    verify(entityView).setCustomerId(isA(CustomerId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   * with {@code TenantId}, {@code EntityView}.
   * <ul>
   *   <li>When {@link EntityView} {@link EntityView#getTenantId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewDataValidator#validateDataImpl(TenantId, EntityView)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEntityView_whenEntityViewGetTenantIdReturnNull() {
    // Arrange
    EntityView entityView = mock(EntityView.class);
    when(entityView.getTenantId()).thenReturn(null);
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> entityViewDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, entityView));
    verify(entityView).getName();
    verify(entityView).getTenantId();
    verify(entityView).getType();
  }
}
