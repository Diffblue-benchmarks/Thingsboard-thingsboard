package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
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
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.asset.AssetDao;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AssetDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class AssetDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private AssetDao assetDao;

  @Autowired
  private AssetDataValidator assetDataValidator;

  @MockBean
  private CustomerDao customerDao;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link AssetDataValidator#validateCreate(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Then calls
   * {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetDataValidator#validateCreate(TenantId, Asset)}
   */
  @Test
  public void testValidateCreateWithTenantIdAsset_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any())).thenReturn(true);

    // Act
    assetDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Asset());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.ASSET));
  }

  /**
   * Test {@link AssetDataValidator#validateUpdate(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <p>
   * Method under test: {@link AssetDataValidator#validateUpdate(TenantId, Asset)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAsset() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Asset asset = mock(Asset.class);
    when(asset.getId()).thenReturn(new AssetId(ModelConstants.NULL_UUID));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, asset));
    verify(asset).getId();
    verify(asset).getTenantId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetDataValidator#validateUpdate(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Given {@link AssetDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetDataValidator#validateUpdate(TenantId, Asset)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAsset_givenAssetDaoFindByIdReturnNull() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    Asset asset = mock(Asset.class);
    when(asset.getId()).thenReturn(new AssetId(ModelConstants.NULL_UUID));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, asset));
    verify(asset).getId();
    verify(asset).getTenantId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetDataValidator#validateUpdate(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetDataValidator#validateUpdate(TenantId, Asset)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAsset_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    Asset asset2 = mock(Asset.class);
    when(asset2.getId()).thenReturn(new AssetId(ModelConstants.NULL_UUID));
    when(asset2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    Asset actualValidateUpdateResult = assetDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, asset2);

    // Assert
    verify(asset2).getId();
    verify(asset2).getTenantId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualValidateUpdateResult);
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <p>
   * Method under test:
   * {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAsset() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenThrow(new DataValidationException("An error occurred"));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(asset.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
    verify(asset).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <p>
   * Method under test:
   * {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAsset2() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(asset.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
    verify(customer).getTenantId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Given {@code Asset name}.</li>
   *   <li>When {@link Asset#Asset()} Name is {@code Asset name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAsset_givenAssetName_whenAssetNameIsAssetName() {
    // Arrange
    Asset asset = new Asset();
    asset.setName("Asset name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAsset_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(asset.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAsset_givenNull_customer_id() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(asset.getName()).thenReturn("Name");

    // Act
    assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset);

    // Assert
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link Asset#setCustomerId(CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAsset_givenNull_thenCallsSetCustomerId() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenReturn(null);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(asset.getName()).thenReturn("Name");

    // Act
    assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset);

    // Assert
    verify(asset).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset).setCustomerId(isA(CustomerId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAsset_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    Asset asset = mock(Asset.class);
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(asset.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with
   * {@code TenantId}, {@code Asset}.
   * <ul>
   *   <li>Then calls {@link Customer#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAsset_thenCallsGetTenantId() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(asset.getName()).thenReturn("Name");

    // Act
    assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset);

    // Assert
    verify(customer).getTenantId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
